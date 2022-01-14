package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes3.dex */
public final class j {
    public final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f58613b;

    /* renamed from: c  reason: collision with root package name */
    public int f58614c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58615d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58616e;

    /* renamed from: f  reason: collision with root package name */
    public j f58617f;

    /* renamed from: g  reason: collision with root package name */
    public j f58618g;

    public j() {
        this.a = new byte[2048];
        this.f58616e = true;
        this.f58615d = false;
    }

    public j(j jVar) {
        this(jVar.a, jVar.f58613b, jVar.f58614c);
        jVar.f58615d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.f58613b = i2;
        this.f58614c = i3;
        this.f58616e = false;
        this.f58615d = true;
    }

    public j a() {
        j jVar = this.f58617f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f58618g;
        jVar2.f58617f = this.f58617f;
        this.f58617f.f58618g = jVar2;
        this.f58617f = null;
        this.f58618g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f58614c - this.f58613b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f58614c = jVar.f58613b + i2;
        this.f58613b += i2;
        this.f58618g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f58618g = this;
        jVar.f58617f = this.f58617f;
        this.f58617f.f58618g = jVar;
        this.f58617f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f58616e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f58614c;
        if (i3 + i2 > 2048) {
            if (jVar.f58615d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f58613b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f58614c -= jVar.f58613b;
            jVar.f58613b = 0;
        }
        System.arraycopy(this.a, this.f58613b, jVar.a, jVar.f58614c, i2);
        jVar.f58614c += i2;
        this.f58613b += i2;
    }

    public void b() {
        j jVar = this.f58618g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f58616e) {
            int i2 = this.f58614c - this.f58613b;
            if (i2 > (2048 - jVar.f58614c) + (jVar.f58615d ? 0 : jVar.f58613b)) {
                return;
            }
            a(this.f58618g, i2);
            a();
            k.a(this);
        }
    }
}
