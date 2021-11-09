package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import com.meizu.cloud.pushsdk.b.a.c;
import com.meizu.cloud.pushsdk.platform.b.d;
import com.meizu.cloud.pushsdk.platform.b.e;
import com.meizu.cloud.pushsdk.platform.b.f;
import com.meizu.cloud.pushsdk.platform.b.g;
import java.io.File;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f67679a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f67680b;

    /* renamed from: c  reason: collision with root package name */
    public Context f67681c;

    /* renamed from: d  reason: collision with root package name */
    public a f67682d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f67683e;

    /* renamed from: f  reason: collision with root package name */
    public g f67684f;

    /* renamed from: g  reason: collision with root package name */
    public f f67685g;

    /* renamed from: h  reason: collision with root package name */
    public e f67686h;

    /* renamed from: i  reason: collision with root package name */
    public d f67687i;
    public com.meizu.cloud.pushsdk.platform.b.a j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f67681c = applicationContext;
        this.f67682d = new a(applicationContext);
        if (z) {
            this.f67680b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f67683e = new com.meizu.cloud.pushsdk.platform.b.b(this.f67681c, this.f67682d, this.f67680b, z2);
        this.f67684f = new g(this.f67681c, this.f67682d, this.f67680b, z2);
        this.f67685g = new f(this.f67681c, this.f67682d, this.f67680b, z2);
        this.f67686h = new e(this.f67681c, this.f67682d, this.f67680b, z2);
        this.f67687i = new d(this.f67681c, this.f67682d, this.f67680b, z2);
        this.j = new com.meizu.cloud.pushsdk.platform.b.a(this.f67681c, this.f67680b, z2);
    }

    public static b a(Context context) {
        if (f67679a == null) {
            synchronized (b.class) {
                if (f67679a == null) {
                    f67679a = new b(context, true);
                }
            }
        }
        return f67679a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f67682d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f67683e.a(z);
        this.f67684f.a(z);
        this.f67685g.a(z);
        this.f67687i.a(z);
        this.f67686h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f67681c, this.f67680b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f67681c, this.f67680b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f67683e.b(str);
        this.f67683e.c(str2);
        this.f67683e.d(str3);
        return this.f67683e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f67685g.b(str);
        this.f67685g.c(str2);
        this.f67685g.d(str3);
        this.f67685g.a(str4);
        this.f67685g.a(2);
        return this.f67685g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f67685g.b(str);
        this.f67685g.c(str2);
        this.f67685g.d(str3);
        this.f67685g.a(str4);
        this.f67685g.a(i2);
        this.f67685g.b(z);
        return this.f67685g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f67686h.b(str);
        this.f67686h.c(str2);
        this.f67686h.d(str3);
        this.f67686h.e(str4);
        this.f67686h.a(0);
        this.f67686h.a(str5);
        return this.f67686h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f67685g.b(str);
        this.f67685g.c(str2);
        this.f67685g.d(str3);
        this.f67685g.a(str4);
        this.f67685g.a(3);
        this.f67685g.b(z);
        return this.f67685g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f67681c, this.f67680b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f67684f.b(str);
        this.f67684f.c(str2);
        this.f67684f.d(str3);
        return this.f67684f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f67686h.b(str);
        this.f67686h.c(str2);
        this.f67686h.d(str3);
        this.f67686h.e(str4);
        this.f67686h.a(2);
        return this.f67686h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f67686h.b(str);
        this.f67686h.c(str2);
        this.f67686h.d(str3);
        this.f67686h.e(str4);
        this.f67686h.a(1);
        this.f67686h.a(str5);
        return this.f67686h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f67686h.b(str);
        this.f67686h.c(str2);
        this.f67686h.d(str3);
        this.f67686h.e(str4);
        this.f67686h.a(3);
        return this.f67686h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f67687i.b(str);
        this.f67687i.c(str2);
        this.f67687i.d(str3);
        this.f67687i.e(str4);
        this.f67687i.a(0);
        this.f67687i.a(str5);
        return this.f67687i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f67687i.b(str);
        this.f67687i.c(str2);
        this.f67687i.d(str3);
        this.f67687i.e(str4);
        this.f67687i.a(2);
        return this.f67687i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f67687i.b(str);
        this.f67687i.c(str2);
        this.f67687i.d(str3);
        this.f67687i.e(str4);
        this.f67687i.a(1);
        this.f67687i.a(str5);
        return this.f67687i.m();
    }
}
