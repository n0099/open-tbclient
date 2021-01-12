package com.pgl.sys.a;

import android.content.Context;
import android.util.Base64;
import com.pgl.a.b.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    static boolean f11390b;
    private static long e = 0;

    /* renamed from: a  reason: collision with root package name */
    static int f11389a = 504;
    static String c = "";
    static String d = "";

    public static String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("os", "Android");
            jSONObject.put("version", "1.0.5");
            if (f11390b) {
                jSONObject.put("token_id", d);
            } else {
                jSONObject.put("token_id", "");
            }
            jSONObject.put("code", f11389a);
            return Base64.encodeToString(jSONObject.toString().getBytes(), 2);
        } catch (Throwable th) {
            d.a("Call onEvent Error");
            return "";
        }
    }

    public static void a(Context context, String str, com.pgl.sys.a.a.a aVar) {
        if (f11389a == 102 || f11389a == 202 || f11389a == 200) {
            return;
        }
        e = System.currentTimeMillis();
        f11390b = false;
        c = str;
        f11389a = 102;
        Thread thread = new Thread(new b(context, aVar));
        thread.setName("CZL-3");
        thread.start();
    }
}
