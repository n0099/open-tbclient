package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public final class c extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final long f10018a;

    /* renamed from: b  reason: collision with root package name */
    private int f10019b;

    private c(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.f10018a = j;
    }

    private int a(int i) {
        if (i >= 0) {
            this.f10019b += i;
        } else if (this.f10018a - this.f10019b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f10018a + ", but read: " + this.f10019b);
        }
        return i;
    }

    @NonNull
    public static InputStream a(@NonNull InputStream inputStream, long j) {
        return new c(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.f10018a - this.f10019b, this.in.available());
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
