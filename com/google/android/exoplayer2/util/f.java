package com.google.android.exoplayer2.util;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes6.dex */
public final class f {
    public final int channels;
    public final int mHi;
    public final int mHj;
    public final int mHk;
    public final long mHl;
    public final int maxFrameSize;
    public final int mpm;
    public final int sampleRate;

    public f(byte[] bArr, int i) {
        k kVar = new k(bArr);
        kVar.setPosition(i * 8);
        this.mHi = kVar.readBits(16);
        this.mHj = kVar.readBits(16);
        this.mHk = kVar.readBits(24);
        this.maxFrameSize = kVar.readBits(24);
        this.sampleRate = kVar.readBits(20);
        this.channels = kVar.readBits(3) + 1;
        this.mpm = kVar.readBits(5) + 1;
        this.mHl = (kVar.readBits(32) & 4294967295L) | ((kVar.readBits(4) & 15) << 32);
    }

    public int dzm() {
        return this.mpm * this.sampleRate;
    }

    public long dzn() {
        return (this.mHl * TimeUtils.NANOS_PER_MS) / this.sampleRate;
    }
}
