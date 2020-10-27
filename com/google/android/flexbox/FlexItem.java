package com.google.android.flexbox;

import android.os.Parcelable;
/* loaded from: classes9.dex */
interface FlexItem extends Parcelable {
    public static final float FLEX_BASIS_PERCENT_DEFAULT = -1.0f;
    public static final float FLEX_GROW_DEFAULT = 0.0f;
    public static final float FLEX_SHRINK_DEFAULT = 1.0f;
    public static final int MAX_SIZE = 16777215;
    public static final int ORDER_DEFAULT = 1;

    int eor();

    boolean eos();

    float eot();

    int eou();

    int eov();

    float getFlexGrow();

    float getFlexShrink();

    int getHeight();

    int getMarginLeft();

    int getMarginRight();

    int getMaxHeight();

    int getMaxWidth();

    int getMinHeight();

    int getMinWidth();

    int getOrder();

    int getWidth();
}
