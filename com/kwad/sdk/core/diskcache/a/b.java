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
    public final InputStream f34119a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f34120b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f34121c;

    /* renamed from: d  reason: collision with root package name */
    public int f34122d;

    /* renamed from: e  reason: collision with root package name */
    public int f34123e;

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f34125a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f34119a = inputStream;
        this.f34120b = charset;
        this.f34121c = new byte[i2];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() {
        InputStream inputStream = this.f34119a;
        byte[] bArr = this.f34121c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f34122d = 0;
        this.f34123e = read;
    }

    public String a() {
        int i2;
        int i3;
        synchronized (this.f34119a) {
            if (this.f34121c != null) {
                if (this.f34122d >= this.f34123e) {
                    c();
                }
                for (int i4 = this.f34122d; i4 != this.f34123e; i4++) {
                    if (this.f34121c[i4] == 10) {
                        if (i4 != this.f34122d) {
                            i3 = i4 - 1;
                            if (this.f34121c[i3] == 13) {
                                String str = new String(this.f34121c, this.f34122d, i3 - this.f34122d, this.f34120b.name());
                                this.f34122d = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(this.f34121c, this.f34122d, i3 - this.f34122d, this.f34120b.name());
                        this.f34122d = i4 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f34123e - this.f34122d) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i5 = ((ByteArrayOutputStream) this).count;
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, (i5 <= 0 || ((ByteArrayOutputStream) this).buf[i5 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i5 - 1, b.this.f34120b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.f34121c, this.f34122d, this.f34123e - this.f34122d);
                    this.f34123e = -1;
                    c();
                    i2 = this.f34122d;
                    while (i2 != this.f34123e) {
                        if (this.f34121c[i2] == 10) {
                            break loop1;
                        }
                        i2++;
                    }
                }
                if (i2 != this.f34122d) {
                    byteArrayOutputStream.write(this.f34121c, this.f34122d, i2 - this.f34122d);
                }
                this.f34122d = i2 + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f34123e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f34119a) {
            if (this.f34121c != null) {
                this.f34121c = null;
                this.f34119a.close();
            }
        }
    }
}
