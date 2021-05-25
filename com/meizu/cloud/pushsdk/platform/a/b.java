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
    public static b f34997a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f34998b;

    /* renamed from: c  reason: collision with root package name */
    public Context f34999c;

    /* renamed from: d  reason: collision with root package name */
    public a f35000d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f35001e;

    /* renamed from: f  reason: collision with root package name */
    public g f35002f;

    /* renamed from: g  reason: collision with root package name */
    public f f35003g;

    /* renamed from: h  reason: collision with root package name */
    public e f35004h;

    /* renamed from: i  reason: collision with root package name */
    public d f35005i;
    public com.meizu.cloud.pushsdk.platform.b.a j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f34999c = applicationContext;
        this.f35000d = new a(applicationContext);
        if (z) {
            this.f34998b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f35001e = new com.meizu.cloud.pushsdk.platform.b.b(this.f34999c, this.f35000d, this.f34998b, z2);
        this.f35002f = new g(this.f34999c, this.f35000d, this.f34998b, z2);
        this.f35003g = new f(this.f34999c, this.f35000d, this.f34998b, z2);
        this.f35004h = new e(this.f34999c, this.f35000d, this.f34998b, z2);
        this.f35005i = new d(this.f34999c, this.f35000d, this.f34998b, z2);
        this.j = new com.meizu.cloud.pushsdk.platform.b.a(this.f34999c, this.f34998b, z2);
    }

    public static b a(Context context) {
        if (f34997a == null) {
            synchronized (b.class) {
                if (f34997a == null) {
                    f34997a = new b(context, true);
                }
            }
        }
        return f34997a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f35000d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f35001e.a(z);
        this.f35002f.a(z);
        this.f35003g.a(z);
        this.f35005i.a(z);
        this.f35004h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f34999c, this.f34998b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f34999c, this.f34998b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f35001e.b(str);
        this.f35001e.c(str2);
        this.f35001e.d(str3);
        return this.f35001e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f35003g.b(str);
        this.f35003g.c(str2);
        this.f35003g.d(str3);
        this.f35003g.a(str4);
        this.f35003g.a(2);
        return this.f35003g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f35003g.b(str);
        this.f35003g.c(str2);
        this.f35003g.d(str3);
        this.f35003g.a(str4);
        this.f35003g.a(i2);
        this.f35003g.b(z);
        return this.f35003g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f35004h.b(str);
        this.f35004h.c(str2);
        this.f35004h.d(str3);
        this.f35004h.e(str4);
        this.f35004h.a(0);
        this.f35004h.a(str5);
        return this.f35004h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f35003g.b(str);
        this.f35003g.c(str2);
        this.f35003g.d(str3);
        this.f35003g.a(str4);
        this.f35003g.a(3);
        this.f35003g.b(z);
        return this.f35003g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f34999c, this.f34998b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f35002f.b(str);
        this.f35002f.c(str2);
        this.f35002f.d(str3);
        return this.f35002f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f35004h.b(str);
        this.f35004h.c(str2);
        this.f35004h.d(str3);
        this.f35004h.e(str4);
        this.f35004h.a(2);
        return this.f35004h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f35004h.b(str);
        this.f35004h.c(str2);
        this.f35004h.d(str3);
        this.f35004h.e(str4);
        this.f35004h.a(1);
        this.f35004h.a(str5);
        return this.f35004h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f35004h.b(str);
        this.f35004h.c(str2);
        this.f35004h.d(str3);
        this.f35004h.e(str4);
        this.f35004h.a(3);
        return this.f35004h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f35005i.b(str);
        this.f35005i.c(str2);
        this.f35005i.d(str3);
        this.f35005i.e(str4);
        this.f35005i.a(0);
        this.f35005i.a(str5);
        return this.f35005i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f35005i.b(str);
        this.f35005i.c(str2);
        this.f35005i.d(str3);
        this.f35005i.e(str4);
        this.f35005i.a(2);
        return this.f35005i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f35005i.b(str);
        this.f35005i.c(str2);
        this.f35005i.d(str3);
        this.f35005i.e(str4);
        this.f35005i.a(1);
        this.f35005i.a(str5);
        return this.f35005i.m();
    }
}
