package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.d.ah;
import java.util.List;
/* loaded from: classes6.dex */
public class f {
    private static volatile f qfG = null;

    private f() {
    }

    public static synchronized void b(g gVar) {
        synchronized (f.class) {
            if (gVar != null) {
                if (qfG == null) {
                    qfG = gVar.eGK();
                } else {
                    b.b(gVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(g gVar) {
        b.b(gVar);
    }

    public static f iB(Context context) {
        if (qfG == null) {
            synchronized (f.class) {
                if (qfG == null) {
                    b.a(context);
                    qfG = new f();
                }
            }
        }
        return qfG;
    }

    public static com.ss.android.socialbase.downloader.g.d iC(Context context) {
        iB(context);
        return new com.ss.android.socialbase.downloader.g.d();
    }

    public void a(int i) {
        c.eGy().d(i);
    }

    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        return c.eGy().a(str);
    }

    public void b(int i) {
        a(i, true);
    }

    public void a(int i, boolean z) {
        c.eGy().c(i, z);
    }

    public void c(int i) {
        c.eGy().f(i);
    }

    public boolean d(int i) {
        return c.eGy().e(i);
    }

    public void e(int i) {
        c.eGy().g(i);
    }

    public void a() {
        c.eGy().c();
    }

    public void a(List<String> list) {
        c.eGy().a(list);
    }

    public void b(List<String> list) {
        c.eGy().b(list);
    }

    public int f(int i) {
        return c.eGy().h(i);
    }

    public boolean g(int i) {
        boolean i2;
        if (com.ss.android.socialbase.downloader.m.a.a(4194304)) {
            synchronized (this) {
                i2 = c.eGy().i(i);
            }
            return i2;
        }
        return c.eGy().i(i);
    }

    public com.ss.android.socialbase.downloader.g.c h(int i) {
        return c.eGy().j(i);
    }

    public com.ss.android.socialbase.downloader.g.c hz(String str, String str2) {
        return c.eGy().b(str, str2);
    }

    public com.ss.android.socialbase.downloader.d.d Rs(int i) {
        return c.eGy().Ro(i);
    }

    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        return c.eGy().b(str);
    }

    public void j(int i) {
        c.eGy().d(i, true);
    }

    @Deprecated
    public void k(int i) {
        c.eGy().a(i, null, com.ss.android.socialbase.downloader.b.h.MAIN, true);
    }

    @Deprecated
    public void a(int i, com.ss.android.socialbase.downloader.d.b bVar) {
        if (bVar != null) {
            c.eGy().b(i, bVar, com.ss.android.socialbase.downloader.b.h.MAIN, true);
        }
    }

    @Deprecated
    public void a(int i, com.ss.android.socialbase.downloader.d.b bVar, boolean z) {
        if (bVar != null) {
            c.eGy().a(i, bVar, com.ss.android.socialbase.downloader.b.h.MAIN, true, z);
        }
    }

    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        return c.eGy().a(cVar);
    }

    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        return c.eGy().c(str);
    }

    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        return c.eGy().d(str);
    }

    public ah Rt(int i) {
        return c.eGy().Rr(i);
    }

    public boolean Rq(int i) {
        return c.eGy().Rn(i).b();
    }

    public r eGz() {
        return b.eGx();
    }

    public void a(r rVar) {
        b.a(rVar);
    }
}
