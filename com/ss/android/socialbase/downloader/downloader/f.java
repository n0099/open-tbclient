package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.d.ah;
import java.util.List;
/* loaded from: classes6.dex */
public class f {
    private static volatile f qgV = null;

    private f() {
    }

    public static synchronized void b(g gVar) {
        synchronized (f.class) {
            if (gVar != null) {
                if (qgV == null) {
                    qgV = gVar.eGW();
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

    public static f iC(Context context) {
        if (qgV == null) {
            synchronized (f.class) {
                if (qgV == null) {
                    b.a(context);
                    qgV = new f();
                }
            }
        }
        return qgV;
    }

    public static com.ss.android.socialbase.downloader.g.d iD(Context context) {
        iC(context);
        return new com.ss.android.socialbase.downloader.g.d();
    }

    public void a(int i) {
        c.eGK().d(i);
    }

    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        return c.eGK().a(str);
    }

    public void b(int i) {
        a(i, true);
    }

    public void a(int i, boolean z) {
        c.eGK().c(i, z);
    }

    public void c(int i) {
        c.eGK().f(i);
    }

    public boolean d(int i) {
        return c.eGK().e(i);
    }

    public void e(int i) {
        c.eGK().g(i);
    }

    public void a() {
        c.eGK().c();
    }

    public void a(List<String> list) {
        c.eGK().a(list);
    }

    public void b(List<String> list) {
        c.eGK().b(list);
    }

    public int f(int i) {
        return c.eGK().h(i);
    }

    public boolean g(int i) {
        boolean i2;
        if (com.ss.android.socialbase.downloader.m.a.a(4194304)) {
            synchronized (this) {
                i2 = c.eGK().i(i);
            }
            return i2;
        }
        return c.eGK().i(i);
    }

    public com.ss.android.socialbase.downloader.g.c h(int i) {
        return c.eGK().j(i);
    }

    public com.ss.android.socialbase.downloader.g.c hC(String str, String str2) {
        return c.eGK().b(str, str2);
    }

    public com.ss.android.socialbase.downloader.d.d Rx(int i) {
        return c.eGK().Rt(i);
    }

    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        return c.eGK().b(str);
    }

    public void j(int i) {
        c.eGK().d(i, true);
    }

    @Deprecated
    public void k(int i) {
        c.eGK().a(i, null, com.ss.android.socialbase.downloader.b.h.MAIN, true);
    }

    @Deprecated
    public void a(int i, com.ss.android.socialbase.downloader.d.b bVar) {
        if (bVar != null) {
            c.eGK().b(i, bVar, com.ss.android.socialbase.downloader.b.h.MAIN, true);
        }
    }

    @Deprecated
    public void a(int i, com.ss.android.socialbase.downloader.d.b bVar, boolean z) {
        if (bVar != null) {
            c.eGK().a(i, bVar, com.ss.android.socialbase.downloader.b.h.MAIN, true, z);
        }
    }

    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        return c.eGK().a(cVar);
    }

    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        return c.eGK().c(str);
    }

    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        return c.eGK().d(str);
    }

    public ah Ry(int i) {
        return c.eGK().Rw(i);
    }

    public boolean Rv(int i) {
        return c.eGK().Rs(i).b();
    }

    public r eGL() {
        return b.eGJ();
    }

    public void a(r rVar) {
        b.a(rVar);
    }
}
