package org.msgpack.unpacker;

import java.math.BigInteger;
/* loaded from: classes.dex */
final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    BigInteger f2955a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        super("integer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(byte b) {
        this.f2955a = BigInteger.valueOf(b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(short s) {
        this.f2955a = BigInteger.valueOf(s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(int i) {
        this.f2955a = BigInteger.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(long j) {
        this.f2955a = BigInteger.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(byte b) {
        BigInteger.valueOf(b & 255);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(short s) {
        BigInteger.valueOf(65535 & s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(int i) {
        if (i < 0) {
            this.f2955a = BigInteger.valueOf((Integer.MAX_VALUE & i) + 2147483648L);
        } else {
            this.f2955a = BigInteger.valueOf(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void b(long j) {
        if (j < 0) {
            this.f2955a = BigInteger.valueOf(Long.MAX_VALUE + j + 1).setBit(63);
        } else {
            this.f2955a = BigInteger.valueOf(j);
        }
    }
}
