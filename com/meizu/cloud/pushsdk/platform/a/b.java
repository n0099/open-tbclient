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
    public ScheduledExecutorService f58823b;

    /* renamed from: c  reason: collision with root package name */
    public Context f58824c;

    /* renamed from: d  reason: collision with root package name */
    public a f58825d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f58826e;

    /* renamed from: f  reason: collision with root package name */
    public g f58827f;

    /* renamed from: g  reason: collision with root package name */
    public f f58828g;

    /* renamed from: h  reason: collision with root package name */
    public e f58829h;

    /* renamed from: i  reason: collision with root package name */
    public d f58830i;

    /* renamed from: j  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.a f58831j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f58824c = applicationContext;
        this.f58825d = new a(applicationContext);
        if (z) {
            this.f58823b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f58826e = new com.meizu.cloud.pushsdk.platform.b.b(this.f58824c, this.f58825d, this.f58823b, z2);
        this.f58827f = new g(this.f58824c, this.f58825d, this.f58823b, z2);
        this.f58828g = new f(this.f58824c, this.f58825d, this.f58823b, z2);
        this.f58829h = new e(this.f58824c, this.f58825d, this.f58823b, z2);
        this.f58830i = new d(this.f58824c, this.f58825d, this.f58823b, z2);
        this.f58831j = new com.meizu.cloud.pushsdk.platform.b.a(this.f58824c, this.f58823b, z2);
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
        return this.f58825d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f58826e.a(z);
        this.f58827f.a(z);
        this.f58828g.a(z);
        this.f58830i.a(z);
        this.f58829h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f58824c, this.f58823b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f58824c, this.f58823b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f58826e.b(str);
        this.f58826e.c(str2);
        this.f58826e.d(str3);
        return this.f58826e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f58828g.b(str);
        this.f58828g.c(str2);
        this.f58828g.d(str3);
        this.f58828g.a(str4);
        this.f58828g.a(2);
        return this.f58828g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f58828g.b(str);
        this.f58828g.c(str2);
        this.f58828g.d(str3);
        this.f58828g.a(str4);
        this.f58828g.a(i2);
        this.f58828g.b(z);
        return this.f58828g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f58829h.b(str);
        this.f58829h.c(str2);
        this.f58829h.d(str3);
        this.f58829h.e(str4);
        this.f58829h.a(0);
        this.f58829h.a(str5);
        return this.f58829h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f58828g.b(str);
        this.f58828g.c(str2);
        this.f58828g.d(str3);
        this.f58828g.a(str4);
        this.f58828g.a(3);
        this.f58828g.b(z);
        return this.f58828g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f58824c, this.f58823b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f58827f.b(str);
        this.f58827f.c(str2);
        this.f58827f.d(str3);
        return this.f58827f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f58829h.b(str);
        this.f58829h.c(str2);
        this.f58829h.d(str3);
        this.f58829h.e(str4);
        this.f58829h.a(2);
        return this.f58829h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f58829h.b(str);
        this.f58829h.c(str2);
        this.f58829h.d(str3);
        this.f58829h.e(str4);
        this.f58829h.a(1);
        this.f58829h.a(str5);
        return this.f58829h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f58829h.b(str);
        this.f58829h.c(str2);
        this.f58829h.d(str3);
        this.f58829h.e(str4);
        this.f58829h.a(3);
        return this.f58829h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f58830i.b(str);
        this.f58830i.c(str2);
        this.f58830i.d(str3);
        this.f58830i.e(str4);
        this.f58830i.a(0);
        this.f58830i.a(str5);
        return this.f58830i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f58830i.b(str);
        this.f58830i.c(str2);
        this.f58830i.d(str3);
        this.f58830i.e(str4);
        this.f58830i.a(2);
        return this.f58830i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f58830i.b(str);
        this.f58830i.c(str2);
        this.f58830i.d(str3);
        this.f58830i.e(str4);
        this.f58830i.a(1);
        this.f58830i.a(str5);
        return this.f58830i.m();
    }
}
