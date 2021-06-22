package d.a.c.e.r;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public final int f42669e;

    /* renamed from: f  reason: collision with root package name */
    public final int f42670f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f42671g;

    public a(int i2, int i3) {
        this.f42669e = i2;
        this.f42670f = i3;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        this.f42671g = allocateDirect;
        allocateDirect.clear();
    }

    public Buffer n() {
        return this.f42671g.clear();
    }

    public synchronized void o() throws IOException {
        write(13);
        write(10);
    }

    public synchronized void p(int i2) {
        if (i2 > this.f42671g.capacity()) {
            ByteBuffer byteBuffer = this.f42671g;
            int position = this.f42671g.position();
            this.f42671g = ByteBuffer.allocateDirect(((i2 / this.f42670f) + 1) * this.f42670f);
            byteBuffer.clear();
            this.f42671g.clear();
            this.f42671g.put(byteBuffer);
            this.f42671g.position(position);
        }
    }

    public Buffer q() {
        return this.f42671g.flip();
    }

    public ByteBuffer r() {
        return this.f42671g;
    }

    public int s() {
        return this.f42671g.remaining();
    }

    public synchronized void t(String str) throws IOException {
        write(str.getBytes("UTF-8"));
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i2) throws IOException {
        if (this.f42671g.position() + 1 > this.f42671g.capacity()) {
            p(this.f42671g.capacity() + 1);
        }
        this.f42671g.put((byte) i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f42671g.position() + i3 > this.f42671g.capacity()) {
            p(this.f42671g.capacity() + i3);
        }
        this.f42671g.put(bArr, i2, i3);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
