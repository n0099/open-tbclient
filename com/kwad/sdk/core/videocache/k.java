package com.kwad.sdk.core.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class k {
    public final m a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a f54859b;

    /* renamed from: f  reason: collision with root package name */
    public volatile Thread f54863f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f54864g;

    /* renamed from: c  reason: collision with root package name */
    public final Object f54860c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f54861d = new Object();

    /* renamed from: h  reason: collision with root package name */
    public volatile int f54865h = -1;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f54862e = new AtomicInteger();

    /* loaded from: classes8.dex */
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
        this.f54859b = (com.kwad.sdk.core.videocache.a) j.a(aVar);
    }

    private void b() {
        int i2 = this.f54862e.get();
        if (i2 < 1) {
            return;
        }
        this.f54862e.set(0);
        throw new ProxyCacheException("Error reading source " + i2 + " times");
    }

    private void b(long j2, long j3) {
        a(j2, j3);
        synchronized (this.f54860c) {
            this.f54860c.notifyAll();
        }
    }

    private synchronized void c() {
        boolean z = (this.f54863f == null || this.f54863f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f54864g && !this.f54859b.d() && !z) {
            a aVar = new a();
            this.f54863f = new Thread(aVar, "Source reader for " + this.a);
            this.f54863f.start();
        }
    }

    private void d() {
        synchronized (this.f54860c) {
            try {
                try {
                    this.f54860c.wait(1000L);
                } catch (InterruptedException e2) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        long j2 = -1;
        long j3 = 0;
        try {
            j3 = this.f54859b.a();
            this.a.a(j3);
            j2 = this.a.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = this.a.a(bArr);
                if (a2 == -1) {
                    g();
                    f();
                    break;
                }
                synchronized (this.f54861d) {
                    if (h()) {
                        return;
                    }
                    this.f54859b.a(bArr, a2);
                }
                j3 += a2;
                b(j3, j2);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private void f() {
        this.f54865h = 100;
        a(this.f54865h);
    }

    private void g() {
        synchronized (this.f54861d) {
            if (!h() && this.f54859b.a() == this.a.a()) {
                this.f54859b.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.f54864g;
    }

    private void i() {
        try {
            this.a.b();
        } catch (ProxyCacheException e2) {
            a(new ProxyCacheException("Error closing source " + this.a, e2));
        }
    }

    public int a(byte[] bArr, long j2, int i2) {
        l.a(bArr, j2, i2);
        while (!this.f54859b.d() && this.f54859b.a() < i2 + j2 && !this.f54864g) {
            c();
            d();
            b();
        }
        int a2 = this.f54859b.a(bArr, j2, i2);
        if (this.f54859b.d() && this.f54865h != 100) {
            this.f54865h = 100;
            a(100);
        }
        return a2;
    }

    public void a() {
        synchronized (this.f54861d) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "Shutdown proxy for " + this.a);
            try {
                this.f54864g = true;
                if (this.f54863f != null) {
                    this.f54863f.interrupt();
                }
                this.f54859b.b();
            } catch (ProxyCacheException e2) {
                a(e2);
            }
        }
    }

    public void a(int i2) {
    }

    public void a(long j2, long j3) {
        int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        int i3 = i2 == 0 ? 100 : (int) ((((float) j2) / ((float) j3)) * 100.0f);
        boolean z = i3 != this.f54865h;
        if ((i2 >= 0) && z) {
            a(i3);
        }
        this.f54865h = i3;
    }

    public final void a(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.a.e("ProxyCache", "ProxyCache error");
        }
    }
}
