package com.facebook.animated.webp;

import android.graphics.Bitmap;
import com.facebook.common.internal.d;
import com.facebook.imagepipeline.animated.base.c;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes10.dex */
public class WebPFrame implements c {
    @d
    private long mNativeContext;

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDurationMs();

    private native int nativeGetHeight();

    private native int nativeGetWidth();

    private native int nativeGetXOffset();

    private native int nativeGetYOffset();

    private native boolean nativeIsBlendWithPreviousFrame();

    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    private native boolean nativeShouldDisposeToBackgroundColor();

    @d
    WebPFrame(long j) {
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
    public void b(int i, int i2, Bitmap bitmap) {
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

    public boolean dNG() {
        return nativeShouldDisposeToBackgroundColor();
    }

    public boolean dNH() {
        return nativeIsBlendWithPreviousFrame();
    }
}
