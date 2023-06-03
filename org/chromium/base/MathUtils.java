package org.chromium.base;
/* loaded from: classes2.dex */
public class MathUtils {
    public static final float EPSILON = 0.001f;

    public static float clamp(float f, float f2, float f3) {
        int i = (f2 > f3 ? 1 : (f2 == f3 ? 0 : -1));
        float f4 = i > 0 ? f3 : f2;
        if (i <= 0) {
            f2 = f3;
        }
        return f < f4 ? f4 : f > f2 ? f2 : f;
    }

    public static int clamp(int i, int i2, int i3) {
        int i4 = i2 > i3 ? i3 : i2;
        if (i2 <= i3) {
            i2 = i3;
        }
        return i < i4 ? i4 : i > i2 ? i2 : i;
    }

    public static long clamp(long j, long j2, long j3) {
        int i = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        long j4 = i > 0 ? j3 : j2;
        if (i <= 0) {
            j2 = j3;
        }
        return j < j4 ? j4 : j > j2 ? j2 : j;
    }

    public static int compareLongs(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    public static float flipSignIf(float f, boolean z) {
        return z ? -f : f;
    }

    public static int flipSignIf(int i, boolean z) {
        return z ? -i : i;
    }

    public static float interpolate(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    public static float map(float f, float f2, float f3, float f4, float f5) {
        return f4 + ((f5 - f4) * ((f - f2) / (f3 - f2)));
    }

    public static float smoothstep(float f) {
        return f * f * (3.0f - (f * 2.0f));
    }

    public static boolean areFloatsEqual(float f, float f2) {
        if (Math.abs(f - f2) < 0.001f) {
            return true;
        }
        return false;
    }

    public static int positiveModulo(int i, int i2) {
        int i3 = i % i2;
        if (i3 < 0) {
            return i3 + i2;
        }
        return i3;
    }

    public static float distance(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    public static float scaleToFitTargetSize(int[] iArr, int i, int i2) {
        if (iArr.length >= 2 && iArr[0] > 0 && iArr[1] > 0) {
            float max = Math.max(i / iArr[0], i2 / iArr[1]);
            iArr[0] = (int) (iArr[0] * max);
            iArr[1] = (int) (iArr[1] * max);
            return max;
        }
        throw new IllegalArgumentException("Expected dimensions to have length >= 2 && dimensions[0] > 0 && dimensions[1] > 0");
    }
}
