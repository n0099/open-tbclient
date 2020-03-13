package com.google.android.exoplayer2.util;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes6.dex */
public final class f {
    public final int channels;
    public final int mHt;
    public final int mHu;
    public final int mHv;
    public final long mHw;
    public final int maxFrameSize;
    public final int mpx;
    public final int sampleRate;

    public f(byte[] bArr, int i) {
        k kVar = new k(bArr);
        kVar.setPosition(i * 8);
        this.mHt = kVar.readBits(16);
        this.mHu = kVar.readBits(16);
        this.mHv = kVar.readBits(24);
        this.maxFrameSize = kVar.readBits(24);
        this.sampleRate = kVar.readBits(20);
        this.channels = kVar.readBits(3) + 1;
        this.mpx = kVar.readBits(5) + 1;
        this.mHw = (kVar.readBits(32) & 4294967295L) | ((kVar.readBits(4) & 15) << 32);
    }

    public int dzn() {
        return this.mpx * this.sampleRate;
    }

    public long dzo() {
        return (this.mHw * TimeUtils.NANOS_PER_MS) / this.sampleRate;
    }
}
