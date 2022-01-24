package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes3.dex */
public final class j {
    public final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f58658b;

    /* renamed from: c  reason: collision with root package name */
    public int f58659c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58660d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58661e;

    /* renamed from: f  reason: collision with root package name */
    public j f58662f;

    /* renamed from: g  reason: collision with root package name */
    public j f58663g;

    public j() {
        this.a = new byte[2048];
        this.f58661e = true;
        this.f58660d = false;
    }

    public j(j jVar) {
        this(jVar.a, jVar.f58658b, jVar.f58659c);
        jVar.f58660d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.f58658b = i2;
        this.f58659c = i3;
        this.f58661e = false;
        this.f58660d = true;
    }

    public j a() {
        j jVar = this.f58662f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f58663g;
        jVar2.f58662f = this.f58662f;
        this.f58662f.f58663g = jVar2;
        this.f58662f = null;
        this.f58663g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f58659c - this.f58658b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f58659c = jVar.f58658b + i2;
        this.f58658b += i2;
        this.f58663g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f58663g = this;
        jVar.f58662f = this.f58662f;
        this.f58662f.f58663g = jVar;
        this.f58662f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f58661e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f58659c;
        if (i3 + i2 > 2048) {
            if (jVar.f58660d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f58658b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f58659c -= jVar.f58658b;
            jVar.f58658b = 0;
        }
        System.arraycopy(this.a, this.f58658b, jVar.a, jVar.f58659c, i2);
        jVar.f58659c += i2;
        this.f58658b += i2;
    }

    public void b() {
        j jVar = this.f58663g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f58661e) {
            int i2 = this.f58659c - this.f58658b;
            if (i2 > (2048 - jVar.f58659c) + (jVar.f58660d ? 0 : jVar.f58658b)) {
                return;
            }
            a(this.f58663g, i2);
            a();
            k.a(this);
        }
    }
}
