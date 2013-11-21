package org.msgpack.unpacker;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
final class f extends a {

    /* renamed from: a  reason: collision with root package name */
    int f2958a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f() {
        super("integer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(byte b) {
        this.f2958a = b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(short s) {
        this.f2958a = s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(int i) {
        this.f2958a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(long j) {
        if (j < -2147483648L || j > 2147483647L) {
            throw new MessageTypeException();
        }
        this.f2958a = (int) j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(byte b) {
        this.f2958a = b & 255;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(short s) {
        this.f2958a = 65535 & s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(int i) {
        if (i < 0) {
            throw new MessageTypeException();
        }
        this.f2958a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(long j) {
        if (j < 0 || j > 2147483647L) {
            throw new MessageTypeException();
        }
        this.f2958a = (int) j;
    }
}
