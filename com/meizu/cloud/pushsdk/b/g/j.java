package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f35539a;

    /* renamed from: b  reason: collision with root package name */
    public int f35540b;

    /* renamed from: c  reason: collision with root package name */
    public int f35541c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35542d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35543e;

    /* renamed from: f  reason: collision with root package name */
    public j f35544f;

    /* renamed from: g  reason: collision with root package name */
    public j f35545g;

    public j() {
        this.f35539a = new byte[2048];
        this.f35543e = true;
        this.f35542d = false;
    }

    public j(j jVar) {
        this(jVar.f35539a, jVar.f35540b, jVar.f35541c);
        jVar.f35542d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f35539a = bArr;
        this.f35540b = i2;
        this.f35541c = i3;
        this.f35543e = false;
        this.f35542d = true;
    }

    public j a() {
        j jVar = this.f35544f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f35545g;
        jVar2.f35544f = this.f35544f;
        this.f35544f.f35545g = jVar2;
        this.f35544f = null;
        this.f35545g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f35541c - this.f35540b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f35541c = jVar.f35540b + i2;
        this.f35540b += i2;
        this.f35545g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f35545g = this;
        jVar.f35544f = this.f35544f;
        this.f35544f.f35545g = jVar;
        this.f35544f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f35543e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f35541c;
        if (i3 + i2 > 2048) {
            if (jVar.f35542d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f35540b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f35539a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f35541c -= jVar.f35540b;
            jVar.f35540b = 0;
        }
        System.arraycopy(this.f35539a, this.f35540b, jVar.f35539a, jVar.f35541c, i2);
        jVar.f35541c += i2;
        this.f35540b += i2;
    }

    public void b() {
        j jVar = this.f35545g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f35543e) {
            int i2 = this.f35541c - this.f35540b;
            if (i2 > (2048 - jVar.f35541c) + (jVar.f35542d ? 0 : jVar.f35540b)) {
                return;
            }
            a(this.f35545g, i2);
            a();
            k.a(this);
        }
    }
}
