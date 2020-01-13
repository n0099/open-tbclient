package com.xiaomi.push;
/* loaded from: classes6.dex */
public class jk extends jm {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private iu f798a;

    public jk(int i) {
        this.f798a = new iu(i);
    }

    @Override // com.xiaomi.push.jm
    public int a(byte[] bArr, int i, int i2) {
        byte[] m459a = this.f798a.m459a();
        if (i2 > this.f798a.a() - this.a) {
            i2 = this.f798a.a() - this.a;
        }
        if (i2 > 0) {
            System.arraycopy(m459a, this.a, bArr, i, i2);
            this.a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.jm
    public void a(byte[] bArr, int i, int i2) {
        this.f798a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f798a.size();
    }
}
