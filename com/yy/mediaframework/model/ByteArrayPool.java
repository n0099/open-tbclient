package com.yy.mediaframework.model;

import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes4.dex */
public class ByteArrayPool {
    private int mBufSize;
    private int mCapacity;
    private ConcurrentLinkedQueue<byte[]> mFreeByteArray;

    public ByteArrayPool(int i, int i2) {
        this.mFreeByteArray = null;
        this.mBufSize = 0;
        this.mCapacity = 0;
        this.mCapacity = i;
        this.mBufSize = i2;
        this.mFreeByteArray = new ConcurrentLinkedQueue<>();
        for (int i3 = 0; i3 < i; i3++) {
            this.mFreeByteArray.offer(new byte[i2]);
        }
    }

    public byte[] newByteArray() {
        return this.mFreeByteArray.poll();
    }

    public void freeByteArray(byte[] bArr) {
        this.mFreeByteArray.offer(bArr);
    }
}
