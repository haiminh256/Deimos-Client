package com.deimos.module.ui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import com.deimos.module.Category;

import java.util.ArrayList;
import java.util.List;

public class ClickGuiScreen extends Screen {
    private final List<CategoryPanel> panels = new ArrayList<>();

    public ClickGuiScreen() {
        super(Text.literal("Click GUI"));

        int xOffset = 10;
        int y = 20;

        for (Category category : Category.values()) {
            if (category == Category.GUI) continue;
            panels.add(new CategoryPanel(category, xOffset, y));
            xOffset += 120;
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(0, 0, this.width, this.height, 0xAA000000); // translucent blacks
        for (CategoryPanel panel : panels) {
            panel.render(context, mouseX, mouseY);
        }
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (CategoryPanel panel : panels) {
            if (panel.mouseClicked(mouseX, mouseY, button)) {
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        for (CategoryPanel panel : panels) {
            panel.mouseReleased(button);
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
