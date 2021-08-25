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
    public static b f74789a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f74790b;

    /* renamed from: c  reason: collision with root package name */
    public Context f74791c;

    /* renamed from: d  reason: collision with root package name */
    public a f74792d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f74793e;

    /* renamed from: f  reason: collision with root package name */
    public g f74794f;

    /* renamed from: g  reason: collision with root package name */
    public f f74795g;

    /* renamed from: h  reason: collision with root package name */
    public e f74796h;

    /* renamed from: i  reason: collision with root package name */
    public d f74797i;

    /* renamed from: j  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.a f74798j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f74791c = applicationContext;
        this.f74792d = new a(applicationContext);
        if (z) {
            this.f74790b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f74793e = new com.meizu.cloud.pushsdk.platform.b.b(this.f74791c, this.f74792d, this.f74790b, z2);
        this.f74794f = new g(this.f74791c, this.f74792d, this.f74790b, z2);
        this.f74795g = new f(this.f74791c, this.f74792d, this.f74790b, z2);
        this.f74796h = new e(this.f74791c, this.f74792d, this.f74790b, z2);
        this.f74797i = new d(this.f74791c, this.f74792d, this.f74790b, z2);
        this.f74798j = new com.meizu.cloud.pushsdk.platform.b.a(this.f74791c, this.f74790b, z2);
    }

    public static b a(Context context) {
        if (f74789a == null) {
            synchronized (b.class) {
                if (f74789a == null) {
                    f74789a = new b(context, true);
                }
            }
        }
        return f74789a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f74792d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f74793e.a(z);
        this.f74794f.a(z);
        this.f74795g.a(z);
        this.f74797i.a(z);
        this.f74796h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f74791c, this.f74790b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f74791c, this.f74790b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f74793e.b(str);
        this.f74793e.c(str2);
        this.f74793e.d(str3);
        return this.f74793e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f74795g.b(str);
        this.f74795g.c(str2);
        this.f74795g.d(str3);
        this.f74795g.a(str4);
        this.f74795g.a(2);
        return this.f74795g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f74795g.b(str);
        this.f74795g.c(str2);
        this.f74795g.d(str3);
        this.f74795g.a(str4);
        this.f74795g.a(i2);
        this.f74795g.b(z);
        return this.f74795g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f74796h.b(str);
        this.f74796h.c(str2);
        this.f74796h.d(str3);
        this.f74796h.e(str4);
        this.f74796h.a(0);
        this.f74796h.a(str5);
        return this.f74796h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f74795g.b(str);
        this.f74795g.c(str2);
        this.f74795g.d(str3);
        this.f74795g.a(str4);
        this.f74795g.a(3);
        this.f74795g.b(z);
        return this.f74795g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f74791c, this.f74790b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f74794f.b(str);
        this.f74794f.c(str2);
        this.f74794f.d(str3);
        return this.f74794f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f74796h.b(str);
        this.f74796h.c(str2);
        this.f74796h.d(str3);
        this.f74796h.e(str4);
        this.f74796h.a(2);
        return this.f74796h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f74796h.b(str);
        this.f74796h.c(str2);
        this.f74796h.d(str3);
        this.f74796h.e(str4);
        this.f74796h.a(1);
        this.f74796h.a(str5);
        return this.f74796h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f74796h.b(str);
        this.f74796h.c(str2);
        this.f74796h.d(str3);
        this.f74796h.e(str4);
        this.f74796h.a(3);
        return this.f74796h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f74797i.b(str);
        this.f74797i.c(str2);
        this.f74797i.d(str3);
        this.f74797i.e(str4);
        this.f74797i.a(0);
        this.f74797i.a(str5);
        return this.f74797i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f74797i.b(str);
        this.f74797i.c(str2);
        this.f74797i.d(str3);
        this.f74797i.e(str4);
        this.f74797i.a(2);
        return this.f74797i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f74797i.b(str);
        this.f74797i.c(str2);
        this.f74797i.d(str3);
        this.f74797i.e(str4);
        this.f74797i.a(1);
        this.f74797i.a(str5);
        return this.f74797i.m();
    }
}
