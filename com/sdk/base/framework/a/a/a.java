package com.sdk.base.framework.a.a;

import android.content.Context;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.sdk.base.framework.c.f;
import com.sdk.base.module.manager.SDKManager;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38695a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f38696b = Boolean.valueOf(f.f38809b);

    public static String a(int i, String str) {
        String a2 = com.sdk.base.framework.f.d.a.a();
        if (c.b(a2).booleanValue()) {
            return "accessCode" + i + str + a2;
        }
        return null;
    }

    public static String a(Context context, int i, String str) {
        if (SDKManager.useCache()) {
            String a2 = a(i, str);
            if (c.b(a2).booleanValue()) {
                String b2 = com.sdk.base.framework.f.b.a.b(context, a2);
                if (c.b(b2).booleanValue()) {
                    String b3 = b(b2);
                    String a3 = com.sdk.base.framework.f.k.a.a(context, a(b2));
                    if (!com.sdk.base.framework.f.k.a.a(a3)) {
                        c.a(f38695a, "can use cache", f38696b);
                        JSONObject jSONObject = new JSONObject(a3);
                        if (i == 1) {
                            jSONObject.remove(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(jSONObject.toString());
                        sb.append("-");
                        sb.append(b3);
                        return sb.toString();
                    }
                    c.a(f38695a, "OutDate cache invalid", f38696b);
                }
            }
            return null;
        }
        return null;
    }

    public static <T> String a(T t, String str) {
        return t + "-" + str;
    }

    public static String a(String str) {
        return str.split("-")[0];
    }

    public static void a(Context context) {
        c.a(f38695a, "cache clear", f38696b);
        com.sdk.base.framework.f.b.a.d(context, "accessCode");
    }

    public static void a(Context context, int i, String str, String str2) {
        if (SDKManager.useCache() && c.b(str).booleanValue()) {
            String a2 = a(i, str2);
            if (c.b(a2).booleanValue()) {
                com.sdk.base.framework.f.b.a.b(context, a2, str);
            }
        }
    }

    public static String b(String str) {
        return str.split("-")[1];
    }

    public static void b(Context context) {
        c.a(f38695a, "oauth cache clear", f38696b);
        com.sdk.base.framework.f.b.a.d(context, "accessCode1");
    }
}
