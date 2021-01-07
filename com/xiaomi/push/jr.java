package com.xiaomi.push;
/* loaded from: classes6.dex */
public final class jr extends js {

    /* renamed from: a  reason: collision with root package name */
    private int f14483a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f864a;

    /* renamed from: b  reason: collision with root package name */
    private int f14484b;

    @Override // com.xiaomi.push.js
    public int a() {
        return this.f14483a;
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        int b2 = b();
        if (i2 > b2) {
            i2 = b2;
        }
        if (i2 > 0) {
            System.arraycopy(this.f864a, this.f14483a, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.xiaomi.push.js
    public void a(int i) {
        this.f14483a += i;
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
        return this.f864a;
    }

    @Override // com.xiaomi.push.js
    public int b() {
        return this.f14484b - this.f14483a;
    }

    @Override // com.xiaomi.push.js
    public void b(byte[] bArr, int i, int i2) {
        this.f864a = bArr;
        this.f14483a = i;
        this.f14484b = i + i2;
    }
}
