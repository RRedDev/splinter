package me.rred.splinter.client.utils;

public class ColorUtils {
    public static int pulse(int color, float speed) {
        float time = (System.currentTimeMillis() % (long)(1000 / speed)) / (1000f / speed);
        float brightness = 0.85f + 0.15f * (float) Math.sin(time * 2 * Math.PI);
        // brightness between 0.7 and 1.0

        int r = (int)(((color >> 16) & 0xFF) * brightness);
        int g = (int)(((color >> 8) & 0xFF) * brightness);
        int b = (int)((color & 0xFF) * brightness);

        return 0xFF000000 | (r << 16) | (g << 8) | b;
    }
}
