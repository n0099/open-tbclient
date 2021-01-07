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
    private static final String f13509a = b.class.getSimpleName();
    private volatile boolean j;
    private volatile boolean k;
    private boolean l;
    private com.ss.android.socialbase.downloader.g.b qbR;
    private com.ss.android.socialbase.downloader.g.b qbS;
    private com.ss.android.socialbase.downloader.downloader.d qbT;
    private final com.ss.android.socialbase.downloader.g.d qbU;
    private com.ss.android.socialbase.downloader.g.c qbV;
    private final e qbW;
    private g qbX;
    private k qbY;

    public b(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.g.d dVar, e eVar) {
        this.l = false;
        this.qbS = bVar;
        this.qbU = dVar;
        if (dVar != null) {
            this.qbV = dVar.a();
        }
        this.qbW = eVar;
        this.qbY = com.ss.android.socialbase.downloader.downloader.b.eHJ();
        this.qbS.a(this);
    }

    public b(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.g.d dVar, g gVar, e eVar) {
        this(bVar, dVar, eVar);
        this.qbX = gVar;
    }

    private String c() {
        return this.qbV.O();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        r3.qbR.a(false);
     */
    @Override // java.lang.Runnable
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Process.setThreadPriority(10);
        this.qbR = this.qbS;
        while (true) {
            try {
                this.qbR.a(this);
                if (!d(this.qbR)) {
                    break;
                }
                this.qbR.a(false);
                if (!e()) {
                    this.qbR = this.qbW.Tj(this.qbR.s());
                    if (e() || this.qbR == null) {
                        break;
                    }
                    Thread.sleep(50L);
                } else {
                    break;
                }
            } finally {
                if (this.qbR != null) {
                    this.qbR.a(false);
                }
                d();
                this.qbW.a(this);
            }
        }
    }

    public void a(long j, long j2) {
        if (this.qbT != null) {
            this.qbT.a(j, j2);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, IGET]}, finally: {[IGET] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [273=14] */
    /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE] complete}, expected: {[IGET] complete} */
    /* JADX WARN: Finally extract failed */
    private boolean d(com.ss.android.socialbase.downloader.g.b bVar) {
        long j;
        boolean z;
        com.ss.android.socialbase.downloader.g.b eIl;
        while (true) {
            com.ss.android.socialbase.downloader.g.b bVar2 = (bVar.d() && bVar.f() && (eIl = bVar.eIl()) != null && eIl.s() == bVar.s()) ? eIl : null;
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
                    this.l = this.qbX != null;
                    bVar.b(this.l);
                    try {
                        try {
                            if (!this.l) {
                                List<com.ss.android.socialbase.downloader.g.e> a2 = com.ss.android.socialbase.downloader.m.d.a(this.qbV.eIs(), this.qbV.an(), n, p);
                                a2.add(new com.ss.android.socialbase.downloader.g.e("Chunk-Index", String.valueOf(bVar.s())));
                                com.ss.android.socialbase.downloader.m.d.a(a2, this.qbV);
                                this.qbX = com.ss.android.socialbase.downloader.downloader.b.b(this.qbV.o(), this.qbV.I(), c, a2);
                            }
                            if (this.qbX != null && this.qbW != null) {
                                try {
                                    int b2 = this.qbX.b();
                                    if (b2 < 200 || b2 >= 300) {
                                        this.qbW.a(this.qbX);
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            if (e()) {
                                return false;
                            } else if (this.qbX == null) {
                                throw new com.ss.android.socialbase.downloader.e.a(1022, new IOException("download can't continue, chunk connection is null"));
                            } else {
                                if (!this.l) {
                                    try {
                                        int b3 = this.qbX.b();
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
                                this.qbT = new com.ss.android.socialbase.downloader.downloader.d(this.qbV, c, this.qbX, bVar, this.qbW);
                                if (bVar2 != null) {
                                    long BX = bVar2.BX(false);
                                    if (p != 0 && p >= n) {
                                        BX = (p - n) + 1;
                                    }
                                    this.qbT.a(bVar2.n(), bVar2.p(), BX);
                                }
                                z = true;
                                try {
                                    this.qbT.d();
                                    d();
                                    return true;
                                } catch (com.ss.android.socialbase.downloader.e.a e2) {
                                    e = e2;
                                    if (e()) {
                                        return true;
                                    } else if (com.ss.android.socialbase.downloader.m.d.g(e)) {
                                        this.qbW.a(e, false);
                                        return false;
                                    } else if (!this.qbW.d(e)) {
                                        if (!this.qbV.eIL() || this.qbV.eIM() || this.qbV.eJl() <= 1 || !com.ss.android.socialbase.downloader.m.d.a(e, this.qbV)) {
                                            this.qbW.b(e);
                                            return false;
                                        }
                                        this.qbW.e(e);
                                        return false;
                                    } else if (com.ss.android.socialbase.downloader.m.d.d(e)) {
                                        this.qbW.a(e, true);
                                        return false;
                                    } else {
                                        long j2 = 0;
                                        if (z) {
                                            if (this.qbT == null) {
                                                this.qbW.b(e);
                                                return false;
                                            } else if (com.ss.android.socialbase.downloader.m.a.a(32)) {
                                                j2 = this.qbT.a() - this.qbT.e();
                                                if (j2 > 0) {
                                                    a(bVar, this.qbT.e());
                                                } else if (j2 < 0) {
                                                    j2 = 0;
                                                }
                                            } else {
                                                j2 = this.qbT.a() - j;
                                                a(bVar, j);
                                            }
                                        }
                                        if ((com.ss.android.socialbase.downloader.m.a.a(16) ? this.qbW.a(bVar, e, j2) : this.qbW.a(e, j2)) == h.RETURN) {
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
                        if (this.qbX != null && this.qbW != null) {
                            try {
                                int b4 = this.qbX.b();
                                if (b4 < 200 || b4 >= 300) {
                                    this.qbW.a(this.qbX);
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
        com.ss.android.socialbase.downloader.g.b eIl = bVar.d() ? bVar.eIl() : bVar;
        if (eIl != null) {
            if (eIl.h()) {
                this.qbY.a(eIl.k(), eIl.b(), j);
            }
            eIl.b(j);
            this.qbY.a(eIl.k(), eIl.s(), eIl.b(), j);
        } else if (bVar.d()) {
            this.qbY.a(bVar.k(), bVar.s(), j);
        }
    }

    private void d() {
        if (this.qbX != null) {
            this.qbX.d();
            this.qbX = null;
        }
    }

    private boolean e() {
        return this.j || this.k;
    }

    public void a() {
        this.j = true;
        if (this.qbT != null) {
            this.qbT.b();
        }
    }

    public void b() {
        this.k = true;
        if (this.qbT != null) {
            this.qbT.c();
        }
    }
}
