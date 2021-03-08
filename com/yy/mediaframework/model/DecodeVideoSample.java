package com.yy.mediaframework.model;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class DecodeVideoSample {
    public byte[] data;
    public int dataLenght;
    public long dts;
    public int frameType;
    public int height;
    AtomicInteger mRefCnt = new AtomicInteger(0);
    public long pts;
    public long streamId;
    public int width;

    public void init(long j, int i, int i2, byte[] bArr, int i3, int i4, long j2, long j3) {
        this.streamId = j;
        this.width = i;
        this.height = i2;
        this.data = bArr;
        this.dataLenght = i3;
        this.frameType = i4;
        this.pts = j2;
        this.dts = j3;
    }

    public void reset() {
        this.streamId = -1L;
        this.width = -1;
        this.height = -1;
        this.data = null;
        this.dataLenght = -1;
        this.frameType = -1;
        this.pts = -1L;
        this.dts = -1L;
    }

    public int addRef() {
        return this.mRefCnt.addAndGet(1);
    }

    public int decRef() {
        int decrementAndGet = this.mRefCnt.decrementAndGet();
        if (decrementAndGet == 0) {
            YYPeripheralsVideoSampleAllocator.instance().free(this);
            return 0;
        }
        return decrementAndGet;
    }
}
