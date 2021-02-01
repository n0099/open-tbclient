package com.yy.mediaframework;

import android.graphics.Bitmap;
import android.hardware.Camera;
import android.media.projection.MediaProjection;
import android.opengl.EGL14;
import android.os.Build;
import android.view.SurfaceView;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import com.thunder.livesdk.ThunderRtcConstant;
import com.yy.mediaframework.CameraInterface;
import com.yy.mediaframework.CameraUtils;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.api.IYMFEncoderStatisticListener;
import com.yy.mediaframework.api.YMFEncoderStatisticInfo;
import com.yy.mediaframework.api.YMFVideoEncodeFrame;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoPublisheParam;
import com.yy.mediaframework.base.YMFLowStreamEncoderConfig;
import com.yy.mediaframework.facedetection.PreviewFrameCallback;
import com.yy.mediaframework.gpuimage.FilterType;
import com.yy.mediaframework.gpuimage.custom.IGPUProcess;
import com.yy.mediaframework.model.Rect;
import com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud;
import com.yy.mediaframework.screenshot.ScreenShotCallback;
import com.yy.mediaframework.stat.VideoDataStat;
import com.yy.mediaframework.stat.VideoDataStatUtil;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.stat.YMFLiveUsrBehaviorStat;
import com.yy.mediaframework.utils.YMFLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
/* loaded from: classes4.dex */
public class YMFLiveAPI implements CameraListener, IEncoderListener, IYMFDeliverCallback {
    private static final String TAG = "[YMFLiveAPI]";
    private static YMFLiveAPI mInstance;
    private CameraListener mCameraListener;
    private CameraPreviewConfig mCameraPreviewConfig;
    private IYMFEncoderStatisticListener mIEncoderStatisticListener;
    private IPublishListener mIPublishListener;
    private VideoPublisheParam mUploadParams;
    private VideoEncoderConfig mVideoEncoderConfig;
    private VideoLiveSessionYCloud mVideoLiveSessionYCloud = null;
    private ScreenLiveSessionYCloud mScreenLiveSessionYCloud = null;
    private YMFExternalTextureSessionYCloud mExternalVideoLiveSessionYCloud = null;
    private List<YMFEncoderStatisticInfo> mEncoderStatInfoList = null;
    private int mNotifyResolutioWidth = 0;
    private int mNotifyResolutioHeight = 0;
    private int mNotifyLowStreamResolutioWidth = 0;
    private int mNotifyLowStreamResolutioHeight = 0;
    private SurfaceView mCameraSurfaceView = null;
    private boolean mNeedCheckCameraCfgFlag = false;
    private boolean mAnchorStatusPreviewingCallback = true;
    private boolean mCameraOpened = false;
    private boolean mNeedRestartCaptureFlag = false;
    private boolean mNeedCheckEncoderCfgFlag = false;
    private boolean mNeedRestartEncoderFlag = false;
    private boolean mNeedLowDelayChangeFlag = false;
    private long mFrameCount = 0;
    private Bitmap mLocalBitmap = null;
    private boolean mOnlyRestartCapture = false;
    private Constant.EncodedStream mEncodedStreamFlag = Constant.EncodedStream.NoneStream;
    private boolean mCameraCapturePauseFlag = false;
    private boolean mScreenCaptureFlag = false;
    private boolean mOriginCaptureFlag = false;
    private boolean mUserForceMode = false;
    private Object mDataAsyncLock = new Object();
    private Bitmap mCaptureReplaceBitmap = null;
    private boolean mOriginCaptureInputTexture = false;
    private long mOriginFrameLastTimeStamp = -1;

    /* loaded from: classes4.dex */
    public enum VideoPublishInfoEnum {
        FRAME,
        BITRATE,
        RESOLUTION,
        DYNAMIC_ENC_FRAME_RATE,
        PREVIEW_FRAME_RATE,
        ENCODETYPE,
        CAPTUREMODE,
        PRRVIEWTYPE,
        CAPTUREFPSMODE,
        CAPTUREFPS,
        SETCAPTUREFPS,
        YUVTEXTUREMODE
    }

    public static YMFLiveAPI getInstance() {
        if (mInstance == null) {
            mInstance = new YMFLiveAPI();
        }
        return mInstance;
    }

    private YMFLiveAPI() {
    }

    public void setPublishListener(IPublishListener iPublishListener) {
        synchronized (this) {
            YMFLog.info(this, "[Procedur]", "setPublishListener:" + iPublishListener);
            YMFLiveUsrBehaviorStat.getInstance().notifyCallApi("setPublishListener:" + (iPublishListener == null ? "0" : "1"));
            this.mIPublishListener = iPublishListener;
        }
    }

    public void setEncoderStatisticListener(IYMFEncoderStatisticListener iYMFEncoderStatisticListener) {
        this.mIEncoderStatisticListener = iYMFEncoderStatisticListener;
    }

    public void setCameraListener(CameraListener cameraListener) {
        this.mCameraListener = cameraListener;
    }

    public void destory() {
        synchronized (this) {
            YMFLog.info(this, "[Encoder ]", "destory");
            this.mAnchorStatusPreviewingCallback = true;
            if (this.mNeedCheckEncoderCfgFlag) {
                if (this.mEncodedStreamFlag == Constant.EncodedStream.ScreenStream) {
                    stopEncodeScreen();
                } else if (this.mEncodedStreamFlag == Constant.EncodedStream.OriginStream) {
                    stopEncodeOrigin();
                } else if (this.mEncodedStreamFlag == Constant.EncodedStream.CameraStream) {
                    stopEncodeVideo();
                }
            }
            if (this.mNeedCheckCameraCfgFlag) {
                if (this.mScreenCaptureFlag) {
                    stopScreenCapture();
                }
                if (this.mOriginCaptureFlag) {
                    stopOriginCapture();
                }
                if (this.mNeedCheckCameraCfgFlag) {
                    this.mVideoLiveSessionYCloud.setPreviewSurfaceView(null);
                    stopVideoCapture();
                }
            }
            if (this.mVideoLiveSessionYCloud != null) {
                deInitVideoLiveSession();
            }
            if (this.mScreenLiveSessionYCloud != null) {
                deInitScreenSession();
            }
            if (this.mExternalVideoLiveSessionYCloud != null) {
                deInitOriginLiveSession();
            }
            this.mCaptureReplaceBitmap = null;
            resetUploadStreamParams();
        }
    }

    public boolean updatePublisherConfig(VideoPublisheParam videoPublisheParam) {
        synchronized (this) {
            YMFLog.info(this, "[Encoder ]", "updatePublisherConfig:" + videoPublisheParam.toString());
            YMFLiveUsrBehaviorStat.getInstance().notifyUpdatePublisherConfig(videoPublisheParam);
            if (this.mUploadParams == null) {
                this.mUploadParams = new VideoPublisheParam();
            }
            this.mUploadParams.assign(videoPublisheParam);
            if (UploadStreamStateParams.mCaptureFpsMode == Constant.CaptureFpsMode.AlignEncoder) {
                this.mUploadParams.captureFrameRate = this.mUploadParams.encodeFrameRate + 2;
                YMFLog.info(this, "[Encoder ]", "updatePublisherConfig AlignEncoder mode,change captureFps " + this.mUploadParams.captureFrameRate + PerfFrameTrackUIUtil.SEPERATOR_ARROR + this.mUploadParams.encodeFrameRate);
            }
            disassembleUploadParams();
            if (this.mCameraPreviewConfig != null) {
                this.mCameraPreviewConfig.mZoomFactor = 0.0f;
                this.mCameraPreviewConfig.mIsTorchOn = false;
            }
            if (this.mNeedRestartEncoderFlag) {
                YMFLog.info(this, "[Encoder ]", "updatePublisherConfig restart encoder:" + this.mVideoEncoderConfig);
                if (this.mEncodedStreamFlag == Constant.EncodedStream.CameraStream) {
                    this.mVideoLiveSessionYCloud.setEncoderListener(null);
                    this.mVideoLiveSessionYCloud.stopEncoder();
                    if (this.mNeedRestartCaptureFlag) {
                        this.mVideoLiveSessionYCloud.mTmpVideoEncoderConfig = this.mVideoEncoderConfig;
                        YYCamera.getInstance().changePreviewParameter(this.mCameraPreviewConfig.mCaptureResolutionWidth, this.mCameraPreviewConfig.mCaptureResolutionHeight, this.mCameraPreviewConfig.mCaptureFrameRate, this.mCameraPreviewConfig.mCameraPosition == 0 ? CameraUtils.CameraFacing.FacingFront : CameraUtils.CameraFacing.FacingBack, this.mCameraPreviewConfig.mCaptureOrientation, CameraInterface.CameraResolutionMode.CAMERA_RESOLUTION_RANGE_MODE);
                        this.mVideoLiveSessionYCloud.enablePreviewMirror(UploadStreamStateParams.mPreviewMirror);
                        this.mVideoLiveSessionYCloud.enableMirror(UploadStreamStateParams.mEncoderMirror);
                        this.mNeedRestartCaptureFlag = false;
                    } else {
                        this.mVideoLiveSessionYCloud.setEncoderConfig(this.mVideoEncoderConfig);
                    }
                    this.mVideoLiveSessionYCloud.setLowStreamEncoderConfigs(this.mUploadParams.lowStreamConfigs, this.mUploadParams.bEnableLocalDualStreamMode);
                    this.mVideoLiveSessionYCloud.setEncoderListener(this);
                    this.mVideoLiveSessionYCloud.startEncoder();
                    if (this.mVideoLiveSessionYCloud != null && UploadStreamStateParams.mWaterMarkBitmap != null) {
                        this.mVideoLiveSessionYCloud.setWaterMark(UploadStreamStateParams.mWaterMarkBitmap, UploadStreamStateParams.mOffsetX, UploadStreamStateParams.mOffsetY);
                    }
                    if (this.mUploadParams.weakNetConfigs != null && this.mUploadParams.weakNetConfigs.size() > 0) {
                        this.mVideoLiveSessionYCloud.setResolutionModifyConfigs(this.mUploadParams.weakNetConfigs, this.mUploadParams.weakNetConfigsIntervalSecs);
                        this.mVideoLiveSessionYCloud.setAbroadNetWorkStrategy(UploadStreamStateParams.mNetWorkStrategy);
                    }
                    this.mVideoLiveSessionYCloud.enableMirror(UploadStreamStateParams.mEncoderMirror);
                } else if (this.mEncodedStreamFlag == Constant.EncodedStream.ScreenStream) {
                    this.mScreenLiveSessionYCloud.setEncoderListener(null);
                    this.mScreenLiveSessionYCloud.stopEncoder();
                    this.mScreenLiveSessionYCloud.setEncoderConfig(this.mVideoEncoderConfig);
                    this.mScreenLiveSessionYCloud.setLowStreamEncoderConfigs(this.mUploadParams.lowStreamConfigs, this.mUploadParams.bEnableLocalDualStreamMode);
                    this.mScreenLiveSessionYCloud.setCaptureResolution(this.mVideoEncoderConfig.mEncodeWidth, this.mVideoEncoderConfig.mEncodeHeight);
                    this.mScreenLiveSessionYCloud.setEncoderListener(this);
                    this.mScreenLiveSessionYCloud.startEncoder();
                    if (this.mScreenLiveSessionYCloud != null && UploadStreamStateParams.mWaterMarkBitmap != null) {
                        this.mScreenLiveSessionYCloud.setWaterMark(UploadStreamStateParams.mWaterMarkBitmap, UploadStreamStateParams.mOffsetX, UploadStreamStateParams.mOffsetY);
                    }
                    if (this.mUploadParams.weakNetConfigs != null && this.mUploadParams.weakNetConfigs.size() > 0) {
                        this.mScreenLiveSessionYCloud.setResolutionModifyConfigs(this.mUploadParams.weakNetConfigs, this.mUploadParams.weakNetConfigsIntervalSecs);
                        this.mScreenLiveSessionYCloud.setAbroadNetWorkStrategy(UploadStreamStateParams.mNetWorkStrategy);
                    }
                } else if (this.mEncodedStreamFlag == Constant.EncodedStream.OriginStream && this.mExternalVideoLiveSessionYCloud != null) {
                    this.mExternalVideoLiveSessionYCloud.setEncoderListener(null);
                    this.mExternalVideoLiveSessionYCloud.stopEncoder();
                    this.mExternalVideoLiveSessionYCloud.setEncoderConfig(this.mVideoEncoderConfig);
                    this.mExternalVideoLiveSessionYCloud.setLowStreamEncoderConfigs(this.mUploadParams.lowStreamConfigs, this.mUploadParams.bEnableLocalDualStreamMode);
                    this.mExternalVideoLiveSessionYCloud.setEncoderListener(this);
                    this.mExternalVideoLiveSessionYCloud.startEncoder();
                    if (this.mExternalVideoLiveSessionYCloud != null && UploadStreamStateParams.mWaterMarkBitmap != null) {
                        this.mExternalVideoLiveSessionYCloud.setWaterMark(UploadStreamStateParams.mWaterMarkBitmap, UploadStreamStateParams.mOffsetX, UploadStreamStateParams.mOffsetY);
                    }
                    if (this.mUploadParams.weakNetConfigs != null && this.mUploadParams.weakNetConfigs.size() > 0) {
                        this.mExternalVideoLiveSessionYCloud.setResolutionModifyConfigs(this.mUploadParams.weakNetConfigs, this.mUploadParams.weakNetConfigsIntervalSecs);
                        this.mExternalVideoLiveSessionYCloud.setAbroadNetWorkStrategy(UploadStreamStateParams.mNetWorkStrategy);
                    }
                }
                YMFStreamSyncSourceManager.getInstance().changeVideoConfig();
                this.mNeedRestartEncoderFlag = false;
            }
            if (this.mNeedRestartCaptureFlag) {
                this.mVideoLiveSessionYCloud.mTmpAssignVideoEncoderConfig = this.mVideoEncoderConfig;
                YYCamera.getInstance().changePreviewParameter(this.mCameraPreviewConfig.mCaptureResolutionWidth, this.mCameraPreviewConfig.mCaptureResolutionHeight, this.mCameraPreviewConfig.mCaptureFrameRate, this.mCameraPreviewConfig.mCameraPosition == 0 ? CameraUtils.CameraFacing.FacingFront : CameraUtils.CameraFacing.FacingBack, this.mCameraPreviewConfig.mCaptureOrientation, CameraInterface.CameraResolutionMode.CAMERA_RESOLUTION_RANGE_MODE);
                this.mVideoLiveSessionYCloud.assignEncoderConfig(this.mVideoEncoderConfig);
                if (UploadStreamStateParams.mWaterMarkBitmap != null) {
                    this.mVideoLiveSessionYCloud.setWaterMark(UploadStreamStateParams.mWaterMarkBitmap, UploadStreamStateParams.mOffsetX, UploadStreamStateParams.mOffsetY);
                }
                this.mVideoLiveSessionYCloud.enablePreviewMirror(UploadStreamStateParams.mPreviewMirror);
                this.mVideoLiveSessionYCloud.enableMirror(UploadStreamStateParams.mEncoderMirror);
                this.mNeedRestartCaptureFlag = false;
                if (this.mEncodedStreamFlag == Constant.EncodedStream.CameraStream) {
                    YMFStreamSyncSourceManager.getInstance().changeVideoConfig();
                }
            } else if (this.mEncodedStreamFlag == Constant.EncodedStream.NoneStream && this.mVideoLiveSessionYCloud != null) {
                this.mVideoLiveSessionYCloud.assignEncoderConfig(this.mVideoEncoderConfig);
                if (UploadStreamStateParams.mWaterMarkBitmap != null) {
                    this.mVideoLiveSessionYCloud.setWaterMark(UploadStreamStateParams.mWaterMarkBitmap, UploadStreamStateParams.mOffsetX, UploadStreamStateParams.mOffsetY);
                }
            }
            if (this.mNeedLowDelayChangeFlag) {
                if (this.mEncodedStreamFlag == Constant.EncodedStream.CameraStream) {
                    this.mVideoLiveSessionYCloud.setLowStreamEncoderConfigs(this.mUploadParams.lowStreamConfigs, this.mUploadParams.bEnableLocalDualStreamMode);
                    this.mVideoLiveSessionYCloud.setLowDelayMode(this.mVideoEncoderConfig.mLowDelay);
                } else if (this.mEncodedStreamFlag == Constant.EncodedStream.ScreenStream) {
                    this.mScreenLiveSessionYCloud.setLowStreamEncoderConfigs(this.mUploadParams.lowStreamConfigs, this.mUploadParams.bEnableLocalDualStreamMode);
                    this.mScreenLiveSessionYCloud.setLowDelayMode(this.mVideoEncoderConfig.mLowDelay);
                } else if (this.mEncodedStreamFlag == Constant.EncodedStream.OriginStream && this.mExternalVideoLiveSessionYCloud != null) {
                    this.mExternalVideoLiveSessionYCloud.setLowStreamEncoderConfigs(this.mUploadParams.lowStreamConfigs, this.mUploadParams.bEnableLocalDualStreamMode);
                    this.mExternalVideoLiveSessionYCloud.setLowDelayMode(this.mVideoEncoderConfig.mLowDelay);
                }
                this.mNeedLowDelayChangeFlag = false;
            }
        }
        return true;
    }

    public int startVideoCapture() {
        YMFLiveUsrBehaviorStat.getInstance().notifyCaptureState(0, true);
        YMFLiveStatisticManager.getInstance().setCaptureType(1);
        if (this.mCameraPreviewConfig == null) {
            YMFLog.error(this, "[CCapture]", "startVideoCapture error: not set UploadParams");
            return -1;
        }
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyCaptureState(0, true);
            VideoDataStatUtil.putCaptureType(0);
            if (this.mCameraPreviewConfig == null) {
                YMFLog.error(this, "[CCapture]", "startVideoCapture error: not set UploadParams");
                return -1;
            } else if (this.mCameraOpened) {
                YMFLog.error(this, "[CCapture]", "startVideoCapture camera is opened");
                return 0;
            } else {
                if (this.mVideoLiveSessionYCloud == null) {
                    initVideoLiveSession();
                }
                int startPreview = YYCamera.getInstance().startPreview(this.mCameraPreviewConfig.mCaptureResolutionWidth, this.mCameraPreviewConfig.mCaptureResolutionHeight, this.mCameraPreviewConfig.mCaptureFrameRate, this.mCameraPreviewConfig.mCameraPosition == 0 ? CameraUtils.CameraFacing.FacingFront : CameraUtils.CameraFacing.FacingBack, this.mCameraPreviewConfig.mCaptureOrientation, CameraInterface.CameraResolutionMode.CAMERA_RESOLUTION_RANGE_MODE);
                if (this.mVideoLiveSessionYCloud != null) {
                    if (this.mEncodedStreamFlag == Constant.EncodedStream.CameraStream && this.mOnlyRestartCapture) {
                        YMFStreamSyncSourceManager.getInstance().reStartCapture();
                    }
                    this.mVideoLiveSessionYCloud.enablePreviewMirror(UploadStreamStateParams.mPreviewMirror);
                    this.mVideoLiveSessionYCloud.enableMirror(UploadStreamStateParams.mEncoderMirror);
                    this.mVideoLiveSessionYCloud.assignEncoderConfig(this.mVideoEncoderConfig);
                    if (UploadStreamStateParams.mWaterMarkBitmap != null && !UploadStreamStateParams.mWaterMarkEffect) {
                        this.mVideoLiveSessionYCloud.setWaterMark(UploadStreamStateParams.mWaterMarkBitmap, UploadStreamStateParams.mOffsetX, UploadStreamStateParams.mOffsetY);
                    }
                    this.mVideoLiveSessionYCloud.setScaleMode(UploadStreamStateParams.mScaleMode);
                    this.mVideoLiveSessionYCloud.setPreviewSurfaceView(this.mCameraSurfaceView);
                    this.mVideoLiveSessionYCloud.setCaptureReplaceImage(this.mCaptureReplaceBitmap);
                }
                if (startPreview == 0) {
                    this.mCameraOpened = true;
                }
                this.mNeedCheckCameraCfgFlag = true;
                this.mCameraCapturePauseFlag = false;
                return startPreview;
            }
        }
    }

    public int pauseVideoCapture(boolean z) {
        int i = 0;
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyPauseVideoCapture(z);
            YMFLog.info(this, "[CCapture]", "pauseVideoCapture:" + z + ":" + this.mNeedCheckCameraCfgFlag);
            if (!this.mNeedCheckCameraCfgFlag) {
                i = -1;
            } else {
                YYCamera.getInstance().resumeCameraAutoFocusFace(true);
                this.mCameraCapturePauseFlag = z;
                if (this.mCameraCapturePauseFlag) {
                    CameraInterface.getInstance().releaseCamera();
                    this.mCameraOpened = false;
                    YMFLiveUsrBehaviorStat.getInstance().notifyCameraCaptureState(false);
                } else {
                    if (this.mEncodedStreamFlag == Constant.EncodedStream.CameraStream) {
                        YMFStreamSyncSourceManager.getInstance().reStartCapture();
                    }
                    i = YYCamera.getInstance().startPreview(this.mCameraPreviewConfig.mCaptureResolutionWidth, this.mCameraPreviewConfig.mCaptureResolutionHeight, this.mCameraPreviewConfig.mCaptureFrameRate, this.mCameraPreviewConfig.mCameraPosition == 0 ? CameraUtils.CameraFacing.FacingFront : CameraUtils.CameraFacing.FacingBack, this.mCameraPreviewConfig.mCaptureOrientation, CameraInterface.CameraResolutionMode.CAMERA_RESOLUTION_RANGE_MODE);
                    if (this.mVideoLiveSessionYCloud != null) {
                        this.mVideoLiveSessionYCloud.enablePreviewMirror(UploadStreamStateParams.mPreviewMirror);
                        this.mVideoLiveSessionYCloud.enableMirror(UploadStreamStateParams.mEncoderMirror);
                        if (UploadStreamStateParams.mWaterMarkBitmap != null && !UploadStreamStateParams.mWaterMarkEffect) {
                            this.mVideoLiveSessionYCloud.setWaterMark(UploadStreamStateParams.mWaterMarkBitmap, UploadStreamStateParams.mOffsetX, UploadStreamStateParams.mOffsetY);
                        }
                        this.mVideoLiveSessionYCloud.setScaleMode(UploadStreamStateParams.mScaleMode);
                        this.mVideoLiveSessionYCloud.setPreviewSurfaceView(this.mCameraSurfaceView);
                    }
                    if (i == 0) {
                        this.mCameraOpened = true;
                        if (this.mCameraPreviewConfig.mZoomFactor > 0.0f) {
                            YYCamera.getInstance().setZoom(this.mCameraPreviewConfig.mZoomFactor);
                        }
                        if (this.mCameraPreviewConfig.mIsTorchOn) {
                            YYCamera.getInstance().setCameraTorchOn(this.mCameraPreviewConfig.mIsTorchOn);
                        }
                    }
                }
            }
        }
        return i;
    }

    public int stopVideoCapture() {
        synchronized (this) {
            if (this.mCameraPreviewConfig != null) {
                this.mCameraPreviewConfig.mIsTorchOn = false;
                this.mCameraPreviewConfig.mZoomFactor = 1.0f;
            }
            YYCamera.getInstance().resumeZoomValue(1.0f);
            YMFLiveUsrBehaviorStat.getInstance().notifyCaptureState(0, false);
            CameraInterface.getInstance().releaseCamera();
            YMFLiveUsrBehaviorStat.getInstance().notifyCameraCaptureState(false);
            this.mNeedCheckCameraCfgFlag = false;
            this.mCameraOpened = false;
            if (!this.mNeedCheckEncoderCfgFlag && !this.mNeedCheckCameraCfgFlag) {
                deInitVideoLiveSession();
            } else if (this.mEncodedStreamFlag == Constant.EncodedStream.CameraStream) {
                this.mOnlyRestartCapture = true;
            }
        }
        return 0;
    }

    public String checkCamera() {
        String str;
        String str2;
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyCallApi("checkCamera");
            YMFLog.info(this, "[CCapture]", "startCheckCamera...");
            if (CameraUtils.isCameraAvailable(1)) {
                String str3 = "front camera is supported\n";
                Camera openCamera = CameraUtils.openCamera(CameraUtils.CameraFacing.FacingFront);
                if (openCamera != null) {
                    str = str3 + "front camera can be used\n";
                    openCamera.release();
                } else {
                    str = str3 + "front camera cannot be used\n";
                }
            } else {
                str = "front camera is not supported\n";
            }
            if (CameraUtils.isCameraAvailable(0)) {
                String str4 = str + "back camera is supported\n";
                Camera openCamera2 = CameraUtils.openCamera(CameraUtils.CameraFacing.FacingBack);
                if (openCamera2 != null) {
                    str2 = str4 + "back camera can be used\n";
                    openCamera2.release();
                } else {
                    str2 = str4 + "back camera cannot be used\n";
                }
            } else {
                str2 = str + "back camera is not supported\n";
            }
        }
        return str2;
    }

    public int startPreview(SurfaceView surfaceView, int i) {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyPreviewState(true, i);
            YMFLog.info(this, "[Preview ]", "startPreview:" + surfaceView + "," + i);
            setPreviewRenderMode(i);
            this.mCameraSurfaceView = surfaceView;
            if (this.mVideoLiveSessionYCloud == null) {
                initVideoLiveSession();
            }
            if (this.mCameraOpened) {
                this.mVideoLiveSessionYCloud.setScaleMode(UploadStreamStateParams.mScaleMode);
                this.mVideoLiveSessionYCloud.setPreviewSurfaceView(surfaceView);
            }
        }
        return 0;
    }

    public int stopPreview() {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyPreviewState(false, -1);
            YMFLog.info(this, "[Preview ]", "stopPreview...");
            if (this.mCameraPreviewConfig != null) {
                this.mCameraPreviewConfig.mIsTorchOn = false;
                this.mCameraPreviewConfig.mZoomFactor = 1.0f;
            }
            YYCamera.getInstance().resumeZoomValue(1.0f);
            this.mCameraSurfaceView = null;
            this.mAnchorStatusPreviewingCallback = true;
            if (this.mVideoLiveSessionYCloud != null) {
                this.mVideoLiveSessionYCloud.setPreviewSurfaceView(null);
                this.mVideoLiveSessionYCloud.reSetPreviewState();
            }
        }
        return 0;
    }

    public int startEncodeVideo() {
        int i = 0;
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyEncodeState(0, true);
            YMFLog.info(this, "[Encoder ]", "startEncodeVideo...");
            if (this.mVideoEncoderConfig == null) {
                YMFLog.error(this, "[CCapture]", "startVideoCapture error: not set UploadParams");
                i = -1;
            } else {
                if (this.mVideoLiveSessionYCloud == null) {
                    initVideoLiveSession();
                }
                this.mVideoLiveSessionYCloud.setDeltaYYPtsMillions(UploadStreamStateParams.mDeltaPtsDts);
                this.mVideoLiveSessionYCloud.setEncoderListener(this);
                this.mVideoLiveSessionYCloud.setEncoderConfig(this.mVideoEncoderConfig);
                this.mVideoLiveSessionYCloud.setLowStreamEncoderConfigs(this.mUploadParams.lowStreamConfigs, this.mUploadParams.bEnableLocalDualStreamMode);
                if (UploadStreamStateParams.mWaterMarkBitmap != null && !UploadStreamStateParams.mWaterMarkEffect) {
                    this.mVideoLiveSessionYCloud.setWaterMark(UploadStreamStateParams.mWaterMarkBitmap, UploadStreamStateParams.mOffsetX, UploadStreamStateParams.mOffsetY);
                    UploadStreamStateParams.mWaterMarkEffect = true;
                }
                this.mVideoLiveSessionYCloud.startEncoder();
                this.mVideoLiveSessionYCloud.enableMirror(UploadStreamStateParams.mEncoderMirror);
                if (this.mUploadParams.weakNetConfigs != null && this.mUploadParams.weakNetConfigs.size() > 0) {
                    this.mVideoLiveSessionYCloud.setResolutionModifyConfigs(this.mUploadParams.weakNetConfigs, this.mUploadParams.weakNetConfigsIntervalSecs);
                    this.mVideoLiveSessionYCloud.setAbroadNetWorkStrategy(UploadStreamStateParams.mNetWorkStrategy);
                }
                this.mNeedCheckEncoderCfgFlag = true;
                if (this.mEncodedStreamFlag != Constant.EncodedStream.NoneStream) {
                    YMFLog.warn(this, "[Encoder ]", "has anothre stream encoded " + this.mEncodedStreamFlag);
                }
                this.mEncodedStreamFlag = Constant.EncodedStream.CameraStream;
            }
        }
        return i;
    }

    public int stopEncodeVideo() {
        int i = 0;
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyEncodeState(0, false);
            YMFLog.info(this, "[Encoder ]", "stopEncodeVideo..");
            if (this.mVideoLiveSessionYCloud == null) {
                i = -1;
            } else {
                this.mVideoLiveSessionYCloud.setEncoderListener(null);
                this.mVideoLiveSessionYCloud.stopEncoder();
                this.mNeedCheckEncoderCfgFlag = false;
                UploadStreamStateParams.mWaterMarkEffect = false;
                this.mEncodedStreamFlag = Constant.EncodedStream.NoneStream;
                if (!this.mNeedCheckEncoderCfgFlag && !this.mNeedCheckCameraCfgFlag) {
                    deInitVideoLiveSession();
                }
                this.mNotifyResolutioWidth = 0;
                this.mNotifyResolutioHeight = 0;
                this.mNotifyLowStreamResolutioWidth = 0;
                this.mNotifyLowStreamResolutioHeight = 0;
                this.mOnlyRestartCapture = false;
            }
        }
        return i;
    }

    public int setLocalVideoMirrorMode(int i) {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifySetVideoMirrorMode(i);
            if (i == 0) {
                UploadStreamStateParams.mPreviewMirror = true;
                UploadStreamStateParams.mEncoderMirror = false;
            } else if (i == 1) {
                UploadStreamStateParams.mPreviewMirror = true;
                UploadStreamStateParams.mEncoderMirror = true;
            } else if (i == 2) {
                UploadStreamStateParams.mPreviewMirror = false;
                UploadStreamStateParams.mEncoderMirror = false;
            } else if (i == 3) {
                UploadStreamStateParams.mPreviewMirror = false;
                UploadStreamStateParams.mEncoderMirror = true;
            }
            YMFLog.info(this, "[Api     ]", " setLocalVideoMirrorMode:" + i + " <" + UploadStreamStateParams.mPreviewMirror + ", " + UploadStreamStateParams.mEncoderMirror + ">");
            if (this.mVideoLiveSessionYCloud != null) {
                this.mVideoLiveSessionYCloud.enablePreviewMirror(UploadStreamStateParams.mPreviewMirror);
                this.mVideoLiveSessionYCloud.enableMirror(UploadStreamStateParams.mEncoderMirror);
            }
        }
        return 0;
    }

    public int setCameraPosition(int i) {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyCallApi("setCameraPosition:" + i);
            YMFLog.info(this, "[CCapture]", "setCameraPosition:" + i);
            UploadStreamStateParams.mCameraPosition = i;
            if (this.mCameraPreviewConfig != null) {
                this.mCameraPreviewConfig.mCameraPosition = UploadStreamStateParams.mCameraPosition;
            }
            if (this.mNeedCheckCameraCfgFlag && !this.mCameraCapturePauseFlag && ((YYCamera.getInstance().isCameraFront() && UploadStreamStateParams.mCameraPosition != 0) || (!YYCamera.getInstance().isCameraFront() && UploadStreamStateParams.mCameraPosition == 0))) {
                if (this.mCameraPreviewConfig != null) {
                    this.mCameraPreviewConfig.mZoomFactor = 1.0f;
                    this.mCameraPreviewConfig.mIsTorchOn = false;
                }
                YYCamera.getInstance().resumeZoomValue(1.0f);
                YYCamera.getInstance().switchCamera();
                requestEncodeIFrame();
                YMFStreamSyncSourceManager.getInstance().changeVideoConfig();
                YMFLiveUsrBehaviorStat.getInstance().notifySwitchCamera(true);
            }
        }
        return 0;
    }

    @Deprecated
    public int setLocalVideoCanvas(SurfaceView surfaceView, int i) {
        synchronized (this) {
        }
        return 0;
    }

    public int setPreviewRenderMode(int i) {
        synchronized (this) {
            if (i == 0) {
                UploadStreamStateParams.mScaleMode = Constant.ScaleMode.ScacleToFill;
            } else if (i == 1) {
                UploadStreamStateParams.mScaleMode = Constant.ScaleMode.AspectFit;
            } else if (i == 2) {
                UploadStreamStateParams.mScaleMode = Constant.ScaleMode.AspectFill;
            }
            YMFLog.info(this, "[Preview ]", "setPreviewRenderMode " + i + " :" + UploadStreamStateParams.mScaleMode);
            if (this.mVideoLiveSessionYCloud != null) {
                this.mVideoLiveSessionYCloud.setScaleMode(UploadStreamStateParams.mScaleMode);
            }
        }
        return 0;
    }

    public void setDeltaYYPtsMillions(long j) {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyCallApi("setDeltaYYPtsMillions:" + j);
            YMFLog.info(this, "[Api     ]", "setDeltaYYPtsMillions:" + j);
            UploadStreamStateParams.mDeltaPtsDts = j;
            if (this.mScreenLiveSessionYCloud != null) {
                this.mScreenLiveSessionYCloud.setDeltaYYPtsMillions(UploadStreamStateParams.mDeltaPtsDts);
            }
            if (this.mVideoLiveSessionYCloud != null) {
                this.mVideoLiveSessionYCloud.setDeltaYYPtsMillions(UploadStreamStateParams.mDeltaPtsDts);
            }
            if (this.mExternalVideoLiveSessionYCloud != null) {
                this.mExternalVideoLiveSessionYCloud.setDeltaYYPtsMillions(UploadStreamStateParams.mDeltaPtsDts);
            }
        }
    }

    public int getCameraPosition() {
        int ordinal;
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyCallApi("getCameraPosition");
            ordinal = YYCamera.getInstance().getCameraFacing().ordinal();
        }
        return ordinal;
    }

    public int setWatermark(Bitmap bitmap, int i, int i2) {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifySetWaterMark(bitmap == null, i, i2);
            YMFLog.info(this, "[Api     ]", "setWatermark " + bitmap + ":" + i + "," + i2 + ",status" + this.mNeedCheckEncoderCfgFlag);
            UploadStreamStateParams.mWaterMarkBitmap = bitmap;
            UploadStreamStateParams.mOffsetX = i;
            UploadStreamStateParams.mOffsetY = i2;
            if (this.mVideoLiveSessionYCloud != null) {
                this.mVideoLiveSessionYCloud.setWaterMark(bitmap, i, i2);
            }
            if (this.mScreenLiveSessionYCloud != null) {
                this.mScreenLiveSessionYCloud.setWaterMark(bitmap, i, i2);
            }
            if (this.mExternalVideoLiveSessionYCloud != null) {
                this.mExternalVideoLiveSessionYCloud.setWaterMark(bitmap, i, i2);
            }
            if (this.mNeedCheckEncoderCfgFlag) {
                UploadStreamStateParams.mWaterMarkEffect = true;
            }
        }
        return 0;
    }

    public void requestEncodeIFrame() {
        synchronized (this) {
            if (this.mVideoLiveSessionYCloud != null) {
                this.mVideoLiveSessionYCloud.requestIFrame();
            }
            if (this.mScreenLiveSessionYCloud != null) {
                this.mScreenLiveSessionYCloud.requestIFrame();
            }
            if (this.mExternalVideoLiveSessionYCloud != null) {
                this.mExternalVideoLiveSessionYCloud.requestIFrame();
            }
        }
    }

    public void setNetworkBitrateSuggest(int i) {
        synchronized (this) {
            if (this.mNeedCheckEncoderCfgFlag) {
                YMFLog.info(this, "[Encoder ]", "live setNetworkBitrateSuggest outside:" + i + " flag:" + this.mNeedCheckEncoderCfgFlag + "," + this.mCameraCapturePauseFlag + "," + this.mCameraOpened);
                if (this.mEncodedStreamFlag == Constant.EncodedStream.ScreenStream && this.mScreenLiveSessionYCloud != null) {
                    this.mScreenLiveSessionYCloud.setNetworkBitrateSuggest(i);
                } else if (this.mEncodedStreamFlag == Constant.EncodedStream.OriginStream && this.mExternalVideoLiveSessionYCloud != null && this.mOriginCaptureFlag) {
                    this.mExternalVideoLiveSessionYCloud.setNetworkBitrateSuggest(i);
                } else if (this.mEncodedStreamFlag == Constant.EncodedStream.CameraStream && this.mVideoLiveSessionYCloud != null && !this.mCameraCapturePauseFlag && this.mCameraOpened) {
                    this.mVideoLiveSessionYCloud.setNetworkBitrateSuggest(i);
                }
            }
        }
    }

    public int getVideoPublishInfo(VideoPublishInfoEnum videoPublishInfoEnum, int i) {
        int ordinal;
        int ordinal2;
        int ordinal3;
        synchronized (this.mDataAsyncLock) {
            if (videoPublishInfoEnum.ordinal() == VideoPublishInfoEnum.CAPTUREMODE.ordinal()) {
                if (this.mVideoLiveSessionYCloud == null) {
                    ordinal3 = UploadStreamStateParams.mCaptureMode.ordinal();
                } else if (this.mVideoLiveSessionYCloud.getVideoProcessMode()) {
                    ordinal3 = Constant.CaptureMode.YuvMode.ordinal();
                } else {
                    ordinal3 = Constant.CaptureMode.TextureMode.ordinal();
                }
                return ordinal3;
            } else if (videoPublishInfoEnum.ordinal() == VideoPublishInfoEnum.PRRVIEWTYPE.ordinal()) {
                if (this.mVideoLiveSessionYCloud == null) {
                    ordinal2 = UploadStreamStateParams.mPreviewMode.ordinal();
                } else if (this.mVideoLiveSessionYCloud.getVideoPreviewMode() == Constant.PreviewMode.TextureMode.ordinal()) {
                    ordinal2 = Constant.PreviewMode.TextureMode.ordinal();
                } else if (this.mVideoLiveSessionYCloud.getVideoPreviewMode() == Constant.PreviewMode.CanvasMode.ordinal()) {
                    ordinal2 = Constant.PreviewMode.CanvasMode.ordinal();
                } else {
                    ordinal2 = Constant.PreviewMode.GlSurfaceMode.ordinal();
                }
                return ordinal2;
            } else if (videoPublishInfoEnum.ordinal() == VideoPublishInfoEnum.CAPTUREFPS.ordinal()) {
                return this.mVideoLiveSessionYCloud != null ? this.mVideoLiveSessionYCloud.getCurrentCameraFps() : 0;
            } else if (videoPublishInfoEnum.ordinal() == VideoPublishInfoEnum.CAPTUREFPSMODE.ordinal()) {
                return UploadStreamStateParams.mCaptureFpsMode.ordinal();
            } else if (videoPublishInfoEnum.ordinal() == VideoPublishInfoEnum.SETCAPTUREFPS.ordinal()) {
                return CameraInterface.mSetCameraFpsParams;
            } else if (videoPublishInfoEnum.ordinal() == VideoPublishInfoEnum.YUVTEXTUREMODE.ordinal()) {
                return UploadStreamStateParams.mYuvTextureMode ? 1 : 0;
            } else {
                YMFEncoderStatisticInfo yMFEncoderStatisticInfo = null;
                if (this.mEncoderStatInfoList == null) {
                    return -1;
                }
                for (YMFEncoderStatisticInfo yMFEncoderStatisticInfo2 : this.mEncoderStatInfoList) {
                    if (yMFEncoderStatisticInfo2.mStreamId != i) {
                        yMFEncoderStatisticInfo2 = yMFEncoderStatisticInfo;
                    }
                    yMFEncoderStatisticInfo = yMFEncoderStatisticInfo2;
                }
                if (yMFEncoderStatisticInfo == null) {
                    return -1;
                }
                if (videoPublishInfoEnum.ordinal() == VideoPublishInfoEnum.FRAME.ordinal()) {
                    ordinal = yMFEncoderStatisticInfo.mFrameRate;
                } else if (videoPublishInfoEnum.ordinal() == VideoPublishInfoEnum.BITRATE.ordinal()) {
                    ordinal = yMFEncoderStatisticInfo.mBitRate;
                } else if (videoPublishInfoEnum.ordinal() == VideoPublishInfoEnum.RESOLUTION.ordinal()) {
                    ordinal = (yMFEncoderStatisticInfo.mWidth << 16) | yMFEncoderStatisticInfo.mHeight;
                } else if (videoPublishInfoEnum.ordinal() == VideoPublishInfoEnum.DYNAMIC_ENC_FRAME_RATE.ordinal()) {
                    if (yMFEncoderStatisticInfo.mStreamId == 0) {
                        ordinal = VideoDataStat.getInstance().getDynamicEncodeFrameRate();
                    } else {
                        ordinal = yMFEncoderStatisticInfo.mFrameRate;
                    }
                } else if (videoPublishInfoEnum.ordinal() == VideoPublishInfoEnum.PREVIEW_FRAME_RATE.ordinal()) {
                    ordinal = VideoDataStat.getInstance().getPreviewFrameRate();
                } else {
                    ordinal = (videoPublishInfoEnum.ordinal() != VideoPublishInfoEnum.ENCODETYPE.ordinal() || yMFEncoderStatisticInfo.mEncoderType == null) ? -1 : yMFEncoderStatisticInfo.mEncoderType.ordinal();
                }
                return ordinal;
            }
        }
    }

    public int setHardwareEncoderAvailable(boolean z) {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyCallApi("setHardwareEncoderAvailable:" + (z ? "1" : "0"));
            YMFLog.info(this, "[Api     ]", "setHardwareEncoderAvailable:" + z);
            UploadStreamStateParams.mDisableHardEncoder.set(true);
        }
        return 0;
    }

    public void changeScreenLiveMode(Boolean bool, Bitmap bitmap) {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyCallApi("changeScreenLiveMode,usedBitmap:" + (bool.booleanValue() ? "1" : "0") + ",bitmap:" + (bitmap == null ? "1" : "0"));
            if (this.mScreenLiveSessionYCloud != null) {
                this.mScreenLiveSessionYCloud.changeScreenLiveMode(bool.booleanValue(), bitmap);
            }
        }
    }

    public void setGPUImageBeautyFilter(IGPUProcess iGPUProcess) {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifySetGPUImageBeautyFilter(iGPUProcess != null);
            if (this.mVideoLiveSessionYCloud != null) {
                this.mVideoLiveSessionYCloud.setGPUImageBeautyFilter(iGPUProcess);
            } else {
                YMFLog.error(this, "[Api     ]", "setGPUImageBeautyFilter failed");
            }
        }
    }

    public void addPreviewFrameCallback(PreviewFrameCallback previewFrameCallback) {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyCallApi("addPreviewFrameCallback");
            if (this.mVideoLiveSessionYCloud != null) {
                this.mVideoLiveSessionYCloud.registerCallback(previewFrameCallback);
            }
        }
    }

    public void removePreviewFrameCallback(PreviewFrameCallback previewFrameCallback) {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyCallApi("removePreviewFrameCallback");
            if (this.mVideoLiveSessionYCloud != null) {
                this.mVideoLiveSessionYCloud.unregisterCallback(previewFrameCallback);
            }
        }
    }

    public int startOriginCapture(boolean z) {
        synchronized (this) {
            this.mOriginCaptureInputTexture = z;
            YMFLiveUsrBehaviorStat.getInstance().notifyCaptureState(2, true);
            YMFLiveStatisticManager.getInstance().setCaptureType(3);
            YMFLog.info(this, "[Api     ]", "startOriginCapture..." + this.mOriginCaptureInputTexture);
            if (!z && this.mExternalVideoLiveSessionYCloud == null) {
                initOriginLiveSession(null);
            }
            this.mOriginCaptureFlag = true;
        }
        return 0;
    }

    public int stopOriginCapture() {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyCaptureState(2, false);
            YMFLog.info(this, "[CCapture]", "stopOriginCapture...");
            this.mFrameCount = 0L;
            this.mOriginCaptureFlag = false;
            if (this.mEncodedStreamFlag != Constant.EncodedStream.OriginStream) {
                deInitOriginLiveSession();
            }
        }
        return 0;
    }

    private void realStartEncodeOrigin() {
        YMFLog.info(this, "[Encoder ]", "realStartEncodeOrigin...");
        this.mExternalVideoLiveSessionYCloud.setDeltaYYPtsMillions(UploadStreamStateParams.mDeltaPtsDts);
        this.mExternalVideoLiveSessionYCloud.setEncoderListener(this);
        this.mExternalVideoLiveSessionYCloud.setEncoderConfig(this.mVideoEncoderConfig);
        this.mExternalVideoLiveSessionYCloud.setLowStreamEncoderConfigs(this.mUploadParams.lowStreamConfigs, this.mUploadParams.bEnableLocalDualStreamMode);
        if (UploadStreamStateParams.mWaterMarkBitmap != null && !UploadStreamStateParams.mWaterMarkEffect) {
            this.mExternalVideoLiveSessionYCloud.setWaterMark(UploadStreamStateParams.mWaterMarkBitmap, UploadStreamStateParams.mOffsetX, UploadStreamStateParams.mOffsetY);
            UploadStreamStateParams.mWaterMarkEffect = true;
        }
        this.mExternalVideoLiveSessionYCloud.startEncoder();
        if (this.mUploadParams.weakNetConfigs != null && this.mUploadParams.weakNetConfigs.size() > 0) {
            this.mExternalVideoLiveSessionYCloud.setResolutionModifyConfigs(this.mUploadParams.weakNetConfigs, this.mUploadParams.weakNetConfigsIntervalSecs);
            this.mExternalVideoLiveSessionYCloud.setAbroadNetWorkStrategy(UploadStreamStateParams.mNetWorkStrategy);
        }
        this.mExternalVideoLiveSessionYCloud.setEnableUnderflowStrategy(false);
    }

    public int startEncodeOrigin() {
        YMFLiveUsrBehaviorStat.getInstance().notifyEncodeState(2, true);
        if (!this.mOriginCaptureInputTexture) {
            if (this.mExternalVideoLiveSessionYCloud == null) {
                initOriginLiveSession(null);
            }
            realStartEncodeOrigin();
        }
        this.mNeedCheckEncoderCfgFlag = true;
        this.mEncodedStreamFlag = Constant.EncodedStream.OriginStream;
        return 0;
    }

    public int stopEncodeOrigin() {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyEncodeState(2, false);
            YMFLog.info(this, "[Encoder ]", "stopEncodeOrigin...");
            if (this.mExternalVideoLiveSessionYCloud != null) {
                this.mExternalVideoLiveSessionYCloud.setEncoderListener(null);
                this.mExternalVideoLiveSessionYCloud.stopEncoder();
                UploadStreamStateParams.mWaterMarkEffect = false;
            }
            this.mEncodedStreamFlag = Constant.EncodedStream.NoneStream;
            this.mNeedCheckEncoderCfgFlag = false;
            this.mNotifyResolutioWidth = 0;
            this.mNotifyResolutioHeight = 0;
            this.mNotifyLowStreamResolutioWidth = 0;
            this.mNotifyLowStreamResolutioHeight = 0;
            this.mOriginFrameLastTimeStamp = -1L;
        }
        return 0;
    }

    public int startScreenCapture(MediaProjection mediaProjection) {
        YMFLiveUsrBehaviorStat.getInstance().notifyCaptureState(1, true);
        YMFLiveStatisticManager.getInstance().setCaptureType(2);
        YMFLog.info(this, "[SCapture]", "startScreenCapture..." + mediaProjection);
        if (this.mScreenLiveSessionYCloud == null) {
            initScreenSession();
        }
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyCaptureState(1, true);
            VideoDataStatUtil.putCaptureType(1);
            YMFLog.info(this, "[SCapture]", "startScreenCapture..." + mediaProjection);
            if (this.mScreenLiveSessionYCloud == null) {
                initScreenSession();
            }
            this.mScreenLiveSessionYCloud.setCaptureResolution(this.mVideoEncoderConfig.mEncodeWidth, this.mVideoEncoderConfig.mEncodeHeight);
            this.mScreenLiveSessionYCloud.setCaptureReplaceImage(this.mCaptureReplaceBitmap);
            this.mScreenLiveSessionYCloud.startCapture(mediaProjection);
            this.mScreenCaptureFlag = true;
        }
        return 0;
    }

    public int stopScreenCapture() {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyCaptureState(1, false);
            YMFLog.info(this, "[SCapture]", "stopScreenCapture...");
            if (this.mScreenLiveSessionYCloud != null) {
                this.mScreenLiveSessionYCloud.stopCapture();
            }
            this.mScreenCaptureFlag = false;
            if (this.mEncodedStreamFlag != Constant.EncodedStream.ScreenStream) {
                deInitScreenSession();
            }
        }
        return 0;
    }

    public int startEncodeScreen() {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyEncodeState(1, true);
            YMFLog.info(this, "[Encoder ]", "startEncodeScreen...");
            if (this.mScreenLiveSessionYCloud == null) {
                initScreenSession();
            }
            this.mScreenLiveSessionYCloud.setDeltaYYPtsMillions(UploadStreamStateParams.mDeltaPtsDts);
            this.mScreenLiveSessionYCloud.setEncoderListener(this);
            this.mScreenLiveSessionYCloud.setEncoderConfig(this.mVideoEncoderConfig);
            this.mScreenLiveSessionYCloud.setLowStreamEncoderConfigs(this.mUploadParams.lowStreamConfigs, this.mUploadParams.bEnableLocalDualStreamMode);
            if (UploadStreamStateParams.mWaterMarkBitmap != null && !UploadStreamStateParams.mWaterMarkEffect) {
                this.mScreenLiveSessionYCloud.setWaterMark(UploadStreamStateParams.mWaterMarkBitmap, UploadStreamStateParams.mOffsetX, UploadStreamStateParams.mOffsetY);
                UploadStreamStateParams.mWaterMarkEffect = true;
            }
            this.mScreenLiveSessionYCloud.startEncoder();
            if (this.mUploadParams.weakNetConfigs != null && this.mUploadParams.weakNetConfigs.size() > 0) {
                this.mScreenLiveSessionYCloud.setResolutionModifyConfigs(this.mUploadParams.weakNetConfigs, this.mUploadParams.weakNetConfigsIntervalSecs);
                this.mScreenLiveSessionYCloud.setAbroadNetWorkStrategy(false);
            }
            this.mNeedCheckEncoderCfgFlag = true;
            if (this.mEncodedStreamFlag != Constant.EncodedStream.NoneStream) {
                YMFLog.warn(this, "[Encoder ]", "current has anothre stream encoded " + this.mEncodedStreamFlag);
            }
            this.mEncodedStreamFlag = Constant.EncodedStream.ScreenStream;
        }
        return 0;
    }

    public int stopEncodeScreen() {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyEncodeState(1, false);
            YMFLog.info(this, "[Encoder ]", "stopPublishScreenVideo");
            if (this.mScreenLiveSessionYCloud != null) {
                this.mScreenLiveSessionYCloud.setEncoderListener(null);
                this.mScreenLiveSessionYCloud.stopEncoder();
                UploadStreamStateParams.mWaterMarkEffect = false;
            }
            this.mEncodedStreamFlag = Constant.EncodedStream.NoneStream;
            this.mNotifyResolutioWidth = 0;
            this.mNotifyResolutioHeight = 0;
            this.mNotifyLowStreamResolutioWidth = 0;
            this.mNotifyLowStreamResolutioHeight = 0;
            if (!this.mScreenCaptureFlag) {
                deInitScreenSession();
            }
        }
        return 0;
    }

    private int initScreenSession() {
        YMFLog.info(this, "[Procedur]", "initScreenLiveSession...");
        if (this.mScreenLiveSessionYCloud != null) {
            deInitScreenSession();
        }
        this.mScreenLiveSessionYCloud = new ScreenLiveSessionYCloud(YYVideoSDK.getInstance().getAppContext(), Constant.VideoStreamType.Screen);
        this.mScreenLiveSessionYCloud.setEncoderListener(this);
        return 0;
    }

    private int deInitScreenSession() {
        YMFLog.info(this, "[Procedur]", "deInitScreenSession....");
        synchronized (this) {
            if (this.mExternalVideoLiveSessionYCloud != null) {
                this.mExternalVideoLiveSessionYCloud.setEncoderListener(null);
                this.mExternalVideoLiveSessionYCloud.stopAndRelease();
                this.mExternalVideoLiveSessionYCloud = null;
            }
        }
        return 0;
    }

    private int initOriginLiveSession(Object obj) {
        YMFLog.info(this, "[Procedur]", "initOriginLiveSession...");
        if (this.mExternalVideoLiveSessionYCloud != null) {
            deInitOriginLiveSession();
        }
        this.mExternalVideoLiveSessionYCloud = new YMFExternalTextureSessionYCloud(YYVideoSDK.getInstance().getAppContext(), Constant.VideoStreamType.OriginData, obj);
        this.mExternalVideoLiveSessionYCloud.initOriginDataFilter();
        this.mExternalVideoLiveSessionYCloud.setEncoderListener(this);
        return 0;
    }

    private int deInitOriginLiveSession() {
        YMFLog.info(this, "[Procedur]", "deInitOriginLiveSession....");
        synchronized (this) {
            if (this.mExternalVideoLiveSessionYCloud != null) {
                this.mExternalVideoLiveSessionYCloud.setEncoderListener(null);
                this.mExternalVideoLiveSessionYCloud.stopAndRelease();
                this.mExternalVideoLiveSessionYCloud = null;
            }
        }
        return 0;
    }

    public void setOriginFrameToEncode(byte[] bArr, int i, int i2, int i3, int i4, long j, int i5) {
        long j2 = this.mFrameCount;
        this.mFrameCount = 1 + j2;
        if (j2 % 300 == 0) {
            YMFLiveUsrBehaviorStat.getInstance().notifyCallApi("setOriginFrameToEncode,format:" + i + ",width:" + i2 + ",height:" + i3 + ",rotation:" + i4 + ",timeStamp:" + j + " scaleMode " + i5);
        }
        if (!this.mOriginCaptureFlag || this.mOriginCaptureInputTexture || i2 > 1920 || i3 > 1920 || i2 * i3 <= 0) {
            YMFLog.warn(this, "[Api     ]", "setOriginFrameToEncode not startcapture or params error");
            return;
        }
        if (this.mOriginFrameLastTimeStamp > 0 && j < this.mOriginFrameLastTimeStamp) {
            YMFLog.warn(this, "[Api     ]", "setOriginFrameToEncode pts error " + j + " < " + this.mOriginFrameLastTimeStamp);
        }
        if (this.mExternalVideoLiveSessionYCloud != null) {
            this.mExternalVideoLiveSessionYCloud.setOriginFrameToEncode(bArr, i, i2, i3, i4, j, i5);
        }
        this.mOriginFrameLastTimeStamp = j;
    }

    public void setOriginTextureToEncode(int i, int i2, int i3, int i4, int i5, long j, float[] fArr, int i6) {
        EGLContext eGLContext;
        long j2 = this.mFrameCount;
        this.mFrameCount = 1 + j2;
        if (j2 % 300 == 0) {
            YMFLiveUsrBehaviorStat.getInstance().notifyCallApi("setOriginTextureToEncode,inputTexture :" + i + ",transformer:" + fArr + "," + j + "," + i5 + " scaleMode " + i6);
        }
        if (!this.mOriginCaptureFlag || !this.mOriginCaptureInputTexture || i < 0) {
            YMFLog.warn(this, "[Api     ]", "setOriginTextureToEncode not startcapture or params error");
            return;
        }
        if (this.mExternalVideoLiveSessionYCloud == null) {
            android.opengl.EGLContext eGLContext2 = null;
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    eGLContext2 = EGL14.eglGetCurrentContext();
                    if (eGLContext2 == null) {
                        EGL10 egl10 = (EGL10) EGLContext.getEGL();
                        if (egl10 == null) {
                            YMFLog.error(this, "[Api     ]", "EGL10 mEgl == null");
                        }
                        eGLContext = egl10.eglGetCurrentContext();
                    } else {
                        eGLContext = eGLContext2;
                    }
                } catch (Exception e) {
                    YMFLog.error(this, "[Api     ]", "eglGetCurrentContext error " + e.toString());
                    eGLContext = eGLContext2;
                }
            } else {
                EGL10 egl102 = (EGL10) EGLContext.getEGL();
                if (egl102 == null) {
                    YMFLog.error(this, "[Api     ]", "EGL10 mEgl == null");
                    return;
                }
                eGLContext = egl102.eglGetCurrentContext();
            }
            if (eGLContext == null) {
                YMFLog.error(this, "[Api     ]", "eglContext == null");
                return;
            }
            initOriginLiveSession(eGLContext);
            if (this.mNeedCheckEncoderCfgFlag && this.mEncodedStreamFlag == Constant.EncodedStream.OriginStream) {
                realStartEncodeOrigin();
            }
        }
        if (this.mOriginFrameLastTimeStamp > 0 && j < this.mOriginFrameLastTimeStamp) {
            YMFLog.warn(this, "[Api     ]", "setOriginFrameToEncode pts error " + j + " < " + this.mOriginFrameLastTimeStamp);
        }
        if (this.mExternalVideoLiveSessionYCloud != null) {
            this.mExternalVideoLiveSessionYCloud.setOriginTextureToEncode(i, i2, fArr, i3, i4, j, i5, i6);
        }
        this.mOriginFrameLastTimeStamp = j;
    }

    public void setOriginExternalFrameToEncode(YMFExternalFrame yMFExternalFrame) {
        if (yMFExternalFrame == null) {
            YMFLog.error(this, "[Api     ]", "frame null");
        } else if (yMFExternalFrame.data != null && yMFExternalFrame.data.length > 0) {
            setOriginFrameToEncode(yMFExternalFrame.data, yMFExternalFrame.format, yMFExternalFrame.width, yMFExternalFrame.height, yMFExternalFrame.rotation, yMFExternalFrame.timeStamp, yMFExternalFrame.scaleMode);
        } else if (yMFExternalFrame.textureID > 0 && yMFExternalFrame.textureFormat > 0) {
            setOriginTextureToEncode(yMFExternalFrame.textureID, yMFExternalFrame.textureFormat, yMFExternalFrame.width, yMFExternalFrame.height, yMFExternalFrame.rotation, yMFExternalFrame.timeStamp, yMFExternalFrame.transform, yMFExternalFrame.scaleMode);
        }
    }

    private void initVideoLiveSession() {
        YMFLog.info(this, "[Procedur]", "initLiveSession...");
        synchronized (this) {
            if (this.mVideoLiveSessionYCloud != null) {
                deInitVideoLiveSession();
            }
            this.mVideoLiveSessionYCloud = new VideoLiveSessionYCloud(YYVideoSDK.getInstance().getAppContext(), Constant.VideoStreamType.Camera);
        }
        CameraInterface.getInstance().setCameraListener(this.mVideoLiveSessionYCloud);
        this.mVideoLiveSessionYCloud.setDeliverCallback(this);
        this.mVideoLiveSessionYCloud.setEncoderListener(this);
        this.mVideoLiveSessionYCloud.setCameraListener(this);
        this.mVideoLiveSessionYCloud.setFilterType(FilterType.BeautyFace);
    }

    private void deInitVideoLiveSession() {
        YMFLog.info(this, "[Procedur]", "deInitLiveSession...");
        synchronized (this) {
            if (this.mVideoLiveSessionYCloud != null) {
                this.mVideoLiveSessionYCloud.setCameraListener(null);
                this.mVideoLiveSessionYCloud.setEncoderListener(null);
                this.mVideoLiveSessionYCloud.setPreviewSurfaceView(null);
                this.mVideoLiveSessionYCloud.reSetPreviewState();
                this.mVideoLiveSessionYCloud.stopAndRelease();
                this.mVideoLiveSessionYCloud = null;
            }
        }
    }

    private void updateLowStreamParams(List<YMFLowStreamEncoderConfig> list, boolean z) {
        switch (this.mEncodedStreamFlag) {
            case CameraStream:
                this.mVideoLiveSessionYCloud.setLowStreamEncoderConfigs(list, z);
                return;
            case ScreenStream:
                this.mScreenLiveSessionYCloud.setLowStreamEncoderConfigs(list, z);
                return;
            case OriginStream:
                this.mExternalVideoLiveSessionYCloud.setLowStreamEncoderConfigs(list, z);
                return;
            default:
                return;
        }
    }

    private void disassembleUploadParams() {
        boolean z = false;
        if (this.mCameraPreviewConfig == null) {
            this.mCameraPreviewConfig = new CameraPreviewConfig();
        }
        if (this.mNeedCheckCameraCfgFlag) {
            if ((this.mCameraPreviewConfig.mCaptureResolutionWidth != this.mUploadParams.captureResolutionWidth || this.mCameraPreviewConfig.mCaptureResolutionHeight != this.mUploadParams.captureResolutionHeight || this.mCameraPreviewConfig.mCaptureFrameRate < this.mUploadParams.encodeFrameRate + 2 || this.mCameraPreviewConfig.mCaptureOrientation != this.mUploadParams.screenOrientation) && !this.mCameraCapturePauseFlag) {
                this.mNeedRestartCaptureFlag = true;
            } else {
                this.mNeedRestartCaptureFlag = false;
            }
        }
        this.mCameraPreviewConfig.mCaptureOrientation = this.mUploadParams.screenOrientation;
        this.mCameraPreviewConfig.mCameraPosition = UploadStreamStateParams.mCameraPosition;
        this.mCameraPreviewConfig.mCaptureResolutionWidth = this.mUploadParams.captureResolutionWidth;
        this.mCameraPreviewConfig.mCaptureResolutionHeight = this.mUploadParams.captureResolutionHeight;
        this.mCameraPreviewConfig.mCaptureFrameRate = this.mUploadParams.captureFrameRate;
        if (this.mVideoEncoderConfig == null) {
            this.mVideoEncoderConfig = new VideoEncoderConfig();
        }
        if (this.mNeedCheckEncoderCfgFlag) {
            if (this.mVideoEncoderConfig.mEncodeWidth != this.mUploadParams.encodeResolutionWidth || this.mVideoEncoderConfig.mEncodeHeight != this.mUploadParams.encodeResolutionHeight || this.mVideoEncoderConfig.mEncodeType != this.mUploadParams.encodeType || this.mVideoEncoderConfig.mFrameRate != this.mUploadParams.encodeFrameRate) {
                this.mNeedRestartEncoderFlag = true;
            } else {
                this.mNeedRestartEncoderFlag = false;
            }
        }
        this.mVideoEncoderConfig.mEncodeWidth = this.mUploadParams.encodeResolutionWidth;
        this.mVideoEncoderConfig.mEncodeHeight = this.mUploadParams.encodeResolutionHeight;
        this.mVideoEncoderConfig.mEncodeType = this.mUploadParams.encodeType;
        this.mVideoEncoderConfig.mEncodeParameter = this.mUploadParams.encoderParam;
        this.mVideoEncoderConfig.mFrameRate = this.mUploadParams.encodeFrameRate;
        this.mVideoEncoderConfig.mBitRate = this.mUploadParams.encodeBitrate;
        if (this.mUploadParams.bLowLatency || this.mUploadParams.bWebSdkCompatibility || this.mUploadParams.bEnableLocalDualStreamMode) {
            z = true;
        }
        if (!this.mNeedRestartEncoderFlag && z != this.mVideoEncoderConfig.mLowDelay) {
            YMFLiveUsrBehaviorStat.getInstance().notifyLowDelayFlagChange(this.mVideoEncoderConfig.mLowDelay, z);
            this.mNeedLowDelayChangeFlag = true;
        }
        this.mVideoEncoderConfig.mLowDelay = z;
    }

    private void resetUploadStreamParams() {
        UploadStreamStateParams.reset();
        YMFStreamSyncSourceManager.getInstance().deInit();
        this.mUploadParams = null;
        this.mVideoEncoderConfig = null;
        this.mCameraPreviewConfig = null;
        this.mCameraSurfaceView = null;
        this.mCameraCapturePauseFlag = false;
        this.mNeedCheckCameraCfgFlag = false;
        this.mNeedCheckEncoderCfgFlag = false;
        this.mNeedLowDelayChangeFlag = false;
        this.mNeedRestartCaptureFlag = false;
        this.mNeedRestartEncoderFlag = false;
        this.mEncodedStreamFlag = Constant.EncodedStream.NoneStream;
        this.mNotifyResolutioWidth = 0;
        this.mNotifyResolutioHeight = 0;
        this.mNotifyLowStreamResolutioWidth = 0;
        this.mNotifyLowStreamResolutioHeight = 0;
        this.mOnlyRestartCapture = false;
        this.mOriginCaptureFlag = false;
        this.mScreenCaptureFlag = false;
        this.mUserForceMode = false;
    }

    private void setEncoderStatistic(YMFEncoderStatisticInfo yMFEncoderStatisticInfo) {
        if (this.mEncoderStatInfoList == null) {
            this.mEncoderStatInfoList = new ArrayList();
            this.mEncoderStatInfoList.add(new YMFEncoderStatisticInfo(0));
            this.mEncoderStatInfoList.add(new YMFEncoderStatisticInfo(1));
        }
        if (yMFEncoderStatisticInfo != null && this.mEncoderStatInfoList.size() >= 2) {
            if (yMFEncoderStatisticInfo.mStreamId == 0) {
                this.mEncoderStatInfoList.get(0).assign(yMFEncoderStatisticInfo);
            } else {
                this.mEncoderStatInfoList.get(1).assign(yMFEncoderStatisticInfo);
            }
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeStat(YMFEncoderStatisticInfo yMFEncoderStatisticInfo) {
        synchronized (this.mDataAsyncLock) {
            setEncoderStatistic(yMFEncoderStatisticInfo);
        }
        if (this.mIEncoderStatisticListener != null) {
            this.mIEncoderStatisticListener.onEncoderStatistics(yMFEncoderStatisticInfo);
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeResolution(int i, int i2, int i3) {
        if (this.mIPublishListener != null) {
            if (i == 0 && (i2 != this.mNotifyResolutioWidth || i3 != this.mNotifyResolutioHeight)) {
                this.mIPublishListener.onUpdateVideoSizeChanged(0L, i2, i3);
                this.mNotifyResolutioWidth = i2;
                this.mNotifyResolutioHeight = i3;
            } else if (i == 1) {
                if (i2 != this.mNotifyLowStreamResolutioWidth || i3 != this.mNotifyLowStreamResolutioHeight) {
                    this.mIPublishListener.onUpdateVideoSizeChanged(1L, i2, i3);
                    this.mNotifyLowStreamResolutioWidth = i2;
                    this.mNotifyLowStreamResolutioHeight = i3;
                }
            }
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeFirstFrame() {
        if (this.mIPublishListener != null) {
            this.mIPublishListener.onVideoAnchorStatus(Constant.AnchorStatus.AnchorStatus_Encoding);
        }
    }

    @Override // com.yy.mediaframework.IYMFDeliverCallback
    public void onRenderFirstFrame() {
        if (this.mIPublishListener != null && this.mAnchorStatusPreviewingCallback) {
            this.mAnchorStatusPreviewingCallback = false;
            this.mIPublishListener.onVideoAnchorStatus(Constant.AnchorStatus.AnchorStatus_Previewing);
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeFrameData(YMFVideoEncodeFrame yMFVideoEncodeFrame) {
        if (this.mIPublishListener != null) {
            YMFStreamSyncSourceManager.getInstance().getExtraData(yMFVideoEncodeFrame);
            this.mIPublishListener.onEncodeFrameData(yMFVideoEncodeFrame);
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeEncParam(String str) {
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onHardEncoderError() {
        synchronized (this) {
            YMFLiveUsrBehaviorStat.getInstance().notifyCallApi("onHardEncoderError");
            YMFLog.warn(this, "[Encoder ]", "onEncoderSwitch change to softEncoder");
            UploadStreamStateParams.mDisableHardEncoder.set(true);
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncoderSwitch() {
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onWaterMarkSizeChange(int i, int i2) {
    }

    @Override // com.yy.mediaframework.IYMFDeliverCallback
    public void onVideoFrameProcessTime(float f, float f2) {
        synchronized (this) {
            if (this.mIPublishListener != null) {
                this.mIPublishListener.onVideoFrameProcessTime(f, f2);
            }
        }
    }

    public void setAbroadNetWorkStrategy(boolean z) {
        synchronized (this) {
            UploadStreamStateParams.mNetWorkStrategy = z;
            YMFLog.info(this, "[Encoder ]", "setAbroadNetWorkStrategy " + z);
            if (this.mVideoLiveSessionYCloud != null) {
                this.mVideoLiveSessionYCloud.setAbroadNetWorkStrategy(z);
            }
            if (this.mExternalVideoLiveSessionYCloud != null) {
                this.mExternalVideoLiveSessionYCloud.setAbroadNetWorkStrategy(z);
            }
            if (this.mScreenLiveSessionYCloud != null) {
                this.mScreenLiveSessionYCloud.setAbroadNetWorkStrategy(z);
            }
        }
    }

    public void setVideoUpCommonConfig(HashMap<String, String> hashMap) {
        try {
            synchronized (this) {
                if (!this.mUserForceMode) {
                    setVideoCaptureMode(Integer.parseInt(hashMap.get(Constant.CommonCfg.yuvCapture) != null ? hashMap.get(Constant.CommonCfg.yuvCapture) : "0"));
                    setVideoPreviewMode(Integer.parseInt(hashMap.get(Constant.CommonCfg.canvasOrGl) != null ? hashMap.get(Constant.CommonCfg.canvasOrGl) : "0"));
                    setVideoDisableBeautyMode(Integer.parseInt(hashMap.get(Constant.CommonCfg.disableBeauty) != null ? hashMap.get(Constant.CommonCfg.disableBeauty) : "0"));
                    setVideoEncoderInputMode(Integer.parseInt(hashMap.get(Constant.CommonCfg.encoderInput) != null ? hashMap.get(Constant.CommonCfg.encoderInput) : "0"));
                }
                setCaptureFpsMode(Integer.parseInt(hashMap.get(Constant.CommonCfg.captureFpsMode) != null ? hashMap.get(Constant.CommonCfg.captureFpsMode) : "0"));
            }
        } catch (Exception e) {
            YMFLog.error(this, "[Api     ]", "setVideoUpCommonConfig:" + e.toString());
        }
    }

    public int setVideoCommonConfigMode(int i) {
        int i2 = 0;
        synchronized (this) {
            YMFLog.info(this, "[Api     ]", "setVideoCommonConfigMode mode=" + i);
            if (this.mVideoLiveSessionYCloud != null) {
                YMFLog.error(this, "[Api     ]", "setVideoCommonConfigMode is invalid,mVideoLiveSessionYCloud is not null ,mode = " + i);
                i2 = -1;
            } else {
                switch (i) {
                    case 1:
                        setYuvTextureMode(false);
                        setVideoCaptureMode(Constant.CaptureMode.YuvMode.ordinal());
                        setVideoPreviewMode(Constant.PreviewMode.CanvasMode.ordinal());
                        setVideoDisableBeautyMode(1);
                        setVideoEncoderInputMode(Constant.EncoderInputMode.BUFFER.ordinal());
                        break;
                    case 2:
                        setYuvTextureMode(true);
                        setVideoCaptureMode(Constant.CaptureMode.TextureMode.ordinal());
                        setVideoPreviewMode(Constant.PreviewMode.TextureMode.ordinal());
                        setVideoDisableBeautyMode(0);
                        setVideoEncoderInputMode(Constant.EncoderInputMode.SURFACE.ordinal());
                        break;
                    default:
                        setYuvTextureMode(false);
                        setVideoCaptureMode(Constant.CaptureMode.TextureMode.ordinal());
                        setVideoPreviewMode(Constant.PreviewMode.TextureMode.ordinal());
                        setVideoDisableBeautyMode(0);
                        setVideoEncoderInputMode(Constant.EncoderInputMode.SURFACE.ordinal());
                        break;
                }
            }
        }
        return i2;
    }

    public int setYuvCanvasMode(boolean z) {
        int i = 0;
        synchronized (this) {
            synchronized (this) {
                if (this.mVideoLiveSessionYCloud != null) {
                    YMFLog.info(this, "[Api     ]", "mVideoLiveSessionYCloud not null:" + z);
                    i = -1;
                } else {
                    YMFLog.info(this, "[Api     ]", "setYuvCanvasMode:" + z);
                    if (z) {
                        setVideoCaptureMode(Constant.CaptureMode.YuvMode.ordinal());
                        setVideoPreviewMode(Constant.PreviewMode.CanvasMode.ordinal());
                        setVideoDisableBeautyMode(1);
                        setVideoEncoderInputMode(Constant.EncoderInputMode.BUFFER.ordinal());
                    } else {
                        setVideoCaptureMode(Constant.CaptureMode.TextureMode.ordinal());
                        setVideoPreviewMode(Constant.PreviewMode.TextureMode.ordinal());
                        setVideoDisableBeautyMode(0);
                        setVideoEncoderInputMode(Constant.EncoderInputMode.SURFACE.ordinal());
                    }
                    this.mUserForceMode = true;
                }
            }
        }
        return i;
    }

    private void setCaptureFpsMode(int i) {
        synchronized (this) {
            YMFLog.info(this, "[Api     ]", "setCaptureFpsMode:" + i);
            if (i == Constant.CaptureFpsMode.FullSpeed.ordinal()) {
                UploadStreamStateParams.mCaptureFpsMode = Constant.CaptureFpsMode.FullSpeed;
            } else {
                UploadStreamStateParams.mCaptureFpsMode = Constant.CaptureFpsMode.AlignEncoder;
            }
        }
    }

    private void setYuvTextureMode(boolean z) {
        synchronized (this) {
            YMFLog.info(this, "[Api     ]", "setYuvTextureMode:" + z);
            UploadStreamStateParams.mYuvTextureMode = z;
        }
    }

    private void setVideoCaptureMode(int i) {
        synchronized (this) {
            YMFLog.info(this, "[Api     ]", "setVideoCaptureMode:" + i);
            if (i == Constant.CaptureMode.YuvMode.ordinal()) {
                UploadStreamStateParams.mCaptureMode = Constant.CaptureMode.YuvMode;
            } else {
                UploadStreamStateParams.mCaptureMode = Constant.CaptureMode.TextureMode;
            }
        }
    }

    private void setVideoPreviewMode(int i) {
        synchronized (this) {
            YMFLog.info(this, "[Api     ]", "setVideoPreviewMode:" + i);
            if (i == Constant.PreviewMode.GlSurfaceMode.ordinal()) {
                UploadStreamStateParams.mPreviewMode = Constant.PreviewMode.GlSurfaceMode;
            } else if (i == Constant.PreviewMode.CanvasMode.ordinal()) {
                UploadStreamStateParams.mPreviewMode = Constant.PreviewMode.CanvasMode;
            } else {
                UploadStreamStateParams.mPreviewMode = Constant.PreviewMode.TextureMode;
            }
        }
    }

    private void setVideoEncoderInputMode(int i) {
        synchronized (this) {
            YMFLog.info(this, "[Api     ]", "setVideoEncoderInputMode:" + i);
            if (i == Constant.EncoderInputMode.BUFFER.ordinal()) {
                UploadStreamStateParams.mEncoderInputMode = Constant.EncoderInputMode.BUFFER;
            } else {
                UploadStreamStateParams.mEncoderInputMode = Constant.EncoderInputMode.SURFACE;
            }
        }
    }

    private void setVideoDisableBeautyMode(int i) {
        synchronized (this) {
            YMFLog.info(this, "[Api     ]", "setVideoDisableBeautyMode:" + i);
            if (i == 1) {
                UploadStreamStateParams.mDisableBeauty = true;
            } else {
                UploadStreamStateParams.mDisableBeauty = false;
            }
        }
    }

    public Constant.PreviewMode getPreViewType() {
        Constant.PreviewMode previewMode;
        synchronized (this) {
            if (this.mVideoLiveSessionYCloud == null) {
                initVideoLiveSession();
            }
            if (this.mVideoLiveSessionYCloud.mFilterContext.isUseCanvasSurfaceView()) {
                previewMode = Constant.PreviewMode.CanvasMode;
            } else if (this.mVideoLiveSessionYCloud.mFilterContext.isUseGLSurfaceView()) {
                previewMode = Constant.PreviewMode.GlSurfaceMode;
            } else {
                previewMode = Constant.PreviewMode.TextureMode;
            }
        }
        return previewMode;
    }

    public boolean isCameraOpen() {
        boolean isCameraOpen;
        synchronized (this) {
            isCameraOpen = YYCamera.getInstance().isCameraOpen();
        }
        return isCameraOpen;
    }

    public boolean isCameraZoomSupported() {
        boolean isZoomSupport;
        synchronized (this) {
            isZoomSupport = YYCamera.getInstance().isZoomSupport();
        }
        return isZoomSupport;
    }

    public float getCameraMaxZoomFactor() {
        float maxZoom;
        synchronized (this) {
            if (YYCamera.getInstance().isZoomSupport()) {
                maxZoom = YYCamera.getInstance().getMaxZoom();
            } else {
                YMFLog.error(TAG, "[CCapture]", "getCameraMaxZoomFactor not support.");
                maxZoom = 1.0f;
            }
        }
        return maxZoom;
    }

    public int setCameraZoomFactor(float f) {
        int i;
        synchronized (this) {
            if (!YYCamera.getInstance().isZoomSupport()) {
                YMFLog.error(TAG, "[CCapture]", "setCameraZoomFactor not support.");
                i = -1;
            } else {
                float maxZoom = YYCamera.getInstance().getMaxZoom();
                if (f > maxZoom) {
                    f = maxZoom;
                } else if (f < 1.0d) {
                    f = 1.0f;
                }
                float zoom = YYCamera.getInstance().setZoom(f);
                if (this.mCameraPreviewConfig != null) {
                    this.mCameraPreviewConfig.mZoomFactor = zoom;
                }
                i = (int) zoom;
            }
        }
        return i;
    }

    public boolean isCameraTorchSupported() {
        boolean isTorchSupported;
        synchronized (this) {
            isTorchSupported = YYCamera.getInstance().isTorchSupported();
        }
        return isTorchSupported;
    }

    public boolean setCameraTorchOn(boolean z) {
        boolean cameraTorchOn;
        synchronized (this) {
            if (this.mCameraPreviewConfig != null) {
                this.mCameraPreviewConfig.mIsTorchOn = z;
            }
            cameraTorchOn = YYCamera.getInstance().setCameraTorchOn(z);
        }
        return cameraTorchOn;
    }

    public boolean isCameraManualFocusPositionSupported() {
        boolean isCameraManualFocusPositionSupported;
        synchronized (this) {
            isCameraManualFocusPositionSupported = YYCamera.getInstance().isCameraManualFocusPositionSupported();
        }
        return isCameraManualFocusPositionSupported;
    }

    public int setCameraFocusPosition(float f, float f2) {
        int cameraFocusPosition;
        synchronized (this) {
            cameraFocusPosition = YYCamera.getInstance().setCameraFocusPosition(f, f2);
        }
        return cameraFocusPosition;
    }

    public boolean isCameraManualExposurePositionSupported() {
        boolean isCameraManualExposurePositionSupported;
        synchronized (this) {
            isCameraManualExposurePositionSupported = YYCamera.getInstance().isCameraManualExposurePositionSupported();
        }
        return isCameraManualExposurePositionSupported;
    }

    public int setCameraExposurePosition(float f, float f2) {
        int cameraExposurePosition;
        synchronized (this) {
            cameraExposurePosition = YYCamera.getInstance().setCameraExposurePosition(f, f2);
        }
        return cameraExposurePosition;
    }

    public boolean isCameraAutoFocusFaceModeSupported() {
        boolean isCameraAutoFocusFaceModeSupported;
        synchronized (this) {
            isCameraAutoFocusFaceModeSupported = YYCamera.getInstance().isCameraAutoFocusFaceModeSupported();
        }
        return isCameraAutoFocusFaceModeSupported;
    }

    public int setCameraAutoFocusFaceModeEnabled(boolean z) {
        int cameraAutoFocusFaceModeEnabled;
        synchronized (this) {
            cameraAutoFocusFaceModeEnabled = YYCamera.getInstance().setCameraAutoFocusFaceModeEnabled(z);
        }
        return cameraAutoFocusFaceModeEnabled;
    }

    public boolean isFrontCamera() {
        boolean isCameraFront;
        synchronized (this) {
            isCameraFront = YYCamera.getInstance().isCameraFront();
        }
        return isCameraFront;
    }

    public int getCameraOrientation() {
        int cameraOrientation;
        synchronized (this) {
            cameraOrientation = YYCamera.getInstance().getCameraOrientation();
        }
        return cameraOrientation;
    }

    public int setCaptureReplaceImage(Bitmap bitmap) {
        this.mCaptureReplaceBitmap = bitmap;
        if (this.mExternalVideoLiveSessionYCloud != null) {
            return ThunderRtcConstant.ThunderRet.THUNDER_RET_INVALID_VIDEO_SOURCE;
        }
        if (this.mVideoLiveSessionYCloud != null) {
            this.mVideoLiveSessionYCloud.setCaptureReplaceImage(this.mCaptureReplaceBitmap);
        }
        if (this.mScreenLiveSessionYCloud != null) {
            this.mScreenLiveSessionYCloud.setCaptureReplaceImage(this.mCaptureReplaceBitmap);
        }
        return 0;
    }

    public Bitmap captureLocalScreenShot() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mLocalBitmap = null;
        if (this.mVideoLiveSessionYCloud != null && this.mCameraSurfaceView != null && this.mCameraOpened) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.mVideoLiveSessionYCloud.takeScreenShot(new ScreenShotCallback() { // from class: com.yy.mediaframework.YMFLiveAPI.1
                @Override // com.yy.mediaframework.screenshot.ScreenShotCallback
                public void onTaked(Bitmap bitmap) {
                    YMFLiveAPI.this.mLocalBitmap = bitmap;
                    countDownLatch.countDown();
                }

                @Override // com.yy.mediaframework.screenshot.ScreenShotCallback
                public void onError(Throwable th) {
                    YMFLog.error(this, "[Preview ]", "Screenshot onError!");
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(500L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                YMFLog.error(this, "[Preview ]", "captureLocalScreenShot barrier.await exception:" + e.toString());
            }
        }
        YMFLog.info(TAG, "[Preview ]", "captureLocalScreenShot end,bitmap is null?" + (this.mLocalBitmap == null ? "y" : "n") + " detal time = " + (System.currentTimeMillis() - currentTimeMillis));
        return this.mLocalBitmap;
    }

    public void notifyChangeVideoSourceState() {
        YMFLog.info(this, "[Api     ]", " notifyChangeVideoSourceState.. ");
        YMFStreamSyncSourceManager.getInstance().changeVideoSource();
    }

    @Override // com.yy.mediaframework.CameraListener
    public void notifyCameraPreviewParameter(int i, int i2, int i3, CameraInterface.CameraResolutionMode cameraResolutionMode) {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void notifyCameraOpenSuccess() {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void notifyCameraOpenFail(String str) {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onDualOpen(boolean z) {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onDualPictureSwitch() {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void reSetEncodingState() {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onCameraFocusAreaChanged(Rect rect) {
        if (this.mCameraListener != null) {
            this.mCameraListener.onCameraFocusAreaChanged(rect);
        }
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onCameraExposureAreaChanged(Rect rect) {
        if (this.mCameraListener != null) {
            this.mCameraListener.onCameraExposureAreaChanged(rect);
        }
    }

    public static int getSupportH265EncodeProperty() {
        return YYVideoCodec.getSupportH265Property();
    }
}
