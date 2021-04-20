package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import com.meizu.cloud.pushsdk.b.a.c;
import com.meizu.cloud.pushsdk.platform.b.d;
import com.meizu.cloud.pushsdk.platform.b.e;
import com.meizu.cloud.pushsdk.platform.b.f;
import com.meizu.cloud.pushsdk.platform.b.g;
import java.io.File;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f38168a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f38169b;

    /* renamed from: c  reason: collision with root package name */
    public Context f38170c;

    /* renamed from: d  reason: collision with root package name */
    public a f38171d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f38172e;

    /* renamed from: f  reason: collision with root package name */
    public g f38173f;

    /* renamed from: g  reason: collision with root package name */
    public f f38174g;

    /* renamed from: h  reason: collision with root package name */
    public e f38175h;
    public d i;
    public com.meizu.cloud.pushsdk.platform.b.a j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f38170c = applicationContext;
        this.f38171d = new a(applicationContext);
        if (z) {
            this.f38169b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f38172e = new com.meizu.cloud.pushsdk.platform.b.b(this.f38170c, this.f38171d, this.f38169b, z2);
        this.f38173f = new g(this.f38170c, this.f38171d, this.f38169b, z2);
        this.f38174g = new f(this.f38170c, this.f38171d, this.f38169b, z2);
        this.f38175h = new e(this.f38170c, this.f38171d, this.f38169b, z2);
        this.i = new d(this.f38170c, this.f38171d, this.f38169b, z2);
        this.j = new com.meizu.cloud.pushsdk.platform.b.a(this.f38170c, this.f38169b, z2);
    }

    public static b a(Context context) {
        if (f38168a == null) {
            synchronized (b.class) {
                if (f38168a == null) {
                    f38168a = new b(context, true);
                }
            }
        }
        return f38168a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f38171d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f38172e.a(z);
        this.f38173f.a(z);
        this.f38174g.a(z);
        this.i.a(z);
        this.f38175h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f38170c, this.f38169b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f38170c, this.f38169b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f38172e.b(str);
        this.f38172e.c(str2);
        this.f38172e.d(str3);
        return this.f38172e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f38174g.b(str);
        this.f38174g.c(str2);
        this.f38174g.d(str3);
        this.f38174g.a(str4);
        this.f38174g.a(2);
        return this.f38174g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i, boolean z) {
        this.f38174g.b(str);
        this.f38174g.c(str2);
        this.f38174g.d(str3);
        this.f38174g.a(str4);
        this.f38174g.a(i);
        this.f38174g.b(z);
        return this.f38174g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f38175h.b(str);
        this.f38175h.c(str2);
        this.f38175h.d(str3);
        this.f38175h.e(str4);
        this.f38175h.a(0);
        this.f38175h.a(str5);
        return this.f38175h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f38174g.b(str);
        this.f38174g.c(str2);
        this.f38174g.d(str3);
        this.f38174g.a(str4);
        this.f38174g.a(3);
        this.f38174g.b(z);
        return this.f38174g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f38170c, this.f38169b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f38173f.b(str);
        this.f38173f.c(str2);
        this.f38173f.d(str3);
        return this.f38173f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f38175h.b(str);
        this.f38175h.c(str2);
        this.f38175h.d(str3);
        this.f38175h.e(str4);
        this.f38175h.a(2);
        return this.f38175h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f38175h.b(str);
        this.f38175h.c(str2);
        this.f38175h.d(str3);
        this.f38175h.e(str4);
        this.f38175h.a(1);
        this.f38175h.a(str5);
        return this.f38175h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f38175h.b(str);
        this.f38175h.c(str2);
        this.f38175h.d(str3);
        this.f38175h.e(str4);
        this.f38175h.a(3);
        return this.f38175h.m();
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
