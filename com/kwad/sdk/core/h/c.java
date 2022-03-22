package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class c extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f39536d;

    /* renamed from: e  reason: collision with root package name */
    public int f39537e;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f39539g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f39540h;
    public int a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f39534b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public long f39535c = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f39538f = -1;
    public int i = 20480;

    public c(@NonNull InputStream inputStream, int i) {
        i = i < 20480 ? 20480 : i;
        this.f39536d = inputStream;
        this.f39539g = i / 1000.0f;
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
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    private void b() {
        this.a = 0;
        this.f39535c = System.currentTimeMillis();
    }

    private void c() {
        if (this.a < this.f39534b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f39535c;
        float f2 = this.a / this.f39539g;
        this.f39540h = a(this.f39537e, currentTimeMillis - this.f39538f);
        float f3 = (float) j;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        return this.f39540h;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f39536d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f39536d.close();
        b.a(this);
        this.f39538f = -1L;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.f39536d.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f39536d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f39538f <= 0) {
            this.f39538f = System.currentTimeMillis();
        }
        this.f39537e++;
        if (b.f39530b && b.a) {
            if (this.a < 0) {
                b();
            }
            int read = this.f39536d.read();
            this.a++;
            c();
            return read;
        }
        return this.f39536d.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f39536d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f39536d.skip(j);
    }
}
