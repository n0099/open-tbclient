package com.facebook.imagepipeline.common;
/* loaded from: classes12.dex */
public class e {
    private static final e oLu = new e(-1, false);
    private static final e oLv = new e(-2, false);
    private static final e oLw = new e(-1, true);
    private final int mRotation;
    private final boolean oLt;

    public static e ekf() {
        return oLu;
    }

    public static e ekg() {
        return oLv;
    }

    public static e ekh() {
        return oLw;
    }

    private e(int i, boolean z) {
        this.mRotation = i;
        this.oLt = z;
    }

    public boolean eki() {
        return this.mRotation == -1;
    }

    public boolean ekj() {
        return this.mRotation != -2;
    }

    public int ekk() {
        if (eki()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean ekl() {
        return this.oLt;
    }

    public int hashCode() {
        return com.facebook.common.util.a.h(Integer.valueOf(this.mRotation), Boolean.valueOf(this.oLt));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.mRotation == eVar.mRotation && this.oLt == eVar.oLt;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.oLt));
    }
}
