package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes4.dex */
public final class j {
    public final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f58825b;

    /* renamed from: c  reason: collision with root package name */
    public int f58826c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58827d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58828e;

    /* renamed from: f  reason: collision with root package name */
    public j f58829f;

    /* renamed from: g  reason: collision with root package name */
    public j f58830g;

    public j() {
        this.a = new byte[2048];
        this.f58828e = true;
        this.f58827d = false;
    }

    public j(j jVar) {
        this(jVar.a, jVar.f58825b, jVar.f58826c);
        jVar.f58827d = true;
    }

    public j(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.f58825b = i2;
        this.f58826c = i3;
        this.f58828e = false;
        this.f58827d = true;
    }

    public j a() {
        j jVar = this.f58829f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.f58830g;
        jVar2.f58829f = this.f58829f;
        this.f58829f.f58830g = jVar2;
        this.f58829f = null;
        this.f58830g = null;
        return jVar;
    }

    public j a(int i2) {
        if (i2 <= 0 || i2 > this.f58826c - this.f58825b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f58826c = jVar.f58825b + i2;
        this.f58825b += i2;
        this.f58830g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.f58830g = this;
        jVar.f58829f = this.f58829f;
        this.f58829f.f58830g = jVar;
        this.f58829f = jVar;
        return jVar;
    }

    public void a(j jVar, int i2) {
        if (!jVar.f58828e) {
            throw new IllegalArgumentException();
        }
        int i3 = jVar.f58826c;
        if (i3 + i2 > 2048) {
            if (jVar.f58827d) {
                throw new IllegalArgumentException();
            }
            int i4 = jVar.f58825b;
            if ((i3 + i2) - i4 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.a;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            jVar.f58826c -= jVar.f58825b;
            jVar.f58825b = 0;
        }
        System.arraycopy(this.a, this.f58825b, jVar.a, jVar.f58826c, i2);
        jVar.f58826c += i2;
        this.f58825b += i2;
    }

    public void b() {
        j jVar = this.f58830g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.f58828e) {
            int i2 = this.f58826c - this.f58825b;
            if (i2 > (2048 - jVar.f58826c) + (jVar.f58827d ? 0 : jVar.f58825b)) {
                return;
            }
            a(this.f58830g, i2);
            a();
            k.a(this);
        }
    }
}
