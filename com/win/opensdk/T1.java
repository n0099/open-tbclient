package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.fun.openid.sdk.FunOpenIDSdk;
/* loaded from: classes7.dex */
public class T1 {

    /* renamed from: b  reason: collision with root package name */
    public static T1 f40097b;

    /* renamed from: c  reason: collision with root package name */
    public static String f40098c;

    /* renamed from: d  reason: collision with root package name */
    public static String f40099d;

    /* renamed from: e  reason: collision with root package name */
    public static String f40100e;

    /* renamed from: a  reason: collision with root package name */
    public Context f40101a;

    public T1(Context context) {
        this.f40101a = context;
    }

    public static T1 a(Context context) {
        if (f40097b == null) {
            synchronized (T1.class) {
                if (f40097b == null) {
                    f40097b = new T1(context);
                }
            }
        }
        return f40097b;
    }

    public String a() {
        return f40099d;
    }

    public String b() {
        if (TextUtils.isEmpty(f40098c)) {
            try {
                return V1.j(this.f40101a);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return f40098c;
    }

    public String c() {
        return f40100e;
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
                FunOpenIDSdk.getOaid(this.f40101a, new S1(this));
            } catch (Exception unused2) {
            }
        }
    }
}
