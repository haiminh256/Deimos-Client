package com.deimos.module.movement;

import com.deimos.module.Category;
import com.deimos.module.Module;
import org.lwjgl.glfw.GLFW;

public class AutoSprint extends Module {
    public AutoSprint() {
        super("AutoSprint", "Automatically sprints.", Category.MOVEMENT, GLFW.GLFW_KEY_LEFT_CONTROL);
    }

    @Override
    public void onUpdate() {
        if (this.isToggled() && mc.player != null && mc.getNetworkHandler() != null) {
            mc.player.setSprinting(true);
        }
    }

    @Override
    public void onEnable() {
        if(mc.player != null) {
            mc.player.setSprinting(true);
        }
        super.onEnable();
    }

    @Override
    public void onDisable() {
        if(mc.player != null) {
            mc.player.setSprinting(false);
        }
        super.onDisable();
    }

    @Override
    public void setupOptions() {

    }
}
