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
    @Nullable
    private T lPS;
    @IntRange(from = -1, to = IjkMediaMeta.AV_CH_LAYOUT_7POINT1_WIDE_BACK)
    private int mAlpha = -1;
    @Nullable
    private Rect mBounds;
    @Nullable
    private ColorFilter mColorFilter;

    public b(@Nullable T t) {
        this.lPS = t;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        if (this.lPS == null) {
            return 0;
        }
        return this.lPS.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int HZ(int i) {
        if (this.lPS == null) {
            return 0;
        }
        return this.lPS.HZ(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        if (this.lPS == null) {
            return 0;
        }
        return this.lPS.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        return this.lPS != null && this.lPS.a(drawable, canvas, i);
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        if (this.lPS != null) {
            this.lPS.setAlpha(i);
        }
        this.mAlpha = i;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.lPS != null) {
            this.lPS.setColorFilter(colorFilter);
        }
        this.mColorFilter = colorFilter;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setBounds(@Nullable Rect rect) {
        if (this.lPS != null) {
            this.lPS.setBounds(rect);
        }
        this.mBounds = rect;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void clear() {
        if (this.lPS != null) {
            this.lPS.clear();
        }
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicWidth() {
        if (this.lPS == null) {
            return -1;
        }
        return this.lPS.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicHeight() {
        if (this.lPS == null) {
            return -1;
        }
        return this.lPS.getIntrinsicHeight();
    }
}
