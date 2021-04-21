package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f37988a;

    /* renamed from: b  reason: collision with root package name */
    public int f37989b;

    /* renamed from: c  reason: collision with root package name */
    public int f37990c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37991d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37992e;

    /* renamed from: f  reason: collision with root package name */
    public j f37993f;

    /* renamed from: g  reason: collision with root package name */
    public j f37994g;

    public j() {
        this.f37988a = new byte[2048];
        this.f37992e = true;
        this.f37991d = false;
    }

    public j(j jVar) {
        this(jVar.f37988a, jVar.f37989b, jVar.f37990c);
        jVar.f37991d = true;
    }

    public j(byte[] bArr, int i, int i2) {
        this.f37988a = bArr;
        this.f37989b = i;
        this.f37990c = i2;
        this.f37992e = false;
        this.f37991d = true;
    }

    public j a() {
        j jVar = this.f37993f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f37994g;
        jVar2.f37993f = this.f37993f;
        this.f37993f.f37994g = jVar2;
        this.f37993f = null;
        this.f37994g = null;
        return jVar;
    }

    public j a(int i) {
        if (i <= 0 || i > this.f37990c - this.f37989b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f37990c = jVar.f37989b + i;
        this.f37989b += i;
        this.f37994g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f37994g = this;
        jVar.f37993f = this.f37993f;
        this.f37993f.f37994g = jVar;
        this.f37993f = jVar;
        return jVar;
    }

    public void a(j jVar, int i) {
        if (!jVar.f37992e) {
            throw new IllegalArgumentException();
        }
        int i2 = jVar.f37990c;
        if (i2 + i > 2048) {
            if (jVar.f37991d) {
                throw new IllegalArgumentException();
            }
            int i3 = jVar.f37989b;
            if ((i2 + i) - i3 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f37988a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            jVar.f37990c -= jVar.f37989b;
            jVar.f37989b = 0;
        }
        System.arraycopy(this.f37988a, this.f37989b, jVar.f37988a, jVar.f37990c, i);
        jVar.f37990c += i;
        this.f37989b += i;
    }

    public void b() {
        j jVar = this.f37994g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f37992e) {
            int i = this.f37990c - this.f37989b;
            if (i > (2048 - jVar.f37990c) + (jVar.f37991d ? 0 : jVar.f37989b)) {
                return;
            }
            a(this.f37994g, i);
            a();
            k.a(this);
        }
    }
}
