package org.webrtc;

import android.os.Build;
import java.nio.ByteBuffer;
import org.webrtc.VideoFrame;
/* loaded from: classes7.dex */
public class NV21Buffer implements VideoFrame.Buffer {
    public final byte[] data;
    public final int height;
    public final RefCountDelegate refCountDelegate;
    public final boolean uvSwapped = Build.MODEL.contains("SABRESD-MX6DQ");
    public final int width;

    public NV21Buffer(byte[] bArr, int i2, int i3, Runnable runnable) {
        this.data = bArr;
        this.width = i2;
        this.height = i3;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    public static native void nativeCropAndScale(int i2, int i3, int i4, int i5, int i6, int i7, byte[] bArr, int i8, int i9, ByteBuffer byteBuffer, int i10, ByteBuffer byteBuffer2, int i11, ByteBuffer byteBuffer3, int i12);

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i2, int i3, int i4, int i5, int i6, int i7) {
        JavaI420Buffer allocate = JavaI420Buffer.allocate(i6, i7);
        if (this.uvSwapped) {
            nativeCropAndScale(i2, i3, i4, i5, i6, i7, this.data, this.width, this.height, allocate.getDataY(), allocate.getStrideY(), allocate.getDataV(), allocate.getStrideV(), allocate.getDataU(), allocate.getStrideU());
        } else {
            nativeCropAndScale(i2, i3, i4, i5, i6, i7, this.data, this.width, this.height, allocate.getDataY(), allocate.getStrideY(), allocate.getDataU(), allocate.getStrideU(), allocate.getDataV(), allocate.getStrideV());
        }
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
