package com.deimos.module.gui;

import com.deimos.module.Category;
import com.deimos.module.Module;
import com.deimos.module.ui.ClickGuiScreen;
import net.minecraft.client.MinecraftClient;

public class ClickGui extends Module {
    private final MinecraftClient mc = MinecraftClient.getInstance();

    public ClickGui() {
        super("ClickGui", "Open the click GUI", Category.GUI, org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT_SHIFT);
    }

    @Override
    public void onEnable() {
        mc.setScreen(new ClickGuiScreen());
        this.setToggled(false); // Auto-disable after opening
    }

    @Override
    public void setupOptions() {
        // Add checkboxes or settings here later if you want
    }
}
