package d.a.o0.b.e;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public final class b extends f {

    /* renamed from: h  reason: collision with root package name */
    public final d f67574h;

    /* renamed from: i  reason: collision with root package name */
    public final g f67575i;
    public final ByteBuffer j;
    public final UploadDataProvider k = new C1831b();
    public boolean l = false;
    public boolean m;
    public boolean n;

    /* renamed from: d.a.o0.b.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1831b extends UploadDataProvider {
        public C1831b() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long n() {
            return -1L;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void o(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= b.this.j.remaining()) {
                byteBuffer.put(b.this.j);
                b.this.j.clear();
                uploadDataSink.c(b.this.l);
                if (!b.this.l) {
                    b.this.f67575i.quit();
                    return;
                } else if (b.this.m) {
                    b.this.f67575i.quit();
                    return;
                } else {
                    return;
                }
            }
            int limit = b.this.j.limit();
            b.this.j.limit(b.this.j.position() + byteBuffer.remaining());
            byteBuffer.put(b.this.j);
            b.this.j.limit(limit);
            uploadDataSink.c(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void p(UploadDataSink uploadDataSink) {
            uploadDataSink.b(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    public b(d dVar, int i2, g gVar, boolean z, boolean z2) {
        this.m = false;
        this.n = false;
        if (dVar == null) {
            throw null;
        }
        if (i2 > 0) {
            this.j = ByteBuffer.allocate(i2);
            this.f67574h = dVar;
            this.f67575i = gVar;
            this.m = z;
            this.n = z2;
            return;
        }
        throw new IllegalArgumentException("chunkLength should be greater than 0");
    }

    @Override // d.a.o0.b.e.f, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.l) {
            return;
        }
        this.l = true;
        this.j.flip();
        if (this.m) {
            this.f67575i.b(this.f67574h.getReadTimeout());
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (!this.n || this.j.position() <= 0) {
            return;
        }
        z();
    }

    @Override // d.a.o0.b.e.f
    public void q() throws IOException {
    }

    @Override // d.a.o0.b.e.f
    public UploadDataProvider r() {
        return this.k;
    }

    @Override // d.a.o0.b.e.f
    public void s() throws IOException {
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        y();
        this.j.put((byte) i2);
    }

    public final void y() throws IOException {
        if (this.j.hasRemaining()) {
            return;
        }
        z();
    }

    public final void z() throws IOException {
        o();
        this.j.flip();
        this.f67575i.b(this.f67574h.getReadTimeout());
        n();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        o();
        if (bArr.length - i2 < i3 || i2 < 0 || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = i3;
        while (i4 > 0) {
            int min = Math.min(i4, this.j.remaining());
            this.j.put(bArr, (i2 + i3) - i4, min);
            i4 -= min;
            y();
        }
    }
}
