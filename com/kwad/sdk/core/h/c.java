package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.logsystem.basic.upload.CrashPadUtil;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class c extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f55895d;

    /* renamed from: e  reason: collision with root package name */
    public int f55896e;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f55898g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f55899h;
    public int a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f55893b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public long f55894c = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f55897f = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f55900i = CrashPadUtil.MAX_READ_EXTRA;

    public c(@NonNull InputStream inputStream, int i2) {
        i2 = i2 < 20480 ? CrashPadUtil.MAX_READ_EXTRA : i2;
        this.f55895d = inputStream;
        this.f55898g = i2 / 1000.0f;
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
        this.f55894c = System.currentTimeMillis();
    }

    private void c() {
        if (this.a < this.f55893b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.f55894c;
        float f2 = this.a / this.f55898g;
        this.f55899h = a(this.f55896e, currentTimeMillis - this.f55897f);
        float f3 = (float) j2;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        return this.f55899h;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f55895d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f55895d.close();
        b.a(this);
        this.f55897f = -1L;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        this.f55895d.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f55895d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f55897f <= 0) {
            this.f55897f = System.currentTimeMillis();
        }
        this.f55896e++;
        if (b.f55889b && b.a) {
            if (this.a < 0) {
                b();
            }
            int read = this.f55895d.read();
            this.a++;
            c();
            return read;
        }
        return this.f55895d.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f55895d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        return this.f55895d.skip(j2);
    }
}
