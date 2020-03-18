package com.google.android.exoplayer2.extractor.g;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes6.dex */
final class b {
    private long dataSize;
    private final int mcN;
    private final int mdi;
    private final int meu;
    private final int mrb;
    private final int mrc;
    private final int mrd;
    private long mre;

    public b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.meu = i;
        this.mcN = i2;
        this.mrb = i3;
        this.mrc = i4;
        this.mrd = i5;
        this.mdi = i6;
    }

    public long getDurationUs() {
        return ((this.dataSize / this.mrc) * TimeUtils.NANOS_PER_MS) / this.mcN;
    }

    public int dwg() {
        return this.mrc;
    }

    public int getBitrate() {
        return this.mcN * this.mrd * this.meu;
    }

    public int dwh() {
        return this.mcN;
    }

    public int dwi() {
        return this.meu;
    }

    public long fM(long j) {
        return Math.min((((this.mrb * j) / TimeUtils.NANOS_PER_MS) / this.mrc) * this.mrc, this.dataSize - this.mrc) + this.mre;
    }

    public long fO(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.mrb;
    }

    public boolean dwj() {
        return (this.mre == 0 || this.dataSize == 0) ? false : true;
    }

    public void P(long j, long j2) {
        this.mre = j;
        this.dataSize = j2;
    }

    public int dwk() {
        return this.mdi;
    }
}
