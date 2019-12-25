package com.opensource.svgaplayer.b;

import android.widget.ImageView;
/* loaded from: classes4.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] mLX = new int[ImageView.ScaleType.values().length];

    static {
        mLX[ImageView.ScaleType.CENTER.ordinal()] = 1;
        mLX[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        mLX[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        mLX[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        mLX[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        mLX[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        mLX[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
