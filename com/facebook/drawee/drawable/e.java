package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class e {
    public static void d(Drawable drawable, Drawable drawable2) {
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
            dVar.k(drawable);
        }
    }

    public static void a(Drawable drawable, @Nullable Drawable.Callback callback, @Nullable r rVar) {
        if (drawable != null) {
            drawable.setCallback(callback);
            if (drawable instanceof q) {
                ((q) drawable).setTransformCallback(rVar);
            }
        }
    }

    public static int df(int i, int i2) {
        if (i2 != 255) {
            if (i2 == 0) {
                return i & 16777215;
            }
            return (((((i2 >> 7) + i2) * (i >>> 24)) >> 8) << 24) | (i & 16777215);
        }
        return i;
    }

    public static int Gm(int i) {
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
