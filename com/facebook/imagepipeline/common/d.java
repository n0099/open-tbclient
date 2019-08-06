package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class d {
    private static final d khr = new d(-1, false);
    private static final d khs = new d(-2, false);
    private static final d kht = new d(-1, true);
    private final boolean khq;
    private final int mRotation;

    public static d cIn() {
        return khr;
    }

    public static d cIo() {
        return kht;
    }

    private d(int i, boolean z) {
        this.mRotation = i;
        this.khq = z;
    }

    public boolean cIp() {
        return this.mRotation == -1;
    }

    public boolean cIq() {
        return this.mRotation != -2;
    }

    public int cIr() {
        if (cIp()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.mRotation;
    }

    public boolean cIs() {
        return this.khq;
    }

    public int hashCode() {
        return com.facebook.common.util.a.f(Integer.valueOf(this.mRotation), Boolean.valueOf(this.khq));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.mRotation == dVar.mRotation && this.khq == dVar.khq;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.mRotation), Boolean.valueOf(this.khq));
    }
}
