package com.ksad.lottie.d;
/* loaded from: classes6.dex */
public class b {
    public static float a(float f2) {
        return f2 <= 0.0031308f ? f2 * 12.92f : (float) ((Math.pow(f2, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int a(float f2, int i2, int i3) {
        float f3 = ((i2 >> 24) & 255) / 255.0f;
        float b2 = b(((i2 >> 16) & 255) / 255.0f);
        float b3 = b(((i2 >> 8) & 255) / 255.0f);
        float b4 = b((i2 & 255) / 255.0f);
        float b5 = b(((i3 >> 16) & 255) / 255.0f);
        float b6 = b(((i3 >> 8) & 255) / 255.0f);
        float b7 = b4 + (f2 * (b((i3 & 255) / 255.0f) - b4));
        return (Math.round(a(b2 + ((b5 - b2) * f2)) * 255.0f) << 16) | (Math.round((f3 + (((((i3 >> 24) & 255) / 255.0f) - f3) * f2)) * 255.0f) << 24) | (Math.round(a(b3 + ((b6 - b3) * f2)) * 255.0f) << 8) | Math.round(a(b7) * 255.0f);
    }

    public static float b(float f2) {
        return f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d);
    }
}
