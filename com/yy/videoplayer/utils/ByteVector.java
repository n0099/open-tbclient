package com.yy.videoplayer.utils;

import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class ByteVector {
    private static final float s_growRation = 1.3f;
    private int mSize = 0;
    private byte[] mBytes = null;

    public ByteVector(int i) {
        reserve(i);
    }

    private int remaining() {
        if (this.mBytes == null) {
            return 0;
        }
        return this.mBytes.length - this.mSize;
    }

    public void reserve(int i) {
        if (i > 0) {
            if (remaining() < i || this.mBytes == null) {
                byte[] bArr = new byte[(int) ((s_growRation * i) + this.mSize)];
                if (this.mSize > 0 && this.mBytes != null) {
                    System.arraycopy(this.mBytes, 0, bArr, 0, this.mSize);
                }
                this.mBytes = bArr;
            }
        }
    }

    public byte[] getBytes() {
        return this.mBytes;
    }

    public int size() {
        return this.mSize;
    }

    public void put(ByteBuffer byteBuffer, int i) {
        if (byteBuffer != null && i > 0) {
            if (byteBuffer.remaining() <= i) {
                i = byteBuffer.remaining();
            }
            reserve(this.mSize + i);
            byteBuffer.get(this.mBytes, this.mSize, i);
            this.mSize += i;
        }
    }

    public void clear() {
        this.mSize = 0;
    }

    public void release() {
        this.mSize = 0;
        this.mBytes = null;
    }
}
