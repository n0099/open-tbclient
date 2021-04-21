package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class h extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public int f35609a;

    public h(@NonNull InputStream inputStream) {
        super(inputStream);
        this.f35609a = Integer.MIN_VALUE;
    }

    private long a(long j) {
        int i = this.f35609a;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    private void b(long j) {
        int i = this.f35609a;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.f35609a = (int) (i - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i = this.f35609a;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.f35609a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        b(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) {
        int a2 = (int) a(i2);
        if (a2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i, a2);
        b(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.f35609a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long a2 = a(j);
        if (a2 == -1) {
            return 0L;
        }
        long skip = super.skip(a2);
        b(skip);
        return skip;
    }
}
