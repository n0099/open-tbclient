package com.facebook.imagepipeline.common;
/* loaded from: classes13.dex */
public class e {
    private static final e lRK = new e(-1, false);
    private static final e lRL = new e(-2, false);
    private static final e lRM = new e(-1, true);
    private final boolean lRJ;
    private final int mRotation;

    public static e dow() {
        return lRK;
    }

    public static e dox() {
        return lRL;
    }

    public static e doy() {
        return lRM;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.lRJ = z;
    }

    public boolean doz() {
        return this.mRotation == -1;
    }

    public boolean doA() {
        return this.mRotation != -2;
    }

    public int doB() {
        if (doz()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean doC() {
        return this.lRJ;
    }

    public int hashCode() {
        return com.facebook.common.util.a.g(Integer.valueOf(this.mRotation), Boolean.valueOf(this.lRJ));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.lRJ == eVar.lRJ;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.lRJ));
    }
}
