package d.b.c.b.d;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes6.dex */
public class e extends ByteArrayOutputStream {

    /* renamed from: e  reason: collision with root package name */
    public final d f65752e;

    public e(d dVar, int i2) {
        this.f65752e = dVar;
        ((ByteArrayOutputStream) this).buf = dVar.c(Math.max(i2, 256));
    }

    public final void c(int i2) {
        int i3 = ((ByteArrayOutputStream) this).count;
        if (i3 + i2 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] c2 = this.f65752e.c((i3 + i2) * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, c2, 0, ((ByteArrayOutputStream) this).count);
        this.f65752e.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = c2;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f65752e.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.f65752e.b(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) {
        c(i3);
        super.write(bArr, i2, i3);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i2) {
        c(1);
        super.write(i2);
    }
}
