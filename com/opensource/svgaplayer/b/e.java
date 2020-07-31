package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
@h
/* loaded from: classes8.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] nKI = new int[ImageView.ScaleType.values().length];

    static {
        nKI[ImageView.ScaleType.CENTER.ordinal()] = 1;
        nKI[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        nKI[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        nKI[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        nKI[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        nKI[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        nKI[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
