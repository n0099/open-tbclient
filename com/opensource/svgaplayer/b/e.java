package com.opensource.svgaplayer.b;

import android.widget.ImageView;
import kotlin.h;
@h
/* loaded from: classes.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] nmh = new int[ImageView.ScaleType.values().length];

    static {
        nmh[ImageView.ScaleType.CENTER.ordinal()] = 1;
        nmh[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        nmh[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        nmh[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        nmh[ImageView.ScaleType.FIT_START.ordinal()] = 5;
        nmh[ImageView.ScaleType.FIT_END.ordinal()] = 6;
        nmh[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
    }
}
