package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f33198d;

    /* renamed from: e  reason: collision with root package name */
    public int f33199e;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f33201g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f33202h;

    /* renamed from: a  reason: collision with root package name */
    public int f33195a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f33196b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public long f33197c = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f33200f = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f33203i = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA;

    public c(@NonNull InputStream inputStream, int i2) {
        i2 = i2 < 20480 ? LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA : i2;
        this.f33198d = inputStream;
        this.f33201g = i2 / 1000.0f;
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
        this.f33195a = 0;
        this.f33197c = System.currentTimeMillis();
    }

    private void c() {
        if (this.f33195a < this.f33196b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f33197c;
        float f2 = this.f33195a / this.f33201g;
        this.f33202h = a(this.f33199e, currentTimeMillis - this.f33200f);
        float f3 = (float) j;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        return this.f33202h;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f33198d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f33198d.close();
        b.a(this);
        this.f33200f = -1L;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        this.f33198d.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f33198d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f33200f <= 0) {
            this.f33200f = System.currentTimeMillis();
        }
        this.f33199e++;
        if (b.f33191b && b.f33190a) {
            if (this.f33195a < 0) {
                b();
            }
            int read = this.f33198d.read();
            this.f33195a++;
            c();
            return read;
        }
        return this.f33198d.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f33198d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f33198d.skip(j);
    }
}
