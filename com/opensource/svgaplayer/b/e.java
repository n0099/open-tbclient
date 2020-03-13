package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] nms = new int[ImageView.ScaleType.values().length];

    static {
        nms[ImageView.ScaleType.CENTER.ordinal()] = 1;
        nms[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        nms[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        nms[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        nms[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        nms[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        nms[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
