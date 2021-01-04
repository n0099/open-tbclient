package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public final class c extends OutputStream {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f10342a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f10343b;
    private com.kwad.sdk.glide.load.engine.bitmap_recycle.b c;
    private int d;

    public c(@NonNull OutputStream outputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this(outputStream, bVar, 65536);
    }

    @VisibleForTesting
    c(@NonNull OutputStream outputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, int i) {
        this.f10342a = outputStream;
        this.c = bVar;
        this.f10343b = (byte[]) bVar.a(i, byte[].class);
    }

    private void a() {
        if (this.d > 0) {
            this.f10342a.write(this.f10343b, 0, this.d);
            this.d = 0;
        }
    }

    private void b() {
        if (this.d == this.f10343b.length) {
            a();
        }
    }

    private void c() {
        if (this.f10343b != null) {
            this.c.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) this.f10343b);
            this.f10343b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
            this.f10342a.close();
            c();
        } catch (Throwable th) {
            this.f10342a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        a();
        this.f10342a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        byte[] bArr = this.f10343b;
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
            if (this.d == 0 && i4 >= this.f10343b.length) {
                this.f10342a.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.f10343b.length - this.d);
            System.arraycopy(bArr, i5, this.f10343b, this.d, min);
            this.d += min;
            i3 += min;
            b();
        } while (i3 < i2);
    }
}
