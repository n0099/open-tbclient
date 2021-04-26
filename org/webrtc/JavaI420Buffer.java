package org.webrtc;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.webrtc.VideoFrame;
/* loaded from: classes7.dex */
public class JavaI420Buffer implements VideoFrame.I420Buffer {
    public final ByteBuffer dataU;
    public final ByteBuffer dataV;
    public final ByteBuffer dataY;
    public final int height;
    public final RefCountDelegate refCountDelegate;
    public final int strideU;
    public final int strideV;
    public final int strideY;
    public final int width;

    public JavaI420Buffer(int i2, int i3, ByteBuffer byteBuffer, int i4, ByteBuffer byteBuffer2, int i5, ByteBuffer byteBuffer3, int i6, @Nullable Runnable runnable) {
        this.width = i2;
        this.height = i3;
        this.dataY = byteBuffer;
        this.dataU = byteBuffer2;
        this.dataV = byteBuffer3;
        this.strideY = i4;
        this.strideU = i5;
        this.strideV = i6;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    public static JavaI420Buffer allocate(int i2, int i3) {
        int i4 = (i3 + 1) / 2;
        int i5 = (i2 + 1) / 2;
        int i6 = i2 * i3;
        int i7 = i6 + 0;
        int i8 = i5 * i4;
        int i9 = i7 + i8;
        final ByteBuffer nativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer(i6 + (i5 * 2 * i4));
        nativeAllocateByteBuffer.position(0);
        nativeAllocateByteBuffer.limit(i7);
        ByteBuffer slice = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i7);
        nativeAllocateByteBuffer.limit(i9);
        ByteBuffer slice2 = nativeAllocateByteBuffer.slice();
        nativeAllocateByteBuffer.position(i9);
        nativeAllocateByteBuffer.limit(i9 + i8);
        return new JavaI420Buffer(i2, i3, slice, i2, slice2, i5, nativeAllocateByteBuffer.slice(), i5, new Runnable() { // from class: org.webrtc._$$Lambda$JavaI420Buffer$_Oc35sRrucoGcYlFFmf5S_RP8fI
            @Override // java.lang.Runnable
            public final void run() {
                JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
            }
        });
    }

    public static void checkCapacity(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        int i5 = (i4 * (i3 - 1)) + i2;
        if (byteBuffer.capacity() >= i5) {
            return;
        }
        throw new IllegalArgumentException("Buffer must be at least " + i5 + " bytes, but was " + byteBuffer.capacity());
    }

    public static VideoFrame.Buffer cropAndScaleI420(final VideoFrame.I420Buffer i420Buffer, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i4 == i6 && i5 == i7) {
            ByteBuffer dataY = i420Buffer.getDataY();
            ByteBuffer dataU = i420Buffer.getDataU();
            ByteBuffer dataV = i420Buffer.getDataV();
            dataY.position(i2 + (i420Buffer.getStrideY() * i3));
            int i8 = i2 / 2;
            int i9 = i3 / 2;
            dataU.position((i420Buffer.getStrideU() * i9) + i8);
            dataV.position(i8 + (i9 * i420Buffer.getStrideV()));
            i420Buffer.retain();
            ByteBuffer slice = dataY.slice();
            int strideY = i420Buffer.getStrideY();
            ByteBuffer slice2 = dataU.slice();
            int strideU = i420Buffer.getStrideU();
            ByteBuffer slice3 = dataV.slice();
            int strideV = i420Buffer.getStrideV();
            i420Buffer.getClass();
            return wrap(i6, i7, slice, strideY, slice2, strideU, slice3, strideV, new Runnable() { // from class: org.webrtc._$$Lambda$cpstbe6pEi_a9uN5WMp_TN86PFo
                @Override // java.lang.Runnable
                public final void run() {
                    VideoFrame.I420Buffer.this.release();
                }
            });
        }
        JavaI420Buffer allocate = allocate(i6, i7);
        nativeCropAndScaleI420(i420Buffer.getDataY(), i420Buffer.getStrideY(), i420Buffer.getDataU(), i420Buffer.getStrideU(), i420Buffer.getDataV(), i420Buffer.getStrideV(), i2, i3, i4, i5, allocate.getDataY(), allocate.getStrideY(), allocate.getDataU(), allocate.getStrideU(), allocate.getDataV(), allocate.getStrideV(), i6, i7);
        return allocate;
    }

    public static native void nativeCropAndScaleI420(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, ByteBuffer byteBuffer3, int i4, int i5, int i6, int i7, int i8, ByteBuffer byteBuffer4, int i9, ByteBuffer byteBuffer5, int i10, ByteBuffer byteBuffer6, int i11, int i12, int i13);

    public static JavaI420Buffer wrap(int i2, int i3, ByteBuffer byteBuffer, int i4, ByteBuffer byteBuffer2, int i5, ByteBuffer byteBuffer3, int i6, @Nullable Runnable runnable) {
        if (byteBuffer == null || byteBuffer2 == null || byteBuffer3 == null) {
            throw new IllegalArgumentException("Data buffers cannot be null.");
        }
        if (byteBuffer.isDirect() && byteBuffer2.isDirect() && byteBuffer3.isDirect()) {
            ByteBuffer slice = byteBuffer.slice();
            ByteBuffer slice2 = byteBuffer2.slice();
            ByteBuffer slice3 = byteBuffer3.slice();
            int i7 = (i2 + 1) / 2;
            int i8 = (i3 + 1) / 2;
            checkCapacity(slice, i2, i3, i4);
            checkCapacity(slice2, i7, i8, i5);
            checkCapacity(slice3, i7, i8, i6);
            return new JavaI420Buffer(i2, i3, slice, i4, slice2, i5, slice3, i6, runnable);
        }
        throw new IllegalArgumentException("Data buffers must be direct byte buffers.");
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i2, int i3, int i4, int i5, int i6, int i7) {
        return cropAndScaleI420(this, i2, i3, i4, i5, i6, i7);
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataU() {
        return this.dataU.slice();
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataV() {
        return this.dataV.slice();
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public ByteBuffer getDataY() {
        return this.dataY.slice();
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideU() {
        return this.strideU;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideV() {
        return this.strideV;
    }

    @Override // org.webrtc.VideoFrame.I420Buffer
    public int getStrideY() {
        return this.strideY;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void release() {
        this.refCountDelegate.release();
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void retain() {
        this.refCountDelegate.retain();
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        retain();
        return this;
    }
}
