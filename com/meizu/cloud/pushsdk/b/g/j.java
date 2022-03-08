package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes8.dex */
public final class j {
    public final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f57175b;

    /* renamed from: c  reason: collision with root package name */
    public int f57176c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57177d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57178e;

    /* renamed from: f  reason: collision with root package name */
    public j f57179f;

    /* renamed from: g  reason: collision with root package name */
    public j f57180g;

    public j() {
        this.a = new byte[2048];
        this.f57178e = true;
        this.f57177d = false;
    }

    public j(j jVar) {
        this(jVar.a, jVar.f57175b, jVar.f57176c);
        jVar.f57177d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.f57175b = i2;
        this.f57176c = i3;
        this.f57178e = false;
        this.f57177d = true;
    }

    public j a() {
        j jVar = this.f57179f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f57180g;
        jVar2.f57179f = this.f57179f;
        this.f57179f.f57180g = jVar2;
        this.f57179f = null;
        this.f57180g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f57176c - this.f57175b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f57176c = jVar.f57175b + i2;
        this.f57175b += i2;
        this.f57180g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f57180g = this;
        jVar.f57179f = this.f57179f;
        this.f57179f.f57180g = jVar;
        this.f57179f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f57178e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f57176c;
        if (i3 + i2 > 2048) {
            if (jVar.f57177d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f57175b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f57176c -= jVar.f57175b;
            jVar.f57175b = 0;
        }
        System.arraycopy(this.a, this.f57175b, jVar.a, jVar.f57176c, i2);
        jVar.f57176c += i2;
        this.f57175b += i2;
    }

    public void b() {
        j jVar = this.f57180g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f57178e) {
            int i2 = this.f57176c - this.f57175b;
            if (i2 > (2048 - jVar.f57176c) + (jVar.f57177d ? 0 : jVar.f57175b)) {
                return;
            }
            a(this.f57180g, i2);
            a();
            k.a(this);
        }
    }
}
