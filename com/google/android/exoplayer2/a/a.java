package com.google.android.exoplayer2.a;
/* loaded from: classes6.dex */
public abstract class a {
    private int flags;

    public void clear() {
        this.flags = 0;
    }

    public final boolean duR() {
        return Jt(Integer.MIN_VALUE);
    }

    public final boolean duS() {
        return Jt(4);
    }

    public final boolean duT() {
        return Jt(1);
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    public final void aK(int i) {
        this.flags |= i;
    }

    public final void aL(int i) {
        this.flags &= i ^ (-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Jt(int i) {
        return (this.flags & i) == i;
    }
}
