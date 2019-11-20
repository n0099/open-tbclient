package com.xiaomi.push;
/* loaded from: classes3.dex */
public class jk extends jm {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private iu f795a;

    public jk(int i) {
        this.f795a = new iu(i);
    }

    @Override // com.xiaomi.push.jm
    public int a(byte[] bArr, int i, int i2) {
        byte[] m447a = this.f795a.m447a();
        if (i2 > this.f795a.a() - this.a) {
            i2 = this.f795a.a() - this.a;
        }
        if (i2 > 0) {
            System.arraycopy(m447a, this.a, bArr, i, i2);
            this.a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.jm
    public void a(byte[] bArr, int i, int i2) {
        this.f795a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f795a.size();
    }
}
