package com.google.android.exoplayer2.extractor.g;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes4.dex */
final class b {
    private long dataSize;
    private final int lWM;
    private final int lWr;
    private final int lXY;
    private final int mkI;
    private final int mkJ;
    private final int mkK;
    private long mkL;

    public b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.lXY = i;
        this.lWr = i2;
        this.mkI = i3;
        this.mkJ = i4;
        this.mkK = i5;
        this.lWM = i6;
    }

    public long drc() {
        return ((this.dataSize / this.mkJ) * TimeUtils.NANOS_PER_MS) / this.lWr;
    }

    public int dti() {
        return this.mkJ;
    }

    public int dtj() {
        return this.lWr * this.mkK * this.lXY;
    }

    public int dtk() {
        return this.lWr;
    }

    public int dtl() {
        return this.lXY;
    }

    public long fI(long j) {
        return Math.min((((this.mkI * j) / TimeUtils.NANOS_PER_MS) / this.mkJ) * this.mkJ, this.dataSize - this.mkJ) + this.mkL;
    }

    public long fK(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.mkI;
    }

    public boolean dtm() {
        return (this.mkL == 0 || this.dataSize == 0) ? false : true;
    }

    public void Q(long j, long j2) {
        this.mkL = j;
        this.dataSize = j2;
    }

    public int dtn() {
        return this.lWM;
    }
}
