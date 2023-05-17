package com.ss.android.socialbase.downloader.e;

import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.i.f;
import java.io.InputStream;
import java.util.concurrent.Future;
/* loaded from: classes10.dex */
public class a implements b {
    public final InputStream a;
    public final int b;
    public final int c;
    public com.ss.android.socialbase.downloader.f.a f;
    public com.ss.android.socialbase.downloader.f.a g;
    public com.ss.android.socialbase.downloader.f.a h;
    public com.ss.android.socialbase.downloader.f.a i;
    public com.ss.android.socialbase.downloader.f.a j;
    public com.ss.android.socialbase.downloader.f.a k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile Throwable n;
    public volatile Future o;
    public int p;
    public final Object d = new Object();
    public final Object e = new Object();
    public final Runnable q = new Runnable() { // from class: com.ss.android.socialbase.downloader.e.a.1
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.f.a d;
            Process.setThreadPriority(10);
            do {
                try {
                    d = a.this.d();
                    d.c = a.this.a.read(d.a);
                    a.this.c(d);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.e) {
                            a.this.m = true;
                            a.this.e.notify();
                            f.a(a.this.a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.e) {
                            a.this.m = true;
                            a.this.e.notify();
                            f.a(a.this.a);
                            throw th2;
                        }
                    }
                }
            } while (d.c != -1);
            synchronized (a.this.e) {
                a.this.m = true;
                a.this.e.notify();
            }
            f.a(a.this.a);
        }
    };

    public a(InputStream inputStream, int i, int i2) throws Throwable {
        this.a = inputStream;
        this.b = i;
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > 64) {
            i2 = 64;
        }
        this.c = i2;
        c();
    }

    private void b(com.ss.android.socialbase.downloader.f.a aVar) {
        synchronized (this.d) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.g;
            if (aVar2 == null) {
                this.g = aVar;
                this.f = aVar;
                this.d.notify();
            } else {
                aVar2.d = aVar;
                this.g = aVar;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.ss.android.socialbase.downloader.f.a aVar) {
        synchronized (this.e) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.j;
            if (aVar2 == null) {
                this.j = aVar;
                this.i = aVar;
                this.e.notify();
            } else {
                aVar2.d = aVar;
                this.j = aVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void a(com.ss.android.socialbase.downloader.f.a aVar) {
        b(aVar);
    }

    private void c() throws Throwable {
        this.o = com.ss.android.socialbase.downloader.downloader.c.q().submit(this.q);
    }

    private com.ss.android.socialbase.downloader.f.a e() throws BaseException, InterruptedException {
        com.ss.android.socialbase.downloader.f.a aVar;
        com.ss.android.socialbase.downloader.f.a aVar2 = this.k;
        if (aVar2 != null) {
            this.k = aVar2.d;
            aVar2.d = null;
            return aVar2;
        }
        synchronized (this.e) {
            aVar = this.i;
            if (aVar == null) {
                do {
                    if (this.m) {
                        f();
                    }
                    this.e.wait();
                    aVar = this.i;
                } while (aVar == null);
                this.k = aVar.d;
                this.j = null;
                this.i = null;
                aVar.d = null;
            } else {
                this.k = aVar.d;
                this.j = null;
                this.i = null;
                aVar.d = null;
            }
        }
        return aVar;
    }

    private void f() throws BaseException {
        Throwable th = this.n;
        if (th != null) {
            if (th instanceof p) {
                throw new BaseException(1068, "async reader closed!");
            }
            f.a(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public com.ss.android.socialbase.downloader.f.a a() throws BaseException, InterruptedException {
        return e();
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void b() {
        synchronized (this.d) {
            this.l = true;
            this.d.notify();
        }
        Future future = this.o;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.f.a d() throws p, InterruptedException {
        com.ss.android.socialbase.downloader.f.a aVar = this.h;
        if (aVar != null) {
            if (!this.l) {
                this.h = aVar.d;
                aVar.d = null;
                return aVar;
            }
            throw new p("");
        }
        synchronized (this.d) {
            if (!this.l) {
                com.ss.android.socialbase.downloader.f.a aVar2 = this.f;
                if (aVar2 == null && this.p < this.c) {
                    this.p++;
                    return new com.ss.android.socialbase.downloader.f.a(this.b);
                }
                while (aVar2 == null) {
                    this.d.wait();
                    if (!this.l) {
                        aVar2 = this.f;
                    } else {
                        throw new p("");
                    }
                }
                this.h = aVar2.d;
                this.g = null;
                this.f = null;
                aVar2.d = null;
                return aVar2;
            }
            throw new p("");
        }
    }
}
