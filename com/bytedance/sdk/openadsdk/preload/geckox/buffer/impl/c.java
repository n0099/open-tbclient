package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class c implements com.bytedance.sdk.openadsdk.preload.geckox.buffer.a {

    /* renamed from: a  reason: collision with root package name */
    public long f30849a;

    /* renamed from: b  reason: collision with root package name */
    public long f30850b;

    /* renamed from: c  reason: collision with root package name */
    public RandomAccessFile f30851c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f30852d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public File f30853e;

    public c(long j, File file) throws IOException {
        this.f30849a = j;
        this.f30853e = file;
        file.getParentFile().mkdirs();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f30851c = randomAccessFile;
            randomAccessFile.setLength(j);
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(this.f30851c);
            throw new IOException("create raf swap failed! path: " + file.getAbsolutePath() + " caused by: " + e2.getMessage(), e2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a() throws IOException {
        if (this.f30852d.get()) {
            throw new IOException("released!");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long b() {
        return this.f30849a;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long c() throws IOException {
        if (!this.f30852d.get()) {
            return this.f30850b;
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
        if (this.f30852d.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(this.f30851c);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public File f() {
        return this.f30853e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
        if (r4 > r0) goto L5;
     */
    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(long j) throws IOException {
        if (!this.f30852d.get()) {
            long j2 = 0;
            if (j >= 0) {
                j2 = this.f30849a;
            }
            j = j2;
            this.f30850b = j;
            this.f30851c.seek(j);
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
        int skipBytes;
        if (this.f30852d.get()) {
            throw new IOException("released!");
        }
        int i2 = (int) j;
        if (i2 == j) {
            skipBytes = this.f30851c.skipBytes(i2);
            this.f30850b = this.f30851c.getFilePointer();
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
    public int b(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f30852d.get()) {
            if (bArr == null || i3 < 1 || i2 < 0 || i2 >= bArr.length) {
                return 0;
            }
            if (i2 + i3 > bArr.length) {
                i3 = bArr.length - i2;
            }
            synchronized (this) {
                if (this.f30850b == this.f30849a) {
                    return -1;
                }
                if (this.f30850b + i3 > this.f30849a) {
                    i3 = (int) (this.f30849a - this.f30850b);
                }
                int read = this.f30851c.read(bArr, i2, i3);
                if (read == -1) {
                    return -1;
                }
                this.f30850b += read;
                return read;
            }
        }
        throw new IOException("released!");
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public int a(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f30852d.get()) {
            if (bArr == null || bArr.length == 0 || i3 < 1 || i2 < 0 || i2 >= bArr.length) {
                return 0;
            }
            if (i2 + i3 > bArr.length) {
                i3 = bArr.length - i2;
            }
            synchronized (this) {
                if (this.f30850b == this.f30849a) {
                    return 0;
                }
                if (this.f30850b + i3 > this.f30849a) {
                    i3 = (int) (this.f30849a - this.f30850b);
                }
                this.f30851c.write(bArr, i2, i3);
                this.f30850b += i3;
                return i3;
            }
        }
        throw new IOException("released!");
    }
}
