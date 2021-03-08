package com.ss.android.socialbase.downloader.l;

import android.annotation.SuppressLint;
import android.os.Process;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.e.h;
import com.ss.android.socialbase.downloader.i.g;
import java.io.IOException;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7867a = b.class.getSimpleName();
    private volatile boolean j;
    private volatile boolean k;
    private boolean l;
    private com.ss.android.socialbase.downloader.g.b qiL;
    private com.ss.android.socialbase.downloader.g.b qiM;
    private com.ss.android.socialbase.downloader.downloader.d qiN;
    private final com.ss.android.socialbase.downloader.g.d qiO;
    private com.ss.android.socialbase.downloader.g.c qiP;
    private final e qiQ;
    private g qiR;
    private k qiS;

    public b(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.g.d dVar, e eVar) {
        this.l = false;
        this.qiM = bVar;
        this.qiO = dVar;
        if (dVar != null) {
            this.qiP = dVar.a();
        }
        this.qiQ = eVar;
        this.qiS = com.ss.android.socialbase.downloader.downloader.b.eGw();
        this.qiM.a(this);
    }

    public b(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.g.d dVar, g gVar, e eVar) {
        this(bVar, dVar, eVar);
        this.qiR = gVar;
    }

    private String c() {
        return this.qiP.O();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        r3.qiL.a(false);
     */
    @Override // java.lang.Runnable
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Process.setThreadPriority(10);
        this.qiL = this.qiM;
        while (true) {
            try {
                this.qiL.a(this);
                if (!d(this.qiL)) {
                    break;
                }
                this.qiL.a(false);
                if (!e()) {
                    this.qiL = this.qiQ.Sc(this.qiL.s());
                    if (e() || this.qiL == null) {
                        break;
                    }
                    Thread.sleep(50L);
                } else {
                    break;
                }
            } finally {
                if (this.qiL != null) {
                    this.qiL.a(false);
                }
                d();
                this.qiQ.a(this);
            }
        }
    }

    public void a(long j, long j2) {
        if (this.qiN != null) {
            this.qiN.a(j, j2);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, IGET]}, finally: {[IGET] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [273=14] */
    /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE] complete}, expected: {[IGET] complete} */
    /* JADX WARN: Finally extract failed */
    private boolean d(com.ss.android.socialbase.downloader.g.b bVar) {
        long j;
        boolean z;
        com.ss.android.socialbase.downloader.g.b eGY;
        while (true) {
            com.ss.android.socialbase.downloader.g.b bVar2 = (bVar.d() && bVar.f() && (eGY = bVar.eGY()) != null && eGY.s() == bVar.s()) ? eGY : null;
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
                    this.l = this.qiR != null;
                    bVar.b(this.l);
                    try {
                        try {
                            if (!this.l) {
                                List<com.ss.android.socialbase.downloader.g.e> a2 = com.ss.android.socialbase.downloader.m.d.a(this.qiP.eHf(), this.qiP.eHo(), n, p);
                                a2.add(new com.ss.android.socialbase.downloader.g.e("Chunk-Index", String.valueOf(bVar.s())));
                                com.ss.android.socialbase.downloader.m.d.a(a2, this.qiP);
                                this.qiR = com.ss.android.socialbase.downloader.downloader.b.b(this.qiP.o(), this.qiP.I(), c, a2);
                            }
                            if (this.qiR != null && this.qiQ != null) {
                                try {
                                    int b = this.qiR.b();
                                    if (b < 200 || b >= 300) {
                                        this.qiQ.a(this.qiR);
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            if (e()) {
                                return false;
                            } else if (this.qiR == null) {
                                throw new com.ss.android.socialbase.downloader.e.a(1022, new IOException("download can't continue, chunk connection is null"));
                            } else {
                                if (!this.l) {
                                    try {
                                        int b2 = this.qiR.b();
                                        if (!com.ss.android.socialbase.downloader.m.d.d(b2)) {
                                            throw new com.ss.android.socialbase.downloader.e.a(1002, String.format("Http response error , code is : %s ", String.valueOf(b2)));
                                            break;
                                        }
                                    } catch (com.ss.android.socialbase.downloader.e.a e) {
                                        throw e;
                                    } catch (Throwable th2) {
                                        com.ss.android.socialbase.downloader.m.d.a(th2, "ChunkRunnableGetResponseCode");
                                    }
                                }
                                this.qiN = new com.ss.android.socialbase.downloader.downloader.d(this.qiP, c, this.qiR, bVar, this.qiQ);
                                if (bVar2 != null) {
                                    long Cl = bVar2.Cl(false);
                                    if (p != 0 && p >= n) {
                                        Cl = (p - n) + 1;
                                    }
                                    this.qiN.a(bVar2.n(), bVar2.p(), Cl);
                                }
                                z = true;
                                try {
                                    this.qiN.d();
                                    d();
                                    return true;
                                } catch (com.ss.android.socialbase.downloader.e.a e2) {
                                    e = e2;
                                    if (e()) {
                                        return true;
                                    } else if (com.ss.android.socialbase.downloader.m.d.g(e)) {
                                        this.qiQ.a(e, false);
                                        return false;
                                    } else if (!this.qiQ.d(e)) {
                                        if (!this.qiP.aC() || this.qiP.eHx() || this.qiP.eHW() <= 1 || !com.ss.android.socialbase.downloader.m.d.a(e, this.qiP)) {
                                            this.qiQ.b(e);
                                            return false;
                                        }
                                        this.qiQ.e(e);
                                        return false;
                                    } else if (com.ss.android.socialbase.downloader.m.d.d(e)) {
                                        this.qiQ.a(e, true);
                                        return false;
                                    } else {
                                        long j2 = 0;
                                        if (z) {
                                            if (this.qiN == null) {
                                                this.qiQ.b(e);
                                                return false;
                                            } else if (com.ss.android.socialbase.downloader.m.a.a(32)) {
                                                j2 = this.qiN.a() - this.qiN.e();
                                                if (j2 > 0) {
                                                    a(bVar, this.qiN.e());
                                                } else if (j2 < 0) {
                                                    j2 = 0;
                                                }
                                            } else {
                                                j2 = this.qiN.a() - j;
                                                a(bVar, j);
                                            }
                                        }
                                        if ((com.ss.android.socialbase.downloader.m.a.a(16) ? this.qiQ.a(bVar, e, j2) : this.qiQ.a(e, j2)) == h.RETURN) {
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
                        if (this.qiR != null && this.qiQ != null) {
                            try {
                                int b3 = this.qiR.b();
                                if (b3 < 200 || b3 >= 300) {
                                    this.qiQ.a(this.qiR);
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
        com.ss.android.socialbase.downloader.g.b eGY = bVar.d() ? bVar.eGY() : bVar;
        if (eGY != null) {
            if (eGY.h()) {
                this.qiS.a(eGY.k(), eGY.b(), j);
            }
            eGY.b(j);
            this.qiS.a(eGY.k(), eGY.s(), eGY.b(), j);
        } else if (bVar.d()) {
            this.qiS.a(bVar.k(), bVar.s(), j);
        }
    }

    private void d() {
        if (this.qiR != null) {
            this.qiR.d();
            this.qiR = null;
        }
    }

    private boolean e() {
        return this.j || this.k;
    }

    public void a() {
        this.j = true;
        if (this.qiN != null) {
            this.qiN.b();
        }
    }

    public void b() {
        this.k = true;
        if (this.qiN != null) {
            this.qiN.c();
        }
    }
}
