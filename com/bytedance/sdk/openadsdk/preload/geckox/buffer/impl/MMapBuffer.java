package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.g;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
class MMapBuffer implements com.bytedance.sdk.openadsdk.preload.geckox.buffer.a {

    /* renamed from: a  reason: collision with root package name */
    private long f7462a;

    /* renamed from: b  reason: collision with root package name */
    private long f7463b;
    private long c;
    private AtomicBoolean d = new AtomicBoolean(false);
    private File e;

    private native long nCreate(String str, long j) throws IOException;

    private native int nFlush(long j, long j2) throws IOException;

    private native void nRead(long j, long j2, byte[] bArr, int i, int i2);

    private native int nRelease(long j, long j2);

    private native void nWrite(long j, long j2, byte[] bArr, int i, int i2);

    static {
        g.a("buffer_pg");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MMapBuffer(long j, File file) throws IOException {
        d(j);
        this.e = file;
        file.getParentFile().mkdirs();
        c(nCreate(file.getAbsolutePath(), j));
    }

    void c(long j) {
        this.f7463b = j;
    }

    void d(long j) {
        this.f7462a = j;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a() throws IOException {
        if (this.d.get()) {
            throw new IOException("released!");
        }
        nFlush(this.f7463b, this.f7462a);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long b() {
        return this.f7462a;
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
        long j2 = 0;
        synchronized (this) {
            if (this.d.get()) {
                throw new IOException("released!");
            }
            if (j > 0) {
                long j3 = this.c;
                this.c += j;
                if (this.c < 0) {
                    this.c = 0L;
                } else if (this.c > this.f7462a) {
                    this.c = this.f7462a;
                }
                j2 = this.c - j3;
            }
        }
        return j2;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int a(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (this.d.get()) {
            throw new IOException("released!");
        }
        if (bArr != null && bArr.length != 0 && i2 >= 1 && i >= 0 && i < bArr.length) {
            if (i + i2 > bArr.length) {
                i2 = bArr.length - i;
            }
            synchronized (this) {
                if (this.c != this.f7462a) {
                    i3 = this.c + ((long) i2) > this.f7462a ? (int) (this.f7462a - this.c) : i2;
                    nWrite(this.f7463b, this.c, bArr, i, i3);
                    this.c += i3;
                }
            }
        }
        return i3;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long c() throws IOException {
        if (this.d.get()) {
            throw new IOException("released!");
        }
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void b(long j) throws IOException {
        if (this.d.get()) {
            throw new IOException("released!");
        }
        if (j < 0) {
            j = 0;
        } else if (j > this.f7462a) {
            j = this.f7462a;
        }
        this.c = j;
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
    public int b(byte[] bArr) throws IOException {
        return b(bArr, 0, bArr.length);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int b(byte[] bArr, int i, int i2) throws IOException {
        if (this.d.get()) {
            throw new IOException("released!");
        }
        if (bArr == null || i2 < 1 || i < 0 || i >= bArr.length) {
            return 0;
        }
        if (i + i2 > bArr.length) {
            i2 = bArr.length - i;
        }
        synchronized (this) {
            if (this.c == this.f7462a) {
                return -1;
            }
            int i3 = this.c + ((long) i2) > this.f7462a ? (int) (this.f7462a - this.c) : i2;
            nRead(this.f7463b, this.c, bArr, i, i3);
            this.c += i3;
            return i3;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void e() {
        if (!this.d.getAndSet(true)) {
            nRelease(this.f7463b, this.f7462a);
            this.f7463b = 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public File f() {
        return this.e;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        try {
            e();
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.c.a(e);
        }
    }
}
