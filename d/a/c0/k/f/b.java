package d.a.c0.k.f;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
public class b implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public final InputStream f43105e;

    /* renamed from: f  reason: collision with root package name */
    public final Charset f43106f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f43107g;

    /* renamed from: h  reason: collision with root package name */
    public int f43108h;

    /* renamed from: i  reason: collision with root package name */
    public int f43109i;

    /* loaded from: classes2.dex */
    public class a extends ByteArrayOutputStream {
        public a(int i2) {
            super(i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
            if (((java.io.ByteArrayOutputStream) r5).buf[r0] == 13) goto L5;
         */
        @Override // java.io.ByteArrayOutputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            int i2;
            int i3 = ((ByteArrayOutputStream) this).count;
            if (i3 > 0) {
                i2 = i3 - 1;
            }
            i2 = ((ByteArrayOutputStream) this).count;
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i2, b.this.f43106f.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f43105e) {
            if (this.f43107g != null) {
                this.f43107g = null;
                this.f43105e.close();
            }
        }
    }

    public boolean n() {
        return this.f43109i == -1;
    }

    public String q() {
        int i2;
        int i3;
        synchronized (this.f43105e) {
            if (this.f43107g != null) {
                if (this.f43108h >= this.f43109i) {
                    r();
                }
                for (int i4 = this.f43108h; i4 != this.f43109i; i4++) {
                    if (this.f43107g[i4] == 10) {
                        if (i4 != this.f43108h) {
                            i3 = i4 - 1;
                            if (this.f43107g[i3] == 13) {
                                String str = new String(this.f43107g, this.f43108h, i3 - this.f43108h, this.f43106f.name());
                                this.f43108h = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(this.f43107g, this.f43108h, i3 - this.f43108h, this.f43106f.name());
                        this.f43108h = i4 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f43109i - this.f43108h) + 80);
                loop1: while (true) {
                    aVar.write(this.f43107g, this.f43108h, this.f43109i - this.f43108h);
                    this.f43109i = -1;
                    r();
                    i2 = this.f43108h;
                    while (i2 != this.f43109i) {
                        if (this.f43107g[i2] == 10) {
                            break loop1;
                        }
                        i2++;
                    }
                }
                if (i2 != this.f43108h) {
                    aVar.write(this.f43107g, this.f43108h, i2 - this.f43108h);
                }
                this.f43108h = i2 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public final void r() {
        InputStream inputStream = this.f43105e;
        byte[] bArr = this.f43107g;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f43108h = 0;
            this.f43109i = read;
            return;
        }
        throw new EOFException();
    }

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 >= 0) {
            if (charset.equals(c.f43111a)) {
                this.f43105e = inputStream;
                this.f43106f = charset;
                this.f43107g = new byte[i2];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
