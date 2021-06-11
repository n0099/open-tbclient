package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f34472d;

    /* renamed from: e  reason: collision with root package name */
    public int f34473e;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f34475g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f34476h;

    /* renamed from: a  reason: collision with root package name */
    public int f34469a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f34470b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public long f34471c = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f34474f = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f34477i = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA;

    public c(@NonNull InputStream inputStream, int i2) {
        i2 = i2 < 20480 ? LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA : i2;
        this.f34472d = inputStream;
        this.f34475g = i2 / 1000.0f;
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
        this.f34469a = 0;
        this.f34471c = System.currentTimeMillis();
    }

    private void c() {
        if (this.f34469a < this.f34470b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f34471c;
        float f2 = this.f34469a / this.f34475g;
        this.f34476h = a(this.f34473e, currentTimeMillis - this.f34474f);
        float f3 = (float) j;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        return this.f34476h;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f34472d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f34472d.close();
        b.a(this);
        this.f34474f = -1L;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        this.f34472d.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f34472d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f34474f <= 0) {
            this.f34474f = System.currentTimeMillis();
        }
        this.f34473e++;
        if (b.f34465b && b.f34464a) {
            if (this.f34469a < 0) {
                b();
            }
            int read = this.f34472d.read();
            this.f34469a++;
            c();
            return read;
        }
        return this.f34472d.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f34472d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f34472d.skip(j);
    }
}
