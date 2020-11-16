package com.googlecode.mp4parser.util;
/* loaded from: classes12.dex */
public class Math {
    public static long gcd(long j, long j2) {
        while (j2 > 0) {
            long j3 = j % j2;
            j = j2;
            j2 = j3;
        }
        return j;
    }

    public static int gcd(int i, int i2) {
        while (i2 > 0) {
            int i3 = i % i2;
            i = i2;
            i2 = i3;
        }
        return i;
    }

    public static long lcm(long j, long j2) {
        return (j2 / gcd(j, j2)) * j;
    }

    public static int lcm(int i, int i2) {
        return (i2 / gcd(i, i2)) * i;
    }
}
