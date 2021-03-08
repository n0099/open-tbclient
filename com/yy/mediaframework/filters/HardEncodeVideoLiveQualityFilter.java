package com.yy.mediaframework.filters;

import com.yy.mediaframework.ILiveSession;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.inteligence.common.ResolutionModifyNotFoundException;
import com.yy.mediaframework.inteligence.framerate.CaptureSyncEncodeFrameRateModify;
import com.yy.mediaframework.inteligence.resolution.DefaultResolutionModify;
import com.yy.mediaframework.utils.YMFLog;
/* loaded from: classes6.dex */
public class HardEncodeVideoLiveQualityFilter extends VideoLiveQualityFilter {
    public HardEncodeVideoLiveQualityFilter(VideoLiveFilterContext videoLiveFilterContext, ILiveSession iLiveSession) {
        super(videoLiveFilterContext, iLiveSession);
        YMFLog.info(this, "[Encoder ]", "HardEncodeVideoLiveQualityFilter construct");
    }

    @Override // com.yy.mediaframework.filters.VideoLiveQualityFilter, com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter
    public void installAdaptor() {
        if (this.mHasAdaptor) {
            YMFLog.info(this, "[Encoder ]", "installAdaptor, has installed");
            return;
        }
        VideoEncoderConfig videoEncoderConfig = this.mFilterContext.getVideoEncoderConfig();
        if (this.mResolutionModifyConfigs != null && this.mResolutionModifyConfigs.size() > 0) {
            this.mFrameRateModify = new CaptureSyncEncodeFrameRateModify();
            ((CaptureSyncEncodeFrameRateModify) this.mFrameRateModify).init(videoEncoderConfig.mFrameRate, videoEncoderConfig.mBitRate, videoEncoderConfig.getEncodeWidth(), videoEncoderConfig.getEncodeHeight(), this.mResolutionModifyConfigs);
            try {
                this.mResolutionModify = new DefaultResolutionModify();
                ((DefaultResolutionModify) this.mResolutionModify).init(videoEncoderConfig.mFrameRate, videoEncoderConfig.mBitRate, videoEncoderConfig.getEncodeWidth(), videoEncoderConfig.getEncodeHeight(), this.mResolutionModifyInterval, this.mResolutionModifyConfigs, this.mResolutionModifyListener);
            } catch (ResolutionModifyNotFoundException e) {
                YMFLog.error(this, "[Encoder ]", "init ResolutinModify exception:%s", e.toString());
                this.mResolutionModify = null;
            }
        }
        this.mHasAdaptor = true;
        YMFLog.info(this, "[Encoder ]", "installAdaptor, done");
    }
}
