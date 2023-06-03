package com.meizu.cloud.pushsdk.c.g;
/* loaded from: classes10.dex */
public final class j {
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public final boolean e;
    public j f;
    public j g;

    public j() {
        this.a = new byte[2048];
        this.e = true;
        this.d = false;
    }

    public j(j jVar) {
        this(jVar.a, jVar.b, jVar.c);
    }

    public j(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.e = false;
        this.d = true;
    }

    public j a() {
        j jVar = this.f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.g;
        jVar2.f = this.f;
        this.f.g = jVar2;
        this.f = null;
        this.g = null;
        return jVar;
    }

    public j a(int i) {
        if (i <= 0 || i > this.c - this.b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.c = jVar.b + i;
        this.b += i;
        this.g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.g = this;
        jVar.f = this.f;
        this.f.g = jVar;
        this.f = jVar;
        return jVar;
    }

    public void a(j jVar, int i) {
        if (!jVar.e) {
            throw new IllegalArgumentException();
        }
        int i2 = jVar.c;
        if (i2 + i > 2048) {
            if (jVar.d) {
                throw new IllegalArgumentException();
            }
            int i3 = jVar.b;
            if ((i2 + i) - i3 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            jVar.c -= jVar.b;
            jVar.b = 0;
        }
        System.arraycopy(this.a, this.b, jVar.a, jVar.c, i);
        jVar.c += i;
        this.b += i;
    }

    public void b() {
        j jVar = this.g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.e) {
            int i = this.c - this.b;
            if (i > (2048 - jVar.c) + (jVar.d ? 0 : jVar.b)) {
                return;
            }
            a(this.g, i);
            a();
            k.a(this);
        }
    }
}
