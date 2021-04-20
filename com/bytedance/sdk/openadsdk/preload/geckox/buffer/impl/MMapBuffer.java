package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.g;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class MMapBuffer implements com.bytedance.sdk.openadsdk.preload.geckox.buffer.a {

    /* renamed from: a  reason: collision with root package name */
    public long f29918a;

    /* renamed from: b  reason: collision with root package name */
    public long f29919b;

    /* renamed from: c  reason: collision with root package name */
    public long f29920c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f29921d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public File f29922e;

    static {
        g.a("buffer_pg");
    }

    public MMapBuffer(long j, File file) throws IOException {
        d(j);
        this.f29922e = file;
        file.getParentFile().mkdirs();
        c(nCreate(file.getAbsolutePath(), j));
    }

    private native long nCreate(String str, long j) throws IOException;

    private native int nFlush(long j, long j2) throws IOException;

    private native void nRead(long j, long j2, byte[] bArr, int i, int i2);

    private native int nRelease(long j, long j2);

    private native void nWrite(long j, long j2, byte[] bArr, int i, int i2);

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a() throws IOException {
        if (!this.f29921d.get()) {
            nFlush(this.f29919b, this.f29918a);
            return;
        }
        throw new IOException("released!");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long b() {
        return this.f29918a;
    }

    public void c(long j) {
        this.f29919b = j;
    }

    public void d(long j) {
        this.f29918a = j;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void e() {
        if (this.f29921d.getAndSet(true)) {
            return;
        }
        nRelease(this.f29919b, this.f29918a);
        this.f29919b = 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public File f() {
        return this.f29922e;
    }

    public void finalize() throws Throwable {
        super.finalize();
        try {
            e();
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.c.a(e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
        if (r4 > r0) goto L5;
     */
    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(long j) throws IOException {
        if (!this.f29921d.get()) {
            long j2 = 0;
            if (j >= 0) {
                j2 = this.f29918a;
            }
            j = j2;
            this.f29920c = j;
            return;
        }
        throw new IOException("released!");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long c() throws IOException {
        if (!this.f29921d.get()) {
            return this.f29920c;
        }
        throw new IOException("released!");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int d() throws IOException {
        byte[] bArr = new byte[1];
        if (b(bArr) <= 0) {
            return -1;
        }
        return bArr[0];
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a(int i) throws IOException {
        a(new byte[]{(byte) i});
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a(byte[] bArr) throws IOException {
        a(bArr, 0, bArr.length);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public synchronized long a(long j) throws IOException {
        if (this.f29921d.get()) {
            throw new IOException("released!");
        }
        if (j <= 0) {
            return 0L;
        }
        long j2 = this.f29920c;
        long j3 = this.f29920c + j;
        this.f29920c = j3;
        if (j3 < 0) {
            this.f29920c = 0L;
        } else if (j3 > this.f29918a) {
            this.f29920c = this.f29918a;
        }
        return this.f29920c - j2;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int b(byte[] bArr) throws IOException {
        return b(bArr, 0, bArr.length);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int b(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f29921d.get()) {
            if (bArr == null || i2 < 1 || i < 0 || i >= bArr.length) {
                return 0;
            }
            if (i + i2 > bArr.length) {
                i2 = bArr.length - i;
            }
            synchronized (this) {
                if (this.f29920c == this.f29918a) {
                    return -1;
                }
                if (this.f29920c + i2 > this.f29918a) {
                    i2 = (int) (this.f29918a - this.f29920c);
                }
                nRead(this.f29919b, this.f29920c, bArr, i, i2);
                this.f29920c += i2;
                return i2;
            }
        }
        throw new IOException("released!");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int a(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f29921d.get()) {
            if (bArr == null || bArr.length == 0 || i2 < 1 || i < 0 || i >= bArr.length) {
                return 0;
            }
            if (i + i2 > bArr.length) {
                i2 = bArr.length - i;
            }
            synchronized (this) {
                if (this.f29920c == this.f29918a) {
                    return 0;
                }
                if (this.f29920c + i2 > this.f29918a) {
                    i2 = (int) (this.f29918a - this.f29920c);
                }
                nWrite(this.f29919b, this.f29920c, bArr, i, i2);
                this.f29920c += i2;
                return i2;
            }
        }
        throw new IOException("released!");
    }
}
