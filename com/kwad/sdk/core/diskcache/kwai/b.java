package com.kwad.sdk.core.diskcache.kwai;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes7.dex */
public class b implements Closeable {
    public final InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f39390b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f39391c;

    /* renamed from: d  reason: collision with root package name */
    public int f39392d;

    /* renamed from: e  reason: collision with root package name */
    public int f39393e;

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.a = inputStream;
        this.f39390b = charset;
        this.f39391c = new byte[i];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() {
        InputStream inputStream = this.a;
        byte[] bArr = this.f39391c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f39392d = 0;
        this.f39393e = read;
    }

    public String a() {
        int i;
        int i2;
        synchronized (this.a) {
            if (this.f39391c != null) {
                if (this.f39392d >= this.f39393e) {
                    c();
                }
                for (int i3 = this.f39392d; i3 != this.f39393e; i3++) {
                    if (this.f39391c[i3] == 10) {
                        if (i3 != this.f39392d) {
                            i2 = i3 - 1;
                            if (this.f39391c[i2] == 13) {
                                String str = new String(this.f39391c, this.f39392d, i2 - this.f39392d, this.f39390b.name());
                                this.f39392d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f39391c, this.f39392d, i2 - this.f39392d, this.f39390b.name());
                        this.f39392d = i3 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f39393e - this.f39392d) + 80) { // from class: com.kwad.sdk.core.diskcache.kwai.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i4 = ((ByteArrayOutputStream) this).count;
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, (i4 <= 0 || ((ByteArrayOutputStream) this).buf[i4 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i4 - 1, b.this.f39390b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.f39391c, this.f39392d, this.f39393e - this.f39392d);
                    this.f39393e = -1;
                    c();
                    i = this.f39392d;
                    while (i != this.f39393e) {
                        if (this.f39391c[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f39392d) {
                    byteArrayOutputStream.write(this.f39391c, this.f39392d, i - this.f39392d);
                }
                this.f39392d = i + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f39393e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.a) {
            if (this.f39391c != null) {
                this.f39391c = null;
                this.a.close();
            }
        }
    }
}
