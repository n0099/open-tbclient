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
    private static final String f13209a = b.class.getSimpleName();
    private volatile boolean j;
    private volatile boolean k;
    private boolean l;
    private com.ss.android.socialbase.downloader.g.b pXr;
    private com.ss.android.socialbase.downloader.g.b pXs;
    private com.ss.android.socialbase.downloader.downloader.d pXt;
    private final com.ss.android.socialbase.downloader.g.d pXu;
    private com.ss.android.socialbase.downloader.g.c pXv;
    private final e pXw;
    private g pXx;
    private k pXy;

    public b(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.g.d dVar, e eVar) {
        this.l = false;
        this.pXs = bVar;
        this.pXu = dVar;
        if (dVar != null) {
            this.pXv = dVar.a();
        }
        this.pXw = eVar;
        this.pXy = com.ss.android.socialbase.downloader.downloader.b.eDT();
        this.pXs.a(this);
    }

    public b(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.g.d dVar, g gVar, e eVar) {
        this(bVar, dVar, eVar);
        this.pXx = gVar;
    }

    private String c() {
        return this.pXv.O();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        r3.pXr.a(false);
     */
    @Override // java.lang.Runnable
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Process.setThreadPriority(10);
        this.pXr = this.pXs;
        while (true) {
            try {
                this.pXr.a(this);
                if (!d(this.pXr)) {
                    break;
                }
                this.pXr.a(false);
                if (!e()) {
                    this.pXr = this.pXw.RC(this.pXr.s());
                    if (e() || this.pXr == null) {
                        break;
                    }
                    Thread.sleep(50L);
                } else {
                    break;
                }
            } finally {
                if (this.pXr != null) {
                    this.pXr.a(false);
                }
                d();
                this.pXw.a(this);
            }
        }
    }

    public void a(long j, long j2) {
        if (this.pXt != null) {
            this.pXt.a(j, j2);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, IGET]}, finally: {[IGET] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [273=14] */
    /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE] complete}, expected: {[IGET] complete} */
    /* JADX WARN: Finally extract failed */
    private boolean d(com.ss.android.socialbase.downloader.g.b bVar) {
        long j;
        boolean z;
        com.ss.android.socialbase.downloader.g.b eEv;
        while (true) {
            com.ss.android.socialbase.downloader.g.b bVar2 = (bVar.d() && bVar.f() && (eEv = bVar.eEv()) != null && eEv.s() == bVar.s()) ? eEv : null;
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
                    this.l = this.pXx != null;
                    bVar.b(this.l);
                    try {
                        try {
                            if (!this.l) {
                                List<com.ss.android.socialbase.downloader.g.e> a2 = com.ss.android.socialbase.downloader.m.d.a(this.pXv.eEC(), this.pXv.an(), n, p);
                                a2.add(new com.ss.android.socialbase.downloader.g.e("Chunk-Index", String.valueOf(bVar.s())));
                                com.ss.android.socialbase.downloader.m.d.a(a2, this.pXv);
                                this.pXx = com.ss.android.socialbase.downloader.downloader.b.b(this.pXv.o(), this.pXv.I(), c, a2);
                            }
                            if (this.pXx != null && this.pXw != null) {
                                try {
                                    int b2 = this.pXx.b();
                                    if (b2 < 200 || b2 >= 300) {
                                        this.pXw.a(this.pXx);
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            if (e()) {
                                return false;
                            } else if (this.pXx == null) {
                                throw new com.ss.android.socialbase.downloader.e.a(1022, new IOException("download can't continue, chunk connection is null"));
                            } else {
                                if (!this.l) {
                                    try {
                                        int b3 = this.pXx.b();
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
                                this.pXt = new com.ss.android.socialbase.downloader.downloader.d(this.pXv, c, this.pXx, bVar, this.pXw);
                                if (bVar2 != null) {
                                    long BT = bVar2.BT(false);
                                    if (p != 0 && p >= n) {
                                        BT = (p - n) + 1;
                                    }
                                    this.pXt.a(bVar2.n(), bVar2.p(), BT);
                                }
                                z = true;
                                try {
                                    this.pXt.d();
                                    d();
                                    return true;
                                } catch (com.ss.android.socialbase.downloader.e.a e2) {
                                    e = e2;
                                    if (e()) {
                                        return true;
                                    } else if (com.ss.android.socialbase.downloader.m.d.g(e)) {
                                        this.pXw.a(e, false);
                                        return false;
                                    } else if (!this.pXw.d(e)) {
                                        if (!this.pXv.eEV() || this.pXv.eEW() || this.pXv.eFv() <= 1 || !com.ss.android.socialbase.downloader.m.d.a(e, this.pXv)) {
                                            this.pXw.b(e);
                                            return false;
                                        }
                                        this.pXw.e(e);
                                        return false;
                                    } else if (com.ss.android.socialbase.downloader.m.d.d(e)) {
                                        this.pXw.a(e, true);
                                        return false;
                                    } else {
                                        long j2 = 0;
                                        if (z) {
                                            if (this.pXt == null) {
                                                this.pXw.b(e);
                                                return false;
                                            } else if (com.ss.android.socialbase.downloader.m.a.a(32)) {
                                                j2 = this.pXt.a() - this.pXt.e();
                                                if (j2 > 0) {
                                                    a(bVar, this.pXt.e());
                                                } else if (j2 < 0) {
                                                    j2 = 0;
                                                }
                                            } else {
                                                j2 = this.pXt.a() - j;
                                                a(bVar, j);
                                            }
                                        }
                                        if ((com.ss.android.socialbase.downloader.m.a.a(16) ? this.pXw.a(bVar, e, j2) : this.pXw.a(e, j2)) == h.RETURN) {
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
                        if (this.pXx != null && this.pXw != null) {
                            try {
                                int b4 = this.pXx.b();
                                if (b4 < 200 || b4 >= 300) {
                                    this.pXw.a(this.pXx);
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
        com.ss.android.socialbase.downloader.g.b eEv = bVar.d() ? bVar.eEv() : bVar;
        if (eEv != null) {
            if (eEv.h()) {
                this.pXy.a(eEv.k(), eEv.b(), j);
            }
            eEv.b(j);
            this.pXy.a(eEv.k(), eEv.s(), eEv.b(), j);
        } else if (bVar.d()) {
            this.pXy.a(bVar.k(), bVar.s(), j);
        }
    }

    private void d() {
        if (this.pXx != null) {
            this.pXx.d();
            this.pXx = null;
        }
    }

    private boolean e() {
        return this.j || this.k;
    }

    public void a() {
        this.j = true;
        if (this.pXt != null) {
            this.pXt.b();
        }
    }

    public void b() {
        this.k = true;
        if (this.pXt != null) {
            this.pXt.c();
        }
    }
}
