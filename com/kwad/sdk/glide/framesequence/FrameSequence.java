package com.kwad.sdk.glide.framesequence;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class FrameSequence implements Serializable {
    public static final AtomicBoolean ISLOADED = new AtomicBoolean(false);
    public int mDefaultLoopCount;
    public int mFrameCount;
    public int mHeight;
    public long mNativeFrameSequence;
    public boolean mOpaque;
    public int mWidth;

    /* loaded from: classes9.dex */
    public static class State implements Serializable {
        public long mNativeState;

        public State(long j) {
            this.mNativeState = j;
        }

        public void destroy() {
            long j = this.mNativeState;
            if (j != 0) {
                FrameSequence.nativeDestroyState(j);
                this.mNativeState = 0L;
            }
        }

        public long getFrame(int i, Bitmap bitmap, int i2) {
            if (bitmap == null || bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                throw new IllegalArgumentException("Bitmap passed must be non-null and ARGB_8888");
            }
            long j = this.mNativeState;
            if (j != 0) {
                return FrameSequence.nativeGetFrame(j, i, bitmap, i2);
            }
            throw new IllegalStateException("attempted to draw destroyed FrameSequenceState");
        }
    }

    static {
        try {
            System.loadLibrary("framesequencev2");
            ISLOADED.set(true);
        } catch (Throwable unused) {
            ISLOADED.set(false);
        }
    }

    public FrameSequence() {
    }

    public FrameSequence(long j, int i, int i2, boolean z, int i3, int i4) {
        this.mNativeFrameSequence = j;
        this.mWidth = i;
        this.mHeight = i2;
        this.mOpaque = z;
        this.mFrameCount = i3;
        this.mDefaultLoopCount = i4;
    }

    @Nullable
    public static FrameSequence decodeByteArray(byte[] bArr) {
        if (ISLOADED.get()) {
            return decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    @Nullable
    public static FrameSequence decodeByteArray(byte[] bArr, int i, int i2) {
        if (ISLOADED.get()) {
            if (bArr != null) {
                if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
                    throw new IllegalArgumentException("invalid offset/length parameters");
                }
                return nativeDecodeByteArray(bArr, i, i2);
            }
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Nullable
    public static FrameSequence decodeByteBuffer(ByteBuffer byteBuffer) {
        if (ISLOADED.get()) {
            if (byteBuffer != null) {
                if (byteBuffer.isDirect()) {
                    return nativeDecodeByteBuffer(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
                }
                if (byteBuffer.hasArray()) {
                    return decodeByteArray(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
                }
                throw new IllegalArgumentException("Cannot have non-direct ByteBuffer with no byte array");
            }
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Nullable
    public static FrameSequence decodeStream(InputStream inputStream) {
        if (ISLOADED.get()) {
            if (inputStream != null) {
                return nativeDecodeStream(inputStream, new byte[16384]);
            }
            throw new IllegalArgumentException();
        }
        return null;
    }

    public static boolean isEnable() {
        return ISLOADED.get();
    }

    public static native long nativeCreateState(long j);

    public static native FrameSequence nativeDecodeByteArray(byte[] bArr, int i, int i2);

    public static native FrameSequence nativeDecodeByteBuffer(ByteBuffer byteBuffer, int i, int i2);

    public static native FrameSequence nativeDecodeStream(InputStream inputStream, byte[] bArr);

    public static native void nativeDestroyFrameSequence(long j);

    public static native void nativeDestroyState(long j);

    public static native long nativeGetFrame(long j, int i, Bitmap bitmap, int i2);

    public State createState() {
        long j = this.mNativeFrameSequence;
        if (j != 0) {
            long nativeCreateState = nativeCreateState(j);
            if (nativeCreateState == 0) {
                return null;
            }
            return new State(nativeCreateState);
        }
        throw new IllegalStateException("attempted to use incorrectly built FrameSequence");
    }

    public void destroy() {
        long j = this.mNativeFrameSequence;
        if (j != 0) {
            nativeDestroyFrameSequence(j);
        }
    }

    public int getDefaultLoopCount() {
        return this.mDefaultLoopCount;
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isOpaque() {
        return this.mOpaque;
    }
}
