package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f34784a;

    /* renamed from: b  reason: collision with root package name */
    public int f34785b;

    /* renamed from: c  reason: collision with root package name */
    public int f34786c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34787d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34788e;

    /* renamed from: f  reason: collision with root package name */
    public j f34789f;

    /* renamed from: g  reason: collision with root package name */
    public j f34790g;

    public j() {
        this.f34784a = new byte[2048];
        this.f34788e = true;
        this.f34787d = false;
    }

    public j(j jVar) {
        this(jVar.f34784a, jVar.f34785b, jVar.f34786c);
        jVar.f34787d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f34784a = bArr;
        this.f34785b = i2;
        this.f34786c = i3;
        this.f34788e = false;
        this.f34787d = true;
    }

    public j a() {
        j jVar = this.f34789f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f34790g;
        jVar2.f34789f = this.f34789f;
        this.f34789f.f34790g = jVar2;
        this.f34789f = null;
        this.f34790g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f34786c - this.f34785b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f34786c = jVar.f34785b + i2;
        this.f34785b += i2;
        this.f34790g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f34790g = this;
        jVar.f34789f = this.f34789f;
        this.f34789f.f34790g = jVar;
        this.f34789f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f34788e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f34786c;
        if (i3 + i2 > 2048) {
            if (jVar.f34787d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f34785b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f34784a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f34786c -= jVar.f34785b;
            jVar.f34785b = 0;
        }
        System.arraycopy(this.f34784a, this.f34785b, jVar.f34784a, jVar.f34786c, i2);
        jVar.f34786c += i2;
        this.f34785b += i2;
    }

    public void b() {
        j jVar = this.f34790g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f34788e) {
            int i2 = this.f34786c - this.f34785b;
            if (i2 > (2048 - jVar.f34786c) + (jVar.f34787d ? 0 : jVar.f34785b)) {
                return;
            }
            a(this.f34790g, i2);
            a();
            k.a(this);
        }
    }
}
