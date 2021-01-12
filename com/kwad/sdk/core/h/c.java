package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class c extends InputStream {
    private InputStream d;
    private int e;
    private volatile float g;
    private volatile long h;

    /* renamed from: a  reason: collision with root package name */
    private int f9305a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f9306b = 10000;
    private long c = -1;
    private long f = -1;
    private int i = 20480;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(@NonNull InputStream inputStream, int i) {
        i = i < this.i ? this.i : i;
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
        this.f9305a = 0;
        this.c = System.currentTimeMillis();
    }

    private void c() {
        if (this.f9305a < this.f9306b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.c;
        float f = this.f9305a / this.g;
        this.h = a(this.e, currentTimeMillis - this.f);
        if (f > ((float) j)) {
            a(f - ((float) j));
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
        if (b.f9304b && b.f9303a) {
            if (this.f9305a < 0) {
                b();
            }
            int read = this.d.read();
            this.f9305a++;
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
