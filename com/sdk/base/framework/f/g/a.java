package com.sdk.base.framework.f.g;

import android.net.Uri;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.b;
import com.sdk.base.framework.c.d;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static b f13142a;

    static {
        a.class.getSimpleName();
    }

    public static String a(int i) {
        JSONObject jSONObject = null;
        switch (i) {
            case 101005:
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("clientTimeOut", f13142a.b());
                jSONObject2.put("type", 1);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", 2);
                jSONObject3.put("time", 3);
                jSONObject2.put("fieldType", jSONObject3);
                JSONArray jSONArray = new JSONArray();
                for (d dVar : f13142a.c().b()) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("url", dVar.a());
                    jSONObject4.put("time", dVar.b());
                    jSONArray.put(jSONObject4);
                }
                jSONObject2.put("content", jSONArray);
                jSONObject = jSONObject2;
                break;
            case CmdConfigSocket.CMD_PB_PAGE /* 302001 */:
                jSONObject = d();
                break;
            case CmdConfigSocket.CMD_SUBPB_FLOOR /* 302002 */:
                jSONObject = c();
                break;
            case 302003:
                jSONObject = new JSONObject();
                jSONObject.put("clientTimeOut", f13142a.b());
                jSONObject.put("type", 2);
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(f13142a.c().a());
                jSONObject.put("content", jSONArray2);
                break;
        }
        return jSONObject != null ? jSONObject.toString() : "";
    }

    public static void a() {
        f13142a = new b();
    }

    public static void a(String str) {
        try {
            List<String> c = f13142a.c().c();
            c.add(str);
            f13142a.c().b(c);
        } catch (Throwable th) {
        }
    }

    public static void a(String str, long j) {
        try {
            if (c.b(str).booleanValue() && c.a(f13142a.a()).booleanValue()) {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("sequenceNumber");
                String queryParameter2 = parse.getQueryParameter("ret_url");
                if (c.b(queryParameter2).booleanValue()) {
                    queryParameter = Uri.parse(com.sdk.base.framework.f.j.d.a(queryParameter2)).getQueryParameter("seq");
                }
                f13142a.a(queryParameter);
            }
            List<d> b2 = f13142a.c().b();
            d dVar = new d();
            dVar.a(str);
            dVar.a(j);
            b2.add(dVar);
            f13142a.c().a(b2);
        } catch (Throwable th) {
        }
    }

    public static b b() {
        if (f13142a == null) {
            a();
        }
        return f13142a;
    }

    public static void b(String str) {
        try {
            List<String> d = f13142a.c().d();
            d.add(str);
            f13142a.c().c(d);
        } catch (Throwable th) {
        }
    }

    private static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("clientTimeOut", f13142a.b());
        jSONObject.put("type", 2);
        JSONArray jSONArray = new JSONArray();
        for (String str : f13142a.c().d()) {
            jSONArray.put(str);
        }
        jSONObject.put("content", jSONArray);
        return jSONObject;
    }

    public static void c(String str) {
        try {
            f13142a.c().a(str);
        } catch (Throwable th) {
        }
    }

    private static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("clientTimeOut", f13142a.b());
        jSONObject.put("type", 2);
        JSONArray jSONArray = new JSONArray();
        for (String str : f13142a.c().c()) {
            jSONArray.put(str);
        }
        jSONObject.put("content", jSONArray);
        return jSONObject;
    }
}
