package com.xiaomi.push;
/* loaded from: classes7.dex */
public final class jk extends jl {

    /* renamed from: a  reason: collision with root package name */
    public int f41770a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f815a;

    /* renamed from: b  reason: collision with root package name */
    public int f41771b;

    @Override // com.xiaomi.push.jl
    public int a() {
        return this.f41770a;
    }

    @Override // com.xiaomi.push.jl
    public int a(byte[] bArr, int i2, int i3) {
        int b2 = b();
        if (i3 > b2) {
            i3 = b2;
        }
        if (i3 > 0) {
            System.arraycopy(this.f815a, this.f41770a, bArr, i2, i3);
            a(i3);
        }
        return i3;
    }

    @Override // com.xiaomi.push.jl
    public void a(int i2) {
        this.f41770a += i2;
    }

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.jl
    public void a(byte[] bArr, int i2, int i3) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.jl
    public byte[] a() {
        return this.f815a;
    }

    @Override // com.xiaomi.push.jl
    public int b() {
        return this.f41771b - this.f41770a;
    }

    @Override // com.xiaomi.push.jl
    public void b(byte[] bArr, int i2, int i3) {
        this.f815a = bArr;
        this.f41770a = i2;
        this.f41771b = i2 + i3;
    }
}
