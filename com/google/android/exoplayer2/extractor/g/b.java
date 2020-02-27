package com.google.android.exoplayer2.extractor.g;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes6.dex */
final class b {
    private long dataSize;
    private final int maU;
    private final int mbp;
    private final int mcB;
    private final int mpi;
    private final int mpj;
    private final int mpk;
    private long mpl;

    public b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mcB = i;
        this.maU = i2;
        this.mpi = i3;
        this.mpj = i4;
        this.mpk = i5;
        this.mbp = i6;
    }

    public long getDurationUs() {
        return ((this.dataSize / this.mpj) * TimeUtils.NANOS_PER_MS) / this.maU;
    }

    public int dvG() {
        return this.mpj;
    }

    public int getBitrate() {
        return this.maU * this.mpk * this.mcB;
    }

    public int dvH() {
        return this.maU;
    }

    public int dvI() {
        return this.mcB;
    }

    public long fL(long j) {
        return Math.min((((this.mpi * j) / TimeUtils.NANOS_PER_MS) / this.mpj) * this.mpj, this.dataSize - this.mpj) + this.mpl;
    }

    public long fN(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.mpi;
    }

    public boolean dvJ() {
        return (this.mpl == 0 || this.dataSize == 0) ? false : true;
    }

    public void P(long j, long j2) {
        this.mpl = j;
        this.dataSize = j2;
    }

    public int dvK() {
        return this.mbp;
    }
}
