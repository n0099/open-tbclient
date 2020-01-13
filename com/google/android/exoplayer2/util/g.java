package com.google.android.exoplayer2.util;

import java.util.Arrays;
/* loaded from: classes5.dex */
public final class g {
    private long[] mGz;
    private int size;

    public g() {
        this(32);
    }

    public g(int i) {
        this.mGz = new long[i];
    }

    public void gI(long j) {
        if (this.size == this.mGz.length) {
            this.mGz = Arrays.copyOf(this.mGz, this.size * 2);
        }
        long[] jArr = this.mGz;
        int i = this.size;
        this.size = i + 1;
        jArr[i] = j;
    }

    public long LO(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.size);
        }
        return this.mGz[i];
    }

    public int size() {
        return this.size;
    }

    public long[] dya() {
        return Arrays.copyOf(this.mGz, this.size);
    }
}
