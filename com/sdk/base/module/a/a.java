package com.sdk.base.module.a;

import android.content.Context;
import com.alipay.sdk.packet.e;
import com.baidu.android.imsdk.internal.Constants;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f36543a;

    /* renamed from: b  reason: collision with root package name */
    public Context f36544b;

    static {
        boolean z = f.f36488b;
    }

    public a(Context context) {
        this.f36544b = context;
    }

    public static a a(Context context) {
        if (f36543a == null) {
            synchronized (a.class) {
                f36543a = new a(context);
            }
        }
        return f36543a;
    }

    public final void a(String str, String str2) {
        com.sdk.base.framework.f.b.a.a(this.f36544b, e.m, str2);
        if (c.b(str).booleanValue()) {
            com.sdk.base.framework.f.b.a.a(this.f36544b, Constants.API_KEY, str);
        }
    }
}
