package com.google.android.exoplayer2.text;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
public final class a {
    public static final a myu = new a(-1, ViewCompat.MEASURED_STATE_MASK, 0, 0, -1, null);
    public final int backgroundColor;
    public final int foregroundColor;
    public final int myv;
    public final int myw;
    public final int myx;
    public final Typeface typeface;

    @TargetApi(19)
    public static a a(CaptioningManager.CaptionStyle captionStyle) {
        return v.SDK_INT >= 21 ? c(captionStyle) : b(captionStyle);
    }

    public a(int i, int i2, int i3, int i4, int i5, Typeface typeface) {
        this.foregroundColor = i;
        this.backgroundColor = i2;
        this.myv = i3;
        this.myw = i4;
        this.myx = i5;
        this.typeface = typeface;
    }

    @TargetApi(19)
    private static a b(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @TargetApi(21)
    private static a c(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : myu.foregroundColor, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : myu.backgroundColor, captionStyle.hasWindowColor() ? captionStyle.windowColor : myu.myv, captionStyle.hasEdgeType() ? captionStyle.edgeType : myu.myw, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : myu.myx, captionStyle.getTypeface());
    }
}
