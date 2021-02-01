package com.kwad.sdk.core.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final m f9505a;

    /* renamed from: b  reason: collision with root package name */
    private final com.kwad.sdk.core.videocache.a f9506b;
    private volatile Thread f;
    private volatile boolean g;
    private final Object c = new Object();
    private final Object d = new Object();
    private volatile int h = -1;
    private final AtomicInteger e = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.e();
        }
    }

    public k(m mVar, com.kwad.sdk.core.videocache.a aVar) {
        this.f9505a = (m) j.a(mVar);
        this.f9506b = (com.kwad.sdk.core.videocache.a) j.a(aVar);
    }

    private void b() {
        int i = this.e.get();
        if (i >= 1) {
            this.e.set(0);
            throw new ProxyCacheException("Error reading source " + i + " times");
        }
    }

    private void b(long j, long j2) {
        a(j, j2);
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }

    private synchronized void c() {
        boolean z = (this.f == null || this.f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.g && !this.f9506b.d() && !z) {
            this.f = new Thread(new a(), "Source reader for " + this.f9505a);
            this.f.start();
        }
    }

    private void d() {
        synchronized (this.c) {
            try {
                this.c.wait(1000L);
            } catch (InterruptedException e) {
                throw new ProxyCacheException("Waiting source data is interrupted!", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            long a2 = this.f9506b.a();
            this.f9505a.a(a2);
            long a3 = this.f9505a.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int a4 = this.f9505a.a(bArr);
                if (a4 == -1) {
                    g();
                    f();
                    i();
                    b(a2, a3);
                    return;
                }
                synchronized (this.d) {
                    if (h()) {
                        i();
                        b(a2, a3);
                        return;
                    }
                    this.f9506b.a(bArr, a4);
                }
                a2 += a4;
                b(a2, a3);
            }
        } catch (Throwable th) {
            try {
                this.e.incrementAndGet();
                a(th);
            } finally {
                i();
                b(0L, -1L);
            }
        }
    }

    private void f() {
        this.h = 100;
        a(this.h);
    }

    private void g() {
        synchronized (this.d) {
            if (!h() && this.f9506b.a() == this.f9505a.a()) {
                this.f9506b.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.g;
    }

    private void i() {
        try {
            this.f9505a.b();
        } catch (ProxyCacheException e) {
            a(new ProxyCacheException("Error closing source " + this.f9505a, e));
        }
    }

    public int a(byte[] bArr, long j, int i) {
        l.a(bArr, j, i);
        while (!this.f9506b.d() && this.f9506b.a() < i + j && !this.g) {
            c();
            d();
            b();
        }
        int a2 = this.f9506b.a(bArr, j, i);
        if (this.f9506b.d() && this.h != 100) {
            this.h = 100;
            a(100);
        }
        return a2;
    }

    public void a() {
        synchronized (this.d) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "Shutdown proxy for " + this.f9505a);
            try {
                this.g = true;
                if (this.f != null) {
                    this.f.interrupt();
                }
                this.f9506b.b();
            } catch (ProxyCacheException e) {
                a(e);
            }
        }
    }

    protected void a(int i) {
    }

    protected void a(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
        boolean z = i != this.h;
        if ((j2 >= 0) && z) {
            a(i);
        }
        this.h = i;
    }

    protected final void a(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.a.d("ProxyCache", "ProxyCache error");
        }
    }
}
