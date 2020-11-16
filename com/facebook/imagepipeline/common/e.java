package com.facebook.imagepipeline.common;
/* loaded from: classes17.dex */
public class e {
    private static final e oWq = new e(-1, false);
    private static final e oWr = new e(-2, false);
    private static final e oWs = new e(-1, true);
    private final int mRotation;
    private final boolean oWp;

    public static e enT() {
        return oWq;
    }

    public static e enU() {
        return oWr;
    }

    public static e enV() {
        return oWs;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.oWp = z;
    }

    public boolean enW() {
        return this.mRotation == -1;
    }

    public boolean enX() {
        return this.mRotation != -2;
    }

    public int enY() {
        if (enW()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean enZ() {
        return this.oWp;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.oWp));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.oWp == eVar.oWp;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.oWp));
    }
}
