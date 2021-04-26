package d.a.c.e.r;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public final int f40004e;

    /* renamed from: f  reason: collision with root package name */
    public final int f40005f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f40006g;

    public a(int i2, int i3) {
        this.f40004e = i2;
        this.f40005f = i3;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2);
        this.f40006g = allocateDirect;
        allocateDirect.clear();
    }

    public Buffer n() {
        return this.f40006g.clear();
    }

    public synchronized void o() throws IOException {
        write(13);
        write(10);
    }

    public synchronized void p(int i2) {
        if (i2 > this.f40006g.capacity()) {
            ByteBuffer byteBuffer = this.f40006g;
            int position = this.f40006g.position();
            this.f40006g = ByteBuffer.allocateDirect(((i2 / this.f40005f) + 1) * this.f40005f);
            byteBuffer.clear();
            this.f40006g.clear();
            this.f40006g.put(byteBuffer);
            this.f40006g.position(position);
        }
    }

    public Buffer q() {
        return this.f40006g.flip();
    }

    public ByteBuffer r() {
        return this.f40006g;
    }

    public int s() {
        return this.f40006g.remaining();
    }

    public synchronized void t(String str) throws IOException {
        write(str.getBytes("UTF-8"));
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i2) throws IOException {
        if (this.f40006g.position() + 1 > this.f40006g.capacity()) {
            p(this.f40006g.capacity() + 1);
        }
        this.f40006g.put((byte) i2);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f40006g.position() + i3 > this.f40006g.capacity()) {
            p(this.f40006g.capacity() + i3);
        }
        this.f40006g.put(bArr, i2, i3);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
