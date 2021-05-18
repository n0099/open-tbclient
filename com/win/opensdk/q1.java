package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.fun.openid.sdk.FunOpenIDSdk;
/* loaded from: classes7.dex */
public class q1 {

    /* renamed from: b  reason: collision with root package name */
    public static q1 f37176b;

    /* renamed from: c  reason: collision with root package name */
    public static String f37177c;

    /* renamed from: d  reason: collision with root package name */
    public static String f37178d;

    /* renamed from: e  reason: collision with root package name */
    public static String f37179e;

    /* renamed from: a  reason: collision with root package name */
    public Context f37180a;

    public q1(Context context) {
        this.f37180a = context;
    }

    public static q1 a(Context context) {
        if (f37176b == null) {
            synchronized (q1.class) {
                if (f37176b == null) {
                    f37176b = new q1(context);
                }
            }
        }
        return f37176b;
    }

    public String a() {
        return f37178d;
    }

    public String b() {
        if (TextUtils.isEmpty(f37177c)) {
            try {
                return s1.j(this.f37180a);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return f37177c;
    }

    public String c() {
        return f37179e;
    }

    public void d() {
        boolean z;
        try {
            Class.forName("com.fun.openid.sdk.FunOpenIDSdk");
            Class.forName("com.fun.openid.sdk.OnGetOaidListener");
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            try {
                FunOpenIDSdk.getOaid(this.f37180a, new p1(this));
            } catch (Exception unused2) {
            }
        }
    }
}
