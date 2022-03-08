package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import com.meizu.cloud.pushsdk.b.a.c;
import com.meizu.cloud.pushsdk.platform.b.d;
import com.meizu.cloud.pushsdk.platform.b.e;
import com.meizu.cloud.pushsdk.platform.b.f;
import com.meizu.cloud.pushsdk.platform.b.g;
import java.io.File;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes8.dex */
public class b {
    public static b a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f57385b;

    /* renamed from: c  reason: collision with root package name */
    public Context f57386c;

    /* renamed from: d  reason: collision with root package name */
    public a f57387d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f57388e;

    /* renamed from: f  reason: collision with root package name */
    public g f57389f;

    /* renamed from: g  reason: collision with root package name */
    public f f57390g;

    /* renamed from: h  reason: collision with root package name */
    public e f57391h;

    /* renamed from: i  reason: collision with root package name */
    public d f57392i;

    /* renamed from: j  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.a f57393j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f57386c = applicationContext;
        this.f57387d = new a(applicationContext);
        if (z) {
            this.f57385b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f57388e = new com.meizu.cloud.pushsdk.platform.b.b(this.f57386c, this.f57387d, this.f57385b, z2);
        this.f57389f = new g(this.f57386c, this.f57387d, this.f57385b, z2);
        this.f57390g = new f(this.f57386c, this.f57387d, this.f57385b, z2);
        this.f57391h = new e(this.f57386c, this.f57387d, this.f57385b, z2);
        this.f57392i = new d(this.f57386c, this.f57387d, this.f57385b, z2);
        this.f57393j = new com.meizu.cloud.pushsdk.platform.b.a(this.f57386c, this.f57385b, z2);
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
        return this.f57387d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f57388e.a(z);
        this.f57389f.a(z);
        this.f57390g.a(z);
        this.f57392i.a(z);
        this.f57391h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f57386c, this.f57385b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f57386c, this.f57385b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f57388e.b(str);
        this.f57388e.c(str2);
        this.f57388e.d(str3);
        return this.f57388e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f57390g.b(str);
        this.f57390g.c(str2);
        this.f57390g.d(str3);
        this.f57390g.a(str4);
        this.f57390g.a(2);
        return this.f57390g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f57390g.b(str);
        this.f57390g.c(str2);
        this.f57390g.d(str3);
        this.f57390g.a(str4);
        this.f57390g.a(i2);
        this.f57390g.b(z);
        return this.f57390g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f57391h.b(str);
        this.f57391h.c(str2);
        this.f57391h.d(str3);
        this.f57391h.e(str4);
        this.f57391h.a(0);
        this.f57391h.a(str5);
        return this.f57391h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f57390g.b(str);
        this.f57390g.c(str2);
        this.f57390g.d(str3);
        this.f57390g.a(str4);
        this.f57390g.a(3);
        this.f57390g.b(z);
        return this.f57390g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f57386c, this.f57385b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f57389f.b(str);
        this.f57389f.c(str2);
        this.f57389f.d(str3);
        return this.f57389f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f57391h.b(str);
        this.f57391h.c(str2);
        this.f57391h.d(str3);
        this.f57391h.e(str4);
        this.f57391h.a(2);
        return this.f57391h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f57391h.b(str);
        this.f57391h.c(str2);
        this.f57391h.d(str3);
        this.f57391h.e(str4);
        this.f57391h.a(1);
        this.f57391h.a(str5);
        return this.f57391h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f57391h.b(str);
        this.f57391h.c(str2);
        this.f57391h.d(str3);
        this.f57391h.e(str4);
        this.f57391h.a(3);
        return this.f57391h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f57392i.b(str);
        this.f57392i.c(str2);
        this.f57392i.d(str3);
        this.f57392i.e(str4);
        this.f57392i.a(0);
        this.f57392i.a(str5);
        return this.f57392i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f57392i.b(str);
        this.f57392i.c(str2);
        this.f57392i.d(str3);
        this.f57392i.e(str4);
        this.f57392i.a(2);
        return this.f57392i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f57392i.b(str);
        this.f57392i.c(str2);
        this.f57392i.d(str3);
        this.f57392i.e(str4);
        this.f57392i.a(1);
        this.f57392i.a(str5);
        return this.f57392i.m();
    }
}
