package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f13309a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f13310b = "";

    public static a a(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar == null || context == null || jSONObject == null) {
            return null;
        }
        String k = cVar.k();
        if (TextUtils.isEmpty(k) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(k);
        f13309a = com.ss.android.socialbase.downloader.b.e.f13373b + "1";
        f13310b = com.ss.android.socialbase.downloader.b.e.f13373b + "2";
        if (str.equals("vivo1")) {
            return new h(context, cVar.n());
        }
        if (str.equals("vivo2")) {
            return new i(context, file.getAbsolutePath());
        }
        if (str.equals(f13309a)) {
            return new f(context, file.getAbsolutePath());
        }
        if (str.equals(f13310b)) {
            return new g(context, file.getAbsolutePath());
        }
        if (str.equals("custom")) {
            return new c(context, file.getAbsolutePath(), jSONObject);
        }
        return null;
    }

    public static boolean a(Context context, String str, JSONObject jSONObject) {
        if (context == null || str == null) {
            return false;
        }
        a aVar = null;
        String b2 = com.ss.android.socialbase.appdownloader.c.b();
        if (TextUtils.isEmpty(b2) || TextUtils.isEmpty(str)) {
            return false;
        }
        f13309a = com.ss.android.socialbase.downloader.b.e.f13373b + "1";
        f13310b = com.ss.android.socialbase.downloader.b.e.f13373b + "2";
        if (str.equals("vivo1")) {
            aVar = new h(context, b2);
        } else if (str.equals("vivo2")) {
            aVar = new i(context, b2);
        } else if (str.equals(f13309a)) {
            aVar = new f(context, b2);
        } else if (str.equals(f13310b)) {
            aVar = new g(context, b2);
        } else if (str.equals("custom")) {
            aVar = new c(context, b2, jSONObject);
        }
        return aVar != null && aVar.a();
    }
}
