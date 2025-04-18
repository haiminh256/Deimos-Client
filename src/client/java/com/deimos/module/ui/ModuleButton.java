package com.deimos.module.ui;

import com.deimos.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class ModuleButton {
    private final Module module;
    private int x, y, width = 100, height = 18;

    public ModuleButton(Module module, int x, int y) {
        this.module = module;
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        int bgColor = module.isToggled() ? 0xFF00AA00 : 0xFF555555;
        context.fill(x, y, x + width, y + height, bgColor);
        context.drawText(MinecraftClient.getInstance().textRenderer, module.getName(), x + 4, y + 5, 0xFFFFFF, false);
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
            if (button == 0) {
                module.toggle();
                return true;
            }
        }
        return false;
    }
}
