package com.ss.android.downloadlib;

import android.content.Context;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.a.k;
/* loaded from: classes4.dex */
public class i {
    private static volatile i pSL;
    private final com.ss.android.b.a.a pSN;
    private com.ss.android.b.a.b pSO;
    private final h pSF = h.eCM();
    private final com.ss.android.a.a.a pSM = new g();
    private long f = System.currentTimeMillis();

    public static i ix(Context context) {
        if (pSL == null) {
            synchronized (i.class) {
                if (pSL == null) {
                    pSL = new i(context);
                }
            }
        }
        return pSL;
    }

    private i(Context context) {
        b(context);
        this.pSN = b.eBX();
    }

    private void b(Context context) {
        j.a(context);
        com.ss.android.socialbase.downloader.downloader.f.iy(j.a());
        com.ss.android.downloadlib.a.b.d.eCc().b();
        com.ss.android.socialbase.appdownloader.d.eCW().a(j.a(), "misc_config", new com.ss.android.downloadlib.d.d(), new com.ss.android.downloadlib.d.c(context), new e());
        com.ss.android.socialbase.appdownloader.d.eCW().a(new com.ss.android.downloadlib.d.b());
        com.ss.android.socialbase.appdownloader.d.eCW().a(new k());
        com.ss.android.socialbase.downloader.downloader.b.a(new d());
        com.ss.android.socialbase.appdownloader.d.eCW().a(new com.ss.android.downloadlib.guide.install.d());
    }

    public com.ss.android.a.a.a eCN() {
        return this.pSM;
    }

    public long b() {
        return this.f;
    }

    public void c() {
        this.f = System.currentTimeMillis();
    }

    public com.ss.android.b.a.a eCO() {
        return this.pSN;
    }

    public com.ss.android.b.a.b eCP() {
        if (this.pSO == null) {
            this.pSO = c.eCE();
        }
        return this.pSO;
    }

    private h eCQ() {
        return this.pSF;
    }

    public void a(Context context, int i, com.ss.android.a.a.b.d dVar, com.ss.android.a.a.b.c cVar) {
        eCQ().a(context, i, dVar, cVar);
    }

    public void a(String str, long j, int i, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
        eCQ().a(str, j, i, bVar, aVar);
    }

    public void c(String str, long j, int i) {
        eCQ().c(str, j, i);
    }

    public void a(String str, int i) {
        eCQ().a(str, i);
    }

    public void a(String str, boolean z) {
        eCQ().a(str, z);
    }

    public void a(com.ss.android.a.a.b.a.a aVar) {
        eCQ().a(aVar);
    }

    public String f() {
        return j.o();
    }

    public void g() {
        f.eCI().e();
    }
}
