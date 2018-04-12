package org.apache.thrift.transport;
/* loaded from: classes3.dex */
public class b extends d {
    private org.apache.thrift.d a;
    private int b;

    public b(int i) {
        this.a = new org.apache.thrift.d(i);
    }

    @Override // org.apache.thrift.transport.d
    public int a(byte[] bArr, int i, int i2) {
        byte[] a = this.a.a();
        if (i2 > this.a.b() - this.b) {
            i2 = this.a.b() - this.b;
        }
        if (i2 > 0) {
            System.arraycopy(a, this.b, bArr, i, i2);
            this.b += i2;
        }
        return i2;
    }

    public int a_() {
        return this.a.size();
    }

    @Override // org.apache.thrift.transport.d
    public void b(byte[] bArr, int i, int i2) {
        this.a.write(bArr, i, i2);
    }
}
