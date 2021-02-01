package com.yy.mediaframework.stat;

import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.base.VideoPublisheParam;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes4.dex */
public class YMFLiveUsrBehaviorStat {
    private static YMFLiveUsrBehaviorStat mInstance;
    private String tag = "YMFLive";
    public IYMFBehaviorEventListener mBehaviorListener = null;

    /* loaded from: classes4.dex */
    private interface UsrBehaviorStatInfoKey {
        public static final String CallApi = "callApi";
        public static final String CameraCaptureState = "cameraState";
        public static final String CaptureState = "captureState";
        public static final String EncodeState = "encodeState";
        public static final String FirstFrameEncode = "firstFrameEncode";
        public static final String FirstFrameRendered = "firstFrameRendered";
        public static final String GlManagerCheck = "glManagerCheck";
        public static final String GlManagerState = "glManagerState";
        public static final String LiveException = "liveException";
        public static final String LowDelayFlagChange = "lowDelayFlagChange";
        public static final String PauseVideoCapture = "pauseVideoCapture";
        public static final String PreviewState = "previewState";
        public static final String PreviewViewOnSurfaceState = "viewDisplayState";
        public static final String SetGPUImageBeautyFilter = "setGPUImageBeautyFilter";
        public static final String SetVideoMirrorMode = "setVideoMirrorMode";
        public static final String SetWaterMark = "setWaterMark";
        public static final String SwitchCamera = "cameraSwitch";
        public static final String UpdatePublisherConfig = "updatePublisherConfig";
        public static final String VideoEncoderState = "encoderState";
        public static final String VideoEncodingState = "encodingState";
        public static final String VideoPreviewViewState = "viewState";
    }

    public static YMFLiveUsrBehaviorStat getInstance() {
        if (mInstance == null) {
            mInstance = new YMFLiveUsrBehaviorStat();
        }
        return mInstance;
    }

    public void setYMFBehaviorEventListener(IYMFBehaviorEventListener iYMFBehaviorEventListener) {
        this.mBehaviorListener = iYMFBehaviorEventListener;
    }

    public String convertTypeToString(VideoEncoderType videoEncoderType) {
        switch (videoEncoderType) {
            case SOFT_ENCODER_X264:
                return "0";
            case HARD_ENCODER_H264:
                return "1";
            case SOFT_ENCODER_H265:
                return "2";
            case HARD_ENCODER_H265:
                return "3";
            case DEFAULT:
                return "4";
            case ERROR:
                return "5";
            default:
                return "6";
        }
    }

    public void notifyVideoEncodingState(boolean z) {
        YMFLog.info(this, "[Encoder ]", "upload usrBehavior notifyVideoEncodingState:" + z);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, UsrBehaviorStatInfoKey.VideoEncodingState, z ? "1" : "0", 1);
        }
    }

    public void notifyCameraCaptureState(boolean z) {
        YMFLog.info(this, "[CCapture]", "upload usrBehavior notifyCameraCaptureState:" + z);
        if (this.mBehaviorListener != null) {
        }
    }

    public void notifyVideoEncoderState(VideoEncoderType videoEncoderType, boolean z) {
        YMFLog.info(this, "[Encoder ]", "upload usrBehavior notifyVideoEncoderState, type:" + convertTypeToString(videoEncoderType) + " state:" + z);
        if (this.mBehaviorListener != null) {
        }
    }

    public void notifyVideoPreviewViewState(boolean z) {
        YMFLog.info(this, "[Preview ]", "upload usrBehavior notifyVideoPreviewViewState:" + z);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, "viewState", z ? "1" : "0", 1);
        }
    }

    public void notifyVideoGlManagerState(int i, boolean z) {
        YMFLog.info(this, "[Procedur]", "upload usrBehavior notifyVideoGlManagerState, type:" + i + " state:" + z);
        if (this.mBehaviorListener != null) {
        }
    }

    public void notifyPreviewViewOnSurfaceState(boolean z, int i, int i2) {
        YMFLog.info(this, "[Procedur]", "upload usrBehavior notifyPreviewViewOnSurfaceState:" + z + " width:" + i + " height:" + i2);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, "viewDisplayState", "state:" + (z ? "1" : "0") + ",width:" + i + ",height:" + i2, 1);
        }
    }

    public void notifyLiveException(String str) {
        YMFLog.info(this, "[Procedur]", "upload usrBehavior notifyLiveException:" + str);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, UsrBehaviorStatInfoKey.LiveException, str, 1);
        }
    }

    public void notifySwitchCamera(boolean z) {
        YMFLog.info(this, "[Procedur]", "upload usrBehavior notifySwitchCamera:" + z);
        if (this.mBehaviorListener != null) {
        }
    }

    public void notifyGlManagerCheck(String str) {
        YMFLog.info(this, "[Procedur]", "upload usrBehavior notifyGlManagerStateCheck, stack:" + str);
        if (this.mBehaviorListener != null) {
        }
    }

    public void notifyCallApi(String str) {
        YMFLog.info(this, "[Procedur]", "upload usrBehavior notifyCallApi, apiNameAndConfig:" + str);
        if (this.mBehaviorListener != null) {
        }
    }

    public void notifyFirstFrameEncode(long j) {
        YMFLog.info(this, "[Encoder ]", "upload usrBehavior notifyFirstFrameEncode, pts:" + j);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, UsrBehaviorStatInfoKey.FirstFrameEncode, "pts:" + j + ",systemTime:" + System.currentTimeMillis(), 1);
        }
    }

    public void notifyFirstFrameRendered() {
        YMFLog.info(this, "[Encoder ]", "upload usrBehavior notifyFirstFrameRendered");
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, "firstFrameRendered", "systemTime:" + System.currentTimeMillis(), 1);
        }
    }

    public void notifyLowDelayFlagChange(boolean z, boolean z2) {
        YMFLog.info(this, "[Encoder ]", "upload usrBehavior notifyLowDelayFlagChange, oldFlag:" + z + " newFlag:" + z2);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, UsrBehaviorStatInfoKey.LowDelayFlagChange, "oldFlag:" + z + ",newFlag:" + z2, 1);
        }
    }

    public void notifyCaptureState(int i, boolean z) {
        YMFLog.info(this, "[Procedur]", "upload usrBehavior notifyVideoCaptureState, captureType:" + i + "state:" + z);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, UsrBehaviorStatInfoKey.CaptureState, "captureType:" + i + ",state:" + (z ? "1" : "0"), 1);
        }
    }

    public void notifyPauseVideoCapture(boolean z) {
        YMFLog.info(this, "[Procedur]", "upload usrBehavior notifyPauseVideoCapture, bPauseCapture:" + z);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, UsrBehaviorStatInfoKey.PauseVideoCapture, z ? "1" : "0", 1);
        }
    }

    public void notifyPreviewState(boolean z, int i) {
        YMFLog.info(this, "[Procedur]", "upload usrBehavior notifyPreviewState, state:" + z + " renderMode" + i);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, UsrBehaviorStatInfoKey.PreviewState, "state:" + (z ? "1" : "0") + ",renderMode:" + i, 1);
        }
    }

    public void notifyEncodeState(int i, boolean z) {
        YMFLog.info(this, "[Procedur]", "upload usrBehavior notifyEncodeState, encodeType:" + i + " state:" + z);
        if (this.mBehaviorListener != null) {
            this.mBehaviorListener.onBehaviorEvent(this.tag, UsrBehaviorStatInfoKey.EncodeState, "encodeType:" + i + ",state:" + (z ? "1" : "0"), 1);
        }
    }

    public void notifySetVideoMirrorMode(int i) {
        YMFLog.info(this, "[Procedur]", "upload usrBehavior notifySetVideoMirrorMode, mode:" + i);
        if (this.mBehaviorListener != null) {
        }
    }

    public void notifySetWaterMark(boolean z, int i, int i2) {
        YMFLog.info(this, "[Procedur]", "upload usrBehavior notifySetWaterMark, bitmap == null:" + z + " offsetX:" + i + " offsetY:" + i2);
        if (this.mBehaviorListener != null) {
        }
    }

    public void notifySetGPUImageBeautyFilter(boolean z) {
        YMFLog.info(this, "[Procedur]", "upload usrBehavior notifySetGPUImageBeautyFilter, filter == null:" + z);
        if (this.mBehaviorListener != null) {
        }
    }

    public void notifyUpdatePublisherConfig(VideoPublisheParam videoPublisheParam) {
        YMFLog.info(this, "[Procedur]", "upload usrBehavior notifyUpdatePublisherConfig, config:" + videoPublisheParam.toString());
        if (this.mBehaviorListener != null) {
        }
    }
}
