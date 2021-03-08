package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public final class c extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final long f6629a;
    private int b;

    private c(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.f6629a = j;
    }

    private int a(int i) {
        if (i >= 0) {
            this.b += i;
        } else if (this.f6629a - this.b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f6629a + ", but read: " + this.b);
        }
        return i;
    }

    @NonNull
    public static InputStream a(@NonNull InputStream inputStream, long j) {
        return new c(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.f6629a - this.b, this.in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        return a(super.read(bArr, i, i2));
    }
}
