package com.google.common.primitives;

import d.h.c.a.n;
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
            for (int i = 0; i < min; i++) {
                if (iArr[i] != iArr2[i]) {
                    return UnsignedInts.a(iArr[i], iArr2[i]);
                }
            }
            return iArr.length - iArr2.length;
        }
    }

    public static int a(int i, int i2) {
        return Ints.d(c(i), c(i2));
    }

    public static int b(int i, int i2) {
        return (int) (f(i) / f(i2));
    }

    public static int c(int i) {
        return i ^ Integer.MIN_VALUE;
    }

    public static int d(String str, int i) {
        n.p(str);
        long parseLong = Long.parseLong(str, i);
        if ((4294967295L & parseLong) == parseLong) {
            return (int) parseLong;
        }
        throw new NumberFormatException("Input " + str + " in base " + i + " is not in the range of an unsigned integer");
    }

    public static int e(int i, int i2) {
        return (int) (f(i) % f(i2));
    }

    public static long f(int i) {
        return i & 4294967295L;
    }

    public static String g(int i, int i2) {
        return Long.toString(i & 4294967295L, i2);
    }
}
