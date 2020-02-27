package com.xiaomi.push;
/* loaded from: classes8.dex */
public class jk extends jm {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private iu f796a;

    public jk(int i) {
        this.f796a = new iu(i);
    }

    @Override // com.xiaomi.push.jm
    public int a(byte[] bArr, int i, int i2) {
        byte[] m464a = this.f796a.m464a();
        if (i2 > this.f796a.a() - this.a) {
            i2 = this.f796a.a() - this.a;
        }
        if (i2 > 0) {
            System.arraycopy(m464a, this.a, bArr, i, i2);
            this.a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.jm
    public void a(byte[] bArr, int i, int i2) {
        this.f796a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f796a.size();
    }
}
