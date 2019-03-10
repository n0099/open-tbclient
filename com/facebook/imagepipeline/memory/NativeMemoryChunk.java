package com.facebook.imagepipeline.memory;

import android.util.Log;
import java.io.Closeable;
@com.facebook.common.internal.d
/* loaded from: classes2.dex */
public class NativeMemoryChunk implements Closeable {
    private boolean mClosed;
    private final long mNativePtr;
    private final int mSize;

    @com.facebook.common.internal.d
    private static native long nativeAllocate(int i);

    @com.facebook.common.internal.d
    private static native void nativeCopyFromByteArray(long j, byte[] bArr, int i, int i2);

    @com.facebook.common.internal.d
    private static native void nativeCopyToByteArray(long j, byte[] bArr, int i, int i2);

    @com.facebook.common.internal.d
    private static native void nativeFree(long j);

    @com.facebook.common.internal.d
    private static native void nativeMemcpy(long j, long j2, int i);

    @com.facebook.common.internal.d
    private static native byte nativeReadByte(long j);

    static {
        com.facebook.imagepipeline.nativecode.a.load();
    }

    public NativeMemoryChunk(int i) {
        com.facebook.common.internal.g.checkArgument(i > 0);
        this.mSize = i;
        this.mNativePtr = nativeAllocate(this.mSize);
        this.mClosed = false;
    }

    public NativeMemoryChunk() {
        this.mSize = 0;
        this.mNativePtr = 0L;
        this.mClosed = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.mClosed) {
            this.mClosed = true;
            nativeFree(this.mNativePtr);
        }
    }

    public synchronized boolean isClosed() {
        return this.mClosed;
    }

    public int getSize() {
        return this.mSize;
    }

    public synchronized int c(int i, byte[] bArr, int i2, int i3) {
        int cC;
        com.facebook.common.internal.g.checkNotNull(bArr);
        com.facebook.common.internal.g.checkState(!isClosed());
        cC = cC(i, i3);
        E(i, bArr.length, i2, cC);
        nativeCopyFromByteArray(this.mNativePtr + i, bArr, i2, cC);
        return cC;
    }

    public synchronized int d(int i, byte[] bArr, int i2, int i3) {
        int cC;
        com.facebook.common.internal.g.checkNotNull(bArr);
        com.facebook.common.internal.g.checkState(!isClosed());
        cC = cC(i, i3);
        E(i, bArr.length, i2, cC);
        nativeCopyToByteArray(this.mNativePtr + i, bArr, i2, cC);
        return cC;
    }

    public synchronized byte BV(int i) {
        byte nativeReadByte;
        synchronized (this) {
            com.facebook.common.internal.g.checkState(!isClosed());
            com.facebook.common.internal.g.checkArgument(i >= 0);
            com.facebook.common.internal.g.checkArgument(i < this.mSize);
            nativeReadByte = nativeReadByte(this.mNativePtr + i);
        }
        return nativeReadByte;
    }

    public void a(int i, NativeMemoryChunk nativeMemoryChunk, int i2, int i3) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        if (nativeMemoryChunk.mNativePtr == this.mNativePtr) {
            Log.w("NativeMemoryChunk", "Copying from NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(this)) + " to NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(nativeMemoryChunk)) + " which share the same address " + Long.toHexString(this.mNativePtr));
            com.facebook.common.internal.g.checkArgument(false);
        }
        if (nativeMemoryChunk.mNativePtr < this.mNativePtr) {
            synchronized (nativeMemoryChunk) {
                synchronized (this) {
                    b(i, nativeMemoryChunk, i2, i3);
                }
            }
            return;
        }
        synchronized (this) {
            synchronized (nativeMemoryChunk) {
                b(i, nativeMemoryChunk, i2, i3);
            }
        }
    }

    private void b(int i, NativeMemoryChunk nativeMemoryChunk, int i2, int i3) {
        com.facebook.common.internal.g.checkState(!isClosed());
        com.facebook.common.internal.g.checkState(nativeMemoryChunk.isClosed() ? false : true);
        E(i, nativeMemoryChunk.mSize, i2, i3);
        nativeMemcpy(nativeMemoryChunk.mNativePtr + i2, this.mNativePtr + i, i3);
    }

    protected void finalize() throws Throwable {
        if (!isClosed()) {
            Log.w("NativeMemoryChunk", "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. Underlying address = " + Long.toHexString(this.mNativePtr));
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    private int cC(int i, int i2) {
        return Math.min(Math.max(0, this.mSize - i), i2);
    }

    private void E(int i, int i2, int i3, int i4) {
        com.facebook.common.internal.g.checkArgument(i4 >= 0);
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i3 >= 0);
        com.facebook.common.internal.g.checkArgument(i + i4 <= this.mSize);
        com.facebook.common.internal.g.checkArgument(i3 + i4 <= i2);
    }
}
