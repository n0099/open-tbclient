package com.xiaomi.push;
/* loaded from: classes6.dex */
public class jq extends js {

    /* renamed from: a  reason: collision with root package name */
    private int f14482a;

    /* renamed from: a  reason: collision with other field name */
    private ja f863a;

    public jq(int i) {
        this.f863a = new ja(i);
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        byte[] m511a = this.f863a.m511a();
        if (i2 > this.f863a.a() - this.f14482a) {
            i2 = this.f863a.a() - this.f14482a;
        }
        if (i2 > 0) {
            System.arraycopy(m511a, this.f14482a, bArr, i, i2);
            this.f14482a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.js
    public void a(byte[] bArr, int i, int i2) {
        this.f863a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f863a.size();
    }
}
