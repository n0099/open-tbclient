package com.kwad.sdk.core.diskcache.kwai;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
public class b implements Closeable {
    public final InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f57887b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f57888c;

    /* renamed from: d  reason: collision with root package name */
    public int f57889d;

    /* renamed from: e  reason: collision with root package name */
    public int f57890e;

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.a = inputStream;
        this.f57887b = charset;
        this.f57888c = new byte[i2];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() {
        InputStream inputStream = this.a;
        byte[] bArr = this.f57888c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f57889d = 0;
        this.f57890e = read;
    }

    public String a() {
        int i2;
        int i3;
        synchronized (this.a) {
            if (this.f57888c != null) {
                if (this.f57889d >= this.f57890e) {
                    c();
                }
                for (int i4 = this.f57889d; i4 != this.f57890e; i4++) {
                    if (this.f57888c[i4] == 10) {
                        if (i4 != this.f57889d) {
                            i3 = i4 - 1;
                            if (this.f57888c[i3] == 13) {
                                String str = new String(this.f57888c, this.f57889d, i3 - this.f57889d, this.f57887b.name());
                                this.f57889d = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(this.f57888c, this.f57889d, i3 - this.f57889d, this.f57887b.name());
                        this.f57889d = i4 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.f57890e - this.f57889d) + 80) { // from class: com.kwad.sdk.core.diskcache.kwai.b.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i5 = ((ByteArrayOutputStream) this).count;
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, (i5 <= 0 || ((ByteArrayOutputStream) this).buf[i5 + (-1)] != 13) ? ((ByteArrayOutputStream) this).count : i5 - 1, b.this.f57887b.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1: while (true) {
                    byteArrayOutputStream.write(this.f57888c, this.f57889d, this.f57890e - this.f57889d);
                    this.f57890e = -1;
                    c();
                    i2 = this.f57889d;
                    while (i2 != this.f57890e) {
                        if (this.f57888c[i2] == 10) {
                            break loop1;
                        }
                        i2++;
                    }
                }
                if (i2 != this.f57889d) {
                    byteArrayOutputStream.write(this.f57888c, this.f57889d, i2 - this.f57889d);
                }
                this.f57889d = i2 + 1;
                return byteArrayOutputStream.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean b() {
        return this.f57890e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.a) {
            if (this.f57888c != null) {
                this.f57888c = null;
                this.a.close();
            }
        }
    }
}
