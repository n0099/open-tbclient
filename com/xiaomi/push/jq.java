package com.xiaomi.push;
/* loaded from: classes7.dex */
public class jq extends js {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private ja f784a;

    public jq(int i) {
        this.f784a = new ja(i);
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        byte[] m481a = this.f784a.m481a();
        if (i2 > this.f784a.a() - this.a) {
            i2 = this.f784a.a() - this.a;
        }
        if (i2 > 0) {
            System.arraycopy(m481a, this.a, bArr, i, i2);
            this.a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.js
    public void a(byte[] bArr, int i, int i2) {
        this.f784a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f784a.size();
    }
}
