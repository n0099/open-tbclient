package com.xiaomi.push;
/* loaded from: classes10.dex */
public final class jm extends jn {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f819a;
    public int b;

    @Override // com.xiaomi.push.jn
    public int a() {
        return this.a;
    }

    @Override // com.xiaomi.push.jn
    public int a(byte[] bArr, int i, int i2) {
        int b = b();
        if (i2 > b) {
            i2 = b;
        }
        if (i2 > 0) {
            System.arraycopy(this.f819a, this.a, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.xiaomi.push.jn
    public void a(int i) {
        this.a += i;
    }

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.jn
    /* renamed from: a */
    public void mo724a(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.jn
    /* renamed from: a  reason: collision with other method in class */
    public byte[] mo725a() {
        return this.f819a;
    }

    @Override // com.xiaomi.push.jn
    public int b() {
        return this.b - this.a;
    }

    public void b(byte[] bArr, int i, int i2) {
        this.f819a = bArr;
        this.a = i;
        this.b = i + i2;
    }
}
