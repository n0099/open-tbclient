package com.thunder.livesdk.helper;

import com.thunder.livesdk.log.ThunderLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public class MshBuffer implements IMshBuffer {
    public ByteBuffer mByteBuffer;
    public IByteBufferPool mBytePool;

    public MshBuffer(int i, IByteBufferPool iByteBufferPool) {
        this.mByteBuffer = null;
        this.mBytePool = null;
        this.mBytePool = iByteBufferPool;
        if (iByteBufferPool == null) {
            this.mByteBuffer = ByteBuffer.allocate(i);
            this.mByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return;
        }
        this.mByteBuffer = iByteBufferPool.newBuffer(i);
    }

    @Override // com.thunder.livesdk.helper.IMshBuffer
    public void freeBuffer() {
        if (this.mBytePool != null) {
            this.mBytePool.freeBuffer(this.mByteBuffer);
            this.mByteBuffer = null;
        }
    }

    @Override // com.thunder.livesdk.helper.IMshBuffer
    public ByteBuffer getByteBuffer() {
        return this.mByteBuffer;
    }

    @Override // com.thunder.livesdk.helper.IMshBuffer
    public int increase_capacity(int i) {
        int capacity = this.mByteBuffer.capacity();
        if (capacity == 0) {
            return 0;
        }
        int i2 = capacity * 2;
        if (i > capacity) {
            i2 = capacity + i;
        }
        if (this.mBytePool == null) {
            ByteBuffer allocate = ByteBuffer.allocate(i2);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            this.mByteBuffer.limit(this.mByteBuffer.position());
            this.mByteBuffer.position(0);
            allocate.put(this.mByteBuffer);
            this.mByteBuffer = allocate;
            return i2;
        }
        ByteBuffer newBuffer = this.mBytePool.newBuffer(i2);
        this.mByteBuffer.limit(this.mByteBuffer.position());
        this.mByteBuffer.position(0);
        newBuffer.put(this.mByteBuffer);
        this.mBytePool.freeBuffer(this.mByteBuffer);
        this.mByteBuffer = newBuffer;
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(ThunderLog.kLogTagSdk, "===MshPoolBuffer, capactiy=" + this.mByteBuffer.capacity() + " postion=" + this.mByteBuffer.position());
            return i2;
        }
        return i2;
    }

    @Override // com.thunder.livesdk.helper.IMshBuffer
    public void wrap(byte[] bArr) {
        if (this.mByteBuffer != null && this.mBytePool != null) {
            this.mBytePool.freeBuffer(this.mByteBuffer);
        }
        this.mByteBuffer = ByteBuffer.wrap(bArr);
        this.mByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.mBytePool = null;
    }
}
