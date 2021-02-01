package com.ss.android.downloadlib;

import android.content.Context;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.a.k;
/* loaded from: classes6.dex */
public class i {
    private static volatile i qcP;
    private final com.ss.android.b.a.a qcR;
    private com.ss.android.b.a.b qcS;
    private final h qcJ = h.eFd();
    private final com.ss.android.a.a.a qcQ = new g();
    private long f = System.currentTimeMillis();

    public static i iA(Context context) {
        if (qcP == null) {
            synchronized (i.class) {
                if (qcP == null) {
                    qcP = new i(context);
                }
            }
        }
        return qcP;
    }

    private i(Context context) {
        b(context);
        this.qcR = b.eEo();
    }

    private void b(Context context) {
        j.a(context);
        com.ss.android.socialbase.downloader.downloader.f.iB(j.a());
        com.ss.android.downloadlib.a.b.d.eEt().b();
        com.ss.android.socialbase.appdownloader.d.eFn().a(j.a(), "misc_config", new com.ss.android.downloadlib.d.d(), new com.ss.android.downloadlib.d.c(context), new e());
        com.ss.android.socialbase.appdownloader.d.eFn().a(new com.ss.android.downloadlib.d.b());
        com.ss.android.socialbase.appdownloader.d.eFn().a(new k());
        com.ss.android.socialbase.downloader.downloader.b.a(new d());
        com.ss.android.socialbase.appdownloader.d.eFn().a(new com.ss.android.downloadlib.guide.install.d());
    }

    public com.ss.android.a.a.a eFe() {
        return this.qcQ;
    }

    public long b() {
        return this.f;
    }

    public void c() {
        this.f = System.currentTimeMillis();
    }

    public com.ss.android.b.a.a eFf() {
        return this.qcR;
    }

    public com.ss.android.b.a.b eFg() {
        if (this.qcS == null) {
            this.qcS = c.eEV();
        }
        return this.qcS;
    }

    private h eFh() {
        return this.qcJ;
    }

    public void a(Context context, int i, com.ss.android.a.a.b.d dVar, com.ss.android.a.a.b.c cVar) {
        eFh().a(context, i, dVar, cVar);
    }

    public void a(String str, long j, int i, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
        eFh().a(str, j, i, bVar, aVar);
    }

    public void e(String str, long j, int i) {
        eFh().e(str, j, i);
    }

    public void a(String str, int i) {
        eFh().a(str, i);
    }

    public void a(String str, boolean z) {
        eFh().a(str, z);
    }

    public void a(com.ss.android.a.a.b.a.a aVar) {
        eFh().a(aVar);
    }

    public String f() {
        return j.o();
    }

    public void g() {
        f.eEZ().e();
    }
}
