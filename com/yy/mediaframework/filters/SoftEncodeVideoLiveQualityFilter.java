package com.yy.mediaframework.filters;

import com.yy.mediaframework.ILiveSession;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.inteligence.common.ResolutionModifyNotFoundException;
import com.yy.mediaframework.inteligence.framerate.AdjustFrameRateModify;
import com.yy.mediaframework.inteligence.resolution.DefaultResolutionModify;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes6.dex */
public class SoftEncodeVideoLiveQualityFilter extends VideoLiveQualityFilter {
    public SoftEncodeVideoLiveQualityFilter(VideoLiveFilterContext videoLiveFilterContext, ILiveSession iLiveSession) {
        super(videoLiveFilterContext, iLiveSession);
        YMFLog.info(this, "[Encoder ]", "SoftEncodeVideoLiveQualityFilter construct");
    }

    @Override // com.yy.mediaframework.filters.VideoLiveQualityFilter, com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter
    public void installAdaptor() {
        if (!this.mHasAdaptor) {
            VideoEncoderConfig videoEncoderConfig = this.mFilterContext.getVideoEncoderConfig();
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

    public void forceRebootEncoder(VideoEncoderConfig videoEncoderConfig) {
        videoEncoderConfig.mEncodeParameter = "";
        YMFLog.info(this, "soft forceRebootEncoder: %s", videoEncoderConfig.toString());
        this.mCallBack.onReCreateEncoder(videoEncoderConfig);
    }
}
