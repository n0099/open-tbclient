package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f68308a;

    /* renamed from: b  reason: collision with root package name */
    public int f68309b;

    /* renamed from: c  reason: collision with root package name */
    public int f68310c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68311d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68312e;

    /* renamed from: f  reason: collision with root package name */
    public j f68313f;

    /* renamed from: g  reason: collision with root package name */
    public j f68314g;

    public j() {
        this.f68308a = new byte[2048];
        this.f68312e = true;
        this.f68311d = false;
    }

    public j(j jVar) {
        this(jVar.f68308a, jVar.f68309b, jVar.f68310c);
        jVar.f68311d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f68308a = bArr;
        this.f68309b = i2;
        this.f68310c = i3;
        this.f68312e = false;
        this.f68311d = true;
    }

    public j a() {
        j jVar = this.f68313f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f68314g;
        jVar2.f68313f = this.f68313f;
        this.f68313f.f68314g = jVar2;
        this.f68313f = null;
        this.f68314g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f68310c - this.f68309b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f68310c = jVar.f68309b + i2;
        this.f68309b += i2;
        this.f68314g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f68314g = this;
        jVar.f68313f = this.f68313f;
        this.f68313f.f68314g = jVar;
        this.f68313f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f68312e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f68310c;
        if (i3 + i2 > 2048) {
            if (jVar.f68311d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f68309b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f68308a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f68310c -= jVar.f68309b;
            jVar.f68309b = 0;
        }
        System.arraycopy(this.f68308a, this.f68309b, jVar.f68308a, jVar.f68310c, i2);
        jVar.f68310c += i2;
        this.f68309b += i2;
    }

    public void b() {
        j jVar = this.f68314g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f68312e) {
            int i2 = this.f68310c - this.f68309b;
            if (i2 > (2048 - jVar.f68310c) + (jVar.f68311d ? 0 : jVar.f68309b)) {
                return;
            }
            a(this.f68314g, i2);
            a();
            k.a(this);
        }
    }
}
