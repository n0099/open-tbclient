package com.facebook.imagepipeline.memory;

import android.util.Log;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader;
import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
@DoNotStrip
/* loaded from: classes6.dex */
public class NativeMemoryChunk implements MemoryChunk, Closeable {
    public static final String TAG = "NativeMemoryChunk";
    public boolean mIsClosed;
    public final long mNativePtr;
    public final int mSize;

    static {
        ImagePipelineNativeLoader.load();
    }

    public NativeMemoryChunk(int i2) {
        Preconditions.checkArgument(i2 > 0);
        this.mSize = i2;
        this.mNativePtr = nativeAllocate(i2);
        this.mIsClosed = false;
    }

    private void doCopy(int i2, MemoryChunk memoryChunk, int i3, int i4) {
        if (memoryChunk instanceof NativeMemoryChunk) {
            Preconditions.checkState(!isClosed());
            Preconditions.checkState(!memoryChunk.isClosed());
            MemoryChunkUtil.checkBounds(i2, memoryChunk.getSize(), i3, i4, this.mSize);
            nativeMemcpy(memoryChunk.getNativePtr() + i3, this.mNativePtr + i2, i4);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @DoNotStrip
    public static native long nativeAllocate(int i2);

    @DoNotStrip
    public static native void nativeCopyFromByteArray(long j, byte[] bArr, int i2, int i3);

    @DoNotStrip
    public static native void nativeCopyToByteArray(long j, byte[] bArr, int i2, int i3);

    @DoNotStrip
    public static native void nativeFree(long j);

    @DoNotStrip
    public static native void nativeMemcpy(long j, long j2, int i2);

    @DoNotStrip
    public static native byte nativeReadByte(long j);

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.mIsClosed) {
            this.mIsClosed = true;
            nativeFree(this.mNativePtr);
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public void copy(int i2, MemoryChunk memoryChunk, int i3, int i4) {
        Preconditions.checkNotNull(memoryChunk);
        if (memoryChunk.getUniqueId() == getUniqueId()) {
            Log.w(TAG, "Copying from NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(this)) + " to NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(memoryChunk)) + " which share the same address " + Long.toHexString(this.mNativePtr));
            Preconditions.checkArgument(false);
        }
        if (memoryChunk.getUniqueId() < getUniqueId()) {
            synchronized (memoryChunk) {
                synchronized (this) {
                    doCopy(i2, memoryChunk, i3, i4);
                }
            }
            return;
        }
        synchronized (this) {
            synchronized (memoryChunk) {
                doCopy(i2, memoryChunk, i3, i4);
            }
        }
    }

    public void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        Log.w(TAG, "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. ");
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    @Nullable
    public ByteBuffer getByteBuffer() {
        return null;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getNativePtr() {
        return this.mNativePtr;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public int getSize() {
        return this.mSize;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getUniqueId() {
        return this.mNativePtr;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized boolean isClosed() {
        return this.mIsClosed;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int read(int i2, byte[] bArr, int i3, int i4) {
        int adjustByteCount;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(!isClosed());
        adjustByteCount = MemoryChunkUtil.adjustByteCount(i2, i4, this.mSize);
        MemoryChunkUtil.checkBounds(i2, bArr.length, i3, adjustByteCount, this.mSize);
        nativeCopyToByteArray(this.mNativePtr + i2, bArr, i3, adjustByteCount);
        return adjustByteCount;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int write(int i2, byte[] bArr, int i3, int i4) {
        int adjustByteCount;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(!isClosed());
        adjustByteCount = MemoryChunkUtil.adjustByteCount(i2, i4, this.mSize);
        MemoryChunkUtil.checkBounds(i2, bArr.length, i3, adjustByteCount, this.mSize);
        nativeCopyFromByteArray(this.mNativePtr + i2, bArr, i3, adjustByteCount);
        return adjustByteCount;
    }

    @VisibleForTesting
    public NativeMemoryChunk() {
        this.mSize = 0;
        this.mNativePtr = 0L;
        this.mIsClosed = true;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized byte read(int i2) {
        boolean z = true;
        Preconditions.checkState(!isClosed());
        Preconditions.checkArgument(i2 >= 0);
        if (i2 >= this.mSize) {
            z = false;
        }
        Preconditions.checkArgument(z);
        return nativeReadByte(this.mNativePtr + i2);
    }
}
