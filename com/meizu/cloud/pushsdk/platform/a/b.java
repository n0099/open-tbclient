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
    public static b f37878a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f37879b;

    /* renamed from: c  reason: collision with root package name */
    public Context f37880c;

    /* renamed from: d  reason: collision with root package name */
    public a f37881d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f37882e;

    /* renamed from: f  reason: collision with root package name */
    public g f37883f;

    /* renamed from: g  reason: collision with root package name */
    public f f37884g;

    /* renamed from: h  reason: collision with root package name */
    public e f37885h;
    public d i;
    public com.meizu.cloud.pushsdk.platform.b.a j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f37880c = applicationContext;
        this.f37881d = new a(applicationContext);
        if (z) {
            this.f37879b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f37882e = new com.meizu.cloud.pushsdk.platform.b.b(this.f37880c, this.f37881d, this.f37879b, z2);
        this.f37883f = new g(this.f37880c, this.f37881d, this.f37879b, z2);
        this.f37884g = new f(this.f37880c, this.f37881d, this.f37879b, z2);
        this.f37885h = new e(this.f37880c, this.f37881d, this.f37879b, z2);
        this.i = new d(this.f37880c, this.f37881d, this.f37879b, z2);
        this.j = new com.meizu.cloud.pushsdk.platform.b.a(this.f37880c, this.f37879b, z2);
    }

    public static b a(Context context) {
        if (f37878a == null) {
            synchronized (b.class) {
                if (f37878a == null) {
                    f37878a = new b(context, true);
                }
            }
        }
        return f37878a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f37881d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f37882e.a(z);
        this.f37883f.a(z);
        this.f37884g.a(z);
        this.i.a(z);
        this.f37885h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f37880c, this.f37879b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f37880c, this.f37879b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f37882e.b(str);
        this.f37882e.c(str2);
        this.f37882e.d(str3);
        return this.f37882e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f37884g.b(str);
        this.f37884g.c(str2);
        this.f37884g.d(str3);
        this.f37884g.a(str4);
        this.f37884g.a(2);
        return this.f37884g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i, boolean z) {
        this.f37884g.b(str);
        this.f37884g.c(str2);
        this.f37884g.d(str3);
        this.f37884g.a(str4);
        this.f37884g.a(i);
        this.f37884g.b(z);
        return this.f37884g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f37885h.b(str);
        this.f37885h.c(str2);
        this.f37885h.d(str3);
        this.f37885h.e(str4);
        this.f37885h.a(0);
        this.f37885h.a(str5);
        return this.f37885h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f37884g.b(str);
        this.f37884g.c(str2);
        this.f37884g.d(str3);
        this.f37884g.a(str4);
        this.f37884g.a(3);
        this.f37884g.b(z);
        return this.f37884g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f37880c, this.f37879b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f37883f.b(str);
        this.f37883f.c(str2);
        this.f37883f.d(str3);
        return this.f37883f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f37885h.b(str);
        this.f37885h.c(str2);
        this.f37885h.d(str3);
        this.f37885h.e(str4);
        this.f37885h.a(2);
        return this.f37885h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f37885h.b(str);
        this.f37885h.c(str2);
        this.f37885h.d(str3);
        this.f37885h.e(str4);
        this.f37885h.a(1);
        this.f37885h.a(str5);
        return this.f37885h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f37885h.b(str);
        this.f37885h.c(str2);
        this.f37885h.d(str3);
        this.f37885h.e(str4);
        this.f37885h.a(3);
        return this.f37885h.m();
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
