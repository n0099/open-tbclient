package com.qq.e.comm.plugin.util;

import com.qq.e.comm.util.StringUtil;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static final String a(String str, int i) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        if (12 == i) {
            return "http://d.gdt.qq.com/fcg-bin/gdt_appdetail.fcg?ico=1&op_appid=" + str;
        }
        if (5 == i) {
            return "http://d.gdt.qq.com/fcg-bin/gdt_appdetail.fcg?ico=1&appid=" + str;
        }
        return null;
    }

    public static boolean a(int i) {
        return i == 19 || i == 12 || i == 5 || i == 38;
    }

    public static boolean a(com.qq.e.comm.plugin.s.a aVar) {
        if (aVar == null) {
            return false;
        }
        return a(aVar.a_());
    }

    public static boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return a(jSONObject.optInt("producttype"));
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("app_landing_page") == 1;
    }

    public static boolean c(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("producttype") == 38;
    }

    public static com.qq.e.comm.plugin.ad.j d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        com.qq.e.comm.plugin.ad.j jVar = new com.qq.e.comm.plugin.ad.j();
        JSONObject optJSONObject2 = jSONObject.optJSONObject("ext");
        if (c(jSONObject) && optJSONObject2 != null) {
            jVar.b(optJSONObject2.optString("pkg_name"));
            jVar.b(optJSONObject2.optInt("appscore", 5));
            jVar.b(optJSONObject2.optLong("appdownloadnum", 100000L));
            jVar.a(optJSONObject2.optDouble("appprice"));
            jVar.c(optJSONObject2.optString("appname"));
            jVar.d(optJSONObject2.optString("applogo"));
            jVar.a(optJSONObject2.optString("appvername"));
            jVar.a(optJSONObject2.optLong("pkgsize"));
            jVar.c(com.qq.e.comm.plugin.a.l.a().a(jVar.d()));
        } else if (a(jSONObject) && optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("alist")) != null) {
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("2022");
            if (optJSONObject3 != null) {
                jVar.b(optJSONObject3.optString("aid"));
            } else {
                jVar.b(optJSONObject.optString("packagename"));
            }
            jVar.b(optJSONObject2.optInt("appscore"));
            jVar.a(optJSONObject2.optDouble("appprice"));
            jVar.c(optJSONObject2.optString("appname"));
            jVar.a(optJSONObject2.optString("appvername"));
            jVar.a(optJSONObject2.optLong("pkgsize"));
            jVar.c(com.qq.e.comm.plugin.a.l.a().a(jVar.d()));
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("2025");
            if (optJSONObject4 != null) {
                JSONObject optJSONObject5 = optJSONObject4.optJSONObject("aid");
                if (optJSONObject5 != null) {
                    jVar.b(optJSONObject5.optLong("total"));
                    jVar.d(optJSONObject5.optString("iconurl"));
                } else {
                    jVar.b(optJSONObject2.optLong("appdownloadnum"));
                }
            } else {
                jVar.b(optJSONObject2.optLong("downloadnum"));
                jVar.d(optJSONObject2.optString("applogo"));
            }
        }
        return jVar;
    }

    public static String e(JSONObject jSONObject) {
        com.qq.e.comm.plugin.ad.j d;
        if (jSONObject == null || (d = d(jSONObject)) == null) {
            return null;
        }
        return d.d();
    }

    public static boolean f(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("app_store") == 1;
    }
}
