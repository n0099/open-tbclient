package com.kwad.components.core.l;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.InputStream;
/* loaded from: classes10.dex */
public final class c extends InputStream {
    public InputStream IF;
    public int IG;
    public volatile float II;
    public volatile long IJ;
    public int IC = -1;
    public int ID = 10000;
    public long IE = -1;
    public long IH = -1;
    public int IK = 20480;

    public c(@NonNull InputStream inputStream, int i) {
        i = i < 20480 ? 20480 : i;
        this.IF = inputStream;
        this.II = i / 1000.0f;
    }

    public static long c(long j, long j2) {
        if (j <= 0) {
            return 0L;
        }
        if (j2 <= 0) {
            return -1L;
        }
        return j / j2;
    }

    private void ot() {
        this.IC = 0;
        this.IE = System.currentTimeMillis();
    }

    private void ou() {
        if (this.IC < this.ID) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.IE;
        float f = this.IC / this.II;
        this.IJ = c(this.IG, currentTimeMillis - this.IH);
        float f2 = (float) j;
        if (f > f2) {
            p(f - f2);
        }
        ot();
    }

    @WorkerThread
    public static void p(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.IF.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.IF.close();
        b.a(this);
        this.IH = -1L;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.IF.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.IF.markSupported();
    }

    public final long os() {
        return this.IJ;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.IH <= 0) {
            this.IH = System.currentTimeMillis();
        }
        this.IG++;
        if (b.IA && b.Iz) {
            if (this.IC < 0) {
                ot();
            }
            int read = this.IF.read();
            this.IC++;
            ou();
            return read;
        }
        return this.IF.read();
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.IF.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        return this.IF.skip(j);
    }
}
