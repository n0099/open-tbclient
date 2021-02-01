package com.yy.mediaframework;
/* loaded from: classes4.dex */
public class CameraPreviewConfig {
    public static final int DEFAULT_PREVIEW_FRAMERATE = 24;
    public static final int DEFAULT_PREVIEW_HEIGHT = 640;
    public static final int DEFAULT_PREVIEW_HIGH_FRAMERATE = 24;
    public static final int DEFAULT_PREVIEW_HIGH_HEIGHT = 1280;
    public static final int DEFAULT_PREVIEW_HIGH_WIDTH = 720;
    public static final int DEFAULT_PREVIEW_WIDTH = 480;
    public static final int PREVIEW_MODE_HIGHQULITY = 1;
    public static final int PREVIEW_MODE_NORMAL = 0;
    public int mCameraPosition;
    public int mCaptureFrameRate;
    public int mCaptureOrientation;
    public int mCaptureResolutionHeight;
    public int mCaptureResolutionWidth;
    public boolean mIsTorchOn;
    public float mZoomFactor;

    /* loaded from: classes4.dex */
    public enum CameraResolutionMode {
        CAMERA_RESOLUTION_PRECISE_MODE,
        CAMERA_RESOLUTION_RANGE_MODE
    }

    public CameraPreviewConfig() {
        this.mIsTorchOn = false;
        this.mZoomFactor = 1.0f;
        this.mCaptureResolutionWidth = 720;
        this.mCaptureResolutionHeight = 1280;
        this.mCaptureFrameRate = 24;
    }

    public CameraPreviewConfig(int i) {
        this.mIsTorchOn = false;
        this.mZoomFactor = 1.0f;
        if (i == 0) {
            this.mCaptureResolutionWidth = 480;
            this.mCaptureResolutionHeight = 640;
            this.mCaptureFrameRate = 24;
            return;
        }
        this.mCaptureResolutionWidth = 720;
        this.mCaptureResolutionHeight = 1280;
        this.mCaptureFrameRate = 24;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" mCaptureResolutionWidth:").append(this.mCaptureResolutionWidth);
        sb.append(" mCaptureResolutionHeight:").append(this.mCaptureResolutionHeight);
        sb.append(" mCaptureFrameRate:").append(this.mCaptureFrameRate);
        sb.append(" mCaptureOrientation:").append(this.mCaptureOrientation);
        sb.append(" mCameraPosition:").append(this.mCameraPosition);
        return sb.toString();
    }
}
