package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public final class c extends OutputStream {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f6645a;
    private byte[] b;
    private com.kwad.sdk.glide.load.engine.bitmap_recycle.b c;
    private int d;

    public c(@NonNull OutputStream outputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this(outputStream, bVar, 65536);
    }

    @VisibleForTesting
    c(@NonNull OutputStream outputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, int i) {
        this.f6645a = outputStream;
        this.c = bVar;
        this.b = (byte[]) bVar.a(i, byte[].class);
    }

    private void a() {
        if (this.d > 0) {
            this.f6645a.write(this.b, 0, this.d);
            this.d = 0;
        }
    }

    private void b() {
        if (this.d == this.b.length) {
            a();
        }
    }

    private void c() {
        if (this.b != null) {
            this.c.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) this.b);
            this.b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
            this.f6645a.close();
            c();
        } catch (Throwable th) {
            this.f6645a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        a();
        this.f6645a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        byte[] bArr = this.b;
        int i2 = this.d;
        this.d = i2 + 1;
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
            if (this.d == 0 && i4 >= this.b.length) {
                this.f6645a.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.b.length - this.d);
            System.arraycopy(bArr, i5, this.b, this.d, min);
            this.d += min;
            i3 += min;
            b();
        } while (i3 < i2);
    }
}
