package com.googlecode.mp4parser.h264;

import java.nio.ShortBuffer;
/* loaded from: classes6.dex */
public class Debug {
    public static final boolean debug = false;

    public static void print(int i2) {
    }

    public static void print(String str) {
    }

    public static void print(short[] sArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            for (int i4 = 0; i4 < 8; i4++) {
                System.out.printf("%3d, ", Short.valueOf(sArr[i2]));
                i2++;
            }
            System.out.println();
        }
    }

    public static final void print8x8(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            for (int i4 = 0; i4 < 8; i4++) {
                System.out.printf("%3d, ", Integer.valueOf(iArr[i2]));
                i2++;
            }
            System.out.println();
        }
    }

    public static void println(String str) {
    }

    public static void trace(String str, Object... objArr) {
    }

    public static final void print8x8(short[] sArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            for (int i4 = 0; i4 < 8; i4++) {
                System.out.printf("%3d, ", Short.valueOf(sArr[i2]));
                i2++;
            }
            System.out.println();
        }
    }

    public static final void print8x8(ShortBuffer shortBuffer) {
        for (int i2 = 0; i2 < 8; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                System.out.printf("%3d, ", Short.valueOf(shortBuffer.get()));
            }
            System.out.println();
        }
    }
}
