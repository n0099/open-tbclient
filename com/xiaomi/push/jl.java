package com.xiaomi.push;
/* loaded from: classes6.dex */
public final class jl extends jm {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f800a;
    private int b;

    @Override // com.xiaomi.push.jm
    public int a() {
        return this.a;
    }

    @Override // com.xiaomi.push.jm
    public int a(byte[] bArr, int i, int i2) {
        int b = b();
        if (i2 > b) {
            i2 = b;
        }
        if (i2 > 0) {
            System.arraycopy(this.f800a, this.a, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.xiaomi.push.jm
    public void a(int i) {
        this.a += i;
    }

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.jm
    public void a(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.jm
    public byte[] a() {
        return this.f800a;
    }

    @Override // com.xiaomi.push.jm
    public int b() {
        return this.b - this.a;
    }

    @Override // com.xiaomi.push.jm
    public void b(byte[] bArr, int i, int i2) {
        this.f800a = bArr;
        this.a = i;
        this.b = i + i2;
    }
}
