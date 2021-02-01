package com.yy.mediaframework;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.ExternalInterface;
import com.yy.mediaframework.api.YMFEncoderStatisticInfo;
import com.yy.mediaframework.api.YMFVideoEncodeFrame;
import com.yy.mediaframework.background.Background;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.base.YMFLowStreamEncoderConfig;
import com.yy.mediaframework.filters.ClipFilter;
import com.yy.mediaframework.filters.LiveSessionType;
import com.yy.mediaframework.filters.OriginDataEntryFilter;
import com.yy.mediaframework.filters.VideoEncoderGroupFilter;
import com.yy.mediaframework.filters.VideoEndPointFilter;
import com.yy.mediaframework.filters.VideoLiveFilterContext;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import com.yy.mediaframework.inteligence.dynamictexture.IDynamicTexture;
import com.yy.mediaframework.model.DecodeVideoConfig;
import com.yy.mediaframework.model.DecodeVideoSample;
import com.yy.mediaframework.model.ExternalDecodeInfo;
import com.yy.mediaframework.model.ExternalYYMediaSample;
import com.yy.mediaframework.screenshot.ScreenShotCallback;
import com.yy.mediaframework.stat.UploadStatManager;
import com.yy.mediaframework.stat.VideoDataStatUtil;
import com.yy.mediaframework.utils.TimeUtil;
import com.yy.mediaframework.utils.YMFLog;
import com.yy.mediaframework.watermark.WaterMark;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class YMFExternalTextureSessionYCloud implements IEncoderListener, ILiveSession, IMediaCodecUpload {
    private static final String TAG = "[VideoLiveSessionYCloud]";
    public ClipFilter mCliperFilter;
    public VideoEncoderGroupFilter mEncoderGroupFilter;
    public VideoEndPointFilter mEndPointFilter;
    public VideoLiveFilterContext mFilterContext;
    private Bitmap mWaterMarkBitmap;
    private WeakReference<IEncoderListener> mEncoderListener = new WeakReference<>(null);
    private AtomicBoolean mHardwareEncoderAvailable = new AtomicBoolean(true);
    private VideoEncoderConfig mVideoEncoderConfig = new VideoEncoderConfig();
    private Object mSurfaceSync = new Object();
    private float mWaterMakeW = 0.0f;
    private float mWaterMakeH = 0.0f;
    private float mWaterMakeX = 0.0f;
    private float mWaterMakeY = 0.0f;
    private OriginDataEntryFilter mOriginDataFilter = null;
    private AtomicBoolean mOriginInputTexture = new AtomicBoolean(false);

    public YMFExternalTextureSessionYCloud(Context context, Constant.VideoStreamType videoStreamType, Object obj) {
        this.mCliperFilter = null;
        this.mEncoderGroupFilter = null;
        this.mFilterContext = null;
        this.mEndPointFilter = null;
        synchronized (this.mSurfaceSync) {
            if (obj == null) {
                this.mOriginInputTexture.set(false);
                this.mFilterContext = new VideoLiveFilterContext(context, videoStreamType);
            } else {
                this.mOriginInputTexture.set(true);
                this.mFilterContext = new VideoLiveFilterContext(context, videoStreamType, obj);
            }
            this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_NORMAL);
            this.mFilterContext.setAndroidContext(context);
            this.mCliperFilter = new ClipFilter();
            this.mEncoderGroupFilter = new VideoEncoderGroupFilter(this.mFilterContext, this);
            this.mEndPointFilter = new VideoEndPointFilter(this.mFilterContext);
            this.mEncoderGroupFilter.setEncoderListener(this);
        }
        this.mFilterContext.getGlManager().registerFilter(this.mCliperFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mEncoderGroupFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mEndPointFilter);
        YMFLog.info(this, "[Procedur]", "videoLiveSession #### use " + this.mFilterContext.getVideoFlowInfomation() + " isEmulator:" + YYVideoSDK.getInstance().mIsEmulator);
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void stopAndRelease() {
        YMFLog.info(this, "[Procedur]", "VideoLiveSession stopAndRelease begin");
        UploadStatManager.getInstance().setIGetCurrentCameraStatInfo(null);
        UploadStatManager.getInstance().setIGetImageFilterInfo(null);
        if (this.mFilterContext.getGLManager().checkSameThread()) {
            if (this.mFilterContext.getScreenShot() != null) {
                this.mFilterContext.getScreenShot().deInit();
            }
            if (this.mFilterContext.getDynamicTexture() != null) {
                this.mFilterContext.getDynamicTexture().onRelease();
                this.mFilterContext.setDynamicTexture(null);
            }
            if (this.mFilterContext.getWaterMarkTexture() != null) {
                this.mFilterContext.getWaterMarkTexture().destroy();
                this.mFilterContext.setWaterMarkTexture(null);
            }
            if (this.mFilterContext.getBackgroundTexture() != null) {
                this.mFilterContext.getBackgroundTexture().destroy();
                this.mFilterContext.setBackgroundTexture(null);
            }
            UploadStatManager.getInstance().stopStat();
            this.mFilterContext.getGLManager().quit();
        } else {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.1
                @Override // java.lang.Runnable
                public void run() {
                    if (YMFExternalTextureSessionYCloud.this.mFilterContext.getWaterMarkTexture() != null) {
                        YMFExternalTextureSessionYCloud.this.mFilterContext.getWaterMarkTexture().destroy();
                        YMFExternalTextureSessionYCloud.this.mFilterContext.setWaterMarkTexture(null);
                    }
                    if (YMFExternalTextureSessionYCloud.this.mFilterContext.getBackgroundTexture() != null) {
                        YMFExternalTextureSessionYCloud.this.mFilterContext.getBackgroundTexture().destroy();
                        YMFExternalTextureSessionYCloud.this.mFilterContext.setBackgroundTexture(null);
                    }
                    UploadStatManager.getInstance().stopStat();
                    YMFExternalTextureSessionYCloud.this.mFilterContext.getGLManager().quit();
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(1500L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                YMFLog.error(this, "[Preview ]", "stopAndRelease timeout exception:" + e.toString());
            }
        }
        YMFLog.info(this, "[Procedur]", "VideoLiveSession stopAndRelease done");
        VideoDataStatUtil.clearPtsTimes(1001L);
    }

    public void setDeltaYYPtsMillions(final long j) {
        YMFLog.info(this, "[Encoder ]", "setDeltaYYPtsMillions:" + j);
        if (this.mFilterContext.getGLManager().checkSameThread()) {
            YYVideoSDK.getInstance().setDeltaYYPtsMillions(j);
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.2
                @Override // java.lang.Runnable
                public void run() {
                    YYVideoSDK.getInstance().setDeltaYYPtsMillions(j);
                }
            });
        }
    }

    public boolean getExternalType() {
        return this.mOriginInputTexture.get();
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setWaterMark(final WaterMark waterMark) {
        YMFLog.info(this, "[Beauty  ]", "setWaterMark, waterMark==null? " + (waterMark == null ? "y" : "n"));
        if (this.mFilterContext.getGLManager().checkSameThread()) {
            this.mFilterContext.setWaterMarkTexture(waterMark);
        } else {
            this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.3
                @Override // java.lang.Runnable
                public void run() {
                    YMFExternalTextureSessionYCloud.this.mFilterContext.setWaterMarkTexture(waterMark);
                }
            });
        }
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void startEncoder() {
        if (this.mFilterContext.getGLManager().checkSameThread()) {
            this.mFilterContext.getUserLiveConfig();
            if (!isHardwareEncoderAvailable()) {
                this.mFilterContext.mVideoEncoderConfig.mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
            }
            if (this.mEncoderGroupFilter.isEnable()) {
                YMFLog.info(this, "[Encoder ]", "encoder is started already!!");
                return;
            }
            try {
                if (this.mEncoderGroupFilter.startEncode(this.mFilterContext.getVideoEncoderConfig())) {
                    UploadStatManager.getInstance().startStat();
                    return;
                }
                return;
            } catch (Exception e) {
                YMFLog.error(this, "[Encoder ]", "startEncode exception:" + e);
                return;
            }
        }
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.4
            @Override // java.lang.Runnable
            public void run() {
                YMFExternalTextureSessionYCloud.this.mFilterContext.getUserLiveConfig();
                if (!YMFExternalTextureSessionYCloud.this.isHardwareEncoderAvailable()) {
                    YMFExternalTextureSessionYCloud.this.mFilterContext.mVideoEncoderConfig.mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
                }
                if (YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.isEnable()) {
                    YMFLog.info(this, "[Encoder ]", "encoder is started already!!");
                    return;
                }
                try {
                    if (YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.startEncode(YMFExternalTextureSessionYCloud.this.mFilterContext.getVideoEncoderConfig())) {
                        UploadStatManager.getInstance().startStat();
                    }
                } catch (Exception e2) {
                    YMFLog.error(this, "[Encoder ]", "startEncode exception:" + e2);
                }
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void stopEncoder() {
        if (this.mFilterContext.getGLManager().checkSameThread()) {
            UploadStatManager.getInstance().stopStat();
            if (this.mEncoderGroupFilter.isEnable()) {
                this.mEncoderGroupFilter.stopEncode();
                return;
            }
            return;
        }
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.5
            @Override // java.lang.Runnable
            public void run() {
                UploadStatManager.getInstance().stopStat();
                if (YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.isEnable()) {
                    YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.stopEncode();
                }
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
        if (this.mFilterContext.getGLManager().checkSameThread()) {
            this.mFilterContext.setBackgroundTexture(background);
        } else {
            this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.6
                @Override // java.lang.Runnable
                public void run() {
                    YMFExternalTextureSessionYCloud.this.mFilterContext.setBackgroundTexture(background);
                }
            });
        }
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setDynamicTexture(final IDynamicTexture iDynamicTexture) {
        if (this.mFilterContext.getGLManager().checkSameThread()) {
            YMFLog.info(this, "[Beauty  ]", "setDynamicTexture");
            this.mFilterContext.setDynamicTexture(iDynamicTexture);
            return;
        }
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.7
            @Override // java.lang.Runnable
            public void run() {
                YMFLog.info(this, "[Beauty  ]", "setDynamicTexture");
                YMFExternalTextureSessionYCloud.this.mFilterContext.setDynamicTexture(iDynamicTexture);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setNetworkBitrateSuggest(final int i) {
        YMFLog.info(this, "[Encoder ]", "setNetworkBitrateSuggest:" + i);
        if (this.mFilterContext.getGLManager().checkSameThread()) {
            this.mEncoderGroupFilter.setNetworkBitrateSuggest(i);
        } else {
            this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.8
                @Override // java.lang.Runnable
                public void run() {
                    YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.setNetworkBitrateSuggest(i);
                }
            });
        }
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setLowStreamEncoderConfigs(final List<YMFLowStreamEncoderConfig> list, final boolean z) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.9
            @Override // java.lang.Runnable
            public void run() {
                YMFExternalTextureSessionYCloud.this.mFilterContext.setLowStreamEncoderConfigs(list);
                YMFExternalTextureSessionYCloud.this.mFilterContext.enableLowStreamEncoder(z);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setResolutionModifyConfigs(final List<ResolutionModifyConfig> list, final int i) {
        if (this.mFilterContext.getGLManager().checkSameThread()) {
            if (YYVideoSDK.getInstance().mIsEmulator) {
                for (ResolutionModifyConfig resolutionModifyConfig : list) {
                    resolutionModifyConfig.videoEncoderType = VideoEncoderType.SOFT_ENCODER_X264;
                    resolutionModifyConfig.encoderParams = "";
                }
            }
            this.mEncoderGroupFilter.setResolutionModifyConfigs(list, i);
            return;
        }
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.10
            @Override // java.lang.Runnable
            public void run() {
                if (YYVideoSDK.getInstance().mIsEmulator) {
                    for (ResolutionModifyConfig resolutionModifyConfig2 : list) {
                        resolutionModifyConfig2.videoEncoderType = VideoEncoderType.SOFT_ENCODER_X264;
                        resolutionModifyConfig2.encoderParams = "";
                    }
                }
                YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.setResolutionModifyConfigs(list, i);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setEncoderListener(final IEncoderListener iEncoderListener) {
        if (iEncoderListener == null) {
            YMFLog.info(this, "[Encoder ]", "setEncoderlistener:" + iEncoderListener);
            this.mEncoderListener = new WeakReference<>(iEncoderListener);
            if (iEncoderListener != null) {
                iEncoderListener.onEncodeEncParam(this.mFilterContext.getEncodeParamTipsMgr().getParam());
            }
        } else if (this.mFilterContext.getGLManager().checkSameThread()) {
            YMFLog.info(this, "[Encoder ]", "setEncoderlistener:" + iEncoderListener);
            this.mEncoderListener = new WeakReference<>(iEncoderListener);
            if (iEncoderListener != null) {
                iEncoderListener.onEncodeEncParam(this.mFilterContext.getEncodeParamTipsMgr().getParam());
            }
        } else {
            this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.11
                @Override // java.lang.Runnable
                public void run() {
                    YMFLog.info(this, "[Encoder ]", "setEncoderlistener:" + iEncoderListener);
                    YMFExternalTextureSessionYCloud.this.mEncoderListener = new WeakReference(iEncoderListener);
                    if (iEncoderListener != null) {
                        iEncoderListener.onEncodeEncParam(YMFExternalTextureSessionYCloud.this.mFilterContext.getEncodeParamTipsMgr().getParam());
                    }
                }
            });
        }
    }

    public void assignEncoderConfig(VideoEncoderConfig videoEncoderConfig) {
        YMFLog.info(this, "[Encoder ]", "setEncoderconfig:" + videoEncoderConfig.toString());
        this.mVideoEncoderConfig = videoEncoderConfig;
        if (YYVideoSDK.getInstance().mIsEmulator) {
            this.mVideoEncoderConfig.mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
        }
        if (!this.mFilterContext.getGLManager().checkSameThread()) {
            this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.12
                @Override // java.lang.Runnable
                public void run() {
                    YMFExternalTextureSessionYCloud.this.mFilterContext.getVideoEncoderConfig().assign(YMFExternalTextureSessionYCloud.this.mVideoEncoderConfig);
                    if (YMFExternalTextureSessionYCloud.this.mFilterContext.mChangeEncoderFlag.get() && YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.isEnable()) {
                        YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.stopEncode();
                        YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.startEncode(YMFExternalTextureSessionYCloud.this.mVideoEncoderConfig);
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
        if (this.mFilterContext == null) {
            YMFLog.info(this, "[Encoder ]", "setEncoderconfig: only save cfg" + videoEncoderConfig.toString());
            return;
        }
        if (YYVideoSDK.getInstance().mIsEmulator) {
            this.mVideoEncoderConfig.mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
        }
        if (!this.mFilterContext.getGLManager().checkSameThread()) {
            this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.13
                @Override // java.lang.Runnable
                public void run() {
                    YMFExternalTextureSessionYCloud.this.mFilterContext.getVideoEncoderConfig().assign(YMFExternalTextureSessionYCloud.this.mVideoEncoderConfig);
                    YMFLog.info(this, "[Encoder ]", "setEncoderConfig:" + YMFExternalTextureSessionYCloud.this.mFilterContext.getVideoEncoderConfig().toString());
                    YMFExternalTextureSessionYCloud.this.mFilterContext.getDefaultVideoEncoderConfig().assign(YMFExternalTextureSessionYCloud.this.mVideoEncoderConfig);
                    YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.init();
                    if (YMFExternalTextureSessionYCloud.this.mFilterContext.mChangeEncoderFlag.get() && YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.isEnable()) {
                        YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.stopEncode();
                        YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.startEncode(YMFExternalTextureSessionYCloud.this.mVideoEncoderConfig);
                    }
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
        this.mEncoderGroupFilter.init();
        if (this.mFilterContext.mChangeEncoderFlag.get() && this.mEncoderGroupFilter.isEnable()) {
            this.mEncoderGroupFilter.stopEncode();
            this.mEncoderGroupFilter.startEncode(this.mVideoEncoderConfig);
        }
        UploadStatManager.getInstance().putSettingBitRate(videoEncoderConfig.getBitRate());
        UploadStatManager.getInstance().putSettingDPI(videoEncoderConfig.getRealDPI());
        UploadStatManager.getInstance().putSettingFrameRate(videoEncoderConfig.getFrameRate());
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setLowDelayMode(final boolean z) {
        if (this.mFilterContext.getGLManager().checkSameThread()) {
            this.mFilterContext.getVideoEncoderConfig().mLowDelay = z;
            YMFLog.info(this, "[Encoder ]", "setLowDelayMode:" + z + " config:" + this.mFilterContext.getVideoEncoderConfig().toString());
            if (this.mFilterContext.mChangeEncoderFlag.get() && this.mEncoderGroupFilter.isEnable()) {
                this.mEncoderGroupFilter.stopEncode();
                this.mEncoderGroupFilter.startEncode(this.mVideoEncoderConfig);
                return;
            }
            return;
        }
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.14
            @Override // java.lang.Runnable
            public void run() {
                YMFExternalTextureSessionYCloud.this.mFilterContext.getVideoEncoderConfig().mLowDelay = z;
                YMFLog.info(this, "[Encoder ]", "setLowDelayMode:" + z + " config:" + YMFExternalTextureSessionYCloud.this.mFilterContext.getVideoEncoderConfig().toString());
                if (YMFExternalTextureSessionYCloud.this.mFilterContext.mChangeEncoderFlag.get() && YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.isEnable()) {
                    YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.stopEncode();
                    YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.startEncode(YMFExternalTextureSessionYCloud.this.mVideoEncoderConfig);
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
        if (this.mFilterContext.getGLManager().checkSameThread()) {
            if (this.mEncoderGroupFilter != null) {
                this.mEncoderGroupFilter.requestSyncFrame();
                return;
            }
            return;
        }
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.15
            @Override // java.lang.Runnable
            public void run() {
                if (YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter != null) {
                    YMFExternalTextureSessionYCloud.this.mEncoderGroupFilter.requestSyncFrame();
                }
            }
        });
    }

    public void enableColorChartLive(final boolean z) {
        YMFLog.info(this, "[Encoder ]", "enableColorChartLive:" + z);
        if (this.mFilterContext.getGLManager().checkSameThread()) {
            this.mFilterContext.setColorChartLiveEnable(z);
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.YMFExternalTextureSessionYCloud.16
                @Override // java.lang.Runnable
                public void run() {
                    YMFExternalTextureSessionYCloud.this.mFilterContext.setColorChartLiveEnable(z);
                }
            });
        }
    }

    public void enableMirror(boolean z) {
        YMFLog.info(this, "[Encoder ]", "enableEncodeMirror:" + z);
        if (this.mFilterContext != null) {
            this.mFilterContext.setMirrorFlag(z);
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
    public void setGLManagerRunnable(Runnable runnable) {
        if (this.mFilterContext != null) {
            this.mFilterContext.getGLManager().post(runnable);
        }
    }

    public void initOriginDataFilter() {
        if (this.mOriginDataFilter == null) {
            this.mOriginDataFilter = new OriginDataEntryFilter(this.mFilterContext);
            this.mFilterContext.getGlManager().registerFilter(this.mOriginDataFilter);
            this.mOriginDataFilter.addDownStream(this.mCliperFilter.addDownStream(this.mEncoderGroupFilter)).addDownStream(this.mEndPointFilter);
            YMFLog.error(this, "[Encoder ]", "initOriginDataFilter success!");
            return;
        }
        YMFLog.error(this, "[Encoder ]", "initOriginDataFilter is not null");
    }

    public void setOriginFrameToEncode(byte[] bArr, int i, int i2, int i3, int i4, long j, int i5) {
        if (this.mOriginDataFilter != null) {
            this.mOriginDataFilter.setOriginFrameToEncode(bArr, i, i2, i3, i4, j < 0 ? TimeUtil.getTickCountLong() : j, i5);
        } else {
            YMFLog.error(this, "[Encoder ]", "OriginDataFilter not init!");
        }
    }

    public void setOriginTextureToEncode(int i, int i2, float[] fArr, int i3, int i4, long j, int i5, int i6) {
        if (this.mOriginDataFilter != null) {
            this.mOriginDataFilter.setOriginTextureToEncode(i, i2, fArr, i3, i4, j < 0 ? TimeUtil.getTickCountLong() : j, i5, i6);
        } else {
            YMFLog.error(this, "[Encoder ]", "OriginDataFilter not init!");
        }
    }

    public void setAbroadNetWorkStrategy(boolean z) {
        if (this.mFilterContext != null) {
            this.mFilterContext.setAbroadNetWorkStrategy(z);
        }
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void onPeripheralsVideoDataReceived(DecodeVideoSample decodeVideoSample) {
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void onPeripheralsVideoConfigReceived(DecodeVideoConfig decodeVideoConfig) {
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void onPeripheralsVideoEnd() {
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setVideoRenderPosition(VideoRenderPosition videoRenderPosition) {
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void onExternalVideoEnd() {
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void pushExternalVideoDecodeInfo(ExternalDecodeInfo externalDecodeInfo) {
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setExternalVideoInterface(ExternalInterface.IExternalCameraData iExternalCameraData) {
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void setExternalDecodeInterface(ExternalInterface.IExternalDecode iExternalDecode) {
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void takeScreenShot(ScreenShotCallback screenShotCallback) {
    }

    @Override // com.yy.mediaframework.IMediaCodecUpload
    public void pushEncodeExternalData(ExternalYYMediaSample externalYYMediaSample) {
    }

    public void setEnableUnderflowStrategy(boolean z) {
        YMFLog.error(this, "[Encoder ]", "setEnableUnderflowStrategy:" + z);
        if (this.mFilterContext != null) {
            this.mFilterContext.setEnableUnderflowStrategy(z);
        }
    }
}
