package com.ss.android.socialbase.downloader.j;

import android.os.Process;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes4.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f13202a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13203b;
    private final int c;
    private volatile boolean l;
    private volatile boolean m;
    private int p;
    private b pXb;
    private b pXc;
    private b pXd;
    private b pXe;
    private b pXf;
    private b pXg;
    private volatile Throwable pXh;
    private volatile Future pXi;
    private final Object d = new Object();
    private final Object e = new Object();
    private final Runnable pXj = new Runnable() { // from class: com.ss.android.socialbase.downloader.j.a.1
        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [114=6] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            b eGe;
            Process.setThreadPriority(10);
            do {
                try {
                    eGe = a.this.eGe();
                    eGe.f13205b = a.this.f13202a.read(eGe.f13204a);
                    a.this.c(eGe);
                } catch (Throwable th) {
                    try {
                        a.this.pXh = th;
                        th.printStackTrace();
                        synchronized (a.this.e) {
                            a.this.m = true;
                            a.this.e.notify();
                            com.ss.android.socialbase.downloader.m.d.a(a.this.f13202a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.e) {
                            a.this.m = true;
                            a.this.e.notify();
                            com.ss.android.socialbase.downloader.m.d.a(a.this.f13202a);
                            throw th2;
                        }
                    }
                }
            } while (eGe.f13205b != -1);
            synchronized (a.this.e) {
                a.this.m = true;
                a.this.e.notify();
            }
            com.ss.android.socialbase.downloader.m.d.a(a.this.f13202a);
        }
    };

    public a(InputStream inputStream, int i, int i2) throws Throwable {
        this.f13202a = inputStream;
        this.f13203b = i;
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.c = i2;
        c();
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public b eGd() throws com.ss.android.socialbase.downloader.e.a, InterruptedException {
        return eGf();
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public void a(b bVar) {
        b(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public void b() {
        synchronized (this.d) {
            this.l = true;
            this.d.notify();
        }
        Future future = this.pXi;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
            }
            this.pXi = null;
        }
    }

    private void c() throws Throwable {
        this.pXi = com.ss.android.socialbase.downloader.downloader.b.eDP().submit(this.pXj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b eGe() throws d, InterruptedException {
        b bVar = this.pXd;
        if (bVar != null) {
            if (this.l) {
                throw new d();
            }
            this.pXd = bVar.pXl;
            bVar.pXl = null;
        } else {
            synchronized (this.d) {
                if (this.l) {
                    throw new d();
                }
                bVar = this.pXb;
                if (bVar == null && this.p < this.c) {
                    this.p++;
                    bVar = new b(this.f13203b);
                } else {
                    while (bVar == null) {
                        this.d.wait();
                        if (this.l) {
                            throw new d();
                        }
                        bVar = this.pXb;
                    }
                    this.pXd = bVar.pXl;
                    this.pXc = null;
                    this.pXb = null;
                    bVar.pXl = null;
                }
            }
        }
        return bVar;
    }

    private void b(b bVar) {
        synchronized (this.d) {
            b bVar2 = this.pXc;
            if (bVar2 == null) {
                this.pXc = bVar;
                this.pXb = bVar;
                this.d.notify();
            } else {
                bVar2.pXl = bVar;
                this.pXc = bVar;
            }
        }
    }

    private b eGf() throws com.ss.android.socialbase.downloader.e.a, InterruptedException {
        b bVar = this.pXg;
        if (bVar != null) {
            this.pXg = bVar.pXl;
            bVar.pXl = null;
        } else {
            synchronized (this.e) {
                bVar = this.pXe;
                if (bVar == null) {
                    do {
                        if (this.m) {
                            f();
                        }
                        this.e.wait();
                        bVar = this.pXe;
                    } while (bVar == null);
                    this.pXg = bVar.pXl;
                    this.pXf = null;
                    this.pXe = null;
                    bVar.pXl = null;
                } else {
                    this.pXg = bVar.pXl;
                    this.pXf = null;
                    this.pXe = null;
                    bVar.pXl = null;
                }
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b bVar) {
        synchronized (this.e) {
            b bVar2 = this.pXf;
            if (bVar2 == null) {
                this.pXf = bVar;
                this.pXe = bVar;
                this.e.notify();
            } else {
                bVar2.pXl = bVar;
                this.pXf = bVar;
            }
        }
    }

    private void f() throws com.ss.android.socialbase.downloader.e.a {
        Throwable th = this.pXh;
        if (th != null) {
            if (th instanceof d) {
                throw new com.ss.android.socialbase.downloader.e.a(1068, "async reader closed!");
            }
            com.ss.android.socialbase.downloader.m.d.a(th, "async_read");
        }
        throw new com.ss.android.socialbase.downloader.e.a(1069, "async reader terminated!");
    }
}
