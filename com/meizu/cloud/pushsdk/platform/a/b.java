package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import com.meizu.cloud.pushsdk.b.a.c;
import com.meizu.cloud.pushsdk.platform.b.d;
import com.meizu.cloud.pushsdk.platform.b.e;
import com.meizu.cloud.pushsdk.platform.b.f;
import com.meizu.cloud.pushsdk.platform.b.g;
import java.io.File;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f75323a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f75324b;

    /* renamed from: c  reason: collision with root package name */
    public Context f75325c;

    /* renamed from: d  reason: collision with root package name */
    public a f75326d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f75327e;

    /* renamed from: f  reason: collision with root package name */
    public g f75328f;

    /* renamed from: g  reason: collision with root package name */
    public f f75329g;

    /* renamed from: h  reason: collision with root package name */
    public e f75330h;

    /* renamed from: i  reason: collision with root package name */
    public d f75331i;

    /* renamed from: j  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.a f75332j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f75325c = applicationContext;
        this.f75326d = new a(applicationContext);
        if (z) {
            this.f75324b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f75327e = new com.meizu.cloud.pushsdk.platform.b.b(this.f75325c, this.f75326d, this.f75324b, z2);
        this.f75328f = new g(this.f75325c, this.f75326d, this.f75324b, z2);
        this.f75329g = new f(this.f75325c, this.f75326d, this.f75324b, z2);
        this.f75330h = new e(this.f75325c, this.f75326d, this.f75324b, z2);
        this.f75331i = new d(this.f75325c, this.f75326d, this.f75324b, z2);
        this.f75332j = new com.meizu.cloud.pushsdk.platform.b.a(this.f75325c, this.f75324b, z2);
    }

    public static b a(Context context) {
        if (f75323a == null) {
            synchronized (b.class) {
                if (f75323a == null) {
                    f75323a = new b(context, true);
                }
            }
        }
        return f75323a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f75326d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f75327e.a(z);
        this.f75328f.a(z);
        this.f75329g.a(z);
        this.f75331i.a(z);
        this.f75330h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f75325c, this.f75324b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f75325c, this.f75324b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f75327e.b(str);
        this.f75327e.c(str2);
        this.f75327e.d(str3);
        return this.f75327e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f75329g.b(str);
        this.f75329g.c(str2);
        this.f75329g.d(str3);
        this.f75329g.a(str4);
        this.f75329g.a(2);
        return this.f75329g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f75329g.b(str);
        this.f75329g.c(str2);
        this.f75329g.d(str3);
        this.f75329g.a(str4);
        this.f75329g.a(i2);
        this.f75329g.b(z);
        return this.f75329g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f75330h.b(str);
        this.f75330h.c(str2);
        this.f75330h.d(str3);
        this.f75330h.e(str4);
        this.f75330h.a(0);
        this.f75330h.a(str5);
        return this.f75330h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f75329g.b(str);
        this.f75329g.c(str2);
        this.f75329g.d(str3);
        this.f75329g.a(str4);
        this.f75329g.a(3);
        this.f75329g.b(z);
        return this.f75329g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f75325c, this.f75324b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f75328f.b(str);
        this.f75328f.c(str2);
        this.f75328f.d(str3);
        return this.f75328f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f75330h.b(str);
        this.f75330h.c(str2);
        this.f75330h.d(str3);
        this.f75330h.e(str4);
        this.f75330h.a(2);
        return this.f75330h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f75330h.b(str);
        this.f75330h.c(str2);
        this.f75330h.d(str3);
        this.f75330h.e(str4);
        this.f75330h.a(1);
        this.f75330h.a(str5);
        return this.f75330h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f75330h.b(str);
        this.f75330h.c(str2);
        this.f75330h.d(str3);
        this.f75330h.e(str4);
        this.f75330h.a(3);
        return this.f75330h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f75331i.b(str);
        this.f75331i.c(str2);
        this.f75331i.d(str3);
        this.f75331i.e(str4);
        this.f75331i.a(0);
        this.f75331i.a(str5);
        return this.f75331i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f75331i.b(str);
        this.f75331i.c(str2);
        this.f75331i.d(str3);
        this.f75331i.e(str4);
        this.f75331i.a(2);
        return this.f75331i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f75331i.b(str);
        this.f75331i.c(str2);
        this.f75331i.d(str3);
        this.f75331i.e(str4);
        this.f75331i.a(1);
        this.f75331i.a(str5);
        return this.f75331i.m();
    }
}
