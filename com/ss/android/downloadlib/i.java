package com.ss.android.downloadlib;

import android.content.Context;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.a.k;
/* loaded from: classes6.dex */
public class i {
    private static volatile i qdp;
    private final com.ss.android.b.a.a qdr;
    private com.ss.android.b.a.b qds;
    private final h qdj = h.eFl();
    private final com.ss.android.a.a.a qdq = new g();
    private long f = System.currentTimeMillis();

    public static i iA(Context context) {
        if (qdp == null) {
            synchronized (i.class) {
                if (qdp == null) {
                    qdp = new i(context);
                }
            }
        }
        return qdp;
    }

    private i(Context context) {
        b(context);
        this.qdr = b.eEw();
    }

    private void b(Context context) {
        j.a(context);
        com.ss.android.socialbase.downloader.downloader.f.iB(j.a());
        com.ss.android.downloadlib.a.b.d.eEB().b();
        com.ss.android.socialbase.appdownloader.d.eFv().a(j.a(), "misc_config", new com.ss.android.downloadlib.d.d(), new com.ss.android.downloadlib.d.c(context), new e());
        com.ss.android.socialbase.appdownloader.d.eFv().a(new com.ss.android.downloadlib.d.b());
        com.ss.android.socialbase.appdownloader.d.eFv().a(new k());
        com.ss.android.socialbase.downloader.downloader.b.a(new d());
        com.ss.android.socialbase.appdownloader.d.eFv().a(new com.ss.android.downloadlib.guide.install.d());
    }

    public com.ss.android.a.a.a eFm() {
        return this.qdq;
    }

    public long b() {
        return this.f;
    }

    public void c() {
        this.f = System.currentTimeMillis();
    }

    public com.ss.android.b.a.a eFn() {
        return this.qdr;
    }

    public com.ss.android.b.a.b eFo() {
        if (this.qds == null) {
            this.qds = c.eFd();
        }
        return this.qds;
    }

    private h eFp() {
        return this.qdj;
    }

    public void a(Context context, int i, com.ss.android.a.a.b.d dVar, com.ss.android.a.a.b.c cVar) {
        eFp().a(context, i, dVar, cVar);
    }

    public void a(String str, long j, int i, com.ss.android.a.a.b.b bVar, com.ss.android.a.a.b.a aVar) {
        eFp().a(str, j, i, bVar, aVar);
    }

    public void e(String str, long j, int i) {
        eFp().e(str, j, i);
    }

    public void a(String str, int i) {
        eFp().a(str, i);
    }

    public void a(String str, boolean z) {
        eFp().a(str, z);
    }

    public void a(com.ss.android.a.a.b.a.a aVar) {
        eFp().a(aVar);
    }

    public String f() {
        return j.o();
    }

    public void g() {
        f.eFh().e();
    }
}
