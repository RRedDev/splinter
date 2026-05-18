package me.rred.splinter.client.gui;

import me.rred.splinter.client.SplinterClient;
import me.rred.splinter.client.sets.SplinterSet;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.util.List;

public class SetsListPanel extends ListPanel {
    private List<SplinterSet> sets;

    public SetsListPanel(int x, int y, int width, int height, List<SplinterSet> sets) {
        super(x, y, width, height);
        this.sets = sets;
    }

    @Override
    public int getItemCount() {
        return sets.size();
    }

    @Override
    public void render(MatrixStack matrixStack, TextRenderer textRenderer, int mouseX, int mouseY) {
        SplinterSet activeSet = SplinterClient.setManager.getActiveSet();

        for (int i = 0; i < getItemCount(); i++) {
            SplinterSet set = sets.get(i);
            String setName = set.getName();

            int itemY = y + (i * LINE_HEIGHT) - scrollOffset + i;
            if (itemY + LINE_HEIGHT < y || itemY > y + height) continue; // skip off-screen lines

            boolean isActive = set == activeSet;
            boolean isHovered = (
                    mouseX >= x && mouseX <= x + width &&
                    mouseY >= itemY && mouseY <= itemY + LINE_HEIGHT
                    );

            // background color based on state
            int bgColor;
            if (isActive) {
                bgColor = 0x80447744; // green tint
            } else if (isHovered)  {
                bgColor = 0x80555555;  // lighter on hover
            }  else {
                bgColor = 0x00000000; // transparent
            }

            // draw background
            DrawableHelper.fill(matrixStack, x, itemY, x + width, itemY + LINE_HEIGHT, bgColor);

            // draw border
            int borderColor = isActive ? 0xFF88AA88 : 0x80666666;
            DrawableHelper.fill(matrixStack, x, itemY + LINE_HEIGHT, x + width, itemY + LINE_HEIGHT + 1, borderColor);

            // draw text
            int textY = itemY + (LINE_HEIGHT - textRenderer.fontHeight + 1) / 2;
            int textColor = isActive ? 0xAAFFAA : 0xFFFFFF;
            textRenderer.drawWithShadow(matrixStack, setName, x + 3, textY, 0xFFFFFF);
        }
    }
}
