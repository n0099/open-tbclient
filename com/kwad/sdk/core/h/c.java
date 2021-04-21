package com.kwad.sdk.core.h;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    public InputStream f34229d;

    /* renamed from: e  reason: collision with root package name */
    public int f34230e;

    /* renamed from: g  reason: collision with root package name */
    public volatile float f34232g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f34233h;

    /* renamed from: a  reason: collision with root package name */
    public int f34226a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f34227b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public long f34228c = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f34231f = -1;
    public int i = LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA;

    public c(@NonNull InputStream inputStream, int i) {
        i = i < 20480 ? LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_EXTRA : i;
        this.f34229d = inputStream;
        this.f34232g = i / 1000.0f;
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
        this.f34226a = 0;
        this.f34228c = System.currentTimeMillis();
    }

    private void c() {
        if (this.f34226a < this.f34227b) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f34228c;
        float f2 = this.f34226a / this.f34232g;
        this.f34233h = a(this.f34230e, currentTimeMillis - this.f34231f);
        float f3 = (float) j;
        if (f2 > f3) {
            a(f2 - f3);
        }
        b();
    }

    public long a() {
        return this.f34233h;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f34229d.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f34229d.close();
        b.a(this);
        this.f34231f = -1L;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.f34229d.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f34229d.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f34231f <= 0) {
            this.f34231f = System.currentTimeMillis();
        }
        this.f34230e++;
        if (b.f34222b && b.f34221a) {
            if (this.f34226a < 0) {
                b();
            }
            int read = this.f34229d.read();
            this.f34226a++;
            c();
            return read;
        }
        return this.f34229d.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f34229d.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f34229d.skip(j);
    }
}
