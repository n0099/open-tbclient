package com.xiaomi.push;
/* loaded from: classes10.dex */
public class jl extends jn {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public iv f818a;

    public jl(int i) {
        this.f818a = new iv(i);
    }

    @Override // com.xiaomi.push.jn
    public int a(byte[] bArr, int i, int i2) {
        byte[] m698a = this.f818a.m698a();
        if (i2 > this.f818a.a() - this.a) {
            i2 = this.f818a.a() - this.a;
        }
        if (i2 > 0) {
            System.arraycopy(m698a, this.a, bArr, i, i2);
            this.a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.jn
    /* renamed from: a */
    public void mo724a(byte[] bArr, int i, int i2) {
        this.f818a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f818a.size();
    }
}
