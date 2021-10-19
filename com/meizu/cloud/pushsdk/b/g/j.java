package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes10.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f75032a;

    /* renamed from: b  reason: collision with root package name */
    public int f75033b;

    /* renamed from: c  reason: collision with root package name */
    public int f75034c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f75035d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f75036e;

    /* renamed from: f  reason: collision with root package name */
    public j f75037f;

    /* renamed from: g  reason: collision with root package name */
    public j f75038g;

    public j() {
        this.f75032a = new byte[2048];
        this.f75036e = true;
        this.f75035d = false;
    }

    public j(j jVar) {
        this(jVar.f75032a, jVar.f75033b, jVar.f75034c);
        jVar.f75035d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.f75032a = bArr;
        this.f75033b = i2;
        this.f75034c = i3;
        this.f75036e = false;
        this.f75035d = true;
    }

    public j a() {
        j jVar = this.f75037f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f75038g;
        jVar2.f75037f = this.f75037f;
        this.f75037f.f75038g = jVar2;
        this.f75037f = null;
        this.f75038g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f75034c - this.f75033b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f75034c = jVar.f75033b + i2;
        this.f75033b += i2;
        this.f75038g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f75038g = this;
        jVar.f75037f = this.f75037f;
        this.f75037f.f75038g = jVar;
        this.f75037f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f75036e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f75034c;
        if (i3 + i2 > 2048) {
            if (jVar.f75035d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f75033b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f75032a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f75034c -= jVar.f75033b;
            jVar.f75033b = 0;
        }
        System.arraycopy(this.f75032a, this.f75033b, jVar.f75032a, jVar.f75034c, i2);
        jVar.f75034c += i2;
        this.f75033b += i2;
    }

    public void b() {
        j jVar = this.f75038g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f75036e) {
            int i2 = this.f75034c - this.f75033b;
            if (i2 > (2048 - jVar.f75034c) + (jVar.f75035d ? 0 : jVar.f75033b)) {
                return;
            }
            a(this.f75038g, i2);
            a();
            k.a(this);
        }
    }
}
