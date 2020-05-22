package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] neX = new int[ImageView.ScaleType.values().length];

    static {
        neX[ImageView.ScaleType.CENTER.ordinal()] = 1;
        neX[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        neX[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        neX[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        neX[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        neX[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        neX[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
