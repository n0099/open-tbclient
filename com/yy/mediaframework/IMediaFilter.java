package com.yy.mediaframework;

import com.yy.mediaframework.model.YYMediaSample;
/* loaded from: classes4.dex */
public interface IMediaFilter {
    public static final String TAG = IMediaFilter.class.getSimpleName();

    boolean processMediaSample(YYMediaSample yYMediaSample, Object obj);
}
