package com.bytedance.sdk.openadsdk.preload.geckox.buffer.a;

import java.io.IOException;
/* loaded from: classes6.dex */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.geckox.buffer.a f30232a;

    public b(com.bytedance.sdk.openadsdk.preload.geckox.buffer.a aVar) {
        this.f30232a = aVar;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.f30232a.a(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f30232a.a(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f30232a.a(bArr, i, i2);
    }
}
