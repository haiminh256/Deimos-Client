package com.deimos.module.movement;

import com.deimos.module.Category;
import com.deimos.module.Module;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class NoFall extends Module {
    public NoFall() {
        super("NoFall", "Prevents fall damage.", Category.MOVEMENT, 0);
    }

    @Override
    public void onUpdate() {
        if (this.isToggled() && mc.player != null && mc.getNetworkHandler() != null) {
            if(mc.player.fallDistance > 0.0f){
                mc.player.fallDistance = 0.0f;
                mc.getNetworkHandler().sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true));    
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
