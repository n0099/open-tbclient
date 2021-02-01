package com.yy.mediaframework;

import com.yy.mediaframework.CameraInterface;
import com.yy.mediaframework.model.Rect;
/* loaded from: classes4.dex */
public interface CameraListener {
    void notifyCameraOpenFail(String str);

    void notifyCameraOpenSuccess();

    void notifyCameraPreviewParameter(int i, int i2, int i3, CameraInterface.CameraResolutionMode cameraResolutionMode);

    void onCameraExposureAreaChanged(Rect rect);

    void onCameraFocusAreaChanged(Rect rect);

    void onDualOpen(boolean z);

    void onDualPictureSwitch();

    void reSetEncodingState();
}
