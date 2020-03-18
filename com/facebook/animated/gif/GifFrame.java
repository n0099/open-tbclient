package com.facebook.animated.gif;

import android.graphics.Bitmap;
import com.facebook.common.internal.d;
import com.facebook.imagepipeline.animated.base.c;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class GifFrame implements c {
    @d
    private long mNativeContext;

    @d
    private native void nativeDispose();

    @d
    private native void nativeFinalize();

    @d
    private native int nativeGetDisposalMode();

    @d
    private native int nativeGetDurationMs();

    @d
    private native int nativeGetHeight();

    @d
    private native int nativeGetTransparentPixelColor();

    @d
    private native int nativeGetWidth();

    @d
    private native int nativeGetXOffset();

    @d
    private native int nativeGetYOffset();

    @d
    private native boolean nativeHasTransparency();

    @d
    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    @d
    GifFrame(long j) {
        this.mNativeContext = j;
    }

    protected void finalize() {
        nativeFinalize();
    }

    @Override // com.facebook.imagepipeline.animated.base.c
    public void dispose() {
        nativeDispose();
    }

    @Override // com.facebook.imagepipeline.animated.base.c
    public void renderFrame(int i, int i2, Bitmap bitmap) {
        nativeRenderFrame(i, i2, bitmap);
    }

    @Override // com.facebook.imagepipeline.animated.base.c
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.c
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.c
    public int getXOffset() {
        return nativeGetXOffset();
    }

    @Override // com.facebook.imagepipeline.animated.base.c
    public int getYOffset() {
        return nativeGetYOffset();
    }

    public int dko() {
        return nativeGetDisposalMode();
    }
}
