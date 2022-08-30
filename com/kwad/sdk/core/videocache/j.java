package com.kwad.sdk.core.videocache;

import android.support.v4.media.session.PlaybackStateCompat;
import com.kwad.sdk.utils.am;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class j {
    public final l aeN;
    public final com.kwad.sdk.core.videocache.a aeO;
    public volatile Thread aeS;
    public volatile boolean hx;
    public final Object aeP = new Object();
    public final Object aeQ = new Object();
    public volatile int aeT = -1;
    public final AtomicInteger aeR = new AtomicInteger();

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a() {
        }

        public /* synthetic */ a(j jVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.this.vW();
        }
    }

    public j(l lVar, com.kwad.sdk.core.videocache.a aVar) {
        this.aeN = (l) am.checkNotNull(lVar);
        this.aeO = (com.kwad.sdk.core.videocache.a) am.checkNotNull(aVar);
    }

    private void d(long j, long j2) {
        e(j, j2);
        synchronized (this.aeP) {
            this.aeP.notifyAll();
        }
    }

    private void e(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        int i2 = i == 0 ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
        boolean z = i2 != this.aeT;
        if ((i >= 0) && z) {
            aZ(i2);
        }
        this.aeT = i2;
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.hx;
    }

    public static void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.e.b.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.e.b.e("ProxyCache", "ProxyCache error");
        }
    }

    private void tryComplete() {
        synchronized (this.aeQ) {
            if (!isStopped() && this.aeO.vJ() == this.aeN.length()) {
                this.aeO.complete();
            }
        }
    }

    private void vT() {
        int i = this.aeR.get();
        if (i <= 0) {
            return;
        }
        this.aeR.set(0);
        throw new ProxyCacheException("Error reading source " + i + " times");
    }

    private synchronized void vU() {
        boolean z = (this.aeS == null || this.aeS.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.hx && !this.aeO.isCompleted() && !z) {
            a aVar = new a(this, (byte) 0);
            this.aeS = new Thread(aVar, "Source reader for " + this.aeN);
            this.aeS.start();
        }
    }

    private void vV() {
        synchronized (this.aeP) {
            try {
                try {
                    this.aeP.wait(1000L);
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
    public void vW() {
        long j = -1;
        long j2 = 0;
        try {
            j2 = this.aeO.vJ();
            this.aeN.I(j2);
            j = this.aeN.length();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = this.aeN.read(bArr);
                if (read == -1) {
                    tryComplete();
                    vX();
                    break;
                }
                synchronized (this.aeQ) {
                    if (!isStopped()) {
                        this.aeO.d(bArr, read);
                    }
                }
                break;
                d(j2, j);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private void vX() {
        this.aeT = 100;
        aZ(this.aeT);
    }

    private void vY() {
        try {
            this.aeN.close();
        } catch (ProxyCacheException e) {
            onError(new ProxyCacheException("Error closing source " + this.aeN, e));
        }
    }

    public final int a(byte[] bArr, long j, int i) {
        k.b(bArr, j, 8192);
        while (!this.aeO.isCompleted() && this.aeO.vJ() < PlaybackStateCompat.ACTION_PLAY_FROM_URI + j && !this.hx) {
            vU();
            vV();
            vT();
        }
        int a2 = this.aeO.a(bArr, j, 8192);
        if (this.aeO.isCompleted() && this.aeT != 100) {
            this.aeT = 100;
            aZ(100);
        }
        return a2;
    }

    public void aZ(int i) {
    }

    public final void shutdown() {
        synchronized (this.aeQ) {
            com.kwad.sdk.core.e.b.d("ProxyCache", "Shutdown proxy for " + this.aeN);
            try {
                this.hx = true;
                if (this.aeS != null) {
                    this.aeS.interrupt();
                }
                this.aeO.close();
            } catch (ProxyCacheException e) {
                onError(e);
            }
        }
    }
}
