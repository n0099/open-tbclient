package com.ss.android.downloadlib;

import android.content.Context;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.a.k;
/* loaded from: classes4.dex */
public class i {
    private static volatile i pXl;
    private final com.ss.android.b.a.a pXn;
    private com.ss.android.b.a.b pXo;
    private final h pXf = h.eGC();
    private final com.ss.android.a.a.a pXm = new g();
    private long f = System.currentTimeMillis();

    public static i iz(Context context) {
        if (pXl == null) {
            synchronized (i.class) {
                if (pXl == null) {
                    pXl = new i(context);
                }
            }
        }
        return pXl;
    }

    private i(Context context) {
        b(context);
        this.pXn = b.eFO();
    }

    private void b(Context context) {
        j.a(context);
        com.ss.android.socialbase.downloader.downloader.f.iA(j.a());
        com.ss.android.downloadlib.a.b.d.eFT().b();
        com.ss.android.socialbase.appdownloader.d.eGM().a(j.a(), "misc_config", new com.ss.android.downloadlib.d.d(), new com.ss.android.downloadlib.d.c(context), new e());
        com.ss.android.socialbase.appdownloader.d.eGM().a(new com.ss.android.downloadlib.d.b());
        com.ss.android.socialbase.appdownloader.d.eGM().a(new k());
        com.ss.android.socialbase.downloader.downloader.b.a(new d());
        com.ss.android.socialbase.appdownloader.d.eGM().a(new com.ss.android.downloadlib.guide.install.d());
    }

    public com.ss.android.a.a.a eGD() {
        return this.pXm;
    }

    public long b() {
        return this.f;
    }

    public void c() {
        this.f = System.currentTimeMillis();
    }

    public com.ss.android.b.a.a eGE() {
        return this.pXn;
    }

    public com.ss.android.b.a.b eGF() {
        if (this.pXo == null) {
            this.pXo = c.eGv();
        }
        return this.pXo;
    }

    private h eGG() {
        return this.pXf;
    }

    public void a(Context context, int i, com.ss.android.a.a.b.d dVar, com.ss.android.a.a.b.c cVar) {
        eGG().a(context, i, dVar, cVar);
    }

    public void a(String str, long j, int i, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
        eGG().a(str, j, i, bVar, aVar);
    }

    public void c(String str, long j, int i) {
        eGG().c(str, j, i);
    }

    public void a(String str, int i) {
        eGG().a(str, i);
    }

    public void a(String str, boolean z) {
        eGG().a(str, z);
    }

    public void a(com.ss.android.a.a.b.a.a aVar) {
        eGG().a(aVar);
    }

    public String f() {
        return j.o();
    }

    public void g() {
        f.eGz().e();
    }
}
