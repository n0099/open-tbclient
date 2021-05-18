package com.kwad.sdk.core.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final m f32830a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a f32831b;

    /* renamed from: f  reason: collision with root package name */
    public volatile Thread f32835f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f32836g;

    /* renamed from: c  reason: collision with root package name */
    public final Object f32832c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Object f32833d = new Object();

    /* renamed from: h  reason: collision with root package name */
    public volatile int f32837h = -1;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f32834e = new AtomicInteger();

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
        this.f32830a = (m) j.a(mVar);
        this.f32831b = (com.kwad.sdk.core.videocache.a) j.a(aVar);
    }

    private void b() {
        int i2 = this.f32834e.get();
        if (i2 < 1) {
            return;
        }
        this.f32834e.set(0);
        throw new ProxyCacheException("Error reading source " + i2 + " times");
    }

    private void b(long j, long j2) {
        a(j, j2);
        synchronized (this.f32832c) {
            this.f32832c.notifyAll();
        }
    }

    private synchronized void c() {
        boolean z = (this.f32835f == null || this.f32835f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f32836g && !this.f32831b.d() && !z) {
            a aVar = new a();
            this.f32835f = new Thread(aVar, "Source reader for " + this.f32830a);
            this.f32835f.start();
        }
    }

    private void d() {
        synchronized (this.f32832c) {
            try {
                try {
                    this.f32832c.wait(1000L);
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
            j2 = this.f32831b.a();
            this.f32830a.a(j2);
            j = this.f32830a.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = this.f32830a.a(bArr);
                if (a2 == -1) {
                    g();
                    f();
                    break;
                }
                synchronized (this.f32833d) {
                    if (h()) {
                        return;
                    }
                    this.f32831b.a(bArr, a2);
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
        this.f32837h = 100;
        a(this.f32837h);
    }

    private void g() {
        synchronized (this.f32833d) {
            if (!h() && this.f32831b.a() == this.f32830a.a()) {
                this.f32831b.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.f32836g;
    }

    private void i() {
        try {
            this.f32830a.b();
        } catch (ProxyCacheException e2) {
            a(new ProxyCacheException("Error closing source " + this.f32830a, e2));
        }
    }

    public int a(byte[] bArr, long j, int i2) {
        l.a(bArr, j, i2);
        while (!this.f32831b.d() && this.f32831b.a() < i2 + j && !this.f32836g) {
            c();
            d();
            b();
        }
        int a2 = this.f32831b.a(bArr, j, i2);
        if (this.f32831b.d() && this.f32837h != 100) {
            this.f32837h = 100;
            a(100);
        }
        return a2;
    }

    public void a() {
        synchronized (this.f32833d) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "Shutdown proxy for " + this.f32830a);
            try {
                this.f32836g = true;
                if (this.f32835f != null) {
                    this.f32835f.interrupt();
                }
                this.f32831b.b();
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
        boolean z = i3 != this.f32837h;
        if ((i2 >= 0) && z) {
            a(i3);
        }
        this.f32837h = i3;
    }

    public final void a(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.a.a("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.a.e("ProxyCache", "ProxyCache error");
        }
    }
}
