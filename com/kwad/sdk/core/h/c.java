package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f34134d;

    /* renamed from: e  reason: collision with root package name */
    public int f34135e;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f34137g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f34138h;

    /* renamed from: a  reason: collision with root package name */
    public int f34131a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f34132b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public long f34133c = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f34136f = -1;
    public int i = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA;

    public c(@NonNull InputStream inputStream, int i) {
        i = i < 20480 ? LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA : i;
        this.f34134d = inputStream;
        this.f34137g = i / 1000.0f;
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
        this.f34131a = 0;
        this.f34133c = System.currentTimeMillis();
    }

    private void c() {
        if (this.f34131a < this.f34132b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f34133c;
        float f2 = this.f34131a / this.f34137g;
        this.f34138h = a(this.f34135e, currentTimeMillis - this.f34136f);
        float f3 = (float) j;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        return this.f34138h;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f34134d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f34134d.close();
        b.a(this);
        this.f34136f = -1L;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.f34134d.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f34134d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f34136f <= 0) {
            this.f34136f = System.currentTimeMillis();
        }
        this.f34135e++;
        if (b.f34127b && b.f34126a) {
            if (this.f34131a < 0) {
                b();
            }
            int read = this.f34134d.read();
            this.f34131a++;
            c();
            return read;
        }
        return this.f34134d.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f34134d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f34134d.skip(j);
    }
}
