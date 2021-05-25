package com.sdk.base.module.a;

import android.content.Context;
import com.alipay.sdk.packet.e;
import com.baidu.android.imsdk.internal.Constants;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f35717a;

    /* renamed from: b  reason: collision with root package name */
    public Context f35718b;

    static {
        boolean z = f.f35662b;
    }

    public a(Context context) {
        this.f35718b = context;
    }

    public static a a(Context context) {
        if (f35717a == null) {
            synchronized (a.class) {
                f35717a = new a(context);
            }
        }
        return f35717a;
    }

    public final void a(String str, String str2) {
        com.sdk.base.framework.f.b.a.a(this.f35718b, e.m, str2);
        if (c.b(str).booleanValue()) {
            com.sdk.base.framework.f.b.a.a(this.f35718b, Constants.API_KEY, str);
        }
    }
}
