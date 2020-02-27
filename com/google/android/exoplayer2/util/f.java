package com.google.android.exoplayer2.util;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes6.dex */
public final class f {
    public final int channels;
    public final int mHg;
    public final int mHh;
    public final int mHi;
    public final long mHj;
    public final int maxFrameSize;
    public final int mpk;
    public final int sampleRate;

    public f(byte[] bArr, int i) {
        k kVar = new k(bArr);
        kVar.setPosition(i * 8);
        this.mHg = kVar.readBits(16);
        this.mHh = kVar.readBits(16);
        this.mHi = kVar.readBits(24);
        this.maxFrameSize = kVar.readBits(24);
        this.sampleRate = kVar.readBits(20);
        this.channels = kVar.readBits(3) + 1;
        this.mpk = kVar.readBits(5) + 1;
        this.mHj = (kVar.readBits(32) & 4294967295L) | ((kVar.readBits(4) & 15) << 32);
    }

    public int dzk() {
        return this.mpk * this.sampleRate;
    }

    public long dzl() {
        return (this.mHj * TimeUtils.NANOS_PER_MS) / this.sampleRate;
    }
}
