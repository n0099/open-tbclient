package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes2.dex */
public final class j {
    public final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f60339b;

    /* renamed from: c  reason: collision with root package name */
    public int f60340c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60341d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60342e;

    /* renamed from: f  reason: collision with root package name */
    public j f60343f;

    /* renamed from: g  reason: collision with root package name */
    public j f60344g;

    public j() {
        this.a = new byte[2048];
        this.f60342e = true;
        this.f60341d = false;
    }

    public j(j jVar) {
        this(jVar.a, jVar.f60339b, jVar.f60340c);
        jVar.f60341d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.f60339b = i2;
        this.f60340c = i3;
        this.f60342e = false;
        this.f60341d = true;
    }

    public j a() {
        j jVar = this.f60343f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f60344g;
        jVar2.f60343f = this.f60343f;
        this.f60343f.f60344g = jVar2;
        this.f60343f = null;
        this.f60344g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f60340c - this.f60339b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f60340c = jVar.f60339b + i2;
        this.f60339b += i2;
        this.f60344g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f60344g = this;
        jVar.f60343f = this.f60343f;
        this.f60343f.f60344g = jVar;
        this.f60343f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f60342e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f60340c;
        if (i3 + i2 > 2048) {
            if (jVar.f60341d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f60339b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f60340c -= jVar.f60339b;
            jVar.f60339b = 0;
        }
        System.arraycopy(this.a, this.f60339b, jVar.a, jVar.f60340c, i2);
        jVar.f60340c += i2;
        this.f60339b += i2;
    }

    public void b() {
        j jVar = this.f60344g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f60342e) {
            int i2 = this.f60340c - this.f60339b;
            if (i2 > (2048 - jVar.f60340c) + (jVar.f60341d ? 0 : jVar.f60339b)) {
                return;
            }
            a(this.f60344g, i2);
            a();
            k.a(this);
        }
    }
}
