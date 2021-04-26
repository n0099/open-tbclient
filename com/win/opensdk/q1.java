package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.fun.openid.sdk.FunOpenIDSdk;
/* loaded from: classes6.dex */
public class q1 {

    /* renamed from: b  reason: collision with root package name */
    public static q1 f37931b;

    /* renamed from: c  reason: collision with root package name */
    public static String f37932c;

    /* renamed from: d  reason: collision with root package name */
    public static String f37933d;

    /* renamed from: e  reason: collision with root package name */
    public static String f37934e;

    /* renamed from: a  reason: collision with root package name */
    public Context f37935a;

    public q1(Context context) {
        this.f37935a = context;
    }

    public static q1 a(Context context) {
        if (f37931b == null) {
            synchronized (q1.class) {
                if (f37931b == null) {
                    f37931b = new q1(context);
                }
            }
        }
        return f37931b;
    }

    public String a() {
        return f37933d;
    }

    public String b() {
        if (TextUtils.isEmpty(f37932c)) {
            try {
                return s1.j(this.f37935a);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return f37932c;
    }

    public String c() {
        return f37934e;
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
                FunOpenIDSdk.getOaid(this.f37935a, new p1(this));
            } catch (Exception unused2) {
            }
        }
    }
}
