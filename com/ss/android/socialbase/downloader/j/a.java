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
    private b qhF;
    private b qhG;
    private b qhH;
    private b qhI;
    private b qhJ;
    private b qhK;
    private volatile Throwable qhL;
    private volatile Future qhM;
    private final Object d = new Object();
    private final Object e = new Object();
    private final Runnable qhN = new Runnable() { // from class: com.ss.android.socialbase.downloader.j.a.1
        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [114=6] */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            b eID;
            Process.setThreadPriority(10);
            do {
                try {
                    eID = a.this.eID();
                    eID.f13207b = a.this.f13204a.read(eID.f13206a);
                    a.this.c(eID);
                } catch (Throwable th) {
                    try {
                        a.this.qhL = th;
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
            } while (eID.f13207b != -1);
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
    public b eIC() throws com.ss.android.socialbase.downloader.e.a, InterruptedException {
        return eIE();
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
        Future future = this.qhM;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
            }
            this.qhM = null;
        }
    }

    private void c() throws Throwable {
        this.qhM = com.ss.android.socialbase.downloader.downloader.b.eGo().submit(this.qhN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b eID() throws d, InterruptedException {
        b bVar = this.qhH;
        if (bVar != null) {
            if (this.l) {
                throw new d();
            }
            this.qhH = bVar.qhP;
            bVar.qhP = null;
        } else {
            synchronized (this.d) {
                if (this.l) {
                    throw new d();
                }
                bVar = this.qhF;
                if (bVar == null && this.p < this.c) {
                    this.p++;
                    bVar = new b(this.f13205b);
                } else {
                    while (bVar == null) {
                        this.d.wait();
                        if (this.l) {
                            throw new d();
                        }
                        bVar = this.qhF;
                    }
                    this.qhH = bVar.qhP;
                    this.qhG = null;
                    this.qhF = null;
                    bVar.qhP = null;
                }
            }
        }
        return bVar;
    }

    private void b(b bVar) {
        synchronized (this.d) {
            b bVar2 = this.qhG;
            if (bVar2 == null) {
                this.qhG = bVar;
                this.qhF = bVar;
                this.d.notify();
            } else {
                bVar2.qhP = bVar;
                this.qhG = bVar;
            }
        }
    }

    private b eIE() throws com.ss.android.socialbase.downloader.e.a, InterruptedException {
        b bVar = this.qhK;
        if (bVar != null) {
            this.qhK = bVar.qhP;
            bVar.qhP = null;
        } else {
            synchronized (this.e) {
                bVar = this.qhI;
                if (bVar == null) {
                    do {
                        if (this.m) {
                            f();
                        }
                        this.e.wait();
                        bVar = this.qhI;
                    } while (bVar == null);
                    this.qhK = bVar.qhP;
                    this.qhJ = null;
                    this.qhI = null;
                    bVar.qhP = null;
                } else {
                    this.qhK = bVar.qhP;
                    this.qhJ = null;
                    this.qhI = null;
                    bVar.qhP = null;
                }
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b bVar) {
        synchronized (this.e) {
            b bVar2 = this.qhJ;
            if (bVar2 == null) {
                this.qhJ = bVar;
                this.qhI = bVar;
                this.e.notify();
            } else {
                bVar2.qhP = bVar;
                this.qhJ = bVar;
            }
        }
    }

    private void f() throws com.ss.android.socialbase.downloader.e.a {
        Throwable th = this.qhL;
        if (th != null) {
            if (th instanceof d) {
                throw new com.ss.android.socialbase.downloader.e.a(1068, "async reader closed!");
            }
            com.ss.android.socialbase.downloader.m.d.a(th, "async_read");
        }
        throw new com.ss.android.socialbase.downloader.e.a(1069, "async reader terminated!");
    }
}
