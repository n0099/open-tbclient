package com.sdk.base.framework.f.f;

import android.net.Uri;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.b;
import com.sdk.base.framework.c.d;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static b f38837a;

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a7 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(int i) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        if (i != 101005) {
            switch (i) {
                case 302001:
                    jSONObject = d();
                    break;
                case 302002:
                    jSONObject = c();
                    break;
                case 302003:
                    jSONObject = new JSONObject();
                    jSONObject.put("clientTimeOut", f38837a.b());
                    jSONObject.put("type", 2);
                    jSONArray = new JSONArray();
                    jSONArray.put(f38837a.c().a());
                    break;
                default:
                    jSONObject = null;
                    break;
            }
            return jSONObject == null ? jSONObject.toString() : "";
        }
        jSONObject = new JSONObject();
        jSONObject.put("clientTimeOut", f38837a.b());
        jSONObject.put("type", 1);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("url", 2);
        jSONObject2.put("time", 3);
        jSONObject.put("fieldType", jSONObject2);
        jSONArray = new JSONArray();
        for (d dVar : f38837a.c().b()) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("url", dVar.a());
            jSONObject3.put("time", dVar.b());
            jSONArray.put(jSONObject3);
        }
        jSONObject.put("content", jSONArray);
        if (jSONObject == null) {
        }
    }

    public static void a() {
        f38837a = new b();
    }

    public static void a(String str) {
        try {
            List<String> c2 = f38837a.c().c();
            c2.add(str);
            f38837a.c().b(c2);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, long j) {
        try {
            if (c.b(str).booleanValue() && c.a(f38837a.a()).booleanValue()) {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("sequenceNumber");
                String queryParameter2 = parse.getQueryParameter("ret_url");
                if (c.b(queryParameter2).booleanValue()) {
                    queryParameter = Uri.parse(com.sdk.base.framework.f.i.d.a(queryParameter2)).getQueryParameter(IAdRequestParam.SEQ);
                }
                f38837a.a(queryParameter);
            }
            List<d> b2 = f38837a.c().b();
            d dVar = new d();
            dVar.a(str);
            dVar.a(j);
            b2.add(dVar);
            f38837a.c().a(b2);
        } catch (Throwable unused) {
        }
    }

    public static b b() {
        if (f38837a == null) {
            a();
        }
        return f38837a;
    }

    public static void b(String str) {
        try {
            List<String> d2 = f38837a.c().d();
            d2.add(str);
            f38837a.c().c(d2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("clientTimeOut", f38837a.b());
        jSONObject.put("type", 2);
        JSONArray jSONArray = new JSONArray();
        for (String str : f38837a.c().d()) {
            jSONArray.put(str);
        }
        jSONObject.put("content", jSONArray);
        return jSONObject;
    }

    public static void c(String str) {
        try {
            f38837a.c().a(str);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("clientTimeOut", f38837a.b());
        jSONObject.put("type", 2);
        JSONArray jSONArray = new JSONArray();
        for (String str : f38837a.c().c()) {
            jSONArray.put(str);
        }
        jSONObject.put("content", jSONArray);
        return jSONObject;
    }
}
