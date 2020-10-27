package com.xiaomi.push;
/* loaded from: classes12.dex */
public class jq extends js {

    /* renamed from: a  reason: collision with root package name */
    private int f5007a;

    /* renamed from: a  reason: collision with other field name */
    private ja f781a;

    public jq(int i) {
        this.f781a = new ja(i);
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        byte[] m481a = this.f781a.m481a();
        if (i2 > this.f781a.a() - this.f5007a) {
            i2 = this.f781a.a() - this.f5007a;
        }
        if (i2 > 0) {
            System.arraycopy(m481a, this.f5007a, bArr, i, i2);
            this.f5007a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.js
    public void a(byte[] bArr, int i, int i2) {
        this.f781a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f781a.size();
    }
}
