package com.spap.wrapper;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
/* loaded from: classes7.dex */
public class camera implements Camera.PreviewCallback, SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: e  reason: collision with root package name */
    public int f39527e;

    /* renamed from: f  reason: collision with root package name */
    public int f39528f;

    /* renamed from: g  reason: collision with root package name */
    public int f39529g;

    /* renamed from: h  reason: collision with root package name */
    public Camera.Size f39530h;

    /* renamed from: i  reason: collision with root package name */
    public SurfaceTexture f39531i;

    public static native void sendresult(int i2, byte[] bArr, int i3, int i4);

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f39528f = 1;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.f39529g == 0 && this.f39528f > 0) {
            try {
                this.f39531i.updateTexImage();
            } catch (Exception unused) {
            }
            this.f39528f = 0;
        }
        int i2 = this.f39527e;
        Camera.Size size = this.f39530h;
        sendresult(i2, bArr, size.width, size.height);
    }
}
