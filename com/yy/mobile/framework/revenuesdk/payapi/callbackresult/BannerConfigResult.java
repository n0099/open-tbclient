package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import java.util.List;
@Keep
/* loaded from: classes9.dex */
public class BannerConfigResult {
    public List<BannerConfigItem> bannerConfigItemList;

    public BannerConfigResult(List<BannerConfigItem> list) {
        this.bannerConfigItemList = list;
    }

    public void setBannerConfigItemList(List<BannerConfigItem> list) {
        this.bannerConfigItemList = list;
    }

    public List<BannerConfigItem> getBannerConfigItemList() {
        return this.bannerConfigItemList;
    }
}
