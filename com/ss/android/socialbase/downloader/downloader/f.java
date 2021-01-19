package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.d.ah;
import java.util.List;
/* loaded from: classes4.dex */
public class f {
    private static volatile f pVC = null;

    private f() {
    }

    public static synchronized void b(g gVar) {
        synchronized (f.class) {
            if (gVar != null) {
                if (pVC == null) {
                    pVC = gVar.eEt();
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

    public static f iy(Context context) {
        if (pVC == null) {
            synchronized (f.class) {
                if (pVC == null) {
                    b.a(context);
                    pVC = new f();
                }
            }
        }
        return pVC;
    }

    public static com.ss.android.socialbase.downloader.g.d iz(Context context) {
        iy(context);
        return new com.ss.android.socialbase.downloader.g.d();
    }

    public void a(int i) {
        c.eEh().d(i);
    }

    public List<com.ss.android.socialbase.downloader.g.c> a(String str) {
        return c.eEh().a(str);
    }

    public void b(int i) {
        a(i, true);
    }

    public void a(int i, boolean z) {
        c.eEh().c(i, z);
    }

    public void c(int i) {
        c.eEh().f(i);
    }

    public boolean d(int i) {
        return c.eEh().e(i);
    }

    public void e(int i) {
        c.eEh().g(i);
    }

    public void a() {
        c.eEh().c();
    }

    public void a(List<String> list) {
        c.eEh().a(list);
    }

    public void b(List<String> list) {
        c.eEh().b(list);
    }

    public int f(int i) {
        return c.eEh().h(i);
    }

    public boolean g(int i) {
        boolean i2;
        if (com.ss.android.socialbase.downloader.m.a.a(4194304)) {
            synchronized (this) {
                i2 = c.eEh().i(i);
            }
            return i2;
        }
        return c.eEh().i(i);
    }

    public com.ss.android.socialbase.downloader.g.c h(int i) {
        return c.eEh().j(i);
    }

    public com.ss.android.socialbase.downloader.g.c hs(String str, String str2) {
        return c.eEh().b(str, str2);
    }

    public com.ss.android.socialbase.downloader.d.d QX(int i) {
        return c.eEh().QT(i);
    }

    public List<com.ss.android.socialbase.downloader.g.c> b(String str) {
        return c.eEh().b(str);
    }

    public void j(int i) {
        c.eEh().d(i, true);
    }

    @Deprecated
    public void k(int i) {
        c.eEh().a(i, null, com.ss.android.socialbase.downloader.b.h.MAIN, true);
    }

    @Deprecated
    public void a(int i, com.ss.android.socialbase.downloader.d.b bVar) {
        if (bVar != null) {
            c.eEh().b(i, bVar, com.ss.android.socialbase.downloader.b.h.MAIN, true);
        }
    }

    @Deprecated
    public void a(int i, com.ss.android.socialbase.downloader.d.b bVar, boolean z) {
        if (bVar != null) {
            c.eEh().a(i, bVar, com.ss.android.socialbase.downloader.b.h.MAIN, true, z);
        }
    }

    public boolean a(com.ss.android.socialbase.downloader.g.c cVar) {
        return c.eEh().a(cVar);
    }

    public List<com.ss.android.socialbase.downloader.g.c> c(String str) {
        return c.eEh().c(str);
    }

    public List<com.ss.android.socialbase.downloader.g.c> d(String str) {
        return c.eEh().d(str);
    }

    public ah QY(int i) {
        return c.eEh().QW(i);
    }

    public boolean QV(int i) {
        return c.eEh().QS(i).b();
    }

    public r eEi() {
        return b.eEg();
    }

    public void a(r rVar) {
        b.a(rVar);
    }
}
