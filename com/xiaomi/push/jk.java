package com.xiaomi.push;
/* loaded from: classes7.dex */
public final class jk extends jl {

    /* renamed from: a  reason: collision with root package name */
    public int f41175a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f815a;

    /* renamed from: b  reason: collision with root package name */
    public int f41176b;

    @Override // com.xiaomi.push.jl
    public int a() {
        return this.f41175a;
    }

    @Override // com.xiaomi.push.jl
    public int a(byte[] bArr, int i, int i2) {
        int b2 = b();
        if (i2 > b2) {
            i2 = b2;
        }
        if (i2 > 0) {
            System.arraycopy(this.f815a, this.f41175a, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.xiaomi.push.jl
    public void a(int i) {
        this.f41175a += i;
    }

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.jl
    public void a(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.jl
    public byte[] a() {
        return this.f815a;
    }

    @Override // com.xiaomi.push.jl
    public int b() {
        return this.f41176b - this.f41175a;
    }

    @Override // com.xiaomi.push.jl
    public void b(byte[] bArr, int i, int i2) {
        this.f815a = bArr;
        this.f41175a = i;
        this.f41176b = i + i2;
    }
}
