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
    private static final String f13211a = b.class.getSimpleName();
    private volatile boolean j;
    private volatile boolean k;
    private boolean l;
    private com.ss.android.socialbase.downloader.g.b qhV;
    private com.ss.android.socialbase.downloader.g.b qhW;
    private com.ss.android.socialbase.downloader.downloader.d qhX;
    private final com.ss.android.socialbase.downloader.g.d qhY;
    private com.ss.android.socialbase.downloader.g.c qhZ;
    private final e qia;
    private g qib;
    private k qic;

    public b(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.g.d dVar, e eVar) {
        this.l = false;
        this.qhW = bVar;
        this.qhY = dVar;
        if (dVar != null) {
            this.qhZ = dVar.a();
        }
        this.qia = eVar;
        this.qic = com.ss.android.socialbase.downloader.downloader.b.eGs();
        this.qhW.a(this);
    }

    public b(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.g.d dVar, g gVar, e eVar) {
        this(bVar, dVar, eVar);
        this.qib = gVar;
    }

    private String c() {
        return this.qhZ.O();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        r3.qhV.a(false);
     */
    @Override // java.lang.Runnable
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Process.setThreadPriority(10);
        this.qhV = this.qhW;
        while (true) {
            try {
                this.qhV.a(this);
                if (!d(this.qhV)) {
                    break;
                }
                this.qhV.a(false);
                if (!e()) {
                    this.qhV = this.qia.RY(this.qhV.s());
                    if (e() || this.qhV == null) {
                        break;
                    }
                    Thread.sleep(50L);
                } else {
                    break;
                }
            } finally {
                if (this.qhV != null) {
                    this.qhV.a(false);
                }
                d();
                this.qia.a(this);
            }
        }
    }

    public void a(long j, long j2) {
        if (this.qhX != null) {
            this.qhX.a(j, j2);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, IGET]}, finally: {[IGET] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [273=14] */
    /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE] complete}, expected: {[IGET] complete} */
    /* JADX WARN: Finally extract failed */
    private boolean d(com.ss.android.socialbase.downloader.g.b bVar) {
        long j;
        boolean z;
        com.ss.android.socialbase.downloader.g.b eGU;
        while (true) {
            com.ss.android.socialbase.downloader.g.b bVar2 = (bVar.d() && bVar.f() && (eGU = bVar.eGU()) != null && eGU.s() == bVar.s()) ? eGU : null;
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
                    this.l = this.qib != null;
                    bVar.b(this.l);
                    try {
                        try {
                            if (!this.l) {
                                List<com.ss.android.socialbase.downloader.g.e> a2 = com.ss.android.socialbase.downloader.m.d.a(this.qhZ.eHb(), this.qhZ.an(), n, p);
                                a2.add(new com.ss.android.socialbase.downloader.g.e("Chunk-Index", String.valueOf(bVar.s())));
                                com.ss.android.socialbase.downloader.m.d.a(a2, this.qhZ);
                                this.qib = com.ss.android.socialbase.downloader.downloader.b.b(this.qhZ.o(), this.qhZ.I(), c, a2);
                            }
                            if (this.qib != null && this.qia != null) {
                                try {
                                    int b2 = this.qib.b();
                                    if (b2 < 200 || b2 >= 300) {
                                        this.qia.a(this.qib);
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            if (e()) {
                                return false;
                            } else if (this.qib == null) {
                                throw new com.ss.android.socialbase.downloader.e.a(1022, new IOException("download can't continue, chunk connection is null"));
                            } else {
                                if (!this.l) {
                                    try {
                                        int b3 = this.qib.b();
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
                                this.qhX = new com.ss.android.socialbase.downloader.downloader.d(this.qhZ, c, this.qib, bVar, this.qia);
                                if (bVar2 != null) {
                                    long Cn = bVar2.Cn(false);
                                    if (p != 0 && p >= n) {
                                        Cn = (p - n) + 1;
                                    }
                                    this.qhX.a(bVar2.n(), bVar2.p(), Cn);
                                }
                                z = true;
                                try {
                                    this.qhX.d();
                                    d();
                                    return true;
                                } catch (com.ss.android.socialbase.downloader.e.a e2) {
                                    e = e2;
                                    if (e()) {
                                        return true;
                                    } else if (com.ss.android.socialbase.downloader.m.d.g(e)) {
                                        this.qia.a(e, false);
                                        return false;
                                    } else if (!this.qia.d(e)) {
                                        if (!this.qhZ.eHu() || this.qhZ.eHv() || this.qhZ.eHU() <= 1 || !com.ss.android.socialbase.downloader.m.d.a(e, this.qhZ)) {
                                            this.qia.b(e);
                                            return false;
                                        }
                                        this.qia.e(e);
                                        return false;
                                    } else if (com.ss.android.socialbase.downloader.m.d.d(e)) {
                                        this.qia.a(e, true);
                                        return false;
                                    } else {
                                        long j2 = 0;
                                        if (z) {
                                            if (this.qhX == null) {
                                                this.qia.b(e);
                                                return false;
                                            } else if (com.ss.android.socialbase.downloader.m.a.a(32)) {
                                                j2 = this.qhX.a() - this.qhX.e();
                                                if (j2 > 0) {
                                                    a(bVar, this.qhX.e());
                                                } else if (j2 < 0) {
                                                    j2 = 0;
                                                }
                                            } else {
                                                j2 = this.qhX.a() - j;
                                                a(bVar, j);
                                            }
                                        }
                                        if ((com.ss.android.socialbase.downloader.m.a.a(16) ? this.qia.a(bVar, e, j2) : this.qia.a(e, j2)) == h.RETURN) {
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
                        if (this.qib != null && this.qia != null) {
                            try {
                                int b4 = this.qib.b();
                                if (b4 < 200 || b4 >= 300) {
                                    this.qia.a(this.qib);
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
        com.ss.android.socialbase.downloader.g.b eGU = bVar.d() ? bVar.eGU() : bVar;
        if (eGU != null) {
            if (eGU.h()) {
                this.qic.a(eGU.k(), eGU.b(), j);
            }
            eGU.b(j);
            this.qic.a(eGU.k(), eGU.s(), eGU.b(), j);
        } else if (bVar.d()) {
            this.qic.a(bVar.k(), bVar.s(), j);
        }
    }

    private void d() {
        if (this.qib != null) {
            this.qib.d();
            this.qib = null;
        }
    }

    private boolean e() {
        return this.j || this.k;
    }

    public void a() {
        this.j = true;
        if (this.qhX != null) {
            this.qhX.b();
        }
    }

    public void b() {
        this.k = true;
        if (this.qhX != null) {
            this.qhX.c();
        }
    }
}
