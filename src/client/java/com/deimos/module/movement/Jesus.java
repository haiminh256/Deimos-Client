package com.deimos.module.movement;

import com.deimos.module.Category;
import com.deimos.module.Module;

public class Jesus extends Module {
    public Jesus() {
        super("Jesus", "Allows walking on water.", Category.MOVEMENT, 0);
    }

    @Override
    public void onUpdate() {
        if (this.isToggled() && mc.player != null && mc.getNetworkHandler() != null) {
            if (mc.player.isInFluid()) {
                mc.player.setVelocity(mc.player.getVelocity().x, 0.1, mc.player.getVelocity().z);
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
