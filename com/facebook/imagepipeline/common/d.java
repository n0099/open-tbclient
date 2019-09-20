package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d kjP = new d(-1, false);
    private static final d kjQ = new d(-2, false);
    private static final d kjR = new d(-1, true);
    private final boolean kjO;
    private final int mRotation;

    public static d cJb() {
        return kjP;
    }

    public static d cJc() {
        return kjR;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.kjO = z;
    }

    public boolean cJd() {
        return this.mRotation == -1;
    }

    public boolean cJe() {
        return this.mRotation != -2;
    }

    public int cJf() {
        if (cJd()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean cJg() {
        return this.kjO;
    }

    public int hashCode() {
        return com.facebook.common.util.a.f(Integer.valueOf(this.mRotation), Boolean.valueOf(this.kjO));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.kjO == dVar.kjO;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.kjO));
    }
}
