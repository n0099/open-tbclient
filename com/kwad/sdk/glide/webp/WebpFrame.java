package com.kwad.sdk.glide.webp;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
@Keep
/* loaded from: classes6.dex */
public class WebpFrame {
    public static final int FRAME_DURATION_MS_FOR_MIN = 100;
    public static final int MIN_FRAME_DURATION_MS = 20;
    public boolean blendPreviousFrame;
    public int delay;
    public boolean disposeBackgroundColor;
    public int ih;
    public int iw;
    public int ix;
    public int iy;
    @Keep
    public long mNativePtr;

    public WebpFrame(long j, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        this.mNativePtr = j;
        this.ix = i;
        this.iy = i2;
        this.iw = i3;
        this.ih = i4;
        this.delay = i5;
        this.blendPreviousFrame = z;
        this.disposeBackgroundColor = z2;
        fixFrameDuration();
    }

    private void fixFrameDuration() {
        if (this.delay < 20) {
            this.delay = 100;
        }
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    public void dispose() {
        nativeDispose();
    }

    public void finalize() {
        nativeFinalize();
    }

    public int getDurationMs() {
        return this.delay;
    }

    public int getHeight() {
        return this.ih;
    }

    public int getWidth() {
        return this.iw;
    }

    public int getXOffest() {
        return this.ix;
    }

    public int getYOffest() {
        return this.iy;
    }

    public boolean isBlendWithPreviousFrame() {
        return this.blendPreviousFrame;
    }

    public void renderFrame(int i, int i2, Bitmap bitmap) {
        nativeRenderFrame(i, i2, bitmap);
    }

    public boolean shouldDisposeToBackgroundColor() {
        return this.disposeBackgroundColor;
    }
}
