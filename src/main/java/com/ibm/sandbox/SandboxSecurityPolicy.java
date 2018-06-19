package com.ibm.sandbox;

import java.io.FilePermission;

import java.net.SocketPermission;
import java.security.AllPermission;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.Policy;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.PropertyPermission;

import com.ibm.sandbox.loader.PluginClassLoader;

public class SandboxSecurityPolicy extends Policy {
    
    @Override
    public PermissionCollection getPermissions(ProtectionDomain domain) {
//        if (isPlugin(domain)) {
//            return pluginPermissions();
//        }
//        else {
            return applicationPermissions();
//        }        
    }

    private boolean isPlugin(ProtectionDomain domain) {
        return domain.getClassLoader() instanceof PluginClassLoader;
    }
                 
    public ArrayList<Permission> pluginPermissions() {
//        Permissions permissions = new Permissions(); // No permissions
    	ArrayList<Permission> permissions = new ArrayList<Permission>();
        permissions.add(new FilePermission("C:\\content.txt", "read"));
//         Permission = new java.io.FilePermission);
//        permissions.add(new FilePermission("C:\\content.txt", "write"));
//        permissions.add(new PropertyPermission("user.dir","read"));
        permissions.add(new PropertyPermission("line.separator","read"));
//        permissions.add(new PropertyPermission("line.separator","write"));
//        permissions.add(new RuntimePermission("createClassLoader,setSecurityManager"));
//        permissions.add(new RuntimePermission("createClassLoader,getClassLoader"));
//        permissions.add(new SocketPermission("127.0.0.1:6666", "accept"));
//        permissions.add(new SocketPermission("127.0.0.1:6666", "connect"));
//        permissions.add(new SocketPermission("127.0.0.1:6666", "listen"));
//        permissions.add(new SocketPermission("127.0.0.1:6666", "resolve"));
////        permissions.add(new SocketPermission("127.0.0.1:6666", "close"));
        return permissions;
    }

    private PermissionCollection applicationPermissions() {
        Permissions permissions = new Permissions();
        permissions.add(new AllPermission());
        return permissions;
    }
}
