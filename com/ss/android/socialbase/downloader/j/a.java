package com.ss.android.socialbase.downloader.j;

import android.os.Process;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f13204a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13205b;
    private final int c;
    private volatile boolean l;
    private volatile boolean m;
    private int p;
    private b qhf;
    private b qhg;
    private b qhh;
    private b qhi;
    private b qhj;
    private b qhk;
    private volatile Throwable qhl;
    private volatile Future qhm;
    private final Object d = new Object();
    private final Object e = new Object();
    private final Runnable qhn = new Runnable() { // from class: com.ss.android.socialbase.downloader.j.a.1
        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [114=6] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            b eIv;
            Process.setThreadPriority(10);
            do {
                try {
                    eIv = a.this.eIv();
                    eIv.f13207b = a.this.f13204a.read(eIv.f13206a);
                    a.this.c(eIv);
                } catch (Throwable th) {
                    try {
                        a.this.qhl = th;
                        th.printStackTrace();
                        synchronized (a.this.e) {
                            a.this.m = true;
                            a.this.e.notify();
                            com.ss.android.socialbase.downloader.m.d.a(a.this.f13204a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.e) {
                            a.this.m = true;
                            a.this.e.notify();
                            com.ss.android.socialbase.downloader.m.d.a(a.this.f13204a);
                            throw th2;
                        }
                    }
                }
            } while (eIv.f13207b != -1);
            synchronized (a.this.e) {
                a.this.m = true;
                a.this.e.notify();
            }
            com.ss.android.socialbase.downloader.m.d.a(a.this.f13204a);
        }
    };

    public a(InputStream inputStream, int i, int i2) throws Throwable {
        this.f13204a = inputStream;
        this.f13205b = i;
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.c = i2;
        c();
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public b eIu() throws com.ss.android.socialbase.downloader.e.a, InterruptedException {
        return eIw();
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
        Future future = this.qhm;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
            }
            this.qhm = null;
        }
    }

    private void c() throws Throwable {
        this.qhm = com.ss.android.socialbase.downloader.downloader.b.eGg().submit(this.qhn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b eIv() throws d, InterruptedException {
        b bVar = this.qhh;
        if (bVar != null) {
            if (this.l) {
                throw new d();
            }
            this.qhh = bVar.qhp;
            bVar.qhp = null;
        } else {
            synchronized (this.d) {
                if (this.l) {
                    throw new d();
                }
                bVar = this.qhf;
                if (bVar == null && this.p < this.c) {
                    this.p++;
                    bVar = new b(this.f13205b);
                } else {
                    while (bVar == null) {
                        this.d.wait();
                        if (this.l) {
                            throw new d();
                        }
                        bVar = this.qhf;
                    }
                    this.qhh = bVar.qhp;
                    this.qhg = null;
                    this.qhf = null;
                    bVar.qhp = null;
                }
            }
        }
        return bVar;
    }

    private void b(b bVar) {
        synchronized (this.d) {
            b bVar2 = this.qhg;
            if (bVar2 == null) {
                this.qhg = bVar;
                this.qhf = bVar;
                this.d.notify();
            } else {
                bVar2.qhp = bVar;
                this.qhg = bVar;
            }
        }
    }

    private b eIw() throws com.ss.android.socialbase.downloader.e.a, InterruptedException {
        b bVar = this.qhk;
        if (bVar != null) {
            this.qhk = bVar.qhp;
            bVar.qhp = null;
        } else {
            synchronized (this.e) {
                bVar = this.qhi;
                if (bVar == null) {
                    do {
                        if (this.m) {
                            f();
                        }
                        this.e.wait();
                        bVar = this.qhi;
                    } while (bVar == null);
                    this.qhk = bVar.qhp;
                    this.qhj = null;
                    this.qhi = null;
                    bVar.qhp = null;
                } else {
                    this.qhk = bVar.qhp;
                    this.qhj = null;
                    this.qhi = null;
                    bVar.qhp = null;
                }
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b bVar) {
        synchronized (this.e) {
            b bVar2 = this.qhj;
            if (bVar2 == null) {
                this.qhj = bVar;
                this.qhi = bVar;
                this.e.notify();
            } else {
                bVar2.qhp = bVar;
                this.qhj = bVar;
            }
        }
    }

    private void f() throws com.ss.android.socialbase.downloader.e.a {
        Throwable th = this.qhl;
        if (th != null) {
            if (th instanceof d) {
                throw new com.ss.android.socialbase.downloader.e.a(1068, "async reader closed!");
            }
            com.ss.android.socialbase.downloader.m.d.a(th, "async_read");
        }
        throw new com.ss.android.socialbase.downloader.e.a(1069, "async reader terminated!");
    }
}
