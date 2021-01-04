package com.meizu.cloud.pushsdk.b.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f11507a;

    /* renamed from: b  reason: collision with root package name */
    int f11508b;
    int c;
    boolean d;
    boolean e;
    j f;
    j g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j() {
        this.f11507a = new byte[2048];
        this.e = true;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(j jVar) {
        this(jVar.f11507a, jVar.f11508b, jVar.c);
        jVar.d = true;
    }

    j(byte[] bArr, int i, int i2) {
        this.f11507a = bArr;
        this.f11508b = i;
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
        if (i <= 0 || i > this.c - this.f11508b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.c = jVar.f11508b + i;
        this.f11508b += i;
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
            if ((jVar.c + i) - jVar.f11508b > 2048) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(jVar.f11507a, jVar.f11508b, jVar.f11507a, 0, jVar.c - jVar.f11508b);
            jVar.c -= jVar.f11508b;
            jVar.f11508b = 0;
        }
        System.arraycopy(this.f11507a, this.f11508b, jVar.f11507a, jVar.c, i);
        jVar.c += i;
        this.f11508b += i;
    }

    public void b() {
        if (this.g == this) {
            throw new IllegalStateException();
        }
        if (this.g.e) {
            int i = this.c - this.f11508b;
            if (i <= (this.g.d ? 0 : this.g.f11508b) + (2048 - this.g.c)) {
                a(this.g, i);
                a();
                k.a(this);
            }
        }
    }
}
