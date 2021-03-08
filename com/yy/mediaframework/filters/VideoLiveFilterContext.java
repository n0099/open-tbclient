package com.yy.mediaframework.filters;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.baidu.fsg.base.statistics.h;
import com.yy.mediaframework.CameraInterface;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.GlManager;
import com.yy.mediaframework.IYMFDeliverCallback;
import com.yy.mediaframework.UploadStreamStateParams;
import com.yy.mediaframework.VideoRenderPosition;
import com.yy.mediaframework.background.Background;
import com.yy.mediaframework.background.BackgroundTexture;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.YMFLowStreamEncoderConfig;
import com.yy.mediaframework.base.YYUserLiveConfig;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.inteligence.dynamictexture.IDynamicTexture;
import com.yy.mediaframework.model.Rect;
import com.yy.mediaframework.screenshot.ScreenShot;
import com.yy.mediaframework.sensor.RotationVectorSensor;
import com.yy.mediaframework.stat.LocalEncodeParamTipsMgr;
import com.yy.mediaframework.utils.VideoEntities;
import com.yy.mediaframework.utils.YMFLog;
import com.yy.mediaframework.watermark.WaterMark;
import com.yy.mediaframework.watermark.WaterMarkTexture;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class VideoLiveFilterContext {
    private static final String TAG = "VideoLiveFilterContext";
    public Context mAndroidContext;
    public VideoRenderPosition mCameraPostion;
    public IYMFDeliverCallback mDeliverCallback;
    private LocalEncodeParamTipsMgr mEncodeParamTipsMgr;
    public GlManager mGlManager;
    public VideoRenderPosition mPeripheralsPosition;
    private RotationVectorSensor mRotationVectorSensor;
    public int mScreenDensityDpi;
    public int mScreenHeight;
    public int mScreenWidth;
    private LiveSessionType mLiveSessionType = LiveSessionType.LIVE_MODE_NORMAL;
    public VideoEncoderConfig mVideoEncoderConfig = new VideoEncoderConfig();
    public VideoEncoderConfig mDefaultVideoEncoderConfig = new VideoEncoderConfig();
    public List<YMFLowStreamEncoderConfig> mLowStreamEncoderConfigs = new LinkedList();
    public VideoEntities.CameraPreviewConfig mCameraPreviewConfig = new VideoEntities.CameraPreviewConfig();
    public VideoEntities.ScreenRecordConfig mScreenRecordConfig = new VideoEntities.ScreenRecordConfig();
    public boolean mHardwareEncode = true;
    private boolean mDoHaveReceiveIFrame = false;
    private IDynamicTexture mDynamicTexture = null;
    private ScreenShot mScreenShot = null;
    private AtomicReference<YYUserLiveConfig> mUserLiveConfig = new AtomicReference<>(null);
    private AtomicBoolean mMirrorFlag = new AtomicBoolean(false);
    private AtomicBoolean mPreviewMirrorFlag = new AtomicBoolean(true);
    private AtomicBoolean mSetCaptureReplaceImageFlag = new AtomicBoolean(false);
    private AtomicBoolean mPictureInPictureFlag = new AtomicBoolean(false);
    private AtomicBoolean mPictureSwitch = new AtomicBoolean(true);
    private Constant.EncoderInputMode mEncoderInputMode = Constant.EncoderInputMode.SURFACE;
    public WaterMarkTexture mWaterMarkTexture = null;
    private WaterMark mWatermark = null;
    private waterMarkUpdate mWaterMarkUpdateCB = null;
    public BackgroundTexture mBackgroundTexture = null;
    private AtomicBoolean mColorChartLiveEnable = new AtomicBoolean(false);
    public int mPeripheralsOrientation = 1;
    private AtomicBoolean mScreenLiveMode = new AtomicBoolean(false);
    private int mScreenLiveTextureId = -1;
    public ReentrantLock mSurfaceDestoryStateLock = new ReentrantLock(true);
    public AtomicBoolean mSurfaceDestoryState = new AtomicBoolean(false);
    public int mVirtualDisplayWidth = 0;
    public int mVirtualDisplayHeight = 0;
    public boolean mUsedAbroadNetWorkStrategy = false;
    public boolean mEnableUnderflowStrategy = true;
    private boolean mUseGLSurfaceView = false;
    private boolean mUseCanvasSurfaceView = false;
    private boolean mUseYuvCapture = false;
    private boolean mDisableBeauty = false;
    public boolean mHasBeautyProcess = false;
    private boolean mLowStreamEncoderEnable = false;
    public int mViewState = 0;
    private boolean mYuvTextureMode = false;
    public AtomicBoolean mChangeEncoderFlag = new AtomicBoolean(false);

    /* loaded from: classes6.dex */
    public interface waterMarkUpdate {
        void onWaterMarkUpdate(WaterMark waterMark);
    }

    public void setDeliverCallback(IYMFDeliverCallback iYMFDeliverCallback) {
        this.mDeliverCallback = iYMFDeliverCallback;
    }

    public void setDisableBeauty(boolean z) {
        YMFLog.info(this, "[Api     ]", "setDisableBeauty:" + z);
        this.mDisableBeauty = z;
    }

    public boolean isDisableBeauty() {
        return this.mDisableBeauty;
    }

    public void setUseGLSurfaceView(boolean z) {
        YMFLog.info(this, "[Api     ]", "setUseGLSurfaceView:" + z);
        this.mUseGLSurfaceView = z;
    }

    public boolean isUseGLSurfaceView() {
        return this.mUseGLSurfaceView;
    }

    public void setUseCanvasSurfaceView(boolean z) {
        YMFLog.info(this, "[Api     ]", "setUseSurfaceViewCanvas:" + z);
        this.mUseCanvasSurfaceView = z;
    }

    public boolean isUseCanvasSurfaceView() {
        return this.mUseCanvasSurfaceView;
    }

    public void setUseYuvCapture(boolean z) {
        YMFLog.info(this, "[Api     ]", "setUseYuvCapture:" + z);
        this.mUseYuvCapture = z;
    }

    public boolean isUseYuvCapture() {
        return this.mUseYuvCapture;
    }

    public void setYuvTextureMode(boolean z) {
        YMFLog.info(this, "[Api     ]", "setYuvTextureMode:" + z);
        this.mYuvTextureMode = z;
    }

    public boolean isYuvTextureMode() {
        return this.mYuvTextureMode;
    }

    public String getVideoFlowInfomation() {
        String str;
        StringBuilder append = new StringBuilder().append(" Capture:").append(isUseYuvCapture() ? "yuv" : "tex").append(" beauty:").append(isDisableBeauty() ? "dis" : h.f1535a).append(" Encoder:").append(getEncoderInputMode() == Constant.EncoderInputMode.SURFACE ? "surface" : " buffer").append(" preview:");
        if (isUseCanvasSurfaceView()) {
            str = "canvas";
        } else {
            str = isUseGLSurfaceView() ? "GL" : "tex";
        }
        return append.append(str).toString();
    }

    public VideoLiveFilterContext(Context context, Constant.VideoStreamType videoStreamType, Object obj) {
        this.mGlManager = null;
        this.mAndroidContext = null;
        this.mEncodeParamTipsMgr = null;
        this.mGlManager = new GlManager(videoStreamType.ordinal(), obj);
        this.mGlManager.setVideoLiveFilterContext(this);
        this.mAndroidContext = context.getApplicationContext();
        this.mEncodeParamTipsMgr = new LocalEncodeParamTipsMgr();
        this.mCameraPostion = new VideoRenderPosition(0, new Rect(0.6f, 0.4f, 1.0f, 0.0f), 1);
        this.mPeripheralsPosition = new VideoRenderPosition(0, new Rect(0.0f, 0.0f, 1.0f, 1.0f), 1);
    }

    public VideoLiveFilterContext(Context context, Constant.VideoStreamType videoStreamType) {
        this.mGlManager = null;
        this.mAndroidContext = null;
        this.mEncodeParamTipsMgr = null;
        this.mGlManager = new GlManager(videoStreamType.ordinal(), null);
        this.mGlManager.setVideoLiveFilterContext(this);
        this.mAndroidContext = context.getApplicationContext();
        this.mEncodeParamTipsMgr = new LocalEncodeParamTipsMgr();
        this.mCameraPostion = new VideoRenderPosition(0, new Rect(0.6f, 0.4f, 1.0f, 0.0f), 1);
        this.mPeripheralsPosition = new VideoRenderPosition(0, new Rect(0.0f, 0.0f, 1.0f, 1.0f), 1);
        if (videoStreamType == Constant.VideoStreamType.Camera) {
            setUseYuvCapture(UploadStreamStateParams.mCaptureMode == Constant.CaptureMode.YuvMode);
            setDisableBeauty(UploadStreamStateParams.mDisableBeauty);
            setEncoderInputMode(UploadStreamStateParams.mEncoderInputMode);
            setUseCanvasSurfaceView(UploadStreamStateParams.mPreviewMode == Constant.PreviewMode.CanvasMode);
            setUseGLSurfaceView(UploadStreamStateParams.mPreviewMode == Constant.PreviewMode.GlSurfaceMode);
            setYuvTextureMode(UploadStreamStateParams.mYuvTextureMode);
        }
    }

    public GlManager getGlManager() {
        return this.mGlManager;
    }

    public void setGlManager(GlManager glManager) {
        this.mGlManager = glManager;
    }

    public void setWaterMarkTexture(WaterMark waterMark) {
        if (this.mWaterMarkTexture != null) {
            this.mWaterMarkTexture.destroy();
            this.mWaterMarkTexture = null;
        }
        if (this.mWatermark != null) {
            this.mWatermark = null;
        }
        if (waterMark != null) {
            this.mWaterMarkTexture = new WaterMarkTexture(waterMark);
            this.mWatermark = waterMark;
        } else {
            this.mWaterMarkTexture = null;
            this.mWatermark = null;
        }
        if (this.mWaterMarkUpdateCB != null) {
            this.mWaterMarkUpdateCB.onWaterMarkUpdate(this.mWatermark);
        }
    }

    public void setWaterMarkUpdateCB(waterMarkUpdate watermarkupdate) {
        this.mWaterMarkUpdateCB = watermarkupdate;
    }

    public BackgroundTexture getBackgroundTexture() {
        return this.mBackgroundTexture;
    }

    public void setBackgroundTexture(Background background) {
        if (this.mBackgroundTexture != null) {
            this.mBackgroundTexture.destroy();
            this.mBackgroundTexture = null;
        }
        if (background != null) {
            this.mBackgroundTexture = new BackgroundTexture(background);
        } else {
            this.mBackgroundTexture = new BackgroundTexture(new Background(null, this.mVideoEncoderConfig.getEncodeWidth(), this.mVideoEncoderConfig.getEncodeHeight(), 0, 0, Background.Align.FullScreen));
        }
    }

    public int getBackgroundTextureId() {
        if (this.mBackgroundTexture == null) {
            return -1;
        }
        return this.mBackgroundTexture.mbackgroundTextureId;
    }

    public int getWatermarkTextureID() {
        if (this.mWaterMarkTexture == null) {
            return -1;
        }
        return this.mWaterMarkTexture.mWaterMarkTextureId;
    }

    public VideoEncoderConfig getVideoEncoderConfig() {
        return this.mVideoEncoderConfig;
    }

    public void setVideoConfig(VideoEncoderConfig videoEncoderConfig) {
        this.mVideoEncoderConfig.assign(videoEncoderConfig);
    }

    public boolean isLowDelayMode() {
        return this.mVideoEncoderConfig.mLowDelay;
    }

    public boolean isLowStreamEncoderEnable() {
        return this.mLowStreamEncoderEnable;
    }

    public void enableLowStreamEncoder(boolean z) {
        this.mLowStreamEncoderEnable = z;
    }

    public List<YMFLowStreamEncoderConfig> getLowStreamEncoderConfigs() {
        return this.mLowStreamEncoderConfigs;
    }

    public void setLowStreamEncoderConfigs(List<YMFLowStreamEncoderConfig> list) {
        this.mLowStreamEncoderConfigs.clear();
        if (list != null && list.size() > 0) {
            this.mLowStreamEncoderConfigs.addAll(list);
        }
    }

    public VideoEncoderConfig getDefaultVideoEncoderConfig() {
        return this.mDefaultVideoEncoderConfig;
    }

    public void setDefaultVideoConfig(VideoEncoderConfig videoEncoderConfig) {
        this.mDefaultVideoEncoderConfig.assign(videoEncoderConfig);
    }

    public Context getAndroidContext() {
        return this.mAndroidContext;
    }

    public VideoEntities.CameraPreviewConfig getCameraPreviewConfig() {
        return this.mCameraPreviewConfig;
    }

    public VideoEntities.ScreenRecordConfig getScreenRecordConfig() {
        return this.mScreenRecordConfig;
    }

    public void updateCameraPreviewConfig(int i, int i2, int i3, CameraInterface.CameraResolutionMode cameraResolutionMode) {
        this.mCameraPreviewConfig.setPreviewSize(i, i2);
        this.mCameraPreviewConfig.setCameraFacing(i3);
        this.mCameraPreviewConfig.setResMode(cameraResolutionMode);
    }

    public void setAndroidContext(Context context) {
        this.mAndroidContext = context.getApplicationContext();
    }

    public void setHardwareEncode(boolean z) {
        YMFLog.warn(this, "[Encoder ]", " setHardwareEncode " + z);
        this.mHardwareEncode = z;
    }

    public boolean isHardwareEncode() {
        return this.mHardwareEncode;
    }

    public IDynamicTexture getDynamicTexture() {
        return this.mDynamicTexture;
    }

    public WaterMarkTexture getWaterMarkTexture() {
        return this.mWaterMarkTexture;
    }

    public WaterMark getWatermark() {
        return this.mWatermark;
    }

    public void setDynamicTexture(IDynamicTexture iDynamicTexture) {
        this.mDynamicTexture = iDynamicTexture;
    }

    public int getDynamicTextureID() {
        if (this.mDynamicTexture != null) {
            return this.mDynamicTexture.getDynamicTextureId();
        }
        return -1;
    }

    public GlManager getGLManager() {
        return this.mGlManager;
    }

    public ScreenShot getScreenShot() {
        return this.mScreenShot;
    }

    public void setScreenShot(ScreenShot screenShot) {
        this.mScreenShot = screenShot;
    }

    public YYUserLiveConfig getUserLiveConfig() {
        return this.mUserLiveConfig.get();
    }

    public void setUserLiveConfig(YYUserLiveConfig yYUserLiveConfig) {
        this.mUserLiveConfig.set(yYUserLiveConfig);
    }

    public LocalEncodeParamTipsMgr getEncodeParamTipsMgr() {
        return this.mEncodeParamTipsMgr;
    }

    public void setSwitchPicture() {
        this.mPictureSwitch.set(!this.mPictureSwitch.get());
    }

    @Deprecated
    public boolean getSwithPictureFlag() {
        return this.mPictureSwitch.get();
    }

    public boolean getPictureInPictureFlag() {
        return this.mPictureInPictureFlag.get();
    }

    public void setPictureInPictureFlag(boolean z) {
        this.mPictureInPictureFlag.set(z);
        if (!z) {
            this.mPictureSwitch.set(true);
        }
    }

    private void initBitmapTexture(Bitmap bitmap) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.checkGlError("glGenTextures");
        this.mScreenLiveTextureId = iArr[0];
        GLES20.glBindTexture(3553, this.mScreenLiveTextureId);
        GlUtil.checkGlError("glBindTexture " + this.mScreenLiveTextureId);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GlUtil.checkGlError("glTexParameter");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.mScreenLiveTextureId);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        YMFLog.info(this, "[SCapture]", "setmScreenLiveMode  initBitmapTexture");
    }

    private void deinitBitmapTexture() {
        GLES20.glDeleteTextures(1, new int[]{this.mScreenLiveTextureId}, 0);
        this.mScreenLiveTextureId = -1;
        YMFLog.info(this, "[SCapture]", "setmScreenLiveMode  deinitBitmapTexture");
    }

    public void setScreenLiveMode(boolean z, Bitmap bitmap) {
        this.mScreenLiveMode.set(z);
        if (z) {
            if (this.mScreenLiveTextureId == -1) {
                initBitmapTexture(bitmap);
            }
        } else {
            deinitBitmapTexture();
        }
        YMFLog.info(this, "[SCapture]", "setmScreenLiveMode:" + z + " ," + bitmap);
    }

    public AtomicBoolean getScreenLiveMode() {
        return this.mScreenLiveMode;
    }

    public int getScreenLiveTextureId() {
        return this.mScreenLiveTextureId;
    }

    public void setColorChartLiveEnable(boolean z) {
        this.mColorChartLiveEnable.set(z);
    }

    public boolean getColorChartLiveEnable() {
        return this.mColorChartLiveEnable.get();
    }

    public void setRvSensor(RotationVectorSensor rotationVectorSensor) {
        this.mRotationVectorSensor = rotationVectorSensor;
    }

    public RotationVectorSensor getRotationVectorSensor() {
        return this.mRotationVectorSensor;
    }

    public void setVideoRenderPostion(VideoRenderPosition videoRenderPosition) {
        if (videoRenderPosition.channalId < 1000) {
            this.mCameraPostion = videoRenderPosition;
        } else if (videoRenderPosition.channalId > 1000) {
            this.mPeripheralsPosition = videoRenderPosition;
        }
    }

    public void setDoHaveReceiveIFrame(boolean z) {
        this.mDoHaveReceiveIFrame = z;
    }

    public boolean getDoHaveReceiveIFrame() {
        return this.mDoHaveReceiveIFrame;
    }

    public void setMirrorFlag(boolean z) {
        this.mMirrorFlag.set(z);
    }

    public boolean getMirrorFlag() {
        return this.mMirrorFlag.get();
    }

    public void setPreviewMirrorFlag(boolean z) {
        this.mPreviewMirrorFlag.set(z);
    }

    public boolean getPreviwMirrorFlag() {
        return this.mPreviewMirrorFlag.get();
    }

    public void setCaptureReplaceImageFlag(boolean z) {
        this.mSetCaptureReplaceImageFlag.set(z);
    }

    public boolean getCaptureReplaceImageFlag() {
        return this.mSetCaptureReplaceImageFlag.get();
    }

    public void setLiveMode(LiveSessionType liveSessionType) {
        this.mLiveSessionType = liveSessionType;
    }

    public LiveSessionType getLiveMode() {
        return this.mLiveSessionType;
    }

    public void setEncoderInputMode(Constant.EncoderInputMode encoderInputMode) {
        YMFLog.info(this, "[Encoder ]", " setEncoderInputMode:" + this.mEncoderInputMode + " ->" + encoderInputMode);
        this.mEncoderInputMode = encoderInputMode;
    }

    public Constant.EncoderInputMode getEncoderInputMode() {
        return this.mEncoderInputMode;
    }

    public void setAbroadNetWorkStrategy(boolean z) {
        this.mUsedAbroadNetWorkStrategy = z;
    }

    public void setEnableUnderflowStrategy(boolean z) {
        this.mEnableUnderflowStrategy = z;
    }
}
