package com.xiaomi.push;
/* loaded from: classes6.dex */
public class jq extends js {

    /* renamed from: a  reason: collision with root package name */
    private int f14481a;

    /* renamed from: a  reason: collision with other field name */
    private ja f862a;

    public jq(int i) {
        this.f862a = new ja(i);
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        byte[] m500a = this.f862a.m500a();
        if (i2 > this.f862a.a() - this.f14481a) {
            i2 = this.f862a.a() - this.f14481a;
        }
        if (i2 > 0) {
            System.arraycopy(m500a, this.f14481a, bArr, i, i2);
            this.f14481a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.js
    public void a(byte[] bArr, int i, int i2) {
        this.f862a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f862a.size();
    }
}
