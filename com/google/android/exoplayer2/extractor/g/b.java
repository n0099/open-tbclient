package com.google.android.exoplayer2.extractor.g;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes6.dex */
final class b {
    private long dataSize;
    private final int mbC;
    private final int mbh;
    private final int mcO;
    private final int mpv;
    private final int mpw;
    private final int mpx;
    private long mpy;

    public b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mcO = i;
        this.mbh = i2;
        this.mpv = i3;
        this.mpw = i4;
        this.mpx = i5;
        this.mbC = i6;
    }

    public long getDurationUs() {
        return ((this.dataSize / this.mpw) * TimeUtils.NANOS_PER_MS) / this.mbh;
    }

    public int dvJ() {
        return this.mpw;
    }

    public int getBitrate() {
        return this.mbh * this.mpx * this.mcO;
    }

    public int dvK() {
        return this.mbh;
    }

    public int dvL() {
        return this.mcO;
    }

    public long fL(long j) {
        return Math.min((((this.mpv * j) / TimeUtils.NANOS_PER_MS) / this.mpw) * this.mpw, this.dataSize - this.mpw) + this.mpy;
    }

    public long fN(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.mpv;
    }

    public boolean dvM() {
        return (this.mpy == 0 || this.dataSize == 0) ? false : true;
    }

    public void P(long j, long j2) {
        this.mpy = j;
        this.dataSize = j2;
    }

    public int dvN() {
        return this.mbC;
    }
}
