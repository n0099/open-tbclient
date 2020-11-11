package com.facebook.imagepipeline.common;
/* loaded from: classes12.dex */
public class e {
    private static final e oUN = new e(-1, false);
    private static final e oUO = new e(-2, false);
    private static final e oUP = new e(-1, true);
    private final int mRotation;
    private final boolean oUM;

    public static e enV() {
        return oUN;
    }

    public static e enW() {
        return oUO;
    }

    public static e enX() {
        return oUP;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.oUM = z;
    }

    public boolean enY() {
        return this.mRotation == -1;
    }

    public boolean enZ() {
        return this.mRotation != -2;
    }

    public int eoa() {
        if (enY()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean eob() {
        return this.oUM;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.oUM));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.oUM == eVar.oUM;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.oUM));
    }
}
