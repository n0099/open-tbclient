package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import com.facebook.fresco.animation.a.a;
import com.kwai.video.player.KsMediaMeta;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class b<T extends a> implements a {
    @IntRange(from = -1, to = KsMediaMeta.AV_CH_LAYOUT_7POINT1_WIDE_BACK)
    private int mAlpha = -1;
    @Nullable
    private Rect mBounds;
    @Nullable
    private ColorFilter mColorFilter;
    @Nullable
    private T pyR;

    public b(@Nullable T t) {
        this.pyR = t;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        if (this.pyR == null) {
            return 0;
        }
        return this.pyR.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int QE(int i) {
        if (this.pyR == null) {
            return 0;
        }
        return this.pyR.QE(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        if (this.pyR == null) {
            return 0;
        }
        return this.pyR.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        return this.pyR != null && this.pyR.a(drawable, canvas, i);
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        if (this.pyR != null) {
            this.pyR.setAlpha(i);
        }
        this.mAlpha = i;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.pyR != null) {
            this.pyR.setColorFilter(colorFilter);
        }
        this.mColorFilter = colorFilter;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setBounds(@Nullable Rect rect) {
        if (this.pyR != null) {
            this.pyR.setBounds(rect);
        }
        this.mBounds = rect;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void clear() {
        if (this.pyR != null) {
            this.pyR.clear();
        }
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicWidth() {
        if (this.pyR == null) {
            return -1;
        }
        return this.pyR.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicHeight() {
        if (this.pyR == null) {
            return -1;
        }
        return this.pyR.getIntrinsicHeight();
    }
}
