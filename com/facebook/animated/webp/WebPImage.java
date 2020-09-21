package com.facebook.animated.webp;

import com.facebook.common.internal.d;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.animated.a.c;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.b;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@d
/* loaded from: classes8.dex */
public class WebPImage implements c, b {
    @d
    private long mNativeContext;

    private static native WebPImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private static native WebPImage nativeCreateFromNativeMemory(long j, int i);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native WebPFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    @d
    public WebPImage() {
    }

    @d
    WebPImage(long j) {
        this.mNativeContext = j;
    }

    protected void finalize() {
        nativeFinalize();
    }

    public static WebPImage D(long j, int i) {
        com.facebook.imagepipeline.nativecode.b.dRK();
        g.checkArgument(j != 0);
        return nativeCreateFromNativeMemory(j, i);
    }

    @Override // com.facebook.imagepipeline.animated.a.c
    public b C(long j, int i) {
        return D(j, i);
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
    public int[] dRL() {
        return nativeGetFrameDurations();
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public int getLoopCount() {
        return nativeGetLoopCount();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.animated.base.b
    /* renamed from: Lw */
    public WebPFrame Lv(int i) {
        return nativeGetFrame(i);
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public boolean dRM() {
        return true;
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public AnimatedDrawableFrameInfo Lt(int i) {
        WebPFrame Lv = Lv(i);
        try {
            return new AnimatedDrawableFrameInfo(i, Lv.getXOffset(), Lv.getYOffset(), Lv.getWidth(), Lv.getHeight(), Lv.dRO() ? AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS : AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND, Lv.dRN() ? AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND : AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT);
        } finally {
            Lv.dispose();
        }
    }
}
