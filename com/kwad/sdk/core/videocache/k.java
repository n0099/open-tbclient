package com.kwad.sdk.core.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final m f33585a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a f33586b;

    /* renamed from: f  reason: collision with root package name */
    public volatile Thread f33590f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f33591g;

    /* renamed from: c  reason: collision with root package name */
    public final Object f33587c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f33588d = new Object();

    /* renamed from: h  reason: collision with root package name */
    public volatile int f33592h = -1;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f33589e = new AtomicInteger();

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
        this.f33585a = (m) j.a(mVar);
        this.f33586b = (com.kwad.sdk.core.videocache.a) j.a(aVar);
    }

    private void b() {
        int i2 = this.f33589e.get();
        if (i2 < 1) {
            return;
        }
        this.f33589e.set(0);
        throw new ProxyCacheException("Error reading source " + i2 + " times");
    }

    private void b(long j, long j2) {
        a(j, j2);
        synchronized (this.f33587c) {
            this.f33587c.notifyAll();
        }
    }

    private synchronized void c() {
        boolean z = (this.f33590f == null || this.f33590f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f33591g && !this.f33586b.d() && !z) {
            a aVar = new a();
            this.f33590f = new Thread(aVar, "Source reader for " + this.f33585a);
            this.f33590f.start();
        }
    }

    private void d() {
        synchronized (this.f33587c) {
            try {
                try {
                    this.f33587c.wait(1000L);
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
            j2 = this.f33586b.a();
            this.f33585a.a(j2);
            j = this.f33585a.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = this.f33585a.a(bArr);
                if (a2 == -1) {
                    g();
                    f();
                    break;
                }
                synchronized (this.f33588d) {
                    if (h()) {
                        return;
                    }
                    this.f33586b.a(bArr, a2);
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
        this.f33592h = 100;
        a(this.f33592h);
    }

    private void g() {
        synchronized (this.f33588d) {
            if (!h() && this.f33586b.a() == this.f33585a.a()) {
                this.f33586b.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.f33591g;
    }

    private void i() {
        try {
            this.f33585a.b();
        } catch (ProxyCacheException e2) {
            a(new ProxyCacheException("Error closing source " + this.f33585a, e2));
        }
    }

    public int a(byte[] bArr, long j, int i2) {
        l.a(bArr, j, i2);
        while (!this.f33586b.d() && this.f33586b.a() < i2 + j && !this.f33591g) {
            c();
            d();
            b();
        }
        int a2 = this.f33586b.a(bArr, j, i2);
        if (this.f33586b.d() && this.f33592h != 100) {
            this.f33592h = 100;
            a(100);
        }
        return a2;
    }

    public void a() {
        synchronized (this.f33588d) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "Shutdown proxy for " + this.f33585a);
            try {
                this.f33591g = true;
                if (this.f33590f != null) {
                    this.f33590f.interrupt();
                }
                this.f33586b.b();
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
        boolean z = i3 != this.f33592h;
        if ((i2 >= 0) && z) {
            a(i3);
        }
        this.f33592h = i3;
    }

    public final void a(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.a.e("ProxyCache", "ProxyCache error");
        }
    }
}
