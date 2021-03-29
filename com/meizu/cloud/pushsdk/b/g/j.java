package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f37604a;

    /* renamed from: b  reason: collision with root package name */
    public int f37605b;

    /* renamed from: c  reason: collision with root package name */
    public int f37606c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37607d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37608e;

    /* renamed from: f  reason: collision with root package name */
    public j f37609f;

    /* renamed from: g  reason: collision with root package name */
    public j f37610g;

    public j() {
        this.f37604a = new byte[2048];
        this.f37608e = true;
        this.f37607d = false;
    }

    public j(j jVar) {
        this(jVar.f37604a, jVar.f37605b, jVar.f37606c);
        jVar.f37607d = true;
    }

    public j(byte[] bArr, int i, int i2) {
        this.f37604a = bArr;
        this.f37605b = i;
        this.f37606c = i2;
        this.f37608e = false;
        this.f37607d = true;
    }

    public j a() {
        j jVar = this.f37609f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f37610g;
        jVar2.f37609f = this.f37609f;
        this.f37609f.f37610g = jVar2;
        this.f37609f = null;
        this.f37610g = null;
        return jVar;
    }

    public j a(int i) {
        if (i <= 0 || i > this.f37606c - this.f37605b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f37606c = jVar.f37605b + i;
        this.f37605b += i;
        this.f37610g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f37610g = this;
        jVar.f37609f = this.f37609f;
        this.f37609f.f37610g = jVar;
        this.f37609f = jVar;
        return jVar;
    }

    public void a(j jVar, int i) {
        if (!jVar.f37608e) {
            throw new IllegalArgumentException();
        }
        int i2 = jVar.f37606c;
        if (i2 + i > 2048) {
            if (jVar.f37607d) {
                throw new IllegalArgumentException();
            }
            int i3 = jVar.f37605b;
            if ((i2 + i) - i3 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f37604a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            jVar.f37606c -= jVar.f37605b;
            jVar.f37605b = 0;
        }
        System.arraycopy(this.f37604a, this.f37605b, jVar.f37604a, jVar.f37606c, i);
        jVar.f37606c += i;
        this.f37605b += i;
    }

    public void b() {
        j jVar = this.f37610g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f37608e) {
            int i = this.f37606c - this.f37605b;
            if (i > (2048 - jVar.f37606c) + (jVar.f37607d ? 0 : jVar.f37605b)) {
                return;
            }
            a(this.f37610g, i);
            a();
            k.a(this);
        }
    }
}
