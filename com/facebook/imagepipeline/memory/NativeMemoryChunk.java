package com.facebook.imagepipeline.memory;

import android.util.Log;
import java.io.Closeable;
@com.facebook.common.internal.d
/* loaded from: classes2.dex */
public class NativeMemoryChunk implements Closeable {
    private final long itt;
    private boolean mClosed;
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
        this.itt = nativeAllocate(this.mSize);
        this.mClosed = false;
    }

    public NativeMemoryChunk() {
        this.mSize = 0;
        this.itt = 0L;
        this.mClosed = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.mClosed) {
            this.mClosed = true;
            nativeFree(this.itt);
        }
    }

    public synchronized boolean isClosed() {
        return this.mClosed;
    }

    public int getSize() {
        return this.mSize;
    }

    public synchronized int c(int i, byte[] bArr, int i2, int i3) {
        int ch;
        com.facebook.common.internal.g.checkNotNull(bArr);
        com.facebook.common.internal.g.checkState(!isClosed());
        ch = ch(i, i3);
        A(i, bArr.length, i2, ch);
        nativeCopyFromByteArray(this.itt + i, bArr, i2, ch);
        return ch;
    }

    public synchronized int d(int i, byte[] bArr, int i2, int i3) {
        int ch;
        com.facebook.common.internal.g.checkNotNull(bArr);
        com.facebook.common.internal.g.checkState(!isClosed());
        ch = ch(i, i3);
        A(i, bArr.length, i2, ch);
        nativeCopyToByteArray(this.itt + i, bArr, i2, ch);
        return ch;
    }

    public synchronized byte yi(int i) {
        byte nativeReadByte;
        synchronized (this) {
            com.facebook.common.internal.g.checkState(!isClosed());
            com.facebook.common.internal.g.checkArgument(i >= 0);
            com.facebook.common.internal.g.checkArgument(i < this.mSize);
            nativeReadByte = nativeReadByte(this.itt + i);
        }
        return nativeReadByte;
    }

    public void a(int i, NativeMemoryChunk nativeMemoryChunk, int i2, int i3) {
        com.facebook.common.internal.g.checkNotNull(nativeMemoryChunk);
        if (nativeMemoryChunk.itt == this.itt) {
            Log.w("NativeMemoryChunk", "Copying from NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(this)) + " to NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(nativeMemoryChunk)) + " which share the same address " + Long.toHexString(this.itt));
            com.facebook.common.internal.g.checkArgument(false);
        }
        if (nativeMemoryChunk.itt < this.itt) {
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
        A(i, nativeMemoryChunk.mSize, i2, i3);
        nativeMemcpy(nativeMemoryChunk.itt + i2, this.itt + i, i3);
    }

    protected void finalize() throws Throwable {
        if (!isClosed()) {
            Log.w("NativeMemoryChunk", "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. Underlying address = " + Long.toHexString(this.itt));
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    private int ch(int i, int i2) {
        return Math.min(Math.max(0, this.mSize - i), i2);
    }

    private void A(int i, int i2, int i3, int i4) {
        com.facebook.common.internal.g.checkArgument(i4 >= 0);
        com.facebook.common.internal.g.checkArgument(i >= 0);
        com.facebook.common.internal.g.checkArgument(i3 >= 0);
        com.facebook.common.internal.g.checkArgument(i + i4 <= this.mSize);
        com.facebook.common.internal.g.checkArgument(i3 + i4 <= i2);
    }
}
