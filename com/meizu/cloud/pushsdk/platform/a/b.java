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
    public static b f38676a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f38677b;

    /* renamed from: c  reason: collision with root package name */
    public Context f38678c;

    /* renamed from: d  reason: collision with root package name */
    public a f38679d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f38680e;

    /* renamed from: f  reason: collision with root package name */
    public g f38681f;

    /* renamed from: g  reason: collision with root package name */
    public f f38682g;

    /* renamed from: h  reason: collision with root package name */
    public e f38683h;

    /* renamed from: i  reason: collision with root package name */
    public d f38684i;
    public com.meizu.cloud.pushsdk.platform.b.a j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f38678c = applicationContext;
        this.f38679d = new a(applicationContext);
        if (z) {
            this.f38677b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f38680e = new com.meizu.cloud.pushsdk.platform.b.b(this.f38678c, this.f38679d, this.f38677b, z2);
        this.f38681f = new g(this.f38678c, this.f38679d, this.f38677b, z2);
        this.f38682g = new f(this.f38678c, this.f38679d, this.f38677b, z2);
        this.f38683h = new e(this.f38678c, this.f38679d, this.f38677b, z2);
        this.f38684i = new d(this.f38678c, this.f38679d, this.f38677b, z2);
        this.j = new com.meizu.cloud.pushsdk.platform.b.a(this.f38678c, this.f38677b, z2);
    }

    public static b a(Context context) {
        if (f38676a == null) {
            synchronized (b.class) {
                if (f38676a == null) {
                    f38676a = new b(context, true);
                }
            }
        }
        return f38676a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f38679d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f38680e.a(z);
        this.f38681f.a(z);
        this.f38682g.a(z);
        this.f38684i.a(z);
        this.f38683h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f38678c, this.f38677b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f38678c, this.f38677b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f38680e.b(str);
        this.f38680e.c(str2);
        this.f38680e.d(str3);
        return this.f38680e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f38682g.b(str);
        this.f38682g.c(str2);
        this.f38682g.d(str3);
        this.f38682g.a(str4);
        this.f38682g.a(2);
        return this.f38682g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f38682g.b(str);
        this.f38682g.c(str2);
        this.f38682g.d(str3);
        this.f38682g.a(str4);
        this.f38682g.a(i2);
        this.f38682g.b(z);
        return this.f38682g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f38683h.b(str);
        this.f38683h.c(str2);
        this.f38683h.d(str3);
        this.f38683h.e(str4);
        this.f38683h.a(0);
        this.f38683h.a(str5);
        return this.f38683h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f38682g.b(str);
        this.f38682g.c(str2);
        this.f38682g.d(str3);
        this.f38682g.a(str4);
        this.f38682g.a(3);
        this.f38682g.b(z);
        return this.f38682g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f38678c, this.f38677b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f38681f.b(str);
        this.f38681f.c(str2);
        this.f38681f.d(str3);
        return this.f38681f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f38683h.b(str);
        this.f38683h.c(str2);
        this.f38683h.d(str3);
        this.f38683h.e(str4);
        this.f38683h.a(2);
        return this.f38683h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f38683h.b(str);
        this.f38683h.c(str2);
        this.f38683h.d(str3);
        this.f38683h.e(str4);
        this.f38683h.a(1);
        this.f38683h.a(str5);
        return this.f38683h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f38683h.b(str);
        this.f38683h.c(str2);
        this.f38683h.d(str3);
        this.f38683h.e(str4);
        this.f38683h.a(3);
        return this.f38683h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f38684i.b(str);
        this.f38684i.c(str2);
        this.f38684i.d(str3);
        this.f38684i.e(str4);
        this.f38684i.a(0);
        this.f38684i.a(str5);
        return this.f38684i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f38684i.b(str);
        this.f38684i.c(str2);
        this.f38684i.d(str3);
        this.f38684i.e(str4);
        this.f38684i.a(2);
        return this.f38684i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f38684i.b(str);
        this.f38684i.c(str2);
        this.f38684i.d(str3);
        this.f38684i.e(str4);
        this.f38684i.a(1);
        this.f38684i.a(str5);
        return this.f38684i.m();
    }
}
