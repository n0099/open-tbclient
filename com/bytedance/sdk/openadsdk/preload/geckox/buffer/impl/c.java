package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class c implements com.bytedance.sdk.openadsdk.preload.geckox.buffer.a {

    /* renamed from: a  reason: collision with root package name */
    public long f29926a;

    /* renamed from: b  reason: collision with root package name */
    public long f29927b;

    /* renamed from: c  reason: collision with root package name */
    public RandomAccessFile f29928c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f29929d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public File f29930e;

    public c(long j, File file) throws IOException {
        this.f29926a = j;
        this.f29930e = file;
        file.getParentFile().mkdirs();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f29928c = randomAccessFile;
            randomAccessFile.setLength(j);
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(this.f29928c);
            throw new IOException("create raf swap failed! path: " + file.getAbsolutePath() + " caused by: " + e2.getMessage(), e2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a() throws IOException {
        if (this.f29929d.get()) {
            throw new IOException("released!");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long b() {
        return this.f29926a;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long c() throws IOException {
        if (!this.f29929d.get()) {
            return this.f29927b;
        }
        throw new IOException("released!");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int d() throws IOException {
        byte[] bArr = new byte[1];
        if (b(bArr) == 0) {
            return -1;
        }
        return bArr[0];
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void e() {
        if (this.f29929d.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(this.f29928c);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public File f() {
        return this.f29930e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
        if (r4 > r0) goto L5;
     */
    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(long j) throws IOException {
        if (!this.f29929d.get()) {
            long j2 = 0;
            if (j >= 0) {
                j2 = this.f29926a;
            }
            j = j2;
            this.f29927b = j;
            this.f29928c.seek(j);
            return;
        }
        throw new IOException("released!");
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
        int skipBytes;
        if (this.f29929d.get()) {
            throw new IOException("released!");
        }
        int i = (int) j;
        if (i == j) {
            skipBytes = this.f29928c.skipBytes(i);
            this.f29927b = this.f29928c.getFilePointer();
        } else {
            throw new IOException("too large:" + j);
        }
        return skipBytes;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int b(byte[] bArr) throws IOException {
        return b(bArr, 0, bArr.length);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int b(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f29929d.get()) {
            if (bArr == null || i2 < 1 || i < 0 || i >= bArr.length) {
                return 0;
            }
            if (i + i2 > bArr.length) {
                i2 = bArr.length - i;
            }
            synchronized (this) {
                if (this.f29927b == this.f29926a) {
                    return -1;
                }
                if (this.f29927b + i2 > this.f29926a) {
                    i2 = (int) (this.f29926a - this.f29927b);
                }
                int read = this.f29928c.read(bArr, i, i2);
                if (read == -1) {
                    return -1;
                }
                this.f29927b += read;
                return read;
            }
        }
        throw new IOException("released!");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int a(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f29929d.get()) {
            if (bArr == null || bArr.length == 0 || i2 < 1 || i < 0 || i >= bArr.length) {
                return 0;
            }
            if (i + i2 > bArr.length) {
                i2 = bArr.length - i;
            }
            synchronized (this) {
                if (this.f29927b == this.f29926a) {
                    return 0;
                }
                if (this.f29927b + i2 > this.f29926a) {
                    i2 = (int) (this.f29926a - this.f29927b);
                }
                this.f29928c.write(bArr, i, i2);
                this.f29927b += i2;
                return i2;
            }
        }
        throw new IOException("released!");
    }
}
