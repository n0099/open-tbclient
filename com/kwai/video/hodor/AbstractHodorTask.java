package com.kwai.video.hodor;

import androidx.annotation.Keep;
import com.kwai.video.cache.AwesomeCacheInitConfig;
import com.kwai.video.hodor.anotations.AccessedByNative;
@Keep
/* loaded from: classes5.dex */
public abstract class AbstractHodorTask implements IHodorTask {
    @AccessedByNative
    private int mTaskQosClass = 0;
    @AccessedByNative
    private int mPriority = 3000;
    @AccessedByNative
    private int mConnectTimeoutMs = 3000;
    @AccessedByNative
    private int mMaxSpeedKbps = -1;
    @AccessedByNative
    protected String mBizType = "unknown";
    @AccessedByNative
    protected String mGroupName = "";

    static {
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setBizType(String str) {
        this.mBizType = str;
    }

    public void setConnectTimeoutMs(int i) {
        this.mConnectTimeoutMs = i;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setGroupName(String str) {
        this.mGroupName = str;
    }

    public void setMaxSpeedKbps(int i) {
        this.mMaxSpeedKbps = i;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setPriority(int i) {
        this.mPriority = i;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setTaskQosClass(int i) {
        this.mTaskQosClass = i;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void submit(boolean z) {
        submit();
    }
}
