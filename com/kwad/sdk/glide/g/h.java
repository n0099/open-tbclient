package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class h extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private int f10326a;

    public h(@NonNull InputStream inputStream) {
        super(inputStream);
        this.f10326a = Integer.MIN_VALUE;
    }

    private long a(long j) {
        if (this.f10326a == 0) {
            return -1L;
        }
        return (this.f10326a == Integer.MIN_VALUE || j <= ((long) this.f10326a)) ? j : this.f10326a;
    }

    private void b(long j) {
        if (this.f10326a == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.f10326a = (int) (this.f10326a - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.f10326a == Integer.MIN_VALUE ? super.available() : Math.min(this.f10326a, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.f10326a = i;
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
        this.f10326a = Integer.MIN_VALUE;
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
