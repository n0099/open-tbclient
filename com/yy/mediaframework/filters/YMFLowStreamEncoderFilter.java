package com.yy.mediaframework.filters;

import com.yy.mediaframework.IEncoderListener;
import com.yy.mediaframework.ILiveSession;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.base.YMFLowStreamEncoderConfig;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.utils.CommonUtil;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class YMFLowStreamEncoderFilter extends AbstractYYMediaFilter {
    private VideoLiveFilterContext mContext;
    private ILiveSession mSession;
    private IEncoderListener mEncoderListener = null;
    private List<X264SoftEncoderFilter> mEncoders = new LinkedList();
    private List<TransmitUploadFilter> mUploadFilters = new LinkedList();
    private List<VideoEncoderConfig> mEncoderConfigs = new LinkedList();

    public YMFLowStreamEncoderFilter(VideoLiveFilterContext videoLiveFilterContext, ILiveSession iLiveSession) {
        this.mSession = iLiveSession;
        this.mContext = videoLiveFilterContext;
    }

    public void setEncoderListener(IEncoderListener iEncoderListener) {
        this.mEncoderListener = iEncoderListener;
    }

    private VideoEncoderConfig assign(YMFLowStreamEncoderConfig yMFLowStreamEncoderConfig) {
        VideoEncoderConfig videoEncoderConfig = new VideoEncoderConfig();
        videoEncoderConfig.mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
        videoEncoderConfig.mEncodeWidth = yMFLowStreamEncoderConfig.mEncodeWidth;
        videoEncoderConfig.mEncodeHeight = yMFLowStreamEncoderConfig.mEncodeHeight;
        videoEncoderConfig.mBitRate = yMFLowStreamEncoderConfig.mCodeRate;
        videoEncoderConfig.mFrameRate = yMFLowStreamEncoderConfig.mFrameRate;
        videoEncoderConfig.mEncodeParameter = yMFLowStreamEncoderConfig.mEncodeParam;
        videoEncoderConfig.mLowDelay = this.mContext.isLowDelayMode();
        videoEncoderConfig.mMaxBitRate = yMFLowStreamEncoderConfig.mMaxCodeRate;
        return videoEncoderConfig;
    }

    public boolean startEncode() {
        if (this.mContext.isLowStreamEncoderEnable()) {
            List<YMFLowStreamEncoderConfig> lowStreamEncoderConfigs = this.mContext.getLowStreamEncoderConfigs();
            for (int i = 0; i < lowStreamEncoderConfigs.size(); i++) {
                X264SoftEncoderFilter x264SoftEncoderFilter = new X264SoftEncoderFilter(this.mContext);
                YMFLowStreamEncoderConfig yMFLowStreamEncoderConfig = lowStreamEncoderConfigs.get(i);
                VideoEncoderConfig assign = assign(yMFLowStreamEncoderConfig);
                x264SoftEncoderFilter.setStreamId(yMFLowStreamEncoderConfig.mConfigId);
                x264SoftEncoderFilter.setEncoderListener(this.mEncoderListener);
                if (!x264SoftEncoderFilter.startEncode(assign)) {
                    x264SoftEncoderFilter.stopEncode();
                    return false;
                }
                TransmitUploadFilter transmitUploadFilter = new TransmitUploadFilter(this.mContext, this.mEncoderListener);
                x264SoftEncoderFilter.addDownStream(transmitUploadFilter);
                this.mEncoders.add(x264SoftEncoderFilter);
                this.mEncoderConfigs.add(assign);
                this.mUploadFilters.add(transmitUploadFilter);
            }
            YMFLiveStatisticManager.getInstance().setVideoEncodeTypeId(1, CommonUtil.wrapperHiidoEncodeId(VideoEncoderType.SOFT_ENCODER_X264));
            YMFLiveStatisticManager.getInstance().setVideoEncodeWidth(1, lowStreamEncoderConfigs.get(0).mEncodeWidth);
            YMFLiveStatisticManager.getInstance().setVideoEncodeHeight(1, lowStreamEncoderConfigs.get(0).mEncodeHeight);
            YMFLiveStatisticManager.getInstance().setVideoDesiredEncodeBitrate(1, lowStreamEncoderConfigs.get(0).mCodeRate);
            YMFLiveStatisticManager.getInstance().setVideoEncodeDesiredFps(1, lowStreamEncoderConfigs.get(0).mFrameRate);
            return true;
        }
        return true;
    }

    public void stopEncoder() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mEncoders.size()) {
                this.mEncoders.get(i2).stopEncode();
                i = i2 + 1;
            } else {
                this.mEncoders.clear();
                this.mEncoderConfigs.clear();
                this.mUploadFilters.clear();
                return;
            }
        }
    }

    public void requestSyncFrame() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mEncoders.size()) {
                this.mEncoders.get(i2).requestSyncFrame();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        yYMediaSample.addRef();
        for (int i = 0; i < this.mEncoders.size(); i++) {
            this.mEncoders.get(i).processMediaSample(yYMediaSample, obj);
        }
        yYMediaSample.decRef();
        return false;
    }
}
