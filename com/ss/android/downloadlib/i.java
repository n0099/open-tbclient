package com.ss.android.downloadlib;

import android.content.Context;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.a.k;
/* loaded from: classes6.dex */
public class i {
    private static volatile i qec;
    private final com.ss.android.b.a.a qee;
    private com.ss.android.b.a.b qef;
    private final h qdW = h.eFp();
    private final com.ss.android.a.a.a qed = new g();
    private long f = System.currentTimeMillis();

    public static i iB(Context context) {
        if (qec == null) {
            synchronized (i.class) {
                if (qec == null) {
                    qec = new i(context);
                }
            }
        }
        return qec;
    }

    private i(Context context) {
        b(context);
        this.qee = b.eEA();
    }

    private void b(Context context) {
        j.a(context);
        com.ss.android.socialbase.downloader.downloader.f.iC(j.a());
        com.ss.android.downloadlib.a.b.d.eEF().b();
        com.ss.android.socialbase.appdownloader.d.eFz().a(j.a(), "misc_config", new com.ss.android.downloadlib.d.d(), new com.ss.android.downloadlib.d.c(context), new e());
        com.ss.android.socialbase.appdownloader.d.eFz().a(new com.ss.android.downloadlib.d.b());
        com.ss.android.socialbase.appdownloader.d.eFz().a(new k());
        com.ss.android.socialbase.downloader.downloader.b.a(new d());
        com.ss.android.socialbase.appdownloader.d.eFz().a(new com.ss.android.downloadlib.guide.install.d());
    }

    public com.ss.android.a.a.a eFq() {
        return this.qed;
    }

    public long b() {
        return this.f;
    }

    public void c() {
        this.f = System.currentTimeMillis();
    }

    public com.ss.android.b.a.a eFr() {
        return this.qee;
    }

    public com.ss.android.b.a.b eFs() {
        if (this.qef == null) {
            this.qef = c.eFh();
        }
        return this.qef;
    }

    private h eFt() {
        return this.qdW;
    }

    public void a(Context context, int i, com.ss.android.a.a.b.d dVar, com.ss.android.a.a.b.c cVar) {
        eFt().a(context, i, dVar, cVar);
    }

    public void a(String str, long j, int i, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
        eFt().a(str, j, i, bVar, aVar);
    }

    public void a(String str, int i) {
        eFt().a(str, i);
    }

    public void a(String str, boolean z) {
        eFt().a(str, z);
    }

    public void a(com.ss.android.a.a.b.a.a aVar) {
        eFt().a(aVar);
    }

    public String f() {
        return j.o();
    }

    public void g() {
        f.eFl().e();
    }
}
