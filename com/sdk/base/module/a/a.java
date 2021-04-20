package com.sdk.base.module.a;

import android.content.Context;
import com.alipay.sdk.packet.e;
import com.baidu.android.imsdk.internal.Constants;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f38863a;

    /* renamed from: b  reason: collision with root package name */
    public Context f38864b;

    static {
        boolean z = f.f38809b;
    }

    public a(Context context) {
        this.f38864b = context;
    }

    public static a a(Context context) {
        if (f38863a == null) {
            synchronized (a.class) {
                f38863a = new a(context);
            }
        }
        return f38863a;
    }

    public final void a(String str, String str2) {
        com.sdk.base.framework.f.b.a.a(this.f38864b, e.m, str2);
        if (c.b(str).booleanValue()) {
            com.sdk.base.framework.f.b.a.a(this.f38864b, Constants.API_KEY, str);
        }
    }
}
