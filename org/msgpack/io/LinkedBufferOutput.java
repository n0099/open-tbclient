package org.msgpack.io;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class LinkedBufferOutput extends c {
    private LinkedList<f> e;
    private int f;

    @Override // org.msgpack.io.c, org.msgpack.io.g
    public /* bridge */ /* synthetic */ void a(byte b) {
        super.a(b);
    }

    @Override // org.msgpack.io.c, org.msgpack.io.g
    public /* bridge */ /* synthetic */ void a(byte b, byte b2) {
        super.a(b, b2);
    }

    @Override // org.msgpack.io.c, org.msgpack.io.g
    public /* bridge */ /* synthetic */ void a(byte b, double d) {
        super.a(b, d);
    }

    @Override // org.msgpack.io.c, org.msgpack.io.g
    public /* bridge */ /* synthetic */ void a(byte b, float f) {
        super.a(b, f);
    }

    @Override // org.msgpack.io.c, org.msgpack.io.g
    public /* bridge */ /* synthetic */ void a(byte b, int i) {
        super.a(b, i);
    }

    @Override // org.msgpack.io.c, org.msgpack.io.g
    public /* bridge */ /* synthetic */ void a(byte b, long j) {
        super.a(b, j);
    }

    @Override // org.msgpack.io.c, org.msgpack.io.g
    public /* bridge */ /* synthetic */ void a(byte b, short s) {
        super.a(b, s);
    }

    @Override // org.msgpack.io.c, org.msgpack.io.g
    public /* bridge */ /* synthetic */ void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
    }

    @Override // org.msgpack.io.c, org.msgpack.io.g
    public /* bridge */ /* synthetic */ void a(byte[] bArr, int i, int i2) {
        super.a(bArr, i, i2);
    }

    @Override // org.msgpack.io.c, java.io.Flushable
    public /* bridge */ /* synthetic */ void flush() {
        super.flush();
    }

    public LinkedBufferOutput(int i) {
        super(i);
        this.e = new LinkedList<>();
    }

    public byte[] a() {
        byte[] bArr = new byte[this.f + this.b];
        Iterator<f> it = this.e.iterator();
        int i = 0;
        while (it.hasNext()) {
            f next = it.next();
            System.arraycopy(next.f3061a, next.b, bArr, i, next.c);
            i = next.c + i;
        }
        if (this.b > 0) {
            System.arraycopy(this.f3060a, 0, bArr, i, this.b);
        }
        return bArr;
    }

    @Override // org.msgpack.io.c
    protected boolean b(byte[] bArr, int i, int i2) {
        this.e.add(new f(bArr, i, i2));
        this.f += i2;
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
