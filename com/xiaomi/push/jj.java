package com.xiaomi.push;
/* loaded from: classes7.dex */
public class jj extends jl {

    /* renamed from: a  reason: collision with root package name */
    public int f38058a;

    /* renamed from: a  reason: collision with other field name */
    public it f814a;

    public jj(int i2) {
        this.f814a = new it(i2);
    }

    @Override // com.xiaomi.push.jl
    public int a(byte[] bArr, int i2, int i3) {
        byte[] m503a = this.f814a.m503a();
        if (i3 > this.f814a.a() - this.f38058a) {
            i3 = this.f814a.a() - this.f38058a;
        }
        if (i3 > 0) {
            System.arraycopy(m503a, this.f38058a, bArr, i2, i3);
            this.f38058a += i3;
        }
        return i3;
    }

    @Override // com.xiaomi.push.jl
    public void a(byte[] bArr, int i2, int i3) {
        this.f814a.write(bArr, i2, i3);
    }

    public int a_() {
        return this.f814a.size();
    }
}
