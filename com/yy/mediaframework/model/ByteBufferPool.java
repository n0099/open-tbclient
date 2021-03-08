package com.yy.mediaframework.model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes6.dex */
public class ByteBufferPool {
    private int mBufSize;
    private int mCapacity;
    private ConcurrentLinkedQueue<ByteBuffer> mFreeByteArray;

    public ByteBufferPool(int i, int i2) {
        this.mFreeByteArray = null;
        this.mBufSize = 0;
        this.mCapacity = 0;
        this.mCapacity = i;
        this.mBufSize = i2;
        this.mFreeByteArray = new ConcurrentLinkedQueue<>();
        for (int i3 = 0; i3 < i; i3++) {
            ByteBuffer allocate = ByteBuffer.allocate(i2);
            allocate.order(ByteOrder.nativeOrder());
            this.mFreeByteArray.offer(allocate);
        }
    }

    public ByteBuffer newByteBuffer() {
        return this.mFreeByteArray.poll();
    }

    public void freeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            byteBuffer.clear();
            this.mFreeByteArray.offer(byteBuffer);
        }
    }
}
