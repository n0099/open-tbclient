package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f34713a;

    /* renamed from: b  reason: collision with root package name */
    public int f34714b;

    /* renamed from: c  reason: collision with root package name */
    public int f34715c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34716d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34717e;

    /* renamed from: f  reason: collision with root package name */
    public j f34718f;

    /* renamed from: g  reason: collision with root package name */
    public j f34719g;

    public j() {
        this.f34713a = new byte[2048];
        this.f34717e = true;
        this.f34716d = false;
    }

    public j(j jVar) {
        this(jVar.f34713a, jVar.f34714b, jVar.f34715c);
        jVar.f34716d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f34713a = bArr;
        this.f34714b = i2;
        this.f34715c = i3;
        this.f34717e = false;
        this.f34716d = true;
    }

    public j a() {
        j jVar = this.f34718f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f34719g;
        jVar2.f34718f = this.f34718f;
        this.f34718f.f34719g = jVar2;
        this.f34718f = null;
        this.f34719g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f34715c - this.f34714b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f34715c = jVar.f34714b + i2;
        this.f34714b += i2;
        this.f34719g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f34719g = this;
        jVar.f34718f = this.f34718f;
        this.f34718f.f34719g = jVar;
        this.f34718f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f34717e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f34715c;
        if (i3 + i2 > 2048) {
            if (jVar.f34716d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f34714b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f34713a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f34715c -= jVar.f34714b;
            jVar.f34714b = 0;
        }
        System.arraycopy(this.f34713a, this.f34714b, jVar.f34713a, jVar.f34715c, i2);
        jVar.f34715c += i2;
        this.f34714b += i2;
    }

    public void b() {
        j jVar = this.f34719g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f34717e) {
            int i2 = this.f34715c - this.f34714b;
            if (i2 > (2048 - jVar.f34715c) + (jVar.f34716d ? 0 : jVar.f34714b)) {
                return;
            }
            a(this.f34719g, i2);
            a();
            k.a(this);
        }
    }
}
