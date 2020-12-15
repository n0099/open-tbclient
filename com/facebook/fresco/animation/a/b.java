package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import com.facebook.fresco.animation.a.a;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class b<T extends a> implements a {
    @IntRange(from = -1, to = 255)
    private int mAlpha = -1;
    @Nullable
    private Rect mBounds;
    @Nullable
    private ColorFilter mColorFilter;
    @Nullable
    private T phC;

    public b(@Nullable T t) {
        this.phC = t;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        if (this.phC == null) {
            return 0;
        }
        return this.phC.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Qq(int i) {
        if (this.phC == null) {
            return 0;
        }
        return this.phC.Qq(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        if (this.phC == null) {
            return 0;
        }
        return this.phC.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        return this.phC != null && this.phC.a(drawable, canvas, i);
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        if (this.phC != null) {
            this.phC.setAlpha(i);
        }
        this.mAlpha = i;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.phC != null) {
            this.phC.setColorFilter(colorFilter);
        }
        this.mColorFilter = colorFilter;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setBounds(@Nullable Rect rect) {
        if (this.phC != null) {
            this.phC.setBounds(rect);
        }
        this.mBounds = rect;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void clear() {
        if (this.phC != null) {
            this.phC.clear();
        }
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicWidth() {
        if (this.phC == null) {
            return -1;
        }
        return this.phC.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicHeight() {
        if (this.phC == null) {
            return -1;
        }
        return this.phC.getIntrinsicHeight();
    }
}
