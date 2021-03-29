package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f33845d;

    /* renamed from: e  reason: collision with root package name */
    public int f33846e;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f33848g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f33849h;

    /* renamed from: a  reason: collision with root package name */
    public int f33842a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f33843b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public long f33844c = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f33847f = -1;
    public int i = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA;

    public c(@NonNull InputStream inputStream, int i) {
        i = i < 20480 ? LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA : i;
        this.f33845d = inputStream;
        this.f33848g = i / 1000.0f;
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
        this.f33842a = 0;
        this.f33844c = System.currentTimeMillis();
    }

    private void c() {
        if (this.f33842a < this.f33843b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f33844c;
        float f2 = this.f33842a / this.f33848g;
        this.f33849h = a(this.f33846e, currentTimeMillis - this.f33847f);
        float f3 = (float) j;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        return this.f33849h;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f33845d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f33845d.close();
        b.a(this);
        this.f33847f = -1L;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.f33845d.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f33845d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f33847f <= 0) {
            this.f33847f = System.currentTimeMillis();
        }
        this.f33846e++;
        if (b.f33838b && b.f33837a) {
            if (this.f33842a < 0) {
                b();
            }
            int read = this.f33845d.read();
            this.f33842a++;
            c();
            return read;
        }
        return this.f33845d.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f33845d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f33845d.skip(j);
    }
}
