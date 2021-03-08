package com.pgl.sys.a;

import android.content.Context;
import android.util.Base64;
import com.pgl.a.b.d;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    static boolean b;
    private static long e = 0;

    /* renamed from: a  reason: collision with root package name */
    static int f7475a = 504;
    static String c = "";
    static String d = "";
    private static Context f = null;

    public static String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("os", "Android");
            jSONObject.put("version", "1.0.5");
            if (d == null || d.length() <= 0) {
                jSONObject.put("token_id", com.pgl.sys.ces.a.meta(303, f, null));
            } else {
                jSONObject.put("token_id", d);
            }
            jSONObject.put("code", f7475a);
            return Base64.encodeToString(jSONObject.toString().getBytes(), 2);
        } catch (Throwable th) {
            d.a("Call onEvent Error");
            return "";
        }
    }

    public static void a(Context context, String str, com.pgl.sys.a.a.a aVar) {
        if (f == null) {
            f = context;
        }
        if (f7475a == 102 || f7475a == 202 || f7475a == 200) {
            return;
        }
        e = System.currentTimeMillis();
        b = false;
        c = str;
        f7475a = 102;
        Thread thread = new Thread(new b(context, aVar));
        thread.setName("CZL-3");
        thread.start();
    }
}
