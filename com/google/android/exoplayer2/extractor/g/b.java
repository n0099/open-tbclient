package com.google.android.exoplayer2.extractor.g;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes5.dex */
final class b {
    private long dataSize;
    private final int maJ;
    private final int mam;
    private final int mbV;
    private final int moC;
    private final int moD;
    private final int moE;
    private long moF;

    public b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mbV = i;
        this.mam = i2;
        this.moC = i3;
        this.moD = i4;
        this.moE = i5;
        this.maJ = i6;
    }

    public long dsq() {
        return ((this.dataSize / this.moD) * TimeUtils.NANOS_PER_MS) / this.mam;
    }

    public int duv() {
        return this.moD;
    }

    public int duw() {
        return this.mam * this.moE * this.mbV;
    }

    public int dux() {
        return this.mam;
    }

    public int duy() {
        return this.mbV;
    }

    public long fN(long j) {
        return Math.min((((this.moC * j) / TimeUtils.NANOS_PER_MS) / this.moD) * this.moD, this.dataSize - this.moD) + this.moF;
    }

    public long fP(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.moC;
    }

    public boolean duz() {
        return (this.moF == 0 || this.dataSize == 0) ? false : true;
    }

    public void Q(long j, long j2) {
        this.moF = j;
        this.dataSize = j2;
    }

    public int duA() {
        return this.maJ;
    }
}
