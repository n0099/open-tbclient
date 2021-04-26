package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.view.Surface;
import javax.annotation.Nullable;
@TargetApi(21)
/* loaded from: classes7.dex */
public class ScreenCapturerAndroid implements VideoCapturer, VideoSink {
    public static final int DISPLAY_FLAGS = 3;
    public static final int VIRTUAL_DISPLAY_DPI = 400;
    @Nullable
    public CapturerObserver capturerObserver;
    public int height;
    public boolean isDisposed;
    @Nullable
    public MediaProjection mediaProjection;
    public final MediaProjection.Callback mediaProjectionCallback;
    @Nullable
    public MediaProjectionManager mediaProjectionManager;
    public final Intent mediaProjectionPermissionResultData;
    public long numCapturedFrames;
    @Nullable
    public SurfaceTextureHelper surfaceTextureHelper;
    @Nullable
    public VirtualDisplay virtualDisplay;
    public int width;

    public ScreenCapturerAndroid(Intent intent, MediaProjection.Callback callback) {
        this.mediaProjectionPermissionResultData = intent;
        this.mediaProjectionCallback = callback;
    }

    private void checkNotDisposed() {
        if (this.isDisposed) {
            throw new RuntimeException("capturer is disposed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createVirtualDisplay() {
        this.surfaceTextureHelper.setTextureSize(this.width, this.height);
        this.virtualDisplay = this.mediaProjection.createVirtualDisplay("WebRTC_ScreenCapture", this.width, this.height, 400, 3, new Surface(this.surfaceTextureHelper.getSurfaceTexture()), null, null);
    }

    @Override // org.webrtc.VideoCapturer
    public void changeCaptureFormat(int i2, int i3, int i4) {
        synchronized (this) {
            checkNotDisposed();
            this.width = i2;
            this.height = i3;
            if (this.virtualDisplay == null) {
                return;
            }
            ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new Runnable() { // from class: org.webrtc.ScreenCapturerAndroid.2
                @Override // java.lang.Runnable
                public void run() {
                    ScreenCapturerAndroid.this.virtualDisplay.release();
                    ScreenCapturerAndroid.this.createVirtualDisplay();
                }
            });
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void dispose() {
        synchronized (this) {
            this.isDisposed = true;
        }
    }

    public long getNumCapturedFrames() {
        return this.numCapturedFrames;
    }

    @Override // org.webrtc.VideoCapturer
    public void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        synchronized (this) {
            checkNotDisposed();
            if (capturerObserver == null) {
                throw new RuntimeException("capturerObserver not set.");
            }
            this.capturerObserver = capturerObserver;
            if (surfaceTextureHelper == null) {
                throw new RuntimeException("surfaceTextureHelper not set.");
            }
            this.surfaceTextureHelper = surfaceTextureHelper;
            this.mediaProjectionManager = (MediaProjectionManager) context.getSystemService("media_projection");
        }
    }

    @Override // org.webrtc.VideoCapturer
    public boolean isScreencast() {
        return true;
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        this.numCapturedFrames++;
        this.capturerObserver.onFrameCaptured(videoFrame);
    }

    @Override // org.webrtc.VideoCapturer
    public void startCapture(int i2, int i3, int i4) {
        synchronized (this) {
            checkNotDisposed();
            this.width = i2;
            this.height = i3;
            MediaProjection mediaProjection = this.mediaProjectionManager.getMediaProjection(-1, this.mediaProjectionPermissionResultData);
            this.mediaProjection = mediaProjection;
            mediaProjection.registerCallback(this.mediaProjectionCallback, this.surfaceTextureHelper.getHandler());
            createVirtualDisplay();
            this.capturerObserver.onCapturerStarted(true);
            this.surfaceTextureHelper.startListening(this);
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void stopCapture() {
        synchronized (this) {
            checkNotDisposed();
            ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new Runnable() { // from class: org.webrtc.ScreenCapturerAndroid.1
                @Override // java.lang.Runnable
                public void run() {
                    ScreenCapturerAndroid.this.surfaceTextureHelper.stopListening();
                    ScreenCapturerAndroid.this.capturerObserver.onCapturerStopped();
                    if (ScreenCapturerAndroid.this.virtualDisplay != null) {
                        ScreenCapturerAndroid.this.virtualDisplay.release();
                        ScreenCapturerAndroid.this.virtualDisplay = null;
                    }
                    if (ScreenCapturerAndroid.this.mediaProjection != null) {
                        ScreenCapturerAndroid.this.mediaProjection.unregisterCallback(ScreenCapturerAndroid.this.mediaProjectionCallback);
                        ScreenCapturerAndroid.this.mediaProjection.stop();
                        ScreenCapturerAndroid.this.mediaProjection = null;
                    }
                }
            });
        }
    }
}
