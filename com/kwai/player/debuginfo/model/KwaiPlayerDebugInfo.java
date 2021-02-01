package com.kwai.player.debuginfo.model;
/* loaded from: classes3.dex */
public class KwaiPlayerDebugInfo {
    public AppLiveQosDebugInfo mAppLiveQosDebugInfo;
    public AppLiveQosDebugInfoNew mAppLiveQosDebugInfoNew;
    public AppVodQosDebugInfoNew mAppVodQosDebugInfo;
    private boolean mIsLive = false;
    public PlayerConfigDebugInfo mPlayerApplyConfig = new PlayerConfigDebugInfo();
    public String mSdkVersion;

    public boolean isLive() {
        return this.mIsLive;
    }

    public void setIsLive(boolean z) {
        this.mIsLive = z;
    }
}
