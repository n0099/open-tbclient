package com.yy.mediaframework.filters;

import com.yy.mediaframework.model.YYMediaSample;
/* loaded from: classes6.dex */
public class YMFEmptyFilter extends AbstractYYMediaFilter {
    private VideoLiveFilterContext mFilterContext;

    public YMFEmptyFilter(VideoLiveFilterContext videoLiveFilterContext) {
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        deliverToDownStream(yYMediaSample);
        return false;
    }
}
