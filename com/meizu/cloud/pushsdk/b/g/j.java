package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f37267a;

    /* renamed from: b  reason: collision with root package name */
    public int f37268b;

    /* renamed from: c  reason: collision with root package name */
    public int f37269c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37270d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37271e;

    /* renamed from: f  reason: collision with root package name */
    public j f37272f;

    /* renamed from: g  reason: collision with root package name */
    public j f37273g;

    public j() {
        this.f37267a = new byte[2048];
        this.f37271e = true;
        this.f37270d = false;
    }

    public j(j jVar) {
        this(jVar.f37267a, jVar.f37268b, jVar.f37269c);
        jVar.f37270d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f37267a = bArr;
        this.f37268b = i2;
        this.f37269c = i3;
        this.f37271e = false;
        this.f37270d = true;
    }

    public j a() {
        j jVar = this.f37272f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f37273g;
        jVar2.f37272f = this.f37272f;
        this.f37272f.f37273g = jVar2;
        this.f37272f = null;
        this.f37273g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f37269c - this.f37268b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f37269c = jVar.f37268b + i2;
        this.f37268b += i2;
        this.f37273g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f37273g = this;
        jVar.f37272f = this.f37272f;
        this.f37272f.f37273g = jVar;
        this.f37272f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f37271e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f37269c;
        if (i3 + i2 > 2048) {
            if (jVar.f37270d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f37268b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f37267a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f37269c -= jVar.f37268b;
            jVar.f37268b = 0;
        }
        System.arraycopy(this.f37267a, this.f37268b, jVar.f37267a, jVar.f37269c, i2);
        jVar.f37269c += i2;
        this.f37268b += i2;
    }

    public void b() {
        j jVar = this.f37273g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f37271e) {
            int i2 = this.f37269c - this.f37268b;
            if (i2 > (2048 - jVar.f37269c) + (jVar.f37270d ? 0 : jVar.f37268b)) {
                return;
            }
            a(this.f37273g, i2);
            a();
            k.a(this);
        }
    }
}
