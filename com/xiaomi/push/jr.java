package com.xiaomi.push;
/* loaded from: classes6.dex */
public final class jr extends js {

    /* renamed from: a  reason: collision with root package name */
    private int f14183a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f863a;

    /* renamed from: b  reason: collision with root package name */
    private int f14184b;

    @Override // com.xiaomi.push.js
    public int a() {
        return this.f14183a;
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        int b2 = b();
        if (i2 > b2) {
            i2 = b2;
        }
        if (i2 > 0) {
            System.arraycopy(this.f863a, this.f14183a, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.xiaomi.push.js
    public void a(int i) {
        this.f14183a += i;
    }

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.js
    public void a(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.js
    public byte[] a() {
        return this.f863a;
    }

    @Override // com.xiaomi.push.js
    public int b() {
        return this.f14184b - this.f14183a;
    }

    @Override // com.xiaomi.push.js
    public void b(byte[] bArr, int i, int i2) {
        this.f863a = bArr;
        this.f14183a = i;
        this.f14184b = i + i2;
    }
}
