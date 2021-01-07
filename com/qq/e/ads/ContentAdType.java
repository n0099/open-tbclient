package com.qq.e.ads;

import com.baidu.platform.comapi.map.MapBundleKey;
/* loaded from: classes4.dex */
public enum ContentAdType {
    AD,
    INFORMATION;

    public static ContentAdType fromString(String str) {
        if (MapBundleKey.MapObjKey.OBJ_AD.equals(str)) {
            return AD;
        }
        if ("information".equals(str)) {
            return INFORMATION;
        }
        return null;
    }
}
