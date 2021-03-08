package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import com.facebook.fresco.animation.a.a;
import com.kwai.video.player.KsMediaMeta;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class b<T extends a> implements a {
    @IntRange(from = -1, to = KsMediaMeta.AV_CH_LAYOUT_7POINT1_WIDE_BACK)
    private int mAlpha = -1;
    @Nullable
    private Rect mBounds;
    @Nullable
    private ColorFilter mColorFilter;
    @Nullable
    private T pHe;

    public b(@Nullable T t) {
        this.pHe = t;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        if (this.pHe == null) {
            return 0;
        }
        return this.pHe.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Px(int i) {
        if (this.pHe == null) {
            return 0;
        }
        return this.pHe.Px(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        if (this.pHe == null) {
            return 0;
        }
        return this.pHe.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        return this.pHe != null && this.pHe.a(drawable, canvas, i);
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        if (this.pHe != null) {
            this.pHe.setAlpha(i);
        }
        this.mAlpha = i;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.pHe != null) {
            this.pHe.setColorFilter(colorFilter);
        }
        this.mColorFilter = colorFilter;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setBounds(@Nullable Rect rect) {
        if (this.pHe != null) {
            this.pHe.setBounds(rect);
        }
        this.mBounds = rect;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void clear() {
        if (this.pHe != null) {
            this.pHe.clear();
        }
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicWidth() {
        if (this.pHe == null) {
            return -1;
        }
        return this.pHe.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicHeight() {
        if (this.pHe == null) {
            return -1;
        }
        return this.pHe.getIntrinsicHeight();
    }
}
