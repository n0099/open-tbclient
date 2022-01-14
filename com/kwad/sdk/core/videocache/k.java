package com.kwad.sdk.core.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class k {
    public final m a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a f56297b;

    /* renamed from: f  reason: collision with root package name */
    public volatile Thread f56301f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f56302g;

    /* renamed from: c  reason: collision with root package name */
    public final Object f56298c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f56299d = new Object();

    /* renamed from: h  reason: collision with root package name */
    public volatile int f56303h = -1;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f56300e = new AtomicInteger();

    /* loaded from: classes3.dex */
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
        this.f56297b = (com.kwad.sdk.core.videocache.a) j.a(aVar);
    }

    private void b() {
        int i2 = this.f56300e.get();
        if (i2 < 1) {
            return;
        }
        this.f56300e.set(0);
        throw new ProxyCacheException("Error reading source " + i2 + " times");
    }

    private void b(long j2, long j3) {
        a(j2, j3);
        synchronized (this.f56298c) {
            this.f56298c.notifyAll();
        }
    }

    private synchronized void c() {
        boolean z = (this.f56301f == null || this.f56301f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f56302g && !this.f56297b.d() && !z) {
            a aVar = new a();
            this.f56301f = new Thread(aVar, "Source reader for " + this.a);
            this.f56301f.start();
        }
    }

    private void d() {
        synchronized (this.f56298c) {
            try {
                try {
                    this.f56298c.wait(1000L);
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
            j3 = this.f56297b.a();
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
                synchronized (this.f56299d) {
                    if (h()) {
                        return;
                    }
                    this.f56297b.a(bArr, a2);
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
        this.f56303h = 100;
        a(this.f56303h);
    }

    private void g() {
        synchronized (this.f56299d) {
            if (!h() && this.f56297b.a() == this.a.a()) {
                this.f56297b.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.f56302g;
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
        while (!this.f56297b.d() && this.f56297b.a() < i2 + j2 && !this.f56302g) {
            c();
            d();
            b();
        }
        int a2 = this.f56297b.a(bArr, j2, i2);
        if (this.f56297b.d() && this.f56303h != 100) {
            this.f56303h = 100;
            a(100);
        }
        return a2;
    }

    public void a() {
        synchronized (this.f56299d) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "Shutdown proxy for " + this.a);
            try {
                this.f56302g = true;
                if (this.f56301f != null) {
                    this.f56301f.interrupt();
                }
                this.f56297b.b();
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
        boolean z = i3 != this.f56303h;
        if ((i2 >= 0) && z) {
            a(i3);
        }
        this.f56303h = i3;
    }

    public final void a(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.a.e("ProxyCache", "ProxyCache error");
        }
    }
}
