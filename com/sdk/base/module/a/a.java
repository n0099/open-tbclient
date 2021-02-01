package com.sdk.base.module.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f12868a;

    /* renamed from: b  reason: collision with root package name */
    private Context f12869b;

    static {
        a.class.getName();
        Boolean.valueOf(f.f12821b);
    }

    private a(Context context) {
        this.f12869b = context;
    }

    public static a a(Context context) {
        if (f12868a == null) {
            synchronized (a.class) {
                f12868a = new a(context);
            }
        }
        return f12868a;
    }

    public final void a(String str, String str2) {
        com.sdk.base.framework.f.b.a.a(this.f12869b, "public_key", str2);
        if (c.b(str).booleanValue()) {
            com.sdk.base.framework.f.b.a.a(this.f12869b, Constants.API_KEY, str);
        }
    }
}
