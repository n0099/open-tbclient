package com.xiaomi.push;
/* loaded from: classes12.dex */
public class jq extends js {

    /* renamed from: a  reason: collision with root package name */
    private int f5009a;

    /* renamed from: a  reason: collision with other field name */
    private ja f784a;

    public jq(int i) {
        this.f784a = new ja(i);
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        byte[] m482a = this.f784a.m482a();
        if (i2 > this.f784a.a() - this.f5009a) {
            i2 = this.f784a.a() - this.f5009a;
        }
        if (i2 > 0) {
            System.arraycopy(m482a, this.f5009a, bArr, i, i2);
            this.f5009a += i2;
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
