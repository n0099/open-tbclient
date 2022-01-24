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
    public ScheduledExecutorService f58868b;

    /* renamed from: c  reason: collision with root package name */
    public Context f58869c;

    /* renamed from: d  reason: collision with root package name */
    public a f58870d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f58871e;

    /* renamed from: f  reason: collision with root package name */
    public g f58872f;

    /* renamed from: g  reason: collision with root package name */
    public f f58873g;

    /* renamed from: h  reason: collision with root package name */
    public e f58874h;

    /* renamed from: i  reason: collision with root package name */
    public d f58875i;

    /* renamed from: j  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.a f58876j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f58869c = applicationContext;
        this.f58870d = new a(applicationContext);
        if (z) {
            this.f58868b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f58871e = new com.meizu.cloud.pushsdk.platform.b.b(this.f58869c, this.f58870d, this.f58868b, z2);
        this.f58872f = new g(this.f58869c, this.f58870d, this.f58868b, z2);
        this.f58873g = new f(this.f58869c, this.f58870d, this.f58868b, z2);
        this.f58874h = new e(this.f58869c, this.f58870d, this.f58868b, z2);
        this.f58875i = new d(this.f58869c, this.f58870d, this.f58868b, z2);
        this.f58876j = new com.meizu.cloud.pushsdk.platform.b.a(this.f58869c, this.f58868b, z2);
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
        return this.f58870d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f58871e.a(z);
        this.f58872f.a(z);
        this.f58873g.a(z);
        this.f58875i.a(z);
        this.f58874h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f58869c, this.f58868b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f58869c, this.f58868b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f58871e.b(str);
        this.f58871e.c(str2);
        this.f58871e.d(str3);
        return this.f58871e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f58873g.b(str);
        this.f58873g.c(str2);
        this.f58873g.d(str3);
        this.f58873g.a(str4);
        this.f58873g.a(2);
        return this.f58873g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f58873g.b(str);
        this.f58873g.c(str2);
        this.f58873g.d(str3);
        this.f58873g.a(str4);
        this.f58873g.a(i2);
        this.f58873g.b(z);
        return this.f58873g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f58874h.b(str);
        this.f58874h.c(str2);
        this.f58874h.d(str3);
        this.f58874h.e(str4);
        this.f58874h.a(0);
        this.f58874h.a(str5);
        return this.f58874h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f58873g.b(str);
        this.f58873g.c(str2);
        this.f58873g.d(str3);
        this.f58873g.a(str4);
        this.f58873g.a(3);
        this.f58873g.b(z);
        return this.f58873g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f58869c, this.f58868b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f58872f.b(str);
        this.f58872f.c(str2);
        this.f58872f.d(str3);
        return this.f58872f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f58874h.b(str);
        this.f58874h.c(str2);
        this.f58874h.d(str3);
        this.f58874h.e(str4);
        this.f58874h.a(2);
        return this.f58874h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f58874h.b(str);
        this.f58874h.c(str2);
        this.f58874h.d(str3);
        this.f58874h.e(str4);
        this.f58874h.a(1);
        this.f58874h.a(str5);
        return this.f58874h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f58874h.b(str);
        this.f58874h.c(str2);
        this.f58874h.d(str3);
        this.f58874h.e(str4);
        this.f58874h.a(3);
        return this.f58874h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f58875i.b(str);
        this.f58875i.c(str2);
        this.f58875i.d(str3);
        this.f58875i.e(str4);
        this.f58875i.a(0);
        this.f58875i.a(str5);
        return this.f58875i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f58875i.b(str);
        this.f58875i.c(str2);
        this.f58875i.d(str3);
        this.f58875i.e(str4);
        this.f58875i.a(2);
        return this.f58875i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f58875i.b(str);
        this.f58875i.c(str2);
        this.f58875i.d(str3);
        this.f58875i.e(str4);
        this.f58875i.a(1);
        this.f58875i.a(str5);
        return this.f58875i.m();
    }
}
