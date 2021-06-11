package com.kwad.sdk.glide.webp;

import androidx.annotation.Keep;
import com.kwad.sdk.glide.g.j;
import java.nio.ByteBuffer;
@Keep
/* loaded from: classes7.dex */
public class WebpImage {
    public int mBackgroundColor;
    public int mDurationMs;
    public int mFrameCount;
    public int[] mFrameDurations;
    public int mHeigth;
    public int mLoopCount;
    @Keep
    public long mNativePtr;
    public int mWidth;

    static {
        try {
            System.loadLibrary("glide-webp");
        } catch (Throwable unused) {
        }
    }

    @Keep
    public WebpImage(long j, int i2, int i3, int i4, int i5, int[] iArr, int i6, int i7) {
        if (j == 0) {
            throw new RuntimeException("internal error: native WebpImage is 0");
        }
        this.mWidth = i2;
        this.mHeigth = i3;
        this.mFrameCount = i4;
        this.mDurationMs = i5;
        this.mFrameDurations = iArr;
        this.mLoopCount = i6;
        fixFrameDurations(iArr);
        this.mBackgroundColor = i7;
        this.mNativePtr = j;
    }

    public static WebpImage create(byte[] bArr) {
        j.a(bArr);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr);
        allocateDirect.rewind();
        return nativeCreateFromDirectByteBuffer(allocateDirect);
    }

    private void fixFrameDurations(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] < 20) {
                iArr[i2] = 100;
            }
        }
    }

    public static native WebpImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native WebpFrame nativeGetFrame(int i2);

    private native int nativeGetSizeInBytes();

    public void dispose() {
        nativeDispose();
    }

    public void finalize() {
        nativeFinalize();
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getDuration() {
        return this.mDurationMs;
    }

    public WebpFrame getFrame(int i2) {
        return nativeGetFrame(i2);
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    public int[] getFrameDurations() {
        return this.mFrameDurations;
    }

    public c getFrameInfo(int i2) {
        WebpFrame frame = getFrame(i2);
        try {
            return new c(i2, frame);
        } finally {
            frame.dispose();
        }
    }

    public int getHeight() {
        return this.mHeigth;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    public int getWidth() {
        return this.mWidth;
    }
}
