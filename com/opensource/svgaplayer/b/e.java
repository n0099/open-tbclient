package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
@h
/* loaded from: classes15.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] pvs = new int[ImageView.ScaleType.values().length];

    static {
        pvs[ImageView.ScaleType.CENTER.ordinal()] = 1;
        pvs[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        pvs[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        pvs[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        pvs[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        pvs[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        pvs[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
