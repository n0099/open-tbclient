package com.sdk.base.module.a;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.c.f;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f13165a;

    /* renamed from: b  reason: collision with root package name */
    private Context f13166b;

    static {
        a.class.getName();
        Boolean.valueOf(f.f13118b);
    }

    private a(Context context) {
        this.f13166b = context;
    }

    public static a a(Context context) {
        if (f13165a == null) {
            synchronized (a.class) {
                f13165a = new a(context);
            }
        }
        return f13165a;
    }

    public final void a(String str, String str2) {
        com.sdk.base.framework.f.b.a.a(this.f13166b, "public_key", str2);
        if (c.b(str).booleanValue()) {
            com.sdk.base.framework.f.b.a.a(this.f13166b, Constants.API_KEY, str);
        }
    }
}
