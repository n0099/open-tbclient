package com.xiaomi.push;
/* loaded from: classes5.dex */
public class jk extends jm {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private iu f800a;

    public jk(int i) {
        this.f800a = new iu(i);
    }

    @Override // com.xiaomi.push.jm
    public int a(byte[] bArr, int i, int i2) {
        byte[] m450a = this.f800a.m450a();
        if (i2 > this.f800a.a() - this.a) {
            i2 = this.f800a.a() - this.a;
        }
        if (i2 > 0) {
            System.arraycopy(m450a, this.a, bArr, i, i2);
            this.a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.jm
    public void a(byte[] bArr, int i, int i2) {
        this.f800a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f800a.size();
    }
}
