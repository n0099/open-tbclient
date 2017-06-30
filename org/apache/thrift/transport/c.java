package org.apache.thrift.transport;
/* loaded from: classes2.dex */
public final class c extends d {
    private byte[] a;
    private int b;
    private int c;

    @Override // org.apache.thrift.transport.d
    public int a(byte[] bArr, int i, int i2) {
        int c = c();
        if (i2 > c) {
            i2 = c;
        }
        if (i2 > 0) {
            System.arraycopy(this.a, this.b, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // org.apache.thrift.transport.d
    public void a(int i) {
        this.b += i;
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // org.apache.thrift.transport.d
    public byte[] a() {
        return this.a;
    }

    @Override // org.apache.thrift.transport.d
    public int b() {
        return this.b;
    }

    @Override // org.apache.thrift.transport.d
    public void b(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // org.apache.thrift.transport.d
    public int c() {
        return this.c - this.b;
    }

    public void c(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i + i2;
    }
}
