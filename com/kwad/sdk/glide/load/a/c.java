package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.OutputStream;
/* loaded from: classes7.dex */
public final class c extends OutputStream {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final OutputStream f36030a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f36031b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36032c;

    /* renamed from: d  reason: collision with root package name */
    public int f36033d;

    public c(@NonNull OutputStream outputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this(outputStream, bVar, 65536);
    }

    @VisibleForTesting
    public c(@NonNull OutputStream outputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, int i2) {
        this.f36030a = outputStream;
        this.f36032c = bVar;
        this.f36031b = (byte[]) bVar.a(i2, byte[].class);
    }

    private void a() {
        int i2 = this.f36033d;
        if (i2 > 0) {
            this.f36030a.write(this.f36031b, 0, i2);
            this.f36033d = 0;
        }
    }

    private void b() {
        if (this.f36033d == this.f36031b.length) {
            a();
        }
    }

    private void c() {
        byte[] bArr = this.f36031b;
        if (bArr != null) {
            this.f36032c.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
            this.f36031b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
            this.f36030a.close();
            c();
        } catch (Throwable th) {
            this.f36030a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        a();
        this.f36030a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i2) {
        byte[] bArr = this.f36031b;
        int i3 = this.f36033d;
        this.f36033d = i3 + 1;
        bArr[i3] = (byte) i2;
        b();
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i2, int i3) {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            if (this.f36033d == 0 && i5 >= this.f36031b.length) {
                this.f36030a.write(bArr, i6, i5);
                return;
            }
            int min = Math.min(i5, this.f36031b.length - this.f36033d);
            System.arraycopy(bArr, i6, this.f36031b, this.f36033d, min);
            this.f36033d += min;
            i4 += min;
            b();
        } while (i4 < i3);
    }
}
