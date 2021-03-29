package com.kwad.sdk.glide.load.a;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.OutputStream;
/* loaded from: classes6.dex */
public final class c extends OutputStream {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final OutputStream f35249a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f35250b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35251c;

    /* renamed from: d  reason: collision with root package name */
    public int f35252d;

    public c(@NonNull OutputStream outputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this(outputStream, bVar, 65536);
    }

    @VisibleForTesting
    public c(@NonNull OutputStream outputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, int i) {
        this.f35249a = outputStream;
        this.f35251c = bVar;
        this.f35250b = (byte[]) bVar.a(i, byte[].class);
    }

    private void a() {
        int i = this.f35252d;
        if (i > 0) {
            this.f35249a.write(this.f35250b, 0, i);
            this.f35252d = 0;
        }
    }

    private void b() {
        if (this.f35252d == this.f35250b.length) {
            a();
        }
    }

    private void c() {
        byte[] bArr = this.f35250b;
        if (bArr != null) {
            this.f35251c.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
            this.f35250b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
            this.f35249a.close();
            c();
        } catch (Throwable th) {
            this.f35249a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        a();
        this.f35249a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        byte[] bArr = this.f35250b;
        int i2 = this.f35252d;
        this.f35252d = i2 + 1;
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
            if (this.f35252d == 0 && i4 >= this.f35250b.length) {
                this.f35249a.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.f35250b.length - this.f35252d);
            System.arraycopy(bArr, i5, this.f35250b, this.f35252d, min);
            this.f35252d += min;
            i3 += min;
            b();
        } while (i3 < i2);
    }
}
