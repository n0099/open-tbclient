package com.bytedance.sdk.openadsdk.preload.geckox.buffer.a;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class a extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.preload.geckox.buffer.a f5064a;
    private long b;

    public a(com.bytedance.sdk.openadsdk.preload.geckox.buffer.a aVar) {
        this.f5064a = aVar;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.f5064a.b(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f5064a.b(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.f5064a.a(j);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        long b = this.f5064a.b() - this.f5064a.c();
        if (b > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.b = i;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f5064a.b(this.b);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f5064a.d();
    }
}
