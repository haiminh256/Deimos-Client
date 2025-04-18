import com.deimos.module.Category;
import com.deimos.module.Module;
import com.deimos.module.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import com.deimos.module.ui.ModuleButton;

import java.util.ArrayList;
import java.util.List;

public class CategoryPanel {
    private int x, y, width = 110, height = 20;
    private final Category category;
    private final List<ModuleButton> buttons = new ArrayList<>();
    private boolean dragging = false;
    private int dragX, dragY;

    public CategoryPanel(Category category, int x, int y) {
        this.category = category;
        this.x = x;
        this.y = y;

        int yOffset = y + height;
        for (Module module : ModuleManager.getModulesByCategory(category)) {
            buttons.add(new ModuleButton(module, x + 5, yOffset));
            yOffset += 20;
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        if (dragging) {
            x = mouseX - dragX;
            y = mouseY - dragY;
        }

        // Draw panel header
        context.fill(x, y, x + width, y + height, 0xFF333333);
        context.drawText(MinecraftClient.getInstance().textRenderer, category.name(), x + 5, y + 6, 0xFFFFFF, false);

        // Update module button positions
        int yOffset = y + height;
        for (ModuleButton button : buttons) {
            button.setPosition(x + 5, yOffset);
            button.render(context, mouseX, mouseY);
            yOffset += 20;
        }
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (isMouseOver(mouseX, mouseY)) {
            if (button == 0) {
                dragging = true;
                dragX = (int) mouseX - x;
                dragY = (int) mouseY - y;
                return true;
            }
        }
        for (ModuleButton btn : buttons) {
            if (btn.mouseClicked(mouseX, mouseY, button)) return true;
        }
        return false;
    }

    public void mouseReleased(int button) {
        if (button == 0) dragging = false;
    }

    private boolean isMouseOver(double mouseX, double mouseY) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }
}
