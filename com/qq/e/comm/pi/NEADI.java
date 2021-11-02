package com.qq.e.comm.pi;

import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.constants.LoadAdParams;
/* loaded from: classes2.dex */
public interface NEADI extends ADI {
    String getAdNetWorkName();

    void loadAd(int i2);

    void loadAd(int i2, LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i2);

    void setMinVideoDuration(int i2);

    void setVideoOption(VideoOption videoOption);

    void setVideoPlayPolicy(int i2);
}
