package com.xiaomi.push;
/* loaded from: classes8.dex */
public class jq extends js {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private ja f788a;

    public jq(int i) {
        this.f788a = new ja(i);
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        byte[] m475a = this.f788a.m475a();
        if (i2 > this.f788a.a() - this.a) {
            i2 = this.f788a.a() - this.a;
        }
        if (i2 > 0) {
            System.arraycopy(m475a, this.a, bArr, i, i2);
            this.a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.js
    public void a(byte[] bArr, int i, int i2) {
        this.f788a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f788a.size();
    }
}
