package com.kwad.sdk.a.a;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes10.dex */
public final class d {
    public static String F(AdInfo adInfo) {
        return com.kwad.sdk.core.config.d.Bp().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", com.kwad.components.core.s.e.a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }

    public static String yZ() {
        String Bq = com.kwad.sdk.core.config.d.Bq();
        if (TextUtils.isEmpty(Bq)) {
            return "安装";
        }
        return Bq;
    }

    public static String za() {
        String Br = com.kwad.sdk.core.config.d.Br();
        if (TextUtils.isEmpty(Br)) {
            return "取消";
        }
        return Br;
    }
}
