package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.OutputStream;
/* loaded from: classes6.dex */
public final class c extends OutputStream {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final OutputStream f35633a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f35634b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35635c;

    /* renamed from: d  reason: collision with root package name */
    public int f35636d;

    public c(@NonNull OutputStream outputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this(outputStream, bVar, 65536);
    }

    @VisibleForTesting
    public c(@NonNull OutputStream outputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, int i) {
        this.f35633a = outputStream;
        this.f35635c = bVar;
        this.f35634b = (byte[]) bVar.a(i, byte[].class);
    }

    private void a() {
        int i = this.f35636d;
        if (i > 0) {
            this.f35633a.write(this.f35634b, 0, i);
            this.f35636d = 0;
        }
    }

    private void b() {
        if (this.f35636d == this.f35634b.length) {
            a();
        }
    }

    private void c() {
        byte[] bArr = this.f35634b;
        if (bArr != null) {
            this.f35635c.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
            this.f35634b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
            this.f35633a.close();
            c();
        } catch (Throwable th) {
            this.f35633a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        a();
        this.f35633a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        byte[] bArr = this.f35634b;
        int i2 = this.f35636d;
        this.f35636d = i2 + 1;
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
            if (this.f35636d == 0 && i4 >= this.f35634b.length) {
                this.f35633a.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.f35634b.length - this.f35636d);
            System.arraycopy(bArr, i5, this.f35634b, this.f35636d, min);
            this.f35636d += min;
            i3 += min;
            b();
        } while (i3 < i2);
    }
}
