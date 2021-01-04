package com.facebook.animated.gif;

import android.graphics.Bitmap;
import com.facebook.common.internal.d;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public class GifFrame {
    @d
    private long mNativeContext;

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDisposalMode();

    private native int nativeGetDurationMs();

    private native int nativeGetHeight();

    private native int nativeGetTransparentPixelColor();

    private native int nativeGetWidth();

    private native int nativeGetXOffset();

    private native int nativeGetYOffset();

    private native boolean nativeHasTransparency();

    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    @d
    GifFrame(long j) {
        this.mNativeContext = j;
    }

    protected void finalize() {
        nativeFinalize();
    }
}
