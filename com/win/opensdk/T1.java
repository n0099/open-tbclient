package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.fun.openid.sdk.FunOpenIDSdk;
/* loaded from: classes7.dex */
public class T1 {

    /* renamed from: b  reason: collision with root package name */
    public static T1 f39808b;

    /* renamed from: c  reason: collision with root package name */
    public static String f39809c;

    /* renamed from: d  reason: collision with root package name */
    public static String f39810d;

    /* renamed from: e  reason: collision with root package name */
    public static String f39811e;

    /* renamed from: a  reason: collision with root package name */
    public Context f39812a;

    public T1(Context context) {
        this.f39812a = context;
    }

    public static T1 a(Context context) {
        if (f39808b == null) {
            synchronized (T1.class) {
                if (f39808b == null) {
                    f39808b = new T1(context);
                }
            }
        }
        return f39808b;
    }

    public String a() {
        return f39810d;
    }

    public String b() {
        if (TextUtils.isEmpty(f39809c)) {
            try {
                return V1.j(this.f39812a);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return f39809c;
    }

    public String c() {
        return f39811e;
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
                FunOpenIDSdk.getOaid(this.f39812a, new S1(this));
            } catch (Exception unused2) {
            }
        }
    }
}
