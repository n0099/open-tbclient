package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes7.dex */
public final class j {
    public final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f42014b;

    /* renamed from: c  reason: collision with root package name */
    public int f42015c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42016d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42017e;

    /* renamed from: f  reason: collision with root package name */
    public j f42018f;

    /* renamed from: g  reason: collision with root package name */
    public j f42019g;

    public j() {
        this.a = new byte[2048];
        this.f42017e = true;
        this.f42016d = false;
    }

    public j(j jVar) {
        this(jVar.a, jVar.f42014b, jVar.f42015c);
        jVar.f42016d = true;
    }

    public j(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.f42014b = i;
        this.f42015c = i2;
        this.f42017e = false;
        this.f42016d = true;
    }

    public j a() {
        j jVar = this.f42018f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f42019g;
        jVar2.f42018f = this.f42018f;
        this.f42018f.f42019g = jVar2;
        this.f42018f = null;
        this.f42019g = null;
        return jVar;
    }

    public j a(int i) {
        if (i <= 0 || i > this.f42015c - this.f42014b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f42015c = jVar.f42014b + i;
        this.f42014b += i;
        this.f42019g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f42019g = this;
        jVar.f42018f = this.f42018f;
        this.f42018f.f42019g = jVar;
        this.f42018f = jVar;
        return jVar;
    }

    public void a(j jVar, int i) {
        if (!jVar.f42017e) {
            throw new IllegalArgumentException();
        }
        int i2 = jVar.f42015c;
        if (i2 + i > 2048) {
            if (jVar.f42016d) {
                throw new IllegalArgumentException();
            }
            int i3 = jVar.f42014b;
            if ((i2 + i) - i3 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            jVar.f42015c -= jVar.f42014b;
            jVar.f42014b = 0;
        }
        System.arraycopy(this.a, this.f42014b, jVar.a, jVar.f42015c, i);
        jVar.f42015c += i;
        this.f42014b += i;
    }

    public void b() {
        j jVar = this.f42019g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f42017e) {
            int i = this.f42015c - this.f42014b;
            if (i > (2048 - jVar.f42015c) + (jVar.f42016d ? 0 : jVar.f42014b)) {
                return;
            }
            a(this.f42019g, i);
            a();
            k.a(this);
        }
    }
}
