package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.d;
import java.io.File;
/* loaded from: classes14.dex */
public class f {
    protected a b = new a(c);

    /* renamed from: a  reason: collision with root package name */
    public static f f7955a = null;
    private static boolean d = false;
    protected static final b c = new b(c(), c.m, c.g, c.h, c.c, c.i, 10, c.e, c.n);

    public static f a() {
        if (f7955a == null) {
            synchronized (f.class) {
                if (f7955a == null) {
                    f7955a = new f();
                    d = true;
                }
            }
        }
        return f7955a;
    }

    private f() {
    }

    protected void a(int i, String str, String str2, Throwable th) {
        if (d) {
            String b = com.tencent.open.utils.e.b();
            if (!TextUtils.isEmpty(b)) {
                String str3 = b + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.b != null) {
                    e.f7954a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                    this.b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                    d = false;
                } else {
                    return;
                }
            }
        }
        e.f7954a.b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (d.a.a(c.b, i) && this.b != null) {
            this.b.b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        }
    }

    public static final void a(String str, String str2) {
        a().a(1, str, str2, null);
    }

    public static final void b(String str, String str2) {
        a().a(2, str, str2, null);
    }

    public static final void a(String str, String str2, Throwable th) {
        a().a(2, str, str2, th);
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

    public static void b() {
        synchronized (f.class) {
            a().d();
            if (f7955a != null) {
                f7955a = null;
            }
        }
    }

    protected static File c() {
        boolean z = false;
        String str = c.d;
        try {
            d.c b = d.b.b();
            if (b != null) {
                if (b.c() > c.f) {
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

    protected void d() {
        if (this.b != null) {
            this.b.a();
            this.b.b();
            this.b = null;
        }
    }
}
