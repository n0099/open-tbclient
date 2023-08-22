package com.xiaomi.push;
/* loaded from: classes10.dex */
public class jl extends jn {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public iv f819a;

    public jl(int i) {
        this.f819a = new iv(i);
    }

    @Override // com.xiaomi.push.jn
    public int a(byte[] bArr, int i, int i2) {
        byte[] m692a = this.f819a.m692a();
        if (i2 > this.f819a.a() - this.a) {
            i2 = this.f819a.a() - this.a;
        }
        if (i2 > 0) {
            System.arraycopy(m692a, this.a, bArr, i, i2);
            this.a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.jn
    /* renamed from: a */
    public void mo718a(byte[] bArr, int i, int i2) {
        this.f819a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f819a.size();
    }
}
