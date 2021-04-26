package com.facebook.imageutils;

import android.graphics.ColorSpace;
import android.util.Pair;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class ImageMetaData {
    @Nullable
    public final ColorSpace mColorSpace;
    @Nullable
    public final Pair<Integer, Integer> mDimensions;

    public ImageMetaData(int i2, int i3, @Nullable ColorSpace colorSpace) {
        this.mDimensions = (i2 == -1 || i3 == -1) ? null : new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
        this.mColorSpace = colorSpace;
    }

    @Nullable
    public ColorSpace getColorSpace() {
        return this.mColorSpace;
    }

    @Nullable
    public Pair<Integer, Integer> getDimensions() {
        return this.mDimensions;
    }
}
