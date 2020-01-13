package com.opensource.svgaplayer.b;

import android.widget.ImageView;
/* loaded from: classes.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] nlz = new int[ImageView.ScaleType.values().length];

    static {
        nlz[ImageView.ScaleType.CENTER.ordinal()] = 1;
        nlz[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        nlz[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        nlz[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        nlz[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        nlz[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        nlz[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
