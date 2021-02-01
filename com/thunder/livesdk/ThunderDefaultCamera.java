package com.thunder.livesdk;

import android.view.MotionEvent;
import com.thunder.livesdk.ThunderPublisher;
import com.thunder.livesdk.log.ThunderLog;
/* loaded from: classes4.dex */
public class ThunderDefaultCamera extends ThunderVideoCapture {
    private ThunderPreviewConfig mCaptureConfig = new ThunderPreviewConfig(0);
    private IYYLiveDefaultCameraDataCallback mCameraDataCallback = null;

    /* loaded from: classes4.dex */
    public interface IYYLiveDefaultCameraDataCallback {
        int onTextureCallback(int i, int i2, int i3);
    }

    public void setCaptureConfig(ThunderPreviewConfig thunderPreviewConfig) {
        if (thunderPreviewConfig == null) {
            thunderPreviewConfig = new ThunderPreviewConfig(0);
        }
        ThunderLog.release(ThunderLog.kLogTagCall, "setCaptureConfig config:%s", thunderPreviewConfig.toString());
        this.mCaptureConfig = thunderPreviewConfig;
    }

    public void setCameraDataCallback(IYYLiveDefaultCameraDataCallback iYYLiveDefaultCameraDataCallback) {
        synchronized (this) {
            this.mCameraDataCallback = iYYLiveDefaultCameraDataCallback;
        }
    }

    public IYYLiveDefaultCameraDataCallback getCameraDataCallback() {
        IYYLiveDefaultCameraDataCallback iYYLiveDefaultCameraDataCallback;
        synchronized (this) {
            iYYLiveDefaultCameraDataCallback = this.mCameraDataCallback;
        }
        return iYYLiveDefaultCameraDataCallback;
    }

    public boolean isCameraZoomSupport() {
        return ThunderBridgeLib.getInstance().isCameraZoomSupport();
    }

    public float getCameraMaxZoom() {
        return ThunderBridgeLib.getInstance().getCameraMaxZoom();
    }

    public float setCameraZoom(int i) {
        return ThunderBridgeLib.getInstance().setCameraZoom(i);
    }

    public void handleFocusMetering(MotionEvent motionEvent) {
        ThunderBridgeLib.getInstance().handleFocusMetering(motionEvent);
    }

    @Override // com.thunder.livesdk.ThunderVideoCapture
    public void startCapture(ThunderPublisher.IVideoPublisher iVideoPublisher) {
    }

    @Override // com.thunder.livesdk.ThunderVideoCapture
    public void stopCapture() {
    }

    @Override // com.thunder.livesdk.ThunderVideoCapture
    public ThunderVideoCaptureConfig getCaptureConfig() {
        return this.mCaptureConfig;
    }
}
