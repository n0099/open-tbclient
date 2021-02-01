package com.yy.mediaframework;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.yy.mediaframework.CameraInterface;
import com.yy.mediaframework.ExternalInterface;
import com.yy.mediaframework.GetAnchorStatInfoInterface;
import com.yy.mediaframework.background.Background;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.YYUserLiveConfig;
import com.yy.mediaframework.facedetection.PreviewFrameCallback;
import com.yy.mediaframework.gles.EglFactory;
import com.yy.mediaframework.gpuimage.FilterType;
import com.yy.mediaframework.gpuimage.custom.IGPUProcess;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import com.yy.mediaframework.inteligence.dynamictexture.IDynamicTexture;
import com.yy.mediaframework.model.DecodeVideoConfig;
import com.yy.mediaframework.model.DecodeVideoSample;
import com.yy.mediaframework.model.ExternalDecodeInfo;
import com.yy.mediaframework.model.ExternalYYMediaSample;
import com.yy.mediaframework.model.Rect;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.screenshot.ScreenShotCallback;
import com.yy.mediaframework.stat.UploadStatManager;
import com.yy.mediaframework.utils.YMFLog;
import com.yy.mediaframework.watermark.WaterMark;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes4.dex */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback, CameraListener, GetAnchorStatInfoInterface.IGetCurrentCameraEncodeStatInfo, GetAnchorStatInfoInterface.IGetImageFilterInfo, IMediaCodecUpload {
    private static final String TAG = "CameraSurfaceView";
    private boolean bEnableFaceDetected;
    private String m3dArEffectPath;
    private String mArJoyPKEffect;
    private int mArJoyPKIndex;
    private String mArJoyPKTag;
    private Background mBackground;
    private String mBeauty5EffectPath;
    private float mBeautyIntensity;
    VideoRenderPosition mCameraPostion;
    public Context mContext;
    private long mDeltaPts;
    private IDynamicTexture mDynamicTexture;
    private boolean mEnableColorChartLive;
    private boolean mEnableMirror;
    private VideoEncoderConfig mEncoderConfig;
    private boolean mEncoderEnabled;
    private IEncoderListener mEncoderListener;
    private Map<Integer, Float> mFaceLiftValue;
    private float mFaceLigtVal;
    private String mFilterEffectPath;
    private Map<String, String> mFilterParams;
    private FilterType mFilterType;
    private IGPUProcess mGPUImageProcess;
    private String mGiftEffectPath;
    private boolean mHardwareEncoderAvailable;
    ExternalInterface.IExternalCameraData mIExternalCameraData;
    ExternalInterface.IExternalDecode mIExternalDecode;
    private boolean mIsFadeOutEffect;
    private boolean mIsGifFadeOutEffect;
    private boolean mIsNeedLimitFaceNum;
    private VideoLiveSession mLiveSession;
    private boolean mLiveSessionAutoMode;
    private String mLockedLandScapeEffectPath;
    private String mLockedPortraitEffectPath;
    private String mLockingLandScapeEffectPath;
    private String mLockingPortraitEffectPath;
    DecodeVideoConfig mOutdoorVideoConfig;
    VideoRenderPosition mPeripheralsPosition;
    DecodeVideoConfig mPeripheralsVideoConfig;
    private PreviewFrameCallback mPreviewCallback;
    public CameraInterface.CameraResolutionMode mResMode;
    private List<ResolutionModifyConfig> mResolutionModifyConfigs;
    private int mResolutionModifyInterval;
    private String mSearchingLandScapeEffectPath;
    private String mSearchingPortraitEffectPath;
    private String mStickerEffect;
    private float mStickerEffectParam;
    private String mStickerEffectPath;
    private String mStickerLutEffect;
    private float mThinFaceParam;
    public YYUserLiveConfig mUserLiveConfig;
    private String[] mVenusModelPath;
    private WaterMark mWaterMark;
    private String mWitnessFilterPath;
    private boolean onDualCameraOpened;

    public CameraSurfaceView(Context context) {
        this(context, null);
    }

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFilterType = FilterType.Normal;
        this.mFilterParams = null;
        this.mEncoderEnabled = false;
        this.mEncoderConfig = null;
        this.mUserLiveConfig = new YYUserLiveConfig();
        this.mStickerEffectPath = null;
        this.mStickerLutEffect = null;
        this.mStickerEffect = null;
        this.mGiftEffectPath = null;
        this.mFilterEffectPath = null;
        this.mWitnessFilterPath = null;
        this.mBeauty5EffectPath = null;
        this.mSearchingPortraitEffectPath = null;
        this.mLockingPortraitEffectPath = null;
        this.mLockedPortraitEffectPath = null;
        this.mSearchingLandScapeEffectPath = null;
        this.mLockingLandScapeEffectPath = null;
        this.mLockedLandScapeEffectPath = null;
        this.m3dArEffectPath = null;
        this.mArJoyPKEffect = null;
        this.mArJoyPKTag = null;
        this.mDeltaPts = 0L;
        this.mIsFadeOutEffect = false;
        this.mLiveSessionAutoMode = true;
        this.onDualCameraOpened = false;
        this.mHardwareEncoderAvailable = false;
        this.mEnableColorChartLive = false;
        this.mEnableMirror = false;
        this.mIsNeedLimitFaceNum = false;
        this.mIsGifFadeOutEffect = false;
        this.mFaceLiftValue = new HashMap();
        this.mVenusModelPath = null;
        this.bEnableFaceDetected = false;
        this.mContext = context.getApplicationContext();
        init();
    }

    private void init() {
        getHolder().addCallback(this);
        CameraInterface.getInstance().setCameraListener(this);
    }

    public void onResume() {
        setKeepScreenOn(true);
    }

    public void onPause() {
        setKeepScreenOn(false);
    }

    public void setSurfaceSizeChange(int i, int i2) {
        YMFLog.info(this, "[Preview ]", "setSurfaceSizeChange:" + i + "*" + i2);
        if (this.mLiveSession != null) {
            this.mLiveSession.setSurfaceChanged(i, i2);
        }
    }

    public void setLiveSessionAutoMode(boolean z) {
        this.mLiveSessionAutoMode = z;
    }

    public void destroyLiveSession() {
        UploadStatManager.getInstance().setIGetCurrentCameraStatInfo(null);
        UploadStatManager.getInstance().setIGetImageFilterInfo(null);
        YMFLog.info(this, "[Preview ]", "stopLiveSession");
        if (this.mLiveSession != null) {
            if (getHolder() != null) {
                notifySurfaceDestroyed(getHolder());
            }
            this.mLiveSession.stopAndRelease();
            this.mLiveSession = null;
        }
    }

    public void setupLiveSession() {
        UploadStatManager.getInstance().setIGetCurrentCameraStatInfo(this);
        UploadStatManager.getInstance().setIGetImageFilterInfo(this);
        YMFLog.info(this, "[Preview ]", "setupLiveSession");
        if (this.mLiveSession != null) {
            destroyLiveSession();
        }
        this.mLiveSession = new VideoLiveSession(this.mContext);
        if (CameraInterface.getInstance().isCameraOpened() && CameraInterface.getInstance().getPreviewSize() != null) {
            this.mResMode = CameraInterface.getInstance().getResolutionMode();
            this.mLiveSession.startPreview(CameraInterface.getInstance().getPreviewSize().width, CameraInterface.getInstance().getPreviewSize().height, CameraInterface.getInstance().getAndroidCameraFacing(), this.mResMode);
        }
        if (getHolder() != null) {
            notifySurfaceCreate(getHolder());
        }
        this.mLiveSession.setFilterInfo(this.mFilterType, this.mFilterParams);
        this.mLiveSession.setEncoderListener(this.mEncoderListener);
        this.mLiveSession.setWaterMark(this.mWaterMark);
        this.mLiveSession.setBackground(this.mBackground);
        this.mLiveSession.setDynamicTexture(this.mDynamicTexture);
        this.mLiveSession.setResolutionModifyConfigs(this.mResolutionModifyConfigs, this.mResolutionModifyInterval);
        this.mLiveSession.setDeltaYYPtsMillions(this.mDeltaPts);
        this.mLiveSession.setExternalDecodeInterface(this.mIExternalDecode);
        this.mLiveSession.setExternalCameraDataCallback(this.mIExternalCameraData);
        if (this.mGPUImageProcess != null) {
            this.mLiveSession.setGPUImageBeautyFilter(this.mGPUImageProcess);
        }
        if (this.m3dArEffectPath != null) {
            this.mLiveSession.startRvSensor();
        }
        if (this.mEncoderConfig != null) {
            this.mLiveSession.setEncoderConfig(this.mEncoderConfig);
            this.mLiveSession.setLowDelayMode(this.mEncoderConfig.mLowDelay);
        }
        if (this.mUserLiveConfig != null) {
            this.mLiveSession.setUserLiveConfig(this.mUserLiveConfig);
        }
        if (this.mEncoderEnabled) {
            this.mLiveSession.startEncoder();
        }
        this.mLiveSession.onDualOpen(this.onDualCameraOpened);
        this.mLiveSession.setHardwareEncoderAvailable(this.mHardwareEncoderAvailable);
        this.mLiveSession.enableColorChartLive(this.mEnableColorChartLive);
        this.mLiveSession.enableMirror(this.mEnableMirror);
        if (this.mPeripheralsVideoConfig != null) {
            this.mLiveSession.onPeripheralsVideoConfigReceived(this.mPeripheralsVideoConfig);
        }
        if (this.mOutdoorVideoConfig != null) {
            this.mLiveSession.onOutdoorVideoConfigReceived(this.mOutdoorVideoConfig);
        }
        if (this.mCameraPostion != null) {
            this.mLiveSession.setVideoRenderPostion(this.mCameraPostion);
        }
        if (this.mPeripheralsPosition != null) {
            this.mLiveSession.setVideoRenderPostion(this.mPeripheralsPosition);
        }
    }

    private void fakeBackground() {
        if (this.mBackground == null) {
            this.mBackground = new Background(null, 960, VideoEncoderConfig.DEFAULT_ENCODE_HIGH_WIDTH, 0, 0, Background.Align.FullScreen);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        YMFLog.info(this, "[Preview ]", "surfaceCreated");
        if (this.mLiveSessionAutoMode) {
            setupLiveSession();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        YMFLog.info(this, "[Preview ]", "surfaceChanged format:" + i + ", width:" + i2 + ", height:" + i3);
        notifySurfaceChanged(surfaceHolder, i, i2, i3);
        CameraInterface.getInstance().setSurfaceViewSize(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.mLiveSession != null && this.mLiveSession.mFilterContext != null) {
            this.mLiveSession.mFilterContext.mSurfaceDestoryStateLock.lock();
            this.mLiveSession.mFilterContext.mSurfaceDestoryState.set(true);
            this.mLiveSession.mFilterContext.mSurfaceDestoryStateLock.unlock();
        }
        YMFLog.info(this, "[Preview ]", "surfaceDestroyed");
        destroyLiveSession();
    }

    public void onTouch(MotionEvent motionEvent) {
        YYCamera.getInstance().handleFocusMetering(motionEvent);
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void startEncoder() {
        this.mEncoderEnabled = true;
        if (this.mLiveSession != null) {
            this.mLiveSession.startEncoder();
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void stopEncoder() {
        this.mEncoderEnabled = false;
        if (this.mLiveSession != null) {
            this.mLiveSession.stopEncoder();
        }
    }

    public void setUserLiveConfig(YYUserLiveConfig yYUserLiveConfig) {
        this.mUserLiveConfig.assign(yYUserLiveConfig);
        if (this.mLiveSession != null) {
            this.mLiveSession.setUserLiveConfig(this.mUserLiveConfig);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setEncoderConfig(VideoEncoderConfig videoEncoderConfig) {
        YMFLog.info(this, "[Encoder ]", "setEncoderConfig:" + videoEncoderConfig);
        this.mEncoderConfig = videoEncoderConfig;
        if (this.mLiveSession != null) {
            this.mLiveSession.setEncoderConfig(videoEncoderConfig);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setEncoderListener(IEncoderListener iEncoderListener) {
        YMFLog.info(this, "[Encoder ]", "setEncoderListener:" + iEncoderListener);
        this.mEncoderListener = iEncoderListener;
        if (this.mLiveSession != null) {
            this.mLiveSession.setEncoderListener(this.mEncoderListener);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setBackground(Background background) {
        this.mBackground = background;
        if (this.mLiveSession != null) {
            this.mLiveSession.setBackground(background);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void onPeripheralsVideoDataReceived(DecodeVideoSample decodeVideoSample) {
        if (this.mLiveSession == null) {
            YMFLog.error(this, "[Decoder ]", "onPeripheralsVideoDataReceived:invalid VideoLiveSession");
        } else {
            this.mLiveSession.onPeripheralsVideoDataReceived(decodeVideoSample);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void onPeripheralsVideoConfigReceived(DecodeVideoConfig decodeVideoConfig) {
        this.mPeripheralsVideoConfig = decodeVideoConfig;
        if (this.mLiveSession == null) {
            YMFLog.error(this, "[Decoder ]", "onPeripheralsVideoConfigReceived:invalid VideoLiveSession");
        } else {
            this.mLiveSession.onPeripheralsVideoConfigReceived(decodeVideoConfig);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setVideoRenderPosition(VideoRenderPosition videoRenderPosition) {
        if (videoRenderPosition == null) {
            YMFLog.error(this, "[Decoder ]", "invalid VideoRenderPositon, return");
            return;
        }
        if (videoRenderPosition.channalId < 1000) {
            this.mCameraPostion = videoRenderPosition;
        } else if (videoRenderPosition.channalId > 1000) {
            this.mPeripheralsPosition = videoRenderPosition;
        }
        if (this.mLiveSession == null) {
            YMFLog.error(this, "[Decoder ]", "onPeripheralsVideoConfigReceived:invalid VideoLiveSession");
        } else {
            this.mLiveSession.setVideoRenderPostion(videoRenderPosition);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void onPeripheralsVideoEnd() {
        if (this.mLiveSession == null) {
            YMFLog.error(this, "[Decoder ]", "onPeripheralsVideoConfigReceived:invalid VideoLiveSession");
        } else {
            this.mLiveSession.onPeripheralsVideoEnd();
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setWaterMark(WaterMark waterMark) {
        this.mWaterMark = waterMark;
        if (this.mLiveSession != null) {
            this.mLiveSession.setWaterMark(this.mWaterMark);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setDynamicTexture(IDynamicTexture iDynamicTexture) {
        this.mDynamicTexture = iDynamicTexture;
        if (this.mLiveSession != null) {
            this.mLiveSession.setDynamicTexture(this.mDynamicTexture);
        }
    }

    public IDynamicTexture getDynamicTexture() {
        return this.mDynamicTexture;
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void takeScreenShot(ScreenShotCallback screenShotCallback) {
        if (this.mLiveSession != null) {
            this.mLiveSession.takeScreenShot(screenShotCallback);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setNetworkBitrateSuggest(int i) {
        if (this.mLiveSession != null) {
            YMFLog.info(this, "[Encoder ]", "setNetworkBitrateSuggest outside:" + i);
            this.mLiveSession.setNetworkBitrateSuggest(i);
        }
    }

    public void setLowDelayMode(boolean z) {
        this.mEncoderConfig.mLowDelay = z;
        if (this.mLiveSession != null) {
            this.mLiveSession.setLowDelayMode(z);
        }
    }

    @Override // com.yy.mediaframework.CameraListener
    public void notifyCameraPreviewParameter(int i, int i2, int i3, CameraInterface.CameraResolutionMode cameraResolutionMode) {
        YMFLog.info(this, "[Preview ]", "notifyCameraPreviewParameter, width:" + i + " height:" + i2 + " facing:" + i3);
        if (this.mLiveSession != null) {
            this.mLiveSession.startPreview(i, i2, i3, cameraResolutionMode);
        }
    }

    @Override // com.yy.mediaframework.CameraListener
    public void notifyCameraOpenSuccess() {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void notifyCameraOpenFail(String str) {
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onDualOpen(boolean z) {
        this.onDualCameraOpened = z;
        if (this.mLiveSession != null) {
            this.mLiveSession.onDualOpen(z);
        }
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onDualPictureSwitch() {
        if (this.mLiveSession != null) {
            this.mLiveSession.onDualPictureSwitch();
        }
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onCameraFocusAreaChanged(Rect rect) {
        if (this.mLiveSession != null) {
            this.mLiveSession.onCameraFocusAreaChanged(rect);
        }
    }

    @Override // com.yy.mediaframework.CameraListener
    public void onCameraExposureAreaChanged(Rect rect) {
        if (this.mLiveSession != null) {
            this.mLiveSession.onCameraExposureAreaChanged(rect);
        }
    }

    public void setFilterInfo(FilterType filterType, Map<String, String> map) {
        this.mFilterType = filterType;
        this.mFilterParams = map;
        if (this.mLiveSession != null) {
            this.mLiveSession.setFilterInfo(filterType, this.mFilterParams);
        }
    }

    public void setFilterType(FilterType filterType) {
        this.mFilterType = filterType;
        if (this.mLiveSession != null) {
            this.mLiveSession.setFilterType(this.mFilterType);
        }
    }

    public FilterType getFilterType() {
        return this.mFilterType;
    }

    public void setResolutionModifyConfigs(List<ResolutionModifyConfig> list, int i) {
        this.mResolutionModifyConfigs = list;
        this.mResolutionModifyInterval = i;
        if (this.mLiveSession != null) {
            this.mLiveSession.setResolutionModifyConfigs(this.mResolutionModifyConfigs, this.mResolutionModifyInterval);
        }
    }

    public void requestEncodeIFrame() {
        if (this.mLiveSession != null) {
            this.mLiveSession.requestIFrame();
        }
    }

    private void notifySurfaceCreate(SurfaceHolder surfaceHolder) {
        if (this.mLiveSession != null) {
            this.mLiveSession.onSurfaceInfoEvent(1, EglFactory.newSurfaceInfo(surfaceHolder, 0, 0));
        }
    }

    private void notifySurfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.mLiveSession != null) {
            YMFLog.info(this, "[Preview ]", String.format(Locale.getDefault() + "notifySurfaceChanged width:%d, height:%d", Integer.valueOf(i2), Integer.valueOf(i3)));
            this.mLiveSession.onSurfaceInfoEvent(2, EglFactory.newSurfaceInfo(surfaceHolder, i2, i3));
        }
    }

    private void notifySurfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.mLiveSession != null) {
            this.mLiveSession.onSurfaceInfoEvent(3, null);
        }
    }

    public void setHardwareEncoderAvailable(boolean z) {
        if (this.mLiveSession != null) {
            this.mLiveSession.setHardwareEncoderAvailable(z);
        }
        this.mHardwareEncoderAvailable = z;
        YMFLog.info(this, "[Encoder ]", "setHardwareEncoderAvailable:" + this.mHardwareEncoderAvailable);
    }

    public void enableColorChartLive(boolean z) {
        YMFLog.info(this, "[Encoder ]", "enableColorChartLive:" + z);
        if (this.mLiveSession != null) {
            this.mLiveSession.enableColorChartLive(z);
        }
        this.mEnableColorChartLive = z;
    }

    public void enableMirror(boolean z) {
        YMFLog.info(this, "[Encoder ]", "enableEncodeMirror:" + z);
        if (this.mLiveSession != null) {
            this.mLiveSession.enableMirror(z);
        }
        this.mEnableMirror = z;
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetCurrentCameraEncodeStatInfo
    public int onGetAnchorCurrentBitRate() {
        if (this.mEncoderConfig == null) {
            return 0;
        }
        return this.mEncoderConfig.getBitRate();
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetCurrentCameraEncodeStatInfo
    public int onGetAnchorCurrentFrameRate() {
        if (this.mEncoderConfig == null) {
            return 0;
        }
        return this.mEncoderConfig.getFrameRate();
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetCurrentCameraEncodeStatInfo
    public String onGetAnchorCurrentDIPRate() {
        if (this.mEncoderConfig == null) {
            return "";
        }
        return this.mEncoderConfig.getRealDPI();
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetImageFilterInfo
    public boolean onGetHasBeauty() {
        return isUse(this.mBeautyIntensity);
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetImageFilterInfo
    public boolean onGetHasFaceLift() {
        return isUse(this.mThinFaceParam);
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetImageFilterInfo
    public float onGetBeautyLevel() {
        return this.mBeautyIntensity;
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetImageFilterInfo
    public float onGetFaceLiftLevel() {
        return this.mThinFaceParam;
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetImageFilterInfo
    public boolean onGetHasSticker() {
        if (this.mStickerEffectPath == null || this.mStickerEffectPath.equals("")) {
            return false;
        }
        return true;
    }

    @Override // com.yy.mediaframework.GetAnchorStatInfoInterface.IGetImageFilterInfo
    public boolean onGetHasDynamicSticker() {
        if (this.mDynamicTexture == null) {
            return false;
        }
        return true;
    }

    private boolean isUse(float f) {
        if (f <= 1.0E-5f) {
            return false;
        }
        return true;
    }

    public void setDeltaYYPtsMillions(long j) {
        YMFLog.info(this, "[Encoder ]", "setDeltaYYPtsMillions:" + j);
        this.mDeltaPts = j;
        if (this.mLiveSession != null) {
            this.mLiveSession.setDeltaYYPtsMillions(j);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setExternalVideoInterface(ExternalInterface.IExternalCameraData iExternalCameraData) {
        this.mIExternalCameraData = iExternalCameraData;
        if (this.mLiveSession != null) {
            this.mLiveSession.setExternalCameraDataCallback(this.mIExternalCameraData);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void pushEncodeExternalData(ExternalYYMediaSample externalYYMediaSample) {
        YYMediaSample yYMediaSample;
        if (this.mLiveSession != null) {
            Object obj = externalYYMediaSample.mSample;
            if (!(obj instanceof YYMediaSample)) {
                yYMediaSample = null;
            } else {
                yYMediaSample = (YYMediaSample) obj;
                yYMediaSample.mMasterTextureId = externalYYMediaSample.mMasterTextureId;
                yYMediaSample.mYYPtsMillions = externalYYMediaSample.mPts;
            }
            this.mLiveSession.startEncodeExternalData(yYMediaSample);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setExternalDecodeInterface(ExternalInterface.IExternalDecode iExternalDecode) {
        this.mIExternalDecode = iExternalDecode;
        if (this.mLiveSession != null) {
            this.mLiveSession.setExternalDecodeInterface(this.mIExternalDecode);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void pushExternalVideoDecodeInfo(ExternalDecodeInfo externalDecodeInfo) {
        if (this.mLiveSession == null || externalDecodeInfo == null) {
            YMFLog.error(this, "[Decoder ]", "invalid VideoLiveSession or sample is null");
            return;
        }
        this.mLiveSession.onOutdoorVideoConfigReceived(externalDecodeInfo.convertToConfig());
        this.mLiveSession.onOutdoorVideoDataReceived(externalDecodeInfo.convertToStreamInfo());
    }

    @Override // com.yy.mediaframework.CameraListener
    public void reSetEncodingState() {
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void onExternalVideoEnd() {
        if (this.mLiveSession == null) {
            YMFLog.error(this, "[Decoder ]", "invalid VideoLiveSession");
        } else {
            this.mLiveSession.onExternalVideoEnd();
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setGLManagerRunnable(Runnable runnable) {
        if (this.mLiveSession != null) {
            this.mLiveSession.setGLManagerRunnable(runnable);
        }
    }

    public void setGPUImageBeautyFilter(IGPUProcess iGPUProcess) {
        this.mGPUImageProcess = iGPUProcess;
        if (this.mLiveSession != null) {
            this.mLiveSession.setGPUImageBeautyFilter(iGPUProcess);
        } else {
            YMFLog.error(this, "[Beauty  ]", "setGPUImageBeautyFilter failed");
        }
    }

    public void addPreviewFrameCallback(PreviewFrameCallback previewFrameCallback) {
        if (this.mLiveSession != null) {
            this.mLiveSession.registerPreviewCallback(previewFrameCallback);
        }
    }

    public void removePreviewFrameCallback(PreviewFrameCallback previewFrameCallback) {
        if (this.mLiveSession != null) {
            this.mLiveSession.unregisterPreviewCallback(previewFrameCallback);
        }
    }
}
