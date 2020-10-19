package com.kascend.chushou.player.a;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f4111a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public boolean g;
    public boolean h;
    public a ohZ;

    /* loaded from: classes6.dex */
    interface a {
        void a(int i);
    }

    public c(int i, int i2, int i3, boolean z, a aVar) {
        this.g = false;
        this.h = true;
        this.f4111a = i;
        this.b = i2;
        this.c = i3;
        this.e = z;
        this.ohZ = aVar;
        this.d = 0;
        this.h = true;
    }

    public c(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, a aVar) {
        this.g = false;
        this.h = true;
        this.f4111a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = z;
        this.h = z2;
        this.g = z3;
        this.ohZ = aVar;
    }
}
