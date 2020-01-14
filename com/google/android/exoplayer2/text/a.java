package com.google.android.exoplayer2.text;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes5.dex */
public final class a {
    public static final a mxO = new a(-1, ViewCompat.MEASURED_STATE_MASK, 0, 0, -1, null);
    public final int backgroundColor;
    public final int foregroundColor;
    public final int mxP;
    public final int mxQ;
    public final int mxR;
    public final Typeface typeface;

    @TargetApi(19)
    public static a a(CaptioningManager.CaptionStyle captionStyle) {
        return v.SDK_INT >= 21 ? c(captionStyle) : b(captionStyle);
    }

    public a(int i, int i2, int i3, int i4, int i5, Typeface typeface) {
        this.foregroundColor = i;
        this.backgroundColor = i2;
        this.mxP = i3;
        this.mxQ = i4;
        this.mxR = i5;
        this.typeface = typeface;
    }

    @TargetApi(19)
    private static a b(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @TargetApi(21)
    private static a c(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : mxO.foregroundColor, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : mxO.backgroundColor, captionStyle.hasWindowColor() ? captionStyle.windowColor : mxO.mxP, captionStyle.hasEdgeType() ? captionStyle.edgeType : mxO.mxQ, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : mxO.mxR, captionStyle.getTypeface());
    }
}
