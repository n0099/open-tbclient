package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.logsystem.basic.upload.CrashPadUtil;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class c extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f58046d;

    /* renamed from: e  reason: collision with root package name */
    public int f58047e;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f58049g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f58050h;
    public int a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f58044b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public long f58045c = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f58048f = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f58051i = CrashPadUtil.MAX_READ_EXTRA;

    public c(@NonNull InputStream inputStream, int i2) {
        i2 = i2 < 20480 ? CrashPadUtil.MAX_READ_EXTRA : i2;
        this.f58046d = inputStream;
        this.f58049g = i2 / 1000.0f;
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
        this.f58045c = System.currentTimeMillis();
    }

    private void c() {
        if (this.a < this.f58044b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.f58045c;
        float f2 = this.a / this.f58049g;
        this.f58050h = a(this.f58047e, currentTimeMillis - this.f58048f);
        float f3 = (float) j2;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        return this.f58050h;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f58046d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f58046d.close();
        b.a(this);
        this.f58048f = -1L;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i2) {
        this.f58046d.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f58046d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f58048f <= 0) {
            this.f58048f = System.currentTimeMillis();
        }
        this.f58047e++;
        if (b.f58040b && b.a) {
            if (this.a < 0) {
                b();
            }
            int read = this.f58046d.read();
            this.a++;
            c();
            return read;
        }
        return this.f58046d.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f58046d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        return this.f58046d.skip(j2);
    }
}
