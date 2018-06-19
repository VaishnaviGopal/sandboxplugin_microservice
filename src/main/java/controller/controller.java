package controller;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.Permission;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.sandbox.SandboxSecurityManager;
import com.ibm.sandbox.SandboxSecurityPolicy;
import com.ibm.sandbox.loader.PluginClassLoader;
import com.ibm.sandbox.plugin.SandboxPlugin;

import model.ReturnModel;
import model.model;

@RestController
@RequestMapping("/executePlugin")
public class controller{

	@RequestMapping(method=RequestMethod.POST,consumes="application/json",path="/execute",produces="application/json")
	public ReturnModel executeDynamicMethod(@RequestBody model args) throws Exception
	{
		String result ="";
		String result1 ="";
//		String result2 ="";

		String pluginJarFile="";
		String classandPackageName="";
		String filetobeexecuted="";
		String message="";
		ArrayList<String> methods= null;



//		Policy.setPolicy(new SandboxSecurityPolicy());
		ArrayList<Permission> permissions = new SandboxSecurityPolicy().pluginPermissions();
		pluginJarFile = args.getpluginJarFile().toString();
		classandPackageName = args.getClassandPackageName().toString();
		filetobeexecuted = args.getfiletobeexecuted().toString();
	    message = args.getmsgtobeprinted().toString();

		File file = new File(pluginJarFile);
        URL url = file.toURI().toURL();
		ClassLoader pluginLoader = new PluginClassLoader(url);
		Class<?> pluginClass = pluginLoader.loadClass(classandPackageName);		
		SandboxPlugin plugin = (SandboxPlugin) pluginClass.newInstance();
		
//		System.setSecurityManager(new SandboxSecurityManager(permissions));

		SecurityManager currentSecManager = System.getSecurityManager();
		
//		System.out.println(plugin.execute());		
//		System.out.println(plugin.executeSensitiveOperation(filetobeexecuted));
//		System.out.println(plugin.executeSensitiveOperation(message));
//		result = plugin.executeSensitiveOperation(filetobeexecuted).toString();
//		result = plugin.executeSensitiveOperation(message,pluginJarFile).toString();
//		result = plugin.executeSensitiveOperation().toString();

		ReturnModel retModel = new ReturnModel();
		try {
			System.setSecurityManager(new SandboxSecurityManager(permissions));
//			result = plugin.execute(args).toString();
			System.out.println("called MyPlugin from try");
			result1 = plugin.executeSensitiveOperation(filetobeexecuted).toString();
			System.out.println("called MyPlugin from try2");
			System.out.println(result1);
			retModel.setAttr1(result);
			retModel.setAttr2(result1);
			}
			catch(Throwable exp) {

			result = exp.getMessage();
			System.out.println(result);
			result1 = exp.getMessage();
			System.out.println(result1);
			retModel.setAttr1(result);
			retModel.setAttr2(result1);
			}
			finally {
			System.setSecurityManager(currentSecManager);
			}

		retModel.setAttr1(result);
//		retModel.setAttr2(result2);
		return retModel;

//		return result;
	}

}
