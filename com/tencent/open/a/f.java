package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.d;
import java.io.File;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f36371a = null;

    /* renamed from: c  reason: collision with root package name */
    public static final b f36372c = new b(c(), c.m, c.f36364g, c.f36365h, c.f36360c, c.f36366i, 10, c.f36362e, c.n);

    /* renamed from: d  reason: collision with root package name */
    public static boolean f36373d = false;

    /* renamed from: b  reason: collision with root package name */
    public a f36374b = new a(f36372c);

    public static f a() {
        if (f36371a == null) {
            synchronized (f.class) {
                if (f36371a == null) {
                    f36371a = new f();
                    f36373d = true;
                }
            }
        }
        return f36371a;
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
        String str = c.f36361d;
        boolean z = false;
        try {
            d.c b2 = d.b.b();
            if (b2 != null) {
                if (b2.c() > c.f36363f) {
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
        a aVar = this.f36374b;
        if (aVar != null) {
            aVar.a();
            this.f36374b.b();
            this.f36374b = null;
        }
    }

    public static void b() {
        synchronized (f.class) {
            a().d();
            if (f36371a != null) {
                f36371a = null;
            }
        }
    }

    public void a(int i2, String str, String str2, Throwable th) {
        a aVar;
        if (f36373d) {
            String b2 = com.tencent.open.utils.e.b();
            if (!TextUtils.isEmpty(b2)) {
                String str3 = b2 + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.f36374b == null) {
                    return;
                }
                e.f36370a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                this.f36374b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                f36373d = false;
            }
        }
        e.f36370a.b(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (!d.a.a(c.f36359b, i2) || (aVar = this.f36374b) == null) {
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
