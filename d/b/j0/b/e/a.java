package d.b.j0.b.e;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public final class a extends f {

    /* renamed from: h  reason: collision with root package name */
    public final int f64506h;
    public ByteBuffer j;
    public final UploadDataProvider i = new b();
    public boolean k = false;

    /* loaded from: classes5.dex */
    public class b extends UploadDataProvider {
        public b() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long n() {
            if (a.this.f64506h == -1) {
                return a.this.k ? a.this.j.limit() : a.this.j.position();
            }
            return a.this.f64506h;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void o(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (remaining < a.this.j.remaining()) {
                byteBuffer.put(a.this.j.array(), a.this.j.position(), remaining);
                a.this.j.position(a.this.j.position() + remaining);
            } else {
                byteBuffer.put(a.this.j);
            }
            uploadDataSink.c(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void p(UploadDataSink uploadDataSink) {
            a.this.j.position(0);
            uploadDataSink.b();
        }
    }

    public a(d dVar, long j) {
        if (dVar == null) {
            throw new NullPointerException("Argument connection cannot be null.");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2GB.");
        }
        if (j >= 0) {
            int i = (int) j;
            this.f64506h = i;
            this.j = ByteBuffer.allocate(i);
            return;
        }
        throw new IllegalArgumentException("Content length < 0.");
    }

    @Override // d.b.j0.b.e.f
    public void q() throws IOException {
    }

    @Override // d.b.j0.b.e.f
    public UploadDataProvider r() {
        return this.i;
    }

    @Override // d.b.j0.b.e.f
    public void s() throws IOException {
        this.k = true;
        if (this.j.position() >= this.f64506h) {
            this.j.flip();
            return;
        }
        throw new ProtocolException("Content received is less than Content-Length");
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        o();
        x(1);
        this.j.put((byte) i);
    }

    public final void x(int i) throws IOException {
        if (this.f64506h != -1 && this.j.position() + i > this.f64506h) {
            throw new ProtocolException("exceeded content-length limit of " + this.f64506h + " bytes");
        } else if (!this.k) {
            if (this.f64506h == -1 && this.j.limit() - this.j.position() <= i) {
                ByteBuffer allocate = ByteBuffer.allocate(Math.max(this.j.capacity() * 2, this.j.capacity() + i));
                this.j.flip();
                allocate.put(this.j);
                this.j = allocate;
            }
        } else {
            throw new IllegalStateException("Cannot write after being connected.");
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        o();
        x(i2);
        this.j.put(bArr, i, i2);
    }

    public a(d dVar) {
        if (dVar != null) {
            this.f64506h = -1;
            this.j = ByteBuffer.allocate(16384);
            return;
        }
        throw null;
    }
}
