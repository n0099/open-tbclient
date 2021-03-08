package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes14.dex */
public class bl {
    public static String c;
    public static String d;
    public static String e;
    public static bl qlf;

    /* renamed from: a  reason: collision with root package name */
    public Context f8118a;

    public bl(Context context) {
        this.f8118a = context;
    }

    public static bl iN(Context context) {
        if (qlf == null) {
            synchronized (bl.class) {
                if (qlf == null) {
                    qlf = new bl(context);
                }
            }
        }
        return qlf;
    }

    public String a() {
        return d;
    }

    public String b() {
        if (TextUtils.isEmpty(c)) {
            try {
                return bp.j(this.f8118a);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return c;
    }

    public String c() {
        return e;
    }

    public void d() {
        boolean z;
        try {
            Class.forName("com.fun.openid.sdk.b");
            Class.forName("com.fun.openid.sdk.c");
            z = true;
        } catch (Exception e2) {
            z = false;
        }
        if (!z) {
            return;
        }
        try {
            com.fun.openid.sdk.b.a(this.f8118a, new bi(this));
        } catch (Exception e3) {
        }
    }
}
