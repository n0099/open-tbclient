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
    public static b f40537a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f40538b;

    /* renamed from: c  reason: collision with root package name */
    public Context f40539c;

    /* renamed from: d  reason: collision with root package name */
    public a f40540d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f40541e;

    /* renamed from: f  reason: collision with root package name */
    public g f40542f;

    /* renamed from: g  reason: collision with root package name */
    public f f40543g;

    /* renamed from: h  reason: collision with root package name */
    public e f40544h;

    /* renamed from: i  reason: collision with root package name */
    public d f40545i;
    public com.meizu.cloud.pushsdk.platform.b.a j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f40539c = applicationContext;
        this.f40540d = new a(applicationContext);
        if (z) {
            this.f40538b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f40541e = new com.meizu.cloud.pushsdk.platform.b.b(this.f40539c, this.f40540d, this.f40538b, z2);
        this.f40542f = new g(this.f40539c, this.f40540d, this.f40538b, z2);
        this.f40543g = new f(this.f40539c, this.f40540d, this.f40538b, z2);
        this.f40544h = new e(this.f40539c, this.f40540d, this.f40538b, z2);
        this.f40545i = new d(this.f40539c, this.f40540d, this.f40538b, z2);
        this.j = new com.meizu.cloud.pushsdk.platform.b.a(this.f40539c, this.f40538b, z2);
    }

    public static b a(Context context) {
        if (f40537a == null) {
            synchronized (b.class) {
                if (f40537a == null) {
                    f40537a = new b(context, true);
                }
            }
        }
        return f40537a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f40540d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f40541e.a(z);
        this.f40542f.a(z);
        this.f40543g.a(z);
        this.f40545i.a(z);
        this.f40544h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f40539c, this.f40538b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f40539c, this.f40538b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f40541e.b(str);
        this.f40541e.c(str2);
        this.f40541e.d(str3);
        return this.f40541e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f40543g.b(str);
        this.f40543g.c(str2);
        this.f40543g.d(str3);
        this.f40543g.a(str4);
        this.f40543g.a(2);
        return this.f40543g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f40543g.b(str);
        this.f40543g.c(str2);
        this.f40543g.d(str3);
        this.f40543g.a(str4);
        this.f40543g.a(i2);
        this.f40543g.b(z);
        return this.f40543g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f40544h.b(str);
        this.f40544h.c(str2);
        this.f40544h.d(str3);
        this.f40544h.e(str4);
        this.f40544h.a(0);
        this.f40544h.a(str5);
        return this.f40544h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f40543g.b(str);
        this.f40543g.c(str2);
        this.f40543g.d(str3);
        this.f40543g.a(str4);
        this.f40543g.a(3);
        this.f40543g.b(z);
        return this.f40543g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f40539c, this.f40538b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f40542f.b(str);
        this.f40542f.c(str2);
        this.f40542f.d(str3);
        return this.f40542f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f40544h.b(str);
        this.f40544h.c(str2);
        this.f40544h.d(str3);
        this.f40544h.e(str4);
        this.f40544h.a(2);
        return this.f40544h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f40544h.b(str);
        this.f40544h.c(str2);
        this.f40544h.d(str3);
        this.f40544h.e(str4);
        this.f40544h.a(1);
        this.f40544h.a(str5);
        return this.f40544h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f40544h.b(str);
        this.f40544h.c(str2);
        this.f40544h.d(str3);
        this.f40544h.e(str4);
        this.f40544h.a(3);
        return this.f40544h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f40545i.b(str);
        this.f40545i.c(str2);
        this.f40545i.d(str3);
        this.f40545i.e(str4);
        this.f40545i.a(0);
        this.f40545i.a(str5);
        return this.f40545i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f40545i.b(str);
        this.f40545i.c(str2);
        this.f40545i.d(str3);
        this.f40545i.e(str4);
        this.f40545i.a(2);
        return this.f40545i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f40545i.b(str);
        this.f40545i.c(str2);
        this.f40545i.d(str3);
        this.f40545i.e(str4);
        this.f40545i.a(1);
        this.f40545i.a(str5);
        return this.f40545i.m();
    }
}
