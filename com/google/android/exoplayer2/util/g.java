package com.google.android.exoplayer2.util;

import java.util.Arrays;
/* loaded from: classes4.dex */
public final class g {
    private long[] mCI;
    private int size;

    public g() {
        this(32);
    }

    public g(int i) {
        this.mCI = new long[i];
    }

    public void gD(long j) {
        if (this.size == this.mCI.length) {
            this.mCI = Arrays.copyOf(this.mCI, this.size * 2);
        }
        long[] jArr = this.mCI;
        int i = this.size;
        this.size = i + 1;
        jArr[i] = j;
    }

    public long LF(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.size);
        }
        return this.mCI[i];
    }

    public int size() {
        return this.size;
    }

    public long[] dwQ() {
        return Arrays.copyOf(this.mCI, this.size);
    }
}
