package com.kwad.sdk.core.webview.b.c;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.utils.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    public static final Map<String, JSONObject> aDv = new HashMap();
    public static boolean aDw = true;

    /* loaded from: classes10.dex */
    public static class a {
        public String msg;
    }

    public static void a(com.kwad.sdk.h.a.b bVar, int i) {
        com.kwad.sdk.commercial.a.a(ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(bVar.aGS).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(i).setPackageUrl(bVar.packageUrl).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Hl())));
    }

    public static void a(com.kwad.sdk.h.a.b bVar, int i, int i2, String str) {
        com.kwad.sdk.commercial.a.a(ILoggerReporter.Category.ERROR_LOG, new HybridLoadMsg().setSceneId(bVar.aGS).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(0).setPackageUrl(bVar.packageUrl).setFailState(i2).setInterval(String.valueOf(System.currentTimeMillis() - bVar.Hl())).setFailReason(str));
    }

    public static void a(String str, String str2, int i, String str3) {
        long currentTimeMillis;
        String str4;
        String str5;
        JSONObject jSONObject = aDv.get(str2);
        if (jSONObject == null) {
            currentTimeMillis = -3;
        } else {
            long optLong = jSONObject.optLong("c_loadUrl");
            if (optLong <= 0) {
                currentTimeMillis = -2;
            } else {
                currentTimeMillis = System.currentTimeMillis() - optLong;
                if (currentTimeMillis > 100000 || currentTimeMillis < 0) {
                    currentTimeMillis = -1;
                }
            }
        }
        if (i == 2) {
            str4 = ILoggerReporter.Category.ERROR_LOG;
        } else {
            str4 = ILoggerReporter.Category.APM_LOG;
        }
        if (jSONObject != null) {
            str5 = jSONObject.toString();
        } else {
            str5 = "";
        }
        com.kwad.sdk.commercial.a.a(str4, new WebViewLoadMsg().setUrl(str).setState(i).setCostTime(str5).setInterval(String.valueOf(currentTimeMillis)).setFailReason(str3));
        ez(str2);
    }

    public static void a(String str, String str2, int i, String str3, long j) {
        String str4;
        if (i == 2) {
            str4 = ILoggerReporter.Category.ERROR_LOG;
        } else {
            str4 = ILoggerReporter.Category.APM_LOG;
        }
        com.kwad.sdk.commercial.a.b(str4, new HybridLoadMsg().setSceneId(str2).setUrl(str).setState(i).setInterval(String.valueOf((j > 60000 || j < 0) ? -1L : -1L)).setFailReason(str3));
    }

    public static void a(String str, String str2, String str3, String str4) {
        JSONObject ey = ey(str2);
        t.putValue(ey, "c_" + str3, System.currentTimeMillis());
        if (str3.equals("pageStatus")) {
            try {
                if (!TextUtils.isEmpty(str4)) {
                    JSONObject jSONObject = new JSONObject(str4);
                    int optInt = jSONObject.optInt("status");
                    String optString = jSONObject.optString("errorMsg", "");
                    String optString2 = jSONObject.optString("webViewCostParams", "");
                    if (!TextUtils.isEmpty(optString2)) {
                        JSONObject jSONObject2 = new JSONObject(optString2);
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            ey.put(next, jSONObject2.opt(next));
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (optInt == 1) {
                            ad(str, str2);
                        } else {
                            ae(str, optString);
                        }
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.e.c.printStackTrace(e);
            } finally {
                ez(str2);
            }
        }
    }

    public static void ac(String str, String str2) {
        JSONObject ey = ey(str);
        t.putValue(ey, "c_" + str2, System.currentTimeMillis());
    }

    public static void ad(String str, String str2) {
        a(str, str2, 1, "");
    }

    public static void ae(String str, String str2) {
        a(str, "", 2, str2);
    }

    public static void c(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        JSONObject ey = ey(str);
        t.putValue(ey, "c_responseStart_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    public static void d(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        JSONObject ey = ey(str);
        t.putValue(ey, "c_responseEnd_" + str2 + "_" + str3, System.currentTimeMillis());
    }

    public static void eA(String str) {
        long currentTimeMillis;
        int i;
        JSONObject ey = ey(str);
        long FN = com.kwad.sdk.core.webview.b.a.FM().FN();
        if (FN <= 0) {
            currentTimeMillis = -1;
        } else {
            currentTimeMillis = System.currentTimeMillis() - FN;
        }
        t.putValue(ey, "c_loadUrl", System.currentTimeMillis());
        t.putValue(ey, "c_init_interval", currentTimeMillis);
        if (aDw) {
            i = 1;
        } else {
            i = 2;
        }
        t.putValue(ey, "c_init_state", i);
        aDw = false;
    }

    public static JSONObject ey(String str) {
        JSONObject jSONObject = aDv.get(str);
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            aDv.put(str, jSONObject2);
            return jSONObject2;
        }
        return jSONObject;
    }

    public static void ez(String str) {
        aDv.remove(str);
    }
}
