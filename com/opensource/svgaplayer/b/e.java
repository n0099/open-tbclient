package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
@h
/* loaded from: classes15.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] pEM = new int[ImageView.ScaleType.values().length];

    static {
        pEM[ImageView.ScaleType.CENTER.ordinal()] = 1;
        pEM[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        pEM[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        pEM[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        pEM[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        pEM[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        pEM[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
