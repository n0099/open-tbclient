package com.tencent.mm.algorithm;

import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class UIN extends Number {
    private int h;

    public UIN(int i) {
        this.h = 0;
        this.h = i;
    }

    public UIN(long j) {
        this.h = 0;
        this.h = (int) ((-1) & j);
    }

    public static int valueOf(String str) {
        try {
            return new UIN(Long.valueOf(str).longValue()).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return (this.h | 0) + 0.0d;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) ((this.h | 0) + 0.0d);
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.h;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.h & Util.MAX_32BIT_VALUE;
    }

    public String toString() {
        return String.valueOf(this.h & Util.MAX_32BIT_VALUE);
    }

    public int value() {
        return this.h;
    }
}
