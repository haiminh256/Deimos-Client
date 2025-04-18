package com.deimos.client;

import com.deimos.module.ModuleManager;
import com.deimos.module.KeyManager;
import com.deimos.module.ui.InGameOverlay;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.DrawContext;

import java.util.logging.Logger;

public class DeimosClient implements ClientModInitializer {

    public static DeimosClient instance = new DeimosClient();

    public static ModuleManager modManager;
    public static KeyManager keyManager;
    public static InGameOverlay ingameoverlay;

    private static final Logger LOGGER = Logger.getLogger("Deimos");

    @Override
    public void onInitializeClient() {
        startClient();
    }

    public void startClient() {
        LOGGER.info("Deimos Loaded");

        modManager = new ModuleManager();
        keyManager = new KeyManager();
        ingameoverlay = new InGameOverlay();

        // Handle ticking
        net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents.END_CLIENT_TICK.register(client -> {
            instance.onTick();
        });

        // Handle rendering
        net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            instance.onRender(drawContext);
        });
    }

    public void onTick() {
        modManager.onTick(keyManager); // this uses your KeyManager to toggle modules
    }

    public void onRender(DrawContext drawContext) {
        ingameoverlay.render(drawContext); // draws FPS + active mods
    }
}
