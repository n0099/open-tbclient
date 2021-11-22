package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import com.meizu.cloud.pushsdk.b.a.c;
import com.meizu.cloud.pushsdk.platform.b.d;
import com.meizu.cloud.pushsdk.platform.b.e;
import com.meizu.cloud.pushsdk.platform.b.f;
import com.meizu.cloud.pushsdk.platform.b.g;
import java.io.File;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f68592a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f68593b;

    /* renamed from: c  reason: collision with root package name */
    public Context f68594c;

    /* renamed from: d  reason: collision with root package name */
    public a f68595d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f68596e;

    /* renamed from: f  reason: collision with root package name */
    public g f68597f;

    /* renamed from: g  reason: collision with root package name */
    public f f68598g;

    /* renamed from: h  reason: collision with root package name */
    public e f68599h;

    /* renamed from: i  reason: collision with root package name */
    public d f68600i;
    public com.meizu.cloud.pushsdk.platform.b.a j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f68594c = applicationContext;
        this.f68595d = new a(applicationContext);
        if (z) {
            this.f68593b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f68596e = new com.meizu.cloud.pushsdk.platform.b.b(this.f68594c, this.f68595d, this.f68593b, z2);
        this.f68597f = new g(this.f68594c, this.f68595d, this.f68593b, z2);
        this.f68598g = new f(this.f68594c, this.f68595d, this.f68593b, z2);
        this.f68599h = new e(this.f68594c, this.f68595d, this.f68593b, z2);
        this.f68600i = new d(this.f68594c, this.f68595d, this.f68593b, z2);
        this.j = new com.meizu.cloud.pushsdk.platform.b.a(this.f68594c, this.f68593b, z2);
    }

    public static b a(Context context) {
        if (f68592a == null) {
            synchronized (b.class) {
                if (f68592a == null) {
                    f68592a = new b(context, true);
                }
            }
        }
        return f68592a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f68595d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f68596e.a(z);
        this.f68597f.a(z);
        this.f68598g.a(z);
        this.f68600i.a(z);
        this.f68599h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f68594c, this.f68593b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f68594c, this.f68593b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f68596e.b(str);
        this.f68596e.c(str2);
        this.f68596e.d(str3);
        return this.f68596e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f68598g.b(str);
        this.f68598g.c(str2);
        this.f68598g.d(str3);
        this.f68598g.a(str4);
        this.f68598g.a(2);
        return this.f68598g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f68598g.b(str);
        this.f68598g.c(str2);
        this.f68598g.d(str3);
        this.f68598g.a(str4);
        this.f68598g.a(i2);
        this.f68598g.b(z);
        return this.f68598g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f68599h.b(str);
        this.f68599h.c(str2);
        this.f68599h.d(str3);
        this.f68599h.e(str4);
        this.f68599h.a(0);
        this.f68599h.a(str5);
        return this.f68599h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f68598g.b(str);
        this.f68598g.c(str2);
        this.f68598g.d(str3);
        this.f68598g.a(str4);
        this.f68598g.a(3);
        this.f68598g.b(z);
        return this.f68598g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f68594c, this.f68593b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f68597f.b(str);
        this.f68597f.c(str2);
        this.f68597f.d(str3);
        return this.f68597f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f68599h.b(str);
        this.f68599h.c(str2);
        this.f68599h.d(str3);
        this.f68599h.e(str4);
        this.f68599h.a(2);
        return this.f68599h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f68599h.b(str);
        this.f68599h.c(str2);
        this.f68599h.d(str3);
        this.f68599h.e(str4);
        this.f68599h.a(1);
        this.f68599h.a(str5);
        return this.f68599h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f68599h.b(str);
        this.f68599h.c(str2);
        this.f68599h.d(str3);
        this.f68599h.e(str4);
        this.f68599h.a(3);
        return this.f68599h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f68600i.b(str);
        this.f68600i.c(str2);
        this.f68600i.d(str3);
        this.f68600i.e(str4);
        this.f68600i.a(0);
        this.f68600i.a(str5);
        return this.f68600i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f68600i.b(str);
        this.f68600i.c(str2);
        this.f68600i.d(str3);
        this.f68600i.e(str4);
        this.f68600i.a(2);
        return this.f68600i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f68600i.b(str);
        this.f68600i.c(str2);
        this.f68600i.d(str3);
        this.f68600i.e(str4);
        this.f68600i.a(1);
        this.f68600i.a(str5);
        return this.f68600i.m();
    }
}
