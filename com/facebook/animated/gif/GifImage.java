package com.facebook.animated.gif;

import com.facebook.common.internal.d;
import com.facebook.imagepipeline.animated.base.a;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@d
/* loaded from: classes6.dex */
public class GifImage implements a {
    @d
    private long mNativeContext;

    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private static native GifImage nativeCreateFromNativeMemory(long j, int i);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native GifFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    @d
    public GifImage() {
    }

    @d
    GifImage(long j) {
        this.mNativeContext = j;
    }

    protected void finalize() {
        nativeFinalize();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }
}
