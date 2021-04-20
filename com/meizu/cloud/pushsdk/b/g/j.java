package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f37893a;

    /* renamed from: b  reason: collision with root package name */
    public int f37894b;

    /* renamed from: c  reason: collision with root package name */
    public int f37895c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37896d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37897e;

    /* renamed from: f  reason: collision with root package name */
    public j f37898f;

    /* renamed from: g  reason: collision with root package name */
    public j f37899g;

    public j() {
        this.f37893a = new byte[2048];
        this.f37897e = true;
        this.f37896d = false;
    }

    public j(j jVar) {
        this(jVar.f37893a, jVar.f37894b, jVar.f37895c);
        jVar.f37896d = true;
    }

    public j(byte[] bArr, int i, int i2) {
        this.f37893a = bArr;
        this.f37894b = i;
        this.f37895c = i2;
        this.f37897e = false;
        this.f37896d = true;
    }

    public j a() {
        j jVar = this.f37898f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f37899g;
        jVar2.f37898f = this.f37898f;
        this.f37898f.f37899g = jVar2;
        this.f37898f = null;
        this.f37899g = null;
        return jVar;
    }

    public j a(int i) {
        if (i <= 0 || i > this.f37895c - this.f37894b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f37895c = jVar.f37894b + i;
        this.f37894b += i;
        this.f37899g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f37899g = this;
        jVar.f37898f = this.f37898f;
        this.f37898f.f37899g = jVar;
        this.f37898f = jVar;
        return jVar;
    }

    public void a(j jVar, int i) {
        if (!jVar.f37897e) {
            throw new IllegalArgumentException();
        }
        int i2 = jVar.f37895c;
        if (i2 + i > 2048) {
            if (jVar.f37896d) {
                throw new IllegalArgumentException();
            }
            int i3 = jVar.f37894b;
            if ((i2 + i) - i3 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f37893a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            jVar.f37895c -= jVar.f37894b;
            jVar.f37894b = 0;
        }
        System.arraycopy(this.f37893a, this.f37894b, jVar.f37893a, jVar.f37895c, i);
        jVar.f37895c += i;
        this.f37894b += i;
    }

    public void b() {
        j jVar = this.f37899g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f37897e) {
            int i = this.f37895c - this.f37894b;
            if (i > (2048 - jVar.f37895c) + (jVar.f37896d ? 0 : jVar.f37894b)) {
                return;
            }
            a(this.f37899g, i);
            a();
            k.a(this);
        }
    }
}
