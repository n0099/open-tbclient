package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] nBX = new int[ImageView.ScaleType.values().length];

    static {
        nBX[ImageView.ScaleType.CENTER.ordinal()] = 1;
        nBX[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        nBX[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        nBX[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        nBX[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        nBX[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        nBX[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
