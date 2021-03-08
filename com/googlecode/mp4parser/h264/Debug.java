package com.googlecode.mp4parser.h264;

import java.nio.ShortBuffer;
/* loaded from: classes5.dex */
public class Debug {
    public static final boolean debug = false;

    public static final void print8x8(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                System.out.printf("%3d, ", Integer.valueOf(iArr[i]));
                i++;
            }
            System.out.println();
        }
    }

    public static final void print8x8(short[] sArr) {
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                System.out.printf("%3d, ", Short.valueOf(sArr[i]));
                i++;
            }
            System.out.println();
        }
    }

    public static final void print8x8(ShortBuffer shortBuffer) {
        for (int i = 0; i < 8; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                System.out.printf("%3d, ", Short.valueOf(shortBuffer.get()));
            }
            System.out.println();
        }
    }

    public static void print(short[] sArr) {
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                System.out.printf("%3d, ", Short.valueOf(sArr[i]));
                i++;
            }
            System.out.println();
        }
    }

    public static void trace(String str, Object... objArr) {
    }

    public static void print(int i) {
    }

    public static void print(String str) {
    }

    public static void println(String str) {
    }
}
