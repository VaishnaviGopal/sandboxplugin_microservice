package model;

import java.util.ArrayList;

//import java.util.List;

public class model {
	
	private String pluginJarFile = "";
	private String classandPackageName = "";
//	private List<String> methods = null;
	private String filetobeexecuted = "";
	private String msgtobeprinted = "";
//	private ArrayList<String> methods = null;
	public String getpluginJarFile() {
		return pluginJarFile;
	}


	public void setpluginJarFile(String pluginJarFile) {
		this.pluginJarFile = pluginJarFile;
	}


	public String getClassandPackageName() {
		return classandPackageName;
	}


	public void setClassandPackageName(String classandPackageName) {
		this.classandPackageName = classandPackageName;
	}


	public String getfiletobeexecuted() {
		return filetobeexecuted;
	}


	public void setfiletobeexecuted(String filetobeexecuted) {
		this.filetobeexecuted = filetobeexecuted;
	}
	
	public String getmsgtobeprinted() {
		return msgtobeprinted;
	}


	public void setmsgtobeprinted(String msgtobeprinted) {
		this.msgtobeprinted = msgtobeprinted;
	}
	
//	public ArrayList<String> getMethods() {
//		return methods;
//	}
//
//
//	public void setMethods(ArrayList<String> methods) {
//		this.methods = methods;
//	}
//	


	@Override
//	public String toString() {
//		return "model [pluginJarFile=" + pluginJarFile + ", classandPackageName=" + classandPackageName
//				+ ",methods=\" + methods + \", filetobeexecuted=" + filetobeexecuted + " , msgtobeprinted=\" + msgtobeprinted" + "]";
//	}
	
	public String toString() {
		return "model [pluginJarFile=" + pluginJarFile + ", classandPackageName=" + classandPackageName
				+ ", filetobeexecuted=" + filetobeexecuted + " , msgtobeprinted=\" + msgtobeprinted" + "]";
	}



}
