package com.xiaomi.push;
/* loaded from: classes8.dex */
public class jq extends js {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private ja f782a;

    public jq(int i) {
        this.f782a = new ja(i);
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        byte[] m477a = this.f782a.m477a();
        if (i2 > this.f782a.a() - this.a) {
            i2 = this.f782a.a() - this.a;
        }
        if (i2 > 0) {
            System.arraycopy(m477a, this.a, bArr, i, i2);
            this.a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.js
    public void a(byte[] bArr, int i, int i2) {
        this.f782a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f782a.size();
    }
}
