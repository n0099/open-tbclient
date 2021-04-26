package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class DrawableUtils {
    @Nullable
    public static Drawable cloneDrawable(Drawable drawable) {
        if (drawable instanceof CloneableDrawable) {
            return ((CloneableDrawable) drawable).cloneDrawable();
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            return constantState.newDrawable();
        }
        return null;
    }

    public static void copyProperties(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        if (drawable2 == null || drawable == null || drawable == drawable2) {
            return;
        }
        drawable.setBounds(drawable2.getBounds());
        drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
        drawable.setLevel(drawable2.getLevel());
        drawable.setVisible(drawable2.isVisible(), false);
        drawable.setState(drawable2.getState());
    }

    public static int getOpacityFromColor(int i2) {
        int i3 = i2 >>> 24;
        if (i3 == 255) {
            return -1;
        }
        return i3 == 0 ? -2 : -3;
    }

    public static int multiplyColorAlpha(int i2, int i3) {
        if (i3 == 255) {
            return i2;
        }
        if (i3 == 0) {
            return i2 & ViewCompat.MEASURED_SIZE_MASK;
        }
        int i4 = i3 + (i3 >> 7);
        return (i2 & ViewCompat.MEASURED_SIZE_MASK) | ((((i2 >>> 24) * i4) >> 8) << 24);
    }

    public static void setCallbacks(@Nullable Drawable drawable, @Nullable Drawable.Callback callback, @Nullable TransformCallback transformCallback) {
        if (drawable != null) {
            drawable.setCallback(callback);
            if (drawable instanceof TransformAwareDrawable) {
                ((TransformAwareDrawable) drawable).setTransformCallback(transformCallback);
            }
        }
    }

    public static void setDrawableProperties(@Nullable Drawable drawable, @Nullable DrawableProperties drawableProperties) {
        if (drawable == null || drawableProperties == null) {
            return;
        }
        drawableProperties.applyTo(drawable);
    }
}
