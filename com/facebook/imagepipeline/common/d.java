package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d idO = new d(-1, false);
    private static final d idP = new d(-2, false);
    private static final d idQ = new d(-1, true);
    private final boolean idN;
    private final int mRotation;

    public static d bUM() {
        return idO;
    }

    public static d bUN() {
        return idQ;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.idN = z;
    }

    public boolean bUO() {
        return this.mRotation == -1;
    }

    public boolean bUP() {
        return this.mRotation != -2;
    }

    public int bUQ() {
        if (bUO()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean bUR() {
        return this.idN;
    }

    public int hashCode() {
        return com.facebook.common.util.a.f(Integer.valueOf(this.mRotation), Boolean.valueOf(this.idN));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.idN == dVar.idN;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.idN));
    }
}
