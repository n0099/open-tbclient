package com.qq.e.comm.pi;

import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.constants.LoadAdParams;
/* loaded from: classes7.dex */
public interface NEADI extends ADI {
    String getAdNetWorkName();

    void loadAd(int i);

    void loadAd(int i, LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setVideoOption(VideoOption videoOption);

    void setVideoPlayPolicy(int i);
}
