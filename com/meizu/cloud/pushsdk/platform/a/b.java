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
    public static b f75288a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f75289b;

    /* renamed from: c  reason: collision with root package name */
    public Context f75290c;

    /* renamed from: d  reason: collision with root package name */
    public a f75291d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f75292e;

    /* renamed from: f  reason: collision with root package name */
    public g f75293f;

    /* renamed from: g  reason: collision with root package name */
    public f f75294g;

    /* renamed from: h  reason: collision with root package name */
    public e f75295h;

    /* renamed from: i  reason: collision with root package name */
    public d f75296i;

    /* renamed from: j  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.a f75297j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f75290c = applicationContext;
        this.f75291d = new a(applicationContext);
        if (z) {
            this.f75289b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f75292e = new com.meizu.cloud.pushsdk.platform.b.b(this.f75290c, this.f75291d, this.f75289b, z2);
        this.f75293f = new g(this.f75290c, this.f75291d, this.f75289b, z2);
        this.f75294g = new f(this.f75290c, this.f75291d, this.f75289b, z2);
        this.f75295h = new e(this.f75290c, this.f75291d, this.f75289b, z2);
        this.f75296i = new d(this.f75290c, this.f75291d, this.f75289b, z2);
        this.f75297j = new com.meizu.cloud.pushsdk.platform.b.a(this.f75290c, this.f75289b, z2);
    }

    public static b a(Context context) {
        if (f75288a == null) {
            synchronized (b.class) {
                if (f75288a == null) {
                    f75288a = new b(context, true);
                }
            }
        }
        return f75288a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f75291d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f75292e.a(z);
        this.f75293f.a(z);
        this.f75294g.a(z);
        this.f75296i.a(z);
        this.f75295h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f75290c, this.f75289b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f75290c, this.f75289b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f75292e.b(str);
        this.f75292e.c(str2);
        this.f75292e.d(str3);
        return this.f75292e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f75294g.b(str);
        this.f75294g.c(str2);
        this.f75294g.d(str3);
        this.f75294g.a(str4);
        this.f75294g.a(2);
        return this.f75294g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f75294g.b(str);
        this.f75294g.c(str2);
        this.f75294g.d(str3);
        this.f75294g.a(str4);
        this.f75294g.a(i2);
        this.f75294g.b(z);
        return this.f75294g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f75295h.b(str);
        this.f75295h.c(str2);
        this.f75295h.d(str3);
        this.f75295h.e(str4);
        this.f75295h.a(0);
        this.f75295h.a(str5);
        return this.f75295h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f75294g.b(str);
        this.f75294g.c(str2);
        this.f75294g.d(str3);
        this.f75294g.a(str4);
        this.f75294g.a(3);
        this.f75294g.b(z);
        return this.f75294g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f75290c, this.f75289b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f75293f.b(str);
        this.f75293f.c(str2);
        this.f75293f.d(str3);
        return this.f75293f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f75295h.b(str);
        this.f75295h.c(str2);
        this.f75295h.d(str3);
        this.f75295h.e(str4);
        this.f75295h.a(2);
        return this.f75295h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f75295h.b(str);
        this.f75295h.c(str2);
        this.f75295h.d(str3);
        this.f75295h.e(str4);
        this.f75295h.a(1);
        this.f75295h.a(str5);
        return this.f75295h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f75295h.b(str);
        this.f75295h.c(str2);
        this.f75295h.d(str3);
        this.f75295h.e(str4);
        this.f75295h.a(3);
        return this.f75295h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f75296i.b(str);
        this.f75296i.c(str2);
        this.f75296i.d(str3);
        this.f75296i.e(str4);
        this.f75296i.a(0);
        this.f75296i.a(str5);
        return this.f75296i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f75296i.b(str);
        this.f75296i.c(str2);
        this.f75296i.d(str3);
        this.f75296i.e(str4);
        this.f75296i.a(2);
        return this.f75296i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f75296i.b(str);
        this.f75296i.c(str2);
        this.f75296i.d(str3);
        this.f75296i.e(str4);
        this.f75296i.a(1);
        this.f75296i.a(str5);
        return this.f75296i.m();
    }
}
