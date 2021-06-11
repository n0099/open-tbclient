package com.google.common.primitives;

import d.g.c.a.n;
import java.math.BigInteger;
import java.util.Comparator;
/* loaded from: classes6.dex */
public final class UnsignedLongs {

    /* loaded from: classes6.dex */
    public enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                if (jArr[i2] != jArr2[i2]) {
                    return UnsignedLongs.a(jArr[i2], jArr2[i2]);
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final long[] f31469a = new long[37];

        /* renamed from: b  reason: collision with root package name */
        public static final int[] f31470b = new int[37];

        /* renamed from: c  reason: collision with root package name */
        public static final int[] f31471c = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i2 = 2; i2 <= 36; i2++) {
                long j = i2;
                f31469a[i2] = UnsignedLongs.b(-1L, j);
                f31470b[i2] = (int) UnsignedLongs.e(-1L, j);
                f31471c[i2] = bigInteger.toString(i2).length() - 1;
            }
        }

        public static boolean a(long j, int i2, int i3) {
            if (j >= 0) {
                long[] jArr = f31469a;
                if (j < jArr[i3]) {
                    return false;
                }
                return j > jArr[i3] || i2 > f31470b[i3];
            }
            return true;
        }
    }

    public static int a(long j, long j2) {
        return Longs.c(c(j), c(j2));
    }

    public static long b(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? 0L : 1L;
        } else if (j >= 0) {
            return j / j2;
        } else {
            long j3 = ((j >>> 1) / j2) << 1;
            return j3 + (a(j - (j3 * j2), j2) < 0 ? 0 : 1);
        }
    }

    public static long c(long j) {
        return j ^ Long.MIN_VALUE;
    }

    public static long d(String str, int i2) {
        n.p(str);
        if (str.length() != 0) {
            if (i2 >= 2 && i2 <= 36) {
                int i3 = a.f31471c[i2] - 1;
                long j = 0;
                for (int i4 = 0; i4 < str.length(); i4++) {
                    int digit = Character.digit(str.charAt(i4), i2);
                    if (digit != -1) {
                        if (i4 > i3 && a.a(j, digit, i2)) {
                            throw new NumberFormatException("Too large for unsigned long: " + str);
                        }
                        j = (j * i2) + digit;
                    } else {
                        throw new NumberFormatException(str);
                    }
                }
                return j;
            }
            throw new NumberFormatException("illegal radix: " + i2);
        }
        throw new NumberFormatException("empty string");
    }

    public static long e(long j, long j2) {
        if (j2 < 0) {
            return a(j, j2) < 0 ? j : j - j2;
        } else if (j >= 0) {
            return j % j2;
        } else {
            long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
            if (a(j3, j2) < 0) {
                j2 = 0;
            }
            return j3 - j2;
        }
    }

    public static String f(long j) {
        return g(j, 10);
    }

    public static String g(long j, int i2) {
        long b2;
        n.f(i2 >= 2 && i2 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i2);
        int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i3 == 0) {
            return "0";
        }
        if (i3 > 0) {
            return Long.toString(j, i2);
        }
        int i4 = 64;
        char[] cArr = new char[64];
        int i5 = i2 - 1;
        if ((i2 & i5) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i2);
            do {
                i4--;
                cArr[i4] = Character.forDigit(((int) j) & i5, i2);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            if ((i2 & 1) == 0) {
                b2 = (j >>> 1) / (i2 >>> 1);
            } else {
                b2 = b(j, i2);
            }
            long j2 = i2;
            cArr[63] = Character.forDigit((int) (j - (b2 * j2)), i2);
            i4 = 63;
            while (b2 > 0) {
                i4--;
                cArr[i4] = Character.forDigit((int) (b2 % j2), i2);
                b2 /= j2;
            }
        }
        return new String(cArr, i4, 64 - i4);
    }
}
