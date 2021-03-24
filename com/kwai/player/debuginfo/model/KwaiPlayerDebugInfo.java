package com.kwai.player.debuginfo.model;
/* loaded from: classes6.dex */
public class KwaiPlayerDebugInfo {
    public AppLiveQosDebugInfo mAppLiveQosDebugInfo;
    public AppLiveQosDebugInfoNew mAppLiveQosDebugInfoNew;
    public AppVodQosDebugInfoNew mAppVodQosDebugInfo;
    public boolean mIsLive = false;
    public PlayerConfigDebugInfo mPlayerApplyConfig = new PlayerConfigDebugInfo();
    public String mSdkVersion;

    public boolean isLive() {
        return this.mIsLive;
    }

    public void setIsLive(boolean z) {
        this.mIsLive = z;
    }
}
