package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import com.bytedance.sdk.openadsdk.preload.geckox.utils.g;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class MMapBuffer implements com.bytedance.sdk.openadsdk.preload.geckox.buffer.a {

    /* renamed from: a  reason: collision with root package name */
    public long f30841a;

    /* renamed from: b  reason: collision with root package name */
    public long f30842b;

    /* renamed from: c  reason: collision with root package name */
    public long f30843c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f30844d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public File f30845e;

    static {
        g.a("buffer_pg");
    }

    public MMapBuffer(long j, File file) throws IOException {
        d(j);
        this.f30845e = file;
        file.getParentFile().mkdirs();
        c(nCreate(file.getAbsolutePath(), j));
    }

    private native long nCreate(String str, long j) throws IOException;

    private native int nFlush(long j, long j2) throws IOException;

    private native void nRead(long j, long j2, byte[] bArr, int i2, int i3);

    private native int nRelease(long j, long j2);

    private native void nWrite(long j, long j2, byte[] bArr, int i2, int i3);

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a() throws IOException {
        if (!this.f30844d.get()) {
            nFlush(this.f30842b, this.f30841a);
            return;
        }
        throw new IOException("released!");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long b() {
        return this.f30841a;
    }

    public void c(long j) {
        this.f30842b = j;
    }

    public void d(long j) {
        this.f30841a = j;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void e() {
        if (this.f30844d.getAndSet(true)) {
            return;
        }
        nRelease(this.f30842b, this.f30841a);
        this.f30842b = 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public File f() {
        return this.f30845e;
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
        if (!this.f30844d.get()) {
            long j2 = 0;
            if (j >= 0) {
                j2 = this.f30841a;
            }
            j = j2;
            this.f30843c = j;
            return;
        }
        throw new IOException("released!");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long c() throws IOException {
        if (!this.f30844d.get()) {
            return this.f30843c;
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
    public void a(int i2) throws IOException {
        a(new byte[]{(byte) i2});
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a(byte[] bArr) throws IOException {
        a(bArr, 0, bArr.length);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public synchronized long a(long j) throws IOException {
        if (this.f30844d.get()) {
            throw new IOException("released!");
        }
        if (j <= 0) {
            return 0L;
        }
        long j2 = this.f30843c;
        long j3 = this.f30843c + j;
        this.f30843c = j3;
        if (j3 < 0) {
            this.f30843c = 0L;
        } else if (j3 > this.f30841a) {
            this.f30843c = this.f30841a;
        }
        return this.f30843c - j2;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int b(byte[] bArr) throws IOException {
        return b(bArr, 0, bArr.length);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int b(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f30844d.get()) {
            if (bArr == null || i3 < 1 || i2 < 0 || i2 >= bArr.length) {
                return 0;
            }
            if (i2 + i3 > bArr.length) {
                i3 = bArr.length - i2;
            }
            synchronized (this) {
                if (this.f30843c == this.f30841a) {
                    return -1;
                }
                if (this.f30843c + i3 > this.f30841a) {
                    i3 = (int) (this.f30841a - this.f30843c);
                }
                nRead(this.f30842b, this.f30843c, bArr, i2, i3);
                this.f30843c += i3;
                return i3;
            }
        }
        throw new IOException("released!");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int a(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f30844d.get()) {
            if (bArr == null || bArr.length == 0 || i3 < 1 || i2 < 0 || i2 >= bArr.length) {
                return 0;
            }
            if (i2 + i3 > bArr.length) {
                i3 = bArr.length - i2;
            }
            synchronized (this) {
                if (this.f30843c == this.f30841a) {
                    return 0;
                }
                if (this.f30843c + i3 > this.f30841a) {
                    i3 = (int) (this.f30841a - this.f30843c);
                }
                nWrite(this.f30842b, this.f30843c, bArr, i2, i3);
                this.f30843c += i3;
                return i3;
            }
        }
        throw new IOException("released!");
    }
}
