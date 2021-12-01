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
    public static b a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f60556b;

    /* renamed from: c  reason: collision with root package name */
    public Context f60557c;

    /* renamed from: d  reason: collision with root package name */
    public a f60558d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f60559e;

    /* renamed from: f  reason: collision with root package name */
    public g f60560f;

    /* renamed from: g  reason: collision with root package name */
    public f f60561g;

    /* renamed from: h  reason: collision with root package name */
    public e f60562h;

    /* renamed from: i  reason: collision with root package name */
    public d f60563i;

    /* renamed from: j  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.a f60564j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f60565k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.f60565k = true;
        Context applicationContext = context.getApplicationContext();
        this.f60557c = applicationContext;
        this.f60558d = new a(applicationContext);
        if (z) {
            this.f60556b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.f60565k = z2;
        this.f60559e = new com.meizu.cloud.pushsdk.platform.b.b(this.f60557c, this.f60558d, this.f60556b, z2);
        this.f60560f = new g(this.f60557c, this.f60558d, this.f60556b, z2);
        this.f60561g = new f(this.f60557c, this.f60558d, this.f60556b, z2);
        this.f60562h = new e(this.f60557c, this.f60558d, this.f60556b, z2);
        this.f60563i = new d(this.f60557c, this.f60558d, this.f60556b, z2);
        this.f60564j = new com.meizu.cloud.pushsdk.platform.b.a(this.f60557c, this.f60556b, z2);
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
        return this.f60558d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f60559e.a(z);
        this.f60560f.a(z);
        this.f60561g.a(z);
        this.f60563i.a(z);
        this.f60562h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f60557c, this.f60556b, this.f60565k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f60557c, this.f60556b, this.f60565k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f60559e.b(str);
        this.f60559e.c(str2);
        this.f60559e.d(str3);
        return this.f60559e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f60561g.b(str);
        this.f60561g.c(str2);
        this.f60561g.d(str3);
        this.f60561g.a(str4);
        this.f60561g.a(2);
        return this.f60561g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f60561g.b(str);
        this.f60561g.c(str2);
        this.f60561g.d(str3);
        this.f60561g.a(str4);
        this.f60561g.a(i2);
        this.f60561g.b(z);
        return this.f60561g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f60562h.b(str);
        this.f60562h.c(str2);
        this.f60562h.d(str3);
        this.f60562h.e(str4);
        this.f60562h.a(0);
        this.f60562h.a(str5);
        return this.f60562h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f60561g.b(str);
        this.f60561g.c(str2);
        this.f60561g.d(str3);
        this.f60561g.a(str4);
        this.f60561g.a(3);
        this.f60561g.b(z);
        return this.f60561g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f60557c, this.f60556b, this.f60565k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f60560f.b(str);
        this.f60560f.c(str2);
        this.f60560f.d(str3);
        return this.f60560f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f60562h.b(str);
        this.f60562h.c(str2);
        this.f60562h.d(str3);
        this.f60562h.e(str4);
        this.f60562h.a(2);
        return this.f60562h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f60562h.b(str);
        this.f60562h.c(str2);
        this.f60562h.d(str3);
        this.f60562h.e(str4);
        this.f60562h.a(1);
        this.f60562h.a(str5);
        return this.f60562h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f60562h.b(str);
        this.f60562h.c(str2);
        this.f60562h.d(str3);
        this.f60562h.e(str4);
        this.f60562h.a(3);
        return this.f60562h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f60563i.b(str);
        this.f60563i.c(str2);
        this.f60563i.d(str3);
        this.f60563i.e(str4);
        this.f60563i.a(0);
        this.f60563i.a(str5);
        return this.f60563i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f60563i.b(str);
        this.f60563i.c(str2);
        this.f60563i.d(str3);
        this.f60563i.e(str4);
        this.f60563i.a(2);
        return this.f60563i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f60563i.b(str);
        this.f60563i.c(str2);
        this.f60563i.d(str3);
        this.f60563i.e(str4);
        this.f60563i.a(1);
        this.f60563i.a(str5);
        return this.f60563i.m();
    }
}
