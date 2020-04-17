package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] mKQ = new int[ImageView.ScaleType.values().length];

    static {
        mKQ[ImageView.ScaleType.CENTER.ordinal()] = 1;
        mKQ[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        mKQ[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        mKQ[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        mKQ[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        mKQ[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        mKQ[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
