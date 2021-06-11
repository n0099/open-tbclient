package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.fun.openid.sdk.FunOpenIDSdk;
/* loaded from: classes7.dex */
public class q1 {

    /* renamed from: b  reason: collision with root package name */
    public static q1 f40784b;

    /* renamed from: c  reason: collision with root package name */
    public static String f40785c;

    /* renamed from: d  reason: collision with root package name */
    public static String f40786d;

    /* renamed from: e  reason: collision with root package name */
    public static String f40787e;

    /* renamed from: a  reason: collision with root package name */
    public Context f40788a;

    public q1(Context context) {
        this.f40788a = context;
    }

    public static q1 a(Context context) {
        if (f40784b == null) {
            synchronized (q1.class) {
                if (f40784b == null) {
                    f40784b = new q1(context);
                }
            }
        }
        return f40784b;
    }

    public String a() {
        return f40786d;
    }

    public String b() {
        if (TextUtils.isEmpty(f40785c)) {
            try {
                return s1.j(this.f40788a);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return f40785c;
    }

    public String c() {
        return f40787e;
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
                FunOpenIDSdk.getOaid(this.f40788a, new p1(this));
            } catch (Exception unused2) {
            }
        }
    }
}
