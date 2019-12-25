package com.google.android.exoplayer2.util;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes4.dex */
public final class f {
    public final int channels;
    public final int mCE;
    public final int mCF;
    public final int mCG;
    public final long mCH;
    public final int maxFrameSize;
    public final int mkK;
    public final int sampleRate;

    public f(byte[] bArr, int i) {
        k kVar = new k(bArr);
        kVar.setPosition(i * 8);
        this.mCE = kVar.readBits(16);
        this.mCF = kVar.readBits(16);
        this.mCG = kVar.readBits(24);
        this.maxFrameSize = kVar.readBits(24);
        this.sampleRate = kVar.readBits(20);
        this.channels = kVar.readBits(3) + 1;
        this.mkK = kVar.readBits(5) + 1;
        this.mCH = (kVar.readBits(32) & 4294967295L) | ((kVar.readBits(4) & 15) << 32);
    }

    public int dwO() {
        return this.mkK * this.sampleRate;
    }

    public long dwP() {
        return (this.mCH * TimeUtils.NANOS_PER_MS) / this.sampleRate;
    }
}
