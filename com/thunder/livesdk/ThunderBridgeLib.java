package com.thunder.livesdk;

import android.view.MotionEvent;
import com.yy.mediaframework.YMFLiveAPI;
import com.yy.mediaframework.YYCamera;
import com.yy.mediaframework.facedetection.PreviewFrameCallback;
import com.yy.mediaframework.gpuimage.custom.IGPUProcess;
/* loaded from: classes6.dex */
public class ThunderBridgeLib {
    private ThunderBridgeLib() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class SingletonHolder {
        private static final ThunderBridgeLib INSTANCE = new ThunderBridgeLib();

        private SingletonHolder() {
        }
    }

    public static ThunderBridgeLib getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public boolean isCameraZoomSupport() {
        return YYCamera.getInstance().isZoomSupport();
    }

    public float getCameraMaxZoom() {
        return YYCamera.getInstance().getMaxZoom();
    }

    public float setCameraZoom(int i) {
        return YYCamera.getInstance().setZoom(i);
    }

    public void handleFocusMetering(MotionEvent motionEvent) {
        YYCamera.getInstance().handleFocusMetering(motionEvent);
    }

    public void setGPUImageProcessFilter(IGPUProcess iGPUProcess) {
        YMFLiveAPI.getInstance().setGPUImageBeautyFilter(iGPUProcess);
    }

    public void addPreviewFrameCallback(PreviewFrameCallback previewFrameCallback) {
        YMFLiveAPI.getInstance().addPreviewFrameCallback(previewFrameCallback);
    }

    public void removePreviewFrameCallback(PreviewFrameCallback previewFrameCallback) {
        YMFLiveAPI.getInstance().removePreviewFrameCallback(previewFrameCallback);
    }
}
