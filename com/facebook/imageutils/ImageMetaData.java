package com.facebook.imageutils;

import android.graphics.ColorSpace;
import android.util.Pair;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class ImageMetaData {
    @Nullable
    public final ColorSpace mColorSpace;
    @Nullable
    public final Pair<Integer, Integer> mDimensions;

    public ImageMetaData(int i, int i2, @Nullable ColorSpace colorSpace) {
        Pair<Integer, Integer> pair;
        if (i != -1 && i2 != -1) {
            pair = new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            pair = null;
        }
        this.mDimensions = pair;
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
