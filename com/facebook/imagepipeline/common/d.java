package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private final boolean ifx;
    private final int mRotation;
    private static final d ify = new d(-1, false);
    private static final d ifz = new d(-2, false);
    private static final d ifA = new d(-1, true);

    public static d bUh() {
        return ify;
    }

    public static d bUi() {
        return ifA;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.ifx = z;
    }

    public boolean bUj() {
        return this.mRotation == -1;
    }

    public boolean bUk() {
        return this.mRotation != -2;
    }

    public int bUl() {
        if (bUj()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean bUm() {
        return this.ifx;
    }

    public int hashCode() {
        return com.facebook.common.util.a.f(Integer.valueOf(this.mRotation), Boolean.valueOf(this.ifx));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.ifx == dVar.ifx;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.ifx));
    }
}
