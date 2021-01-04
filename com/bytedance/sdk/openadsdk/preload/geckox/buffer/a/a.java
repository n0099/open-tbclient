package com.bytedance.sdk.openadsdk.preload.geckox.buffer.a;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class a extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.preload.geckox.buffer.a f7756a;

    /* renamed from: b  reason: collision with root package name */
    private long f7757b;

    public a(com.bytedance.sdk.openadsdk.preload.geckox.buffer.a aVar) {
        this.f7756a = aVar;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.f7756a.b(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f7756a.b(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.f7756a.a(j);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        long b2 = this.f7756a.b() - this.f7756a.c();
        return b2 > 2147483647L ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) b2;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.f7757b = i;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f7756a.b(this.f7757b);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f7756a.d();
    }
}
