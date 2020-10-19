package com.xiaomi.push;
/* loaded from: classes12.dex */
public final class jr extends js {

    /* renamed from: a  reason: collision with root package name */
    private int f5010a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f785a;
    private int b;

    @Override // com.xiaomi.push.js
    public int a() {
        return this.f5010a;
    }

    @Override // com.xiaomi.push.js
    public int a(byte[] bArr, int i, int i2) {
        int b = b();
        if (i2 > b) {
            i2 = b;
        }
        if (i2 > 0) {
            System.arraycopy(this.f785a, this.f5010a, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.xiaomi.push.js
    public void a(int i) {
        this.f5010a += i;
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
        return this.f785a;
    }

    @Override // com.xiaomi.push.js
    public int b() {
        return this.b - this.f5010a;
    }

    @Override // com.xiaomi.push.js
    public void b(byte[] bArr, int i, int i2) {
        this.f785a = bArr;
        this.f5010a = i;
        this.b = i + i2;
    }
}
