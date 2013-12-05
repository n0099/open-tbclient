package org.msgpack.unpacker;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import org.msgpack.packer.Unconverter;
import org.msgpack.type.r;
import org.msgpack.type.s;
/* loaded from: classes.dex */
final class n extends a {

    /* renamed from: a  reason: collision with root package name */
    private Unconverter f3145a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n() {
        super(null);
        this.f3145a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Unconverter unconverter) {
        this.f3145a = unconverter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(boolean z) {
        this.f3145a.a((r) s.a(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(byte b) {
        this.f3145a.a((r) s.a(b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(short s) {
        this.f3145a.a((r) s.a(s));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(int i) {
        this.f3145a.a((r) s.a(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(long j) {
        this.f3145a.a((r) s.a(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(byte b) {
        this.f3145a.a((r) s.a(b & 255));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(short s) {
        this.f3145a.a((r) s.a(65535 & s));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(int i) {
        if (i < 0) {
            this.f3145a.a((r) s.a((Integer.MAX_VALUE & i) + 2147483648L));
        } else {
            this.f3145a.a((r) s.a(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(long j) {
        if (j < 0) {
            this.f3145a.a((r) s.a(BigInteger.valueOf(Long.MAX_VALUE + j + 1).setBit(63)));
            return;
        }
        this.f3145a.a((r) s.a(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(byte[] bArr) {
        this.f3145a.a((r) s.a(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a() {
        this.f3145a.a((r) s.b());
    }

    @Override // org.msgpack.unpacker.a, org.msgpack.io.b
    public void a(ByteBuffer byteBuffer, boolean z) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        this.f3145a.a((r) s.a(bArr, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void c(int i) {
        this.f3145a.c(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void d(int i) {
        this.f3145a.d(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b() {
        this.f3145a.a((r) s.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(float f) {
        this.f3145a.a((r) s.a(f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(double d) {
        this.f3145a.a((r) s.a(d));
    }
}
