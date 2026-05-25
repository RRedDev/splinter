package me.rred.splinter.client.timer;

import me.rred.splinter.Splinter;
import me.rred.splinter.client.SplinterClient;
import me.rred.splinter.client.utils.TimerFormatter;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;

import java.awt.*;

public class TimerHud {

    public static void render(MatrixStack matrixStack, TextRenderer textRenderer) {
        if (!(SplinterClient.timer.isRunning() || SplinterClient.timer.isStopped())) {
            return;
        }

        MinecraftClient client = MinecraftClient.getInstance();
        float scaledHeight = client.getWindow().getScaledHeight();
        float y = scaledHeight / 2;

        int color = SplinterClient.timer.isStopped() ? 0xFFD700 : 0xFFFFFF;

        String time =  TimerFormatter.format(SplinterClient.timer.fetchElapsedTime());
        textRenderer.drawWithShadow(matrixStack, new LiteralText(time), 10, y, color);
    }
}
