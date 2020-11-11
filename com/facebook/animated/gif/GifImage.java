package com.facebook.animated.gif;

import com.facebook.common.e.a;
import com.facebook.common.internal.d;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.animated.a.c;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.b;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@d
/* loaded from: classes10.dex */
public class GifImage implements c, b {
    private static volatile boolean oJN;
    @d
    private long mNativeContext;

    @d
    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    @d
    private static native GifImage nativeCreateFromNativeMemory(long j, int i);

    @d
    private native void nativeDispose();

    @d
    private native void nativeFinalize();

    @d
    private native int nativeGetDuration();

    @d
    private native GifFrame nativeGetFrame(int i);

    @d
    private native int nativeGetFrameCount();

    @d
    private native int[] nativeGetFrameDurations();

    @d
    private native int nativeGetHeight();

    @d
    private native int nativeGetLoopCount();

    @d
    private native int nativeGetSizeInBytes();

    @d
    private native int nativeGetWidth();

    private static synchronized void eji() {
        synchronized (GifImage.class) {
            if (!oJN) {
                oJN = true;
                a.loadLibrary("gifimage");
            }
        }
    }

    public static GifImage J(long j, int i) {
        eji();
        g.checkArgument(j != 0);
        return nativeCreateFromNativeMemory(j, i);
    }

    @Override // com.facebook.imagepipeline.animated.a.c
    public b K(long j, int i) {
        return J(j, i);
    }

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

    @Override // com.facebook.imagepipeline.animated.base.b
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public int getFrameCount() {
        return nativeGetFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public int[] ejj() {
        return nativeGetFrameDurations();
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public int getLoopCount() {
        int nativeGetLoopCount = nativeGetLoopCount();
        switch (nativeGetLoopCount) {
            case -1:
                return 1;
            case 0:
                return 0;
            default:
                return nativeGetLoopCount + 1;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.animated.base.b
    /* renamed from: Ok */
    public GifFrame On(int i) {
        return nativeGetFrame(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public boolean ejk() {
        return false;
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public AnimatedDrawableFrameInfo Ol(int i) {
        GifFrame On = On(i);
        try {
            return new AnimatedDrawableFrameInfo(i, On.getXOffset(), On.getYOffset(), On.getWidth(), On.getHeight(), AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS, Om(On.ejh()));
        } finally {
            On.dispose();
        }
    }

    private static AnimatedDrawableFrameInfo.DisposalMethod Om(int i) {
        if (i == 0) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
        }
        if (i == 1) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
        }
        if (i == 2) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND;
        }
        if (i == 3) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS;
        }
        return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
    }
}
