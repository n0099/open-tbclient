package com.facebook.fresco.animation.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import com.facebook.fresco.animation.a.a;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class b<T extends a> implements a {
    @IntRange(from = -1, to = 255)
    private int mAlpha = -1;
    @Nullable
    private Rect mBounds;
    @Nullable
    private ColorFilter mColorFilter;
    @Nullable
    private T mWS;

    public b(@Nullable T t) {
        this.mWS = t;
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getFrameCount() {
        if (this.mWS == null) {
            return 0;
        }
        return this.mWS.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.a.d
    public int IQ(int i) {
        if (this.mWS == null) {
            return 0;
        }
        return this.mWS.IQ(i);
    }

    @Override // com.facebook.fresco.animation.a.d
    public int getLoopCount() {
        if (this.mWS == null) {
            return 0;
        }
        return this.mWS.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.a.a
    public boolean a(Drawable drawable, Canvas canvas, int i) {
        return this.mWS != null && this.mWS.a(drawable, canvas, i);
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        if (this.mWS != null) {
            this.mWS.setAlpha(i);
        }
        this.mAlpha = i;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mWS != null) {
            this.mWS.setColorFilter(colorFilter);
        }
        this.mColorFilter = colorFilter;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void setBounds(@Nullable Rect rect) {
        if (this.mWS != null) {
            this.mWS.setBounds(rect);
        }
        this.mBounds = rect;
    }

    @Override // com.facebook.fresco.animation.a.a
    public void clear() {
        if (this.mWS != null) {
            this.mWS.clear();
        }
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicWidth() {
        if (this.mWS == null) {
            return -1;
        }
        return this.mWS.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.a.a
    public int getIntrinsicHeight() {
        if (this.mWS == null) {
            return -1;
        }
        return this.mWS.getIntrinsicHeight();
    }
}
