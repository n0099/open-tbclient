package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.d.ah;
import java.util.List;
/* loaded from: classes6.dex */
public class f {
    private static volatile f qgg = null;

    private f() {
    }

    public static synchronized void b(g gVar) {
        synchronized (f.class) {
            if (gVar != null) {
                if (qgg == null) {
                    qgg = gVar.eGS();
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
        if (qgg == null) {
            synchronized (f.class) {
                if (qgg == null) {
                    b.a(context);
                    qgg = new f();
                }
            }
        }
        return qgg;
    }

    public static com.ss.android.socialbase.downloader.g.d iC(Context context) {
        iB(context);
        return new com.ss.android.socialbase.downloader.g.d();
    }

    public void a(int i) {
        c.eGG().d(i);
    }

    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        return c.eGG().a(str);
    }

    public void b(int i) {
        a(i, true);
    }

    public void a(int i, boolean z) {
        c.eGG().c(i, z);
    }

    public void c(int i) {
        c.eGG().f(i);
    }

    public boolean d(int i) {
        return c.eGG().e(i);
    }

    public void e(int i) {
        c.eGG().g(i);
    }

    public void a() {
        c.eGG().c();
    }

    public void a(List<String> list) {
        c.eGG().a(list);
    }

    public void b(List<String> list) {
        c.eGG().b(list);
    }

    public int f(int i) {
        return c.eGG().h(i);
    }

    public boolean g(int i) {
        boolean i2;
        if (com.ss.android.socialbase.downloader.m.a.a(4194304)) {
            synchronized (this) {
                i2 = c.eGG().i(i);
            }
            return i2;
        }
        return c.eGG().i(i);
    }

    public com.ss.android.socialbase.downloader.g.c h(int i) {
        return c.eGG().j(i);
    }

    public com.ss.android.socialbase.downloader.g.c hB(String str, String str2) {
        return c.eGG().b(str, str2);
    }

    public com.ss.android.socialbase.downloader.d.d Rt(int i) {
        return c.eGG().Rp(i);
    }

    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        return c.eGG().b(str);
    }

    public void j(int i) {
        c.eGG().d(i, true);
    }

    @Deprecated
    public void k(int i) {
        c.eGG().a(i, null, com.ss.android.socialbase.downloader.b.h.MAIN, true);
    }

    @Deprecated
    public void a(int i, com.ss.android.socialbase.downloader.d.b bVar) {
        if (bVar != null) {
            c.eGG().b(i, bVar, com.ss.android.socialbase.downloader.b.h.MAIN, true);
        }
    }

    @Deprecated
    public void a(int i, com.ss.android.socialbase.downloader.d.b bVar, boolean z) {
        if (bVar != null) {
            c.eGG().a(i, bVar, com.ss.android.socialbase.downloader.b.h.MAIN, true, z);
        }
    }

    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        return c.eGG().a(cVar);
    }

    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        return c.eGG().c(str);
    }

    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        return c.eGG().d(str);
    }

    public ah Ru(int i) {
        return c.eGG().Rs(i);
    }

    public boolean Rr(int i) {
        return c.eGG().Ro(i).b();
    }

    public r eGH() {
        return b.eGF();
    }

    public void a(r rVar) {
        b.a(rVar);
    }
}
