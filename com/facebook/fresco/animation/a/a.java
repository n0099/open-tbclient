package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public interface a extends d {
    boolean a(Drawable drawable, Canvas canvas, int i);

    void clear();

    int getIntrinsicHeight();

    int getIntrinsicWidth();

    void setAlpha(@IntRange(from = 0, to = 255) int i);

    void setBounds(Rect rect);

    void setColorFilter(@Nullable ColorFilter colorFilter);
}
