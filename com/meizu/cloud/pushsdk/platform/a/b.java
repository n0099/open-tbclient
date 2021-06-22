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

    /* renamed from: a  reason: collision with root package name */
    public static b f38774a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f38775b;

    /* renamed from: c  reason: collision with root package name */
    public Context f38776c;

    /* renamed from: d  reason: collision with root package name */
    public a f38777d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f38778e;

    /* renamed from: f  reason: collision with root package name */
    public g f38779f;

    /* renamed from: g  reason: collision with root package name */
    public f f38780g;

    /* renamed from: h  reason: collision with root package name */
    public e f38781h;

    /* renamed from: i  reason: collision with root package name */
    public d f38782i;
    public com.meizu.cloud.pushsdk.platform.b.a j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f38776c = applicationContext;
        this.f38777d = new a(applicationContext);
        if (z) {
            this.f38775b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f38778e = new com.meizu.cloud.pushsdk.platform.b.b(this.f38776c, this.f38777d, this.f38775b, z2);
        this.f38779f = new g(this.f38776c, this.f38777d, this.f38775b, z2);
        this.f38780g = new f(this.f38776c, this.f38777d, this.f38775b, z2);
        this.f38781h = new e(this.f38776c, this.f38777d, this.f38775b, z2);
        this.f38782i = new d(this.f38776c, this.f38777d, this.f38775b, z2);
        this.j = new com.meizu.cloud.pushsdk.platform.b.a(this.f38776c, this.f38775b, z2);
    }

    public static b a(Context context) {
        if (f38774a == null) {
            synchronized (b.class) {
                if (f38774a == null) {
                    f38774a = new b(context, true);
                }
            }
        }
        return f38774a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f38777d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f38778e.a(z);
        this.f38779f.a(z);
        this.f38780g.a(z);
        this.f38782i.a(z);
        this.f38781h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f38776c, this.f38775b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f38776c, this.f38775b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f38778e.b(str);
        this.f38778e.c(str2);
        this.f38778e.d(str3);
        return this.f38778e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f38780g.b(str);
        this.f38780g.c(str2);
        this.f38780g.d(str3);
        this.f38780g.a(str4);
        this.f38780g.a(2);
        return this.f38780g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f38780g.b(str);
        this.f38780g.c(str2);
        this.f38780g.d(str3);
        this.f38780g.a(str4);
        this.f38780g.a(i2);
        this.f38780g.b(z);
        return this.f38780g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f38781h.b(str);
        this.f38781h.c(str2);
        this.f38781h.d(str3);
        this.f38781h.e(str4);
        this.f38781h.a(0);
        this.f38781h.a(str5);
        return this.f38781h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f38780g.b(str);
        this.f38780g.c(str2);
        this.f38780g.d(str3);
        this.f38780g.a(str4);
        this.f38780g.a(3);
        this.f38780g.b(z);
        return this.f38780g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f38776c, this.f38775b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f38779f.b(str);
        this.f38779f.c(str2);
        this.f38779f.d(str3);
        return this.f38779f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f38781h.b(str);
        this.f38781h.c(str2);
        this.f38781h.d(str3);
        this.f38781h.e(str4);
        this.f38781h.a(2);
        return this.f38781h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f38781h.b(str);
        this.f38781h.c(str2);
        this.f38781h.d(str3);
        this.f38781h.e(str4);
        this.f38781h.a(1);
        this.f38781h.a(str5);
        return this.f38781h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f38781h.b(str);
        this.f38781h.c(str2);
        this.f38781h.d(str3);
        this.f38781h.e(str4);
        this.f38781h.a(3);
        return this.f38781h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f38782i.b(str);
        this.f38782i.c(str2);
        this.f38782i.d(str3);
        this.f38782i.e(str4);
        this.f38782i.a(0);
        this.f38782i.a(str5);
        return this.f38782i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f38782i.b(str);
        this.f38782i.c(str2);
        this.f38782i.d(str3);
        this.f38782i.e(str4);
        this.f38782i.a(2);
        return this.f38782i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f38782i.b(str);
        this.f38782i.c(str2);
        this.f38782i.d(str3);
        this.f38782i.e(str4);
        this.f38782i.a(1);
        this.f38782i.a(str5);
        return this.f38782i.m();
    }
}
