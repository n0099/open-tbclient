package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.logsystem.basic.upload.CrashPadUtil;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class c extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f56062d;

    /* renamed from: e  reason: collision with root package name */
    public int f56063e;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f56065g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f56066h;
    public int a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f56060b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public long f56061c = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f56064f = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f56067i = CrashPadUtil.MAX_READ_EXTRA;

    public c(@NonNull InputStream inputStream, int i2) {
        i2 = i2 < 20480 ? CrashPadUtil.MAX_READ_EXTRA : i2;
        this.f56062d = inputStream;
        this.f56065g = i2 / 1000.0f;
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
        this.f56061c = System.currentTimeMillis();
    }

    private void c() {
        if (this.a < this.f56060b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.f56061c;
        float f2 = this.a / this.f56065g;
        this.f56066h = a(this.f56063e, currentTimeMillis - this.f56064f);
        float f3 = (float) j2;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        return this.f56066h;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f56062d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f56062d.close();
        b.a(this);
        this.f56064f = -1L;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        this.f56062d.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f56062d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f56064f <= 0) {
            this.f56064f = System.currentTimeMillis();
        }
        this.f56063e++;
        if (b.f56056b && b.a) {
            if (this.a < 0) {
                b();
            }
            int read = this.f56062d.read();
            this.a++;
            c();
            return read;
        }
        return this.f56062d.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f56062d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        return this.f56062d.skip(j2);
    }
}
