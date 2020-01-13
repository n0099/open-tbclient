package com.google.android.exoplayer2.util;

import com.baidu.searchbox.v8engine.util.TimeUtils;
/* loaded from: classes5.dex */
public final class f {
    public final int channels;
    public final int mGv;
    public final int mGw;
    public final int mGx;
    public final long mGy;
    public final int maxFrameSize;
    public final int moz;
    public final int sampleRate;

    public f(byte[] bArr, int i) {
        k kVar = new k(bArr);
        kVar.setPosition(i * 8);
        this.mGv = kVar.readBits(16);
        this.mGw = kVar.readBits(16);
        this.mGx = kVar.readBits(24);
        this.maxFrameSize = kVar.readBits(24);
        this.sampleRate = kVar.readBits(20);
        this.channels = kVar.readBits(3) + 1;
        this.moz = kVar.readBits(5) + 1;
        this.mGy = (kVar.readBits(32) & 4294967295L) | ((kVar.readBits(4) & 15) << 32);
    }

    public int dxY() {
        return this.moz * this.sampleRate;
    }

    public long dxZ() {
        return (this.mGy * TimeUtils.NANOS_PER_MS) / this.sampleRate;
    }
}
