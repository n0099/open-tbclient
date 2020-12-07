package com.sdk.base.module.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
/* loaded from: classes9.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f4282a;
    private Context b;

    static {
        a.class.getName();
        Boolean.valueOf(f.b);
    }

    private a(Context context) {
        this.b = context;
    }

    public static a a(Context context) {
        if (f4282a == null) {
            synchronized (a.class) {
                f4282a = new a(context);
            }
        }
        return f4282a;
    }

    public final void a(String str, String str2) {
        com.sdk.base.framework.f.b.a.a(this.b, "public_key", str2);
        if (c.b(str).booleanValue()) {
            com.sdk.base.framework.f.b.a.a(this.b, Constants.API_KEY, str);
        }
    }
}
