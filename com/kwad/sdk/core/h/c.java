package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f33844d;

    /* renamed from: e  reason: collision with root package name */
    public int f33845e;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f33847g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f33848h;

    /* renamed from: a  reason: collision with root package name */
    public int f33841a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f33842b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public long f33843c = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f33846f = -1;
    public int i = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA;

    public c(@NonNull InputStream inputStream, int i) {
        i = i < 20480 ? LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA : i;
        this.f33844d = inputStream;
        this.f33847g = i / 1000.0f;
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
        this.f33841a = 0;
        this.f33843c = System.currentTimeMillis();
    }

    private void c() {
        if (this.f33841a < this.f33842b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f33843c;
        float f2 = this.f33841a / this.f33847g;
        this.f33848h = a(this.f33845e, currentTimeMillis - this.f33846f);
        float f3 = (float) j;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        return this.f33848h;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f33844d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f33844d.close();
        b.a(this);
        this.f33846f = -1L;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.f33844d.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f33844d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f33846f <= 0) {
            this.f33846f = System.currentTimeMillis();
        }
        this.f33845e++;
        if (b.f33837b && b.f33836a) {
            if (this.f33841a < 0) {
                b();
            }
            int read = this.f33844d.read();
            this.f33841a++;
            c();
            return read;
        }
        return this.f33844d.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f33844d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f33844d.skip(j);
    }
}
