package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] nmf = new int[ImageView.ScaleType.values().length];

    static {
        nmf[ImageView.ScaleType.CENTER.ordinal()] = 1;
        nmf[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        nmf[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        nmf[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        nmf[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        nmf[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        nmf[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
