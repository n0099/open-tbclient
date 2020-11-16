package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
@h
/* loaded from: classes17.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] pGp = new int[ImageView.ScaleType.values().length];

    static {
        pGp[ImageView.ScaleType.CENTER.ordinal()] = 1;
        pGp[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        pGp[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        pGp[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        pGp[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        pGp[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        pGp[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
