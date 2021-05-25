package com.kwad.sdk.core.diskcache.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f32081a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f32082b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f32083c;

    /* renamed from: d  reason: collision with root package name */
    public int f32084d;

    /* renamed from: e  reason: collision with root package name */
    public int f32085e;

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f32087a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f32081a = inputStream;
        this.f32082b = charset;
        this.f32083c = new byte[i2];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() {
        InputStream inputStream = this.f32081a;
        byte[] bArr = this.f32083c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f32084d = 0;
        this.f32085e = read;
    }

    public String a() {
        int i2;
        int i3;
        synchronized (this.f32081a) {
            if (this.f32083c != null) {
                if (this.f32084d >= this.f32085e) {
                    c();
                }
                for (int i4 = this.f32084d; i4 != this.f32085e; i4++) {
                    if (this.f32083c[i4] == 10) {
                        if (i4 != this.f32084d) {
                            i3 = i4 - 1;
                            if (this.f32083c[i3] == 13) {
                                String str = new String(this.f32083c, this.f32084d, i3 - this.f32084d, this.f32082b.name());
                                this.f32084d = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(this.f32083c, this.f32084d, i3 - this.f32084d, this.f32082b.name());
                        this.f32084d = i4 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f32085e - this.f32084d) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i5 = ((ByteArrayOutputStream) this).count;
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, (i5 <= 0 || ((ByteArrayOutputStream) this).buf[i5 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i5 - 1, b.this.f32082b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.f32083c, this.f32084d, this.f32085e - this.f32084d);
                    this.f32085e = -1;
                    c();
                    i2 = this.f32084d;
                    while (i2 != this.f32085e) {
                        if (this.f32083c[i2] == 10) {
                            break loop1;
                        }
                        i2++;
                    }
                }
                if (i2 != this.f32084d) {
                    byteArrayOutputStream.write(this.f32083c, this.f32084d, i2 - this.f32084d);
                }
                this.f32084d = i2 + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f32085e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f32081a) {
            if (this.f32083c != null) {
                this.f32083c = null;
                this.f32081a.close();
            }
        }
    }
}
