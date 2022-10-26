package com.qq.e.ads.rewardvideo;

import com.qq.e.comm.util.AdError;
import java.util.Map;
/* loaded from: classes8.dex */
public interface RewardVideoADListener {
    void onADClick();

    void onADClose();

    void onADExpose();

    void onADLoad();

    void onADShow();

    void onError(AdError adError);

    void onReward(Map map);

    void onVideoCached();

    void onVideoComplete();
}
