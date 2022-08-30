package com.facebook.drawee.drawable;

import android.graphics.ColorFilter;
/* loaded from: classes7.dex */
public interface Rounded {
    int getBorderColor();

    float getBorderWidth();

    float getPadding();

    boolean getPaintFilterBitmap();

    float[] getRadii();

    boolean getScaleDownInsideBorders();

    boolean isCircle();

    void setBorder(int i, float f);

    void setBorderColorFilter(ColorFilter colorFilter);

    void setCircle(boolean z);

    void setPadding(float f);

    void setPaintFilterBitmap(boolean z);

    void setRadii(float[] fArr);

    void setRadius(float f);

    void setScaleDownInsideBorders(boolean z);
}
