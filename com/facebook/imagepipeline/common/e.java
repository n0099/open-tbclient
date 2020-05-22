package com.facebook.imagepipeline.common;
/* loaded from: classes13.dex */
public class e {
    private static final e mvj = new e(-1, false);
    private static final e mvk = new e(-2, false);
    private static final e mvl = new e(-1, true);
    private final int mRotation;
    private final boolean mvi;

    public static e dyj() {
        return mvj;
    }

    public static e dyk() {
        return mvk;
    }

    public static e dyl() {
        return mvl;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.mvi = z;
    }

    public boolean dym() {
        return this.mRotation == -1;
    }

    public boolean dyn() {
        return this.mRotation != -2;
    }

    public int dyo() {
        if (dym()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean dyp() {
        return this.mvi;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.mvi));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.mvi == eVar.mvi;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.mvi));
    }
}
