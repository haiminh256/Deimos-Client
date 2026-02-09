package com.deimos.module.player;

import com.deimos.module.Category;
import com.deimos.module.Module;

public class AutoRespawn
 extends Module {
    public AutoRespawn() {
        super("AutoRespawn", "Automatically respawns you when you die.", Category.PLAYER, 0);
    }

    @Override
    public void onUpdate() {
        if (this.isToggled() && mc.player != null && mc.getNetworkHandler() != null) {
            if (mc.player.isDead()) {
                mc.player.requestRespawn();
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
