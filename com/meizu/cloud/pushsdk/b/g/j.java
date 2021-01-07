package com.meizu.cloud.pushsdk.b.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f11508a;

    /* renamed from: b  reason: collision with root package name */
    int f11509b;
    int c;
    boolean d;
    boolean e;
    j f;
    j g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j() {
        this.f11508a = new byte[2048];
        this.e = true;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(j jVar) {
        this(jVar.f11508a, jVar.f11509b, jVar.c);
        jVar.d = true;
    }

    j(byte[] bArr, int i, int i2) {
        this.f11508a = bArr;
        this.f11509b = i;
        this.c = i2;
        this.e = false;
        this.d = true;
    }

    public j a() {
        j jVar = this.f != this ? this.f : null;
        this.g.f = this.f;
        this.f.g = this.g;
        this.f = null;
        this.g = null;
        return jVar;
    }

    public j a(int i) {
        if (i <= 0 || i > this.c - this.f11509b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.c = jVar.f11509b + i;
        this.f11509b += i;
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
        if (jVar.c + i > 2048) {
            if (jVar.d) {
                throw new IllegalArgumentException();
            }
            if ((jVar.c + i) - jVar.f11509b > 2048) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(jVar.f11508a, jVar.f11509b, jVar.f11508a, 0, jVar.c - jVar.f11509b);
            jVar.c -= jVar.f11509b;
            jVar.f11509b = 0;
        }
        System.arraycopy(this.f11508a, this.f11509b, jVar.f11508a, jVar.c, i);
        jVar.c += i;
        this.f11509b += i;
    }

    public void b() {
        if (this.g == this) {
            throw new IllegalStateException();
        }
        if (this.g.e) {
            int i = this.c - this.f11509b;
            if (i <= (this.g.d ? 0 : this.g.f11509b) + (2048 - this.g.c)) {
                a(this.g, i);
                a();
                k.a(this);
            }
        }
    }
}
