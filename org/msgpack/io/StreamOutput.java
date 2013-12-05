package org.msgpack.io;

import java.io.DataOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class StreamOutput implements g {

    /* renamed from: a  reason: collision with root package name */
    private DataOutputStream f3058a;

    @Override // org.msgpack.io.g
    public void a(byte[] bArr, int i, int i2) {
        this.f3058a.write(bArr, i, i2);
    }

    @Override // org.msgpack.io.g
    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            this.f3058a.write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
            return;
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        this.f3058a.write(bArr);
    }

    @Override // org.msgpack.io.g
    public void a(byte b) {
        this.f3058a.write(b);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, byte b2) {
        this.f3058a.write(b);
        this.f3058a.write(b2);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, short s) {
        this.f3058a.write(b);
        this.f3058a.writeShort(s);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, int i) {
        this.f3058a.write(b);
        this.f3058a.writeInt(i);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, long j) {
        this.f3058a.write(b);
        this.f3058a.writeLong(j);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, float f) {
        this.f3058a.write(b);
        this.f3058a.writeFloat(f);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, double d) {
        this.f3058a.write(b);
        this.f3058a.writeDouble(d);
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3058a.close();
    }
}
