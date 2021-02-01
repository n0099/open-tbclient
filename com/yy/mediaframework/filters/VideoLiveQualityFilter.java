package com.yy.mediaframework.filters;

import android.os.Build;
import com.yy.mediaframework.ILiveSession;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter;
import com.yy.mediaframework.inteligence.coderate.DefaultCodeRateByFrame;
import com.yy.mediaframework.inteligence.coderate.ICodeRateByFrame;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import com.yy.mediaframework.inteligence.common.ResolutionModifyNotFoundException;
import com.yy.mediaframework.inteligence.framerate.AdjustFrameRateModify;
import com.yy.mediaframework.inteligence.framerate.CaptureSyncEncodeFrameRateModify;
import com.yy.mediaframework.inteligence.framerate.IFrameRateModify;
import com.yy.mediaframework.inteligence.resolution.DefaultResolutionModify;
import com.yy.mediaframework.inteligence.resolution.IResolutionModify;
import com.yy.mediaframework.inteligence.resolution.ResolutionModifyListener;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.utils.YMFLog;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoLiveQualityFilter extends AbstractVideoLiveQualityFilter {
    protected static final int mCodeRateNotifyInterval = 3000;
    VideoLiveFilterContext mFilterContext;
    protected ILiveSession mLiveSession;
    protected int mSuggestCodeRate;
    protected ICodeRateByFrame mCodeRateByFrame = null;
    protected IFrameRateModify mFrameRateModify = null;
    protected List<ResolutionModifyConfig> mResolutionModifyConfigs = null;
    protected int mResolutionModifyInterval = 0;
    protected IResolutionModify mResolutionModify = null;
    protected boolean mHasAdaptor = false;
    protected AbstractVideoLiveQualityFilter.IWeakerNetworkCallback mCallBack = null;
    protected boolean mUsedNewStrategy = true;
    protected ResolutionModifyListener mResolutionModifyListener = new ResolutionModifyListener() { // from class: com.yy.mediaframework.filters.VideoLiveQualityFilter.1
        public void onReceiveSuggestResolution2(int i, int i2, int i3, String str, VideoEncoderType videoEncoderType, int i4) {
            VideoEncoderConfig videoEncoderConfig = new VideoEncoderConfig(i, i2, i3, i4, videoEncoderType, str);
            YMFLog.info(this, "[Encoder ]", "onReceiveSuggestResolution2:%dx%d -> %dx%d, frameRate:%d -> %d, suggest codeRate:%d, current codeRate:%d, VideoEncoderType:%s -> %s", Integer.valueOf(videoEncoderConfig.getEncodeWidth()), Integer.valueOf(videoEncoderConfig.getEncodeHeight()), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(videoEncoderConfig.mFrameRate), Integer.valueOf(i3), Integer.valueOf(VideoLiveQualityFilter.this.mSuggestCodeRate), Integer.valueOf(i4), VideoLiveQualityFilter.this.mFilterContext.mVideoEncoderConfig.mEncodeType, videoEncoderType);
            YMFLog.info(this, "[Encoder ]", "onReceiveSuggestResolution2 encode param:" + videoEncoderConfig.mEncodeParameter + " -> " + str);
            if (VideoLiveQualityFilter.this.mCallBack != null) {
                VideoLiveQualityFilter.this.mCallBack.onReCreateEncoder(videoEncoderConfig);
                VideoLiveQualityFilter.this.mCallBack.notifyInitEncoderParams(0, 0);
            }
        }

        @Override // com.yy.mediaframework.inteligence.resolution.ResolutionModifyListener
        public void onReceiveSuggestResolution(int i, int i2, int i3, String str, VideoEncoderType videoEncoderType, int i4) {
            if (VideoLiveQualityFilter.this.mUsedNewStrategy) {
                onReceiveSuggestResolution2(i, i2, i3, str, videoEncoderType, i4);
                return;
            }
            VideoEncoderConfig videoEncoderConfig = VideoLiveQualityFilter.this.mFilterContext.getVideoEncoderConfig();
            YMFLog.info(this, "[Encoder ]", "onReceiveSuggestResolution:%dx%d -> %dx%d, frameRate:%d -> %d, suggest codeRate:%d, current codeRate:%d, VideoEncoderType:%s -> %s", Integer.valueOf(videoEncoderConfig.getEncodeWidth()), Integer.valueOf(videoEncoderConfig.getEncodeHeight()), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(videoEncoderConfig.mFrameRate), Integer.valueOf(i3), Integer.valueOf(VideoLiveQualityFilter.this.mSuggestCodeRate), Integer.valueOf(i4), VideoLiveQualityFilter.this.mFilterContext.mVideoEncoderConfig.mEncodeType, videoEncoderType);
            YMFLog.info(this, "[Encoder ]", "onReceiveSuggestResolution encode param:" + videoEncoderConfig.mEncodeParameter + " -> " + str);
            if (i != videoEncoderConfig.getEncodeWidth() || i2 != videoEncoderConfig.getEncodeHeight() || !str.equals(videoEncoderConfig.mEncodeParameter) || videoEncoderType != videoEncoderConfig.mEncodeType) {
                if (str == null || str.isEmpty()) {
                    str = VideoLiveQualityFilter.this.mFilterContext.getDefaultVideoEncoderConfig().mEncodeParameter;
                }
                videoEncoderConfig.setEncodeParam(str);
                if (i > 0 && i2 > 0) {
                    videoEncoderConfig.setEncodeSize(i, i2);
                    VideoLiveQualityFilter.this.mFilterContext.mVideoEncoderConfig.setEncodeSize(i, i2);
                }
                if (i3 > 0) {
                    videoEncoderConfig.setFrameRate(i3);
                    VideoLiveQualityFilter.this.mFilterContext.mVideoEncoderConfig.setFrameRate(i3);
                }
                videoEncoderConfig.setBitRate(i4);
                VideoLiveQualityFilter.this.mFilterContext.mVideoEncoderConfig.setBitRate(i4);
                try {
                    if (VideoLiveQualityFilter.this.mCodeRateByFrame != null) {
                        VideoLiveQualityFilter.this.mCodeRateByFrame.init(VideoLiveQualityFilter.this.mSuggestCodeRate, videoEncoderConfig.mFrameRate, 3000, VideoLiveQualityFilter.this.mFilterContext.mGlManager.getHandler());
                    }
                    if (VideoLiveQualityFilter.this.mFrameRateModify instanceof AdjustFrameRateModify) {
                        try {
                            ((AdjustFrameRateModify) VideoLiveQualityFilter.this.mFrameRateModify).init(videoEncoderConfig.mFrameRate, i4, videoEncoderConfig.getEncodeWidth(), videoEncoderConfig.getEncodeHeight(), VideoLiveQualityFilter.this.mResolutionModifyConfigs);
                        } catch (ResolutionModifyNotFoundException e) {
                            YMFLog.error(this, "[Encoder ]", "init FrameRateModify exception:%s", e.toString());
                            VideoLiveQualityFilter.this.mFrameRateModify = null;
                        }
                    } else if (VideoLiveQualityFilter.this.mFrameRateModify instanceof CaptureSyncEncodeFrameRateModify) {
                        ((CaptureSyncEncodeFrameRateModify) VideoLiveQualityFilter.this.mFrameRateModify).reInit(videoEncoderConfig.mFrameRate, i4, videoEncoderConfig.getEncodeWidth(), videoEncoderConfig.getEncodeHeight(), VideoLiveQualityFilter.this.mResolutionModifyConfigs);
                    }
                } catch (Throwable th) {
                    YMFLog.info(this, "[Encoder ]", "onReceiveSuggestResolution exception:" + th);
                }
                if (!VideoLiveQualityFilter.this.mFilterContext.mVideoEncoderConfig.mEncodeType.equals(videoEncoderType)) {
                    YMFLog.info(this, "[Encoder ]", "encoder switch, set new encoder:%s", videoEncoderType);
                    VideoLiveQualityFilter.this.mFilterContext.mVideoEncoderConfig.mEncodeType = videoEncoderType;
                    videoEncoderConfig.setEncodeType(videoEncoderType);
                }
            }
        }
    };

    public VideoLiveQualityFilter(VideoLiveFilterContext videoLiveFilterContext, ILiveSession iLiveSession) {
        this.mFilterContext = null;
        this.mLiveSession = null;
        this.mSuggestCodeRate = 0;
        this.mFilterContext = videoLiveFilterContext;
        this.mLiveSession = iLiveSession;
        VideoEncoderConfig videoEncoderConfig = this.mFilterContext.getVideoEncoderConfig();
        if (videoEncoderConfig != null) {
            this.mSuggestCodeRate = videoEncoderConfig.mBitRate;
            this.mLastEncoderInitBitrate = 0;
            this.mLastEncoderInitFrameRate = 0;
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter
    public void setWeakNetworkCallback(AbstractVideoLiveQualityFilter.IWeakerNetworkCallback iWeakerNetworkCallback) {
        this.mCallBack = iWeakerNetworkCallback;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        if (this.mHasAdaptor && this.mFrameRateModify != null) {
            this.mFrameRateModify.onInterceptDoFrame(yYMediaSample.mAndoridPtsNanos);
        }
        deliverToDownStream(yYMediaSample);
        return super.processMediaSample(yYMediaSample, obj);
    }

    @Deprecated
    public void adjustEncoderBitrate(int i) {
        YMFLog.info(this, "[Encoder ]", "adjustEncoderBitrate suggestCodeRate:%d", Integer.valueOf(i));
        this.mSuggestCodeRate = i;
        this.mLiveSession.adjustEncoderBitrate(i);
    }

    @Override // com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter
    public boolean setNetworkBitrateSuggest(int i) {
        boolean z;
        YMFLog.info(this, "[Encoder ]", "setNetworkBitrateSuggest:" + i);
        if (this.mFrameRateModify != null) {
            this.mFrameRateModify.publishNetworkCodeRate(i);
            if (this.mLastEncoderInitBitrate == 0 || i < this.mLastEncoderInitBitrate) {
                this.mFilterContext.getVideoEncoderConfig().setBitRate(i);
            }
            z = true;
        } else {
            z = false;
        }
        if (this.mResolutionModify != null) {
            this.mResolutionModify.publishNetworkCodeRate(i);
            z = true;
        }
        VideoEncoderConfig videoEncoderConfig = this.mFilterContext.getVideoEncoderConfig();
        YMFLog.info(this, "[Encoder ]", "setNetworkBitrateSuggest:" + i + " resolution:(%d x %d)", Integer.valueOf(videoEncoderConfig.getEncodeWidth()), Integer.valueOf(videoEncoderConfig.getEncodeHeight()));
        if (this.mFrameRateModify != null) {
            this.mFrameRateModify.publishCurrentResolution(videoEncoderConfig.getEncodeWidth(), videoEncoderConfig.getEncodeHeight(), i);
        }
        this.mSuggestCodeRate = i;
        return z;
    }

    private void estimateEncoderParamsAndReboot(int i) {
        int i2;
        try {
            int findConfigIdx = ((CaptureSyncEncodeFrameRateModify) this.mFrameRateModify).mAjustFRModify.findConfigIdx(0, 0, i);
            ResolutionModifyConfig resolutionModifyConfig = this.mResolutionModifyConfigs.get(findConfigIdx);
            try {
                i2 = (int) (((resolutionModifyConfig.maxFrameRate - resolutionModifyConfig.minFrameRate) * ((float) ((i - resolutionModifyConfig.minCodeRate) / (resolutionModifyConfig.maxCodeRate - resolutionModifyConfig.minCodeRate)))) + resolutionModifyConfig.minFrameRate);
            } catch (Exception e) {
                YMFLog.error(this, "[Encoder ]", e.toString());
                i2 = 0;
            }
            int i3 = i2 >= 4 ? i2 : 4;
            if (this.mResolutionModify != null && (this.mResolutionModify instanceof DefaultResolutionModify)) {
                ((DefaultResolutionModify) this.mResolutionModify).setLastTimestampNanos();
            }
            if (this.mResolutionModifyListener != null && resolutionModifyConfig != null) {
                YMFLog.info(this, "[Encoder ]", "%d  %d  %d restart Encoder", Integer.valueOf(findConfigIdx), Integer.valueOf(i3), Integer.valueOf(i));
                this.mResolutionModifyListener.onReceiveSuggestResolution(resolutionModifyConfig.width, resolutionModifyConfig.height, i3, resolutionModifyConfig.encoderParams, resolutionModifyConfig.videoEncoderType, i);
                this.mCallBack.notifyInitEncoderParams(i3, i);
            }
        } catch (Exception e2) {
            YMFLog.error(this, "[Encoder ]", " estimateRebootEncoder findConfigIdx error");
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter
    public void estimateRebootEncoder(int i, int i2) {
        long nanoTime = System.nanoTime();
        long lastTimestampNanos = this.mResolutionModify == null ? nanoTime : ((DefaultResolutionModify) this.mResolutionModify).getLastTimestampNanos();
        if (lastTimestampNanos == 0) {
            lastTimestampNanos = nanoTime;
        }
        int lastFrameRate = (int) getLastFrameRate();
        if (i < this.mSuggestCodeRate / 2 && nanoTime - lastTimestampNanos >= 1.2E9d && i2 > lastFrameRate - 3 && this.mFilterContext.mEnableUnderflowStrategy) {
            YMFLog.info(this, "[Encoder ]", "%d < %d / 2 in %d, underflow force reboot encoder", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.mSuggestCodeRate));
            if (this.mFrameRateModify != null && (this.mFrameRateModify instanceof CaptureSyncEncodeFrameRateModify)) {
                estimateEncoderParamsAndReboot(this.mSuggestCodeRate);
            }
        } else if (i > this.mLastEncoderInitBitrate * 1.2d && i2 > this.mLastEncoderInitFrameRate && this.mLastEncoderInitBitrate != 0 && this.mLastEncoderInitFrameRate != 0 && nanoTime - lastTimestampNanos >= 1.2E9d && i2 >= 4) {
            YMFLog.info(this, "[Encoder ]", "%d __ %d > %d ,%d > %d ,overflow so force reboot encoder", Integer.valueOf(this.mSuggestCodeRate), Integer.valueOf(i), Integer.valueOf(this.mLastEncoderInitBitrate), Integer.valueOf(i2), Integer.valueOf(this.mLastEncoderInitFrameRate));
            estimateEncoderParamsAndReboot(this.mSuggestCodeRate);
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        this.mHasAdaptor = false;
        if (this.mCodeRateByFrame != null) {
            this.mCodeRateByFrame.release();
            this.mCodeRateByFrame = null;
        }
        if (this.mFrameRateModify != null) {
            this.mFrameRateModify.release();
            this.mFrameRateModify = null;
        }
        if (this.mResolutionModify != null) {
            this.mResolutionModify.release();
            this.mResolutionModify = null;
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter
    public boolean hasAdapator() {
        return this.mHasAdaptor;
    }

    @Override // com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter
    @Deprecated
    public void setEncodeStats(int i, int i2) {
        if (this.mCodeRateByFrame != null) {
            this.mCodeRateByFrame.publishCurrentFrameRate(i2, i);
            int suggestCodeRate = this.mCodeRateByFrame.getSuggestCodeRate();
            adjustEncoderBitrate(suggestCodeRate);
            YMFLog.info(this, "[Encoder ]", "Send SuggestCodeRate:" + suggestCodeRate);
            return;
        }
        adjustEncoderBitrate(this.mSuggestCodeRate);
        YMFLog.info(this, "[Encoder ]", "Send SuggestCodeRate:" + this.mSuggestCodeRate);
    }

    @Override // com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter
    public void installAdaptor() {
        if (!this.mHasAdaptor) {
            VideoEncoderConfig videoEncoderConfig = this.mFilterContext.getVideoEncoderConfig();
            if (Build.VERSION.SDK_INT >= 19) {
                this.mCodeRateByFrame = new DefaultCodeRateByFrame();
                this.mCodeRateByFrame.init(videoEncoderConfig.mBitRate, videoEncoderConfig.mFrameRate, 3000, this.mFilterContext.mGlManager.getHandler());
            }
            if (this.mResolutionModifyConfigs != null && this.mResolutionModifyConfigs.size() > 0) {
                this.mFrameRateModify = new AdjustFrameRateModify();
                try {
                    ((AdjustFrameRateModify) this.mFrameRateModify).init(videoEncoderConfig.mFrameRate, videoEncoderConfig.mBitRate, videoEncoderConfig.getEncodeWidth(), videoEncoderConfig.getEncodeHeight(), this.mResolutionModifyConfigs);
                } catch (ResolutionModifyNotFoundException e) {
                    YMFLog.error(this, "[Encoder ]", "init FrameRateModify exception:%s", e.toString());
                    this.mFrameRateModify = null;
                }
                try {
                    this.mResolutionModify = new DefaultResolutionModify();
                    ((DefaultResolutionModify) this.mResolutionModify).init(videoEncoderConfig.mFrameRate, videoEncoderConfig.mBitRate, videoEncoderConfig.getEncodeWidth(), videoEncoderConfig.getEncodeHeight(), this.mResolutionModifyInterval, this.mResolutionModifyConfigs, this.mResolutionModifyListener);
                } catch (ResolutionModifyNotFoundException e2) {
                    YMFLog.error(this, "[Encoder ]", "init ResolutinModify exception:%s", e2.toString());
                    this.mResolutionModify = null;
                }
            }
            this.mHasAdaptor = true;
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter
    public void setResolutionModifyConfigs(List<ResolutionModifyConfig> list, int i) {
        YMFLog.info(this, "[Encoder ]", "setResolutionModifyConfigs, config.size:" + (list == null ? 0 : list.size()) + " intervalSecs:" + i);
        if (list == null) {
            YMFLog.error(this, "[Encoder ]", "setResolutionModifyConfigs config == null");
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            YMFLog.info(this, "[Encoder ]", "setResolutionModifyConfigs, config.part" + i2 + ":" + list.get(i2).toString());
        }
        this.mResolutionModifyConfigs = list;
        this.mResolutionModifyInterval = i;
    }

    @Override // com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter
    public float getLastFrameRate() {
        if (this.mFrameRateModify != null) {
            return this.mFrameRateModify.getLastFrameRate();
        }
        return 0.0f;
    }

    @Override // com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter
    public void setLastFrameRate(float f) {
        if (this.mFrameRateModify != null) {
            this.mFrameRateModify.setLastFrameRate(f);
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter
    public void setLastNetWorkBitrate(int i) {
        this.mSuggestCodeRate = i;
        if (this.mFrameRateModify != null) {
            YMFLog.info(this, "[Encoder ]", "reboot setLastNetWorkBitrate=" + i);
            this.mFrameRateModify.publishNetworkCodeRate(i);
        }
    }
}
