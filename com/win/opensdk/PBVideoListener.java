package com.win.opensdk;
/* loaded from: classes6.dex */
public interface PBVideoListener extends PBListener {
    void onRewardedAdClosed();

    void onRewardedAdOpened();

    void onRewardedShowFail(String str);

    void onUserEarnedReward(boolean z, long j);
}
