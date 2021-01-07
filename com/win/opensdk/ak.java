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
/* loaded from: classes4.dex */
public final class ak {
    private static HashMap<String, String> qew = new HashMap<>();
    private static boolean qdm = false;

    public static String R(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8")).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8")).append(ETAG.ITEM_SEPARATOR);
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static String abO(String str) {
        try {
            return bc.abP(str);
        } catch (Exception e) {
            return str;
        }
    }

    public static HashMap<String, String> iO(Context context) {
        HashMap<String, String> hashMap;
        if (qdm) {
            hashMap = qew;
        } else {
            qew.put("app", context.getPackageName());
            qew.put("sdkna", "norm-1.1.3");
            qew.put("plat", "a");
            qew.put("model", Build.MODEL);
            qew.put("manu", Build.MANUFACTURER);
            qew.put("sysv", String.valueOf(Build.VERSION.SDK_INT));
            qew.put("h", String.valueOf(bd.iT(context)));
            qew.put("w", String.valueOf(bd.iS(context)));
            qew.put("appv", String.valueOf(bd.a(context)));
            qew.put("appvn", bd.iQ(context));
            qew.put("rt", ay.java() ? "1" : "0");
            qew.put("dpi", String.valueOf(context.getResources().getDisplayMetrics().densityDpi));
            String java = bd.java();
            if (!TextUtils.isEmpty(java)) {
                qew.put("serial", abO(java));
            }
            String d = bd.d(context);
            if (!TextUtils.isEmpty(d)) {
                qew.put("imsi", abO(d));
            }
            qdm = true;
            hashMap = qew;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        String c = bd.c(context);
        if (!TextUtils.isEmpty(c)) {
            hashMap2.put("imei", abO(c));
        }
        String m74a = bd.m74a(context);
        if (!TextUtils.isEmpty(m74a)) {
            hashMap2.put("opcode", m74a);
        }
        String iR = bd.iR(context);
        if (!TextUtils.isEmpty(iR)) {
            hashMap2.put("anid", iR);
        }
        String iR2 = at.iR(context);
        if (!TextUtils.isEmpty(iR2)) {
            hashMap2.put("oaid", abO(iR2));
        }
        hashMap2.put("lic", az.iQ(context));
        hashMap2.put("locale", Locale.getDefault().getLanguage());
        String b2 = bd.b(context);
        if (!TextUtils.isEmpty(b2)) {
            hashMap2.put("net", b2);
        }
        hashMap2.put("bt", az.m65a(context));
        String eKw = bd.eKw();
        if (!TextUtils.isEmpty(eKw)) {
            hashMap2.put("wm", abO(eKw));
        }
        double d2 = au.a.eKE().qeG;
        if (d2 > 0.0d) {
            hashMap2.put("lau", abO(String.valueOf(d2)));
            hashMap2.put("lon", abO(String.valueOf(au.a.eKE().qeH)));
        }
        try {
            String java2 = bl.java();
            if (!TextUtils.isEmpty(java2)) {
                hashMap2.put("oid", abO(java2));
            }
            String a2 = bl.a();
            if (!TextUtils.isEmpty(a2)) {
                hashMap2.put("vid", abO(a2));
            }
            String eKw2 = bl.eKw();
            if (!TextUtils.isEmpty(eKw2)) {
                hashMap2.put("aid", abO(eKw2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap2;
    }
}
