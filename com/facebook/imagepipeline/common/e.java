package com.facebook.imagepipeline.common;
/* loaded from: classes13.dex */
public class e {
    private static final e lRV = new e(-1, false);
    private static final e lRW = new e(-2, false);
    private static final e lRX = new e(-1, true);
    private final boolean lRU;
    private final int mRotation;

    public static e dox() {
        return lRV;
    }

    public static e doy() {
        return lRW;
    }

    public static e doz() {
        return lRX;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.lRU = z;
    }

    public boolean doA() {
        return this.mRotation == -1;
    }

    public boolean doB() {
        return this.mRotation != -2;
    }

    public int doC() {
        if (doA()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean doD() {
        return this.lRU;
    }

    public int hashCode() {
        return com.facebook.common.util.a.g(Integer.valueOf(this.mRotation), Boolean.valueOf(this.lRU));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.lRU == eVar.lRU;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.lRU));
    }
}
