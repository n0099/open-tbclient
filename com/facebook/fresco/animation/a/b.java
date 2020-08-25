package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import com.facebook.fresco.animation.a.a;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class b<T extends a> implements a {
    @IntRange(from = -1, to = 255)
    private int mAlpha = -1;
    @Nullable
    private Rect mBounds;
    @Nullable
    private ColorFilter mColorFilter;
    @Nullable
    private T nqH;

    public b(@Nullable T t) {
        this.nqH = t;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        if (this.nqH == null) {
            return 0;
        }
        return this.nqH.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Lu(int i) {
        if (this.nqH == null) {
            return 0;
        }
        return this.nqH.Lu(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        if (this.nqH == null) {
            return 0;
        }
        return this.nqH.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        return this.nqH != null && this.nqH.a(drawable, canvas, i);
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        if (this.nqH != null) {
            this.nqH.setAlpha(i);
        }
        this.mAlpha = i;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.nqH != null) {
            this.nqH.setColorFilter(colorFilter);
        }
        this.mColorFilter = colorFilter;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setBounds(@Nullable Rect rect) {
        if (this.nqH != null) {
            this.nqH.setBounds(rect);
        }
        this.mBounds = rect;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void clear() {
        if (this.nqH != null) {
            this.nqH.clear();
        }
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicWidth() {
        if (this.nqH == null) {
            return -1;
        }
        return this.nqH.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicHeight() {
        if (this.nqH == null) {
            return -1;
        }
        return this.nqH.getIntrinsicHeight();
    }
}
