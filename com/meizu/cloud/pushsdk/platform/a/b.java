package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import com.meizu.cloud.pushsdk.b.a.c;
import com.meizu.cloud.pushsdk.platform.b.d;
import com.meizu.cloud.pushsdk.platform.b.e;
import com.meizu.cloud.pushsdk.platform.b.f;
import com.meizu.cloud.pushsdk.platform.b.g;
import java.io.File;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes3.dex */
public class b {
    public static b a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f61137b;

    /* renamed from: c  reason: collision with root package name */
    public Context f61138c;

    /* renamed from: d  reason: collision with root package name */
    public a f61139d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f61140e;

    /* renamed from: f  reason: collision with root package name */
    public g f61141f;

    /* renamed from: g  reason: collision with root package name */
    public f f61142g;

    /* renamed from: h  reason: collision with root package name */
    public e f61143h;

    /* renamed from: i  reason: collision with root package name */
    public d f61144i;

    /* renamed from: j  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.a f61145j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f61146k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.f61146k = true;
        Context applicationContext = context.getApplicationContext();
        this.f61138c = applicationContext;
        this.f61139d = new a(applicationContext);
        if (z) {
            this.f61137b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.f61146k = z2;
        this.f61140e = new com.meizu.cloud.pushsdk.platform.b.b(this.f61138c, this.f61139d, this.f61137b, z2);
        this.f61141f = new g(this.f61138c, this.f61139d, this.f61137b, z2);
        this.f61142g = new f(this.f61138c, this.f61139d, this.f61137b, z2);
        this.f61143h = new e(this.f61138c, this.f61139d, this.f61137b, z2);
        this.f61144i = new d(this.f61138c, this.f61139d, this.f61137b, z2);
        this.f61145j = new com.meizu.cloud.pushsdk.platform.b.a(this.f61138c, this.f61137b, z2);
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
        return this.f61139d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f61140e.a(z);
        this.f61141f.a(z);
        this.f61142g.a(z);
        this.f61144i.a(z);
        this.f61143h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f61138c, this.f61137b, this.f61146k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f61138c, this.f61137b, this.f61146k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f61140e.b(str);
        this.f61140e.c(str2);
        this.f61140e.d(str3);
        return this.f61140e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f61142g.b(str);
        this.f61142g.c(str2);
        this.f61142g.d(str3);
        this.f61142g.a(str4);
        this.f61142g.a(2);
        return this.f61142g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f61142g.b(str);
        this.f61142g.c(str2);
        this.f61142g.d(str3);
        this.f61142g.a(str4);
        this.f61142g.a(i2);
        this.f61142g.b(z);
        return this.f61142g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f61143h.b(str);
        this.f61143h.c(str2);
        this.f61143h.d(str3);
        this.f61143h.e(str4);
        this.f61143h.a(0);
        this.f61143h.a(str5);
        return this.f61143h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f61142g.b(str);
        this.f61142g.c(str2);
        this.f61142g.d(str3);
        this.f61142g.a(str4);
        this.f61142g.a(3);
        this.f61142g.b(z);
        return this.f61142g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f61138c, this.f61137b, this.f61146k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f61141f.b(str);
        this.f61141f.c(str2);
        this.f61141f.d(str3);
        return this.f61141f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f61143h.b(str);
        this.f61143h.c(str2);
        this.f61143h.d(str3);
        this.f61143h.e(str4);
        this.f61143h.a(2);
        return this.f61143h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f61143h.b(str);
        this.f61143h.c(str2);
        this.f61143h.d(str3);
        this.f61143h.e(str4);
        this.f61143h.a(1);
        this.f61143h.a(str5);
        return this.f61143h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f61143h.b(str);
        this.f61143h.c(str2);
        this.f61143h.d(str3);
        this.f61143h.e(str4);
        this.f61143h.a(3);
        return this.f61143h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f61144i.b(str);
        this.f61144i.c(str2);
        this.f61144i.d(str3);
        this.f61144i.e(str4);
        this.f61144i.a(0);
        this.f61144i.a(str5);
        return this.f61144i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f61144i.b(str);
        this.f61144i.c(str2);
        this.f61144i.d(str3);
        this.f61144i.e(str4);
        this.f61144i.a(2);
        return this.f61144i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f61144i.b(str);
        this.f61144i.c(str2);
        this.f61144i.d(str3);
        this.f61144i.e(str4);
        this.f61144i.a(1);
        this.f61144i.a(str5);
        return this.f61144i.m();
    }
}
