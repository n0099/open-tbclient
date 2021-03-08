package com.yy.mediaframework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.mobstat.Config;
import com.yy.mediaframework.CameraInterface;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.ExternalInterface;
import com.yy.mediaframework.GetAnchorStatInfoInterface;
import com.yy.mediaframework.api.YMFEncoderStatisticInfo;
import com.yy.mediaframework.api.YMFVideoEncodeFrame;
import com.yy.mediaframework.background.Background;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.base.YMFLowStreamEncoderConfig;
import com.yy.mediaframework.base.YYUserLiveConfig;
import com.yy.mediaframework.facedetection.CameraPreviewCallbackHost;
import com.yy.mediaframework.facedetection.PreviewFrameCallback;
import com.yy.mediaframework.filters.CameraCaptureFilter;
import com.yy.mediaframework.filters.ClipFilter;
import com.yy.mediaframework.filters.ExternalDecoderFilter;
import com.yy.mediaframework.filters.GPUPreprocessFilter;
import com.yy.mediaframework.filters.LiveSessionType;
import com.yy.mediaframework.filters.OriginDataEntryFilter;
import com.yy.mediaframework.filters.PeripheralsDecoderFilter;
import com.yy.mediaframework.filters.PreviewFilter;
import com.yy.mediaframework.filters.VideoEncoderGroupFilter;
import com.yy.mediaframework.filters.VideoEndPointFilter;
import com.yy.mediaframework.filters.VideoLiveFilterContext;
import com.yy.mediaframework.filters.YMFCaptureReplaceImageFilter;
import com.yy.mediaframework.filters.YMFNV21ToTextureFilter;
import com.yy.mediaframework.filters.YMFProcessGroupFilter;
import com.yy.mediaframework.gles.EglFactory;
import com.yy.mediaframework.gpuimage.FilterType;
import com.yy.mediaframework.gpuimage.custom.IGPUProcess;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import com.yy.mediaframework.inteligence.dynamictexture.IDynamicTexture;
import com.yy.mediaframework.model.AbstractSurfaceInfo;
import com.yy.mediaframework.model.DecodeVideoConfig;
import com.yy.mediaframework.model.DecodeVideoSample;
import com.yy.mediaframework.model.ExternalDecodeInfo;
import com.yy.mediaframework.model.ExternalYYMediaSample;
import com.yy.mediaframework.model.Rect;
import com.yy.mediaframework.model.SurfaceHolderInfo;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.opengles.YMFPreviewCanvasView;
import com.yy.mediaframework.opengles.YMFPreviewView;
import com.yy.mediaframework.screenshot.ScreenShot;
import com.yy.mediaframework.screenshot.ScreenShotCallback;
import com.yy.mediaframework.sensor.RotationVectorSensor;
import com.yy.mediaframework.stat.UploadStatManager;
import com.yy.mediaframework.stat.VideoDataStatUtil;
import com.yy.mediaframework.stat.YMFLiveUsrBehaviorStat;
import com.yy.mediaframework.utils.TimeUtil;
import com.yy.mediaframework.utils.YMFLog;
import com.yy.mediaframework.watermark.WaterMark;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class VideoLiveSessionYCloud implements SurfaceHolder.Callback, CameraListener, GetAnchorStatInfoInterface.IGetCurrentCameraEncodeStatInfo, GetAnchorStatInfoInterface.IGetImageFilterInfo, IEncoderListener, ILiveSession, IMediaCodecUpload, IYYVideoSurfaceInfoListener {
    private static final String TAG = "[VideoLiveSessionYCloud]";
    private float mBeautyIntensity;
    public CameraCaptureFilter mCaptureFilter;
    public YMFCaptureReplaceImageFilter mCaptureReplaceImageFilter;
    public ClipFilter mCliperFilter;
    public VideoEncoderGroupFilter mEncoderGroupFilter;
    public VideoEndPointFilter mEndPointFilter;
    public ExternalDecoderFilter mExternalDecoderFilter;
    public VideoLiveFilterContext mFilterContext;
    private YMFNV21ToTextureFilter mNv21ToTextureFilter;
    public PeripheralsDecoderFilter mPeripheralsDecoderFilter;
    public GPUPreprocessFilter mPreprocessFilter;
    public PreviewFilter mPreviewFilter;
    public YMFProcessGroupFilter mProcessGroupFilter;
    private RotationVectorSensor mRotationVectorSensor;
    private ScreenShot mScreenShot;
    private Bitmap mWaterMarkBitmap;
    private WeakReference<IEncoderListener> mEncoderListener = new WeakReference<>(null);
    private WeakReference<CameraListener> mCameraListener = new WeakReference<>(null);
    private AtomicBoolean mHardwareEncoderAvailable = new AtomicBoolean(true);
    private SurfaceView mCameraSurfaceView = null;
    private FilterType mFilterType = FilterType.Normal;
    private VideoEncoderConfig mVideoEncoderConfig = new VideoEncoderConfig();
    private IDynamicTexture mDynamicTexture = null;
    private Object mSurfaceSync = new Object();
    private int mSurfaceWidth = 0;
    private int mSurfaceHeight = 0;
    private float mWaterMakeW = 0.0f;
    private float mWaterMakeH = 0.0f;
    private float mWaterMakeX = 0.0f;
    private float mWaterMakeY = 0.0f;
    private CameraPreviewCallbackHost mPreviewCallbackHost = new CameraPreviewCallbackHost();
    private OriginDataEntryFilter mOriginDataFilter = null;
    public VideoEncoderConfig mTmpVideoEncoderConfig = null;
    public VideoEncoderConfig mTmpAssignVideoEncoderConfig = null;

    public void setScaleMode(Constant.ScaleMode scaleMode) {
        if (this.mFilterContext != null && !this.mFilterContext.isUseYuvCapture()) {
            if (this.mPreviewFilter != null) {
                this.mPreviewFilter.setScaleMode(scaleMode);
            }
        } else if (this.mProcessGroupFilter != null) {
            this.mProcessGroupFilter.setScaleMode(scaleMode);
        }
    }

    public VideoLiveSessionYCloud(Context context, Constant.VideoStreamType videoStreamType) {
        this.mCaptureFilter = null;
        this.mPreprocessFilter = null;
        this.mProcessGroupFilter = null;
        this.mCliperFilter = null;
        this.mPreviewFilter = null;
        this.mEncoderGroupFilter = null;
        this.mFilterContext = null;
        this.mEndPointFilter = null;
        this.mCaptureReplaceImageFilter = null;
        this.mRotationVectorSensor = null;
        this.mScreenShot = null;
        synchronized (this.mSurfaceSync) {
            this.mFilterContext = new VideoLiveFilterContext(context, videoStreamType);
            this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_NORMAL);
            this.mFilterContext.setAndroidContext(context);
            this.mRotationVectorSensor = new RotationVectorSensor(context);
            this.mFilterContext.setRvSensor(this.mRotationVectorSensor);
            this.mScreenShot = new ScreenShot(context, this.mFilterContext);
            this.mFilterContext.setScreenShot(this.mScreenShot);
            this.mCaptureFilter = new CameraCaptureFilter(this.mFilterContext);
            this.mCliperFilter = new ClipFilter();
            this.mCaptureReplaceImageFilter = new YMFCaptureReplaceImageFilter(this.mFilterContext);
            if (this.mFilterContext.isYuvTextureMode()) {
                this.mNv21ToTextureFilter = new YMFNV21ToTextureFilter(this.mFilterContext);
                this.mPreprocessFilter = new GPUPreprocessFilter(this.mFilterContext);
                this.mPreviewFilter = new PreviewFilter(this.mFilterContext);
            } else if (!this.mFilterContext.isUseYuvCapture()) {
                this.mPreprocessFilter = new GPUPreprocessFilter(this.mFilterContext);
                this.mPreviewFilter = new PreviewFilter(this.mFilterContext);
            } else {
                this.mProcessGroupFilter = new YMFProcessGroupFilter(this.mFilterContext);
            }
            this.mEncoderGroupFilter = new VideoEncoderGroupFilter(this.mFilterContext, this);
            this.mEndPointFilter = new VideoEndPointFilter(this.mFilterContext);
            this.mEncoderGroupFilter.setEncoderListener(this);
        }
        if (this.mFilterContext.isYuvTextureMode()) {
            YMFLog.info(this, "[Procedur]", "mFilterContext.isYuvTextureMode:true ");
            this.mCaptureFilter.addDownStream(this.mNv21ToTextureFilter.addDownStream(this.mPreprocessFilter.addDownStream(this.mCaptureReplaceImageFilter.addDownStream(this.mCliperFilter.addDownStream(this.mEncoderGroupFilter).addDownStream(this.mPreviewFilter))).addDownStream(this.mEndPointFilter)));
        } else if (!this.mFilterContext.isUseYuvCapture()) {
            YMFLog.info(this, "[Procedur]", "mFilterContext.isYuvTextureMode:false,YuvCapture:false ");
            this.mCaptureFilter.addDownStream(this.mPreprocessFilter.addDownStream(this.mCaptureReplaceImageFilter.addDownStream(this.mCliperFilter.addDownStream(this.mEncoderGroupFilter).addDownStream(this.mPreviewFilter))).addDownStream(this.mEndPointFilter));
        } else {
            YMFLog.info(this, "[Procedur]", "mFilterContext.isYuvTextureMode:false,YuvCapture:true");
            this.mCaptureFilter.addDownStream(this.mCaptureReplaceImageFilter.addDownStream(this.mCliperFilter.addDownStream(this.mProcessGroupFilter.addDownStream(this.mEncoderGroupFilter))).addDownStream(this.mEndPointFilter));
        }
        this.mFilterContext.getGlManager().registerFilter(this.mPeripheralsDecoderFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mExternalDecoderFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mCaptureFilter);
        if (this.mFilterContext.isYuvTextureMode()) {
            this.mFilterContext.getGlManager().registerFilter(this.mNv21ToTextureFilter);
            this.mFilterContext.getGlManager().registerFilter(this.mPreviewFilter);
            this.mFilterContext.getGlManager().registerFilter(this.mPreprocessFilter);
        } else if (!this.mFilterContext.isUseYuvCapture()) {
            this.mFilterContext.getGlManager().registerFilter(this.mPreviewFilter);
            this.mFilterContext.getGlManager().registerFilter(this.mPreprocessFilter);
        } else {
            this.mFilterContext.getGlManager().registerFilter(this.mProcessGroupFilter);
        }
        this.mFilterContext.getGlManager().registerFilter(this.mCliperFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mEncoderGroupFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mEndPointFilter);
        this.mFilterContext.getGLManager().registerFilter(this.mCaptureReplaceImageFilter);
        UploadStatManager.getInstance().setIGetCurrentCameraStatInfo(this);
        UploadStatManager.getInstance().setIGetImageFilterInfo(this);
        YMFLog.info(this, "[Procedur]", "videoLiveSession #### use " + this.mFilterContext.getVideoFlowInfomation() + " isEmulator:" + YYVideoSDK.getInstance().mIsEmulator);
    }

    private void startPreview(final int i, final int i2, final int i3, final CameraInterface.CameraResolutionMode cameraResolutionMode) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.1
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSessionYCloud.this.mFilterContext.updateCameraPreviewConfig(i, i2, i3, cameraResolutionMode);
                YMFLog.info(this, "[Preview ]", "startPreview, previewWidth:" + VideoLiveSessionYCloud.this.mFilterContext.getCameraPreviewConfig().getWidth() + " previewHeight:" + VideoLiveSessionYCloud.this.mFilterContext.getCameraPreviewConfig().getHeight());
                VideoLiveSessionYCloud.this.mCaptureFilter.init();
                if (!VideoLiveSessionYCloud.this.mFilterContext.isUseYuvCapture()) {
                    VideoLiveSessionYCloud.this.mPreprocessFilter.init(i, i2);
                    VideoLiveSessionYCloud.this.mPreviewFilter.init(i, i2);
                }
                VideoLiveSessionYCloud.this.mPreviewCallbackHost.setPreviewCallbackWithBuffer();
                VideoLiveSessionYCloud.this.mPreviewCallbackHost.updatePreviewSize(i, i2);
                if (VideoLiveSessionYCloud.this.mFilterContext.isUseYuvCapture() || VideoLiveSessionYCloud.this.mFilterContext.isYuvTextureMode()) {
                    VideoLiveSessionYCloud.this.mPreviewCallbackHost.setYMFPreviewFrameCallback(VideoLiveSessionYCloud.this.mCaptureFilter);
                }
                if (VideoLiveSessionYCloud.this.mTmpVideoEncoderConfig != null) {
                    VideoLiveSessionYCloud.this.setEncoderConfig(VideoLiveSessionYCloud.this.mTmpVideoEncoderConfig);
                    VideoLiveSessionYCloud.this.mTmpVideoEncoderConfig = null;
                } else if (VideoLiveSessionYCloud.this.mTmpAssignVideoEncoderConfig != null) {
                    VideoLiveSessionYCloud.this.assignEncoderConfig(VideoLiveSessionYCloud.this.mTmpAssignVideoEncoderConfig);
                    VideoLiveSessionYCloud.this.mTmpAssignVideoEncoderConfig = null;
                }
                CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CameraInterface.getInstance().startPreviewWithSurfaceTexture(VideoLiveSessionYCloud.this.mCaptureFilter.getCaptureSurfaceTextures(), VideoLiveSessionYCloud.this.mCaptureFilter);
                    }
                });
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void stopAndRelease() {
        YMFLog.info(this, "[Procedur]", "VideoLiveSession stopAndRelease begin");
        UploadStatManager.getInstance().setIGetCurrentCameraStatInfo(null);
        UploadStatManager.getInstance().setIGetImageFilterInfo(null);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoLiveSessionYCloud.this.mFilterContext.getScreenShot() != null) {
                    VideoLiveSessionYCloud.this.mFilterContext.getScreenShot().deInit();
                }
                if (VideoLiveSessionYCloud.this.mFilterContext.getDynamicTexture() != null) {
                    VideoLiveSessionYCloud.this.mFilterContext.getDynamicTexture().onRelease();
                    VideoLiveSessionYCloud.this.mFilterContext.setDynamicTexture(null);
                }
                if (VideoLiveSessionYCloud.this.mFilterContext.getWaterMarkTexture() != null) {
                    VideoLiveSessionYCloud.this.mFilterContext.getWaterMarkTexture().destroy();
                    VideoLiveSessionYCloud.this.mFilterContext.setWaterMarkTexture(null);
                }
                if (VideoLiveSessionYCloud.this.mFilterContext.getBackgroundTexture() != null) {
                    VideoLiveSessionYCloud.this.mFilterContext.getBackgroundTexture().destroy();
                    VideoLiveSessionYCloud.this.mFilterContext.setBackgroundTexture(null);
                }
                UploadStatManager.getInstance().stopStat();
                VideoLiveSessionYCloud.this.mFilterContext.getGLManager().quit();
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(1500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            YMFLog.error(this, "[Preview ]", "stopAndRelease timeout exception:" + e.toString());
        }
        stopRvSensor();
        this.mCameraSurfaceView = null;
        this.mRotationVectorSensor = null;
        YMFLog.info(this, "[Procedur]", "VideoLiveSession stopAndRelease done");
        VideoDataStatUtil.clearPtsTimes(1001L);
    }

    public void updateSurfaceViewInfo() {
        if (this.mCameraSurfaceView != null) {
            YMFLog.info(this, "[Preview ]", "updateSurfaceViewInfo:" + this.mCameraSurfaceView.getWidth() + Config.EVENT_HEAT_X + this.mCameraSurfaceView.getHeight() + ":" + (Build.VERSION.SDK_INT >= 19 ? Boolean.valueOf(this.mCameraSurfaceView.isAttachedToWindow()) : Integer.valueOf(this.mCameraSurfaceView.getVisibility())));
            if (this.mCameraSurfaceView.getWidth() != 0 || this.mCameraSurfaceView.getHeight() != 0) {
                YMFLiveUsrBehaviorStat.getInstance().notifyPreviewViewOnSurfaceState(true, this.mCameraSurfaceView.getWidth(), this.mCameraSurfaceView.getHeight());
                onSurfaceInfoEvent(2, EglFactory.newSurfaceInfo(this.mCameraSurfaceView.getHolder(), this.mCameraSurfaceView.getWidth(), this.mCameraSurfaceView.getHeight()));
            }
        }
    }

    public void setDeltaYYPtsMillions(final long j) {
        YMFLog.info(this, "[Encoder ]", "setDeltaYYPtsMillions:" + j);
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.3
            @Override // java.lang.Runnable
            public void run() {
                YYVideoSDK.getInstance().setDeltaYYPtsMillions(j);
            }
        });
    }

    @Override // com.yy.mediaframework.CameraListener
    public void reSetEncodingState() {
        this.mFilterContext.getGlManager().postDelayed(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.4
            @Override // java.lang.Runnable
            public void run() {
                if (VideoLiveSessionYCloud.this.mEncoderGroupFilter != null) {
                    VideoLiveSessionYCloud.this.mEncoderGroupFilter.reSetEncodingState();
                }
            }
        }, 300);
    }

    public void reSetPreviewState() {
        YMFLog.info(this, "[Preview ]", "reSetPreviewState...");
        if (this.mPreviewFilter != null) {
            this.mPreviewFilter.reSetPreviewState();
        }
        if (this.mProcessGroupFilter != null) {
            this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.5
                @Override // java.lang.Runnable
                public void run() {
                    VideoLiveSessionYCloud.this.mProcessGroupFilter.reSetPreviewState();
                }
            });
        }
    }

    public void setPreviewSurfaceView(SurfaceView surfaceView) {
        YMFLog.info(this, "[Preview ]", "setPreviewSurfaceView:" + surfaceView);
        if (surfaceView != null) {
            YMFLiveUsrBehaviorStat.getInstance().notifyVideoPreviewViewState(true);
        } else {
            YMFLiveUsrBehaviorStat.getInstance().notifyVideoPreviewViewState(false);
        }
        if (this.mFilterContext.isUseYuvCapture()) {
            this.mProcessGroupFilter.setPreviewView(surfaceView);
        }
        if (this.mPreviewFilter != null) {
            this.mPreviewFilter.drawBlackScreen(surfaceView == null);
        } else {
            this.mProcessGroupFilter.drawBlackScreen(surfaceView == null);
            if (surfaceView == null || (surfaceView instanceof YMFPreviewView)) {
                return;
            }
        }
        try {
            if (this.mCameraSurfaceView != null && this.mCameraSurfaceView != surfaceView) {
                this.mCameraSurfaceView.getHolder().removeCallback(this);
                this.mCameraSurfaceView = null;
            }
        } catch (Exception e) {
            YMFLog.warn(this, "[Preview ]", "old mCameraSurfaceView remove exception:" + e.toString());
        }
        this.mCameraSurfaceView = surfaceView;
        if (this.mCameraSurfaceView != null) {
            this.mCameraSurfaceView.getHolder().addCallback(this);
        }
        updateSurfaceViewInfo();
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setWaterMark(final WaterMark waterMark) {
        YMFLog.info(this, "[Beauty  ]", "setWaterMark, waterMark==null? " + (waterMark == null ? "y" : "n"));
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.6
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSessionYCloud.this.mFilterContext.setWaterMarkTexture(waterMark);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void startEncoder() {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.7
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSessionYCloud.this.mFilterContext.getUserLiveConfig();
                if (!VideoLiveSessionYCloud.this.isHardwareEncoderAvailable()) {
                    VideoLiveSessionYCloud.this.mFilterContext.mVideoEncoderConfig.mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
                }
                if (VideoLiveSessionYCloud.this.mEncoderGroupFilter.isEnable()) {
                    YMFLog.info(this, "[Encoder ]", "encoder is started already!!");
                    return;
                }
                try {
                    if (VideoLiveSessionYCloud.this.mEncoderGroupFilter.startEncode(VideoLiveSessionYCloud.this.mFilterContext.getVideoEncoderConfig())) {
                        UploadStatManager.getInstance().startStat();
                    }
                } catch (Exception e) {
                    YMFLog.error(this, "[Encoder ]", "startEncode exception:" + e);
                }
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void stopEncoder() {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.8
            @Override // java.lang.Runnable
            public void run() {
                UploadStatManager.getInstance().stopStat();
                if (VideoLiveSessionYCloud.this.mEncoderGroupFilter.isEnable()) {
                    VideoLiveSessionYCloud.this.mEncoderGroupFilter.stopEncode();
                }
            }
        });
    }

    @Override // com.yy.mediaframework.IYYVideoSurfaceInfoListener
    public void onSurfaceInfoEvent(int i, final AbstractSurfaceInfo abstractSurfaceInfo) {
        if (!this.mFilterContext.isUseYuvCapture()) {
            if (abstractSurfaceInfo != null) {
                YMFLog.info(this, "[Preview ]", "onSurfaceInfoEvent evtType:" + i + " width:" + abstractSurfaceInfo.mWidth + " height:" + abstractSurfaceInfo.mHeight);
            } else {
                YMFLog.info(this, "[Preview ]", "onSurfaceInfoEvent evtType:" + i);
            }
            switch (i) {
                case 1:
                case 2:
                    synchronized (this.mSurfaceSync) {
                        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (VideoLiveSessionYCloud.this.mPreviewFilter != null) {
                                    VideoLiveSessionYCloud.this.mPreviewFilter.onSurfaceChanged(abstractSurfaceInfo);
                                    VideoLiveSessionYCloud.this.mSurfaceWidth = abstractSurfaceInfo.mWidth;
                                    VideoLiveSessionYCloud.this.mSurfaceHeight = abstractSurfaceInfo.mHeight;
                                    VideoLiveSessionYCloud.this.mFilterContext.mSurfaceDestoryStateLock.lock();
                                    VideoLiveSessionYCloud.this.mFilterContext.mSurfaceDestoryState.set(false);
                                    VideoLiveSessionYCloud.this.mFilterContext.mSurfaceDestoryStateLock.unlock();
                                }
                            }
                        });
                    }
                    return;
                case 3:
                    if (this.mPreviewFilter != null) {
                        this.mFilterContext.mSurfaceDestoryStateLock.lock();
                        this.mFilterContext.mSurfaceDestoryState.set(true);
                        this.mFilterContext.mSurfaceDestoryStateLock.unlock();
                    }
                    this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoLiveSessionYCloud.this.mPreviewFilter != null) {
                                VideoLiveSessionYCloud.this.mPreviewFilter.onSurfaceDestroy();
                            }
                        }
                    });
                    return;
                default:
                    return;
            }
        } else if (this.mFilterContext.isUseCanvasSurfaceView()) {
            synchronized (this.mSurfaceSync) {
                this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if ((VideoLiveSessionYCloud.this.mCameraSurfaceView instanceof YMFPreviewCanvasView) && (abstractSurfaceInfo instanceof SurfaceHolderInfo)) {
                            ((YMFPreviewCanvasView) VideoLiveSessionYCloud.this.mCameraSurfaceView).surfaceChanged(((SurfaceHolderInfo) abstractSurfaceInfo).mSurfaceHolder, 4, abstractSurfaceInfo.mWidth, abstractSurfaceInfo.mHeight);
                        }
                    }
                });
            }
        }
    }

    public void setFilterInfo(final FilterType filterType, final Map<String, String> map) {
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.12
            @Override // java.lang.Runnable
            public void run() {
                if (VideoLiveSessionYCloud.this.mPreprocessFilter != null) {
                    VideoLiveSessionYCloud.this.mPreprocessFilter.setFilterInfo(filterType, map);
                }
            }
        });
    }

    public void setFilterType(final FilterType filterType) {
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.13
            @Override // java.lang.Runnable
            public void run() {
                if (VideoLiveSessionYCloud.this.mPreprocessFilter != null) {
                    VideoLiveSessionYCloud.this.mPreprocessFilter.setFilterType(filterType);
                }
            }
        });
    }

    public FilterType getFilterType() {
        return this.mFilterType;
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setWaterMark(Bitmap bitmap, int i, int i2) {
        if (this.mVideoEncoderConfig != null) {
            YMFLog.info(this, "[Beauty  ]", "setWaterMark, bitmap==null? " + (bitmap == null ? "y" : "n") + "<" + i + "." + i2 + ">");
            this.mWaterMarkBitmap = bitmap;
            if (bitmap == null) {
                setWaterMark(null);
            } else if (bitmap != null && bitmap != null && (bitmap.getWidth() + i > this.mVideoEncoderConfig.mEncodeWidth || bitmap.getHeight() + i2 > this.mVideoEncoderConfig.mEncodeHeight)) {
                YMFLog.error(this, "[Beauty  ]", "setWaterMark error:" + bitmap.getWidth() + "(bitmapWigth)+" + i + "(offestX)>" + this.mVideoEncoderConfig.mEncodeWidth + "(encodeWidth) OR " + bitmap.getHeight() + "(bitmapHeight)+" + i2 + "(offsetY)>" + this.mVideoEncoderConfig.mEncodeHeight + "(encodeHeight)");
                setWaterMark(null);
            } else {
                this.mWaterMakeX = i / this.mVideoEncoderConfig.mEncodeWidth;
                this.mWaterMakeY = i2 / this.mVideoEncoderConfig.mEncodeHeight;
                this.mWaterMakeW = bitmap.getWidth() / this.mVideoEncoderConfig.mEncodeWidth;
                this.mWaterMakeH = bitmap.getHeight() / this.mVideoEncoderConfig.mEncodeHeight;
                int i3 = (int) (this.mVideoEncoderConfig.mEncodeWidth * this.mWaterMakeX);
                int i4 = (int) (this.mVideoEncoderConfig.mEncodeHeight * this.mWaterMakeY);
                Matrix matrix = new Matrix();
                matrix.postScale(((int) (this.mVideoEncoderConfig.mEncodeWidth * this.mWaterMakeW)) / this.mWaterMarkBitmap.getWidth(), ((int) (this.mVideoEncoderConfig.mEncodeHeight * this.mWaterMakeH)) / this.mWaterMarkBitmap.getHeight());
                setWaterMark(new WaterMark(Bitmap.createBitmap(this.mWaterMarkBitmap, 0, 0, this.mWaterMarkBitmap.getWidth(), this.mWaterMarkBitmap.getHeight(), matrix, false), this.mVideoEncoderConfig.mEncodeWidth, this.mVideoEncoderConfig.mEncodeHeight, i3, i4, WaterMark.Align.LeftTop));
            }
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setBackground(final Background background) {
        YMFLog.info(this, "[Preview ]", "setBackground, background ==null? " + (background == null ? "y" : "n"));
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.14
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSessionYCloud.this.mFilterContext.setBackgroundTexture(background);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setDynamicTexture(final IDynamicTexture iDynamicTexture) {
        this.mDynamicTexture = iDynamicTexture;
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.15
            @Override // java.lang.Runnable
            public void run() {
                YMFLog.info(this, "[Beauty  ]", "setDynamicTexture");
                VideoLiveSessionYCloud.this.mFilterContext.setDynamicTexture(iDynamicTexture);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void takeScreenShot(ScreenShotCallback screenShotCallback) {
        this.mScreenShot.setCallback(screenShotCallback);
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setNetworkBitrateSuggest(final int i) {
        YMFLog.info(this, "[Encoder ]", "setNetworkBitrateSuggest:" + i);
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.16
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSessionYCloud.this.mEncoderGroupFilter.setNetworkBitrateSuggest(i);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setResolutionModifyConfigs(final List<ResolutionModifyConfig> list, final int i) {
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.17
            @Override // java.lang.Runnable
            public void run() {
                if (YYVideoSDK.getInstance().mIsEmulator) {
                    for (ResolutionModifyConfig resolutionModifyConfig : list) {
                        resolutionModifyConfig.videoEncoderType = VideoEncoderType.SOFT_ENCODER_X264;
                        resolutionModifyConfig.encoderParams = "";
                    }
                }
                VideoLiveSessionYCloud.this.mEncoderGroupFilter.setResolutionModifyConfigs(list, i);
            }
        });
    }

    public void setDeliverCallback(IYMFDeliverCallback iYMFDeliverCallback) {
        this.mFilterContext.setDeliverCallback(iYMFDeliverCallback);
    }

    public void setCameraListener(CameraListener cameraListener) {
        this.mCameraListener = new WeakReference<>(cameraListener);
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setEncoderListener(final IEncoderListener iEncoderListener) {
        if (iEncoderListener == null) {
            YMFLog.info(this, "[Encoder ]", "setEncoderlistener:" + iEncoderListener);
            this.mEncoderListener = new WeakReference<>(iEncoderListener);
            if (iEncoderListener != null) {
                iEncoderListener.onEncodeEncParam(this.mFilterContext.getEncodeParamTipsMgr().getParam());
                return;
            }
            return;
        }
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.18
            @Override // java.lang.Runnable
            public void run() {
                YMFLog.info(this, "[Encoder ]", "setEncoderlistener:" + iEncoderListener);
                VideoLiveSessionYCloud.this.mEncoderListener = new WeakReference(iEncoderListener);
                if (iEncoderListener != null) {
                    iEncoderListener.onEncodeEncParam(VideoLiveSessionYCloud.this.mFilterContext.getEncodeParamTipsMgr().getParam());
                }
            }
        });
    }

    public void assignEncoderConfig(VideoEncoderConfig videoEncoderConfig) {
        YMFLog.info(this, "[Encoder ]", "assignEncoderConfig:" + videoEncoderConfig.toString());
        this.mVideoEncoderConfig = videoEncoderConfig;
        if (YYVideoSDK.getInstance().mIsEmulator) {
            this.mVideoEncoderConfig.mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
        }
        if (!this.mFilterContext.getGLManager().checkSameThread()) {
            this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.19
                @Override // java.lang.Runnable
                public void run() {
                    VideoLiveSessionYCloud.this.mFilterContext.getVideoEncoderConfig().assign(VideoLiveSessionYCloud.this.mVideoEncoderConfig);
                    if (VideoLiveSessionYCloud.this.mFilterContext.mChangeEncoderFlag.get() && VideoLiveSessionYCloud.this.mEncoderGroupFilter.isEnable()) {
                        VideoLiveSessionYCloud.this.mEncoderGroupFilter.stopEncode();
                        VideoLiveSessionYCloud.this.mEncoderGroupFilter.startEncode(VideoLiveSessionYCloud.this.mVideoEncoderConfig);
                    }
                }
            });
            return;
        }
        this.mFilterContext.getVideoEncoderConfig().assign(this.mVideoEncoderConfig);
        if (this.mFilterContext.mChangeEncoderFlag.get() && this.mEncoderGroupFilter.isEnable()) {
            this.mEncoderGroupFilter.stopEncode();
            this.mEncoderGroupFilter.startEncode(this.mVideoEncoderConfig);
        }
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setEncoderConfig(final VideoEncoderConfig videoEncoderConfig) {
        YMFLog.info(this, "[Encoder ]", "setEncoderconfig:" + videoEncoderConfig.toString());
        this.mVideoEncoderConfig = videoEncoderConfig;
        if (YYVideoSDK.getInstance().mIsEmulator) {
            this.mVideoEncoderConfig.mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
        }
        if (!this.mFilterContext.getGLManager().checkSameThread()) {
            this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.20
                @Override // java.lang.Runnable
                public void run() {
                    VideoLiveSessionYCloud.this.mFilterContext.getVideoEncoderConfig().assign(VideoLiveSessionYCloud.this.mVideoEncoderConfig);
                    YMFLog.info(this, "[Encoder ]", "setEncoderConfig:" + VideoLiveSessionYCloud.this.mFilterContext.getVideoEncoderConfig().toString());
                    VideoLiveSessionYCloud.this.mFilterContext.getDefaultVideoEncoderConfig().assign(VideoLiveSessionYCloud.this.mVideoEncoderConfig);
                    if (!VideoLiveSessionYCloud.this.mFilterContext.isUseYuvCapture()) {
                        VideoLiveSessionYCloud.this.mPreprocessFilter.init(VideoLiveSessionYCloud.this.mVideoEncoderConfig.getEncodeWidth(), VideoLiveSessionYCloud.this.mVideoEncoderConfig.getEncodeHeight());
                        VideoLiveSessionYCloud.this.mPreviewFilter.init(videoEncoderConfig.getEncodeWidth(), videoEncoderConfig.getEncodeHeight());
                    }
                    if (VideoLiveSessionYCloud.this.mFilterContext.mChangeEncoderFlag.get() && VideoLiveSessionYCloud.this.mEncoderGroupFilter.isEnable()) {
                        VideoLiveSessionYCloud.this.mEncoderGroupFilter.stopEncode();
                        VideoLiveSessionYCloud.this.mEncoderGroupFilter.startEncode(VideoLiveSessionYCloud.this.mVideoEncoderConfig);
                    }
                    VideoLiveSessionYCloud.this.mEncoderGroupFilter.init();
                    UploadStatManager.getInstance().putSettingBitRate(videoEncoderConfig.getBitRate());
                    UploadStatManager.getInstance().putSettingDPI(videoEncoderConfig.getRealDPI());
                    UploadStatManager.getInstance().putSettingFrameRate(videoEncoderConfig.getFrameRate());
                }
            });
            return;
        }
        this.mFilterContext.getVideoEncoderConfig().assign(this.mVideoEncoderConfig);
        YMFLog.info(this, "[Encoder ]", "setEncoderConfig:" + this.mFilterContext.getVideoEncoderConfig().toString());
        this.mFilterContext.getDefaultVideoEncoderConfig().assign(this.mVideoEncoderConfig);
        if (!this.mFilterContext.isUseYuvCapture()) {
            this.mPreprocessFilter.init(this.mVideoEncoderConfig.getEncodeWidth(), this.mVideoEncoderConfig.getEncodeHeight());
            this.mPreviewFilter.init(videoEncoderConfig.getEncodeWidth(), videoEncoderConfig.getEncodeHeight());
        }
        if (this.mFilterContext.mChangeEncoderFlag.get() && this.mEncoderGroupFilter.isEnable()) {
            this.mEncoderGroupFilter.stopEncode();
            this.mEncoderGroupFilter.startEncode(this.mVideoEncoderConfig);
        }
        this.mEncoderGroupFilter.init();
        UploadStatManager.getInstance().putSettingBitRate(videoEncoderConfig.getBitRate());
        UploadStatManager.getInstance().putSettingDPI(videoEncoderConfig.getRealDPI());
        UploadStatManager.getInstance().putSettingFrameRate(videoEncoderConfig.getFrameRate());
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setLowStreamEncoderConfigs(final List<YMFLowStreamEncoderConfig> list, final boolean z) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.21
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSessionYCloud.this.mFilterContext.setLowStreamEncoderConfigs(list);
                VideoLiveSessionYCloud.this.mFilterContext.enableLowStreamEncoder(z);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setLowDelayMode(final boolean z) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.22
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSessionYCloud.this.mFilterContext.getVideoEncoderConfig().mLowDelay = z;
                YMFLog.info(this, "[Encoder ]", "setLowDelayMode:" + z + " config:" + VideoLiveSessionYCloud.this.mFilterContext.getVideoEncoderConfig().toString());
                if (VideoLiveSessionYCloud.this.mFilterContext.mChangeEncoderFlag.get() && VideoLiveSessionYCloud.this.mEncoderGroupFilter.isEnable()) {
                    VideoLiveSessionYCloud.this.mEncoderGroupFilter.stopEncode();
                    VideoLiveSessionYCloud.this.mEncoderGroupFilter.startEncode(VideoLiveSessionYCloud.this.mVideoEncoderConfig);
                }
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void adjustEncoderBitrate(int i) {
        if (this.mEncoderGroupFilter != null) {
            YMFLog.info(this, "[Encoder ]", "setNetworkBitrateSuggest:" + i);
            this.mEncoderGroupFilter.adjustBitRate((i + 999) / 1000);
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeStat(YMFEncoderStatisticInfo yMFEncoderStatisticInfo) {
        IEncoderListener iEncoderListener = this.mEncoderListener.get();
        if (iEncoderListener != null) {
            iEncoderListener.onEncodeStat(yMFEncoderStatisticInfo);
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeResolution(int i, int i2, int i3) {
        IEncoderListener iEncoderListener = this.mEncoderListener.get();
        if (iEncoderListener != null) {
            iEncoderListener.onEncodeResolution(i, i2, i3);
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeFirstFrame() {
        IEncoderListener iEncoderListener = this.mEncoderListener.get();
        if (iEncoderListener != null) {
            iEncoderListener.onEncodeFirstFrame();
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeFrameData(YMFVideoEncodeFrame yMFVideoEncodeFrame) {
        IEncoderListener iEncoderListener = this.mEncoderListener.get();
        if (iEncoderListener != null) {
            iEncoderListener.onEncodeFrameData(yMFVideoEncodeFrame);
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeEncParam(String str) {
        IEncoderListener iEncoderListener = this.mEncoderListener.get();
        if (iEncoderListener != null) {
            iEncoderListener.onEncodeEncParam(str);
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onHardEncoderError() {
        IEncoderListener iEncoderListener = this.mEncoderListener.get();
        if (iEncoderListener != null) {
            iEncoderListener.onHardEncoderError();
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncoderSwitch() {
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onWaterMarkSizeChange(int i, int i2) {
        YMFLog.info(this, "[Beauty  ]", "onWaterMarkSizeChange w:" + i + " h:" + i2 + "(" + this.mWaterMakeX + "," + this.mWaterMakeY + "," + this.mWaterMakeW + "," + this.mWaterMakeH + ")");
        if (this.mWaterMakeH != 0.0d && this.mWaterMakeW != 0.0d && this.mWaterMarkBitmap != null) {
            int i3 = (int) (i * this.mWaterMakeX);
            int i4 = (int) (i2 * this.mWaterMakeY);
            Matrix matrix = new Matrix();
            matrix.postScale(((int) (i * this.mWaterMakeW)) / this.mWaterMarkBitmap.getWidth(), ((int) (i2 * this.mWaterMakeH)) / this.mWaterMarkBitmap.getHeight());
            setWaterMark(new WaterMark(Bitmap.createBitmap(this.mWaterMarkBitmap, 0, 0, this.mWaterMarkBitmap.getWidth(), this.mWaterMarkBitmap.getHeight(), matrix, false), i, i2, i3, i4, WaterMark.Align.LeftTop));
        }
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void requestIFrame() {
        YMFLog.info(this, "[Encoder ]", "requestIFrame");
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.23
            @Override // java.lang.Runnable
            public void run() {
                if (VideoLiveSessionYCloud.this.mEncoderGroupFilter != null) {
                    VideoLiveSessionYCloud.this.mEncoderGroupFilter.requestSyncFrame();
                }
            }
        });
    }

    public void setUserLiveConfig(final YYUserLiveConfig yYUserLiveConfig) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.24
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSessionYCloud.this.mFilterContext.setUserLiveConfig(yYUserLiveConfig);
            }
        });
    }

    public void enableColorChartLive(final boolean z) {
        YMFLog.info(this, "[Encoder ]", "enableColorChartLive:" + z);
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.25
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSessionYCloud.this.mFilterContext.setColorChartLiveEnable(z);
            }
        });
    }

    @Override // com.yy.mediaframework.CameraListener
    public void notifyCameraPreviewParameter(int i, int i2, int i3, CameraInterface.CameraResolutionMode cameraResolutionMode) {
        YMFLog.info(this, "[Preview ]", "notifyCameraPreviewParameter, width:" + i + " height:" + i2 + " facing:" + i3);
        startPreview(i, i2, i3, cameraResolutionMode);
    }

    @Override // com.yy.mediaframework.CameraListener
    public void notifyCameraOpenSuccess() {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void notifyCameraOpenFail(String str) {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onDualOpen(boolean z) {
        this.mFilterContext.setPictureInPictureFlag(z);
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onDualPictureSwitch() {
        this.mFilterContext.setSwitchPicture();
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onCameraFocusAreaChanged(Rect rect) {
        CameraListener cameraListener = this.mCameraListener.get();
        if (cameraListener != null) {
            cameraListener.onCameraFocusAreaChanged(rect);
        }
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onCameraExposureAreaChanged(Rect rect) {
        CameraListener cameraListener = this.mCameraListener.get();
        if (cameraListener != null) {
            cameraListener.onCameraExposureAreaChanged(rect);
        }
    }

    public void enableMirror(boolean z) {
        YMFLog.info(this, "[Encoder ]", "enableEncodeMirror:" + z);
        if (this.mFilterContext != null) {
            this.mFilterContext.setMirrorFlag(z);
        }
    }

    public void enablePreviewMirror(boolean z) {
        YMFLog.info(this, "[Preview ]", "enablePreviewMirror:" + z);
        if (this.mFilterContext != null) {
            this.mFilterContext.setPreviewMirrorFlag(z);
        }
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setHardwareEncoderAvailable(boolean z) {
        YMFLog.info(this, "[Encoder ]", "HardwareEncoderAvailable set status:" + z);
        this.mHardwareEncoderAvailable.set(z);
    }

    @Override // com.yy.mediaframework.ILiveSession
    public boolean isHardwareEncoderAvailable() {
        YMFLog.info(this, "[Encoder ]", "HardwareEncoderAvailable get status:" + this.mHardwareEncoderAvailable.get());
        return this.mHardwareEncoderAvailable.get();
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void onPeripheralsVideoDataReceived(DecodeVideoSample decodeVideoSample) {
        this.mPeripheralsDecoderFilter.handlePeripheralsVideoData(decodeVideoSample);
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void onPeripheralsVideoConfigReceived(DecodeVideoConfig decodeVideoConfig) {
        this.mPeripheralsDecoderFilter.handlePeripheralsVideoConfig(decodeVideoConfig, this.mPeripheralsDecoderFilter);
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void onPeripheralsVideoEnd() {
        YMFLog.info(this, "[Decoder ]", "onPeripheralsVideoEnd");
        this.mPeripheralsDecoderFilter.handlePerpheralsVideoEnd();
        this.mPeripheralsDecoderFilter.deInit();
        this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_NORMAL);
        this.mPreprocessFilter.onPeripheralsVideoEnd();
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setVideoRenderPosition(final VideoRenderPosition videoRenderPosition) {
        if (videoRenderPosition == null) {
            YMFLog.error(this, "[Decoder ]", "invalid VideoRenderPositon, return");
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.26
                @Override // java.lang.Runnable
                public void run() {
                    VideoLiveSessionYCloud.this.mFilterContext.setVideoRenderPostion(videoRenderPosition);
                }
            });
        }
    }

    public void startRvSensor() {
        YMFLog.info(this, "[Preview ]", "RotationVectorSensor startRvSensor");
        if (this.mRotationVectorSensor != null) {
            this.mRotationVectorSensor.registerSensor();
        }
    }

    public void stopRvSensor() {
        YMFLog.info(this, "[Preview ]", "RotationVectorSensor stopRvSensor");
        if (this.mRotationVectorSensor != null) {
            this.mRotationVectorSensor.unregisterSensor();
        }
    }

    public void onTouch(MotionEvent motionEvent) {
        YYCamera.getInstance().handleFocusMetering(motionEvent);
    }

    public void setTextureListener(final ITextureListener iTextureListener) {
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.27
            @Override // java.lang.Runnable
            public void run() {
                if (VideoLiveSessionYCloud.this.mPreprocessFilter != null) {
                    VideoLiveSessionYCloud.this.mPreprocessFilter.setTextureListener(iTextureListener);
                }
            }
        });
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        YMFLog.info(this, "[Preview ]", "surfaceCreated...");
        onSurfaceInfoEvent(1, EglFactory.newSurfaceInfo(surfaceHolder, 0, 0));
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        YMFLog.info(this, "[Preview ]", "surfaceChanged...");
        YMFLiveUsrBehaviorStat.getInstance().notifyPreviewViewOnSurfaceState(true, i2, i3);
        onSurfaceInfoEvent(2, EglFactory.newSurfaceInfo(surfaceHolder, i2, i3));
        CameraInterface.getInstance().setSurfaceViewSize(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        YMFLog.info(this, "[Preview ]", "surfaceDestroyed...");
        YMFLiveUsrBehaviorStat.getInstance().notifyPreviewViewOnSurfaceState(false, 0, 0);
        onSurfaceInfoEvent(3, null);
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetImageFilterInfo
    public boolean onGetHasBeauty() {
        return isUse(this.mBeautyIntensity);
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetImageFilterInfo
    public boolean onGetHasFaceLift() {
        return false;
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetImageFilterInfo
    public float onGetBeautyLevel() {
        return this.mBeautyIntensity;
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetImageFilterInfo
    public float onGetFaceLiftLevel() {
        return 0.0f;
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetImageFilterInfo
    public boolean onGetHasSticker() {
        return false;
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetImageFilterInfo
    public boolean onGetHasDynamicSticker() {
        if (this.mDynamicTexture == null) {
            return false;
        }
        return true;
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetCurrentCameraEncodeStatInfo
    public int onGetAnchorCurrentBitRate() {
        if (this.mVideoEncoderConfig == null) {
            return 0;
        }
        return this.mVideoEncoderConfig.getBitRate();
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetCurrentCameraEncodeStatInfo
    public int onGetAnchorCurrentFrameRate() {
        if (this.mVideoEncoderConfig == null) {
            return 0;
        }
        return this.mVideoEncoderConfig.getFrameRate();
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetCurrentCameraEncodeStatInfo
    public String onGetAnchorCurrentDIPRate() {
        if (this.mVideoEncoderConfig == null) {
            return "";
        }
        return this.mVideoEncoderConfig.getRealDPI();
    }

    private boolean isUse(float f) {
        if (f <= 1.0E-5f) {
            return false;
        }
        return true;
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setExternalDecodeInterface(ExternalInterface.IExternalDecode iExternalDecode) {
        if (this.mFilterContext != null && iExternalDecode != null) {
            this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_EXTERNAL);
        }
        if (this.mEncoderGroupFilter != null) {
            this.mEncoderGroupFilter.setExternalDecodeCallback(iExternalDecode);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setExternalVideoInterface(ExternalInterface.IExternalCameraData iExternalCameraData) {
        if (this.mFilterContext != null && iExternalCameraData != null) {
            this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_EXTERNAL);
        }
        if (this.mEncoderGroupFilter != null) {
            this.mEncoderGroupFilter.setExternalCameraDataCallback(iExternalCameraData);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void pushEncodeExternalData(ExternalYYMediaSample externalYYMediaSample) {
        YYMediaSample yYMediaSample;
        Object obj = externalYYMediaSample.mSample;
        if (obj instanceof YYMediaSample) {
            yYMediaSample = (YYMediaSample) obj;
            yYMediaSample.mMasterTextureId = externalYYMediaSample.mMasterTextureId;
            yYMediaSample.mYYPtsMillions = externalYYMediaSample.mPts;
        } else {
            yYMediaSample = null;
        }
        if (this.mEncoderGroupFilter != null) {
            this.mEncoderGroupFilter.setIsExternalEncode(true);
            this.mEncoderGroupFilter.processMediaSample(yYMediaSample, null);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setGLManagerRunnable(Runnable runnable) {
        if (this.mFilterContext != null) {
            this.mFilterContext.getGLManager().post(runnable);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void pushExternalVideoDecodeInfo(ExternalDecodeInfo externalDecodeInfo) {
        if (this.mExternalDecoderFilter == null || externalDecodeInfo == null) {
            YMFLog.error(this, "[Decoder ]", "invalid VideoLiveSession or sample is null");
            return;
        }
        this.mExternalDecoderFilter.handleOutdoorVideoConfig(externalDecodeInfo.convertToConfig(), this.mExternalDecoderFilter);
        this.mExternalDecoderFilter.handleOutdoorVideoData(externalDecodeInfo.convertToStreamInfo());
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void onExternalVideoEnd() {
        YMFLog.info(this, "[Decoder ]", "onPeripheralsVideoEnd");
        this.mExternalDecoderFilter.handleExternalVideoEnd();
        this.mExternalDecoderFilter.deInit();
        this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_NORMAL);
        this.mEncoderGroupFilter.onExternalVideoEnd();
    }

    public void setGPUImageBeautyFilter(IGPUProcess iGPUProcess) {
        if (this.mFilterContext.isDisableBeauty() && this.mFilterContext.isUseYuvCapture()) {
            YMFLog.error(this, "[Beauty  ]", "YUV mode unsupport beauty!!!");
        } else if (this.mFilterContext.isUseYuvCapture()) {
            if (this.mProcessGroupFilter != null) {
                this.mProcessGroupFilter.setGpuProcess(iGPUProcess);
            }
        } else if (this.mPreprocessFilter != null) {
            this.mPreprocessFilter.setGPUImageBeautyFilter(iGPUProcess);
        } else {
            YMFLog.error(this, "[Beauty  ]", "setGPUImageBeautyFilter failedmPreprocessFilter == null ");
        }
    }

    public void registerCallback(PreviewFrameCallback previewFrameCallback) {
        if (this.mPreviewCallbackHost != null) {
            this.mPreviewCallbackHost.registerCallback(previewFrameCallback);
        }
    }

    public void unregisterCallback(PreviewFrameCallback previewFrameCallback) {
        if (this.mPreviewCallbackHost != null) {
            this.mPreviewCallbackHost.unregisterCallback(previewFrameCallback);
        }
    }

    public void initOriginDataFilter() {
        if (this.mOriginDataFilter == null) {
            this.mOriginDataFilter = new OriginDataEntryFilter(this.mFilterContext);
            this.mOriginDataFilter.addDownStream(this.mCliperFilter.addDownStream(this.mEncoderGroupFilter).addDownStream(this.mPreviewFilter)).addDownStream(this.mEndPointFilter);
            YMFLog.error(this, "[Encoder ]", "initOriginDataFilter success!");
            return;
        }
        YMFLog.error(this, "[Encoder ]", "initOriginDataFilter is not null");
    }

    public void setOriginFrameToEncode(byte[] bArr, int i, int i2, int i3, int i4, long j) {
        if (this.mOriginDataFilter != null) {
            this.mOriginDataFilter.setOriginFrameToEncode(bArr, i, i2, i3, i4, j == 0 ? TimeUtil.getTickCountLong() : j, 1);
        } else {
            YMFLog.error(this, "[Encoder ]", "OriginDataFilter not init!");
        }
    }

    public void setAbroadNetWorkStrategy(boolean z) {
        if (this.mFilterContext != null) {
            this.mFilterContext.setAbroadNetWorkStrategy(z);
        }
    }

    public boolean getVideoProcessMode() {
        if (this.mFilterContext != null) {
            return this.mFilterContext.isUseYuvCapture();
        }
        return false;
    }

    public boolean getYuvTextureMode() {
        if (this.mFilterContext != null) {
            return this.mFilterContext.isYuvTextureMode();
        }
        return false;
    }

    public int getVideoPreviewMode() {
        if (this.mFilterContext != null && this.mFilterContext.isUseGLSurfaceView()) {
            return Constant.PreviewMode.GlSurfaceMode.ordinal();
        }
        if (this.mFilterContext != null && this.mFilterContext.isUseCanvasSurfaceView()) {
            return Constant.PreviewMode.CanvasMode.ordinal();
        }
        return Constant.PreviewMode.TextureMode.ordinal();
    }

    public int getCurrentCameraFps() {
        if (this.mCaptureFilter != null) {
            return this.mCaptureFilter.getCurrentCameraFps();
        }
        return 0;
    }

    public void setEnableUnderflowStrategy(boolean z) {
        YMFLog.error(this, "[Encoder ]", "setEnableUnderflowStrategy:" + z);
        if (this.mFilterContext != null) {
            this.mFilterContext.setEnableUnderflowStrategy(z);
        }
    }

    public void setCaptureReplaceImage(final Bitmap bitmap) {
        if (this.mFilterContext != null) {
            this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSessionYCloud.28
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoLiveSessionYCloud.this.mCaptureReplaceImageFilter != null) {
                        if (bitmap == null) {
                            VideoLiveSessionYCloud.this.mFilterContext.setCaptureReplaceImageFlag(false);
                        } else {
                            VideoLiveSessionYCloud.this.mFilterContext.setCaptureReplaceImageFlag(true);
                        }
                        VideoLiveSessionYCloud.this.mCaptureReplaceImageFilter.setReplaceBitmap(bitmap);
                        if (VideoLiveSessionYCloud.this.mEncoderGroupFilter != null) {
                            VideoLiveSessionYCloud.this.mEncoderGroupFilter.requestSyncFrame();
                        }
                    }
                }
            });
        }
    }
}
