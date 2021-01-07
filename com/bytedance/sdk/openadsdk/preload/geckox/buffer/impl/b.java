package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
class b implements com.bytedance.sdk.openadsdk.preload.geckox.buffer.a {

    /* renamed from: a  reason: collision with root package name */
    private RandomAccessFile f7762a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicBoolean f7763b = new AtomicBoolean(false);
    private File c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(File file) throws IOException {
        this.c = file;
        file.getParentFile().mkdirs();
        try {
            this.f7762a = new RandomAccessFile(file, "rw");
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(this.f7762a);
            throw new IOException("create raf mSwap failed! path: " + file.getAbsolutePath() + " caused by: " + e.getMessage(), e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a() throws IOException {
        if (this.f7763b.get()) {
            throw new IOException("released!");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long b() throws IOException {
        return this.f7762a.length();
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
        if (this.f7763b.get()) {
            throw new IOException("released!");
        }
        if (((int) j) != j) {
            throw new IOException("too large:" + j);
        }
        return this.f7762a.skipBytes((int) j);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int a(byte[] bArr, int i, int i2) throws IOException {
        if (this.f7763b.get()) {
            throw new IOException("released!");
        }
        if (bArr == null || bArr.length == 0 || i2 < 1) {
            return 0;
        }
        if (i < 0 || i >= bArr.length) {
            return 0;
        }
        if (i + i2 > bArr.length) {
            i2 = bArr.length - i;
        }
        synchronized (this) {
            this.f7762a.write(bArr, i, i2);
        }
        return i2;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long c() throws IOException {
        if (this.f7763b.get()) {
            throw new IOException("released!");
        }
        return this.f7762a.getFilePointer();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void b(long j) throws IOException {
        if (this.f7763b.get()) {
            throw new IOException("released!");
        }
        if (j < 0) {
            j = 0;
        }
        this.f7762a.seek(j);
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
        int read;
        if (this.f7763b.get()) {
            throw new IOException("released!");
        }
        if (bArr == null || i2 < 1 || i < 0 || i >= bArr.length) {
            return 0;
        }
        if (i + i2 > bArr.length) {
            i2 = bArr.length - i;
        }
        synchronized (this) {
            read = this.f7762a.read(bArr, i, i2);
        }
        return read;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void e() {
        if (!this.f7763b.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(this.f7762a);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public File f() {
        return this.c;
    }
}
