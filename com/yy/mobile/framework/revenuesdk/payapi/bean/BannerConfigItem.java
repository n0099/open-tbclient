package com.yy.mobile.framework.revenuesdk.payapi.bean;

import androidx.annotation.Keep;
import java.util.List;
@Keep
/* loaded from: classes9.dex */
public class BannerConfigItem {
    public int autoPlayTime;
    public List<BannerInfo> bannerInfoList;
    public int type;

    @Keep
    /* loaded from: classes9.dex */
    public static class BannerInfo {
        public String id;
        public String imageUrl;
        public String jumpData;
        public int jumpType;

        public String toString() {
            return "BannerInfo{id=" + this.id + ", imageUrl=" + this.imageUrl + ", jumpType=" + this.jumpType + ", jumpData='" + this.jumpData + "'}";
        }
    }
}
