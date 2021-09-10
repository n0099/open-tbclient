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
    public static b f74969a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f74970b;

    /* renamed from: c  reason: collision with root package name */
    public Context f74971c;

    /* renamed from: d  reason: collision with root package name */
    public a f74972d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f74973e;

    /* renamed from: f  reason: collision with root package name */
    public g f74974f;

    /* renamed from: g  reason: collision with root package name */
    public f f74975g;

    /* renamed from: h  reason: collision with root package name */
    public e f74976h;

    /* renamed from: i  reason: collision with root package name */
    public d f74977i;

    /* renamed from: j  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.a f74978j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f74971c = applicationContext;
        this.f74972d = new a(applicationContext);
        if (z) {
            this.f74970b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f74973e = new com.meizu.cloud.pushsdk.platform.b.b(this.f74971c, this.f74972d, this.f74970b, z2);
        this.f74974f = new g(this.f74971c, this.f74972d, this.f74970b, z2);
        this.f74975g = new f(this.f74971c, this.f74972d, this.f74970b, z2);
        this.f74976h = new e(this.f74971c, this.f74972d, this.f74970b, z2);
        this.f74977i = new d(this.f74971c, this.f74972d, this.f74970b, z2);
        this.f74978j = new com.meizu.cloud.pushsdk.platform.b.a(this.f74971c, this.f74970b, z2);
    }

    public static b a(Context context) {
        if (f74969a == null) {
            synchronized (b.class) {
                if (f74969a == null) {
                    f74969a = new b(context, true);
                }
            }
        }
        return f74969a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f74972d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f74973e.a(z);
        this.f74974f.a(z);
        this.f74975g.a(z);
        this.f74977i.a(z);
        this.f74976h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f74971c, this.f74970b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f74971c, this.f74970b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f74973e.b(str);
        this.f74973e.c(str2);
        this.f74973e.d(str3);
        return this.f74973e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f74975g.b(str);
        this.f74975g.c(str2);
        this.f74975g.d(str3);
        this.f74975g.a(str4);
        this.f74975g.a(2);
        return this.f74975g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f74975g.b(str);
        this.f74975g.c(str2);
        this.f74975g.d(str3);
        this.f74975g.a(str4);
        this.f74975g.a(i2);
        this.f74975g.b(z);
        return this.f74975g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f74976h.b(str);
        this.f74976h.c(str2);
        this.f74976h.d(str3);
        this.f74976h.e(str4);
        this.f74976h.a(0);
        this.f74976h.a(str5);
        return this.f74976h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f74975g.b(str);
        this.f74975g.c(str2);
        this.f74975g.d(str3);
        this.f74975g.a(str4);
        this.f74975g.a(3);
        this.f74975g.b(z);
        return this.f74975g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f74971c, this.f74970b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f74974f.b(str);
        this.f74974f.c(str2);
        this.f74974f.d(str3);
        return this.f74974f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f74976h.b(str);
        this.f74976h.c(str2);
        this.f74976h.d(str3);
        this.f74976h.e(str4);
        this.f74976h.a(2);
        return this.f74976h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f74976h.b(str);
        this.f74976h.c(str2);
        this.f74976h.d(str3);
        this.f74976h.e(str4);
        this.f74976h.a(1);
        this.f74976h.a(str5);
        return this.f74976h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f74976h.b(str);
        this.f74976h.c(str2);
        this.f74976h.d(str3);
        this.f74976h.e(str4);
        this.f74976h.a(3);
        return this.f74976h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f74977i.b(str);
        this.f74977i.c(str2);
        this.f74977i.d(str3);
        this.f74977i.e(str4);
        this.f74977i.a(0);
        this.f74977i.a(str5);
        return this.f74977i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f74977i.b(str);
        this.f74977i.c(str2);
        this.f74977i.d(str3);
        this.f74977i.e(str4);
        this.f74977i.a(2);
        return this.f74977i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f74977i.b(str);
        this.f74977i.c(str2);
        this.f74977i.d(str3);
        this.f74977i.e(str4);
        this.f74977i.a(1);
        this.f74977i.a(str5);
        return this.f74977i.m();
    }
}
