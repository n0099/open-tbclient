package com.ss.android.socialbase.downloader.j;

import android.os.Process;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f7863a;
    private final int b;
    private final int c;
    private volatile boolean l;
    private volatile boolean m;
    private int p;
    private b qiA;
    private b qiB;
    private volatile Throwable qiC;
    private volatile Future qiD;
    private b qiw;
    private b qix;
    private b qiy;
    private b qiz;
    private final Object d = new Object();
    private final Object e = new Object();
    private final Runnable q = new Runnable() { // from class: com.ss.android.socialbase.downloader.j.a.1
        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [114=6] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            b eIF;
            Process.setThreadPriority(10);
            do {
                try {
                    eIF = a.this.eIF();
                    eIF.b = a.this.f7863a.read(eIF.f7864a);
                    a.this.c(eIF);
                } catch (Throwable th) {
                    try {
                        a.this.qiC = th;
                        th.printStackTrace();
                        synchronized (a.this.e) {
                            a.this.m = true;
                            a.this.e.notify();
                            com.ss.android.socialbase.downloader.m.d.a(a.this.f7863a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.e) {
                            a.this.m = true;
                            a.this.e.notify();
                            com.ss.android.socialbase.downloader.m.d.a(a.this.f7863a);
                            throw th2;
                        }
                    }
                }
            } while (eIF.b != -1);
            synchronized (a.this.e) {
                a.this.m = true;
                a.this.e.notify();
            }
            com.ss.android.socialbase.downloader.m.d.a(a.this.f7863a);
        }
    };

    public a(InputStream inputStream, int i, int i2) throws Throwable {
        this.f7863a = inputStream;
        this.b = i;
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.c = i2;
        c();
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public b eIE() throws com.ss.android.socialbase.downloader.e.a, InterruptedException {
        return eIG();
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
        Future future = this.qiD;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
            }
            this.qiD = null;
        }
    }

    private void c() throws Throwable {
        this.qiD = com.ss.android.socialbase.downloader.downloader.b.eGs().submit(this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b eIF() throws d, InterruptedException {
        b bVar = this.qiy;
        if (bVar != null) {
            if (this.l) {
                throw new d();
            }
            this.qiy = bVar.qiF;
            bVar.qiF = null;
        } else {
            synchronized (this.d) {
                if (this.l) {
                    throw new d();
                }
                bVar = this.qiw;
                if (bVar == null && this.p < this.c) {
                    this.p++;
                    bVar = new b(this.b);
                } else {
                    while (bVar == null) {
                        this.d.wait();
                        if (this.l) {
                            throw new d();
                        }
                        bVar = this.qiw;
                    }
                    this.qiy = bVar.qiF;
                    this.qix = null;
                    this.qiw = null;
                    bVar.qiF = null;
                }
            }
        }
        return bVar;
    }

    private void b(b bVar) {
        synchronized (this.d) {
            b bVar2 = this.qix;
            if (bVar2 == null) {
                this.qix = bVar;
                this.qiw = bVar;
                this.d.notify();
            } else {
                bVar2.qiF = bVar;
                this.qix = bVar;
            }
        }
    }

    private b eIG() throws com.ss.android.socialbase.downloader.e.a, InterruptedException {
        b bVar = this.qiB;
        if (bVar != null) {
            this.qiB = bVar.qiF;
            bVar.qiF = null;
        } else {
            synchronized (this.e) {
                bVar = this.qiz;
                if (bVar == null) {
                    do {
                        if (this.m) {
                            f();
                        }
                        this.e.wait();
                        bVar = this.qiz;
                    } while (bVar == null);
                    this.qiB = bVar.qiF;
                    this.qiA = null;
                    this.qiz = null;
                    bVar.qiF = null;
                } else {
                    this.qiB = bVar.qiF;
                    this.qiA = null;
                    this.qiz = null;
                    bVar.qiF = null;
                }
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b bVar) {
        synchronized (this.e) {
            b bVar2 = this.qiA;
            if (bVar2 == null) {
                this.qiA = bVar;
                this.qiz = bVar;
                this.e.notify();
            } else {
                bVar2.qiF = bVar;
                this.qiA = bVar;
            }
        }
    }

    private void f() throws com.ss.android.socialbase.downloader.e.a {
        Throwable th = this.qiC;
        if (th != null) {
            if (th instanceof d) {
                throw new com.ss.android.socialbase.downloader.e.a(1068, "async reader closed!");
            }
            com.ss.android.socialbase.downloader.m.d.a(th, "async_read");
        }
        throw new com.ss.android.socialbase.downloader.e.a(1069, "async reader terminated!");
    }
}
