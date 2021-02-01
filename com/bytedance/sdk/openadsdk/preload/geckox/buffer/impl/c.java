package com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl;

import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
class c implements com.bytedance.sdk.openadsdk.preload.geckox.buffer.a {

    /* renamed from: a  reason: collision with root package name */
    private long f7466a;

    /* renamed from: b  reason: collision with root package name */
    private long f7467b;
    private RandomAccessFile c;
    private AtomicBoolean d = new AtomicBoolean(false);
    private File e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(long j, File file) throws IOException {
        this.f7466a = j;
        this.e = file;
        file.getParentFile().mkdirs();
        try {
            this.c = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
            this.c.setLength(j);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(this.c);
            throw new IOException("create raf swap failed! path: " + file.getAbsolutePath() + " caused by: " + e.getMessage(), e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void a() throws IOException {
        if (this.d.get()) {
            throw new IOException("released!");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public long b() {
        return this.f7466a;
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
        if (this.d.get()) {
            throw new IOException("released!");
        }
        if (((int) j) != j) {
            throw new IOException("too large:" + j);
        }
        skipBytes = this.c.skipBytes((int) j);
        this.f7467b = this.c.getFilePointer();
        return skipBytes;
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
                if (this.f7467b != this.f7466a) {
                    i3 = this.f7467b + ((long) i2) > this.f7466a ? (int) (this.f7466a - this.f7467b) : i2;
                    this.c.write(bArr, i, i3);
                    this.f7467b += i3;
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
        return this.f7467b;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void b(long j) throws IOException {
        if (this.d.get()) {
            throw new IOException("released!");
        }
        if (j < 0) {
            j = 0;
        } else if (j > this.f7466a) {
            j = this.f7466a;
        }
        this.f7467b = j;
        this.c.seek(this.f7467b);
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
            if (this.f7467b == this.f7466a) {
                return -1;
            }
            if (this.f7467b + i2 > this.f7466a) {
                i2 = (int) (this.f7466a - this.f7467b);
            }
            int read = this.c.read(bArr, i, i2);
            if (read == -1) {
                return -1;
            }
            this.f7467b += read;
            return read;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public void e() {
        if (!this.d.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.preload.geckox.utils.b.a(this.c);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.buffer.a
    public File f() {
        return this.e;
    }
}
