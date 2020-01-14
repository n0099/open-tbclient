package com.google.android.exoplayer2.util;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes5.dex */
public final class f {
    public final int channels;
    public final int mGA;
    public final int mGB;
    public final int mGC;
    public final long mGD;
    public final int maxFrameSize;
    public final int moE;
    public final int sampleRate;

    public f(byte[] bArr, int i) {
        k kVar = new k(bArr);
        kVar.setPosition(i * 8);
        this.mGA = kVar.readBits(16);
        this.mGB = kVar.readBits(16);
        this.mGC = kVar.readBits(24);
        this.maxFrameSize = kVar.readBits(24);
        this.sampleRate = kVar.readBits(20);
        this.channels = kVar.readBits(3) + 1;
        this.moE = kVar.readBits(5) + 1;
        this.mGD = (kVar.readBits(32) & 4294967295L) | ((kVar.readBits(4) & 15) << 32);
    }

    public int dya() {
        return this.moE * this.sampleRate;
    }

    public long dyb() {
        return (this.mGD * TimeUtils.NANOS_PER_MS) / this.sampleRate;
    }
}
