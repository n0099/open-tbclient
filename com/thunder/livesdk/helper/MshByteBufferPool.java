package com.thunder.livesdk.helper;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class MshByteBufferPool implements IByteBufferPool {
    static final int kSize16K = 16384;
    static final int kSize32K = 32768;
    static final int kSize4K = 4096;
    static final int kSize8K = 8192;
    private HashSet<ByteBuffer> mBigBuffers;
    private ByteBufferChunk mBuffer16K;
    private ByteBufferChunk mBuffer32K;
    private ByteBufferChunk mBuffer4K;
    private ByteBufferChunk mBuffer8K;

    public MshByteBufferPool() {
        this.mBuffer4K = null;
        this.mBuffer8K = null;
        this.mBuffer16K = null;
        this.mBuffer32K = null;
        this.mBigBuffers = null;
        this.mBuffer4K = new ByteBufferChunk(this, 4096, 8);
        this.mBuffer8K = new ByteBufferChunk(this, 8192, 6);
        this.mBuffer16K = new ByteBufferChunk(this, 16384, 4);
        this.mBuffer32K = new ByteBufferChunk(this, 32768, 2);
        this.mBigBuffers = new HashSet<>();
    }

    private ByteBufferChunk getBuffers(int i) {
        if (i < 0) {
            return null;
        }
        if (i <= 4096) {
            return this.mBuffer4K;
        }
        if (i <= 8192) {
            return this.mBuffer8K;
        }
        if (i <= 16384) {
            return this.mBuffer16K;
        }
        if (i <= 32768) {
            return this.mBuffer32K;
        }
        return null;
    }

    @Override // com.thunder.livesdk.helper.IByteBufferPool
    public ByteBuffer newBuffer(int i) {
        ByteBuffer order;
        synchronized (this) {
            ByteBufferChunk buffers = getBuffers(i);
            if (buffers != null && buffers.mFreeCnt > 0) {
                order = buffers.newBuffer();
            } else {
                order = ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
                this.mBigBuffers.add(order);
            }
        }
        return order;
    }

    @Override // com.thunder.livesdk.helper.IByteBufferPool
    public void freeBuffer(ByteBuffer byteBuffer) {
        synchronized (this) {
            ByteBufferChunk buffers = getBuffers(byteBuffer.capacity());
            if (buffers == null || !buffers.freeBuffer(byteBuffer)) {
                this.mBigBuffers.remove(byteBuffer);
            }
        }
    }

    @Override // com.thunder.livesdk.helper.IByteBufferPool
    public int totalSize() {
        return 0;
    }

    @Override // com.thunder.livesdk.helper.IByteBufferPool
    public void clear() {
        synchronized (this) {
            this.mBigBuffers.clear();
            this.mBigBuffers = null;
            this.mBuffer4K.clear();
            this.mBuffer8K.clear();
            this.mBuffer16K.clear();
            this.mBuffer32K.clear();
            this.mBuffer4K = null;
            this.mBuffer8K = null;
            this.mBuffer16K = null;
            this.mBuffer32K = null;
        }
    }

    /* loaded from: classes4.dex */
    public class ByteBufferChunk {
        public static final int kFreeFlag = 1;
        public int[] mBlockFlags;
        public ByteBuffer[] mBufferBlocks;
        public int mFreeCnt;
        final /* synthetic */ MshByteBufferPool this$0;

        public ByteBufferChunk(MshByteBufferPool mshByteBufferPool, int i, int i2) {
            this.this$0 = mshByteBufferPool;
            this.mBufferBlocks = null;
            this.mBlockFlags = null;
            this.mFreeCnt = 0;
            this.mBufferBlocks = new ByteBuffer[i2];
            this.mBlockFlags = new int[i2];
            this.mFreeCnt = i2;
            for (int i3 = 0; i3 < i2; i3++) {
                this.mBufferBlocks[i3] = ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
                this.mBlockFlags[i3] = 1;
            }
        }

        public ByteBuffer newBuffer() {
            for (int i = 0; i < this.mBufferBlocks.length; i++) {
                if ((this.mBlockFlags[i] & 1) != 0) {
                    int[] iArr = this.mBlockFlags;
                    iArr[i] = iArr[i] & (-2);
                    this.mFreeCnt--;
                    return this.mBufferBlocks[i];
                }
            }
            return null;
        }

        public boolean freeBuffer(ByteBuffer byteBuffer) {
            for (int i = 0; i < this.mBufferBlocks.length; i++) {
                if (byteBuffer == this.mBufferBlocks[i] && (this.mBlockFlags[i] & 1) == 0) {
                    int[] iArr = this.mBlockFlags;
                    iArr[i] = iArr[i] | 1;
                    this.mBufferBlocks[i].clear();
                    this.mFreeCnt++;
                    return true;
                }
            }
            return false;
        }

        public void clear() {
            for (int i = 0; i < this.mBufferBlocks.length; i++) {
                this.mBufferBlocks[i] = null;
            }
            this.mBufferBlocks = null;
            this.mBlockFlags = null;
        }
    }
}
