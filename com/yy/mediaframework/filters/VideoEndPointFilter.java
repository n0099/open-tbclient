package com.yy.mediaframework.filters;

import com.yy.mediaframework.model.YYMediaSample;
/* loaded from: classes4.dex */
public class VideoEndPointFilter extends AbstractYYMediaFilter {
    public VideoLiveFilterContext mFilterContext;

    public VideoEndPointFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = videoLiveFilterContext;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        return false;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
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
    }
}
