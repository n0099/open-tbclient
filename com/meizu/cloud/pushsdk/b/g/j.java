package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes7.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f38392a;

    /* renamed from: b  reason: collision with root package name */
    public int f38393b;

    /* renamed from: c  reason: collision with root package name */
    public int f38394c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38395d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38396e;

    /* renamed from: f  reason: collision with root package name */
    public j f38397f;

    /* renamed from: g  reason: collision with root package name */
    public j f38398g;

    public j() {
        this.f38392a = new byte[2048];
        this.f38396e = true;
        this.f38395d = false;
    }

    public j(j jVar) {
        this(jVar.f38392a, jVar.f38393b, jVar.f38394c);
        jVar.f38395d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f38392a = bArr;
        this.f38393b = i2;
        this.f38394c = i3;
        this.f38396e = false;
        this.f38395d = true;
    }

    public j a() {
        j jVar = this.f38397f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f38398g;
        jVar2.f38397f = this.f38397f;
        this.f38397f.f38398g = jVar2;
        this.f38397f = null;
        this.f38398g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f38394c - this.f38393b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f38394c = jVar.f38393b + i2;
        this.f38393b += i2;
        this.f38398g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f38398g = this;
        jVar.f38397f = this.f38397f;
        this.f38397f.f38398g = jVar;
        this.f38397f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f38396e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f38394c;
        if (i3 + i2 > 2048) {
            if (jVar.f38395d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f38393b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f38392a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f38394c -= jVar.f38393b;
            jVar.f38393b = 0;
        }
        System.arraycopy(this.f38392a, this.f38393b, jVar.f38392a, jVar.f38394c, i2);
        jVar.f38394c += i2;
        this.f38393b += i2;
    }

    public void b() {
        j jVar = this.f38398g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f38396e) {
            int i2 = this.f38394c - this.f38393b;
            if (i2 > (2048 - jVar.f38394c) + (jVar.f38395d ? 0 : jVar.f38393b)) {
                return;
            }
            a(this.f38398g, i2);
            a();
            k.a(this);
        }
    }
}
