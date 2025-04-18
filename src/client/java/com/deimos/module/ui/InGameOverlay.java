package com.deimos.module.ui;

import java.util.List;

import com.deimos.client.DeimosClient;
import com.deimos.module.util.RainbowUtil;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class InGameOverlay {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    public InGameOverlay(){}

    public void render(DrawContext drawContext){
        if(mc.player != null){
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();

            String clientName = "Deimos | ";
            drawContext.drawText(mc.textRenderer, clientName, 10, 5, 0xFFFFFF,false);
            
            int fps = mc.getCurrentFps();
            String fpsText = "FPS " + fps;
            int clientNameWidth = mc.textRenderer.getWidth(clientName);

            drawContext.drawText(mc.textRenderer, fpsText, 10 + clientNameWidth,5 , 0xFFFFFF,false);
            int fpsTexWidth = mc.textRenderer.getWidth(fpsText);

            int totalWidth = clientNameWidth + fpsTexWidth + 5;
            int totalHeight = mc.textRenderer.fontHeight;
            renderEnableMods(drawContext);
            RenderSystem.disableBlend();
        }
    }
    private void renderEnableMods(DrawContext drawContext){
        List<com.deimos.module.Module> enabledMods = DeimosClient.instance.modManager.getEnabledModules();
        int screenWidth = mc.getWindow().getScaledWidth();
        int yOffset = 5;
        for(int i = 0; i < enabledMods.size(); i++){
            com.deimos.module.Module mod = enabledMods.get(i);
            String modName = mod.getName();

            int modNameWidth = mc.textRenderer.getWidth(modName);
            int rainbowColor = RainbowUtil.getRainbowColor(i * 0.1f);

            drawContext.drawText(mc.textRenderer, "- " + modName, screenWidth - modNameWidth - 15,yOffset, rainbowColor,false);
            yOffset += mc.textRenderer.fontHeight + 2;
        }
    }
}
