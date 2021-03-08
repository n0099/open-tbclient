package com.yy.mediaframework;

import android.content.Context;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.api.YMFEncoderStatisticInfo;
import com.yy.mediaframework.api.YMFVideoEncodeFrame;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.YMFLowStreamEncoderConfig;
import com.yy.mediaframework.base.YYUserLiveConfig;
import com.yy.mediaframework.filters.GPUPreprocessFilter;
import com.yy.mediaframework.filters.LiveSessionType;
import com.yy.mediaframework.filters.VideoEncoderGroupFilter;
import com.yy.mediaframework.filters.VideoLiveFilterContext;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import com.yy.mediaframework.inteligence.dynamictexture.IDynamicTexture;
import com.yy.mediaframework.stat.UploadStatManager;
import com.yy.mediaframework.utils.YMFLog;
import com.yy.mediaframework.watermark.WaterMark;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class AbstractLiveSession implements IEncoderListener, ILiveSession {
    public VideoEncoderGroupFilter mEncoderGroupFilter;
    public VideoLiveFilterContext mFilterContext;
    public GPUPreprocessFilter mPreprocessFilter;
    private WeakReference<IEncoderListener> mEncoderListener = new WeakReference<>(null);
    private AtomicBoolean mHardwareEncoderAvailable = new AtomicBoolean(true);
    private long mLastCountTime = 0;

    public AbstractLiveSession(Context context) {
        this.mPreprocessFilter = null;
        this.mEncoderGroupFilter = null;
        this.mFilterContext = null;
        YMFLog.info(this, "[Procedur]", "AbstractLiveSession construct begin");
        this.mFilterContext = new VideoLiveFilterContext(context, Constant.VideoStreamType.Undef);
        this.mFilterContext.setLiveMode(LiveSessionType.LIVE_MODE_SCREEN_RECORD);
        this.mFilterContext.setAndroidContext(context);
        this.mPreprocessFilter = new GPUPreprocessFilter(this.mFilterContext);
        this.mEncoderGroupFilter = new VideoEncoderGroupFilter(this.mFilterContext, this);
        this.mEncoderGroupFilter.setEncoderListener(this);
        this.mFilterContext.getGlManager().registerFilter(this.mPreprocessFilter);
        this.mFilterContext.getGlManager().registerFilter(this.mEncoderGroupFilter);
        YMFLog.info(this, "[Procedur]", "AbstractLiveSession construct done");
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void stopAndRelease() {
        YMFLog.info(this, "[Procedur]", "AbstractLiveSession stopAndRelease begin");
        this.mFilterContext.getGLManager().getHandler().removeCallbacksAndMessages(null);
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.AbstractLiveSession.1
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractLiveSession.this.mFilterContext.getScreenShot() != null) {
                    AbstractLiveSession.this.mFilterContext.getScreenShot().deInit();
                }
                if (AbstractLiveSession.this.mFilterContext.getDynamicTexture() != null) {
                    AbstractLiveSession.this.mFilterContext.getDynamicTexture().onRelease();
                    AbstractLiveSession.this.mFilterContext.setDynamicTexture(null);
                }
                if (AbstractLiveSession.this.mFilterContext.getWaterMarkTexture() != null) {
                    AbstractLiveSession.this.mFilterContext.getWaterMarkTexture().destroy();
                    AbstractLiveSession.this.mFilterContext.setWaterMarkTexture(null);
                }
                UploadStatManager.getInstance().stopStat();
                AbstractLiveSession.this.mFilterContext.getGLManager().quit();
            }
        });
        YMFLog.info(this, "[Procedur]", "AbstractLiveSession stopAndRelease done");
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void startEncoder() {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.AbstractLiveSession.2
            @Override // java.lang.Runnable
            public void run() {
                AbstractLiveSession.this.mFilterContext.getUserLiveConfig();
                if (AbstractLiveSession.this.mEncoderGroupFilter.isEnable()) {
                    YMFLog.info(this, "[Encoder ]", "encoder is started already!!");
                } else if (AbstractLiveSession.this.mEncoderGroupFilter.startEncode(AbstractLiveSession.this.mFilterContext.getVideoEncoderConfig())) {
                    UploadStatManager.getInstance().startStat();
                }
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void stopEncoder() {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.AbstractLiveSession.3
            @Override // java.lang.Runnable
            public void run() {
                UploadStatManager.getInstance().stopStat();
                if (AbstractLiveSession.this.mEncoderGroupFilter.isEnable()) {
                    AbstractLiveSession.this.mEncoderGroupFilter.stopEncode();
                }
            }
        });
    }

    public void setWaterMark(final WaterMark waterMark) {
        YMFLog.info(this, "[Beauty  ]", "setWaterMark, waterMark==null? " + (waterMark == null ? "y" : "n"));
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.AbstractLiveSession.4
            @Override // java.lang.Runnable
            public void run() {
                AbstractLiveSession.this.mFilterContext.setWaterMarkTexture(waterMark);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setDynamicTexture(final IDynamicTexture iDynamicTexture) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.AbstractLiveSession.5
            @Override // java.lang.Runnable
            public void run() {
                AbstractLiveSession.this.mFilterContext.setDynamicTexture(iDynamicTexture);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setNetworkBitrateSuggest(final int i) {
        YMFLog.info(this, "[Encoder ]", "setNetworkBitrateSuggest:" + i);
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.AbstractLiveSession.6
            @Override // java.lang.Runnable
            public void run() {
                AbstractLiveSession.this.mEncoderGroupFilter.setNetworkBitrateSuggest(i);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setResolutionModifyConfigs(List<ResolutionModifyConfig> list, int i) {
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setEncoderListener(IEncoderListener iEncoderListener) {
        YMFLog.info(this, "[Encoder ]", "setEncoderListener:" + iEncoderListener);
        this.mEncoderListener = new WeakReference<>(iEncoderListener);
        if (iEncoderListener != null) {
            iEncoderListener.onEncodeEncParam(this.mFilterContext.getEncodeParamTipsMgr().getParam());
        }
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setEncoderConfig(final VideoEncoderConfig videoEncoderConfig) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.AbstractLiveSession.7
            @Override // java.lang.Runnable
            public void run() {
                boolean z = AbstractLiveSession.this.mFilterContext.getVideoEncoderConfig().mLowDelay;
                AbstractLiveSession.this.mFilterContext.getVideoEncoderConfig().assign(videoEncoderConfig);
                AbstractLiveSession.this.mFilterContext.getVideoEncoderConfig().mLowDelay = z;
                YMFLog.info(this, "[Encoder ]", "setEncoderConfig:" + AbstractLiveSession.this.mFilterContext.getVideoEncoderConfig().toString());
                AbstractLiveSession.this.mFilterContext.getDefaultVideoEncoderConfig().assign(videoEncoderConfig);
                AbstractLiveSession.this.mPreprocessFilter.init(videoEncoderConfig.getEncodeWidth(), videoEncoderConfig.getEncodeHeight());
                AbstractLiveSession.this.mEncoderGroupFilter.init();
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setLowStreamEncoderConfigs(final List<YMFLowStreamEncoderConfig> list, final boolean z) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.AbstractLiveSession.8
            @Override // java.lang.Runnable
            public void run() {
                AbstractLiveSession.this.mFilterContext.setLowStreamEncoderConfigs(list);
                AbstractLiveSession.this.mFilterContext.enableLowStreamEncoder(z);
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void setLowDelayMode(final boolean z) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.AbstractLiveSession.9
            @Override // java.lang.Runnable
            public void run() {
                AbstractLiveSession.this.mFilterContext.getVideoEncoderConfig().mLowDelay = z;
                YMFLog.info(this, "[Encoder ]", "setLowDelayMode:" + z + " config:" + AbstractLiveSession.this.mFilterContext.getVideoEncoderConfig().toString());
            }
        });
    }

    @Override // com.yy.mediaframework.ILiveSession
    public void requestIFrame() {
        YMFLog.info(this, "[Encoder ]", "requestIFrame");
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.AbstractLiveSession.10
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractLiveSession.this.mEncoderGroupFilter != null) {
                    AbstractLiveSession.this.mEncoderGroupFilter.requestSyncFrame();
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
        YMFLog.info(this, "[Encoder ]", "encoder switch in AbstractLiveSession");
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onHardEncoderError() {
        IEncoderListener iEncoderListener = this.mEncoderListener.get();
        if (iEncoderListener != null) {
            iEncoderListener.onHardEncoderError();
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onWaterMarkSizeChange(int i, int i2) {
    }

    public void setUserLiveConfig(final YYUserLiveConfig yYUserLiveConfig) {
        this.mFilterContext.getGLManager().post(new Runnable() { // from class: com.yy.mediaframework.AbstractLiveSession.11
            @Override // java.lang.Runnable
            public void run() {
                AbstractLiveSession.this.mFilterContext.setUserLiveConfig(yYUserLiveConfig);
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
}
