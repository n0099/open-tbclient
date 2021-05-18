package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.d;
import java.io.File;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f36442a = null;

    /* renamed from: c  reason: collision with root package name */
    public static final b f36443c = new b(c(), c.m, c.f36435g, c.f36436h, c.f36431c, c.f36437i, 10, c.f36433e, c.n);

    /* renamed from: d  reason: collision with root package name */
    public static boolean f36444d = false;

    /* renamed from: b  reason: collision with root package name */
    public a f36445b = new a(f36443c);

    public static f a() {
        if (f36442a == null) {
            synchronized (f.class) {
                if (f36442a == null) {
                    f36442a = new f();
                    f36444d = true;
                }
            }
        }
        return f36442a;
    }

    public static final void b(String str, String str2) {
        a().a(2, str, str2, null);
    }

    public static final void c(String str, String str2) {
        a().a(4, str, str2, null);
    }

    public static final void d(String str, String str2) {
        a().a(8, str, str2, null);
    }

    public static final void e(String str, String str2) {
        a().a(16, str, str2, null);
    }

    public static final void b(String str, String str2, Throwable th) {
        a().a(16, str, str2, th);
    }

    public static File c() {
        String str = c.f36432d;
        boolean z = false;
        try {
            d.c b2 = d.b.b();
            if (b2 != null) {
                if (b2.c() > c.f36434f) {
                    z = true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (z) {
            return new File(Environment.getExternalStorageDirectory(), str);
        }
        return new File(com.tencent.open.utils.e.c(), str);
    }

    public void d() {
        a aVar = this.f36445b;
        if (aVar != null) {
            aVar.a();
            this.f36445b.b();
            this.f36445b = null;
        }
    }

    public static void b() {
        synchronized (f.class) {
            a().d();
            if (f36442a != null) {
                f36442a = null;
            }
        }
    }

    public void a(int i2, String str, String str2, Throwable th) {
        a aVar;
        if (f36444d) {
            String b2 = com.tencent.open.utils.e.b();
            if (!TextUtils.isEmpty(b2)) {
                String str3 = b2 + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.f36445b == null) {
                    return;
                }
                e.f36441a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                this.f36445b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                f36444d = false;
            }
        }
        e.f36441a.b(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (!d.a.a(c.f36430b, i2) || (aVar = this.f36445b) == null) {
            return;
        }
        aVar.b(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
    }

    public static final void a(String str, String str2) {
        a().a(1, str, str2, null);
    }

    public static final void a(String str, String str2, Throwable th) {
        a().a(2, str, str2, th);
    }
}
