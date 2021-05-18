package d.a.l0.b.e;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class e extends InputStream {

    /* renamed from: e  reason: collision with root package name */
    public final d f63822e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63823f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f63824g;

    /* renamed from: h  reason: collision with root package name */
    public IOException f63825h;

    public e(d dVar) {
        this.f63822e = dVar;
    }

    public final void n() throws IOException {
        if (this.f63823f) {
            IOException iOException = this.f63825h;
            if (iOException != null) {
                throw iOException;
            }
        } else if (o()) {
        } else {
            if (this.f63824g == null) {
                this.f63824g = ByteBuffer.allocateDirect(32768);
            }
            this.f63824g.clear();
            this.f63822e.u(this.f63824g);
            IOException iOException2 = this.f63825h;
            if (iOException2 == null) {
                ByteBuffer byteBuffer = this.f63824g;
                if (byteBuffer != null) {
                    byteBuffer.flip();
                    return;
                }
                return;
            }
            throw iOException2;
        }
    }

    public final boolean o() {
        ByteBuffer byteBuffer = this.f63824g;
        return byteBuffer != null && byteBuffer.hasRemaining();
    }

    public void p(IOException iOException) {
        this.f63825h = iOException;
        this.f63823f = true;
        this.f63824g = null;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        n();
        if (o()) {
            return this.f63824g.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i2 < 0 || i3 < 0 || i2 + i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 == 0) {
            return 0;
        }
        n();
        if (o()) {
            int min = Math.min(this.f63824g.limit() - this.f63824g.position(), i3);
            this.f63824g.get(bArr, i2, min);
            return min;
        }
        return -1;
    }
}
