package com.sdk.base.module.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f13166a;

    /* renamed from: b  reason: collision with root package name */
    private Context f13167b;

    static {
        a.class.getName();
        Boolean.valueOf(f.f13119b);
    }

    private a(Context context) {
        this.f13167b = context;
    }

    public static a a(Context context) {
        if (f13166a == null) {
            synchronized (a.class) {
                f13166a = new a(context);
            }
        }
        return f13166a;
    }

    public final void a(String str, String str2) {
        com.sdk.base.framework.f.b.a.a(this.f13167b, "public_key", str2);
        if (c.b(str).booleanValue()) {
            com.sdk.base.framework.f.b.a.a(this.f13167b, Constants.API_KEY, str);
        }
    }
}
