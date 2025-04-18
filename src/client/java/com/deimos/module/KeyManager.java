package com.deimos.module;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.MinecraftClient;

public class KeyManager {
    
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private boolean[] keysPressed = new boolean[GLFW.GLFW_KEY_LAST];

    public void checkKeys(ModuleManager moduleManager){
        long windowHandle = mc.getWindow().getHandle();
        for(Module module : ModuleManager.getAllModules()){
            int keycode = module.getKeyCode();
            if(GLFW.glfwGetKey(windowHandle, keycode) == GLFW.GLFW_PRESS){
                if(!keysPressed[keycode]){
                    module.toggle();
                    keysPressed[keycode] = true;
                }
            }else{
                keysPressed[keycode] = false;
            }
        }
    
    }
}
