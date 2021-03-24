package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public final class c extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public final long f35211a;

    /* renamed from: b  reason: collision with root package name */
    public int f35212b;

    public c(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.f35211a = j;
    }

    private int a(int i) {
        if (i >= 0) {
            this.f35212b += i;
        } else if (this.f35211a - this.f35212b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f35211a + ", but read: " + this.f35212b);
        }
        return i;
    }

    @NonNull
    public static InputStream a(@NonNull InputStream inputStream, long j) {
        return new c(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.f35211a - this.f35212b, ((FilterInputStream) this).in.available());
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
