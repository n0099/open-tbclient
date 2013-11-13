package org.msgpack.io;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class StreamInput extends a {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f2892a;
    private byte[] b;
    private ByteBuffer c;
    private int d;

    @Override // org.msgpack.io.e
    public int a(byte[] bArr, int i, int i2) {
        int i3 = i2;
        while (i3 > 0) {
            int read = this.f2892a.read(bArr, i, i3);
            if (read <= 0) {
                throw new EOFException();
            }
            a(read);
            i3 -= read;
            i += read;
        }
        return i2;
    }

    @Override // org.msgpack.io.e
    public boolean a(b bVar, int i) {
        return false;
    }

    @Override // org.msgpack.io.e
    public byte b() {
        int read = this.f2892a.read();
        if (read < 0) {
            throw new EOFException();
        }
        a();
        return (byte) read;
    }

    @Override // org.msgpack.io.e
    public void c() {
        a(this.d);
        this.d = 0;
    }

    private void b(int i) {
        while (this.d < i) {
            int read = this.f2892a.read(this.b, this.d, i - this.d);
            if (read < 0) {
                throw new EOFException();
            }
            this.d = read + this.d;
        }
    }

    @Override // org.msgpack.io.e
    public byte d() {
        b(1);
        return this.b[0];
    }

    @Override // org.msgpack.io.e
    public short e() {
        b(2);
        return this.c.getShort(0);
    }

    @Override // org.msgpack.io.e
    public int f() {
        b(4);
        return this.c.getInt(0);
    }

    @Override // org.msgpack.io.e
    public long g() {
        b(8);
        return this.c.getLong(0);
    }

    @Override // org.msgpack.io.e
    public float h() {
        b(4);
        return this.c.getFloat(0);
    }

    @Override // org.msgpack.io.e
    public double i() {
        b(8);
        return this.c.getDouble(0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2892a.close();
    }
}
