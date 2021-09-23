package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes10.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f74997a;

    /* renamed from: b  reason: collision with root package name */
    public int f74998b;

    /* renamed from: c  reason: collision with root package name */
    public int f74999c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f75000d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f75001e;

    /* renamed from: f  reason: collision with root package name */
    public j f75002f;

    /* renamed from: g  reason: collision with root package name */
    public j f75003g;

    public j() {
        this.f74997a = new byte[2048];
        this.f75001e = true;
        this.f75000d = false;
    }

    public j(j jVar) {
        this(jVar.f74997a, jVar.f74998b, jVar.f74999c);
        jVar.f75000d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f74997a = bArr;
        this.f74998b = i2;
        this.f74999c = i3;
        this.f75001e = false;
        this.f75000d = true;
    }

    public j a() {
        j jVar = this.f75002f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f75003g;
        jVar2.f75002f = this.f75002f;
        this.f75002f.f75003g = jVar2;
        this.f75002f = null;
        this.f75003g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f74999c - this.f74998b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f74999c = jVar.f74998b + i2;
        this.f74998b += i2;
        this.f75003g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f75003g = this;
        jVar.f75002f = this.f75002f;
        this.f75002f.f75003g = jVar;
        this.f75002f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f75001e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f74999c;
        if (i3 + i2 > 2048) {
            if (jVar.f75000d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f74998b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f74997a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f74999c -= jVar.f74998b;
            jVar.f74998b = 0;
        }
        System.arraycopy(this.f74997a, this.f74998b, jVar.f74997a, jVar.f74999c, i2);
        jVar.f74999c += i2;
        this.f74998b += i2;
    }

    public void b() {
        j jVar = this.f75003g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f75001e) {
            int i2 = this.f74999c - this.f74998b;
            if (i2 > (2048 - jVar.f74999c) + (jVar.f75000d ? 0 : jVar.f74998b)) {
                return;
            }
            a(this.f75003g, i2);
            a();
            k.a(this);
        }
    }
}
