package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.facebook.common.internal.g;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.h;
import com.facebook.drawee.drawable.j;
import com.facebook.drawee.drawable.k;
import com.facebook.drawee.drawable.l;
import com.facebook.drawee.drawable.m;
import com.facebook.drawee.drawable.n;
import com.facebook.drawee.generic.RoundingParams;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class e {
    private static final Drawable keI = new ColorDrawable(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Drawable b(@Nullable Drawable drawable, @Nullable n.b bVar) {
        return a(drawable, bVar, (PointF) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Drawable a(@Nullable Drawable drawable, @Nullable n.b bVar, @Nullable PointF pointF) {
        if (drawable != null && bVar != null) {
            m mVar = new m(drawable, bVar);
            if (pointF != null) {
                mVar.d(pointF);
            }
            return mVar;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Drawable a(@Nullable Drawable drawable, @Nullable Matrix matrix) {
        return (drawable == null || matrix == null) ? drawable : new h(drawable, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(com.facebook.drawee.drawable.c cVar, n.b bVar) {
        Drawable b = b(cVar.g(keI), bVar);
        cVar.g(b);
        g.checkNotNull(b, "Parent has no child drawable!");
        return (m) b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.facebook.drawee.drawable.c cVar, @Nullable RoundingParams roundingParams) {
        Drawable drawable = cVar.getDrawable();
        if (roundingParams != null && roundingParams.cEY() == RoundingParams.RoundingMethod.OVERLAY_COLOR) {
            if (drawable instanceof RoundedCornersDrawable) {
                RoundedCornersDrawable roundedCornersDrawable = (RoundedCornersDrawable) drawable;
                a((j) roundedCornersDrawable, roundingParams);
                roundedCornersDrawable.setOverlayColor(roundingParams.cEZ());
                return;
            }
            cVar.g(a(cVar.g(keI), roundingParams));
        } else if (drawable instanceof RoundedCornersDrawable) {
            cVar.g(((RoundedCornersDrawable) drawable).i(keI));
            keI.setCallback(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.facebook.drawee.drawable.c cVar, @Nullable RoundingParams roundingParams, Resources resources) {
        com.facebook.drawee.drawable.c a = a(cVar);
        Drawable drawable = a.getDrawable();
        if (roundingParams != null && roundingParams.cEY() == RoundingParams.RoundingMethod.BITMAP_ONLY) {
            if (drawable instanceof j) {
                a((j) drawable, roundingParams);
            } else if (drawable != null) {
                a.g(keI);
                a.g(b(drawable, roundingParams, resources));
            }
        } else if (drawable instanceof j) {
            a((j) drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable a(@Nullable Drawable drawable, @Nullable RoundingParams roundingParams) {
        if (drawable != null && roundingParams != null && roundingParams.cEY() == RoundingParams.RoundingMethod.OVERLAY_COLOR) {
            RoundedCornersDrawable roundedCornersDrawable = new RoundedCornersDrawable(drawable);
            a((j) roundedCornersDrawable, roundingParams);
            roundedCornersDrawable.setOverlayColor(roundingParams.cEZ());
            return roundedCornersDrawable;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable a(@Nullable Drawable drawable, @Nullable RoundingParams roundingParams, Resources resources) {
        if (drawable != null && roundingParams != null && roundingParams.cEY() == RoundingParams.RoundingMethod.BITMAP_ONLY) {
            if (drawable instanceof com.facebook.drawee.drawable.g) {
                com.facebook.drawee.drawable.c a = a((com.facebook.drawee.drawable.g) drawable);
                a.g(b(a.g(keI), roundingParams, resources));
                return drawable;
            }
            return b(drawable, roundingParams, resources);
        }
        return drawable;
    }

    private static Drawable b(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            k kVar = new k(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
            a((j) kVar, roundingParams);
            return kVar;
        } else if ((drawable instanceof ColorDrawable) && Build.VERSION.SDK_INT >= 11) {
            l a = l.a((ColorDrawable) drawable);
            a((j) a, roundingParams);
            return a;
        } else {
            return drawable;
        }
    }

    static void a(j jVar, RoundingParams roundingParams) {
        jVar.sg(roundingParams.cEW());
        jVar.j(roundingParams.cEX());
        jVar.m(roundingParams.getBorderColor(), roundingParams.getBorderWidth());
        jVar.aE(roundingParams.cFb());
    }

    static void a(j jVar) {
        jVar.sg(false);
        jVar.setRadius(0.0f);
        jVar.m(0, 0.0f);
        jVar.aE(0.0f);
    }

    static com.facebook.drawee.drawable.c a(com.facebook.drawee.drawable.c cVar) {
        while (true) {
            Drawable drawable = cVar.getDrawable();
            if (drawable == cVar || !(drawable instanceof com.facebook.drawee.drawable.c)) {
                break;
            }
            cVar = (com.facebook.drawee.drawable.c) drawable;
        }
        return cVar;
    }
}
