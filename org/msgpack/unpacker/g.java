package org.msgpack.unpacker;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
final class g extends a {

    /* renamed from: a  reason: collision with root package name */
    long f2975a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
        super("integer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(byte b) {
        this.f2975a = b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(short s) {
        this.f2975a = s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(int i) {
        this.f2975a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(long j) {
        this.f2975a = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(byte b) {
        this.f2975a = b & 255;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(short s) {
        this.f2975a = 65535 & s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(int i) {
        if (i < 0) {
            this.f2975a = (Integer.MAX_VALUE & i) + 2147483648L;
        } else {
            this.f2975a = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(long j) {
        if (j < 0) {
            throw new MessageTypeException();
        }
        this.f2975a = j;
    }
}
