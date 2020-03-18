package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] nof = new int[ImageView.ScaleType.values().length];

    static {
        nof[ImageView.ScaleType.CENTER.ordinal()] = 1;
        nof[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        nof[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        nof[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        nof[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        nof[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        nof[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
