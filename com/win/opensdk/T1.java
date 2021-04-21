package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.fun.openid.sdk.FunOpenIDSdk;
/* loaded from: classes7.dex */
public class T1 {

    /* renamed from: b  reason: collision with root package name */
    public static T1 f40192b;

    /* renamed from: c  reason: collision with root package name */
    public static String f40193c;

    /* renamed from: d  reason: collision with root package name */
    public static String f40194d;

    /* renamed from: e  reason: collision with root package name */
    public static String f40195e;

    /* renamed from: a  reason: collision with root package name */
    public Context f40196a;

    public T1(Context context) {
        this.f40196a = context;
    }

    public static T1 a(Context context) {
        if (f40192b == null) {
            synchronized (T1.class) {
                if (f40192b == null) {
                    f40192b = new T1(context);
                }
            }
        }
        return f40192b;
    }

    public String a() {
        return f40194d;
    }

    public String b() {
        if (TextUtils.isEmpty(f40193c)) {
            try {
                return V1.j(this.f40196a);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return f40193c;
    }

    public String c() {
        return f40195e;
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
                FunOpenIDSdk.getOaid(this.f40196a, new S1(this));
            } catch (Exception unused2) {
            }
        }
    }
}
