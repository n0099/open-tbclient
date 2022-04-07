package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class c extends InputStream {
    public InputStream d;
    public int e;
    public volatile float g;
    public volatile long h;
    public int a = -1;
    public int b = 10000;
    public long c = -1;
    public long f = -1;
    public int i = 20480;

    public c(@NonNull InputStream inputStream, int i) {
        i = i < 20480 ? 20480 : i;
        this.d = inputStream;
        this.g = i / 1000.0f;
    }

    private long a(long j, long j2) {
        if (j <= 0) {
            return 0L;
        }
        if (j2 <= 0) {
            return -1L;
        }
        return j / j2;
    }

    @WorkerThread
    private void a(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void b() {
        this.a = 0;
        this.c = System.currentTimeMillis();
    }

    private void c() {
        if (this.a < this.b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.c;
        float f = this.a / this.g;
        this.h = a(this.e, currentTimeMillis - this.f);
        float f2 = (float) j;
        if (f > f2) {
            a(f - f2);
        }
        b();
    }

    public long a() {
        return this.h;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d.close();
        b.a(this);
        this.f = -1L;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.d.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f <= 0) {
            this.f = System.currentTimeMillis();
        }
        this.e++;
        if (b.b && b.a) {
            if (this.a < 0) {
                b();
            }
            int read = this.d.read();
            this.a++;
            c();
            return read;
        }
        return this.d.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.d.skip(j);
    }
}
