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
    public static b f37740a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f37741b;

    /* renamed from: c  reason: collision with root package name */
    public Context f37742c;

    /* renamed from: d  reason: collision with root package name */
    public a f37743d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f37744e;

    /* renamed from: f  reason: collision with root package name */
    public g f37745f;

    /* renamed from: g  reason: collision with root package name */
    public f f37746g;

    /* renamed from: h  reason: collision with root package name */
    public e f37747h;

    /* renamed from: i  reason: collision with root package name */
    public d f37748i;
    public com.meizu.cloud.pushsdk.platform.b.a j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f37742c = applicationContext;
        this.f37743d = new a(applicationContext);
        if (z) {
            this.f37741b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f37744e = new com.meizu.cloud.pushsdk.platform.b.b(this.f37742c, this.f37743d, this.f37741b, z2);
        this.f37745f = new g(this.f37742c, this.f37743d, this.f37741b, z2);
        this.f37746g = new f(this.f37742c, this.f37743d, this.f37741b, z2);
        this.f37747h = new e(this.f37742c, this.f37743d, this.f37741b, z2);
        this.f37748i = new d(this.f37742c, this.f37743d, this.f37741b, z2);
        this.j = new com.meizu.cloud.pushsdk.platform.b.a(this.f37742c, this.f37741b, z2);
    }

    public static b a(Context context) {
        if (f37740a == null) {
            synchronized (b.class) {
                if (f37740a == null) {
                    f37740a = new b(context, true);
                }
            }
        }
        return f37740a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f37743d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f37744e.a(z);
        this.f37745f.a(z);
        this.f37746g.a(z);
        this.f37748i.a(z);
        this.f37747h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f37742c, this.f37741b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f37742c, this.f37741b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f37744e.b(str);
        this.f37744e.c(str2);
        this.f37744e.d(str3);
        return this.f37744e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f37746g.b(str);
        this.f37746g.c(str2);
        this.f37746g.d(str3);
        this.f37746g.a(str4);
        this.f37746g.a(2);
        return this.f37746g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f37746g.b(str);
        this.f37746g.c(str2);
        this.f37746g.d(str3);
        this.f37746g.a(str4);
        this.f37746g.a(i2);
        this.f37746g.b(z);
        return this.f37746g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f37747h.b(str);
        this.f37747h.c(str2);
        this.f37747h.d(str3);
        this.f37747h.e(str4);
        this.f37747h.a(0);
        this.f37747h.a(str5);
        return this.f37747h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f37746g.b(str);
        this.f37746g.c(str2);
        this.f37746g.d(str3);
        this.f37746g.a(str4);
        this.f37746g.a(3);
        this.f37746g.b(z);
        return this.f37746g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f37742c, this.f37741b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f37745f.b(str);
        this.f37745f.c(str2);
        this.f37745f.d(str3);
        return this.f37745f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f37747h.b(str);
        this.f37747h.c(str2);
        this.f37747h.d(str3);
        this.f37747h.e(str4);
        this.f37747h.a(2);
        return this.f37747h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f37747h.b(str);
        this.f37747h.c(str2);
        this.f37747h.d(str3);
        this.f37747h.e(str4);
        this.f37747h.a(1);
        this.f37747h.a(str5);
        return this.f37747h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f37747h.b(str);
        this.f37747h.c(str2);
        this.f37747h.d(str3);
        this.f37747h.e(str4);
        this.f37747h.a(3);
        return this.f37747h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f37748i.b(str);
        this.f37748i.c(str2);
        this.f37748i.d(str3);
        this.f37748i.e(str4);
        this.f37748i.a(0);
        this.f37748i.a(str5);
        return this.f37748i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f37748i.b(str);
        this.f37748i.c(str2);
        this.f37748i.d(str3);
        this.f37748i.e(str4);
        this.f37748i.a(2);
        return this.f37748i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f37748i.b(str);
        this.f37748i.c(str2);
        this.f37748i.d(str3);
        this.f37748i.e(str4);
        this.f37748i.a(1);
        this.f37748i.a(str5);
        return this.f37748i.m();
    }
}
