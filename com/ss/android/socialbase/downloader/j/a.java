package com.ss.android.socialbase.downloader.j;

import android.os.Process;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes4.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f13501a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13502b;
    private final int c;
    private volatile boolean l;
    private volatile boolean m;
    private int p;
    private b pZT;
    private b pZU;
    private b pZV;
    private b pZW;
    private b pZX;
    private b pZY;
    private volatile Throwable pZZ;
    private volatile Future qaa;
    private final Object d = new Object();
    private final Object e = new Object();
    private final Runnable qab = new Runnable() { // from class: com.ss.android.socialbase.downloader.j.a.1
        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [114=6] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            b eJq;
            Process.setThreadPriority(10);
            do {
                try {
                    eJq = a.this.eJq();
                    eJq.f13504b = a.this.f13501a.read(eJq.f13503a);
                    a.this.c(eJq);
                } catch (Throwable th) {
                    try {
                        a.this.pZZ = th;
                        th.printStackTrace();
                        synchronized (a.this.e) {
                            a.this.m = true;
                            a.this.e.notify();
                            com.ss.android.socialbase.downloader.m.d.a(a.this.f13501a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.e) {
                            a.this.m = true;
                            a.this.e.notify();
                            com.ss.android.socialbase.downloader.m.d.a(a.this.f13501a);
                            throw th2;
                        }
                    }
                }
            } while (eJq.f13504b != -1);
            synchronized (a.this.e) {
                a.this.m = true;
                a.this.e.notify();
            }
            com.ss.android.socialbase.downloader.m.d.a(a.this.f13501a);
        }
    };

    public a(InputStream inputStream, int i, int i2) throws Throwable {
        this.f13501a = inputStream;
        this.f13502b = i;
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.c = i2;
        c();
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public b eJp() throws com.ss.android.socialbase.downloader.e.a, InterruptedException {
        return eJr();
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
        Future future = this.qaa;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
            }
            this.qaa = null;
        }
    }

    private void c() throws Throwable {
        this.qaa = com.ss.android.socialbase.downloader.downloader.b.eHb().submit(this.qab);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b eJq() throws d, InterruptedException {
        b bVar = this.pZV;
        if (bVar != null) {
            if (this.l) {
                throw new d();
            }
            this.pZV = bVar.qad;
            bVar.qad = null;
        } else {
            synchronized (this.d) {
                if (this.l) {
                    throw new d();
                }
                bVar = this.pZT;
                if (bVar == null && this.p < this.c) {
                    this.p++;
                    bVar = new b(this.f13502b);
                } else {
                    while (bVar == null) {
                        this.d.wait();
                        if (this.l) {
                            throw new d();
                        }
                        bVar = this.pZT;
                    }
                    this.pZV = bVar.qad;
                    this.pZU = null;
                    this.pZT = null;
                    bVar.qad = null;
                }
            }
        }
        return bVar;
    }

    private void b(b bVar) {
        synchronized (this.d) {
            b bVar2 = this.pZU;
            if (bVar2 == null) {
                this.pZU = bVar;
                this.pZT = bVar;
                this.d.notify();
            } else {
                bVar2.qad = bVar;
                this.pZU = bVar;
            }
        }
    }

    private b eJr() throws com.ss.android.socialbase.downloader.e.a, InterruptedException {
        b bVar = this.pZY;
        if (bVar != null) {
            this.pZY = bVar.qad;
            bVar.qad = null;
        } else {
            synchronized (this.e) {
                bVar = this.pZW;
                if (bVar == null) {
                    do {
                        if (this.m) {
                            f();
                        }
                        this.e.wait();
                        bVar = this.pZW;
                    } while (bVar == null);
                    this.pZY = bVar.qad;
                    this.pZX = null;
                    this.pZW = null;
                    bVar.qad = null;
                } else {
                    this.pZY = bVar.qad;
                    this.pZX = null;
                    this.pZW = null;
                    bVar.qad = null;
                }
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b bVar) {
        synchronized (this.e) {
            b bVar2 = this.pZX;
            if (bVar2 == null) {
                this.pZX = bVar;
                this.pZW = bVar;
                this.e.notify();
            } else {
                bVar2.qad = bVar;
                this.pZX = bVar;
            }
        }
    }

    private void f() throws com.ss.android.socialbase.downloader.e.a {
        Throwable th = this.pZZ;
        if (th != null) {
            if (th instanceof d) {
                throw new com.ss.android.socialbase.downloader.e.a(1068, "async reader closed!");
            }
            com.ss.android.socialbase.downloader.m.d.a(th, "async_read");
        }
        throw new com.ss.android.socialbase.downloader.e.a(1069, "async reader terminated!");
    }
}
