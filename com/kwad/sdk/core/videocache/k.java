package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.ap;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class k {
    public final m aBm;
    public final com.kwad.sdk.core.videocache.a aBn;
    public volatile Thread aBr;
    public volatile boolean kH;
    public final Object aBo = new Object();
    public final Object aBp = new Object();
    public volatile int aBs = -1;
    public final AtomicInteger aBq = new AtomicInteger();

    public void cU(int i) {
    }

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public a() {
        }

        public /* synthetic */ a(k kVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.Fu();
        }
    }

    public k(m mVar, com.kwad.sdk.core.videocache.a aVar) {
        this.aBm = (m) ap.checkNotNull(mVar);
        this.aBn = (com.kwad.sdk.core.videocache.a) ap.checkNotNull(aVar);
    }

    private void j(long j, long j2) {
        k(j, j2);
        synchronized (this.aBo) {
            this.aBo.notifyAll();
        }
    }

    private void k(long j, long j2) {
        boolean z;
        int i;
        boolean z2;
        boolean z3 = true;
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i = 100;
        } else {
            i = (int) ((((float) j) / ((float) j2)) * 100.0f);
        }
        if (i != this.aBs) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i2 < 0) {
            z3 = false;
        }
        if (z3 && z2) {
            cU(i);
        }
        this.aBs = i;
    }

    private void Fr() {
        int i = this.aBq.get();
        if (i <= 0) {
            return;
        }
        this.aBq.set(0);
        throw new ProxyCacheException("Error reading source " + i + " times");
    }

    private void Ft() {
        synchronized (this.aBo) {
            try {
                try {
                    this.aBo.wait(1000L);
                } catch (InterruptedException e) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void Fv() {
        this.aBs = 100;
        cU(this.aBs);
    }

    private void Fw() {
        try {
            this.aBm.close();
        } catch (ProxyCacheException e) {
            onError(new ProxyCacheException("Error closing source " + this.aBm, e));
        }
    }

    private boolean isStopped() {
        if (!Thread.currentThread().isInterrupted() && !this.kH) {
            return false;
        }
        return true;
    }

    private void tryComplete() {
        synchronized (this.aBp) {
            if (!isStopped() && this.aBn.Ff() == this.aBm.length()) {
                this.aBn.complete();
            }
        }
    }

    private synchronized void Fs() {
        boolean z;
        if (this.aBr != null && this.aBr.getState() != Thread.State.TERMINATED) {
            z = true;
        } else {
            z = false;
        }
        if (!this.kH && !this.aBn.isCompleted() && !z) {
            a aVar = new a(this, (byte) 0);
            this.aBr = new Thread(aVar, "Source reader for " + this.aBm);
            this.aBr.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
        r2 = r2 + r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Fu() {
        long j = -1;
        long j2 = 0;
        try {
            j2 = this.aBn.Ff();
            this.aBm.al(j2);
            j = this.aBm.length();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = this.aBm.read(bArr);
                if (read != -1) {
                    synchronized (this.aBp) {
                        if (!isStopped()) {
                            this.aBn.d(bArr, read);
                        }
                    }
                    break;
                }
                tryComplete();
                Fv();
                break;
                j(j2, j);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.e.c.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.e.c.e("ProxyCache", "ProxyCache error");
        }
    }

    public final int a(byte[] bArr, long j, int i) {
        l.b(bArr, j, 1024);
        while (!this.aBn.isCompleted() && this.aBn.Ff() < 1024 + j && !this.kH) {
            Fs();
            Ft();
            Fr();
        }
        int a2 = this.aBn.a(bArr, j, 1024);
        if (this.aBn.isCompleted() && this.aBs != 100) {
            this.aBs = 100;
            cU(100);
        }
        return a2;
    }

    public final void shutdown() {
        synchronized (this.aBp) {
            com.kwad.sdk.core.e.c.d("ProxyCache", "Shutdown proxy for " + this.aBm);
            try {
                this.kH = true;
                if (this.aBr != null) {
                    this.aBr.interrupt();
                }
                this.aBn.close();
            } catch (ProxyCacheException e) {
                onError(e);
            }
        }
    }
}
