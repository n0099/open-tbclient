package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes7.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f40253a;

    /* renamed from: b  reason: collision with root package name */
    public int f40254b;

    /* renamed from: c  reason: collision with root package name */
    public int f40255c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40256d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40257e;

    /* renamed from: f  reason: collision with root package name */
    public j f40258f;

    /* renamed from: g  reason: collision with root package name */
    public j f40259g;

    public j() {
        this.f40253a = new byte[2048];
        this.f40257e = true;
        this.f40256d = false;
    }

    public j(j jVar) {
        this(jVar.f40253a, jVar.f40254b, jVar.f40255c);
        jVar.f40256d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f40253a = bArr;
        this.f40254b = i2;
        this.f40255c = i3;
        this.f40257e = false;
        this.f40256d = true;
    }

    public j a() {
        j jVar = this.f40258f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f40259g;
        jVar2.f40258f = this.f40258f;
        this.f40258f.f40259g = jVar2;
        this.f40258f = null;
        this.f40259g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f40255c - this.f40254b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f40255c = jVar.f40254b + i2;
        this.f40254b += i2;
        this.f40259g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f40259g = this;
        jVar.f40258f = this.f40258f;
        this.f40258f.f40259g = jVar;
        this.f40258f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f40257e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f40255c;
        if (i3 + i2 > 2048) {
            if (jVar.f40256d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f40254b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f40253a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f40255c -= jVar.f40254b;
            jVar.f40254b = 0;
        }
        System.arraycopy(this.f40253a, this.f40254b, jVar.f40253a, jVar.f40255c, i2);
        jVar.f40255c += i2;
        this.f40254b += i2;
    }

    public void b() {
        j jVar = this.f40259g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f40257e) {
            int i2 = this.f40255c - this.f40254b;
            if (i2 > (2048 - jVar.f40255c) + (jVar.f40256d ? 0 : jVar.f40254b)) {
                return;
            }
            a(this.f40259g, i2);
            a();
            k.a(this);
        }
    }
}
