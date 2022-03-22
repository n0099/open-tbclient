package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import com.meizu.cloud.pushsdk.b.a.c;
import com.meizu.cloud.pushsdk.platform.b.d;
import com.meizu.cloud.pushsdk.platform.b.e;
import com.meizu.cloud.pushsdk.platform.b.f;
import com.meizu.cloud.pushsdk.platform.b.g;
import java.io.File;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
public class b {
    public static b a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f42208b;

    /* renamed from: c  reason: collision with root package name */
    public Context f42209c;

    /* renamed from: d  reason: collision with root package name */
    public a f42210d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f42211e;

    /* renamed from: f  reason: collision with root package name */
    public g f42212f;

    /* renamed from: g  reason: collision with root package name */
    public f f42213g;

    /* renamed from: h  reason: collision with root package name */
    public e f42214h;
    public d i;
    public com.meizu.cloud.pushsdk.platform.b.a j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f42209c = applicationContext;
        this.f42210d = new a(applicationContext);
        if (z) {
            this.f42208b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f42211e = new com.meizu.cloud.pushsdk.platform.b.b(this.f42209c, this.f42210d, this.f42208b, z2);
        this.f42212f = new g(this.f42209c, this.f42210d, this.f42208b, z2);
        this.f42213g = new f(this.f42209c, this.f42210d, this.f42208b, z2);
        this.f42214h = new e(this.f42209c, this.f42210d, this.f42208b, z2);
        this.i = new d(this.f42209c, this.f42210d, this.f42208b, z2);
        this.j = new com.meizu.cloud.pushsdk.platform.b.a(this.f42209c, this.f42208b, z2);
    }

    public static b a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context, true);
                }
            }
        }
        return a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f42210d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f42211e.a(z);
        this.f42212f.a(z);
        this.f42213g.a(z);
        this.i.a(z);
        this.f42214h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f42209c, this.f42208b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f42209c, this.f42208b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f42211e.b(str);
        this.f42211e.c(str2);
        this.f42211e.d(str3);
        return this.f42211e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f42213g.b(str);
        this.f42213g.c(str2);
        this.f42213g.d(str3);
        this.f42213g.a(str4);
        this.f42213g.a(2);
        return this.f42213g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i, boolean z) {
        this.f42213g.b(str);
        this.f42213g.c(str2);
        this.f42213g.d(str3);
        this.f42213g.a(str4);
        this.f42213g.a(i);
        this.f42213g.b(z);
        return this.f42213g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f42214h.b(str);
        this.f42214h.c(str2);
        this.f42214h.d(str3);
        this.f42214h.e(str4);
        this.f42214h.a(0);
        this.f42214h.a(str5);
        return this.f42214h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f42213g.b(str);
        this.f42213g.c(str2);
        this.f42213g.d(str3);
        this.f42213g.a(str4);
        this.f42213g.a(3);
        this.f42213g.b(z);
        return this.f42213g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f42209c, this.f42208b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f42212f.b(str);
        this.f42212f.c(str2);
        this.f42212f.d(str3);
        return this.f42212f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f42214h.b(str);
        this.f42214h.c(str2);
        this.f42214h.d(str3);
        this.f42214h.e(str4);
        this.f42214h.a(2);
        return this.f42214h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f42214h.b(str);
        this.f42214h.c(str2);
        this.f42214h.d(str3);
        this.f42214h.e(str4);
        this.f42214h.a(1);
        this.f42214h.a(str5);
        return this.f42214h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f42214h.b(str);
        this.f42214h.c(str2);
        this.f42214h.d(str3);
        this.f42214h.e(str4);
        this.f42214h.a(3);
        return this.f42214h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.i.b(str);
        this.i.c(str2);
        this.i.d(str3);
        this.i.e(str4);
        this.i.a(0);
        this.i.a(str5);
        return this.i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.i.b(str);
        this.i.c(str2);
        this.i.d(str3);
        this.i.e(str4);
        this.i.a(2);
        return this.i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.i.b(str);
        this.i.c(str2);
        this.i.d(str3);
        this.i.e(str4);
        this.i.a(1);
        this.i.a(str5);
        return this.i.m();
    }
}
