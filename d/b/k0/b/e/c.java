package d.b.k0.b.e;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public final class c extends f {
    public static int m = 16384;

    /* renamed from: h  reason: collision with root package name */
    public final g f64810h;
    public final long i;
    public final ByteBuffer j;
    public final UploadDataProvider k = new b();
    public long l;

    /* loaded from: classes5.dex */
    public class b extends UploadDataProvider {
        public b() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long n() {
            return c.this.i;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void o(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.j.remaining()) {
                byteBuffer.put(c.this.j);
                c.this.j.clear();
                uploadDataSink.c(false);
                c.this.f64810h.quit();
                return;
            }
            int limit = c.this.j.limit();
            c.this.j.limit(c.this.j.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.j);
            c.this.j.limit(limit);
            uploadDataSink.c(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void p(UploadDataSink uploadDataSink) {
            uploadDataSink.a(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw null;
        }
        if (j >= 0) {
            this.i = j;
            this.j = ByteBuffer.allocate((int) Math.min(j, m));
            this.f64810h = gVar;
            this.l = 0L;
            return;
        }
        throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
    }

    public final void A() throws IOException {
        if (this.l == this.i) {
            z();
        }
    }

    @Override // d.b.k0.b.e.f
    public void q() throws IOException {
        if (this.l < this.i) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    @Override // d.b.k0.b.e.f
    public UploadDataProvider r() {
        return this.k;
    }

    @Override // d.b.k0.b.e.f
    public void s() throws IOException {
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        o();
        x(1);
        y();
        this.j.put((byte) i);
        this.l++;
        A();
    }

    public final void x(int i) throws ProtocolException {
        if (this.l + i <= this.i) {
            return;
        }
        throw new ProtocolException("expected " + (this.i - this.l) + " bytes but received " + i);
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
        this.f64810h.a();
        n();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        o();
        if (bArr.length - i >= i2 && i >= 0 && i2 >= 0) {
            x(i2);
            int i3 = i2;
            while (i3 > 0) {
                y();
                int min = Math.min(i3, this.j.remaining());
                this.j.put(bArr, (i + i2) - i3, min);
                i3 -= min;
            }
            this.l += i2;
            A();
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
