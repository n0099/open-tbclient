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
    public static b f74589a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f74590b;

    /* renamed from: c  reason: collision with root package name */
    public Context f74591c;

    /* renamed from: d  reason: collision with root package name */
    public a f74592d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f74593e;

    /* renamed from: f  reason: collision with root package name */
    public g f74594f;

    /* renamed from: g  reason: collision with root package name */
    public f f74595g;

    /* renamed from: h  reason: collision with root package name */
    public e f74596h;

    /* renamed from: i  reason: collision with root package name */
    public d f74597i;

    /* renamed from: j  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.a f74598j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f74591c = applicationContext;
        this.f74592d = new a(applicationContext);
        if (z) {
            this.f74590b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f74593e = new com.meizu.cloud.pushsdk.platform.b.b(this.f74591c, this.f74592d, this.f74590b, z2);
        this.f74594f = new g(this.f74591c, this.f74592d, this.f74590b, z2);
        this.f74595g = new f(this.f74591c, this.f74592d, this.f74590b, z2);
        this.f74596h = new e(this.f74591c, this.f74592d, this.f74590b, z2);
        this.f74597i = new d(this.f74591c, this.f74592d, this.f74590b, z2);
        this.f74598j = new com.meizu.cloud.pushsdk.platform.b.a(this.f74591c, this.f74590b, z2);
    }

    public static b a(Context context) {
        if (f74589a == null) {
            synchronized (b.class) {
                if (f74589a == null) {
                    f74589a = new b(context, true);
                }
            }
        }
        return f74589a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f74592d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f74593e.a(z);
        this.f74594f.a(z);
        this.f74595g.a(z);
        this.f74597i.a(z);
        this.f74596h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f74591c, this.f74590b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f74591c, this.f74590b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f74593e.b(str);
        this.f74593e.c(str2);
        this.f74593e.d(str3);
        return this.f74593e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f74595g.b(str);
        this.f74595g.c(str2);
        this.f74595g.d(str3);
        this.f74595g.a(str4);
        this.f74595g.a(2);
        return this.f74595g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f74595g.b(str);
        this.f74595g.c(str2);
        this.f74595g.d(str3);
        this.f74595g.a(str4);
        this.f74595g.a(i2);
        this.f74595g.b(z);
        return this.f74595g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f74596h.b(str);
        this.f74596h.c(str2);
        this.f74596h.d(str3);
        this.f74596h.e(str4);
        this.f74596h.a(0);
        this.f74596h.a(str5);
        return this.f74596h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f74595g.b(str);
        this.f74595g.c(str2);
        this.f74595g.d(str3);
        this.f74595g.a(str4);
        this.f74595g.a(3);
        this.f74595g.b(z);
        return this.f74595g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f74591c, this.f74590b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f74594f.b(str);
        this.f74594f.c(str2);
        this.f74594f.d(str3);
        return this.f74594f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f74596h.b(str);
        this.f74596h.c(str2);
        this.f74596h.d(str3);
        this.f74596h.e(str4);
        this.f74596h.a(2);
        return this.f74596h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f74596h.b(str);
        this.f74596h.c(str2);
        this.f74596h.d(str3);
        this.f74596h.e(str4);
        this.f74596h.a(1);
        this.f74596h.a(str5);
        return this.f74596h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f74596h.b(str);
        this.f74596h.c(str2);
        this.f74596h.d(str3);
        this.f74596h.e(str4);
        this.f74596h.a(3);
        return this.f74596h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f74597i.b(str);
        this.f74597i.c(str2);
        this.f74597i.d(str3);
        this.f74597i.e(str4);
        this.f74597i.a(0);
        this.f74597i.a(str5);
        return this.f74597i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f74597i.b(str);
        this.f74597i.c(str2);
        this.f74597i.d(str3);
        this.f74597i.e(str4);
        this.f74597i.a(2);
        return this.f74597i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f74597i.b(str);
        this.f74597i.c(str2);
        this.f74597i.d(str3);
        this.f74597i.e(str4);
        this.f74597i.a(1);
        this.f74597i.a(str5);
        return this.f74597i.m();
    }
}
