package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes10.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f74678a;

    /* renamed from: b  reason: collision with root package name */
    public int f74679b;

    /* renamed from: c  reason: collision with root package name */
    public int f74680c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f74681d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f74682e;

    /* renamed from: f  reason: collision with root package name */
    public j f74683f;

    /* renamed from: g  reason: collision with root package name */
    public j f74684g;

    public j() {
        this.f74678a = new byte[2048];
        this.f74682e = true;
        this.f74681d = false;
    }

    public j(j jVar) {
        this(jVar.f74678a, jVar.f74679b, jVar.f74680c);
        jVar.f74681d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f74678a = bArr;
        this.f74679b = i2;
        this.f74680c = i3;
        this.f74682e = false;
        this.f74681d = true;
    }

    public j a() {
        j jVar = this.f74683f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f74684g;
        jVar2.f74683f = this.f74683f;
        this.f74683f.f74684g = jVar2;
        this.f74683f = null;
        this.f74684g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f74680c - this.f74679b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f74680c = jVar.f74679b + i2;
        this.f74679b += i2;
        this.f74684g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f74684g = this;
        jVar.f74683f = this.f74683f;
        this.f74683f.f74684g = jVar;
        this.f74683f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f74682e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f74680c;
        if (i3 + i2 > 2048) {
            if (jVar.f74681d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f74679b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f74678a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f74680c -= jVar.f74679b;
            jVar.f74679b = 0;
        }
        System.arraycopy(this.f74678a, this.f74679b, jVar.f74678a, jVar.f74680c, i2);
        jVar.f74680c += i2;
        this.f74679b += i2;
    }

    public void b() {
        j jVar = this.f74684g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f74682e) {
            int i2 = this.f74680c - this.f74679b;
            if (i2 > (2048 - jVar.f74680c) + (jVar.f74681d ? 0 : jVar.f74679b)) {
                return;
            }
            a(this.f74684g, i2);
            a();
            k.a(this);
        }
    }
}
