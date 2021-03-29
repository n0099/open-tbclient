package com.xiaomi.push;
/* loaded from: classes7.dex */
public class jj extends jl {

    /* renamed from: a  reason: collision with root package name */
    public int f40885a;

    /* renamed from: a  reason: collision with other field name */
    public it f814a;

    public jj(int i) {
        this.f814a = new it(i);
    }

    @Override // com.xiaomi.push.jl
    public int a(byte[] bArr, int i, int i2) {
        byte[] m497a = this.f814a.m497a();
        if (i2 > this.f814a.a() - this.f40885a) {
            i2 = this.f814a.a() - this.f40885a;
        }
        if (i2 > 0) {
            System.arraycopy(m497a, this.f40885a, bArr, i, i2);
            this.f40885a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.jl
    public void a(byte[] bArr, int i, int i2) {
        this.f814a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f814a.size();
    }
}
