package com.qq.e.comm.pi;

import com.qq.e.comm.constants.LoadAdParams;
import java.util.List;
/* loaded from: classes7.dex */
public interface NUADI extends ADI {
    String getAdNetWorkName();

    void loadData(int i2);

    void loadData(int i2, LoadAdParams loadAdParams);

    void setCategories(List<String> list);

    void setMaxVideoDuration(int i2);

    void setMinVideoDuration(int i2);

    void setVastClassName(String str);

    @Deprecated
    void setVideoADContainerRender(int i2);

    @Deprecated
    void setVideoPlayPolicy(int i2);
}
