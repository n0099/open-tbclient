package com.ksad.lottie.d;
/* loaded from: classes4.dex */
public class b {
    private static float a(float f) {
        return f <= 0.0031308f ? 12.92f * f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int a(float f, int i, int i2) {
        float f2 = ((i >> 24) & 255) / 255.0f;
        float b2 = b(((i >> 16) & 255) / 255.0f);
        float b3 = b(((i >> 8) & 255) / 255.0f);
        float b4 = b((i & 255) / 255.0f);
        float b5 = b(((i2 >> 16) & 255) / 255.0f);
        return (Math.round((f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f)) * 255.0f) << 24) | (Math.round(a(b2 + ((b5 - b2) * f)) * 255.0f) << 16) | (Math.round(a(b3 + ((b(((i2 >> 8) & 255) / 255.0f) - b3) * f)) * 255.0f) << 8) | Math.round(a(b4 + ((b((i2 & 255) / 255.0f) - b4) * f)) * 255.0f);
    }

    private static float b(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((0.055f + f) / 1.055f, 2.4000000953674316d);
    }
}
