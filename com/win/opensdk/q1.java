package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.fun.openid.sdk.FunOpenIDSdk;
/* loaded from: classes7.dex */
public class q1 {

    /* renamed from: b  reason: collision with root package name */
    public static q1 f37105b;

    /* renamed from: c  reason: collision with root package name */
    public static String f37106c;

    /* renamed from: d  reason: collision with root package name */
    public static String f37107d;

    /* renamed from: e  reason: collision with root package name */
    public static String f37108e;

    /* renamed from: a  reason: collision with root package name */
    public Context f37109a;

    public q1(Context context) {
        this.f37109a = context;
    }

    public static q1 a(Context context) {
        if (f37105b == null) {
            synchronized (q1.class) {
                if (f37105b == null) {
                    f37105b = new q1(context);
                }
            }
        }
        return f37105b;
    }

    public String a() {
        return f37107d;
    }

    public String b() {
        if (TextUtils.isEmpty(f37106c)) {
            try {
                return s1.j(this.f37109a);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return f37106c;
    }

    public String c() {
        return f37108e;
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
                FunOpenIDSdk.getOaid(this.f37109a, new p1(this));
            } catch (Exception unused2) {
            }
        }
    }
}
