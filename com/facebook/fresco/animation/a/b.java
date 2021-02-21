package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import com.facebook.fresco.animation.a.a;
import com.kwai.video.player.KsMediaMeta;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class b<T extends a> implements a {
    @IntRange(from = -1, to = KsMediaMeta.AV_CH_LAYOUT_7POINT1_WIDE_BACK)
    private int mAlpha = -1;
    @Nullable
    private Rect mBounds;
    @Nullable
    private ColorFilter mColorFilter;
    @Nullable
    private T pEZ;

    public b(@Nullable T t) {
        this.pEZ = t;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        if (this.pEZ == null) {
            return 0;
        }
        return this.pEZ.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int Pt(int i) {
        if (this.pEZ == null) {
            return 0;
        }
        return this.pEZ.Pt(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        if (this.pEZ == null) {
            return 0;
        }
        return this.pEZ.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        return this.pEZ != null && this.pEZ.a(drawable, canvas, i);
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        if (this.pEZ != null) {
            this.pEZ.setAlpha(i);
        }
        this.mAlpha = i;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.pEZ != null) {
            this.pEZ.setColorFilter(colorFilter);
        }
        this.mColorFilter = colorFilter;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setBounds(@Nullable Rect rect) {
        if (this.pEZ != null) {
            this.pEZ.setBounds(rect);
        }
        this.mBounds = rect;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void clear() {
        if (this.pEZ != null) {
            this.pEZ.clear();
        }
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicWidth() {
        if (this.pEZ == null) {
            return -1;
        }
        return this.pEZ.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicHeight() {
        if (this.pEZ == null) {
            return -1;
        }
        return this.pEZ.getIntrinsicHeight();
    }
}
