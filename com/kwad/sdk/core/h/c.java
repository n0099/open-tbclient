package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class c extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f54412d;

    /* renamed from: e  reason: collision with root package name */
    public int f54413e;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f54415g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f54416h;
    public int a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f54410b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public long f54411c = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f54414f = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f54417i = 20480;

    public c(@NonNull InputStream inputStream, int i2) {
        i2 = i2 < 20480 ? 20480 : i2;
        this.f54412d = inputStream;
        this.f54415g = i2 / 1000.0f;
    }

    private long a(long j2, long j3) {
        if (j2 <= 0) {
            return 0L;
        }
        if (j3 <= 0) {
            return -1L;
        }
        return j2 / j3;
    }

    @WorkerThread
    private void a(long j2) {
        try {
            Thread.sleep(j2);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    private void b() {
        this.a = 0;
        this.f54411c = System.currentTimeMillis();
    }

    private void c() {
        if (this.a < this.f54410b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.f54411c;
        float f2 = this.a / this.f54415g;
        this.f54416h = a(this.f54413e, currentTimeMillis - this.f54414f);
        float f3 = (float) j2;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        return this.f54416h;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f54412d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f54412d.close();
        b.a(this);
        this.f54414f = -1L;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        this.f54412d.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f54412d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f54414f <= 0) {
            this.f54414f = System.currentTimeMillis();
        }
        this.f54413e++;
        if (b.f54406b && b.a) {
            if (this.a < 0) {
                b();
            }
            int read = this.f54412d.read();
            this.a++;
            c();
            return read;
        }
        return this.f54412d.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f54412d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        return this.f54412d.skip(j2);
    }
}
