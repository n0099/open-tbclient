package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.d.ah;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private static volatile f pYu = null;

    private f() {
    }

    public static synchronized void b(g gVar) {
        synchronized (f.class) {
            if (gVar != null) {
                if (pYu == null) {
                    pYu = gVar.eHF();
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

    public static f iA(Context context) {
        if (pYu == null) {
            synchronized (f.class) {
                if (pYu == null) {
                    b.a(context);
                    pYu = new f();
                }
            }
        }
        return pYu;
    }

    public static com.ss.android.socialbase.downloader.g.d iB(Context context) {
        iA(context);
        return new com.ss.android.socialbase.downloader.g.d();
    }

    public void a(int i) {
        c.eHt().d(i);
    }

    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        return c.eHt().a(str);
    }

    public void b(int i) {
        a(i, true);
    }

    public void a(int i, boolean z) {
        c.eHt().c(i, z);
    }

    public void c(int i) {
        c.eHt().f(i);
    }

    public boolean d(int i) {
        return c.eHt().e(i);
    }

    public void e(int i) {
        c.eHt().g(i);
    }

    public void a() {
        c.eHt().c();
    }

    public void a(List<String> list) {
        c.eHt().a(list);
    }

    public void b(List<String> list) {
        c.eHt().b(list);
    }

    public int f(int i) {
        return c.eHt().h(i);
    }

    public boolean g(int i) {
        boolean i2;
        if (com.ss.android.socialbase.downloader.m.a.a(4194304)) {
            synchronized (this) {
                i2 = c.eHt().i(i);
            }
            return i2;
        }
        return c.eHt().i(i);
    }

    public com.ss.android.socialbase.downloader.g.c h(int i) {
        return c.eHt().j(i);
    }

    public com.ss.android.socialbase.downloader.g.c hs(String str, String str2) {
        return c.eHt().b(str, str2);
    }

    public com.ss.android.socialbase.downloader.d.d So(int i) {
        return c.eHt().Sk(i);
    }

    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        return c.eHt().b(str);
    }

    public void j(int i) {
        c.eHt().d(i, true);
    }

    @Deprecated
    public void k(int i) {
        c.eHt().a(i, null, com.ss.android.socialbase.downloader.b.h.MAIN, true);
    }

    @Deprecated
    public void a(int i, com.ss.android.socialbase.downloader.d.b bVar) {
        if (bVar != null) {
            c.eHt().b(i, bVar, com.ss.android.socialbase.downloader.b.h.MAIN, true);
        }
    }

    @Deprecated
    public void a(int i, com.ss.android.socialbase.downloader.d.b bVar, boolean z) {
        if (bVar != null) {
            c.eHt().a(i, bVar, com.ss.android.socialbase.downloader.b.h.MAIN, true, z);
        }
    }

    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        return c.eHt().a(cVar);
    }

    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        return c.eHt().c(str);
    }

    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        return c.eHt().d(str);
    }

    public ah Sp(int i) {
        return c.eHt().Sn(i);
    }

    public boolean Sm(int i) {
        return c.eHt().Sj(i).b();
    }

    public r eHu() {
        return b.eHs();
    }

    public void a(r rVar) {
        b.a(rVar);
    }
}
