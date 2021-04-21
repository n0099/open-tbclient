package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.d;
import java.io.File;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f39596a = null;

    /* renamed from: c  reason: collision with root package name */
    public static final b f39597c = new b(c(), c.m, c.f39590g, c.f39591h, c.f39586c, c.i, 10, c.f39588e, c.n);

    /* renamed from: d  reason: collision with root package name */
    public static boolean f39598d = false;

    /* renamed from: b  reason: collision with root package name */
    public a f39599b = new a(f39597c);

    public static f a() {
        if (f39596a == null) {
            synchronized (f.class) {
                if (f39596a == null) {
                    f39596a = new f();
                    f39598d = true;
                }
            }
        }
        return f39596a;
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
        String str = c.f39587d;
        boolean z = false;
        try {
            d.c b2 = d.b.b();
            if (b2 != null) {
                if (b2.c() > c.f39589f) {
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
        a aVar = this.f39599b;
        if (aVar != null) {
            aVar.a();
            this.f39599b.b();
            this.f39599b = null;
        }
    }

    public static void b() {
        synchronized (f.class) {
            a().d();
            if (f39596a != null) {
                f39596a = null;
            }
        }
    }

    public void a(int i, String str, String str2, Throwable th) {
        a aVar;
        if (f39598d) {
            String b2 = com.tencent.open.utils.e.b();
            if (!TextUtils.isEmpty(b2)) {
                String str3 = b2 + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.f39599b == null) {
                    return;
                }
                e.f39595a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                this.f39599b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                f39598d = false;
            }
        }
        e.f39595a.b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (!d.a.a(c.f39585b, i) || (aVar = this.f39599b) == null) {
            return;
        }
        aVar.b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
    }

    public static final void a(String str, String str2) {
        a().a(1, str, str2, null);
    }

    public static final void a(String str, String str2, Throwable th) {
        a().a(2, str, str2, th);
    }
}
