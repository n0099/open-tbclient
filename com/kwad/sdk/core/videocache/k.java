package com.kwad.sdk.core.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class k {
    public final m a;
    public final com.kwad.sdk.core.videocache.a b;
    public volatile Thread f;
    public volatile boolean g;
    public final Object c = new Object();
    public final Object d = new Object();
    public volatile int h = -1;
    public final AtomicInteger e = new AtomicInteger();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.e();
        }
    }

    public k(m mVar, com.kwad.sdk.core.videocache.a aVar) {
        this.a = (m) j.a(mVar);
        this.b = (com.kwad.sdk.core.videocache.a) j.a(aVar);
    }

    private void b() {
        int i = this.e.get();
        if (i < 1) {
            return;
        }
        this.e.set(0);
        throw new ProxyCacheException("Error reading source " + i + " times");
    }

    private void b(long j, long j2) {
        a(j, j2);
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }

    private synchronized void c() {
        boolean z = (this.f == null || this.f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.g && !this.b.d() && !z) {
            a aVar = new a();
            this.f = new Thread(aVar, "Source reader for " + this.a);
            this.f.start();
        }
    }

    private void d() {
        synchronized (this.c) {
            try {
                try {
                    this.c.wait(1000L);
                } catch (InterruptedException e) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        long j = -1;
        long j2 = 0;
        try {
            j2 = this.b.a();
            this.a.a(j2);
            j = this.a.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = this.a.a(bArr);
                if (a2 == -1) {
                    g();
                    f();
                    break;
                }
                synchronized (this.d) {
                    if (h()) {
                        return;
                    }
                    this.b.a(bArr, a2);
                }
                j2 += a2;
                b(j2, j);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private void f() {
        this.h = 100;
        a(this.h);
    }

    private void g() {
        synchronized (this.d) {
            if (!h() && this.b.a() == this.a.a()) {
                this.b.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.g;
    }

    private void i() {
        try {
            this.a.b();
        } catch (ProxyCacheException e) {
            a(new ProxyCacheException("Error closing source " + this.a, e));
        }
    }

    public int a(byte[] bArr, long j, int i) {
        l.a(bArr, j, i);
        while (!this.b.d() && this.b.a() < i + j && !this.g) {
            c();
            d();
            b();
        }
        int a2 = this.b.a(bArr, j, i);
        if (this.b.d() && this.h != 100) {
            this.h = 100;
            a(100);
        }
        return a2;
    }

    public void a() {
        synchronized (this.d) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "Shutdown proxy for " + this.a);
            try {
                this.g = true;
                if (this.f != null) {
                    this.f.interrupt();
                }
                this.b.b();
            } catch (ProxyCacheException e) {
                a(e);
            }
        }
    }

    public void a(int i) {
    }

    public void a(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        int i2 = i == 0 ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
        boolean z = i2 != this.h;
        if ((i >= 0) && z) {
            a(i2);
        }
        this.h = i2;
    }

    public final void a(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.a.e("ProxyCache", "ProxyCache error");
        }
    }
}
