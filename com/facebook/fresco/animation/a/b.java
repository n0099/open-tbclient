package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import com.facebook.fresco.animation.a.a;
import javax.annotation.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes12.dex */
public class b<T extends a> implements a {
    @Nullable
    private T lNs;
    @IntRange(from = -1, to = IjkMediaMeta.AV_CH_LAYOUT_7POINT1_WIDE_BACK)
    private int mAlpha = -1;
    @Nullable
    private Rect mBounds;
    @Nullable
    private ColorFilter mColorFilter;

    public b(@Nullable T t) {
        this.lNs = t;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        if (this.lNs == null) {
            return 0;
        }
        return this.lNs.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int HO(int i) {
        if (this.lNs == null) {
            return 0;
        }
        return this.lNs.HO(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        if (this.lNs == null) {
            return 0;
        }
        return this.lNs.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        return this.lNs != null && this.lNs.a(drawable, canvas, i);
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        if (this.lNs != null) {
            this.lNs.setAlpha(i);
        }
        this.mAlpha = i;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.lNs != null) {
            this.lNs.setColorFilter(colorFilter);
        }
        this.mColorFilter = colorFilter;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setBounds(@Nullable Rect rect) {
        if (this.lNs != null) {
            this.lNs.setBounds(rect);
        }
        this.mBounds = rect;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void clear() {
        if (this.lNs != null) {
            this.lNs.clear();
        }
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicWidth() {
        if (this.lNs == null) {
            return -1;
        }
        return this.lNs.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicHeight() {
        if (this.lNs == null) {
            return -1;
        }
        return this.lNs.getIntrinsicHeight();
    }
}
