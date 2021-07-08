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
    public static b f37551a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f37552b;

    /* renamed from: c  reason: collision with root package name */
    public Context f37553c;

    /* renamed from: d  reason: collision with root package name */
    public a f37554d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f37555e;

    /* renamed from: f  reason: collision with root package name */
    public g f37556f;

    /* renamed from: g  reason: collision with root package name */
    public f f37557g;

    /* renamed from: h  reason: collision with root package name */
    public e f37558h;

    /* renamed from: i  reason: collision with root package name */
    public d f37559i;
    public com.meizu.cloud.pushsdk.platform.b.a j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f37553c = applicationContext;
        this.f37554d = new a(applicationContext);
        if (z) {
            this.f37552b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f37555e = new com.meizu.cloud.pushsdk.platform.b.b(this.f37553c, this.f37554d, this.f37552b, z2);
        this.f37556f = new g(this.f37553c, this.f37554d, this.f37552b, z2);
        this.f37557g = new f(this.f37553c, this.f37554d, this.f37552b, z2);
        this.f37558h = new e(this.f37553c, this.f37554d, this.f37552b, z2);
        this.f37559i = new d(this.f37553c, this.f37554d, this.f37552b, z2);
        this.j = new com.meizu.cloud.pushsdk.platform.b.a(this.f37553c, this.f37552b, z2);
    }

    public static b a(Context context) {
        if (f37551a == null) {
            synchronized (b.class) {
                if (f37551a == null) {
                    f37551a = new b(context, true);
                }
            }
        }
        return f37551a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f37554d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f37555e.a(z);
        this.f37556f.a(z);
        this.f37557g.a(z);
        this.f37559i.a(z);
        this.f37558h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f37553c, this.f37552b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f37553c, this.f37552b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f37555e.b(str);
        this.f37555e.c(str2);
        this.f37555e.d(str3);
        return this.f37555e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f37557g.b(str);
        this.f37557g.c(str2);
        this.f37557g.d(str3);
        this.f37557g.a(str4);
        this.f37557g.a(2);
        return this.f37557g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f37557g.b(str);
        this.f37557g.c(str2);
        this.f37557g.d(str3);
        this.f37557g.a(str4);
        this.f37557g.a(i2);
        this.f37557g.b(z);
        return this.f37557g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f37558h.b(str);
        this.f37558h.c(str2);
        this.f37558h.d(str3);
        this.f37558h.e(str4);
        this.f37558h.a(0);
        this.f37558h.a(str5);
        return this.f37558h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f37557g.b(str);
        this.f37557g.c(str2);
        this.f37557g.d(str3);
        this.f37557g.a(str4);
        this.f37557g.a(3);
        this.f37557g.b(z);
        return this.f37557g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f37553c, this.f37552b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f37556f.b(str);
        this.f37556f.c(str2);
        this.f37556f.d(str3);
        return this.f37556f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f37558h.b(str);
        this.f37558h.c(str2);
        this.f37558h.d(str3);
        this.f37558h.e(str4);
        this.f37558h.a(2);
        return this.f37558h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f37558h.b(str);
        this.f37558h.c(str2);
        this.f37558h.d(str3);
        this.f37558h.e(str4);
        this.f37558h.a(1);
        this.f37558h.a(str5);
        return this.f37558h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f37558h.b(str);
        this.f37558h.c(str2);
        this.f37558h.d(str3);
        this.f37558h.e(str4);
        this.f37558h.a(3);
        return this.f37558h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f37559i.b(str);
        this.f37559i.c(str2);
        this.f37559i.d(str3);
        this.f37559i.e(str4);
        this.f37559i.a(0);
        this.f37559i.a(str5);
        return this.f37559i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f37559i.b(str);
        this.f37559i.c(str2);
        this.f37559i.d(str3);
        this.f37559i.e(str4);
        this.f37559i.a(2);
        return this.f37559i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f37559i.b(str);
        this.f37559i.c(str2);
        this.f37559i.d(str3);
        this.f37559i.e(str4);
        this.f37559i.a(1);
        this.f37559i.a(str5);
        return this.f37559i.m();
    }
}
