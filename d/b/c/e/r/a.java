package d.b.c.e.r;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public final int f42551e;

    /* renamed from: f  reason: collision with root package name */
    public final int f42552f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f42553g;

    public a(int i, int i2) {
        this.f42551e = i;
        this.f42552f = i2;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        this.f42553g = allocateDirect;
        allocateDirect.clear();
    }

    public Buffer n() {
        return this.f42553g.clear();
    }

    public synchronized void o() throws IOException {
        write(13);
        write(10);
    }

    public synchronized void p(int i) {
        if (i > this.f42553g.capacity()) {
            ByteBuffer byteBuffer = this.f42553g;
            int position = this.f42553g.position();
            this.f42553g = ByteBuffer.allocateDirect(((i / this.f42552f) + 1) * this.f42552f);
            byteBuffer.clear();
            this.f42553g.clear();
            this.f42553g.put(byteBuffer);
            this.f42553g.position(position);
        }
    }

    public Buffer q() {
        return this.f42553g.flip();
    }

    public ByteBuffer r() {
        return this.f42553g;
    }

    public int s() {
        return this.f42553g.remaining();
    }

    public synchronized void t(String str) throws IOException {
        write(str.getBytes("UTF-8"));
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        if (this.f42553g.position() + 1 > this.f42553g.capacity()) {
            p(this.f42553g.capacity() + 1);
        }
        this.f42553g.put((byte) i);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.f42553g.position() + i2 > this.f42553g.capacity()) {
            p(this.f42553g.capacity() + i2);
        }
        this.f42553g.put(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
