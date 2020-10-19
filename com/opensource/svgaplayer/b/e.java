package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
@h
/* loaded from: classes15.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] oDW = new int[ImageView.ScaleType.values().length];

    static {
        oDW[ImageView.ScaleType.CENTER.ordinal()] = 1;
        oDW[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        oDW[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        oDW[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        oDW[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        oDW[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        oDW[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
