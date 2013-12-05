package org.msgpack.io;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class ByteBufferOutput implements g {

    /* renamed from: a  reason: collision with root package name */
    private ByteBuffer f3055a;
    private d b;

    private void a(int i) {
        if (i > this.f3055a.remaining()) {
            if (this.b == null) {
                throw new BufferOverflowException();
            }
            this.f3055a = this.b.a(this.f3055a, i);
        }
    }

    @Override // org.msgpack.io.g
    public void a(byte[] bArr, int i, int i2) {
        a(i2);
        this.f3055a.put(bArr, i, i2);
    }

    @Override // org.msgpack.io.g
    public void a(ByteBuffer byteBuffer) {
        a(byteBuffer.remaining());
        this.f3055a.put(byteBuffer);
    }

    @Override // org.msgpack.io.g
    public void a(byte b) {
        a(1);
        this.f3055a.put(b);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, byte b2) {
        a(2);
        this.f3055a.put(b);
        this.f3055a.put(b2);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, short s) {
        a(3);
        this.f3055a.put(b);
        this.f3055a.putShort(s);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, int i) {
        a(5);
        this.f3055a.put(b);
        this.f3055a.putInt(i);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, long j) {
        a(9);
        this.f3055a.put(b);
        this.f3055a.putLong(j);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, float f) {
        a(5);
        this.f3055a.put(b);
        this.f3055a.putFloat(f);
    }

    @Override // org.msgpack.io.g
    public void a(byte b, double d) {
        a(9);
        this.f3055a.put(b);
        this.f3055a.putDouble(d);
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
