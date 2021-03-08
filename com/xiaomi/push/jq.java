package com.xiaomi.push;
/* loaded from: classes5.dex */
public class jq extends js {

    /* renamed from: a  reason: collision with root package name */
    private int f8472a;

    /* renamed from: a  reason: collision with other field name */
    private ja f783a;

    public jq(int i) {
        this.f783a = new ja(i);
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        byte[] m485a = this.f783a.m485a();
        if (i2 > this.f783a.a() - this.f8472a) {
            i2 = this.f783a.a() - this.f8472a;
        }
        if (i2 > 0) {
            System.arraycopy(m485a, this.f8472a, bArr, i, i2);
            this.f8472a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.js
    public void a(byte[] bArr, int i, int i2) {
        this.f783a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f783a.size();
    }
}
