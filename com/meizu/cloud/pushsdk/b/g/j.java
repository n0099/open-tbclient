package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f37456a;

    /* renamed from: b  reason: collision with root package name */
    public int f37457b;

    /* renamed from: c  reason: collision with root package name */
    public int f37458c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37459d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37460e;

    /* renamed from: f  reason: collision with root package name */
    public j f37461f;

    /* renamed from: g  reason: collision with root package name */
    public j f37462g;

    public j() {
        this.f37456a = new byte[2048];
        this.f37460e = true;
        this.f37459d = false;
    }

    public j(j jVar) {
        this(jVar.f37456a, jVar.f37457b, jVar.f37458c);
        jVar.f37459d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f37456a = bArr;
        this.f37457b = i2;
        this.f37458c = i3;
        this.f37460e = false;
        this.f37459d = true;
    }

    public j a() {
        j jVar = this.f37461f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f37462g;
        jVar2.f37461f = this.f37461f;
        this.f37461f.f37462g = jVar2;
        this.f37461f = null;
        this.f37462g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f37458c - this.f37457b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f37458c = jVar.f37457b + i2;
        this.f37457b += i2;
        this.f37462g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f37462g = this;
        jVar.f37461f = this.f37461f;
        this.f37461f.f37462g = jVar;
        this.f37461f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f37460e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f37458c;
        if (i3 + i2 > 2048) {
            if (jVar.f37459d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f37457b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f37456a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f37458c -= jVar.f37457b;
            jVar.f37457b = 0;
        }
        System.arraycopy(this.f37456a, this.f37457b, jVar.f37456a, jVar.f37458c, i2);
        jVar.f37458c += i2;
        this.f37457b += i2;
    }

    public void b() {
        j jVar = this.f37462g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f37460e) {
            int i2 = this.f37458c - this.f37457b;
            if (i2 > (2048 - jVar.f37458c) + (jVar.f37459d ? 0 : jVar.f37457b)) {
                return;
            }
            a(this.f37462g, i2);
            a();
            k.a(this);
        }
    }
}
