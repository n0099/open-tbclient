package com.facebook.imagepipeline.common;
/* loaded from: classes13.dex */
public class e {
    private static final e lRI = new e(-1, false);
    private static final e lRJ = new e(-2, false);
    private static final e lRK = new e(-1, true);
    private final boolean lRH;
    private final int mRotation;

    public static e dou() {
        return lRI;
    }

    public static e dov() {
        return lRJ;
    }

    public static e dow() {
        return lRK;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.lRH = z;
    }

    public boolean dox() {
        return this.mRotation == -1;
    }

    public boolean doy() {
        return this.mRotation != -2;
    }

    public int doz() {
        if (dox()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean doA() {
        return this.lRH;
    }

    public int hashCode() {
        return com.facebook.common.util.a.g(Integer.valueOf(this.mRotation), Boolean.valueOf(this.lRH));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.lRH == eVar.lRH;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.lRH));
    }
}
