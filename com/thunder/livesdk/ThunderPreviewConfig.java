package com.thunder.livesdk;
/* loaded from: classes4.dex */
public class ThunderPreviewConfig extends ThunderVideoCaptureConfig {
    public static final int YYPREVIEW_MODE_HIGHQULITY = 1;
    public static final int YYPREVIEW_MODE_NORMAL = 0;
    public int cameraPosition;
    public int captureOrientation;
    public int playType;
    public int previewMode;

    public ThunderPreviewConfig() {
        this.playType = 0;
        this.previewMode = -1;
        this.captureOrientation = 0;
    }

    @Deprecated
    public ThunderPreviewConfig(int i) {
        if (i == 0) {
            this.captureResolutionWidth = 480;
            this.captureResolutionHeight = 640;
            this.captureFrameRate = 24;
            this.captureOrientation = 0;
        } else {
            this.captureResolutionWidth = 720;
            this.captureResolutionHeight = 1280;
            this.captureFrameRate = 24;
            this.captureOrientation = 0;
        }
        this.playType = 0;
        this.previewMode = i;
    }

    public String toString() {
        return "{captureResolutionWidth:" + this.captureResolutionWidth + " captureResolutionHeight:" + this.captureResolutionHeight + " captureFrameRate:" + this.captureFrameRate + " captureOrientation:" + this.captureOrientation + " cameraPosition:" + this.cameraPosition + " playType:" + this.playType + " previewMode:" + this.previewMode + "}";
    }
}
