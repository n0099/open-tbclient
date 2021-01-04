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
    private static HashMap<String, String> qcO = new HashMap<>();
    private static boolean qbE = false;

    public static String R(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8")).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8")).append(ETAG.ITEM_SEPARATOR);
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static String abN(String str) {
        try {
            return bc.abO(str);
        } catch (Exception e) {
            return str;
        }
    }

    public static HashMap<String, String> iO(Context context) {
        HashMap<String, String> hashMap;
        if (qbE) {
            hashMap = qcO;
        } else {
            qcO.put("app", context.getPackageName());
            qcO.put("sdkna", "norm-1.1.3");
            qcO.put("plat", "a");
            qcO.put("model", Build.MODEL);
            qcO.put("manu", Build.MANUFACTURER);
            qcO.put("sysv", String.valueOf(Build.VERSION.SDK_INT));
            qcO.put("h", String.valueOf(bd.iT(context)));
            qcO.put("w", String.valueOf(bd.iS(context)));
            qcO.put("appv", String.valueOf(bd.a(context)));
            qcO.put("appvn", bd.iQ(context));
            qcO.put("rt", ay.java() ? "1" : "0");
            qcO.put("dpi", String.valueOf(context.getResources().getDisplayMetrics().densityDpi));
            String java = bd.java();
            if (!TextUtils.isEmpty(java)) {
                qcO.put("serial", abN(java));
            }
            String d = bd.d(context);
            if (!TextUtils.isEmpty(d)) {
                qcO.put("imsi", abN(d));
            }
            qbE = true;
            hashMap = qcO;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        String c = bd.c(context);
        if (!TextUtils.isEmpty(c)) {
            hashMap2.put("imei", abN(c));
        }
        String m63a = bd.m63a(context);
        if (!TextUtils.isEmpty(m63a)) {
            hashMap2.put("opcode", m63a);
        }
        String iR = bd.iR(context);
        if (!TextUtils.isEmpty(iR)) {
            hashMap2.put("anid", iR);
        }
        String iR2 = at.iR(context);
        if (!TextUtils.isEmpty(iR2)) {
            hashMap2.put("oaid", abN(iR2));
        }
        hashMap2.put("lic", az.iQ(context));
        hashMap2.put("locale", Locale.getDefault().getLanguage());
        String b2 = bd.b(context);
        if (!TextUtils.isEmpty(b2)) {
            hashMap2.put("net", b2);
        }
        hashMap2.put("bt", az.m54a(context));
        String eJS = bd.eJS();
        if (!TextUtils.isEmpty(eJS)) {
            hashMap2.put("wm", abN(eJS));
        }
        double d2 = au.a.eKa().qcY;
        if (d2 > 0.0d) {
            hashMap2.put("lau", abN(String.valueOf(d2)));
            hashMap2.put("lon", abN(String.valueOf(au.a.eKa().qcZ)));
        }
        try {
            String java2 = bl.java();
            if (!TextUtils.isEmpty(java2)) {
                hashMap2.put("oid", abN(java2));
            }
            String a2 = bl.a();
            if (!TextUtils.isEmpty(a2)) {
                hashMap2.put("vid", abN(a2));
            }
            String eJS2 = bl.eJS();
            if (!TextUtils.isEmpty(eJS2)) {
                hashMap2.put("aid", abN(eJS2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap2;
    }
}
