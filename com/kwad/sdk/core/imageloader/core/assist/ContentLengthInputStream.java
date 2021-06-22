package com.kwad.sdk.core.imageloader.core.assist;

import java.io.InputStream;
/* loaded from: classes7.dex */
public class ContentLengthInputStream extends InputStream {
    public final int length;
    public final InputStream stream;

    public ContentLengthInputStream(InputStream inputStream, int i2) {
        this.stream = inputStream;
        this.length = i2;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.stream.close();
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.stream.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.stream.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        return this.stream.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.stream.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        return this.stream.read(bArr, i2, i3);
    }

    @Override // java.io.InputStream
    public void reset() {
        this.stream.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.stream.skip(j);
    }
}
