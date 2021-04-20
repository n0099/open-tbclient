package com.facebook.fresco.animation.backend;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.kwai.video.player.KsMediaMeta;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class AnimationBackendDelegate<T extends AnimationBackend> implements AnimationBackend {
    public static final int ALPHA_UNSET = -1;
    @IntRange(from = -1, to = KsMediaMeta.AV_CH_LAYOUT_7POINT1_WIDE_BACK)
    public int mAlpha = -1;
    @Nullable
    public T mAnimationBackend;
    @Nullable
    public Rect mBounds;
    @Nullable
    public ColorFilter mColorFilter;

    public AnimationBackendDelegate(@Nullable T t) {
        this.mAnimationBackend = t;
    }

    @SuppressLint({"Range"})
    private void applyBackendProperties(AnimationBackend animationBackend) {
        Rect rect = this.mBounds;
        if (rect != null) {
            animationBackend.setBounds(rect);
        }
        int i = this.mAlpha;
        if (i >= 0 && i <= 255) {
            animationBackend.setAlpha(i);
        }
        ColorFilter colorFilter = this.mColorFilter;
        if (colorFilter != null) {
            animationBackend.setColorFilter(colorFilter);
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.clear();
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        T t = this.mAnimationBackend;
        return t != null && t.drawFrame(drawable, canvas, i);
    }

    @Nullable
    public T getAnimationBackend() {
        return this.mAnimationBackend;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i) {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getFrameDurationMs(i);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return -1;
        }
        return t.getIntrinsicHeight();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return -1;
        }
        return t.getIntrinsicWidth();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        T t = this.mAnimationBackend;
        if (t == null) {
            return 0;
        }
        return t.getSizeInBytes();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.setAlpha(i);
        }
        this.mAlpha = i;
    }

    public void setAnimationBackend(@Nullable T t) {
        this.mAnimationBackend = t;
        if (t != null) {
            applyBackendProperties(t);
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(@Nullable Rect rect) {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.setBounds(rect);
        }
        this.mBounds = rect;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(ColorFilter colorFilter) {
        T t = this.mAnimationBackend;
        if (t != null) {
            t.setColorFilter(colorFilter);
        }
        this.mColorFilter = colorFilter;
    }
}
