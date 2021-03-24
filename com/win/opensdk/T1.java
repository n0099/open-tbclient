package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.fun.openid.sdk.FunOpenIDSdk;
/* loaded from: classes7.dex */
public class T1 {

    /* renamed from: b  reason: collision with root package name */
    public static T1 f39807b;

    /* renamed from: c  reason: collision with root package name */
    public static String f39808c;

    /* renamed from: d  reason: collision with root package name */
    public static String f39809d;

    /* renamed from: e  reason: collision with root package name */
    public static String f39810e;

    /* renamed from: a  reason: collision with root package name */
    public Context f39811a;

    public T1(Context context) {
        this.f39811a = context;
    }

    public static T1 a(Context context) {
        if (f39807b == null) {
            synchronized (T1.class) {
                if (f39807b == null) {
                    f39807b = new T1(context);
                }
            }
        }
        return f39807b;
    }

    public String a() {
        return f39809d;
    }

    public String b() {
        if (TextUtils.isEmpty(f39808c)) {
            try {
                return V1.j(this.f39811a);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return f39808c;
    }

    public String c() {
        return f39810e;
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
                FunOpenIDSdk.getOaid(this.f39811a, new S1(this));
            } catch (Exception unused2) {
            }
        }
    }
}
