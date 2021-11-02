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
    public static b f67680a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f67681b;

    /* renamed from: c  reason: collision with root package name */
    public Context f67682c;

    /* renamed from: d  reason: collision with root package name */
    public a f67683d;

    /* renamed from: e  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.platform.b.b f67684e;

    /* renamed from: f  reason: collision with root package name */
    public g f67685f;

    /* renamed from: g  reason: collision with root package name */
    public f f67686g;

    /* renamed from: h  reason: collision with root package name */
    public e f67687h;

    /* renamed from: i  reason: collision with root package name */
    public d f67688i;
    public com.meizu.cloud.pushsdk.platform.b.a j;
    public boolean k;

    public b(Context context, boolean z) {
        this(context, z, true);
    }

    public b(Context context, boolean z, boolean z2) {
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.f67682c = applicationContext;
        this.f67683d = new a(applicationContext);
        if (z) {
            this.f67681b = (ScheduledExecutorService) com.meizu.cloud.pushsdk.c.b.a.b.a();
        }
        this.k = z2;
        this.f67684e = new com.meizu.cloud.pushsdk.platform.b.b(this.f67682c, this.f67683d, this.f67681b, z2);
        this.f67685f = new g(this.f67682c, this.f67683d, this.f67681b, z2);
        this.f67686g = new f(this.f67682c, this.f67683d, this.f67681b, z2);
        this.f67687h = new e(this.f67682c, this.f67683d, this.f67681b, z2);
        this.f67688i = new d(this.f67682c, this.f67683d, this.f67681b, z2);
        this.j = new com.meizu.cloud.pushsdk.platform.b.a(this.f67682c, this.f67681b, z2);
    }

    public static b a(Context context) {
        if (f67680a == null) {
            synchronized (b.class) {
                if (f67680a == null) {
                    f67680a = new b(context, true);
                }
            }
        }
        return f67680a;
    }

    public c<String> a(String str, String str2, String str3, File file) {
        return this.f67683d.a(str, str2, str3, file);
    }

    public void a(boolean z) {
        this.f67684e.a(z);
        this.f67685f.a(z);
        this.f67686g.a(z);
        this.f67688i.a(z);
        this.f67687h.a(z);
    }

    public boolean a(String str) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f67682c, this.f67681b, this.k);
        aVar.a(0);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f67682c, this.f67681b, this.k);
        aVar.a(2);
        aVar.a(str2);
        aVar.d(str);
        return aVar.m();
    }

    public boolean a(String str, String str2, String str3) {
        this.f67684e.b(str);
        this.f67684e.c(str2);
        this.f67684e.d(str3);
        return this.f67684e.m();
    }

    public boolean a(String str, String str2, String str3, String str4) {
        this.f67686g.b(str);
        this.f67686g.c(str2);
        this.f67686g.d(str3);
        this.f67686g.a(str4);
        this.f67686g.a(2);
        return this.f67686g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, int i2, boolean z) {
        this.f67686g.b(str);
        this.f67686g.c(str2);
        this.f67686g.d(str3);
        this.f67686g.a(str4);
        this.f67686g.a(i2);
        this.f67686g.b(z);
        return this.f67686g.m();
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        this.f67687h.b(str);
        this.f67687h.c(str2);
        this.f67687h.d(str3);
        this.f67687h.e(str4);
        this.f67687h.a(0);
        this.f67687h.a(str5);
        return this.f67687h.m();
    }

    public boolean a(String str, String str2, String str3, String str4, boolean z) {
        this.f67686g.b(str);
        this.f67686g.c(str2);
        this.f67686g.d(str3);
        this.f67686g.a(str4);
        this.f67686g.a(3);
        this.f67686g.b(z);
        return this.f67686g.m();
    }

    public boolean a(String str, int... iArr) {
        com.meizu.cloud.pushsdk.platform.b.a aVar = new com.meizu.cloud.pushsdk.platform.b.a(this.f67682c, this.f67681b, this.k);
        aVar.a(iArr);
        aVar.d(str);
        aVar.a(1);
        return aVar.m();
    }

    public boolean b(String str, String str2, String str3) {
        this.f67685f.b(str);
        this.f67685f.c(str2);
        this.f67685f.d(str3);
        return this.f67685f.m();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        this.f67687h.b(str);
        this.f67687h.c(str2);
        this.f67687h.d(str3);
        this.f67687h.e(str4);
        this.f67687h.a(2);
        return this.f67687h.m();
    }

    public boolean b(String str, String str2, String str3, String str4, String str5) {
        this.f67687h.b(str);
        this.f67687h.c(str2);
        this.f67687h.d(str3);
        this.f67687h.e(str4);
        this.f67687h.a(1);
        this.f67687h.a(str5);
        return this.f67687h.m();
    }

    public boolean c(String str, String str2, String str3, String str4) {
        this.f67687h.b(str);
        this.f67687h.c(str2);
        this.f67687h.d(str3);
        this.f67687h.e(str4);
        this.f67687h.a(3);
        return this.f67687h.m();
    }

    public boolean c(String str, String str2, String str3, String str4, String str5) {
        this.f67688i.b(str);
        this.f67688i.c(str2);
        this.f67688i.d(str3);
        this.f67688i.e(str4);
        this.f67688i.a(0);
        this.f67688i.a(str5);
        return this.f67688i.m();
    }

    public boolean d(String str, String str2, String str3, String str4) {
        this.f67688i.b(str);
        this.f67688i.c(str2);
        this.f67688i.d(str3);
        this.f67688i.e(str4);
        this.f67688i.a(2);
        return this.f67688i.m();
    }

    public boolean d(String str, String str2, String str3, String str4, String str5) {
        this.f67688i.b(str);
        this.f67688i.c(str2);
        this.f67688i.d(str3);
        this.f67688i.e(str4);
        this.f67688i.a(1);
        this.f67688i.a(str5);
        return this.f67688i.m();
    }
}
