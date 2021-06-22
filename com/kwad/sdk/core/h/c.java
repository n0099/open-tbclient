package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class c extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f34570d;

    /* renamed from: e  reason: collision with root package name */
    public int f34571e;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f34573g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f34574h;

    /* renamed from: a  reason: collision with root package name */
    public int f34567a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f34568b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public long f34569c = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f34572f = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f34575i = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA;

    public c(@NonNull InputStream inputStream, int i2) {
        i2 = i2 < 20480 ? LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA : i2;
        this.f34570d = inputStream;
        this.f34573g = i2 / 1000.0f;
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
        this.f34567a = 0;
        this.f34569c = System.currentTimeMillis();
    }

    private void c() {
        if (this.f34567a < this.f34568b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f34569c;
        float f2 = this.f34567a / this.f34573g;
        this.f34574h = a(this.f34571e, currentTimeMillis - this.f34572f);
        float f3 = (float) j;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        return this.f34574h;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f34570d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f34570d.close();
        b.a(this);
        this.f34572f = -1L;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        this.f34570d.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f34570d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f34572f <= 0) {
            this.f34572f = System.currentTimeMillis();
        }
        this.f34571e++;
        if (b.f34563b && b.f34562a) {
            if (this.f34567a < 0) {
                b();
            }
            int read = this.f34570d.read();
            this.f34567a++;
            c();
            return read;
        }
        return this.f34570d.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f34570d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f34570d.skip(j);
    }
}
