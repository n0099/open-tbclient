package com.bytedance.sdk.openadsdk.preload.geckox.buffer.a;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class a extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.geckox.buffer.a f30229a;

    /* renamed from: b  reason: collision with root package name */
    public long f30230b;

    public a(com.bytedance.sdk.openadsdk.preload.geckox.buffer.a aVar) {
        this.f30229a = aVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        long b2 = this.f30229a.b() - this.f30229a.c();
        if (b2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) b2;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.f30230b = i;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.f30229a.b(bArr);
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f30229a.b(this.f30230b);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.f30229a.a(j);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f30229a.b(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f30229a.d();
    }
}
