package com.kwad.sdk.core.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final m f34500a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a f34501b;

    /* renamed from: f  reason: collision with root package name */
    public volatile Thread f34505f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f34506g;

    /* renamed from: c  reason: collision with root package name */
    public final Object f34502c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f34503d = new Object();

    /* renamed from: h  reason: collision with root package name */
    public volatile int f34507h = -1;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f34504e = new AtomicInteger();

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.e();
        }
    }

    public k(m mVar, com.kwad.sdk.core.videocache.a aVar) {
        this.f34500a = (m) j.a(mVar);
        this.f34501b = (com.kwad.sdk.core.videocache.a) j.a(aVar);
    }

    private void b() {
        int i = this.f34504e.get();
        if (i < 1) {
            return;
        }
        this.f34504e.set(0);
        throw new ProxyCacheException("Error reading source " + i + " times");
    }

    private void b(long j, long j2) {
        a(j, j2);
        synchronized (this.f34502c) {
            this.f34502c.notifyAll();
        }
    }

    private synchronized void c() {
        boolean z = (this.f34505f == null || this.f34505f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f34506g && !this.f34501b.d() && !z) {
            a aVar = new a();
            this.f34505f = new Thread(aVar, "Source reader for " + this.f34500a);
            this.f34505f.start();
        }
    }

    private void d() {
        synchronized (this.f34502c) {
            try {
                try {
                    this.f34502c.wait(1000L);
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
            j2 = this.f34501b.a();
            this.f34500a.a(j2);
            j = this.f34500a.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = this.f34500a.a(bArr);
                if (a2 == -1) {
                    g();
                    f();
                    break;
                }
                synchronized (this.f34503d) {
                    if (h()) {
                        return;
                    }
                    this.f34501b.a(bArr, a2);
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
        this.f34507h = 100;
        a(this.f34507h);
    }

    private void g() {
        synchronized (this.f34503d) {
            if (!h() && this.f34501b.a() == this.f34500a.a()) {
                this.f34501b.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.f34506g;
    }

    private void i() {
        try {
            this.f34500a.b();
        } catch (ProxyCacheException e2) {
            a(new ProxyCacheException("Error closing source " + this.f34500a, e2));
        }
    }

    public int a(byte[] bArr, long j, int i) {
        l.a(bArr, j, i);
        while (!this.f34501b.d() && this.f34501b.a() < i + j && !this.f34506g) {
            c();
            d();
            b();
        }
        int a2 = this.f34501b.a(bArr, j, i);
        if (this.f34501b.d() && this.f34507h != 100) {
            this.f34507h = 100;
            a(100);
        }
        return a2;
    }

    public void a() {
        synchronized (this.f34503d) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "Shutdown proxy for " + this.f34500a);
            try {
                this.f34506g = true;
                if (this.f34505f != null) {
                    this.f34505f.interrupt();
                }
                this.f34501b.b();
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
        boolean z = i2 != this.f34507h;
        if ((i >= 0) && z) {
            a(i2);
        }
        this.f34507h = i2;
    }

    public final void a(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.a.d("ProxyCache", "ProxyCache error");
        }
    }
}
