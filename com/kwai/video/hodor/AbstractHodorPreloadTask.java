package com.kwai.video.hodor;

import com.kwai.video.hodor.anotations.AccessedByNative;
/* loaded from: classes7.dex */
public abstract class AbstractHodorPreloadTask extends AbstractHodorTask {
    @AccessedByNative
    public int mOnlyPreloadUnderSpeedKbps = -1;

    public void setOnlyPreloadUnderSpeedKbps(int i2) {
        this.mOnlyPreloadUnderSpeedKbps = i2;
    }
}
