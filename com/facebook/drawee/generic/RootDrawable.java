package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class RootDrawable extends ForwardingDrawable implements VisibilityAwareDrawable {
    public static ColorFilter sGlobalColorFilter;
    public ColorFilter mColorFilter;
    @VisibleForTesting
    @Nullable
    public Drawable mControllerOverlay;
    public boolean mUserGlobalColorFilter;
    @Nullable
    public VisibilityCallback mVisibilityCallback;

    public RootDrawable(Drawable drawable) {
        super(drawable);
        this.mControllerOverlay = null;
        this.mColorFilter = null;
        this.mUserGlobalColorFilter = true;
    }

    public static ColorFilter getGlobalColorFilter() {
        return sGlobalColorFilter;
    }

    public static void setGlobalColorFilter(ColorFilter colorFilter) {
        sGlobalColorFilter = colorFilter;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        ColorFilter colorFilter;
        if (isVisible()) {
            if (this.mUserGlobalColorFilter && (colorFilter = sGlobalColorFilter) != this.mColorFilter) {
                this.mColorFilter = colorFilter;
                setColorFilter(colorFilter);
            }
            VisibilityCallback visibilityCallback = this.mVisibilityCallback;
            if (visibilityCallback != null) {
                visibilityCallback.onDraw();
            }
            super.draw(canvas);
            Drawable drawable = this.mControllerOverlay;
            if (drawable != null) {
                drawable.setBounds(getBounds());
                this.mControllerOverlay.draw(canvas);
            }
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    public boolean getUseGlobalColorFilter() {
        return this.mUserGlobalColorFilter;
    }

    public void setControllerOverlay(@Nullable Drawable drawable) {
        this.mControllerOverlay = drawable;
        invalidateSelf();
    }

    public void setUseGlobalColorFilter(boolean z) {
        this.mUserGlobalColorFilter = z;
    }

    @Override // com.facebook.drawee.drawable.VisibilityAwareDrawable
    public void setVisibilityCallback(@Nullable VisibilityCallback visibilityCallback) {
        this.mVisibilityCallback = visibilityCallback;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        VisibilityCallback visibilityCallback = this.mVisibilityCallback;
        if (visibilityCallback != null) {
            visibilityCallback.onVisibilityChange(z);
        }
        return super.setVisible(z, z2);
    }
}
