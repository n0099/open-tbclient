package org.msgpack.io;

import java.io.DataOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class StreamOutput implements g {

    /* renamed from: a  reason: collision with root package name */
    private DataOutputStream f2893a;

    @Override // org.msgpack.io.g
    public void a(byte[] bArr, int i, int i2) {
        this.f2893a.write(bArr, i, i2);
    }

    @Override // org.msgpack.io.g
    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            this.f2893a.write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
            return;
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        this.f2893a.write(bArr);
    }

    @Override // org.msgpack.io.g
    public void a(byte b) {
        this.f2893a.write(b);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, byte b2) {
        this.f2893a.write(b);
        this.f2893a.write(b2);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, short s) {
        this.f2893a.write(b);
        this.f2893a.writeShort(s);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, int i) {
        this.f2893a.write(b);
        this.f2893a.writeInt(i);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, long j) {
        this.f2893a.write(b);
        this.f2893a.writeLong(j);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, float f) {
        this.f2893a.write(b);
        this.f2893a.writeFloat(f);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, double d) {
        this.f2893a.write(b);
        this.f2893a.writeDouble(d);
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2893a.close();
    }
}
