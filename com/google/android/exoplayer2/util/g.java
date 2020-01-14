package com.google.android.exoplayer2.util;

import java.util.Arrays;
/* loaded from: classes5.dex */
public final class g {
    private long[] mGE;
    private int size;

    public g() {
        this(32);
    }

    public g(int i) {
        this.mGE = new long[i];
    }

    public void gI(long j) {
        if (this.size == this.mGE.length) {
            this.mGE = Arrays.copyOf(this.mGE, this.size * 2);
        }
        long[] jArr = this.mGE;
        int i = this.size;
        this.size = i + 1;
        jArr[i] = j;
    }

    public long LO(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.size);
        }
        return this.mGE[i];
    }

    public int size() {
        return this.size;
    }

    public long[] dyc() {
        return Arrays.copyOf(this.mGE, this.size);
    }
}
