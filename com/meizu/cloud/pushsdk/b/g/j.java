package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes7.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f38490a;

    /* renamed from: b  reason: collision with root package name */
    public int f38491b;

    /* renamed from: c  reason: collision with root package name */
    public int f38492c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38493d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38494e;

    /* renamed from: f  reason: collision with root package name */
    public j f38495f;

    /* renamed from: g  reason: collision with root package name */
    public j f38496g;

    public j() {
        this.f38490a = new byte[2048];
        this.f38494e = true;
        this.f38493d = false;
    }

    public j(j jVar) {
        this(jVar.f38490a, jVar.f38491b, jVar.f38492c);
        jVar.f38493d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f38490a = bArr;
        this.f38491b = i2;
        this.f38492c = i3;
        this.f38494e = false;
        this.f38493d = true;
    }

    public j a() {
        j jVar = this.f38495f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f38496g;
        jVar2.f38495f = this.f38495f;
        this.f38495f.f38496g = jVar2;
        this.f38495f = null;
        this.f38496g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f38492c - this.f38491b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f38492c = jVar.f38491b + i2;
        this.f38491b += i2;
        this.f38496g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f38496g = this;
        jVar.f38495f = this.f38495f;
        this.f38495f.f38496g = jVar;
        this.f38495f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f38494e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f38492c;
        if (i3 + i2 > 2048) {
            if (jVar.f38493d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f38491b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f38490a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f38492c -= jVar.f38491b;
            jVar.f38491b = 0;
        }
        System.arraycopy(this.f38490a, this.f38491b, jVar.f38490a, jVar.f38492c, i2);
        jVar.f38492c += i2;
        this.f38491b += i2;
    }

    public void b() {
        j jVar = this.f38496g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f38494e) {
            int i2 = this.f38492c - this.f38491b;
            if (i2 > (2048 - jVar.f38492c) + (jVar.f38493d ? 0 : jVar.f38491b)) {
                return;
            }
            a(this.f38496g, i2);
            a();
            k.a(this);
        }
    }
}
