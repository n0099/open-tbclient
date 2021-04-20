package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.OutputStream;
/* loaded from: classes6.dex */
public final class c extends OutputStream {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final OutputStream f35538a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f35539b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35540c;

    /* renamed from: d  reason: collision with root package name */
    public int f35541d;

    public c(@NonNull OutputStream outputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this(outputStream, bVar, 65536);
    }

    @VisibleForTesting
    public c(@NonNull OutputStream outputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, int i) {
        this.f35538a = outputStream;
        this.f35540c = bVar;
        this.f35539b = (byte[]) bVar.a(i, byte[].class);
    }

    private void a() {
        int i = this.f35541d;
        if (i > 0) {
            this.f35538a.write(this.f35539b, 0, i);
            this.f35541d = 0;
        }
    }

    private void b() {
        if (this.f35541d == this.f35539b.length) {
            a();
        }
    }

    private void c() {
        byte[] bArr = this.f35539b;
        if (bArr != null) {
            this.f35540c.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
            this.f35539b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
            this.f35538a.close();
            c();
        } catch (Throwable th) {
            this.f35538a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        a();
        this.f35538a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        byte[] bArr = this.f35539b;
        int i2 = this.f35541d;
        this.f35541d = i2 + 1;
        bArr[i2] = (byte) i;
        b();
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i, int i2) {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            if (this.f35541d == 0 && i4 >= this.f35539b.length) {
                this.f35538a.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.f35539b.length - this.f35541d);
            System.arraycopy(bArr, i5, this.f35539b, this.f35541d, min);
            this.f35541d += min;
            i3 += min;
            b();
        } while (i3 < i2);
    }
}
