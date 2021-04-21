package d.b.a0.k.f;

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
    public final InputStream f41979e;

    /* renamed from: f  reason: collision with root package name */
    public final Charset f41980f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f41981g;

    /* renamed from: h  reason: collision with root package name */
    public int f41982h;
    public int i;

    /* loaded from: classes2.dex */
    public class a extends ByteArrayOutputStream {
        public a(int i) {
            super(i);
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
            if (((java.io.ByteArrayOutputStream) r5).buf[r0] == 13) goto L5;
         */
        @Override // java.io.ByteArrayOutputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            int i;
            int i2 = ((ByteArrayOutputStream) this).count;
            if (i2 > 0) {
                i = i2 - 1;
            }
            i = ((ByteArrayOutputStream) this).count;
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i, b.this.f41980f.name());
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
        synchronized (this.f41979e) {
            if (this.f41981g != null) {
                this.f41981g = null;
                this.f41979e.close();
            }
        }
    }

    public boolean n() {
        return this.i == -1;
    }

    public String q() {
        int i;
        int i2;
        synchronized (this.f41979e) {
            if (this.f41981g != null) {
                if (this.f41982h >= this.i) {
                    r();
                }
                for (int i3 = this.f41982h; i3 != this.i; i3++) {
                    if (this.f41981g[i3] == 10) {
                        if (i3 != this.f41982h) {
                            i2 = i3 - 1;
                            if (this.f41981g[i2] == 13) {
                                String str = new String(this.f41981g, this.f41982h, i2 - this.f41982h, this.f41980f.name());
                                this.f41982h = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f41981g, this.f41982h, i2 - this.f41982h, this.f41980f.name());
                        this.f41982h = i3 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.i - this.f41982h) + 80);
                loop1: while (true) {
                    aVar.write(this.f41981g, this.f41982h, this.i - this.f41982h);
                    this.i = -1;
                    r();
                    i = this.f41982h;
                    while (i != this.i) {
                        if (this.f41981g[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f41982h) {
                    aVar.write(this.f41981g, this.f41982h, i - this.f41982h);
                }
                this.f41982h = i + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public final void r() {
        InputStream inputStream = this.f41979e;
        byte[] bArr = this.f41981g;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f41982h = 0;
            this.i = read;
            return;
        }
        throw new EOFException();
    }

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i >= 0) {
            if (charset.equals(c.f41984a)) {
                this.f41979e = inputStream;
                this.f41980f = charset;
                this.f41981g = new byte[i];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
