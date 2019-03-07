package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d jGI = new d(-1, false);
    private static final d jGJ = new d(-2, false);
    private static final d jGK = new d(-1, true);
    private final boolean jGH;
    private final int mRotation;

    public static d cwM() {
        return jGI;
    }

    public static d cwN() {
        return jGK;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.jGH = z;
    }

    public boolean cwO() {
        return this.mRotation == -1;
    }

    public boolean cwP() {
        return this.mRotation != -2;
    }

    public int cwQ() {
        if (cwO()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean cwR() {
        return this.jGH;
    }

    public int hashCode() {
        return com.facebook.common.util.a.f(Integer.valueOf(this.mRotation), Boolean.valueOf(this.jGH));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.jGH == dVar.jGH;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.jGH));
    }
}
