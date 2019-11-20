package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class e {
    public static void c(Drawable drawable, Drawable drawable2) {
        if (drawable2 != null && drawable != null && drawable != drawable2) {
            drawable.setBounds(drawable2.getBounds());
            drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
            drawable.setLevel(drawable2.getLevel());
            drawable.setVisible(drawable2.isVisible(), false);
            drawable.setState(drawable2.getState());
        }
    }

    public static void a(Drawable drawable, d dVar) {
        if (drawable != null && dVar != null) {
            dVar.h(drawable);
        }
    }

    public static void a(Drawable drawable, @Nullable Drawable.Callback callback, @Nullable p pVar) {
        if (drawable != null) {
            drawable.setCallback(callback);
            if (drawable instanceof o) {
                ((o) drawable).a(pVar);
            }
        }
    }

    public static int cC(int i, int i2) {
        if (i2 != 255) {
            if (i2 == 0) {
                return i & ViewCompat.MEASURED_SIZE_MASK;
            }
            return (((((i2 >> 7) + i2) * (i >>> 24)) >> 8) << 24) | (i & ViewCompat.MEASURED_SIZE_MASK);
        }
        return i;
    }

    public static int Cf(int i) {
        int i2 = i >>> 24;
        if (i2 == 255) {
            return -1;
        }
        if (i2 == 0) {
            return -2;
        }
        return -3;
    }
}
