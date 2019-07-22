package com.facebook.imagepipeline.common;

import com.facebook.common.internal.g;
/* loaded from: classes2.dex */
public class c {
    public final int height;
    public final float kgi;
    public final float kgj;
    public final int width;

    public c(int i, int i2) {
        this(i, i2, 2048.0f);
    }

    public c(int i, int i2, float f) {
        this(i, i2, f, 0.6666667f);
    }

    public c(int i, int i2, float f, float f2) {
        g.checkArgument(i > 0);
        g.checkArgument(i2 > 0);
        this.width = i;
        this.height = i2;
        this.kgi = f;
        this.kgj = f2;
    }

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
