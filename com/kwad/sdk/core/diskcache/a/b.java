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
    public final InputStream f32907a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f32908b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f32909c;

    /* renamed from: d  reason: collision with root package name */
    public int f32910d;

    /* renamed from: e  reason: collision with root package name */
    public int f32911e;

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f32913a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f32907a = inputStream;
        this.f32908b = charset;
        this.f32909c = new byte[i2];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() {
        InputStream inputStream = this.f32907a;
        byte[] bArr = this.f32909c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f32910d = 0;
        this.f32911e = read;
    }

    public String a() {
        int i2;
        int i3;
        synchronized (this.f32907a) {
            if (this.f32909c != null) {
                if (this.f32910d >= this.f32911e) {
                    c();
                }
                for (int i4 = this.f32910d; i4 != this.f32911e; i4++) {
                    if (this.f32909c[i4] == 10) {
                        if (i4 != this.f32910d) {
                            i3 = i4 - 1;
                            if (this.f32909c[i3] == 13) {
                                String str = new String(this.f32909c, this.f32910d, i3 - this.f32910d, this.f32908b.name());
                                this.f32910d = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(this.f32909c, this.f32910d, i3 - this.f32910d, this.f32908b.name());
                        this.f32910d = i4 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f32911e - this.f32910d) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i5 = ((ByteArrayOutputStream) this).count;
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, (i5 <= 0 || ((ByteArrayOutputStream) this).buf[i5 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i5 - 1, b.this.f32908b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.f32909c, this.f32910d, this.f32911e - this.f32910d);
                    this.f32911e = -1;
                    c();
                    i2 = this.f32910d;
                    while (i2 != this.f32911e) {
                        if (this.f32909c[i2] == 10) {
                            break loop1;
                        }
                        i2++;
                    }
                }
                if (i2 != this.f32910d) {
                    byteArrayOutputStream.write(this.f32909c, this.f32910d, i2 - this.f32910d);
                }
                this.f32910d = i2 + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f32911e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f32907a) {
            if (this.f32909c != null) {
                this.f32909c = null;
                this.f32907a.close();
            }
        }
    }
}
