package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f67396a;

    /* renamed from: b  reason: collision with root package name */
    public int f67397b;

    /* renamed from: c  reason: collision with root package name */
    public int f67398c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67399d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67400e;

    /* renamed from: f  reason: collision with root package name */
    public j f67401f;

    /* renamed from: g  reason: collision with root package name */
    public j f67402g;

    public j() {
        this.f67396a = new byte[2048];
        this.f67400e = true;
        this.f67399d = false;
    }

    public j(j jVar) {
        this(jVar.f67396a, jVar.f67397b, jVar.f67398c);
        jVar.f67399d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f67396a = bArr;
        this.f67397b = i2;
        this.f67398c = i3;
        this.f67400e = false;
        this.f67399d = true;
    }

    public j a() {
        j jVar = this.f67401f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f67402g;
        jVar2.f67401f = this.f67401f;
        this.f67401f.f67402g = jVar2;
        this.f67401f = null;
        this.f67402g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f67398c - this.f67397b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f67398c = jVar.f67397b + i2;
        this.f67397b += i2;
        this.f67402g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f67402g = this;
        jVar.f67401f = this.f67401f;
        this.f67401f.f67402g = jVar;
        this.f67401f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f67400e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f67398c;
        if (i3 + i2 > 2048) {
            if (jVar.f67399d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f67397b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f67396a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f67398c -= jVar.f67397b;
            jVar.f67397b = 0;
        }
        System.arraycopy(this.f67396a, this.f67397b, jVar.f67396a, jVar.f67398c, i2);
        jVar.f67398c += i2;
        this.f67397b += i2;
    }

    public void b() {
        j jVar = this.f67402g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f67400e) {
            int i2 = this.f67398c - this.f67397b;
            if (i2 > (2048 - jVar.f67398c) + (jVar.f67399d ? 0 : jVar.f67397b)) {
                return;
            }
            a(this.f67402g, i2);
            a();
            k.a(this);
        }
    }
}
