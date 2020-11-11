package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import com.facebook.fresco.animation.a.a;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class b<T extends a> implements a {
    @IntRange(from = -1, to = 255)
    private int mAlpha = -1;
    @Nullable
    private Rect mBounds;
    @Nullable
    private ColorFilter mColorFilter;
    @Nullable
    private T oRb;

    public b(@Nullable T t) {
        this.oRb = t;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        if (this.oRb == null) {
            return 0;
        }
        return this.oRb.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int OR(int i) {
        if (this.oRb == null) {
            return 0;
        }
        return this.oRb.OR(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        if (this.oRb == null) {
            return 0;
        }
        return this.oRb.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        return this.oRb != null && this.oRb.a(drawable, canvas, i);
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        if (this.oRb != null) {
            this.oRb.setAlpha(i);
        }
        this.mAlpha = i;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.oRb != null) {
            this.oRb.setColorFilter(colorFilter);
        }
        this.mColorFilter = colorFilter;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setBounds(@Nullable Rect rect) {
        if (this.oRb != null) {
            this.oRb.setBounds(rect);
        }
        this.mBounds = rect;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void clear() {
        if (this.oRb != null) {
            this.oRb.clear();
        }
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicWidth() {
        if (this.oRb == null) {
            return -1;
        }
        return this.oRb.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicHeight() {
        if (this.oRb == null) {
            return -1;
        }
        return this.oRb.getIntrinsicHeight();
    }
}
