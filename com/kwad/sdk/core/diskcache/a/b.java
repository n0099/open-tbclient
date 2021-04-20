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
    public final InputStream f33786a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f33787b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f33788c;

    /* renamed from: d  reason: collision with root package name */
    public int f33789d;

    /* renamed from: e  reason: collision with root package name */
    public int f33790e;

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f33792a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f33786a = inputStream;
        this.f33787b = charset;
        this.f33788c = new byte[i];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() {
        InputStream inputStream = this.f33786a;
        byte[] bArr = this.f33788c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f33789d = 0;
        this.f33790e = read;
    }

    public String a() {
        int i;
        int i2;
        synchronized (this.f33786a) {
            if (this.f33788c != null) {
                if (this.f33789d >= this.f33790e) {
                    c();
                }
                for (int i3 = this.f33789d; i3 != this.f33790e; i3++) {
                    if (this.f33788c[i3] == 10) {
                        if (i3 != this.f33789d) {
                            i2 = i3 - 1;
                            if (this.f33788c[i2] == 13) {
                                String str = new String(this.f33788c, this.f33789d, i2 - this.f33789d, this.f33787b.name());
                                this.f33789d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f33788c, this.f33789d, i2 - this.f33789d, this.f33787b.name());
                        this.f33789d = i3 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f33790e - this.f33789d) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i4 = ((ByteArrayOutputStream) this).count;
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, (i4 <= 0 || ((ByteArrayOutputStream) this).buf[i4 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i4 - 1, b.this.f33787b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.f33788c, this.f33789d, this.f33790e - this.f33789d);
                    this.f33790e = -1;
                    c();
                    i = this.f33789d;
                    while (i != this.f33790e) {
                        if (this.f33788c[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f33789d) {
                    byteArrayOutputStream.write(this.f33788c, this.f33789d, i - this.f33789d);
                }
                this.f33789d = i + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f33790e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f33786a) {
            if (this.f33788c != null) {
                this.f33788c = null;
                this.f33786a.close();
            }
        }
    }
}
