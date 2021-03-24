package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.d;
import java.io.File;
/* loaded from: classes7.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static f f39211a = null;

    /* renamed from: c  reason: collision with root package name */
    public static final b f39212c = new b(c(), c.m, c.f39205g, c.f39206h, c.f39201c, c.i, 10, c.f39203e, c.n);

    /* renamed from: d  reason: collision with root package name */
    public static boolean f39213d = false;

    /* renamed from: b  reason: collision with root package name */
    public a f39214b = new a(f39212c);

    public static f a() {
        if (f39211a == null) {
            synchronized (f.class) {
                if (f39211a == null) {
                    f39211a = new f();
                    f39213d = true;
                }
            }
        }
        return f39211a;
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
        String str = c.f39202d;
        boolean z = false;
        try {
            d.c b2 = d.b.b();
            if (b2 != null) {
                if (b2.c() > c.f39204f) {
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
        a aVar = this.f39214b;
        if (aVar != null) {
            aVar.a();
            this.f39214b.b();
            this.f39214b = null;
        }
    }

    public static void b() {
        synchronized (f.class) {
            a().d();
            if (f39211a != null) {
                f39211a = null;
            }
        }
    }

    public void a(int i, String str, String str2, Throwable th) {
        a aVar;
        if (f39213d) {
            String b2 = com.tencent.open.utils.e.b();
            if (!TextUtils.isEmpty(b2)) {
                String str3 = b2 + " SDK_VERSION:" + Constants.SDK_VERSION;
                if (this.f39214b == null) {
                    return;
                }
                e.f39210a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                this.f39214b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                f39213d = false;
            }
        }
        e.f39210a.b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (!d.a.a(c.f39200b, i) || (aVar = this.f39214b) == null) {
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
