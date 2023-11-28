package com.kwad.sdk.utils;
/* loaded from: classes10.dex */
public final class bd {
    public final int mHeight;
    public final int mWidth;

    public bd(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public final float Le() {
        return this.mWidth;
    }

    public final float Lf() {
        return this.mHeight;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final int hashCode() {
        int i = this.mHeight;
        int i2 = this.mWidth;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public final String toString() {
        return this.mWidth + "x" + this.mHeight;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof bd) {
            bd bdVar = (bd) obj;
            if (this.mWidth == bdVar.mWidth && this.mHeight == bdVar.mHeight) {
                return true;
            }
        }
        return false;
    }
}
