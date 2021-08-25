package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes10.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f74498a;

    /* renamed from: b  reason: collision with root package name */
    public int f74499b;

    /* renamed from: c  reason: collision with root package name */
    public int f74500c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f74501d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f74502e;

    /* renamed from: f  reason: collision with root package name */
    public j f74503f;

    /* renamed from: g  reason: collision with root package name */
    public j f74504g;

    public j() {
        this.f74498a = new byte[2048];
        this.f74502e = true;
        this.f74501d = false;
    }

    public j(j jVar) {
        this(jVar.f74498a, jVar.f74499b, jVar.f74500c);
        jVar.f74501d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f74498a = bArr;
        this.f74499b = i2;
        this.f74500c = i3;
        this.f74502e = false;
        this.f74501d = true;
    }

    public j a() {
        j jVar = this.f74503f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f74504g;
        jVar2.f74503f = this.f74503f;
        this.f74503f.f74504g = jVar2;
        this.f74503f = null;
        this.f74504g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f74500c - this.f74499b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f74500c = jVar.f74499b + i2;
        this.f74499b += i2;
        this.f74504g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f74504g = this;
        jVar.f74503f = this.f74503f;
        this.f74503f.f74504g = jVar;
        this.f74503f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f74502e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f74500c;
        if (i3 + i2 > 2048) {
            if (jVar.f74501d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f74499b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f74498a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f74500c -= jVar.f74499b;
            jVar.f74499b = 0;
        }
        System.arraycopy(this.f74498a, this.f74499b, jVar.f74498a, jVar.f74500c, i2);
        jVar.f74500c += i2;
        this.f74499b += i2;
    }

    public void b() {
        j jVar = this.f74504g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f74502e) {
            int i2 = this.f74500c - this.f74499b;
            if (i2 > (2048 - jVar.f74500c) + (jVar.f74501d ? 0 : jVar.f74499b)) {
                return;
            }
            a(this.f74504g, i2);
            a();
            k.a(this);
        }
    }
}
