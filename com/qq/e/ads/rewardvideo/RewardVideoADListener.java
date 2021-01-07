package com.qq.e.ads.rewardvideo;

import com.qq.e.comm.util.AdError;
/* loaded from: classes4.dex */
public interface RewardVideoADListener {
    void onADClick();

    void onADClose();

    void onADExpose();

    void onADLoad();

    void onADShow();

    void onError(AdError adError);

    void onReward();

    void onVideoCached();

    void onVideoComplete();
}
