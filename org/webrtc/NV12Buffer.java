package org.webrtc;

import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.webrtc.VideoFrame;
/* loaded from: classes7.dex */
public class NV12Buffer implements VideoFrame.Buffer {
    public final ByteBuffer buffer;
    public final int height;
    public final RefCountDelegate refCountDelegate;
    public final int sliceHeight;
    public final int stride;
    public final int width;

    public NV12Buffer(int i2, int i3, int i4, int i5, ByteBuffer byteBuffer, @Nullable Runnable runnable) {
        this.width = i2;
        this.height = i3;
        this.stride = i4;
        this.sliceHeight = i5;
        this.buffer = byteBuffer;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    public static native void nativeCropAndScale(int i2, int i3, int i4, int i5, int i6, int i7, ByteBuffer byteBuffer, int i8, int i9, int i10, int i11, ByteBuffer byteBuffer2, int i12, ByteBuffer byteBuffer3, int i13, ByteBuffer byteBuffer4, int i14);

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i2, int i3, int i4, int i5, int i6, int i7) {
        JavaI420Buffer allocate = JavaI420Buffer.allocate(i6, i7);
        nativeCropAndScale(i2, i3, i4, i5, i6, i7, this.buffer, this.width, this.height, this.stride, this.sliceHeight, allocate.getDataY(), allocate.getStrideY(), allocate.getDataU(), allocate.getStrideU(), allocate.getDataV(), allocate.getStrideV());
        return allocate;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
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
        int i2 = this.width;
        int i3 = this.height;
        return (VideoFrame.I420Buffer) cropAndScale(0, 0, i2, i3, i2, i3);
    }
}
