package com.google.android.exoplayer2.util;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes6.dex */
public final class f {
    public final int channels;
    public final int mJd;
    public final int mJe;
    public final int mJf;
    public final long mJg;
    public final int maxFrameSize;
    public final int mrd;
    public final int sampleRate;

    public f(byte[] bArr, int i) {
        k kVar = new k(bArr);
        kVar.setPosition(i * 8);
        this.mJd = kVar.readBits(16);
        this.mJe = kVar.readBits(16);
        this.mJf = kVar.readBits(24);
        this.maxFrameSize = kVar.readBits(24);
        this.sampleRate = kVar.readBits(20);
        this.channels = kVar.readBits(3) + 1;
        this.mrd = kVar.readBits(5) + 1;
        this.mJg = (kVar.readBits(32) & 4294967295L) | ((kVar.readBits(4) & 15) << 32);
    }

    public int dzK() {
        return this.mrd * this.sampleRate;
    }

    public long dzL() {
        return (this.mJg * TimeUtils.NANOS_PER_MS) / this.sampleRate;
    }
}
