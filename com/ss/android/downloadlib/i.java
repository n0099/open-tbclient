package com.ss.android.downloadlib;

import android.content.Context;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.a.k;
/* loaded from: classes4.dex */
public class i {
    private static volatile i pVD;
    private final com.ss.android.b.a.a pVF;
    private com.ss.android.b.a.b pVG;
    private final h pVx = h.eFY();
    private final com.ss.android.a.a.a pVE = new g();
    private long f = System.currentTimeMillis();

    public static i iz(Context context) {
        if (pVD == null) {
            synchronized (i.class) {
                if (pVD == null) {
                    pVD = new i(context);
                }
            }
        }
        return pVD;
    }

    private i(Context context) {
        b(context);
        this.pVF = b.eFk();
    }

    private void b(Context context) {
        j.a(context);
        com.ss.android.socialbase.downloader.downloader.f.iA(j.a());
        com.ss.android.downloadlib.a.b.d.eFp().b();
        com.ss.android.socialbase.appdownloader.d.eGi().a(j.a(), "misc_config", new com.ss.android.downloadlib.d.d(), new com.ss.android.downloadlib.d.c(context), new e());
        com.ss.android.socialbase.appdownloader.d.eGi().a(new com.ss.android.downloadlib.d.b());
        com.ss.android.socialbase.appdownloader.d.eGi().a(new k());
        com.ss.android.socialbase.downloader.downloader.b.a(new d());
        com.ss.android.socialbase.appdownloader.d.eGi().a(new com.ss.android.downloadlib.guide.install.d());
    }

    public com.ss.android.a.a.a eFZ() {
        return this.pVE;
    }

    public long b() {
        return this.f;
    }

    public void c() {
        this.f = System.currentTimeMillis();
    }

    public com.ss.android.b.a.a eGa() {
        return this.pVF;
    }

    public com.ss.android.b.a.b eGb() {
        if (this.pVG == null) {
            this.pVG = c.eFR();
        }
        return this.pVG;
    }

    private h eGc() {
        return this.pVx;
    }

    public void a(Context context, int i, com.ss.android.a.a.b.d dVar, com.ss.android.a.a.b.c cVar) {
        eGc().a(context, i, dVar, cVar);
    }

    public void a(String str, long j, int i, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
        eGc().a(str, j, i, bVar, aVar);
    }

    public void c(String str, long j, int i) {
        eGc().c(str, j, i);
    }

    public void a(String str, int i) {
        eGc().a(str, i);
    }

    public void a(String str, boolean z) {
        eGc().a(str, z);
    }

    public void a(com.ss.android.a.a.b.a.a aVar) {
        eGc().a(aVar);
    }

    public String f() {
        return j.o();
    }

    public void g() {
        f.eFV().e();
    }
}
