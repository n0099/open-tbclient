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
    public static b f35823a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f35824b;

    /* renamed from: c  reason: collision with root package name */
    public Context f35825c;

    /* renamed from: d  reason: collision with root package name */
    public a f35826d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f35827e;

    /* renamed from: f  reason: collision with root package name */
    public g f35828f;

    /* renamed from: g  reason: collision with root package name */
    public f f35829g;

    /* renamed from: h  reason: collision with root package name */
    public e f35830h;

    /* renamed from: i  reason: collision with root package name */
    public d f35831i;
    public com.meizu.cloud.pushsdk.platform.b.a j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f35825c = applicationContext;
        this.f35826d = new a(applicationContext);
        if (z) {
            this.f35824b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f35827e = new com.meizu.cloud.pushsdk.platform.b.b(this.f35825c, this.f35826d, this.f35824b, z2);
        this.f35828f = new g(this.f35825c, this.f35826d, this.f35824b, z2);
        this.f35829g = new f(this.f35825c, this.f35826d, this.f35824b, z2);
        this.f35830h = new e(this.f35825c, this.f35826d, this.f35824b, z2);
        this.f35831i = new d(this.f35825c, this.f35826d, this.f35824b, z2);
        this.j = new com.meizu.cloud.pushsdk.platform.b.a(this.f35825c, this.f35824b, z2);
    }

    public static b a(Context context) {
        if (f35823a == null) {
            synchronized (b.class) {
                if (f35823a == null) {
                    f35823a = new b(context, true);
                }
            }
        }
        return f35823a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f35826d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f35827e.a(z);
        this.f35828f.a(z);
        this.f35829g.a(z);
        this.f35831i.a(z);
        this.f35830h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f35825c, this.f35824b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f35825c, this.f35824b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f35827e.b(str);
        this.f35827e.c(str2);
        this.f35827e.d(str3);
        return this.f35827e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f35829g.b(str);
        this.f35829g.c(str2);
        this.f35829g.d(str3);
        this.f35829g.a(str4);
        this.f35829g.a(2);
        return this.f35829g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f35829g.b(str);
        this.f35829g.c(str2);
        this.f35829g.d(str3);
        this.f35829g.a(str4);
        this.f35829g.a(i2);
        this.f35829g.b(z);
        return this.f35829g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f35830h.b(str);
        this.f35830h.c(str2);
        this.f35830h.d(str3);
        this.f35830h.e(str4);
        this.f35830h.a(0);
        this.f35830h.a(str5);
        return this.f35830h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f35829g.b(str);
        this.f35829g.c(str2);
        this.f35829g.d(str3);
        this.f35829g.a(str4);
        this.f35829g.a(3);
        this.f35829g.b(z);
        return this.f35829g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f35825c, this.f35824b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f35828f.b(str);
        this.f35828f.c(str2);
        this.f35828f.d(str3);
        return this.f35828f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f35830h.b(str);
        this.f35830h.c(str2);
        this.f35830h.d(str3);
        this.f35830h.e(str4);
        this.f35830h.a(2);
        return this.f35830h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f35830h.b(str);
        this.f35830h.c(str2);
        this.f35830h.d(str3);
        this.f35830h.e(str4);
        this.f35830h.a(1);
        this.f35830h.a(str5);
        return this.f35830h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f35830h.b(str);
        this.f35830h.c(str2);
        this.f35830h.d(str3);
        this.f35830h.e(str4);
        this.f35830h.a(3);
        return this.f35830h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f35831i.b(str);
        this.f35831i.c(str2);
        this.f35831i.d(str3);
        this.f35831i.e(str4);
        this.f35831i.a(0);
        this.f35831i.a(str5);
        return this.f35831i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f35831i.b(str);
        this.f35831i.c(str2);
        this.f35831i.d(str3);
        this.f35831i.e(str4);
        this.f35831i.a(2);
        return this.f35831i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f35831i.b(str);
        this.f35831i.c(str2);
        this.f35831i.d(str3);
        this.f35831i.e(str4);
        this.f35831i.a(1);
        this.f35831i.a(str5);
        return this.f35831i.m();
    }
}
