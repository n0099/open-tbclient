package com.google.android.exoplayer2.decoder;
/* loaded from: classes7.dex */
public abstract class Buffer {
    public int flags;

    public void clear() {
        this.flags = 0;
    }

    public final boolean isDecodeOnly() {
        return getFlag(Integer.MIN_VALUE);
    }

    public final boolean isEndOfStream() {
        return getFlag(4);
    }

    public final boolean isKeyFrame() {
        return getFlag(1);
    }

    public final void addFlag(int i) {
        this.flags = i | this.flags;
    }

    public final void clearFlag(int i) {
        this.flags = (~i) & this.flags;
    }

    public final boolean getFlag(int i) {
        if ((this.flags & i) == i) {
            return true;
        }
        return false;
    }

    public final void setFlags(int i) {
        this.flags = i;
    }
}
