package com.deimos.module.movement;

import com.deimos.module.Category;
import com.deimos.module.Module;
import org.lwjgl.glfw.GLFW;

public class Flight extends Module{
    public Flight(){
        super("Flight","Enable flight in survival",Category.MOVEMENT,GLFW.GLFW_KEY_F);
    }
    @Override
    public void onEnable(){
        if(mc.player != null){
            mc.player.getAbilities().flying = true;
            mc.player.getAbilities().allowFlying = true;
        }
        super.onEnable();
    }
    @Override
    public void onDisable(){
        if(mc.player != null){
            mc.player.getAbilities().flying = false;
            mc.player.getAbilities().allowFlying = false;
        }
        super.onDisable();
    }
    @Override
    public void onUpdate(){
        if(this.isToggled()){
            mc.player.getAbilities().allowFlying = true;
        }
    }
    @Override
    public void setupOptions(){
        
    }
}
