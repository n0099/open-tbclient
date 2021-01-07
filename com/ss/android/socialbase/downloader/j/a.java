package com.ss.android.socialbase.downloader.j;

import android.os.Process;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes4.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f13502a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13503b;
    private final int c;
    private volatile boolean l;
    private volatile boolean m;
    private int p;
    private b qbB;
    private b qbC;
    private b qbD;
    private b qbE;
    private b qbF;
    private b qbG;
    private volatile Throwable qbH;
    private volatile Future qbI;
    private final Object d = new Object();
    private final Object e = new Object();
    private final Runnable qbJ = new Runnable() { // from class: com.ss.android.socialbase.downloader.j.a.1
        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [114=6] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            b eJU;
            Process.setThreadPriority(10);
            do {
                try {
                    eJU = a.this.eJU();
                    eJU.f13505b = a.this.f13502a.read(eJU.f13504a);
                    a.this.c(eJU);
                } catch (Throwable th) {
                    try {
                        a.this.qbH = th;
                        th.printStackTrace();
                        synchronized (a.this.e) {
                            a.this.m = true;
                            a.this.e.notify();
                            com.ss.android.socialbase.downloader.m.d.a(a.this.f13502a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.e) {
                            a.this.m = true;
                            a.this.e.notify();
                            com.ss.android.socialbase.downloader.m.d.a(a.this.f13502a);
                            throw th2;
                        }
                    }
                }
            } while (eJU.f13505b != -1);
            synchronized (a.this.e) {
                a.this.m = true;
                a.this.e.notify();
            }
            com.ss.android.socialbase.downloader.m.d.a(a.this.f13502a);
        }
    };

    public a(InputStream inputStream, int i, int i2) throws Throwable {
        this.f13502a = inputStream;
        this.f13503b = i;
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.c = i2;
        c();
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public b eJT() throws com.ss.android.socialbase.downloader.e.a, InterruptedException {
        return eJV();
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
        Future future = this.qbI;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
            }
            this.qbI = null;
        }
    }

    private void c() throws Throwable {
        this.qbI = com.ss.android.socialbase.downloader.downloader.b.eHF().submit(this.qbJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b eJU() throws d, InterruptedException {
        b bVar = this.qbD;
        if (bVar != null) {
            if (this.l) {
                throw new d();
            }
            this.qbD = bVar.qbL;
            bVar.qbL = null;
        } else {
            synchronized (this.d) {
                if (this.l) {
                    throw new d();
                }
                bVar = this.qbB;
                if (bVar == null && this.p < this.c) {
                    this.p++;
                    bVar = new b(this.f13503b);
                } else {
                    while (bVar == null) {
                        this.d.wait();
                        if (this.l) {
                            throw new d();
                        }
                        bVar = this.qbB;
                    }
                    this.qbD = bVar.qbL;
                    this.qbC = null;
                    this.qbB = null;
                    bVar.qbL = null;
                }
            }
        }
        return bVar;
    }

    private void b(b bVar) {
        synchronized (this.d) {
            b bVar2 = this.qbC;
            if (bVar2 == null) {
                this.qbC = bVar;
                this.qbB = bVar;
                this.d.notify();
            } else {
                bVar2.qbL = bVar;
                this.qbC = bVar;
            }
        }
    }

    private b eJV() throws com.ss.android.socialbase.downloader.e.a, InterruptedException {
        b bVar = this.qbG;
        if (bVar != null) {
            this.qbG = bVar.qbL;
            bVar.qbL = null;
        } else {
            synchronized (this.e) {
                bVar = this.qbE;
                if (bVar == null) {
                    do {
                        if (this.m) {
                            f();
                        }
                        this.e.wait();
                        bVar = this.qbE;
                    } while (bVar == null);
                    this.qbG = bVar.qbL;
                    this.qbF = null;
                    this.qbE = null;
                    bVar.qbL = null;
                } else {
                    this.qbG = bVar.qbL;
                    this.qbF = null;
                    this.qbE = null;
                    bVar.qbL = null;
                }
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b bVar) {
        synchronized (this.e) {
            b bVar2 = this.qbF;
            if (bVar2 == null) {
                this.qbF = bVar;
                this.qbE = bVar;
                this.e.notify();
            } else {
                bVar2.qbL = bVar;
                this.qbF = bVar;
            }
        }
    }

    private void f() throws com.ss.android.socialbase.downloader.e.a {
        Throwable th = this.qbH;
        if (th != null) {
            if (th instanceof d) {
                throw new com.ss.android.socialbase.downloader.e.a(1068, "async reader closed!");
            }
            com.ss.android.socialbase.downloader.m.d.a(th, "async_read");
        }
        throw new com.ss.android.socialbase.downloader.e.a(1069, "async reader terminated!");
    }
}
