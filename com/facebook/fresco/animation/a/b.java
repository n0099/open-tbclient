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
    private T pur;

    public b(@Nullable T t) {
        this.pur = t;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        if (this.pur == null) {
            return 0;
        }
        return this.pur.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int OX(int i) {
        if (this.pur == null) {
            return 0;
        }
        return this.pur.OX(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        if (this.pur == null) {
            return 0;
        }
        return this.pur.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        return this.pur != null && this.pur.a(drawable, canvas, i);
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        if (this.pur != null) {
            this.pur.setAlpha(i);
        }
        this.mAlpha = i;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.pur != null) {
            this.pur.setColorFilter(colorFilter);
        }
        this.mColorFilter = colorFilter;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setBounds(@Nullable Rect rect) {
        if (this.pur != null) {
            this.pur.setBounds(rect);
        }
        this.mBounds = rect;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void clear() {
        if (this.pur != null) {
            this.pur.clear();
        }
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicWidth() {
        if (this.pur == null) {
            return -1;
        }
        return this.pur.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicHeight() {
        if (this.pur == null) {
            return -1;
        }
        return this.pur.getIntrinsicHeight();
    }
}
