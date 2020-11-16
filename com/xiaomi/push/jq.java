package com.xiaomi.push;
/* loaded from: classes18.dex */
public class jq extends js {

    /* renamed from: a  reason: collision with root package name */
    private int f5009a;

    /* renamed from: a  reason: collision with other field name */
    private ja f786a;

    public jq(int i) {
        this.f786a = new ja(i);
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        byte[] m484a = this.f786a.m484a();
        if (i2 > this.f786a.a() - this.f5009a) {
            i2 = this.f786a.a() - this.f5009a;
        }
        if (i2 > 0) {
            System.arraycopy(m484a, this.f5009a, bArr, i, i2);
            this.f5009a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.js
    public void a(byte[] bArr, int i, int i2) {
        this.f786a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f786a.size();
    }
}
