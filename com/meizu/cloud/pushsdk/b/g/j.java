package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f67395a;

    /* renamed from: b  reason: collision with root package name */
    public int f67396b;

    /* renamed from: c  reason: collision with root package name */
    public int f67397c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67398d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67399e;

    /* renamed from: f  reason: collision with root package name */
    public j f67400f;

    /* renamed from: g  reason: collision with root package name */
    public j f67401g;

    public j() {
        this.f67395a = new byte[2048];
        this.f67399e = true;
        this.f67398d = false;
    }

    public j(j jVar) {
        this(jVar.f67395a, jVar.f67396b, jVar.f67397c);
        jVar.f67398d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f67395a = bArr;
        this.f67396b = i2;
        this.f67397c = i3;
        this.f67399e = false;
        this.f67398d = true;
    }

    public j a() {
        j jVar = this.f67400f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f67401g;
        jVar2.f67400f = this.f67400f;
        this.f67400f.f67401g = jVar2;
        this.f67400f = null;
        this.f67401g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f67397c - this.f67396b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f67397c = jVar.f67396b + i2;
        this.f67396b += i2;
        this.f67401g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f67401g = this;
        jVar.f67400f = this.f67400f;
        this.f67400f.f67401g = jVar;
        this.f67400f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f67399e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f67397c;
        if (i3 + i2 > 2048) {
            if (jVar.f67398d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f67396b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f67395a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f67397c -= jVar.f67396b;
            jVar.f67396b = 0;
        }
        System.arraycopy(this.f67395a, this.f67396b, jVar.f67395a, jVar.f67397c, i2);
        jVar.f67397c += i2;
        this.f67396b += i2;
    }

    public void b() {
        j jVar = this.f67401g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f67399e) {
            int i2 = this.f67397c - this.f67396b;
            if (i2 > (2048 - jVar.f67397c) + (jVar.f67398d ? 0 : jVar.f67396b)) {
                return;
            }
            a(this.f67401g, i2);
            a();
            k.a(this);
        }
    }
}
