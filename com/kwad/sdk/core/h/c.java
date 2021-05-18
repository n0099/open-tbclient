package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f32443d;

    /* renamed from: e  reason: collision with root package name */
    public int f32444e;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f32446g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f32447h;

    /* renamed from: a  reason: collision with root package name */
    public int f32440a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f32441b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public long f32442c = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f32445f = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f32448i = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA;

    public c(@NonNull InputStream inputStream, int i2) {
        i2 = i2 < 20480 ? LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA : i2;
        this.f32443d = inputStream;
        this.f32446g = i2 / 1000.0f;
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
        this.f32440a = 0;
        this.f32442c = System.currentTimeMillis();
    }

    private void c() {
        if (this.f32440a < this.f32441b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f32442c;
        float f2 = this.f32440a / this.f32446g;
        this.f32447h = a(this.f32444e, currentTimeMillis - this.f32445f);
        float f3 = (float) j;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        return this.f32447h;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f32443d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f32443d.close();
        b.a(this);
        this.f32445f = -1L;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        this.f32443d.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f32443d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f32445f <= 0) {
            this.f32445f = System.currentTimeMillis();
        }
        this.f32444e++;
        if (b.f32436b && b.f32435a) {
            if (this.f32440a < 0) {
                b();
            }
            int read = this.f32443d.read();
            this.f32440a++;
            c();
            return read;
        }
        return this.f32443d.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f32443d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f32443d.skip(j);
    }
}
