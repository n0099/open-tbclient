package com.thunder.livesdk.video;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import com.thunder.livesdk.ExternalVideoSource;
import com.thunder.livesdk.ThunderConstant;
import com.thunder.livesdk.ThunderDefaultCamera;
import com.thunder.livesdk.ThunderEngine;
import com.thunder.livesdk.ThunderExternalVideoFrame;
import com.thunder.livesdk.ThunderPreviewConfig;
import com.thunder.livesdk.ThunderPublisher;
import com.thunder.livesdk.ThunderRtcConstant;
import com.thunder.livesdk.ThunderScreenCapture;
import com.thunder.livesdk.ThunderVideoCapture;
import com.thunder.livesdk.helper.ThunderNative;
import com.thunder.livesdk.log.ThunderLog;
import com.thunder.livesdk.video.serviceConfig.VideoConfigManager;
import com.thunder.livesdk.video.serviceConfig.VideoLiveConfig;
import com.yy.mediaframework.CameraInterface;
import com.yy.mediaframework.CameraListener;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.IPublishListener;
import com.yy.mediaframework.ITextureListener;
import com.yy.mediaframework.YMFExternalFrame;
import com.yy.mediaframework.YMFLiveAPI;
import com.yy.mediaframework.YYVideoCodec;
import com.yy.mediaframework.api.YMFVideoEncodeFrame;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.base.VideoPublisheParam;
import com.yy.mediaframework.base.YMFLowStreamEncoderConfig;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import com.yy.mediaframework.model.Rect;
import com.yy.mediaframework.stat.IYMFBehaviorEventListener;
import com.yy.mediaframework.stat.IYMFExceptionListener;
import com.yy.mediaframework.stat.VideoDataStat;
import com.yy.mediaframework.stat.YMFLiveExceptionStat;
import com.yy.mediaframework.stat.YMFLiveExceptionType;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.stat.YMFLiveUsrBehaviorStat;
import com.yy.videoplayer.decoder.YYVideoLibMgr;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class ThunderVideoPublishEngineImp implements CameraListener, IPublishListener, ITextureListener, IYMFBehaviorEventListener, IYMFExceptionListener {
    private static final String TAG = "ThunderVideoPublishEngineImp";
    private static final int VIDEO_DYNAMIC_ENC_FRAME_RATE = 4;
    private static final int VIDEO_ENCODED_TYPE = 5;
    private static final int VIDEO_PREVIEW_FRAME_RATE = 3;
    private static final int VIDEO_STATE_RESOLUTION = 2;
    private static final int VIDEO_STAT_BITRATE = 1;
    private static final int VIDEO_STAT_FPS = 0;
    private static long mCallBackPtr = 0;
    private Handler mUiHandler;
    private YMFLiveAPI mPublisher = null;
    private ThunderVideoHiidoUtil mVideoPubHiidoUtil = null;
    private ThunderVideoCapture mCapture = null;
    private int mCaptureType = 0;
    private int mCameraState = 5;
    private float mCurZoomFactor = 0.0f;
    private boolean bStartEncode = false;
    private boolean bUserCallEncode = false;
    private boolean bStartCameraCapture = true;

    private native void onUpdateVideoSizeChanged(long j, long j2, int i, int i2);

    private native void onVideoAnchorStatus(long j, int i);

    private native void onVideoCaptureEncodeEvent(long j, int i);

    private native void onVideoCaptureExposureChanged(long j, float f, float f2, float f3, float f4);

    private native void onVideoCaptureFocusChanged(long j, float f, float f2, float f3, float f4);

    private native void onVideoCaptureStatus(long j, int i);

    private native void onVideoEncodedFrame(long j, byte[] bArr, int i, long j2, long j3, int i2, int i3, boolean z, int i4, int i5, int i6, byte[] bArr2, int i7);

    private native void onVideoFrameProcessTime(long j, float f, float f2);

    @Override // com.yy.mediaframework.IPublishListener
    public void onVideoAnchorStatus(Constant.AnchorStatus anchorStatus) {
        if (this.bUserCallEncode || anchorStatus != Constant.AnchorStatus.AnchorStatus_Encoding) {
            if (anchorStatus == Constant.AnchorStatus.AnchorStatus_Encoding) {
                this.bUserCallEncode = false;
            }
            if (mCallBackPtr != 0) {
                onVideoAnchorStatus(mCallBackPtr, anchorStatus.ordinal());
            }
        }
    }

    @Override // com.yy.mediaframework.IPublishListener
    public void onVideoFrameProcessTime(float f, float f2) {
        if (mCallBackPtr != 0) {
            onVideoFrameProcessTime(mCallBackPtr, f2, f);
        }
    }

    @Override // com.yy.mediaframework.IPublishListener
    public void onEncodeFrameData(YMFVideoEncodeFrame yMFVideoEncodeFrame) {
        int i = 1;
        boolean z = false;
        byte[] bArr = yMFVideoEncodeFrame.data;
        int i2 = yMFVideoEncodeFrame.len;
        int i3 = yMFVideoEncodeFrame.svcTid;
        int i4 = yMFVideoEncodeFrame.svcSid;
        int i5 = yMFVideoEncodeFrame.frameType;
        int i6 = yMFVideoEncodeFrame.streamId;
        long j = yMFVideoEncodeFrame.pts;
        long j2 = yMFVideoEncodeFrame.dts;
        VideoEncoderType videoEncoderType = yMFVideoEncodeFrame.encodeType;
        byte[] bArr2 = yMFVideoEncodeFrame.extraData;
        int i7 = yMFVideoEncodeFrame.extraDataLen;
        switch (videoEncoderType) {
            case SOFT_ENCODER_X264:
                z = false;
                i = 1;
                break;
            case HARD_ENCODER_H264:
                z = true;
                i = 1;
                break;
            case SOFT_ENCODER_H265:
                z = false;
                i = 2;
                break;
            case HARD_ENCODER_H265:
                z = true;
                i = 2;
                break;
            case DEFAULT:
            case ERROR:
                ThunderLog.warn(ThunderLog.kLogTagVideo, "unknown encoder type" + videoEncoderType.toString());
                break;
        }
        if (mCallBackPtr != 0) {
            onVideoEncodedFrame(mCallBackPtr, bArr, i2, j, j2, i5, i, z, i3, i4, i6, bArr2, i7);
        }
    }

    @Override // com.yy.mediaframework.IPublishListener
    public void onUpdateVideoSizeChanged(long j, int i, int i2) {
        if (mCallBackPtr != 0) {
            onUpdateVideoSizeChanged(mCallBackPtr, j, i, i2);
        }
    }

    @Override // com.yy.mediaframework.CameraListener
    public void notifyCameraPreviewParameter(int i, int i2, int i3, CameraInterface.CameraResolutionMode cameraResolutionMode) {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void notifyCameraOpenFail(String str) {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onDualOpen(boolean z) {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void notifyCameraOpenSuccess() {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onDualPictureSwitch() {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void reSetEncodingState() {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onCameraFocusAreaChanged(Rect rect) {
        onVideoCaptureFocusChanged(mCallBackPtr, rect.left, rect.top, rect.right - rect.left, rect.top - rect.bottom);
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onCameraExposureAreaChanged(Rect rect) {
        onVideoCaptureExposureChanged(mCallBackPtr, rect.left, rect.top, rect.right - rect.left, rect.top - rect.bottom);
    }

    @Override // com.yy.mediaframework.ITextureListener
    public int onTextureCallback(int i, int i2, int i3) {
        ThunderDefaultCamera defaluteCamera;
        return (this.mCapture == null || this.mCaptureType != 0 || (defaluteCamera = ThunderEngine.getDefaluteCamera()) == null || defaluteCamera.getCameraDataCallback() == null) ? i : defaluteCamera.getCameraDataCallback().onTextureCallback(i, i2, i3);
    }

    public ThunderVideoPublishEngineImp() {
        this.mUiHandler = null;
        this.mUiHandler = new Handler(Looper.getMainLooper());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: com.thunder.livesdk.video.ThunderVideoPublishEngineImp.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    YYVideoCodec.testSupportH264Encode();
                    YYVideoCodec.getSupportH265();
                } catch (Exception e) {
                    ThunderLog.error(ThunderVideoPublishEngineImp.TAG, "testVideoEncoderCrash crash " + e.toString());
                }
                countDownLatch.countDown();
            }
        }).start();
        try {
            countDownLatch.await(500L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            ThunderLog.error(TAG, "testVideoEncoderCrash waitSync crash " + e.toString());
        }
    }

    @Override // com.yy.mediaframework.stat.IYMFBehaviorEventListener
    public void onBehaviorEvent(String str, String str2, String str3, int i) {
        ThunderNative.makeBehaviorEvent(str, str2, str3, i);
    }

    @Override // com.yy.mediaframework.stat.IYMFExceptionListener
    public void onVideoLiveAbnormalStateNotification(YMFLiveExceptionType yMFLiveExceptionType) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "onVideoLiveAbnormalStateNotification:" + yMFLiveExceptionType);
        }
        if (mCallBackPtr != 0) {
            onVideoCaptureEncodeEvent(mCallBackPtr, yMFLiveExceptionType.getValue());
            if (yMFLiveExceptionType == YMFLiveExceptionType.AnchorStatus_CAPTURE_USED_BY_HIGHER_PRIORITY) {
                this.mCameraState = 3;
                onVideoCaptureStatus(mCallBackPtr, this.mCameraState);
            }
        }
    }

    public void pubInit() {
        this.mPublisher = YMFLiveAPI.getInstance();
        this.mVideoPubHiidoUtil = new ThunderVideoHiidoUtil(YYVideoLibMgr.instance().getAppContext());
        this.mPublisher.setPublishListener(this);
        this.mPublisher.setCameraListener(this);
        YMFLiveUsrBehaviorStat.getInstance().setYMFBehaviorEventListener(this);
        YMFLiveExceptionStat.getInstance().setYMFExceptionListener(this);
    }

    public boolean startVideoEngine() {
        return true;
    }

    public boolean stopVideoEngine() {
        return true;
    }

    public int attachVideoCapture(Object obj, int i) {
        if (this.mPublisher == null) {
            return ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR;
        }
        if (i == this.mCaptureType && (this.mCaptureType == 0 || this.mCaptureType == 1 || (this.mCaptureType == 2 && this.mCapture.equals(obj)))) {
            ThunderLog.error(TAG, "attachVideoCapture same captureType curType %d, newType %d", Integer.valueOf(this.mCaptureType), Integer.valueOf(i));
            return ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR;
        }
        if (this.bStartEncode) {
            if (this.mCapture == null || this.mCaptureType == 0) {
                this.mPublisher.stopEncodeVideo();
            } else if (this.mCapture != null && this.mCaptureType == 1) {
                this.mPublisher.stopEncodeScreen();
                this.mPublisher.stopScreenCapture();
            } else if (this.mCapture != null && this.mCaptureType == 2) {
                this.mPublisher.stopEncodeOrigin();
                this.mPublisher.stopOriginCapture();
                this.mCapture.stopCapture();
            }
        }
        this.mCaptureType = i;
        this.mCapture = (ThunderVideoCapture) obj;
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "attach capture: %s, type %d", this.mCapture.toString(), Integer.valueOf(this.mCaptureType));
        }
        if (this.bStartEncode) {
            this.mPublisher.setAbroadNetWorkStrategy(VideoConfigManager.instance().getAbroadNetWorkStrategy());
            this.mPublisher.notifyChangeVideoSourceState();
            if (this.mCapture != null && this.mCaptureType == 2) {
                if (((ExternalVideoSource) this.mCapture).getExternalVideoBuffType() == 2) {
                    this.mPublisher.startOriginCapture(true);
                } else {
                    this.mPublisher.startOriginCapture(false);
                }
                this.mCapture.startCapture(new ThunderPublisher.IVideoPublisher() { // from class: com.thunder.livesdk.video.ThunderVideoPublishEngineImp.2
                    @Override // com.thunder.livesdk.ThunderPublisher.IVideoPublisher
                    public void pushVideoData(byte[] bArr, int i2, int i3, int i4, int i5, long j) {
                        ThunderVideoPublishEngineImp.this.setOriginFrameToEncode(bArr, i2, i3, i4, i5, j);
                    }

                    @Override // com.thunder.livesdk.ThunderPublisher.IVideoPublisher
                    public void pushVideoData(byte[] bArr, ThunderConstant.ThunderVideoEncodeType thunderVideoEncodeType, long j, long j2) {
                    }

                    @Override // com.thunder.livesdk.ThunderPublisher.IVideoPublisher
                    public void pushVideoTexture(int i2, int i3, int i4, int i5, int i6, long j, float[] fArr) {
                        ThunderVideoPublishEngineImp.this.setOriginTextureToEncode(i2, i3, i4, i5, i6, j, fArr);
                    }

                    @Override // com.thunder.livesdk.ThunderPublisher.IVideoPublisher
                    public void pushVideoFrame(ThunderExternalVideoFrame thunderExternalVideoFrame) {
                        ThunderVideoPublishEngineImp.this.setExternalFrameToEncode(thunderExternalVideoFrame);
                    }
                });
                this.mPublisher.startEncodeOrigin();
            } else if (this.mCapture != null && this.mCaptureType == 1) {
                this.mPublisher.startScreenCapture(((ThunderScreenCapture) this.mCapture).getMediaProjection());
                this.mPublisher.startEncodeScreen();
            } else {
                this.mPublisher.startEncodeVideo();
            }
        }
        return 0;
    }

    public int startVideoCapture() {
        this.mCameraState = this.mPublisher.startVideoCapture();
        this.bStartCameraCapture = true;
        if (mCallBackPtr != 0) {
            onVideoCaptureStatus(mCallBackPtr, this.mCameraState);
        }
        return this.mCameraState;
    }

    public int stopVideoCapture() {
        this.mPublisher.stopVideoCapture();
        this.bStartCameraCapture = false;
        if (mCallBackPtr != 0 && this.mCameraState == 0) {
            onVideoCaptureStatus(mCallBackPtr, 5);
        }
        return 0;
    }

    public int pauseVideoCapture(boolean z) {
        this.mCameraState = this.mPublisher.pauseVideoCapture(z);
        return 0;
    }

    public int startPreview(final Object obj, int i) {
        if (obj != null && (obj instanceof ThunderPreviewView)) {
            if (((ThunderPreviewView) obj).checkViewType(this.mPublisher.getPreViewType())) {
                ThunderLog.warn(TAG, "startPreview: enableVideoPublishBufferProcess error!");
                CountDownLatch countDownLatch = new CountDownLatch(1);
                if (Thread.currentThread().getId() == this.mUiHandler.getLooper().getThread().getId()) {
                    ((ThunderPreviewView) obj).changeViewType();
                } else {
                    this.mUiHandler.post(new Runnable() { // from class: com.thunder.livesdk.video.ThunderVideoPublishEngineImp.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ((ThunderPreviewView) obj).changeViewType();
                        }
                    });
                    try {
                        countDownLatch.await();
                    } catch (Exception e) {
                        ThunderLog.error(TAG, "changeViewType waitSync crash " + e.toString());
                    }
                }
            }
            this.mPublisher.startPreview(((ThunderPreviewView) obj).getSurfaceView(), i);
            return 0;
        }
        this.mPublisher.startPreview(null, i);
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "startPreview: invalid view " + obj);
            return 0;
        }
        return 0;
    }

    public int stopPreview() {
        this.mPublisher.stopPreview();
        return 0;
    }

    public int setCaptureReplaceImage(Object obj) {
        return this.mPublisher.setCaptureReplaceImage((Bitmap) obj);
    }

    public Object captureLocalScreenShot() {
        return this.mPublisher.captureLocalScreenShot();
    }

    public int startEncodeVideo() {
        this.bUserCallEncode = true;
        this.mPublisher.setAbroadNetWorkStrategy(VideoConfigManager.instance().getAbroadNetWorkStrategy());
        if (this.mCapture != null && this.mCaptureType == 2) {
            if (((ExternalVideoSource) this.mCapture).getExternalVideoBuffType() == 2) {
                this.mPublisher.startOriginCapture(true);
            } else {
                this.mPublisher.startOriginCapture(false);
            }
            this.mCapture.startCapture(new ThunderPublisher.IVideoPublisher() { // from class: com.thunder.livesdk.video.ThunderVideoPublishEngineImp.4
                @Override // com.thunder.livesdk.ThunderPublisher.IVideoPublisher
                public void pushVideoData(byte[] bArr, int i, int i2, int i3, int i4, long j) {
                    ThunderVideoPublishEngineImp.this.setOriginFrameToEncode(bArr, i, i2, i3, i4, j);
                }

                @Override // com.thunder.livesdk.ThunderPublisher.IVideoPublisher
                public void pushVideoData(byte[] bArr, ThunderConstant.ThunderVideoEncodeType thunderVideoEncodeType, long j, long j2) {
                }

                @Override // com.thunder.livesdk.ThunderPublisher.IVideoPublisher
                public void pushVideoTexture(int i, int i2, int i3, int i4, int i5, long j, float[] fArr) {
                    ThunderVideoPublishEngineImp.this.setOriginTextureToEncode(i, i2, i3, i4, i5, j, fArr);
                }

                @Override // com.thunder.livesdk.ThunderPublisher.IVideoPublisher
                public void pushVideoFrame(ThunderExternalVideoFrame thunderExternalVideoFrame) {
                    ThunderVideoPublishEngineImp.this.setExternalFrameToEncode(thunderExternalVideoFrame);
                }
            });
            this.mPublisher.startEncodeOrigin();
        } else if (this.mCapture != null && this.mCaptureType == 1) {
            this.mPublisher.startScreenCapture(((ThunderScreenCapture) this.mCapture).getMediaProjection());
            this.mPublisher.startEncodeScreen();
        } else if (this.mCaptureType == 0) {
            this.mPublisher.startEncodeVideo();
        }
        this.bStartEncode = true;
        return 0;
    }

    public int stopEncodeVideo() {
        if (this.mCapture != null && this.mCaptureType == 2) {
            this.mPublisher.stopEncodeOrigin();
            this.mPublisher.stopOriginCapture();
            this.mCapture.stopCapture();
        } else if (this.mCapture != null && this.mCaptureType == 1) {
            this.mPublisher.stopEncodeScreen();
            this.mPublisher.stopScreenCapture();
        } else {
            this.mPublisher.stopEncodeVideo();
        }
        this.bStartEncode = false;
        return 0;
    }

    public void setPreviewRenderMode(int i) {
        this.mPublisher.setPreviewRenderMode(i);
    }

    public void changeScreenLiveMode(boolean z, Object obj) {
        if (this.mPublisher != null) {
            this.mPublisher.changeScreenLiveMode(Boolean.valueOf(z), (Bitmap) obj);
        }
    }

    public int updateVideoPublishConfig(VideoPublishParams videoPublishParams) {
        VideoPublisheParam videoPublisheParam = new VideoPublisheParam();
        videoPublisheParam.bLowLatency = videoPublishParams.bLowLatency;
        videoPublisheParam.bWebSdkCompatibility = videoPublishParams.bWebSdkCompatibility;
        videoPublisheParam.captureFrameRate = videoPublishParams.captureFrameRate;
        videoPublisheParam.captureResolutionWidth = videoPublishParams.captureResolutionWidth;
        videoPublisheParam.captureResolutionHeight = videoPublishParams.captureResolutionHeight;
        videoPublisheParam.screenOrientation = videoPublishParams.screenOrientation;
        videoPublisheParam.codecid = videoPublishParams.codecid;
        videoPublisheParam.encodeFrameRate = videoPublishParams.encodeFrameRate;
        videoPublisheParam.encodeBitrate = videoPublishParams.encodeBitrate * 1000;
        videoPublisheParam.encodeMaxBitrate = videoPublishParams.encodeMaxBitrate * 1000;
        videoPublisheParam.encodeMinBitrate = videoPublishParams.encodeMinBitrate * 1000;
        videoPublisheParam.encodeResolutionWidth = videoPublishParams.encodeResolutionWidth;
        videoPublisheParam.encodeResolutionHeight = videoPublishParams.encodeResolutionHeight;
        videoPublisheParam.weakNetConfigsIntervalSecs = videoPublishParams.weakNetConfigsIntervalSecs;
        videoPublisheParam.encodeType = switchVideoEncodeType(videoPublishParams.codecid);
        videoPublisheParam.bEnableLocalDualStreamMode = videoPublishParams.bEnableLocalDualStreamMode;
        videoPublisheParam.encoderParam = videoPublishParams.encoderParam;
        for (VideoPublishWeakNetParam videoPublishWeakNetParam : videoPublishParams.weakNetCfgs) {
            videoPublisheParam.weakNetConfigs.add(new ResolutionModifyConfig(videoPublishWeakNetParam.resolutionWidth, videoPublishWeakNetParam.resolutionHeight, videoPublishWeakNetParam.minCodeRate * 1000, videoPublishWeakNetParam.maxCodeRate * 1000, videoPublishWeakNetParam.minFrameRate, videoPublishWeakNetParam.maxFrameRate, switchVideoEncodeType(videoPublishWeakNetParam.codecid), videoPublishWeakNetParam.encoderParam));
        }
        for (VideoPublishLowStreamConfig videoPublishLowStreamConfig : videoPublishParams.lowStreamCfgs) {
            YMFLowStreamEncoderConfig yMFLowStreamEncoderConfig = new YMFLowStreamEncoderConfig();
            yMFLowStreamEncoderConfig.mConfigId = videoPublishLowStreamConfig.type;
            yMFLowStreamEncoderConfig.mEncoderId = videoPublishLowStreamConfig.codecid;
            yMFLowStreamEncoderConfig.mEncodeWidth = videoPublishLowStreamConfig.resolutionWidth;
            yMFLowStreamEncoderConfig.mEncodeHeight = videoPublishLowStreamConfig.resolutionHeight;
            yMFLowStreamEncoderConfig.mFrameRate = videoPublishLowStreamConfig.encodeFrameRate;
            yMFLowStreamEncoderConfig.mCodeRate = videoPublishLowStreamConfig.encodeCodeRate * 1000;
            yMFLowStreamEncoderConfig.mMaxCodeRate = videoPublishLowStreamConfig.maxCodeRate * 1000;
            yMFLowStreamEncoderConfig.mMinCodeRate = videoPublishLowStreamConfig.minCodeRate * 1000;
            yMFLowStreamEncoderConfig.mTranscoding = videoPublishLowStreamConfig.transcoding;
            yMFLowStreamEncoderConfig.mEncodeParam = videoPublishLowStreamConfig.encoderParam;
            videoPublisheParam.lowStreamConfigs.add(yMFLowStreamEncoderConfig);
        }
        this.mPublisher.updatePublisherConfig(videoPublisheParam);
        return 0;
    }

    public int setCameraPosition(int i) {
        ThunderDefaultCamera defaluteCamera = ThunderEngine.getDefaluteCamera();
        if (defaluteCamera != null) {
            ((ThunderPreviewConfig) defaluteCamera.getCaptureConfig()).cameraPosition = i;
            return this.mPublisher.setCameraPosition(i);
        }
        ThunderLog.warn(TAG, "setCameraPosition get null camera");
        return ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR;
    }

    public boolean setCameraTorchOn(boolean z) {
        if (this.mPublisher == null) {
            return false;
        }
        return this.mPublisher.setCameraTorchOn(z);
    }

    public boolean isCameraOpen() {
        if (this.mPublisher == null) {
            return false;
        }
        return this.mPublisher.isCameraOpen();
    }

    public boolean isCameraZoomSupported() {
        if (this.mPublisher == null) {
            return false;
        }
        return this.mPublisher.isCameraZoomSupported();
    }

    public float getCameraMaxZoomFactor() {
        if (this.mPublisher == null) {
            return -4001.0f;
        }
        return this.mPublisher.getCameraMaxZoomFactor();
    }

    public int setCameraZoomFactor(float f) {
        return this.mPublisher == null ? ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR : this.mPublisher.setCameraZoomFactor(f);
    }

    public boolean isCameraTorchSupported() {
        if (this.mPublisher == null) {
            return false;
        }
        return this.mPublisher.isCameraTorchSupported();
    }

    public boolean isCameraManualFocusPositionSupported() {
        if (this.mPublisher == null) {
            return false;
        }
        return this.mPublisher.isCameraManualFocusPositionSupported();
    }

    public int setCameraFocusPosition(float f, float f2) {
        return this.mPublisher == null ? ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR : this.mPublisher.setCameraFocusPosition(f, f2);
    }

    public boolean isCameraManualExposurePositionSupported() {
        if (this.mPublisher == null) {
            return false;
        }
        return this.mPublisher.isCameraManualExposurePositionSupported();
    }

    public int setCameraExposurePosition(float f, float f2) {
        return this.mPublisher == null ? ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR : this.mPublisher.setCameraExposurePosition(f, f2);
    }

    public boolean isCameraAutoFocusFaceModeSupported() {
        if (this.mPublisher == null) {
            return false;
        }
        return this.mPublisher.isCameraAutoFocusFaceModeSupported();
    }

    public int setCameraAutoFocusFaceModeEnabled(boolean z) {
        return this.mPublisher == null ? ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR : this.mPublisher.setCameraAutoFocusFaceModeEnabled(z);
    }

    public boolean isFrontCamera() {
        if (this.mPublisher == null) {
            return false;
        }
        return this.mPublisher.isFrontCamera();
    }

    public int getVideoCaptureOrientation() {
        return this.mPublisher == null ? ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR : this.mPublisher.getCameraOrientation();
    }

    public int setPubWatermark(int i, int i2, int i3, int i4, String str) {
        Exception e;
        Bitmap bitmap;
        Bitmap bitmap2;
        try {
            if (str != null) {
                try {
                    if (!str.isEmpty()) {
                        FileInputStream fileInputStream = new FileInputStream(str);
                        Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                        try {
                            fileInputStream.close();
                            int width = decodeStream.getWidth();
                            int height = decodeStream.getHeight();
                            Matrix matrix = new Matrix();
                            matrix.postScale(i3 / width, i4 / height);
                            bitmap = decodeStream;
                            bitmap2 = Bitmap.createBitmap(decodeStream, 0, 0, width, height, matrix, true);
                            return this.mPublisher.setWatermark(bitmap2, i, i2);
                        } catch (Exception e2) {
                            e = e2;
                            bitmap = decodeStream;
                            bitmap2 = null;
                            e.printStackTrace();
                            if (bitmap2 != null) {
                                bitmap2.recycle();
                            }
                            if (bitmap != null) {
                                bitmap.recycle();
                            }
                            return 0;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    bitmap = null;
                    bitmap2 = null;
                }
            }
            return this.mPublisher.setWatermark(bitmap2, i, i2);
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return 0;
        }
        bitmap = null;
        bitmap2 = null;
    }

    public int onDynamicBitrate(long j) {
        this.mPublisher.setNetworkBitrateSuggest(((int) j) * 1000);
        return 0;
    }

    public int setPublisherPtsAdjustVal(int i) {
        if (this.mPublisher != null) {
            this.mPublisher.setDeltaYYPtsMillions(i);
            return 0;
        }
        return 0;
    }

    public int setLocalVideoMirrorMode(int i) {
        return this.mPublisher == null ? ThunderRtcConstant.ThunderRet.THUNDER_RET_VIDEO_ENGINE_ERROR : this.mPublisher.setLocalVideoMirrorMode(i);
    }

    public float getCameraZoomFactor() {
        return this.mCurZoomFactor;
    }

    public int onRequestIFrame() {
        this.mPublisher.requestEncodeIFrame();
        return 0;
    }

    public void setVideoPublishEngineCallBack(long j) {
        mCallBackPtr = j;
    }

    public static String getVideoPubLibVersion() {
        return "200.3.3.101";
    }

    public String getAnchorHiidoStatInfo(long j) {
        String str = "";
        if (this.mVideoPubHiidoUtil != null) {
            ThunderVideoHiidoUtil thunderVideoHiidoUtil = this.mVideoPubHiidoUtil;
            str = ThunderVideoHiidoUtil.getAnchorStatInfo();
        }
        return VideoDataStat.getInstance().getAnchorVideoData(j) + str;
    }

    public int getPublishRuntimeInfo(int i, int i2) {
        switch (i) {
            case 0:
                return this.mPublisher.getVideoPublishInfo(YMFLiveAPI.VideoPublishInfoEnum.FRAME, i2);
            case 1:
                return this.mPublisher.getVideoPublishInfo(YMFLiveAPI.VideoPublishInfoEnum.BITRATE, i2);
            case 2:
                return this.mPublisher.getVideoPublishInfo(YMFLiveAPI.VideoPublishInfoEnum.RESOLUTION, i2);
            case 3:
                return this.mPublisher.getVideoPublishInfo(YMFLiveAPI.VideoPublishInfoEnum.PREVIEW_FRAME_RATE, i2);
            case 4:
                return this.mPublisher.getVideoPublishInfo(YMFLiveAPI.VideoPublishInfoEnum.DYNAMIC_ENC_FRAME_RATE, i2);
            case 5:
                int videoPublishInfo = this.mPublisher.getVideoPublishInfo(YMFLiveAPI.VideoPublishInfoEnum.ENCODETYPE, i2);
                if (VideoEncoderType.HARD_ENCODER_H264.ordinal() == videoPublishInfo || VideoEncoderType.HARD_ENCODER_H265.ordinal() == videoPublishInfo) {
                    return 1;
                }
                return (VideoEncoderType.SOFT_ENCODER_X264.ordinal() == videoPublishInfo || VideoEncoderType.SOFT_ENCODER_H265.ordinal() == videoPublishInfo) ? 2 : 0;
            default:
                return 0;
        }
    }

    public void notifyEncodeBlackList(String str) {
        if (!str.isEmpty()) {
            String[] split = str.split(",");
            for (int i = 0; i < split.length; i++) {
                if ((split[i].equalsIgnoreCase(YYVideoCodec.getH264EncodeName()) || split[i].equalsIgnoreCase(YYVideoCodec.getH265EncodeName())) && this.mPublisher != null) {
                    if (ThunderLog.isInfoValid()) {
                        ThunderLog.info(TAG, "notifyEncodeBlackList to videoLib, content: %s", split[i]);
                    }
                    this.mPublisher.setHardwareEncoderAvailable(false);
                }
            }
        }
    }

    public void checkPublishVideoConfigAvailable(VideoPublishConfig videoPublishConfig) {
        if (videoPublishConfig.codecid == 220 && YMFLiveAPI.getSupportH265EncodeProperty() != 1) {
            videoPublishConfig.codecid = 1;
            ThunderLog.error(TAG, "checkPublishVideoConfigAvailable THUNDERVIDEO_ENCODE_TYPE_H264");
        }
    }

    public int enableVideoPublishBufferProcess(boolean z) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "enableVideoPublishBufferProcess:" + z);
        }
        return this.mPublisher.setYuvCanvasMode(z);
    }

    public int setVideoCommonConfigMode(int i) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(TAG, "setVideoCommonConfigMode:" + i);
        }
        return this.mPublisher.setVideoCommonConfigMode(i);
    }

    public void updateArgoConfig(HashMap<String, String> hashMap) {
        if (!hashMap.isEmpty()) {
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(TAG, "updateArgoConfig:" + hashMap);
            }
            this.mPublisher.setVideoUpCommonConfig(hashMap);
        }
    }

    public void destroyPublishEngine() {
        YMFLiveUsrBehaviorStat.getInstance().setYMFBehaviorEventListener(null);
        if (this.mPublisher != null) {
            this.mPublisher.destory();
        }
        reset();
    }

    private void reset() {
        this.mCaptureType = 0;
        this.mCameraState = 5;
        this.bStartEncode = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExternalFrameToEncode(ThunderExternalVideoFrame thunderExternalVideoFrame) {
        if (this.mPublisher != null && thunderExternalVideoFrame != null) {
            YMFExternalFrame yMFExternalFrame = new YMFExternalFrame();
            yMFExternalFrame.data = thunderExternalVideoFrame.data;
            yMFExternalFrame.format = thunderExternalVideoFrame.format;
            yMFExternalFrame.width = thunderExternalVideoFrame.width;
            yMFExternalFrame.height = thunderExternalVideoFrame.height;
            yMFExternalFrame.textureID = thunderExternalVideoFrame.textureID;
            yMFExternalFrame.textureFormat = thunderExternalVideoFrame.textureFormat;
            yMFExternalFrame.rotation = thunderExternalVideoFrame.rotation;
            yMFExternalFrame.transform = thunderExternalVideoFrame.transform;
            yMFExternalFrame.scaleMode = thunderExternalVideoFrame.scaleMode;
            yMFExternalFrame.timeStamp = thunderExternalVideoFrame.timeStamp;
            this.mPublisher.setOriginExternalFrameToEncode(yMFExternalFrame);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOriginFrameToEncode(byte[] bArr, int i, int i2, int i3, int i4, long j) {
        if (this.mPublisher != null) {
            this.mPublisher.setOriginFrameToEncode(bArr, i, i2, i3, i4, j, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOriginTextureToEncode(int i, int i2, int i3, int i4, int i5, long j, float[] fArr) {
        if (this.mPublisher != null) {
            this.mPublisher.setOriginTextureToEncode(i, i2, i3, i4, i5, j, fArr, 1);
        }
    }

    private VideoEncoderType switchVideoEncodeType(int i) {
        VideoEncoderType videoEncoderType = VideoEncoderType.DEFAULT;
        switch (i) {
            case 200:
                return VideoEncoderType.HARD_ENCODER_H264;
            case 201:
                return VideoEncoderType.SOFT_ENCODER_X264;
            case VideoLiveConfig.EncodeType.PHONE_CODEC_HW_H265 /* 220 */:
                return VideoEncoderType.HARD_ENCODER_H265;
            case VideoLiveConfig.EncodeType.PHONE_CODEC_X265 /* 221 */:
                return VideoEncoderType.SOFT_ENCODER_H265;
            default:
                return VideoEncoderType.DEFAULT;
        }
    }

    /* loaded from: classes4.dex */
    public class VideoPublishParams {
        public boolean bEnableLocalDualStreamMode;
        public boolean bLowLatency;
        public boolean bWebSdkCompatibility;
        public int captureFrameRate;
        public int captureResolutionHeight;
        public int captureResolutionWidth;
        public int codecid;
        public int encodeBitrate;
        public int encodeFrameRate;
        public int encodeMaxBitrate;
        public int encodeMinBitrate;
        public int encodeResolutionHeight;
        public int encodeResolutionWidth;
        public String encoderParam;
        public int screenOrientation;
        public int weakNetConfigsIntervalSecs;
        public List<VideoPublishWeakNetParam> weakNetCfgs = new ArrayList();
        public List<VideoPublishLowStreamConfig> lowStreamCfgs = new ArrayList();

        public VideoPublishParams() {
        }
    }

    /* loaded from: classes4.dex */
    public class VideoPublishWeakNetParam {
        public int codecid;
        public String encoderParam;
        public int maxCodeRate;
        public int maxFrameRate;
        public int minCodeRate;
        public int minFrameRate;
        public int resolutionHeight;
        public int resolutionWidth;

        public VideoPublishWeakNetParam() {
        }
    }

    /* loaded from: classes4.dex */
    public class VideoPublishLowStreamConfig {
        public int codecid;
        public int encodeCodeRate;
        public int encodeFrameRate;
        public String encoderParam;
        public int maxCodeRate;
        public int minCodeRate;
        public int resolutionHeight;
        public int resolutionWidth;
        public int transcoding;
        public int type;

        public VideoPublishLowStreamConfig() {
        }
    }

    public String getVideoEncodeBaseStatics(int i) {
        return YMFLiveStatisticManager.getInstance().getBaseUploadVideoStatistics(i);
    }

    public String getVideoEncodeStatics(boolean z, int i) {
        String str = "";
        if (this.mVideoPubHiidoUtil != null) {
            ThunderVideoHiidoUtil thunderVideoHiidoUtil = this.mVideoPubHiidoUtil;
            str = ThunderVideoHiidoUtil.getAnchorStatInfo();
        }
        return YMFLiveStatisticManager.getInstance().getUploadVideoStatistics(z, i) + str;
    }
}
