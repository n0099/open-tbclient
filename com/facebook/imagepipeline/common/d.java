package com.facebook.imagepipeline.common;

import com.facebook.common.internal.g;
/* loaded from: classes12.dex */
public class d {
    public final int height;
    public final float oLr;
    public final float oLs;
    public final int width;

    public d(int i, int i2) {
        this(i, i2, 2048.0f);
    }

    public d(int i, int i2, float f) {
        this(i, i2, f, 0.6666667f);
    }

    public d(int i, int i2, float f, float f2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.width = i;
        this.height = i2;
        this.oLr = f;
        this.oLs = f2;
    }

    public int hashCode() {
        return com.facebook.common.util.a.hashCode(this.width, this.height);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.width == dVar.width && this.height == dVar.height;
        }
        return false;
    }

    public String toString() {
        return String.format(null, "%dx%d", Integer.valueOf(this.width), Integer.valueOf(this.height));
    }
}
