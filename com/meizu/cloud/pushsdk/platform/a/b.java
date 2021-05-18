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
    public static b f35068a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f35069b;

    /* renamed from: c  reason: collision with root package name */
    public Context f35070c;

    /* renamed from: d  reason: collision with root package name */
    public a f35071d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f35072e;

    /* renamed from: f  reason: collision with root package name */
    public g f35073f;

    /* renamed from: g  reason: collision with root package name */
    public f f35074g;

    /* renamed from: h  reason: collision with root package name */
    public e f35075h;

    /* renamed from: i  reason: collision with root package name */
    public d f35076i;
    public com.meizu.cloud.pushsdk.platform.b.a j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f35070c = applicationContext;
        this.f35071d = new a(applicationContext);
        if (z) {
            this.f35069b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f35072e = new com.meizu.cloud.pushsdk.platform.b.b(this.f35070c, this.f35071d, this.f35069b, z2);
        this.f35073f = new g(this.f35070c, this.f35071d, this.f35069b, z2);
        this.f35074g = new f(this.f35070c, this.f35071d, this.f35069b, z2);
        this.f35075h = new e(this.f35070c, this.f35071d, this.f35069b, z2);
        this.f35076i = new d(this.f35070c, this.f35071d, this.f35069b, z2);
        this.j = new com.meizu.cloud.pushsdk.platform.b.a(this.f35070c, this.f35069b, z2);
    }

    public static b a(Context context) {
        if (f35068a == null) {
            synchronized (b.class) {
                if (f35068a == null) {
                    f35068a = new b(context, true);
                }
            }
        }
        return f35068a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f35071d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f35072e.a(z);
        this.f35073f.a(z);
        this.f35074g.a(z);
        this.f35076i.a(z);
        this.f35075h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f35070c, this.f35069b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f35070c, this.f35069b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f35072e.b(str);
        this.f35072e.c(str2);
        this.f35072e.d(str3);
        return this.f35072e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f35074g.b(str);
        this.f35074g.c(str2);
        this.f35074g.d(str3);
        this.f35074g.a(str4);
        this.f35074g.a(2);
        return this.f35074g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f35074g.b(str);
        this.f35074g.c(str2);
        this.f35074g.d(str3);
        this.f35074g.a(str4);
        this.f35074g.a(i2);
        this.f35074g.b(z);
        return this.f35074g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f35075h.b(str);
        this.f35075h.c(str2);
        this.f35075h.d(str3);
        this.f35075h.e(str4);
        this.f35075h.a(0);
        this.f35075h.a(str5);
        return this.f35075h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f35074g.b(str);
        this.f35074g.c(str2);
        this.f35074g.d(str3);
        this.f35074g.a(str4);
        this.f35074g.a(3);
        this.f35074g.b(z);
        return this.f35074g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f35070c, this.f35069b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f35073f.b(str);
        this.f35073f.c(str2);
        this.f35073f.d(str3);
        return this.f35073f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f35075h.b(str);
        this.f35075h.c(str2);
        this.f35075h.d(str3);
        this.f35075h.e(str4);
        this.f35075h.a(2);
        return this.f35075h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f35075h.b(str);
        this.f35075h.c(str2);
        this.f35075h.d(str3);
        this.f35075h.e(str4);
        this.f35075h.a(1);
        this.f35075h.a(str5);
        return this.f35075h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f35075h.b(str);
        this.f35075h.c(str2);
        this.f35075h.d(str3);
        this.f35075h.e(str4);
        this.f35075h.a(3);
        return this.f35075h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f35076i.b(str);
        this.f35076i.c(str2);
        this.f35076i.d(str3);
        this.f35076i.e(str4);
        this.f35076i.a(0);
        this.f35076i.a(str5);
        return this.f35076i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f35076i.b(str);
        this.f35076i.c(str2);
        this.f35076i.d(str3);
        this.f35076i.e(str4);
        this.f35076i.a(2);
        return this.f35076i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f35076i.b(str);
        this.f35076i.c(str2);
        this.f35076i.d(str3);
        this.f35076i.e(str4);
        this.f35076i.a(1);
        this.f35076i.a(str5);
        return this.f35076i.m();
    }
}
