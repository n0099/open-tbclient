package com.google.android.exoplayer2.extractor.g;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes5.dex */
final class b {
    private long dataSize;
    private final int maE;
    private final int mah;
    private final int mbQ;
    private long moA;
    private final int mox;
    private final int moy;
    private final int moz;

    public b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mbQ = i;
        this.mah = i2;
        this.mox = i3;
        this.moy = i4;
        this.moz = i5;
        this.maE = i6;
    }

    public long dso() {
        return ((this.dataSize / this.moy) * TimeUtils.NANOS_PER_MS) / this.mah;
    }

    public int dut() {
        return this.moy;
    }

    public int duu() {
        return this.mah * this.moz * this.mbQ;
    }

    public int duv() {
        return this.mah;
    }

    public int duw() {
        return this.mbQ;
    }

    public long fN(long j) {
        return Math.min((((this.mox * j) / TimeUtils.NANOS_PER_MS) / this.moy) * this.moy, this.dataSize - this.moy) + this.moA;
    }

    public long fP(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.mox;
    }

    public boolean dux() {
        return (this.moA == 0 || this.dataSize == 0) ? false : true;
    }

    public void Q(long j, long j2) {
        this.moA = j;
        this.dataSize = j2;
    }

    public int duy() {
        return this.maE;
    }
}
