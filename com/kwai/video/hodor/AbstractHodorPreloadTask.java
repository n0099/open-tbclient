package com.kwai.video.hodor;

import com.kwai.video.hodor.anotations.AccessedByNative;
/* loaded from: classes4.dex */
public abstract class AbstractHodorPreloadTask extends AbstractHodorTask {
    @AccessedByNative
    private int mOnlyPreloadUnderSpeedKbps = -1;

    public void setOnlyPreloadUnderSpeedKbps(int i) {
        this.mOnlyPreloadUnderSpeedKbps = i;
    }
}
