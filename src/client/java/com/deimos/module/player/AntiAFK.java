package com.deimos.module.player;

import com.deimos.module.Category;
import com.deimos.module.Module;

public class AntiAFK extends Module {
    public AntiAFK() {
        super("AntiAFK", "Prevents AFK kick by spoofing onGround.", Category.PLAYER, 0);
    }

    private boolean movingForward = true;
    @Override
    public void onUpdate() {
        if(this.isToggled() && mc.player != null && mc.getNetworkHandler() != null) {
            if(movingForward){
                mc.player.input.movementForward = 1.0f;
            }else {
                mc.player.input.movementForward = -1.0f;
            }
            
        }
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void setupOptions() {

    }
}
