package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes10.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f74298a;

    /* renamed from: b  reason: collision with root package name */
    public int f74299b;

    /* renamed from: c  reason: collision with root package name */
    public int f74300c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f74301d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f74302e;

    /* renamed from: f  reason: collision with root package name */
    public j f74303f;

    /* renamed from: g  reason: collision with root package name */
    public j f74304g;

    public j() {
        this.f74298a = new byte[2048];
        this.f74302e = true;
        this.f74301d = false;
    }

    public j(j jVar) {
        this(jVar.f74298a, jVar.f74299b, jVar.f74300c);
        jVar.f74301d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f74298a = bArr;
        this.f74299b = i2;
        this.f74300c = i3;
        this.f74302e = false;
        this.f74301d = true;
    }

    public j a() {
        j jVar = this.f74303f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f74304g;
        jVar2.f74303f = this.f74303f;
        this.f74303f.f74304g = jVar2;
        this.f74303f = null;
        this.f74304g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f74300c - this.f74299b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f74300c = jVar.f74299b + i2;
        this.f74299b += i2;
        this.f74304g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f74304g = this;
        jVar.f74303f = this.f74303f;
        this.f74303f.f74304g = jVar;
        this.f74303f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f74302e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f74300c;
        if (i3 + i2 > 2048) {
            if (jVar.f74301d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f74299b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f74298a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f74300c -= jVar.f74299b;
            jVar.f74299b = 0;
        }
        System.arraycopy(this.f74298a, this.f74299b, jVar.f74298a, jVar.f74300c, i2);
        jVar.f74300c += i2;
        this.f74299b += i2;
    }

    public void b() {
        j jVar = this.f74304g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f74302e) {
            int i2 = this.f74300c - this.f74299b;
            if (i2 > (2048 - jVar.f74300c) + (jVar.f74301d ? 0 : jVar.f74299b)) {
                return;
            }
            a(this.f74304g, i2);
            a();
            k.a(this);
        }
    }
}
