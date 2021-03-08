package com.yy.mediaframework;

import android.content.Context;
import android.graphics.Bitmap;
import com.yy.mediaframework.CameraInterface;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.ExternalInterface;
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
import com.yy.mediaframework.filters.PeripheralsDecoderFilter;
import com.yy.mediaframework.filters.PreviewFilter;
import com.yy.mediaframework.filters.VideoEncoderGroupFilter;
import com.yy.mediaframework.filters.VideoEndPointFilter;
import com.yy.mediaframework.filters.VideoLiveFilterContext;
import com.yy.mediaframework.gpuimage.FilterType;
import com.yy.mediaframework.gpuimage.custom.IGPUProcess;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import com.yy.mediaframework.inteligence.dynamictexture.IDynamicTexture;
import com.yy.mediaframework.model.AbstractSurfaceInfo;
import com.yy.mediaframework.model.DecodeVideoConfig;
import com.yy.mediaframework.model.DecodeVideoSample;
import com.yy.mediaframework.model.Rect;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.screenshot.ScreenShot;
import com.yy.mediaframework.screenshot.ScreenShotCallback;
import com.yy.mediaframework.sensor.RotationVectorSensor;
import com.yy.mediaframework.stat.UploadStatManager;
import com.yy.mediaframework.stat.VideoDataStatUtil;
import com.yy.mediaframework.utils.YMFLog;
import com.yy.mediaframework.watermark.WaterMark;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class VideoLiveSession implements IEncoderListener, ILiveSession, IYYVideoSurfaceInfoListener {
    private static final String TAG = "VideoLiveSession";
    public CameraCaptureFilter mCaptureFilter;
    public ClipFilter mCliperFilter;
    public VideoEncoderGroupFilter mEncoderGroupFilter;
    public VideoEndPointFilter mEndPointFilter;
    public ExternalDecoderFilter mExternalDecoderFilter;
    public VideoLiveFilterContext mFilterContext;
    public PeripheralsDecoderFilter mPeripheralsDecoderFilter;
    public GPUPreprocessFilter mPreprocessFilter;
    public PreviewFilter mPreviewFilter;
    private RotationVectorSensor mRotationVectorSensor;
    private ScreenShot mScreenShot;
    private WeakReference<IEncoderListener> mEncoderListener = new WeakReference<>(null);
    private AtomicBoolean mHardwareEncoderAvailable = new AtomicBoolean(true);
    private long mLastCountTime = 0;
    private CameraPreviewCallbackHost mPreviewCallbackHost = new CameraPreviewCallbackHost();

    public VideoLiveSession(Context context) {
        this.mCaptureFilter = null;
        this.mPreprocessFilter = null;
        this.mCliperFilter = null;
        this.mPreviewFilter = null;
        this.mEncoderGroupFilter = null;
        this.mFilterContext = null;
        this.mEndPointFilter = null;
        this.mRotationVectorSensor = null;
        this.mFilterContext = new VideoLiveFilterContext(context, Constant.VideoStreamType.Camera);
        this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_NORMAL);
        this.mFilterContext.setAndroidContext(context);
        this.mRotationVectorSensor = new RotationVectorSensor(context);
        this.mFilterContext.setRvSensor(this.mRotationVectorSensor);
        this.mPeripheralsDecoderFilter = new PeripheralsDecoderFilter(this.mFilterContext);
        this.mExternalDecoderFilter = new ExternalDecoderFilter(this.mFilterContext);
        this.mCaptureFilter = new CameraCaptureFilter(this.mFilterContext);
        this.mPreprocessFilter = new GPUPreprocessFilter(this.mFilterContext);
        this.mCliperFilter = new ClipFilter();
        this.mScreenShot = new ScreenShot(context, this.mFilterContext);
        this.mFilterContext.setScreenShot(this.mScreenShot);
        this.mPreviewFilter = new PreviewFilter(this.mFilterContext);
        this.mEncoderGroupFilter = new VideoEncoderGroupFilter(this.mFilterContext, this);
        this.mEndPointFilter = new VideoEndPointFilter(this.mFilterContext);
        this.mEncoderGroupFilter.setEncoderListener(this);
        this.mPeripheralsDecoderFilter.addDownStream(this.mPreprocessFilter);
        this.mExternalDecoderFilter.addDownStream(this.mPreprocessFilter);
        this.mCaptureFilter.addDownStream(this.mPreprocessFilter.addDownStream(this.mCliperFilter.addDownStream(this.mEncoderGroupFilter).addDownStream(this.mPreviewFilter)).addDownStream(this.mEndPointFilter));
        this.mFilterContext.getGlManager().registerFilter(this.mPeripheralsDecoderFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mExternalDecoderFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mCaptureFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mPreprocessFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mCliperFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mPreviewFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mEncoderGroupFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mEndPointFilter);
        YMFLog.info(this, "[Procedur]", "videoLiveSession callbackbuffer screencatpure #### previewFilter clear color buffer");
    }

    public void startPreview(final int i, final int i2, final int i3, final CameraInterface.CameraResolutionMode cameraResolutionMode) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.1
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSession.this.mFilterContext.updateCameraPreviewConfig(i, i2, i3, cameraResolutionMode);
                YMFLog.info(this, "[Preview ]", "startPreview, previewWidth:" + VideoLiveSession.this.mFilterContext.getCameraPreviewConfig().getWidth() + " previewHeight:" + VideoLiveSession.this.mFilterContext.getCameraPreviewConfig().getHeight());
                VideoLiveSession.this.mCaptureFilter.init();
                VideoLiveSession.this.mPreprocessFilter.init(i, i2);
                CameraInterface.getInstance().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CameraInterface.getInstance().startPreviewWithSurfaceTexture(VideoLiveSession.this.mCaptureFilter.getCaptureSurfaceTextures(), VideoLiveSession.this.mCaptureFilter);
                    }
                });
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void stopAndRelease() {
        YMFLog.info(this, "[Procedur]", "VideoLiveSession stopAndRelease begin");
        this.mFilterContext.getGLManager().getHandler().removeCallbacksAndMessages(null);
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoLiveSession.this.mFilterContext.getScreenShot() != null) {
                    VideoLiveSession.this.mFilterContext.getScreenShot().deInit();
                }
                if (VideoLiveSession.this.mFilterContext.getDynamicTexture() != null) {
                    VideoLiveSession.this.mFilterContext.getDynamicTexture().onRelease();
                    VideoLiveSession.this.mFilterContext.setDynamicTexture(null);
                }
                if (VideoLiveSession.this.mFilterContext.getWaterMarkTexture() != null) {
                    VideoLiveSession.this.mFilterContext.getWaterMarkTexture().destroy();
                    VideoLiveSession.this.mFilterContext.setWaterMarkTexture(null);
                }
                if (VideoLiveSession.this.mFilterContext.getBackgroundTexture() != null) {
                    VideoLiveSession.this.mFilterContext.getBackgroundTexture().destroy();
                }
                UploadStatManager.getInstance().stopStat();
                VideoLiveSession.this.mFilterContext.getGLManager().quit();
                YMFLog.info(this, "[Procedur]", "VideoLiveSession stopAndRelease quit");
            }
        });
        stopRvSensor();
        this.mRotationVectorSensor = null;
        YMFLog.info(this, "[Procedur]", "VideoLiveSession stopAndRelease done");
        VideoDataStatUtil.clearPtsTimes(1001L);
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void startEncoder() {
        YMFLog.info(this, "[Encoder ]", "VideoLiveSession startEncoder ");
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.3
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSession.this.mFilterContext.getUserLiveConfig();
                if (!VideoLiveSession.this.isHardwareEncoderAvailable()) {
                    VideoLiveSession.this.mFilterContext.mVideoEncoderConfig.mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
                }
                if (VideoLiveSession.this.mEncoderGroupFilter.isEnable()) {
                    YMFLog.info(this, "[Encoder ]", "encoder is started already!!");
                    return;
                }
                try {
                    if (VideoLiveSession.this.mEncoderGroupFilter.startEncode(VideoLiveSession.this.mFilterContext.getVideoEncoderConfig())) {
                        UploadStatManager.getInstance().startStat();
                    }
                } catch (Exception e) {
                    YMFLog.error(this, "[Encoder ]", "VideoLiveSession startEncode exception:" + e);
                }
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void stopEncoder() {
        YMFLog.info(this, "[Encoder ]", "VideoLiveSession stopEncoder");
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.4
            @Override // java.lang.Runnable
            public void run() {
                UploadStatManager.getInstance().stopStat();
                if (VideoLiveSession.this.mEncoderGroupFilter.isEnable()) {
                    VideoLiveSession.this.mEncoderGroupFilter.stopEncode();
                }
            }
        });
    }

    @Override // com.yy.mediaframework.IYYVideoSurfaceInfoListener
    public void onSurfaceInfoEvent(int i, final AbstractSurfaceInfo abstractSurfaceInfo) {
        if (abstractSurfaceInfo != null) {
            YMFLog.info(this, "[Preview ]", "onSurfaceInfoEvent evtType:" + i + "width:" + abstractSurfaceInfo.mWidth + " height:" + abstractSurfaceInfo.mHeight);
        } else {
            YMFLog.info(this, "[Preview ]", "onSurfaceInfoEvent evtType:" + i);
        }
        switch (i) {
            case 1:
            case 2:
                this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoLiveSession.this.mPreviewFilter != null) {
                            VideoLiveSession.this.mPreviewFilter.onSurfaceChanged(abstractSurfaceInfo);
                        }
                    }
                });
                return;
            case 3:
                this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoLiveSession.this.mPreviewFilter != null) {
                            VideoLiveSession.this.mPreviewFilter.onSurfaceDestroy();
                        }
                    }
                });
                return;
            default:
                return;
        }
    }

    public void setScreenShot(ScreenShot screenShot) {
        this.mFilterContext.setScreenShot(screenShot);
    }

    public void setFilterInfo(final FilterType filterType, final Map<String, String> map) {
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.7
            @Override // java.lang.Runnable
            public void run() {
                if (VideoLiveSession.this.mPreprocessFilter != null) {
                    VideoLiveSession.this.mPreprocessFilter.setFilterInfo(filterType, map);
                }
            }
        });
    }

    public void setFilterType(final FilterType filterType) {
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.8
            @Override // java.lang.Runnable
            public void run() {
                if (VideoLiveSession.this.mPreprocessFilter != null) {
                    VideoLiveSession.this.mPreprocessFilter.setFilterType(filterType);
                }
            }
        });
    }

    public void setWaterMark(final WaterMark waterMark) {
        YMFLog.info(this, "[Beauty  ]", "setWaterMark, waterMark==null? " + (waterMark == null ? "y" : "n"));
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.9
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSession.this.mFilterContext.setWaterMarkTexture(waterMark);
            }
        });
    }

    public void setBackground(final Background background) {
        YMFLog.info(this, "[Beauty  ]", "setBackground, background ==null? " + (background == null ? "y" : "n"));
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.10
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSession.this.mFilterContext.setBackgroundTexture(background);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setDynamicTexture(final IDynamicTexture iDynamicTexture) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.11
            @Override // java.lang.Runnable
            public void run() {
                YMFLog.info(this, "[Beauty  ]", "setDynamicTexture:");
                VideoLiveSession.this.mFilterContext.setDynamicTexture(iDynamicTexture);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void takeScreenShot(ScreenShotCallback screenShotCallback) {
        if (this.mScreenShot != null) {
            this.mScreenShot.setCallback(screenShotCallback);
        }
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setNetworkBitrateSuggest(final int i) {
        YMFLog.info(this, "[Encoder ]", "setNetworkBitrateSuggest:" + i);
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.12
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSession.this.mEncoderGroupFilter.setNetworkBitrateSuggest(i);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setResolutionModifyConfigs(final List<ResolutionModifyConfig> list, final int i) {
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.13
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSession.this.mEncoderGroupFilter.setResolutionModifyConfigs(list, i);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setEncoderListener(IEncoderListener iEncoderListener) {
        this.mEncoderListener = new WeakReference<>(iEncoderListener);
        if (iEncoderListener != null) {
            iEncoderListener.onEncodeEncParam(this.mFilterContext.getEncodeParamTipsMgr().getParam());
        }
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setEncoderConfig(final VideoEncoderConfig videoEncoderConfig) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.14
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSession.this.mFilterContext.getVideoEncoderConfig().assign(videoEncoderConfig);
                YMFLog.info(this, "[Encoder ]", "setEncoderConfig:" + VideoLiveSession.this.mFilterContext.getVideoEncoderConfig().toString());
                VideoLiveSession.this.mFilterContext.getDefaultVideoEncoderConfig().assign(videoEncoderConfig);
                VideoLiveSession.this.mPreprocessFilter.init(videoEncoderConfig.getEncodeWidth(), videoEncoderConfig.getEncodeHeight());
                VideoLiveSession.this.mEncoderGroupFilter.init();
                VideoLiveSession.this.mPreviewFilter.init(videoEncoderConfig.getEncodeWidth(), videoEncoderConfig.getEncodeHeight());
                UploadStatManager.getInstance().putSettingBitRate(videoEncoderConfig.getBitRate());
                UploadStatManager.getInstance().putSettingDPI(videoEncoderConfig.getRealDPI());
                UploadStatManager.getInstance().putSettingFrameRate(videoEncoderConfig.getFrameRate());
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setLowStreamEncoderConfigs(final List<YMFLowStreamEncoderConfig> list, final boolean z) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.15
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSession.this.mFilterContext.setLowStreamEncoderConfigs(list);
                VideoLiveSession.this.mFilterContext.enableLowStreamEncoder(z);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setLowDelayMode(final boolean z) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.16
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSession.this.mFilterContext.getVideoEncoderConfig().mLowDelay = z;
                YMFLog.info(this, "[Encoder ]", "setLowDelayMode:" + z + " config:" + VideoLiveSession.this.mFilterContext.getVideoEncoderConfig().toString());
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void adjustEncoderBitrate(int i) {
        if (this.mEncoderGroupFilter != null) {
            YMFLog.info(this, "[Encoder ]", "adjustEncoderBitrate:" + i);
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
    public void onHardEncoderError() {
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeFrameData(YMFVideoEncodeFrame yMFVideoEncodeFrame) {
        IEncoderListener iEncoderListener = this.mEncoderListener.get();
        if (System.currentTimeMillis() - this.mLastCountTime >= 6000) {
            this.mLastCountTime = System.currentTimeMillis();
            YMFLog.info(this, "[Encoder ]", "onEncodeFrameData, listener:" + iEncoderListener);
        }
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
    public void onEncoderSwitch() {
        YMFLog.info(this, "[Encoder ]", "encoder switch in VideoLiveSession");
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.17
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSession.this.stopEncoder();
                VideoLiveSession.this.startEncoder();
            }
        });
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onWaterMarkSizeChange(int i, int i2) {
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void requestIFrame() {
        YMFLog.info(this, "[Encoder ]", "requestIFrame");
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.18
            @Override // java.lang.Runnable
            public void run() {
                if (VideoLiveSession.this.mEncoderGroupFilter != null) {
                    VideoLiveSession.this.mEncoderGroupFilter.requestSyncFrame();
                }
            }
        });
    }

    public void setUserLiveConfig(final YYUserLiveConfig yYUserLiveConfig) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.19
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSession.this.mFilterContext.setUserLiveConfig(yYUserLiveConfig);
            }
        });
    }

    public void enableColorChartLive(final boolean z) {
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.20
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSession.this.mFilterContext.setColorChartLiveEnable(z);
            }
        });
    }

    public void onDualPictureSwitch() {
        this.mFilterContext.setSwitchPicture();
    }

    public void onDualOpen(boolean z) {
        this.mFilterContext.setPictureInPictureFlag(z);
    }

    public void onCameraFocusAreaChanged(Rect rect) {
    }

    public void onCameraExposureAreaChanged(Rect rect) {
    }

    public void enableMirror(final boolean z) {
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.21
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSession.this.mFilterContext.setMirrorFlag(z);
            }
        });
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

    public void setSurfaceChanged(final int i, final int i2) {
        if (this.mPreviewFilter != null) {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.22
                @Override // java.lang.Runnable
                public void run() {
                    VideoLiveSession.this.mPreviewFilter.setSurfaceChanged(i, i2);
                }
            });
        }
    }

    public void onPeripheralsVideoDataReceived(DecodeVideoSample decodeVideoSample) {
        this.mPeripheralsDecoderFilter.handlePeripheralsVideoData(decodeVideoSample);
    }

    public void onPeripheralsVideoConfigReceived(DecodeVideoConfig decodeVideoConfig) {
        this.mPeripheralsDecoderFilter.handlePeripheralsVideoConfig(decodeVideoConfig, this.mPeripheralsDecoderFilter);
    }

    public void onOutdoorVideoDataReceived(DecodeVideoSample decodeVideoSample) {
        this.mExternalDecoderFilter.handleOutdoorVideoData(decodeVideoSample);
    }

    public void onOutdoorVideoConfigReceived(DecodeVideoConfig decodeVideoConfig) {
        this.mExternalDecoderFilter.handleOutdoorVideoConfig(decodeVideoConfig, this.mExternalDecoderFilter);
    }

    public void onPeripheralsVideoEnd() {
        YMFLog.info(this, "[Decoder ]", "onPeripheralsVideoEnd");
        this.mPeripheralsDecoderFilter.handlePerpheralsVideoEnd();
        this.mPeripheralsDecoderFilter.deInit();
        this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_NORMAL);
        this.mPreprocessFilter.onPeripheralsVideoEnd();
    }

    public void onExternalVideoEnd() {
        YMFLog.info(this, "[Decoder ]", "onPeripheralsVideoEnd");
        this.mExternalDecoderFilter.handleExternalVideoEnd();
        this.mExternalDecoderFilter.deInit();
        this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_NORMAL);
        this.mEncoderGroupFilter.onExternalVideoEnd();
    }

    public void setSessionLiveMode(LiveSessionType liveSessionType) {
        this.mFilterContext.setLiveMode(liveSessionType);
    }

    public void setVideoRenderPostion(final VideoRenderPosition videoRenderPosition) {
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.23
            @Override // java.lang.Runnable
            public void run() {
                VideoLiveSession.this.mFilterContext.setVideoRenderPostion(videoRenderPosition);
            }
        });
    }

    public void startRvSensor() {
        YMFLog.info(this, "[Preview ]", "startRvSensor");
        if (this.mRotationVectorSensor != null) {
            this.mRotationVectorSensor.registerSensor();
        }
    }

    public void stopRvSensor() {
        YMFLog.info(this, "[Preview ]", "stopRvSensor");
        if (this.mRotationVectorSensor != null) {
            this.mRotationVectorSensor.unregisterSensor();
        }
    }

    public void setDeltaYYPtsMillions(final long j) {
        YMFLog.info(this, "[Encoder ]", "setDeltaYYPtsMillions:" + j);
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.VideoLiveSession.24
            @Override // java.lang.Runnable
            public void run() {
                YYVideoSDK.getInstance().setDeltaYYPtsMillions(j);
            }
        });
    }

    public void registerPreviewCallback(PreviewFrameCallback previewFrameCallback) {
        if (this.mPreviewCallbackHost != null) {
            this.mPreviewCallbackHost.registerCallback(previewFrameCallback);
        }
    }

    public void unregisterPreviewCallback(PreviewFrameCallback previewFrameCallback) {
        if (this.mPreviewCallbackHost != null) {
            this.mPreviewCallbackHost.unregisterCallback(previewFrameCallback);
        }
    }

    public void setExternalCameraDataCallback(ExternalInterface.IExternalCameraData iExternalCameraData) {
        if (this.mFilterContext != null && iExternalCameraData != null) {
            this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_EXTERNAL);
        }
        if (this.mEncoderGroupFilter != null) {
            this.mEncoderGroupFilter.setExternalCameraDataCallback(iExternalCameraData);
        }
    }

    public void setExternalDecodeInterface(ExternalInterface.IExternalDecode iExternalDecode) {
        if (this.mFilterContext != null && iExternalDecode != null) {
            this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_EXTERNAL);
        }
        if (this.mEncoderGroupFilter != null) {
            this.mEncoderGroupFilter.setExternalDecodeCallback(iExternalDecode);
        }
    }

    public void startEncodeExternalData(YYMediaSample yYMediaSample) {
        if (this.mEncoderGroupFilter != null) {
            this.mEncoderGroupFilter.setIsExternalEncode(true);
            this.mEncoderGroupFilter.processMediaSample(yYMediaSample, null);
        }
    }

    public void setGLManagerRunnable(Runnable runnable) {
        if (this.mFilterContext != null) {
            this.mFilterContext.getGLManager().post(runnable);
        }
    }

    public void setGPUImageBeautyFilter(IGPUProcess iGPUProcess) {
        if (this.mPreprocessFilter != null) {
            this.mPreprocessFilter.setGPUImageBeautyFilter(iGPUProcess);
        } else {
            YMFLog.error(this, "[Beauty  ]", "setGPUImageBeautyFilter null");
        }
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setWaterMark(Bitmap bitmap, int i, int i2) {
    }
}
