package com.facebook.imagepipeline.common;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.HashCodeUtil;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class ResizeOptions {
    public static final float DEFAULT_ROUNDUP_FRACTION = 0.6666667f;
    public final int height;
    public final float maxBitmapSize;
    public final float roundUpFraction;
    public final int width;

    public ResizeOptions(int i2, int i3) {
        this(i2, i3, 2048.0f);
    }

    @Nullable
    public static ResizeOptions forDimensions(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return null;
        }
        return new ResizeOptions(i2, i3);
    }

    @Nullable
    public static ResizeOptions forSquareSize(int i2) {
        if (i2 <= 0) {
            return null;
        }
        return new ResizeOptions(i2, i2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ResizeOptions) {
            ResizeOptions resizeOptions = (ResizeOptions) obj;
            return this.width == resizeOptions.width && this.height == resizeOptions.height;
        }
        return false;
    }

    public int hashCode() {
        return HashCodeUtil.hashCode(this.width, this.height);
    }

    public String toString() {
        return String.format(null, "%dx%d", Integer.valueOf(this.width), Integer.valueOf(this.height));
    }

    public ResizeOptions(int i2, int i3, float f2) {
        this(i2, i3, f2, 0.6666667f);
    }

    public ResizeOptions(int i2, int i3, float f2, float f3) {
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkArgument(i3 > 0);
        this.width = i2;
        this.height = i3;
        this.maxBitmapSize = f2;
        this.roundUpFraction = f3;
    }
}
