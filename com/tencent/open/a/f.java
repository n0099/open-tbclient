package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.d;
import java.io.File;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f40050a = null;

    /* renamed from: c  reason: collision with root package name */
    public static final b f40051c = new b(c(), c.m, c.f40043g, c.f40044h, c.f40039c, c.f40045i, 10, c.f40041e, c.n);

    /* renamed from: d  reason: collision with root package name */
    public static boolean f40052d = false;

    /* renamed from: b  reason: collision with root package name */
    public a f40053b = new a(f40051c);

    public static f a() {
        if (f40050a == null) {
            synchronized (f.class) {
                if (f40050a == null) {
                    f40050a = new f();
                    f40052d = true;
                }
            }
        }
        return f40050a;
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
        String str = c.f40040d;
        boolean z = false;
        try {
            d.c b2 = d.b.b();
            if (b2 != null) {
                if (b2.c() > c.f40042f) {
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
        a aVar = this.f40053b;
        if (aVar != null) {
            aVar.a();
            this.f40053b.b();
            this.f40053b = null;
        }
    }

    public static void b() {
        synchronized (f.class) {
            a().d();
            if (f40050a != null) {
                f40050a = null;
            }
        }
    }

    public void a(int i2, String str, String str2, Throwable th) {
        a aVar;
        if (f40052d) {
            String b2 = com.tencent.open.utils.e.b();
            if (!TextUtils.isEmpty(b2)) {
                String str3 = b2 + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.f40053b == null) {
                    return;
                }
                e.f40049a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                this.f40053b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                f40052d = false;
            }
        }
        e.f40049a.b(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (!d.a.a(c.f40038b, i2) || (aVar = this.f40053b) == null) {
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
