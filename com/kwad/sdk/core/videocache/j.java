package com.kwad.sdk.core.videocache;

import android.support.v4.media.session.PlaybackStateCompat;
import com.kwad.sdk.utils.aj;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class j {
    public final l a;
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

        public /* synthetic */ a(j jVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.this.e();
        }
    }

    public j(l lVar, com.kwad.sdk.core.videocache.a aVar) {
        this.a = (l) aj.a(lVar);
        this.b = (com.kwad.sdk.core.videocache.a) aj.a(aVar);
    }

    private void a(long j, long j2) {
        b(j, j2);
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }

    public static void a(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.b.a("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.b.e("ProxyCache", "ProxyCache error");
        }
    }

    private void b() {
        int i = this.e.get();
        if (i <= 0) {
            return;
        }
        this.e.set(0);
        throw new ProxyCacheException("Error reading source " + i + " times");
    }

    private void b(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        int i2 = i == 0 ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
        boolean z = i2 != this.h;
        if ((i >= 0) && z) {
            a(i2);
        }
        this.h = i2;
    }

    private synchronized void c() {
        boolean z = (this.f == null || this.f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.g && !this.b.d() && !z) {
            a aVar = new a(this, (byte) 0);
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
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
        r2 = r2 + r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
                    if (!h()) {
                        this.b.a(bArr, a2);
                    }
                }
                break;
                a(j2, j);
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

    public final int a(byte[] bArr, long j, int i) {
        k.a(bArr, j, 8192);
        while (!this.b.d() && this.b.a() < PlaybackStateCompat.ACTION_PLAY_FROM_URI + j && !this.g) {
            c();
            d();
            b();
        }
        int a2 = this.b.a(bArr, j, 8192);
        if (this.b.d() && this.h != 100) {
            this.h = 100;
            a(100);
        }
        return a2;
    }

    public final void a() {
        synchronized (this.d) {
            com.kwad.sdk.core.d.b.a("ProxyCache", "Shutdown proxy for " + this.a);
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
}
