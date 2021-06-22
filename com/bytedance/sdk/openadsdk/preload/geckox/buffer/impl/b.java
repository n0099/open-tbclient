package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class b implements com.bytedance.sdk.openadsdk.preload.geckox.buffer.a {

    /* renamed from: a  reason: collision with root package name */
    public RandomAccessFile f30205a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f30206b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public File f30207c;

    public b(File file) throws IOException {
        this.f30207c = file;
        file.getParentFile().mkdirs();
        try {
            this.f30205a = new RandomAccessFile(file, "rw");
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(this.f30205a);
            throw new IOException("create raf mSwap failed! path: " + file.getAbsolutePath() + " caused by: " + e2.getMessage(), e2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a() throws IOException {
        if (this.f30206b.get()) {
            throw new IOException("released!");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long b() throws IOException {
        return this.f30205a.length();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long c() throws IOException {
        if (!this.f30206b.get()) {
            return this.f30205a.getFilePointer();
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
    public void e() {
        if (this.f30206b.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(this.f30205a);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public File f() {
        return this.f30207c;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void b(long j) throws IOException {
        if (!this.f30206b.get()) {
            if (j < 0) {
                j = 0;
            }
            this.f30205a.seek(j);
            return;
        }
        throw new IOException("released!");
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
        int i2;
        if (this.f30206b.get()) {
            throw new IOException("released!");
        }
        i2 = (int) j;
        if (i2 == j) {
        } else {
            throw new IOException("too large:" + j);
        }
        return this.f30205a.skipBytes(i2);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int b(byte[] bArr) throws IOException {
        return b(bArr, 0, bArr.length);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int b(byte[] bArr, int i2, int i3) throws IOException {
        int read;
        if (!this.f30206b.get()) {
            if (bArr == null || i3 < 1 || i2 < 0 || i2 >= bArr.length) {
                return 0;
            }
            if (i2 + i3 > bArr.length) {
                i3 = bArr.length - i2;
            }
            synchronized (this) {
                read = this.f30205a.read(bArr, i2, i3);
            }
            return read;
        }
        throw new IOException("released!");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int a(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f30206b.get()) {
            if (bArr == null || bArr.length == 0 || i3 < 1 || i2 < 0 || i2 >= bArr.length) {
                return 0;
            }
            if (i2 + i3 > bArr.length) {
                i3 = bArr.length - i2;
            }
            synchronized (this) {
                this.f30205a.write(bArr, i2, i3);
            }
            return i3;
        }
        throw new IOException("released!");
    }
}
