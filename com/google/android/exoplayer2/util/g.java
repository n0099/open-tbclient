package com.google.android.exoplayer2.util;

import java.util.Arrays;
/* loaded from: classes6.dex */
public final class g {
    private int size;
    private long[] values;

    public g() {
        this(32);
    }

    public g(int i) {
        this.values = new long[i];
    }

    public void gG(long j) {
        if (this.size == this.values.length) {
            this.values = Arrays.copyOf(this.values, this.size * 2);
        }
        long[] jArr = this.values;
        int i = this.size;
        this.size = i + 1;
        jArr[i] = j;
    }

    public long LT(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.size);
        }
        return this.values[i];
    }

    public int size() {
        return this.size;
    }

    public long[] dzp() {
        return Arrays.copyOf(this.values, this.size);
    }
}
