package com.yy.mediaframework.screenlive;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.WindowManager;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.IEncoderListener;
import com.yy.mediaframework.ILiveSession;
import com.yy.mediaframework.YYVideoSDK;
import com.yy.mediaframework.api.YMFEncoderStatisticInfo;
import com.yy.mediaframework.api.YMFVideoEncodeFrame;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.base.YMFLowStreamEncoderConfig;
import com.yy.mediaframework.filters.ClipFilter;
import com.yy.mediaframework.filters.GPUPreprocessFilter;
import com.yy.mediaframework.filters.GlLoadImageFilter;
import com.yy.mediaframework.filters.ImageCaptureFilter;
import com.yy.mediaframework.filters.LiveSessionType;
import com.yy.mediaframework.filters.ScreenCaptureFilter;
import com.yy.mediaframework.filters.VideoEncoderGroupFilter;
import com.yy.mediaframework.filters.VideoEndPointFilter;
import com.yy.mediaframework.filters.VideoLiveFilterContext;
import com.yy.mediaframework.filters.YMFCaptureReplaceImageFilter;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import com.yy.mediaframework.inteligence.dynamictexture.IDynamicTexture;
import com.yy.mediaframework.screenshot.ScreenShot;
import com.yy.mediaframework.screenshot.ScreenShotCallback;
import com.yy.mediaframework.stat.UploadStatManager;
import com.yy.mediaframework.utils.YMFLog;
import com.yy.mediaframework.watermark.WaterMark;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
@TargetApi(21)
/* loaded from: classes4.dex */
public class ScreenLiveSessionYCloud implements IEncoderListener, ILiveSession, ScreenSurfaceCallback {
    private static final String TAG = "[ScreenLiveSessionYCloud]";
    private YMFCaptureReplaceImageFilter mCaptureReplaceImageFilter;
    private ClipFilter mCliperFilter;
    private VideoEncoderGroupFilter mEncoderGroupFilter;
    private VideoEndPointFilter mEndPointFilter;
    private VideoLiveFilterContext mFilterContext;
    private GlLoadImageFilter mGlLoadImageFilter;
    private ImageCaptureFilter mImageCaptureFilter;
    private MediaProjection mMediaProjection;
    private GPUPreprocessFilter mPreprocessFilter;
    private ScreenCaptureFilter mScreenCaptureFilter;
    private Surface mSurface;
    private VirtualDisplay mVirtualDisplay;
    private Bitmap mWaterMarkBitmap;
    private WeakReference<IEncoderListener> mEncoderListener = new WeakReference<>(null);
    private AtomicBoolean mHardwareEncoderAvailable = new AtomicBoolean(true);
    private long mLastCountTime = 0;
    private float mWaterMakeW = 0.0f;
    private float mWaterMakeH = 0.0f;
    private float mWaterMakeX = 0.0f;
    private float mWaterMakeY = 0.0f;
    private VideoEncoderConfig mVideoEncoderConfig = new VideoEncoderConfig();

    public ScreenLiveSessionYCloud(Context context, Constant.VideoStreamType videoStreamType) {
        YMFLog.info(this, "[Procedur]", "ScreenLiveSessionYCloud construct begin");
        this.mFilterContext = new VideoLiveFilterContext(context, videoStreamType);
        this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_SCREEN_RECORD);
        this.mFilterContext.setAndroidContext(context);
        this.mPreprocessFilter = new GPUPreprocessFilter(this.mFilterContext);
        this.mEncoderGroupFilter = new VideoEncoderGroupFilter(this.mFilterContext, this);
        this.mEncoderGroupFilter.setEncoderListener(this);
        getScreenBaseInfo(context);
        this.mFilterContext.setScreenShot(new ScreenShot(context, this.mFilterContext));
        this.mScreenCaptureFilter = new ScreenCaptureFilter(this.mFilterContext, context.getApplicationContext());
        this.mScreenCaptureFilter.addScreenSurfaceCallback(this);
        this.mCliperFilter = new ClipFilter();
        this.mGlLoadImageFilter = new GlLoadImageFilter();
        this.mImageCaptureFilter = new ImageCaptureFilter(this.mFilterContext, 3);
        this.mEndPointFilter = new VideoEndPointFilter(this.mFilterContext);
        this.mCaptureReplaceImageFilter = new YMFCaptureReplaceImageFilter(this.mFilterContext);
        this.mPreprocessFilter.addDownStream(this.mCaptureReplaceImageFilter.addDownStream(this.mCliperFilter.addDownStream(this.mEncoderGroupFilter)));
        this.mScreenCaptureFilter.addDownStream(this.mPreprocessFilter).addDownStream(this.mEndPointFilter);
        this.mImageCaptureFilter.addDownStream(this.mGlLoadImageFilter.addDownStream(this.mCliperFilter));
        this.mFilterContext.getGlManager().registerFilter(this.mPreprocessFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mEncoderGroupFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mScreenCaptureFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mImageCaptureFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mGlLoadImageFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mPreprocessFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mCliperFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mEncoderGroupFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mEndPointFilter);
        this.mFilterContext.getGLManager().registerFilter(this.mCaptureReplaceImageFilter);
        YMFLog.info(this, "[Procedur]", "ScreenLiveSessionYCloud construct done");
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void startEncoder() {
        YMFLog.info(this, "[Encoder ]", "startEncoder...");
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.1
            @Override // java.lang.Runnable
            public void run() {
                ScreenLiveSessionYCloud.this.mFilterContext.getUserLiveConfig();
                if (ScreenLiveSessionYCloud.this.mEncoderGroupFilter.isEnable()) {
                    YMFLog.info(this, "[Encoder ]", "encoder is started already!!");
                } else if (ScreenLiveSessionYCloud.this.mEncoderGroupFilter.startEncode(ScreenLiveSessionYCloud.this.mFilterContext.getVideoEncoderConfig())) {
                    UploadStatManager.getInstance().startStat();
                }
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void stopEncoder() {
        YMFLog.info(this, "[Encoder ]", "stopEncoder...");
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.2
            @Override // java.lang.Runnable
            public void run() {
                UploadStatManager.getInstance().stopStat();
                if (ScreenLiveSessionYCloud.this.mEncoderGroupFilter.isEnable()) {
                    ScreenLiveSessionYCloud.this.mEncoderGroupFilter.stopEncode();
                }
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setEncoderConfig(VideoEncoderConfig videoEncoderConfig) {
        this.mVideoEncoderConfig = videoEncoderConfig;
        if (YYVideoSDK.getInstance().mIsEmulator) {
            this.mVideoEncoderConfig.mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
        }
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.3
            @Override // java.lang.Runnable
            public void run() {
                ScreenLiveSessionYCloud.this.mFilterContext.getVideoEncoderConfig().assign(ScreenLiveSessionYCloud.this.mVideoEncoderConfig);
                YMFLog.info(this, "[Encoder ]", "setEncoderConfig:" + ScreenLiveSessionYCloud.this.mFilterContext.getVideoEncoderConfig().toString());
                ScreenLiveSessionYCloud.this.mFilterContext.getDefaultVideoEncoderConfig().assign(ScreenLiveSessionYCloud.this.mVideoEncoderConfig);
                ScreenLiveSessionYCloud.this.mPreprocessFilter.init(ScreenLiveSessionYCloud.this.mVideoEncoderConfig.getEncodeWidth(), ScreenLiveSessionYCloud.this.mVideoEncoderConfig.getEncodeHeight());
                ScreenLiveSessionYCloud.this.mEncoderGroupFilter.init();
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setLowStreamEncoderConfigs(final List<YMFLowStreamEncoderConfig> list, final boolean z) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.4
            @Override // java.lang.Runnable
            public void run() {
                ScreenLiveSessionYCloud.this.mFilterContext.setLowStreamEncoderConfigs(list);
                ScreenLiveSessionYCloud.this.mFilterContext.enableLowStreamEncoder(z);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setEncoderListener(final IEncoderListener iEncoderListener) {
        if (iEncoderListener == null) {
            YMFLog.info(this, "[Encoder ]", "set encodelistener:" + iEncoderListener);
            this.mEncoderListener = new WeakReference<>(iEncoderListener);
            if (iEncoderListener != null) {
                iEncoderListener.onEncodeEncParam(this.mFilterContext.getEncodeParamTipsMgr().getParam());
                return;
            }
            return;
        }
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.5
            @Override // java.lang.Runnable
            public void run() {
                YMFLog.info(this, "[Encoder ]", "set encodelistener:" + iEncoderListener);
                ScreenLiveSessionYCloud.this.mEncoderListener = new WeakReference(iEncoderListener);
                if (iEncoderListener != null) {
                    iEncoderListener.onEncodeEncParam(ScreenLiveSessionYCloud.this.mFilterContext.getEncodeParamTipsMgr().getParam());
                }
            }
        });
    }

    public void setWaterMark(final WaterMark waterMark) {
        YMFLog.info(this, "[Beauty  ]", "setWaterMark, waterMark==null? " + (waterMark == null ? "y" : "n"));
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.6
            @Override // java.lang.Runnable
            public void run() {
                ScreenLiveSessionYCloud.this.mFilterContext.setWaterMarkTexture(waterMark);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setWaterMark(Bitmap bitmap, int i, int i2) {
        if (this.mVideoEncoderConfig != null) {
            YMFLog.info(this, "[Beauty  ]", "setWaterMark, bitmap==null? " + (bitmap == null ? "y" : "n") + "<" + i + "." + i2 + ">");
            this.mWaterMarkBitmap = bitmap;
            if (bitmap == null) {
                setWaterMark(null);
            } else if (bitmap != null && bitmap != null && (bitmap.getWidth() + i > this.mVideoEncoderConfig.mEncodeWidth || bitmap.getHeight() + i2 > this.mVideoEncoderConfig.mEncodeHeight)) {
                YMFLog.error(this, "[Encoder ]", "setWaterMark error:" + bitmap.getWidth() + "+" + i + ">" + this.mVideoEncoderConfig.mEncodeWidth + " OR " + bitmap.getHeight() + "+" + i2 + ">" + this.mVideoEncoderConfig.mEncodeHeight);
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

    @Override // com.yy.mediaframework.ILiveSession
    public void setDynamicTexture(final IDynamicTexture iDynamicTexture) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.7
            @Override // java.lang.Runnable
            public void run() {
                ScreenLiveSessionYCloud.this.mFilterContext.setDynamicTexture(iDynamicTexture);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setNetworkBitrateSuggest(final int i) {
        YMFLog.info(this, "[Encoder ]", "setNetworkBitrateSuggest:" + i);
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.8
            @Override // java.lang.Runnable
            public void run() {
                ScreenLiveSessionYCloud.this.mEncoderGroupFilter.setNetworkBitrateSuggest(i);
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

    @Override // com.yy.mediaframework.ILiveSession
    public void requestIFrame() {
        YMFLog.info(this, "[Encoder ]", "requestIFrame");
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.9
            @Override // java.lang.Runnable
            public void run() {
                if (ScreenLiveSessionYCloud.this.mEncoderGroupFilter != null) {
                    ScreenLiveSessionYCloud.this.mEncoderGroupFilter.requestSyncFrame();
                }
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setLowDelayMode(final boolean z) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.10
            @Override // java.lang.Runnable
            public void run() {
                ScreenLiveSessionYCloud.this.mFilterContext.getVideoEncoderConfig().mLowDelay = z;
                YMFLog.info(this, "[Encoder ]", "setLowDelayMode:" + z + " config:" + ScreenLiveSessionYCloud.this.mFilterContext.getVideoEncoderConfig().toString());
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setResolutionModifyConfigs(final List<ResolutionModifyConfig> list, final int i) {
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.11
            @Override // java.lang.Runnable
            public void run() {
                if (YYVideoSDK.getInstance().mIsEmulator) {
                    for (ResolutionModifyConfig resolutionModifyConfig : list) {
                        resolutionModifyConfig.videoEncoderType = VideoEncoderType.SOFT_ENCODER_X264;
                        resolutionModifyConfig.encoderParams = "";
                    }
                }
                ScreenLiveSessionYCloud.this.mEncoderGroupFilter.setResolutionModifyConfigs(list, i);
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
    public void onHardEncoderError() {
        IEncoderListener iEncoderListener = this.mEncoderListener.get();
        if (iEncoderListener != null) {
            iEncoderListener.onHardEncoderError();
        }
        YMFLog.info(this, "[Encoder ]", "onHardEncoderError in ScreenLiveSessionYCloud");
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

    public void startCapture(MediaProjection mediaProjection) {
        YMFLog.info(this, "[SCapture]", "startCapture...");
        this.mMediaProjection = mediaProjection;
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.12
            @Override // java.lang.Runnable
            public void run() {
                ScreenLiveSessionYCloud.this.mScreenCaptureFilter.init();
                ScreenLiveSessionYCloud.this.mImageCaptureFilter.init();
                ScreenLiveSessionYCloud.this.mScreenCaptureFilter.startCapture();
            }
        });
    }

    public void stopCapture() {
        this.mMediaProjection = null;
        YMFLog.info(this, "[SCapture]", "stopCapture...");
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.13
            @Override // java.lang.Runnable
            public void run() {
                ScreenLiveSessionYCloud.this.mScreenCaptureFilter.deInit();
                ScreenLiveSessionYCloud.this.mImageCaptureFilter.deInit();
                ScreenLiveSessionYCloud.this.mScreenCaptureFilter.stopCapture();
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void stopAndRelease() {
        YMFLog.info(this, "[SCapture]", "ScreenLiveSessionYCloud stopAndRelease begin");
        this.mScreenCaptureFilter.stopCapture();
        this.mFilterContext.getGLManager().getHandler().removeCallbacksAndMessages(null);
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.14
            @Override // java.lang.Runnable
            public void run() {
                if (ScreenLiveSessionYCloud.this.mFilterContext.getScreenShot() != null) {
                    ScreenLiveSessionYCloud.this.mFilterContext.getScreenShot().deInit();
                }
                if (ScreenLiveSessionYCloud.this.mFilterContext.getDynamicTexture() != null) {
                    ScreenLiveSessionYCloud.this.mFilterContext.getDynamicTexture().onRelease();
                    ScreenLiveSessionYCloud.this.mFilterContext.setDynamicTexture(null);
                }
                if (ScreenLiveSessionYCloud.this.mFilterContext.getWaterMarkTexture() != null) {
                    ScreenLiveSessionYCloud.this.mFilterContext.getWaterMarkTexture().destroy();
                    ScreenLiveSessionYCloud.this.mFilterContext.setWaterMarkTexture(null);
                }
                UploadStatManager.getInstance().stopStat();
                ScreenLiveSessionYCloud.this.mFilterContext.getGLManager().quit();
            }
        });
        YMFLog.info(this, "[SCapture]", "ScreenLiveSessionYCloud stopAndRelease done");
    }

    public void setCaptureResolution(final int i, final int i2) {
        YMFLog.info(this, "[SCapture]", " setCaptureResolution, width:" + i + " ,height:" + i2);
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.15
            @Override // java.lang.Runnable
            public void run() {
                ScreenLiveSessionYCloud.this.mFilterContext.getScreenRecordConfig().setScreenSize(i, i2);
            }
        });
    }

    public void imageFrameAvailable(ByteBuffer byteBuffer, int i, int i2, int i3) {
        if (this.mImageCaptureFilter != null) {
            byteBuffer.position(0);
            this.mImageCaptureFilter.onImageAvailable(byteBuffer, i, i2, i3);
        }
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void takeScreenShot(ScreenShotCallback screenShotCallback) {
        this.mFilterContext.getScreenShot().setCallback(screenShotCallback);
    }

    public void setSelfMode(boolean z) {
        YMFLog.info(this, "[SCapture]", "setSelfMode,isSelfMode:" + z);
        if (!z) {
            this.mScreenCaptureFilter.startCapture();
        } else {
            this.mScreenCaptureFilter.stopCapture();
        }
    }

    public void setScreenCropArea(RectF rectF) {
        YMFLog.info(this, "[SCapture]", "setScreenCropArea...rectF:" + rectF + " ,mScreenCaptureFilter:" + this.mScreenCaptureFilter);
        if (this.mScreenCaptureFilter != null) {
            this.mScreenCaptureFilter.setScreenCropArea(rectF);
        }
    }

    public void setDeltaYYPtsMillions(final long j) {
        YMFLog.info(this, "[Encoder ]", "setDeltaYYPtsMillions:" + j);
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.16
            @Override // java.lang.Runnable
            public void run() {
                YYVideoSDK.getInstance().setDeltaYYPtsMillions(j);
            }
        });
    }

    @Override // com.yy.mediaframework.screenlive.ScreenSurfaceCallback
    public void surfaceCreated(Surface surface) {
        YMFLog.info(this, "[Preview ]", "surfaceCreated");
        this.mSurface = surface;
        if (this.mVirtualDisplay == null) {
            YMFLog.info(this, "[Preview ]", "createVirtualDisplay, width:" + this.mFilterContext.mVirtualDisplayWidth + " , height:" + this.mFilterContext.mVirtualDisplayHeight);
            this.mVirtualDisplay = this.mMediaProjection.createVirtualDisplay(getClass().getName(), this.mFilterContext.mVirtualDisplayWidth, this.mFilterContext.mVirtualDisplayHeight, this.mFilterContext.mScreenDensityDpi, 16, this.mSurface, null, null);
        }
    }

    @Override // com.yy.mediaframework.screenlive.ScreenSurfaceCallback
    public void detachSurface() {
        this.mVirtualDisplay.setSurface(null);
    }

    @Override // com.yy.mediaframework.screenlive.ScreenSurfaceCallback
    public void attachSurface(Surface surface) {
        this.mVirtualDisplay.setSurface(surface);
    }

    @Override // com.yy.mediaframework.screenlive.ScreenSurfaceCallback
    public void surfaceChange(Surface surface) {
        this.mVirtualDisplay.resize(this.mFilterContext.mVirtualDisplayWidth, this.mFilterContext.mVirtualDisplayHeight, this.mFilterContext.mScreenDensityDpi);
        YMFLog.info(this, "[Preview ]", "surfaceChange,resize width:" + this.mFilterContext.mVirtualDisplayWidth + " , height:" + this.mFilterContext.mVirtualDisplayHeight);
    }

    @Override // com.yy.mediaframework.screenlive.ScreenSurfaceCallback
    public void surfaceDestroyed(Surface surface) {
        YMFLog.info(this, "[Preview ]", "surfaceDestroyed");
        if (this.mVirtualDisplay != null) {
            this.mVirtualDisplay.release();
            this.mFilterContext.mVirtualDisplayWidth = 0;
            this.mFilterContext.mVirtualDisplayHeight = 0;
            this.mVirtualDisplay = null;
        }
    }

    private void getScreenBaseInfo(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.mFilterContext.mScreenWidth = displayMetrics.widthPixels;
        this.mFilterContext.mScreenHeight = displayMetrics.heightPixels;
        this.mFilterContext.mScreenDensityDpi = displayMetrics.densityDpi;
        YMFLog.info(this, "[SCapture]", "getScreenBaseInfo, mScreenWidth:" + this.mFilterContext.mScreenWidth + " ,mScreenHeight:" + this.mFilterContext.mScreenHeight + " ,mScreenDensityDpi:" + this.mFilterContext.mScreenDensityDpi);
    }

    public void changeScreenLiveMode(final boolean z, final Bitmap bitmap) {
        if (this.mFilterContext == null) {
            YMFLog.warn(this, "[SCapture]", "changeScreenLiveMode, normal:" + z + " mFilterContext == null");
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.17
                @Override // java.lang.Runnable
                public void run() {
                    ScreenLiveSessionYCloud.this.mFilterContext.setScreenLiveMode(z, bitmap);
                }
            });
        }
    }

    public void setAbroadNetWorkStrategy(boolean z) {
        if (this.mFilterContext != null) {
            this.mFilterContext.setAbroadNetWorkStrategy(z);
        }
    }

    public void setCaptureReplaceImage(final Bitmap bitmap) {
        if (this.mFilterContext != null) {
            this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.screenlive.ScreenLiveSessionYCloud.18
                @Override // java.lang.Runnable
                public void run() {
                    if (ScreenLiveSessionYCloud.this.mCaptureReplaceImageFilter != null) {
                        ScreenLiveSessionYCloud.this.mCaptureReplaceImageFilter.setReplaceBitmap(bitmap);
                    }
                    if (ScreenLiveSessionYCloud.this.mEncoderGroupFilter != null) {
                        ScreenLiveSessionYCloud.this.mEncoderGroupFilter.requestSyncFrame();
                    }
                }
            });
        }
    }
}
