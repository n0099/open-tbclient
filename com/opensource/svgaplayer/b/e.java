package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] ngh = new int[ImageView.ScaleType.values().length];

    static {
        ngh[ImageView.ScaleType.CENTER.ordinal()] = 1;
        ngh[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        ngh[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        ngh[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        ngh[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        ngh[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        ngh[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
