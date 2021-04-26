package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.d;
import java.io.File;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f37197a = null;

    /* renamed from: c  reason: collision with root package name */
    public static final b f37198c = new b(c(), c.m, c.f37190g, c.f37191h, c.f37186c, c.f37192i, 10, c.f37188e, c.n);

    /* renamed from: d  reason: collision with root package name */
    public static boolean f37199d = false;

    /* renamed from: b  reason: collision with root package name */
    public a f37200b = new a(f37198c);

    public static f a() {
        if (f37197a == null) {
            synchronized (f.class) {
                if (f37197a == null) {
                    f37197a = new f();
                    f37199d = true;
                }
            }
        }
        return f37197a;
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
        String str = c.f37187d;
        boolean z = false;
        try {
            d.c b2 = d.b.b();
            if (b2 != null) {
                if (b2.c() > c.f37189f) {
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
        a aVar = this.f37200b;
        if (aVar != null) {
            aVar.a();
            this.f37200b.b();
            this.f37200b = null;
        }
    }

    public static void b() {
        synchronized (f.class) {
            a().d();
            if (f37197a != null) {
                f37197a = null;
            }
        }
    }

    public void a(int i2, String str, String str2, Throwable th) {
        a aVar;
        if (f37199d) {
            String b2 = com.tencent.open.utils.e.b();
            if (!TextUtils.isEmpty(b2)) {
                String str3 = b2 + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.f37200b == null) {
                    return;
                }
                e.f37196a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                this.f37200b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                f37199d = false;
            }
        }
        e.f37196a.b(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (!d.a.a(c.f37185b, i2) || (aVar = this.f37200b) == null) {
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
