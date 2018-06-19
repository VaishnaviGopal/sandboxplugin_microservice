package com.ibm.sandbox.plugin;

public interface SandboxPlugin {

	@SuppressWarnings("unchecked")
	public <T>Object execute(T...args);
	
	@SuppressWarnings("unchecked")
	public <T>Object executeSensitiveOperation(T...args);
}
