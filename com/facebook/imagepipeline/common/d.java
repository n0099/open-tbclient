package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d jGn = new d(-1, false);
    private static final d jGo = new d(-2, false);
    private static final d jGp = new d(-1, true);
    private final boolean jGm;
    private final int mRotation;

    public static d cwS() {
        return jGn;
    }

    public static d cwT() {
        return jGp;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.jGm = z;
    }

    public boolean cwU() {
        return this.mRotation == -1;
    }

    public boolean cwV() {
        return this.mRotation != -2;
    }

    public int cwW() {
        if (cwU()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean cwX() {
        return this.jGm;
    }

    public int hashCode() {
        return com.facebook.common.util.a.f(Integer.valueOf(this.mRotation), Boolean.valueOf(this.jGm));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.jGm == dVar.jGm;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.jGm));
    }
}
