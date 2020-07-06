package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] nCa = new int[ImageView.ScaleType.values().length];

    static {
        nCa[ImageView.ScaleType.CENTER.ordinal()] = 1;
        nCa[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        nCa[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        nCa[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        nCa[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        nCa[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        nCa[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
