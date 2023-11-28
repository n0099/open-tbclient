package com.kwad.components.core.q;
/* loaded from: classes10.dex */
public class a {
    public static volatile a Si;
    public int OR;
    public int Sj;
    public boolean Sk;
    public boolean Sl;
    public int Sm;
    public boolean Sn;

    public static a qu() {
        if (Si == null) {
            synchronized (a.class) {
                if (Si == null) {
                    Si = new a();
                }
            }
        }
        return Si;
    }

    public final void clear() {
        this.Sl = false;
        this.Sk = false;
        this.Sm = 0;
        this.Sn = false;
        this.Sj = -1;
        this.OR = 0;
    }

    public final boolean qA() {
        return this.Sn;
    }

    public final int qB() {
        return this.OR;
    }

    public final int qv() {
        return this.Sj;
    }

    public final boolean qw() {
        return this.Sk;
    }

    public final boolean qx() {
        return this.Sl;
    }

    public final boolean qy() {
        int i = this.Sm;
        if (i == 1 || i == 3) {
            return true;
        }
        return false;
    }

    public final int qz() {
        return this.Sm;
    }

    public final void aD(int i) {
        this.Sj = i;
    }

    public final void aE(int i) {
        this.Sm = i;
    }

    public final void aF(int i) {
        this.OR = i;
    }

    public final void aJ(boolean z) {
        this.Sk = true;
    }

    public final void aK(boolean z) {
        this.Sl = z;
    }

    public final void aL(boolean z) {
        this.Sn = z;
    }
}
