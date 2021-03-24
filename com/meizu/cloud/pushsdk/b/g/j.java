package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f37603a;

    /* renamed from: b  reason: collision with root package name */
    public int f37604b;

    /* renamed from: c  reason: collision with root package name */
    public int f37605c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37606d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37607e;

    /* renamed from: f  reason: collision with root package name */
    public j f37608f;

    /* renamed from: g  reason: collision with root package name */
    public j f37609g;

    public j() {
        this.f37603a = new byte[2048];
        this.f37607e = true;
        this.f37606d = false;
    }

    public j(j jVar) {
        this(jVar.f37603a, jVar.f37604b, jVar.f37605c);
        jVar.f37606d = true;
    }

    public j(byte[] bArr, int i, int i2) {
        this.f37603a = bArr;
        this.f37604b = i;
        this.f37605c = i2;
        this.f37607e = false;
        this.f37606d = true;
    }

    public j a() {
        j jVar = this.f37608f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f37609g;
        jVar2.f37608f = this.f37608f;
        this.f37608f.f37609g = jVar2;
        this.f37608f = null;
        this.f37609g = null;
        return jVar;
    }

    public j a(int i) {
        if (i <= 0 || i > this.f37605c - this.f37604b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f37605c = jVar.f37604b + i;
        this.f37604b += i;
        this.f37609g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f37609g = this;
        jVar.f37608f = this.f37608f;
        this.f37608f.f37609g = jVar;
        this.f37608f = jVar;
        return jVar;
    }

    public void a(j jVar, int i) {
        if (!jVar.f37607e) {
            throw new IllegalArgumentException();
        }
        int i2 = jVar.f37605c;
        if (i2 + i > 2048) {
            if (jVar.f37606d) {
                throw new IllegalArgumentException();
            }
            int i3 = jVar.f37604b;
            if ((i2 + i) - i3 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f37603a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            jVar.f37605c -= jVar.f37604b;
            jVar.f37604b = 0;
        }
        System.arraycopy(this.f37603a, this.f37604b, jVar.f37603a, jVar.f37605c, i);
        jVar.f37605c += i;
        this.f37604b += i;
    }

    public void b() {
        j jVar = this.f37609g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f37607e) {
            int i = this.f37605c - this.f37604b;
            if (i > (2048 - jVar.f37605c) + (jVar.f37606d ? 0 : jVar.f37604b)) {
                return;
            }
            a(this.f37609g, i);
            a();
            k.a(this);
        }
    }
}
