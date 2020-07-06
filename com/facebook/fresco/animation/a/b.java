package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import com.facebook.fresco.animation.a.a;
import javax.annotation.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes13.dex */
public class b<T extends a> implements a {
    @IntRange(from = -1, to = IjkMediaMeta.AV_CH_LAYOUT_7POINT1_WIDE_BACK)
    private int mAlpha = -1;
    @Nullable
    private Rect mBounds;
    @Nullable
    private ColorFilter mColorFilter;
    @Nullable
    private T mOG;

    public b(@Nullable T t) {
        this.mOG = t;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        if (this.mOG == null) {
            return 0;
        }
        return this.mOG.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Iv(int i) {
        if (this.mOG == null) {
            return 0;
        }
        return this.mOG.Iv(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        if (this.mOG == null) {
            return 0;
        }
        return this.mOG.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        return this.mOG != null && this.mOG.a(drawable, canvas, i);
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        if (this.mOG != null) {
            this.mOG.setAlpha(i);
        }
        this.mAlpha = i;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mOG != null) {
            this.mOG.setColorFilter(colorFilter);
        }
        this.mColorFilter = colorFilter;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setBounds(@Nullable Rect rect) {
        if (this.mOG != null) {
            this.mOG.setBounds(rect);
        }
        this.mBounds = rect;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void clear() {
        if (this.mOG != null) {
            this.mOG.clear();
        }
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicWidth() {
        if (this.mOG == null) {
            return -1;
        }
        return this.mOG.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicHeight() {
        if (this.mOG == null) {
            return -1;
        }
        return this.mOG.getIntrinsicHeight();
    }
}
