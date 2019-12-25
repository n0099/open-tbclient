package com.google.android.exoplayer2.a;
/* loaded from: classes4.dex */
public abstract class a {
    private int flags;

    public void clear() {
        this.flags = 0;
    }

    public final boolean drS() {
        return IZ(Integer.MIN_VALUE);
    }

    public final boolean drT() {
        return IZ(4);
    }

    public final boolean drU() {
        return IZ(1);
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    public final void aH(int i) {
        this.flags |= i;
    }

    public final void aI(int i) {
        this.flags &= i ^ (-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean IZ(int i) {
        return (this.flags & i) == i;
    }
}
