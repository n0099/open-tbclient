package d.a.k0.b.e;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public final class a extends f {

    /* renamed from: h  reason: collision with root package name */
    public final int f63099h;
    public ByteBuffer j;

    /* renamed from: i  reason: collision with root package name */
    public final UploadDataProvider f63100i = new b();
    public boolean k = false;

    /* loaded from: classes5.dex */
    public class b extends UploadDataProvider {
        public b() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long n() {
            if (a.this.f63099h == -1) {
                return a.this.k ? a.this.j.limit() : a.this.j.position();
            }
            return a.this.f63099h;
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
            uploadDataSink.a();
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
            int i2 = (int) j;
            this.f63099h = i2;
            this.j = ByteBuffer.allocate(i2);
            return;
        }
        throw new IllegalArgumentException("Content length < 0.");
    }

    @Override // d.a.k0.b.e.f
    public void q() throws IOException {
    }

    @Override // d.a.k0.b.e.f
    public UploadDataProvider r() {
        return this.f63100i;
    }

    @Override // d.a.k0.b.e.f
    public void s() throws IOException {
        this.k = true;
        if (this.j.position() >= this.f63099h) {
            this.j.flip();
            return;
        }
        throw new ProtocolException("Content received is less than Content-Length");
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        o();
        x(1);
        this.j.put((byte) i2);
    }

    public final void x(int i2) throws IOException {
        if (this.f63099h != -1 && this.j.position() + i2 > this.f63099h) {
            throw new ProtocolException("exceeded content-length limit of " + this.f63099h + " bytes");
        } else if (!this.k) {
            if (this.f63099h == -1 && this.j.limit() - this.j.position() <= i2) {
                ByteBuffer allocate = ByteBuffer.allocate(Math.max(this.j.capacity() * 2, this.j.capacity() + i2));
                this.j.flip();
                allocate.put(this.j);
                this.j = allocate;
            }
        } else {
            throw new IllegalStateException("Cannot write after being connected.");
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        o();
        x(i3);
        this.j.put(bArr, i2, i3);
    }

    public a(d dVar) {
        if (dVar != null) {
            this.f63099h = -1;
            this.j = ByteBuffer.allocate(16384);
            return;
        }
        throw null;
    }
}
