package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f32372d;

    /* renamed from: e  reason: collision with root package name */
    public int f32373e;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f32375g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f32376h;

    /* renamed from: a  reason: collision with root package name */
    public int f32369a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f32370b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public long f32371c = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f32374f = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f32377i = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA;

    public c(@NonNull InputStream inputStream, int i2) {
        i2 = i2 < 20480 ? LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA : i2;
        this.f32372d = inputStream;
        this.f32375g = i2 / 1000.0f;
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
        this.f32369a = 0;
        this.f32371c = System.currentTimeMillis();
    }

    private void c() {
        if (this.f32369a < this.f32370b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f32371c;
        float f2 = this.f32369a / this.f32375g;
        this.f32376h = a(this.f32373e, currentTimeMillis - this.f32374f);
        float f3 = (float) j;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        return this.f32376h;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f32372d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f32372d.close();
        b.a(this);
        this.f32374f = -1L;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        this.f32372d.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f32372d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f32374f <= 0) {
            this.f32374f = System.currentTimeMillis();
        }
        this.f32373e++;
        if (b.f32365b && b.f32364a) {
            if (this.f32369a < 0) {
                b();
            }
            int read = this.f32372d.read();
            this.f32369a++;
            c();
            return read;
        }
        return this.f32372d.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f32372d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f32372d.skip(j);
    }
}
