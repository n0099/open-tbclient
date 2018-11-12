package com.facebook.imagepipeline.common;
/* loaded from: classes2.dex */
public class c {
    public final int height;
    public final float ifv;
    public final float ifw;
    public final int width;

    public int hashCode() {
        return com.facebook.common.util.a.hashCode(this.width, this.height);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.width == cVar.width && this.height == cVar.height;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%dx%d", Integer.valueOf(this.width), Integer.valueOf(this.height));
    }
}
