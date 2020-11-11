package com.sdk.base.framework.a.a;

import android.content.Context;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.c.f;
import com.sdk.base.module.manager.SDKManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4457a = a.class.getSimpleName();
    private static Boolean b = Boolean.valueOf(f.b);

    private static String a(Context context, int i) {
        ArrayList<KInfo> b2 = com.sdk.base.framework.c.a.b(context);
        if (b2 != null) {
            Iterator<KInfo> it = b2.iterator();
            while (it.hasNext()) {
                KInfo next = it.next();
                if (next.isIdfd()) {
                    return "accessCode" + i + next.getIs();
                }
            }
        }
        return null;
    }

    public static <T> String a(T t, String str) {
        return t + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str;
    }

    public static String a(String str) {
        return str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0];
    }

    public static void a(Context context) {
        c.a(f4457a, "cache clear", b);
        com.sdk.base.framework.f.b.a.d(context, "accessCode");
    }

    public static void a(Context context, int i, String str) {
        if (SDKManager.useCache() && c.b(str).booleanValue()) {
            String a2 = a(context, i);
            if (c.b(a2).booleanValue()) {
                com.sdk.base.framework.f.b.a.b(context, a2, str);
            }
        }
    }

    public static String b(Context context, int i, String str) {
        try {
            if (!SDKManager.useCache()) {
                c.a(f4457a, "cache close", b);
                return null;
            }
            String a2 = a(context, i);
            if (c.b(a2).booleanValue()) {
                String b2 = com.sdk.base.framework.f.b.a.b(context, a2);
                if (c.b(b2).booleanValue()) {
                    if (!com.sdk.base.framework.f.h.b.a(context, a2.substring(11)).equals(str)) {
                        c.a(f4457a, "Capacity mismatch cache invalid", b);
                        return null;
                    }
                    String b3 = b(b2);
                    String a3 = com.sdk.base.framework.f.l.a.a(context, a(b2));
                    if (com.sdk.base.framework.f.l.a.a(a3)) {
                        c.a(f4457a, "OutDate cache invalid", b);
                        return null;
                    }
                    c.a(f4457a, "can use cache", b);
                    JSONObject jSONObject = new JSONObject(a3);
                    if (i == 1) {
                        jSONObject.remove("fakeMobile");
                    }
                    return jSONObject.toString() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + b3;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static String b(String str) {
        return str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1];
    }

    public static void b(Context context) {
        c.a(f4457a, "oauth cache clear", b);
        com.sdk.base.framework.f.b.a.d(context, "accessCode1");
    }
}
