package com.kwad.sdk.core.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final m f34949a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a f34950b;

    /* renamed from: f  reason: collision with root package name */
    public volatile Thread f34954f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f34955g;

    /* renamed from: c  reason: collision with root package name */
    public final Object f34951c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f34952d = new Object();

    /* renamed from: h  reason: collision with root package name */
    public volatile int f34956h = -1;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f34953e = new AtomicInteger();

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
        this.f34949a = (m) j.a(mVar);
        this.f34950b = (com.kwad.sdk.core.videocache.a) j.a(aVar);
    }

    private void b() {
        int i2 = this.f34953e.get();
        if (i2 < 1) {
            return;
        }
        this.f34953e.set(0);
        throw new ProxyCacheException("Error reading source " + i2 + " times");
    }

    private void b(long j, long j2) {
        a(j, j2);
        synchronized (this.f34951c) {
            this.f34951c.notifyAll();
        }
    }

    private synchronized void c() {
        boolean z = (this.f34954f == null || this.f34954f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f34955g && !this.f34950b.d() && !z) {
            a aVar = new a();
            this.f34954f = new Thread(aVar, "Source reader for " + this.f34949a);
            this.f34954f.start();
        }
    }

    private void d() {
        synchronized (this.f34951c) {
            try {
                try {
                    this.f34951c.wait(1000L);
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
            j2 = this.f34950b.a();
            this.f34949a.a(j2);
            j = this.f34949a.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = this.f34949a.a(bArr);
                if (a2 == -1) {
                    g();
                    f();
                    break;
                }
                synchronized (this.f34952d) {
                    if (h()) {
                        return;
                    }
                    this.f34950b.a(bArr, a2);
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
        this.f34956h = 100;
        a(this.f34956h);
    }

    private void g() {
        synchronized (this.f34952d) {
            if (!h() && this.f34950b.a() == this.f34949a.a()) {
                this.f34950b.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.f34955g;
    }

    private void i() {
        try {
            this.f34949a.b();
        } catch (ProxyCacheException e2) {
            a(new ProxyCacheException("Error closing source " + this.f34949a, e2));
        }
    }

    public int a(byte[] bArr, long j, int i2) {
        l.a(bArr, j, i2);
        while (!this.f34950b.d() && this.f34950b.a() < i2 + j && !this.f34955g) {
            c();
            d();
            b();
        }
        int a2 = this.f34950b.a(bArr, j, i2);
        if (this.f34950b.d() && this.f34956h != 100) {
            this.f34956h = 100;
            a(100);
        }
        return a2;
    }

    public void a() {
        synchronized (this.f34952d) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "Shutdown proxy for " + this.f34949a);
            try {
                this.f34955g = true;
                if (this.f34954f != null) {
                    this.f34954f.interrupt();
                }
                this.f34950b.b();
            } catch (ProxyCacheException e2) {
                a(e2);
            }
        }
    }

    public void a(int i2) {
    }

    public void a(long j, long j2) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        int i3 = i2 == 0 ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
        boolean z = i3 != this.f34956h;
        if ((i2 >= 0) && z) {
            a(i3);
        }
        this.f34956h = i3;
    }

    public final void a(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.a.d("ProxyCache", "ProxyCache error");
        }
    }
}
