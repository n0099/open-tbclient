package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes3.dex */
public final class j {
    public final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f60920b;

    /* renamed from: c  reason: collision with root package name */
    public int f60921c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60922d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60923e;

    /* renamed from: f  reason: collision with root package name */
    public j f60924f;

    /* renamed from: g  reason: collision with root package name */
    public j f60925g;

    public j() {
        this.a = new byte[2048];
        this.f60923e = true;
        this.f60922d = false;
    }

    public j(j jVar) {
        this(jVar.a, jVar.f60920b, jVar.f60921c);
        jVar.f60922d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.f60920b = i2;
        this.f60921c = i3;
        this.f60923e = false;
        this.f60922d = true;
    }

    public j a() {
        j jVar = this.f60924f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f60925g;
        jVar2.f60924f = this.f60924f;
        this.f60924f.f60925g = jVar2;
        this.f60924f = null;
        this.f60925g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f60921c - this.f60920b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f60921c = jVar.f60920b + i2;
        this.f60920b += i2;
        this.f60925g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f60925g = this;
        jVar.f60924f = this.f60924f;
        this.f60924f.f60925g = jVar;
        this.f60924f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f60923e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f60921c;
        if (i3 + i2 > 2048) {
            if (jVar.f60922d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f60920b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f60921c -= jVar.f60920b;
            jVar.f60920b = 0;
        }
        System.arraycopy(this.a, this.f60920b, jVar.a, jVar.f60921c, i2);
        jVar.f60921c += i2;
        this.f60920b += i2;
    }

    public void b() {
        j jVar = this.f60925g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f60923e) {
            int i2 = this.f60921c - this.f60920b;
            if (i2 > (2048 - jVar.f60921c) + (jVar.f60922d ? 0 : jVar.f60920b)) {
                return;
            }
            a(this.f60925g, i2);
            a();
            k.a(this);
        }
    }
}
