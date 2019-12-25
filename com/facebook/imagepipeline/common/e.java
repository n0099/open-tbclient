package com.facebook.imagepipeline.common;
/* loaded from: classes11.dex */
public class e {
    private static final e lNk = new e(-1, false);
    private static final e lNl = new e(-2, false);
    private static final e lNm = new e(-1, true);
    private final boolean lNj;
    private final int mRotation;

    public static e dma() {
        return lNk;
    }

    public static e dmb() {
        return lNm;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.lNj = z;
    }

    public boolean dmc() {
        return this.mRotation == -1;
    }

    public boolean dmd() {
        return this.mRotation != -2;
    }

    public int dme() {
        if (dmc()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean dmf() {
        return this.lNj;
    }

    public int hashCode() {
        return com.facebook.common.util.a.g(Integer.valueOf(this.mRotation), Boolean.valueOf(this.lNj));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.lNj == eVar.lNj;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.lNj));
    }
}
