package com.google.android.exoplayer2.extractor.g;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes6.dex */
final class b {
    private long dataSize;
    private final int maW;
    private final int mbr;
    private final int mcD;
    private final int mpk;
    private final int mpl;
    private final int mpm;
    private long mpn;

    public b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mcD = i;
        this.maW = i2;
        this.mpk = i3;
        this.mpl = i4;
        this.mpm = i5;
        this.mbr = i6;
    }

    public long getDurationUs() {
        return ((this.dataSize / this.mpl) * TimeUtils.NANOS_PER_MS) / this.maW;
    }

    public int dvI() {
        return this.mpl;
    }

    public int getBitrate() {
        return this.maW * this.mpm * this.mcD;
    }

    public int dvJ() {
        return this.maW;
    }

    public int dvK() {
        return this.mcD;
    }

    public long fL(long j) {
        return Math.min((((this.mpk * j) / TimeUtils.NANOS_PER_MS) / this.mpl) * this.mpl, this.dataSize - this.mpl) + this.mpn;
    }

    public long fN(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.mpk;
    }

    public boolean dvL() {
        return (this.mpn == 0 || this.dataSize == 0) ? false : true;
    }

    public void P(long j, long j2) {
        this.mpn = j;
        this.dataSize = j2;
    }

    public int dvM() {
        return this.mbr;
    }
}
