package com.win.opensdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import com.win.opensdk.au;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public final class ak {
    private static HashMap<String, String> qkA = new HashMap<>();
    private static boolean qjq = false;

    public static String T(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8")).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8")).append(ETAG.ITEM_SEPARATOR);
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static String abU(String str) {
        try {
            return bc.abV(str);
        } catch (Exception e) {
            return str;
        }
    }

    public static HashMap<String, String> iP(Context context) {
        HashMap<String, String> hashMap;
        if (qjq) {
            hashMap = qkA;
        } else {
            qkA.put("app", context.getPackageName());
            qkA.put("sdkna", "norm-1.1.3");
            qkA.put("plat", "a");
            qkA.put("model", Build.MODEL);
            qkA.put("manu", Build.MANUFACTURER);
            qkA.put("sysv", String.valueOf(Build.VERSION.SDK_INT));
            qkA.put("h", String.valueOf(bd.iU(context)));
            qkA.put("w", String.valueOf(bd.iT(context)));
            qkA.put("appv", String.valueOf(bd.a(context)));
            qkA.put("appvn", bd.iR(context));
            qkA.put("rt", ay.java() ? "1" : "0");
            qkA.put("dpi", String.valueOf(context.getResources().getDisplayMetrics().densityDpi));
            String java = bd.java();
            if (!TextUtils.isEmpty(java)) {
                qkA.put("serial", abU(java));
            }
            String d = bd.d(context);
            if (!TextUtils.isEmpty(d)) {
                qkA.put("imsi", abU(d));
            }
            qjq = true;
            hashMap = qkA;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        String c = bd.c(context);
        if (!TextUtils.isEmpty(c)) {
            hashMap2.put("imei", abU(c));
        }
        String m69a = bd.m69a(context);
        if (!TextUtils.isEmpty(m69a)) {
            hashMap2.put("opcode", m69a);
        }
        String iS = bd.iS(context);
        if (!TextUtils.isEmpty(iS)) {
            hashMap2.put("anid", iS);
        }
        String iS2 = at.iS(context);
        if (!TextUtils.isEmpty(iS2)) {
            hashMap2.put("oaid", abU(iS2));
        }
        hashMap2.put("lic", az.iR(context));
        hashMap2.put("locale", Locale.getDefault().getLanguage());
        String b2 = bd.b(context);
        if (!TextUtils.isEmpty(b2)) {
            hashMap2.put("net", b2);
        }
        hashMap2.put("bt", az.m60a(context));
        String eJe = bd.eJe();
        if (!TextUtils.isEmpty(eJe)) {
            hashMap2.put("wm", abU(eJe));
        }
        double d2 = au.a.eJm().qkK;
        if (d2 > 0.0d) {
            hashMap2.put("lau", abU(String.valueOf(d2)));
            hashMap2.put("lon", abU(String.valueOf(au.a.eJm().qkL)));
        }
        try {
            String java2 = bl.java();
            if (!TextUtils.isEmpty(java2)) {
                hashMap2.put("oid", abU(java2));
            }
            String a2 = bl.a();
            if (!TextUtils.isEmpty(a2)) {
                hashMap2.put("vid", abU(a2));
            }
            String eJe2 = bl.eJe();
            if (!TextUtils.isEmpty(eJe2)) {
                hashMap2.put("aid", abU(eJe2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap2;
    }
}
