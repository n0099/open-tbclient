package com.kwad.sdk.glide.a;

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
    public final InputStream f35051a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f35052b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f35053c;

    /* renamed from: d  reason: collision with root package name */
    public int f35054d;

    /* renamed from: e  reason: collision with root package name */
    public int f35055e;

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f35057a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f35051a = inputStream;
        this.f35052b = charset;
        this.f35053c = new byte[i];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() {
        InputStream inputStream = this.f35051a;
        byte[] bArr = this.f35053c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f35054d = 0;
        this.f35055e = read;
    }

    public String a() {
        int i;
        int i2;
        synchronized (this.f35051a) {
            if (this.f35053c != null) {
                if (this.f35054d >= this.f35055e) {
                    c();
                }
                for (int i3 = this.f35054d; i3 != this.f35055e; i3++) {
                    if (this.f35053c[i3] == 10) {
                        if (i3 != this.f35054d) {
                            i2 = i3 - 1;
                            if (this.f35053c[i2] == 13) {
                                String str = new String(this.f35053c, this.f35054d, i2 - this.f35054d, this.f35052b.name());
                                this.f35054d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f35053c, this.f35054d, i2 - this.f35054d, this.f35052b.name());
                        this.f35054d = i3 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f35055e - this.f35054d) + 80) { // from class: com.kwad.sdk.glide.a.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i4 = ((ByteArrayOutputStream) this).count;
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, (i4 <= 0 || ((ByteArrayOutputStream) this).buf[i4 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i4 - 1, b.this.f35052b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.f35053c, this.f35054d, this.f35055e - this.f35054d);
                    this.f35055e = -1;
                    c();
                    i = this.f35054d;
                    while (i != this.f35055e) {
                        if (this.f35053c[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f35054d) {
                    byteArrayOutputStream.write(this.f35053c, this.f35054d, i - this.f35054d);
                }
                this.f35054d = i + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f35055e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f35051a) {
            if (this.f35053c != null) {
                this.f35053c = null;
                this.f35051a.close();
            }
        }
    }
}
