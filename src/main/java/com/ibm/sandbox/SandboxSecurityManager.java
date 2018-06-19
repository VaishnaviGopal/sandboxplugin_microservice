package com.ibm.sandbox;

import java.io.FilePermission;
//import java.net.SocketPermission;
import java.security.Permission;
//import java.security.PermissionCollection;
import java.util.ArrayList;
//import java.util.Enumeration;
import java.util.PropertyPermission;

public class SandboxSecurityManager extends SecurityManager{

	ArrayList<Permission> permissions = null;

	public SandboxSecurityManager(ArrayList<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public void checkPermission(Permission perm){
		System.out.println("====>"+perm);

		//Enumeration<Permission> elements = sandboxSecurityPolicy.pluginPermissions().elements();
		 ArrayList<Permission> pluginPermissions = permissions;
		 for (Permission permission : pluginPermissions) {
			
			 
			boolean t = true; 
			while(t) { if(permission instanceof FilePermission && perm instanceof FilePermission) {
//				t = true;
				FilePermission filePerm = (FilePermission)permission;
				boolean implies = filePerm.implies(perm);
				System.out.println("====>"+perm+" implies "+implies);
				if(implies) {
					return;
				}
//				else	throw new SecurityException("FilePermission Access denied !!!");
					
				}
		
			
				if(permission instanceof PropertyPermission && perm instanceof PropertyPermission) {
//				t = true;
				PropertyPermission propPerm = (PropertyPermission)permission;
				boolean implies = propPerm.implies(perm);
				System.out.println("====>"+perm+" implies "+implies);
				if(implies) {
					return;
				}
//				else	throw new SecurityException("PropertyPermission Access denied !!!");
					
				}
			t = false;	
			System.out.println(t);
//			if (t == false)throw new SecurityException("Permissions Access denied !!!");
			}
//			throw new SecurityException("Permissions Access denied !!!");}
//			
//			else {
//				throw new SecurityException("Permissions Access denied !!!"); 
//			}
				
//			if
//			else {
//				throw new SecurityException("Permissions Access denied !!!"); 
//			}
			
			
//			 if(permission instanceof SocketPermission && perm instanceof SocketPermission) {
//					SocketPermission socPerm = (SocketPermission)permission;
//					boolean implies = socPerm.implies(perm);
//					System.out.println("====>"+perm+" implies "+implies);
//					if(implies) {
//						return;
//					}
//					
//			}
//			 else {
//					throw new SecurityException("Permissions Access denied !!!"); 
//				}
//					
//			if(permission instanceof RuntimePermission && perm instanceof RuntimePermission) {
//			
//				 RuntimePermission runPerm = (RuntimePermission)permission;
//					boolean implies = runPerm.implies(perm);
//					System.out.println("====>"+perm+" implies "+implies);
//					if(implies) {
//						return;
//					}
//					throw new SecurityException("RuntimePermission Access denied !!!");
//			}
		
			
//			else {
//				throw new SecurityException("Permissions Access denied !!!"); 
//			}
		}
		 
		
	}



}