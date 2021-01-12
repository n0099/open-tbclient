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
    private b pXa;
    private b pXb;
    private b pXc;
    private b pXd;
    private b pXe;
    private b pXf;
    private volatile Throwable pXg;
    private volatile Future pXh;
    private final Object d = new Object();
    private final Object e = new Object();
    private final Runnable pXi = new Runnable() { // from class: com.ss.android.socialbase.downloader.j.a.1
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
                        a.this.pXg = th;
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
        Future future = this.pXh;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
            }
            this.pXh = null;
        }
    }

    private void c() throws Throwable {
        this.pXh = com.ss.android.socialbase.downloader.downloader.b.eDP().submit(this.pXi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b eGe() throws d, InterruptedException {
        b bVar = this.pXc;
        if (bVar != null) {
            if (this.l) {
                throw new d();
            }
            this.pXc = bVar.pXk;
            bVar.pXk = null;
        } else {
            synchronized (this.d) {
                if (this.l) {
                    throw new d();
                }
                bVar = this.pXa;
                if (bVar == null && this.p < this.c) {
                    this.p++;
                    bVar = new b(this.f13203b);
                } else {
                    while (bVar == null) {
                        this.d.wait();
                        if (this.l) {
                            throw new d();
                        }
                        bVar = this.pXa;
                    }
                    this.pXc = bVar.pXk;
                    this.pXb = null;
                    this.pXa = null;
                    bVar.pXk = null;
                }
            }
        }
        return bVar;
    }

    private void b(b bVar) {
        synchronized (this.d) {
            b bVar2 = this.pXb;
            if (bVar2 == null) {
                this.pXb = bVar;
                this.pXa = bVar;
                this.d.notify();
            } else {
                bVar2.pXk = bVar;
                this.pXb = bVar;
            }
        }
    }

    private b eGf() throws com.ss.android.socialbase.downloader.e.a, InterruptedException {
        b bVar = this.pXf;
        if (bVar != null) {
            this.pXf = bVar.pXk;
            bVar.pXk = null;
        } else {
            synchronized (this.e) {
                bVar = this.pXd;
                if (bVar == null) {
                    do {
                        if (this.m) {
                            f();
                        }
                        this.e.wait();
                        bVar = this.pXd;
                    } while (bVar == null);
                    this.pXf = bVar.pXk;
                    this.pXe = null;
                    this.pXd = null;
                    bVar.pXk = null;
                } else {
                    this.pXf = bVar.pXk;
                    this.pXe = null;
                    this.pXd = null;
                    bVar.pXk = null;
                }
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b bVar) {
        synchronized (this.e) {
            b bVar2 = this.pXe;
            if (bVar2 == null) {
                this.pXe = bVar;
                this.pXd = bVar;
                this.e.notify();
            } else {
                bVar2.pXk = bVar;
                this.pXe = bVar;
            }
        }
    }

    private void f() throws com.ss.android.socialbase.downloader.e.a {
        Throwable th = this.pXg;
        if (th != null) {
            if (th instanceof d) {
                throw new com.ss.android.socialbase.downloader.e.a(1068, "async reader closed!");
            }
            com.ss.android.socialbase.downloader.m.d.a(th, "async_read");
        }
        throw new com.ss.android.socialbase.downloader.e.a(1069, "async reader terminated!");
    }
}
