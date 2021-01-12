package com.sdk.base.module.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
/* loaded from: classes14.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f12866a;

    /* renamed from: b  reason: collision with root package name */
    private Context f12867b;

    static {
        a.class.getName();
        Boolean.valueOf(f.f12819b);
    }

    private a(Context context) {
        this.f12867b = context;
    }

    public static a a(Context context) {
        if (f12866a == null) {
            synchronized (a.class) {
                f12866a = new a(context);
            }
        }
        return f12866a;
    }

    public final void a(String str, String str2) {
        com.sdk.base.framework.f.b.a.a(this.f12867b, "public_key", str2);
        if (c.b(str).booleanValue()) {
            com.sdk.base.framework.f.b.a.a(this.f12867b, Constants.API_KEY, str);
        }
    }
}
