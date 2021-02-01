package com.yy.mediaframework.base;
/* loaded from: classes4.dex */
public class YYUserLiveConfig {
    public long mUid = 0;
    public long mTopSid = 0;
    public long mSubSid = 0;

    public YYUserLiveConfig() {
    }

    public YYUserLiveConfig(YYUserLiveConfig yYUserLiveConfig) {
        assign(yYUserLiveConfig);
    }

    public void assign(YYUserLiveConfig yYUserLiveConfig) {
        this.mUid = yYUserLiveConfig.mUid;
        this.mTopSid = yYUserLiveConfig.mTopSid;
        this.mSubSid = yYUserLiveConfig.mSubSid;
    }
}
