package com.ss.android.socialbase.downloader.l;

import android.annotation.SuppressLint;
import android.os.Process;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.e.h;
import com.ss.android.socialbase.downloader.i.g;
import java.io.IOException;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13508a = b.class.getSimpleName();
    private volatile boolean j;
    private volatile boolean k;
    private boolean l;
    private com.ss.android.socialbase.downloader.g.b qaj;
    private com.ss.android.socialbase.downloader.g.b qak;
    private com.ss.android.socialbase.downloader.downloader.d qal;
    private final com.ss.android.socialbase.downloader.g.d qam;
    private com.ss.android.socialbase.downloader.g.c qan;
    private final e qao;
    private g qap;
    private k qaq;

    public b(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.g.d dVar, e eVar) {
        this.l = false;
        this.qak = bVar;
        this.qam = dVar;
        if (dVar != null) {
            this.qan = dVar.a();
        }
        this.qao = eVar;
        this.qaq = com.ss.android.socialbase.downloader.downloader.b.eHf();
        this.qak.a(this);
    }

    public b(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.g.d dVar, g gVar, e eVar) {
        this(bVar, dVar, eVar);
        this.qap = gVar;
    }

    private String c() {
        return this.qan.O();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        r3.qaj.a(false);
     */
    @Override // java.lang.Runnable
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Process.setThreadPriority(10);
        this.qaj = this.qak;
        while (true) {
            try {
                this.qaj.a(this);
                if (!d(this.qaj)) {
                    break;
                }
                this.qaj.a(false);
                if (!e()) {
                    this.qaj = this.qao.ST(this.qaj.s());
                    if (e() || this.qaj == null) {
                        break;
                    }
                    Thread.sleep(50L);
                } else {
                    break;
                }
            } finally {
                if (this.qaj != null) {
                    this.qaj.a(false);
                }
                d();
                this.qao.a(this);
            }
        }
    }

    public void a(long j, long j2) {
        if (this.qal != null) {
            this.qal.a(j, j2);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, IGET]}, finally: {[IGET] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [273=14] */
    /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE] complete}, expected: {[IGET] complete} */
    /* JADX WARN: Finally extract failed */
    private boolean d(com.ss.android.socialbase.downloader.g.b bVar) {
        long j;
        boolean z;
        com.ss.android.socialbase.downloader.g.b eHH;
        while (true) {
            com.ss.android.socialbase.downloader.g.b bVar2 = (bVar.d() && bVar.f() && (eHH = bVar.eHH()) != null && eHH.s() == bVar.s()) ? eHH : null;
            if (bVar2 != null && bVar2.i()) {
                return true;
            }
            long n = bVar.n();
            long p = bVar.p();
            long n2 = bVar.n();
            if (bVar2 != null) {
                long n3 = bVar2.n();
                n = bVar2.n();
                p = bVar2.p();
                j = n3;
            } else {
                j = n2;
            }
            try {
                try {
                    if (e()) {
                        return false;
                    }
                    String c = c();
                    this.l = this.qap != null;
                    bVar.b(this.l);
                    try {
                        try {
                            if (!this.l) {
                                List<com.ss.android.socialbase.downloader.g.e> a2 = com.ss.android.socialbase.downloader.m.d.a(this.qan.eHO(), this.qan.an(), n, p);
                                a2.add(new com.ss.android.socialbase.downloader.g.e("Chunk-Index", String.valueOf(bVar.s())));
                                com.ss.android.socialbase.downloader.m.d.a(a2, this.qan);
                                this.qap = com.ss.android.socialbase.downloader.downloader.b.b(this.qan.o(), this.qan.I(), c, a2);
                            }
                            if (this.qap != null && this.qao != null) {
                                try {
                                    int b2 = this.qap.b();
                                    if (b2 < 200 || b2 >= 300) {
                                        this.qao.a(this.qap);
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            if (e()) {
                                return false;
                            } else if (this.qap == null) {
                                throw new com.ss.android.socialbase.downloader.e.a(1022, new IOException("download can't continue, chunk connection is null"));
                            } else {
                                if (!this.l) {
                                    try {
                                        int b3 = this.qap.b();
                                        if (!com.ss.android.socialbase.downloader.m.d.d(b3)) {
                                            throw new com.ss.android.socialbase.downloader.e.a(1002, String.format("Http response error , code is : %s ", String.valueOf(b3)));
                                            break;
                                        }
                                    } catch (com.ss.android.socialbase.downloader.e.a e) {
                                        throw e;
                                    } catch (Throwable th2) {
                                        com.ss.android.socialbase.downloader.m.d.a(th2, "ChunkRunnableGetResponseCode");
                                    }
                                }
                                this.qal = new com.ss.android.socialbase.downloader.downloader.d(this.qan, c, this.qap, bVar, this.qao);
                                if (bVar2 != null) {
                                    long BX = bVar2.BX(false);
                                    if (p != 0 && p >= n) {
                                        BX = (p - n) + 1;
                                    }
                                    this.qal.a(bVar2.n(), bVar2.p(), BX);
                                }
                                z = true;
                                try {
                                    this.qal.d();
                                    d();
                                    return true;
                                } catch (com.ss.android.socialbase.downloader.e.a e2) {
                                    e = e2;
                                    if (e()) {
                                        return true;
                                    } else if (com.ss.android.socialbase.downloader.m.d.g(e)) {
                                        this.qao.a(e, false);
                                        return false;
                                    } else if (!this.qao.d(e)) {
                                        if (!this.qan.eIh() || this.qan.eIi() || this.qan.eIH() <= 1 || !com.ss.android.socialbase.downloader.m.d.a(e, this.qan)) {
                                            this.qao.b(e);
                                            return false;
                                        }
                                        this.qao.e(e);
                                        return false;
                                    } else if (com.ss.android.socialbase.downloader.m.d.d(e)) {
                                        this.qao.a(e, true);
                                        return false;
                                    } else {
                                        long j2 = 0;
                                        if (z) {
                                            if (this.qal == null) {
                                                this.qao.b(e);
                                                return false;
                                            } else if (com.ss.android.socialbase.downloader.m.a.a(32)) {
                                                j2 = this.qal.a() - this.qal.e();
                                                if (j2 > 0) {
                                                    a(bVar, this.qal.e());
                                                } else if (j2 < 0) {
                                                    j2 = 0;
                                                }
                                            } else {
                                                j2 = this.qal.a() - j;
                                                a(bVar, j);
                                            }
                                        }
                                        if ((com.ss.android.socialbase.downloader.m.a.a(16) ? this.qao.a(bVar, e, j2) : this.qao.a(e, j2)) == h.RETURN) {
                                            return false;
                                        }
                                        bVar.b(false);
                                        d();
                                    }
                                }
                            }
                        } catch (com.ss.android.socialbase.downloader.e.a e3) {
                            throw e3;
                        }
                    } catch (Throwable th3) {
                        if (this.qap != null && this.qao != null) {
                            try {
                                int b4 = this.qap.b();
                                if (b4 < 200 || b4 >= 300) {
                                    this.qao.a(this.qap);
                                }
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                        }
                        throw th3;
                    }
                } catch (com.ss.android.socialbase.downloader.e.a e4) {
                    e = e4;
                    z = false;
                }
            } finally {
                d();
            }
        }
    }

    private void a(com.ss.android.socialbase.downloader.g.b bVar, long j) {
        com.ss.android.socialbase.downloader.g.b eHH = bVar.d() ? bVar.eHH() : bVar;
        if (eHH != null) {
            if (eHH.h()) {
                this.qaq.a(eHH.k(), eHH.b(), j);
            }
            eHH.b(j);
            this.qaq.a(eHH.k(), eHH.s(), eHH.b(), j);
        } else if (bVar.d()) {
            this.qaq.a(bVar.k(), bVar.s(), j);
        }
    }

    private void d() {
        if (this.qap != null) {
            this.qap.d();
            this.qap = null;
        }
    }

    private boolean e() {
        return this.j || this.k;
    }

    public void a() {
        this.j = true;
        if (this.qal != null) {
            this.qal.b();
        }
    }

    public void b() {
        this.k = true;
        if (this.qal != null) {
            this.qal.c();
        }
    }
}
