package com.kwad.components.core.p;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.InputStream;
/* loaded from: classes10.dex */
public final class c extends InputStream {
    public InputStream Sc;
    public int Sd;
    public volatile float Sf;
    public volatile long Sg;
    public int RZ = -1;
    public int Sa = 10000;
    public long Sb = -1;
    public long Se = -1;
    public int Sh = 20480;

    public c(@NonNull InputStream inputStream, int i) {
        i = i < 20480 ? 20480 : i;
        this.Sc = inputStream;
        this.Sf = i / 1000.0f;
    }

    public static long g(long j, long j2) {
        if (j <= 0) {
            return 0L;
        }
        if (j2 <= 0) {
            return -1L;
        }
        return j / j2;
    }

    @WorkerThread
    public static void D(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.Sc.mark(i);
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        return this.Sc.skip(j);
    }

    private void qs() {
        this.RZ = 0;
        this.Sb = System.currentTimeMillis();
    }

    private void qt() {
        if (this.RZ < this.Sa) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.Sb;
        float f = this.RZ / this.Sf;
        this.Sg = g(this.Sd, currentTimeMillis - this.Se);
        float f2 = (float) j;
        if (f > f2) {
            D(f - f2);
        }
        qs();
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.Sc.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.Sc.close();
        b.a(this);
        this.Se = -1L;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.Sc.markSupported();
    }

    public final long qr() {
        return this.Sg;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.Sc.reset();
    }

    @Override // java.io.InputStream
    public final int read() {
        boolean z;
        if (this.Se <= 0) {
            this.Se = System.currentTimeMillis();
        }
        this.Sd++;
        if (b.RX && b.RW) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return this.Sc.read();
        }
        if (this.RZ < 0) {
            qs();
        }
        int read = this.Sc.read();
        this.RZ++;
        qt();
        return read;
    }
}
