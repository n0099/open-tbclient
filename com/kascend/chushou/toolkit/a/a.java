package com.kascend.chushou.toolkit.a;

import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class a {
    public static void a(Map<String, Object> map) {
    }

    @Deprecated
    public static void j(Object... objArr) {
        HashMap hashMap = new HashMap();
        if (objArr != null) {
            if (objArr.length % 2 != 0) {
                throw new IllegalArgumentException("Supplied arguments must be even");
            }
            for (int i = 0; i < objArr.length; i += 2) {
                hashMap.put(String.valueOf(objArr[i]), objArr[i + 1]);
            }
        }
        a(hashMap);
    }

    public static void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "4");
        hashMap.put("_clickPos", str);
        a(hashMap);
    }

    public static void b(Map<String, Object> map) {
    }

    public static void a(String str, String str2, String str3, String str4) {
        String str5 = null;
        if (str != null) {
            if (str.equals("SinaWeibo")) {
                str5 = "1";
            } else if (str.equals(Constants.SOURCE_QQ)) {
                str5 = "2";
            } else if (str.equals("QZone")) {
                str5 = "3";
            } else if (str.equals("Wechat")) {
                str5 = "4";
            } else if (str.equals("WechatMoments")) {
                str5 = "5";
            } else if (str.equals("IM")) {
                str5 = "6";
            }
        }
        com.kascend.chushou.c.c.dBQ().a(str5, str2, str3, str4);
    }
}
