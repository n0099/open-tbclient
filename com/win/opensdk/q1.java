package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.fun.openid.sdk.FunOpenIDSdk;
/* loaded from: classes7.dex */
public class q1 {

    /* renamed from: b  reason: collision with root package name */
    public static q1 f40887b;

    /* renamed from: c  reason: collision with root package name */
    public static String f40888c;

    /* renamed from: d  reason: collision with root package name */
    public static String f40889d;

    /* renamed from: e  reason: collision with root package name */
    public static String f40890e;

    /* renamed from: a  reason: collision with root package name */
    public Context f40891a;

    public q1(Context context) {
        this.f40891a = context;
    }

    public static q1 a(Context context) {
        if (f40887b == null) {
            synchronized (q1.class) {
                if (f40887b == null) {
                    f40887b = new q1(context);
                }
            }
        }
        return f40887b;
    }

    public String a() {
        return f40889d;
    }

    public String b() {
        if (TextUtils.isEmpty(f40888c)) {
            try {
                return s1.j(this.f40891a);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return f40888c;
    }

    public String c() {
        return f40890e;
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
                FunOpenIDSdk.getOaid(this.f40891a, new p1(this));
            } catch (Exception unused2) {
            }
        }
    }
}
