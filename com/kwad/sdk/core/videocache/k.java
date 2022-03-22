package com.kwad.sdk.core.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class k {
    public final m a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a f39954b;

    /* renamed from: f  reason: collision with root package name */
    public volatile Thread f39958f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f39959g;

    /* renamed from: c  reason: collision with root package name */
    public final Object f39955c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f39956d = new Object();

    /* renamed from: h  reason: collision with root package name */
    public volatile int f39960h = -1;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f39957e = new AtomicInteger();

    /* loaded from: classes7.dex */
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
        this.f39954b = (com.kwad.sdk.core.videocache.a) j.a(aVar);
    }

    private void b() {
        int i = this.f39957e.get();
        if (i < 1) {
            return;
        }
        this.f39957e.set(0);
        throw new ProxyCacheException("Error reading source " + i + " times");
    }

    private void b(long j, long j2) {
        a(j, j2);
        synchronized (this.f39955c) {
            this.f39955c.notifyAll();
        }
    }

    private synchronized void c() {
        boolean z = (this.f39958f == null || this.f39958f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f39959g && !this.f39954b.d() && !z) {
            a aVar = new a();
            this.f39958f = new Thread(aVar, "Source reader for " + this.a);
            this.f39958f.start();
        }
    }

    private void d() {
        synchronized (this.f39955c) {
            try {
                try {
                    this.f39955c.wait(1000L);
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
        long j = -1;
        long j2 = 0;
        try {
            j2 = this.f39954b.a();
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
                synchronized (this.f39956d) {
                    if (h()) {
                        return;
                    }
                    this.f39954b.a(bArr, a2);
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
        this.f39960h = 100;
        a(this.f39960h);
    }

    private void g() {
        synchronized (this.f39956d) {
            if (!h() && this.f39954b.a() == this.a.a()) {
                this.f39954b.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.f39959g;
    }

    private void i() {
        try {
            this.a.b();
        } catch (ProxyCacheException e2) {
            a(new ProxyCacheException("Error closing source " + this.a, e2));
        }
    }

    public int a(byte[] bArr, long j, int i) {
        l.a(bArr, j, i);
        while (!this.f39954b.d() && this.f39954b.a() < i + j && !this.f39959g) {
            c();
            d();
            b();
        }
        int a2 = this.f39954b.a(bArr, j, i);
        if (this.f39954b.d() && this.f39960h != 100) {
            this.f39960h = 100;
            a(100);
        }
        return a2;
    }

    public void a() {
        synchronized (this.f39956d) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "Shutdown proxy for " + this.a);
            try {
                this.f39959g = true;
                if (this.f39958f != null) {
                    this.f39958f.interrupt();
                }
                this.f39954b.b();
            } catch (ProxyCacheException e2) {
                a(e2);
            }
        }
    }

    public void a(int i) {
    }

    public void a(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        int i2 = i == 0 ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
        boolean z = i2 != this.f39960h;
        if ((i >= 0) && z) {
            a(i2);
        }
        this.f39960h = i2;
    }

    public final void a(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.a.e("ProxyCache", "ProxyCache error");
        }
    }
}
