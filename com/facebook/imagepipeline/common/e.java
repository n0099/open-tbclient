package com.facebook.imagepipeline.common;
/* loaded from: classes12.dex */
public class e {
    private static final e nUc = new e(-1, false);
    private static final e nUd = new e(-2, false);
    private static final e nUe = new e(-1, true);
    private final int mRotation;
    private final boolean nUb;

    public static e eah() {
        return nUc;
    }

    public static e eai() {
        return nUd;
    }

    public static e eaj() {
        return nUe;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.nUb = z;
    }

    public boolean eak() {
        return this.mRotation == -1;
    }

    public boolean eal() {
        return this.mRotation != -2;
    }

    public int eam() {
        if (eak()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean ean() {
        return this.nUb;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.nUb));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.nUb == eVar.nUb;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.nUb));
    }
}
