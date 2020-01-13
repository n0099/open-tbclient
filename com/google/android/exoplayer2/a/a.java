package com.google.android.exoplayer2.a;
/* loaded from: classes5.dex */
public abstract class a {
    private int flags;

    public void clear() {
        this.flags = 0;
    }

    public final boolean dte() {
        return Ji(Integer.MIN_VALUE);
    }

    public final boolean dtf() {
        return Ji(4);
    }

    public final boolean dtg() {
        return Ji(1);
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
    public final boolean Ji(int i) {
        return (this.flags & i) == i;
    }
}
