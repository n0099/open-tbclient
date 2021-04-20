package d.b.z.k.f;

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
    public final InputStream f65677e;

    /* renamed from: f  reason: collision with root package name */
    public final Charset f65678f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f65679g;

    /* renamed from: h  reason: collision with root package name */
    public int f65680h;
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
                return new String(((ByteArrayOutputStream) this).buf, 0, i, b.this.f65678f.name());
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
        synchronized (this.f65677e) {
            if (this.f65679g != null) {
                this.f65679g = null;
                this.f65677e.close();
            }
        }
    }

    public boolean n() {
        return this.i == -1;
    }

    public String q() {
        int i;
        int i2;
        synchronized (this.f65677e) {
            if (this.f65679g != null) {
                if (this.f65680h >= this.i) {
                    r();
                }
                for (int i3 = this.f65680h; i3 != this.i; i3++) {
                    if (this.f65679g[i3] == 10) {
                        if (i3 != this.f65680h) {
                            i2 = i3 - 1;
                            if (this.f65679g[i2] == 13) {
                                String str = new String(this.f65679g, this.f65680h, i2 - this.f65680h, this.f65678f.name());
                                this.f65680h = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f65679g, this.f65680h, i2 - this.f65680h, this.f65678f.name());
                        this.f65680h = i3 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.i - this.f65680h) + 80);
                loop1: while (true) {
                    aVar.write(this.f65679g, this.f65680h, this.i - this.f65680h);
                    this.i = -1;
                    r();
                    i = this.f65680h;
                    while (i != this.i) {
                        if (this.f65679g[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f65680h) {
                    aVar.write(this.f65679g, this.f65680h, i - this.f65680h);
                }
                this.f65680h = i + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public final void r() {
        InputStream inputStream = this.f65677e;
        byte[] bArr = this.f65679g;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f65680h = 0;
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
            if (charset.equals(c.f65682a)) {
                this.f65677e = inputStream;
                this.f65678f = charset;
                this.f65679g = new byte[i];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
