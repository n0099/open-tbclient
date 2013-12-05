package org.msgpack.unpacker;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
final class d extends a {

    /* renamed from: a  reason: collision with root package name */
    byte[] f3137a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        super("raw value");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(byte[] bArr) {
        this.f3137a = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a() {
        this.f3137a = new byte[0];
    }

    @Override // org.msgpack.unpacker.a, org.msgpack.io.b
    public void a(ByteBuffer byteBuffer, boolean z) {
        this.f3137a = new byte[byteBuffer.remaining()];
        byteBuffer.get(this.f3137a);
    }
}
