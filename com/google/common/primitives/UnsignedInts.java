package com.google.common.primitives;

import d.g.c.a.n;
import java.util.Comparator;
/* loaded from: classes6.dex */
public final class UnsignedInts {

    /* loaded from: classes6.dex */
    public enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                if (iArr[i2] != iArr2[i2]) {
                    return UnsignedInts.a(iArr[i2], iArr2[i2]);
                }
            }
            return iArr.length - iArr2.length;
        }
    }

    public static int a(int i2, int i3) {
        return Ints.d(c(i2), c(i3));
    }

    public static int b(int i2, int i3) {
        return (int) (f(i2) / f(i3));
    }

    public static int c(int i2) {
        return i2 ^ Integer.MIN_VALUE;
    }

    public static int d(String str, int i2) {
        n.p(str);
        long parseLong = Long.parseLong(str, i2);
        if ((4294967295L & parseLong) == parseLong) {
            return (int) parseLong;
        }
        throw new NumberFormatException("Input " + str + " in base " + i2 + " is not in the range of an unsigned integer");
    }

    public static int e(int i2, int i3) {
        return (int) (f(i2) % f(i3));
    }

    public static long f(int i2) {
        return i2 & 4294967295L;
    }

    public static String g(int i2, int i3) {
        return Long.toString(i2 & 4294967295L, i3);
    }
}
