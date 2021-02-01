package com.qq.e.ads.rewardvideo2;

import com.qq.e.comm.util.AdError;
/* loaded from: classes15.dex */
public interface ExpressRewardVideoAdListener {
    void onAdLoaded();

    void onClick();

    void onClose();

    void onError(AdError adError);

    void onExpose();

    void onReward();

    void onShow();

    void onVideoCached();

    void onVideoComplete();
}
