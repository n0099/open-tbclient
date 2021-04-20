package d.c.c.b.d;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes5.dex */
public class e extends ByteArrayOutputStream {

    /* renamed from: e  reason: collision with root package name */
    public final d f66530e;

    public e(d dVar, int i) {
        this.f66530e = dVar;
        ((ByteArrayOutputStream) this).buf = dVar.c(Math.max(i, 256));
    }

    public final void c(int i) {
        int i2 = ((ByteArrayOutputStream) this).count;
        if (i2 + i <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] c2 = this.f66530e.c((i2 + i) * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, c2, 0, ((ByteArrayOutputStream) this).count);
        this.f66530e.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = c2;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f66530e.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.f66530e.b(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        c(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        c(1);
        super.write(i);
    }
}
