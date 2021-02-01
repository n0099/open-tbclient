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
    private final e qhA;
    private g qhB;
    private k qhC;
    private com.ss.android.socialbase.downloader.g.b qhv;
    private com.ss.android.socialbase.downloader.g.b qhw;
    private com.ss.android.socialbase.downloader.downloader.d qhx;
    private final com.ss.android.socialbase.downloader.g.d qhy;
    private com.ss.android.socialbase.downloader.g.c qhz;

    public b(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.g.d dVar, e eVar) {
        this.l = false;
        this.qhw = bVar;
        this.qhy = dVar;
        if (dVar != null) {
            this.qhz = dVar.a();
        }
        this.qhA = eVar;
        this.qhC = com.ss.android.socialbase.downloader.downloader.b.eGk();
        this.qhw.a(this);
    }

    public b(com.ss.android.socialbase.downloader.g.b bVar, com.ss.android.socialbase.downloader.g.d dVar, g gVar, e eVar) {
        this(bVar, dVar, eVar);
        this.qhB = gVar;
    }

    private String c() {
        return this.qhz.O();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        r3.qhv.a(false);
     */
    @Override // java.lang.Runnable
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Process.setThreadPriority(10);
        this.qhv = this.qhw;
        while (true) {
            try {
                this.qhv.a(this);
                if (!d(this.qhv)) {
                    break;
                }
                this.qhv.a(false);
                if (!e()) {
                    this.qhv = this.qhA.RX(this.qhv.s());
                    if (e() || this.qhv == null) {
                        break;
                    }
                    Thread.sleep(50L);
                } else {
                    break;
                }
            } finally {
                if (this.qhv != null) {
                    this.qhv.a(false);
                }
                d();
                this.qhA.a(this);
            }
        }
    }

    public void a(long j, long j2) {
        if (this.qhx != null) {
            this.qhx.a(j, j2);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, IGET]}, finally: {[IGET] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [273=14] */
    /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE] complete}, expected: {[IGET] complete} */
    /* JADX WARN: Finally extract failed */
    private boolean d(com.ss.android.socialbase.downloader.g.b bVar) {
        long j;
        boolean z;
        com.ss.android.socialbase.downloader.g.b eGM;
        while (true) {
            com.ss.android.socialbase.downloader.g.b bVar2 = (bVar.d() && bVar.f() && (eGM = bVar.eGM()) != null && eGM.s() == bVar.s()) ? eGM : null;
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
                    this.l = this.qhB != null;
                    bVar.b(this.l);
                    try {
                        try {
                            if (!this.l) {
                                List<com.ss.android.socialbase.downloader.g.e> a2 = com.ss.android.socialbase.downloader.m.d.a(this.qhz.eGT(), this.qhz.an(), n, p);
                                a2.add(new com.ss.android.socialbase.downloader.g.e("Chunk-Index", String.valueOf(bVar.s())));
                                com.ss.android.socialbase.downloader.m.d.a(a2, this.qhz);
                                this.qhB = com.ss.android.socialbase.downloader.downloader.b.b(this.qhz.o(), this.qhz.I(), c, a2);
                            }
                            if (this.qhB != null && this.qhA != null) {
                                try {
                                    int b2 = this.qhB.b();
                                    if (b2 < 200 || b2 >= 300) {
                                        this.qhA.a(this.qhB);
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            if (e()) {
                                return false;
                            } else if (this.qhB == null) {
                                throw new com.ss.android.socialbase.downloader.e.a(1022, new IOException("download can't continue, chunk connection is null"));
                            } else {
                                if (!this.l) {
                                    try {
                                        int b3 = this.qhB.b();
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
                                this.qhx = new com.ss.android.socialbase.downloader.downloader.d(this.qhz, c, this.qhB, bVar, this.qhA);
                                if (bVar2 != null) {
                                    long Cn = bVar2.Cn(false);
                                    if (p != 0 && p >= n) {
                                        Cn = (p - n) + 1;
                                    }
                                    this.qhx.a(bVar2.n(), bVar2.p(), Cn);
                                }
                                z = true;
                                try {
                                    this.qhx.d();
                                    d();
                                    return true;
                                } catch (com.ss.android.socialbase.downloader.e.a e2) {
                                    e = e2;
                                    if (e()) {
                                        return true;
                                    } else if (com.ss.android.socialbase.downloader.m.d.g(e)) {
                                        this.qhA.a(e, false);
                                        return false;
                                    } else if (!this.qhA.d(e)) {
                                        if (!this.qhz.eHm() || this.qhz.eHn() || this.qhz.eHM() <= 1 || !com.ss.android.socialbase.downloader.m.d.a(e, this.qhz)) {
                                            this.qhA.b(e);
                                            return false;
                                        }
                                        this.qhA.e(e);
                                        return false;
                                    } else if (com.ss.android.socialbase.downloader.m.d.d(e)) {
                                        this.qhA.a(e, true);
                                        return false;
                                    } else {
                                        long j2 = 0;
                                        if (z) {
                                            if (this.qhx == null) {
                                                this.qhA.b(e);
                                                return false;
                                            } else if (com.ss.android.socialbase.downloader.m.a.a(32)) {
                                                j2 = this.qhx.a() - this.qhx.e();
                                                if (j2 > 0) {
                                                    a(bVar, this.qhx.e());
                                                } else if (j2 < 0) {
                                                    j2 = 0;
                                                }
                                            } else {
                                                j2 = this.qhx.a() - j;
                                                a(bVar, j);
                                            }
                                        }
                                        if ((com.ss.android.socialbase.downloader.m.a.a(16) ? this.qhA.a(bVar, e, j2) : this.qhA.a(e, j2)) == h.RETURN) {
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
                        if (this.qhB != null && this.qhA != null) {
                            try {
                                int b4 = this.qhB.b();
                                if (b4 < 200 || b4 >= 300) {
                                    this.qhA.a(this.qhB);
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
        com.ss.android.socialbase.downloader.g.b eGM = bVar.d() ? bVar.eGM() : bVar;
        if (eGM != null) {
            if (eGM.h()) {
                this.qhC.a(eGM.k(), eGM.b(), j);
            }
            eGM.b(j);
            this.qhC.a(eGM.k(), eGM.s(), eGM.b(), j);
        } else if (bVar.d()) {
            this.qhC.a(bVar.k(), bVar.s(), j);
        }
    }

    private void d() {
        if (this.qhB != null) {
            this.qhB.d();
            this.qhB = null;
        }
    }

    private boolean e() {
        return this.j || this.k;
    }

    public void a() {
        this.j = true;
        if (this.qhx != null) {
            this.qhx.b();
        }
    }

    public void b() {
        this.k = true;
        if (this.qhx != null) {
            this.qhx.c();
        }
    }
}
