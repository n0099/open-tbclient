package org.webrtc;

import android.content.Context;
/* loaded from: classes8.dex */
public interface VideoCapturer {
    void changeCaptureFormat(int i2, int i3, int i4);

    void dispose();

    void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver);

    boolean isScreencast();

    void startCapture(int i2, int i3, int i4);

    void stopCapture() throws InterruptedException;
}
