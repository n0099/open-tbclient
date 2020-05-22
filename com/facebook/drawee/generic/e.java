package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import com.facebook.common.internal.g;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.j;
import com.facebook.drawee.drawable.k;
import com.facebook.drawee.drawable.l;
import com.facebook.drawee.drawable.n;
import com.facebook.drawee.drawable.o;
import com.facebook.drawee.drawable.p;
import com.facebook.drawee.generic.RoundingParams;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class e {
    private static final Drawable mqM = new ColorDrawable(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Drawable f(@Nullable Drawable drawable, @Nullable p.b bVar) {
        return a(drawable, bVar, (PointF) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Drawable a(@Nullable Drawable drawable, @Nullable p.b bVar, @Nullable PointF pointF) {
        if (drawable != null && bVar != null) {
            o oVar = new o(drawable, bVar);
            if (pointF != null) {
                oVar.d(pointF);
            }
            return oVar;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a(com.facebook.drawee.drawable.c cVar, p.b bVar) {
        Drawable f = f(cVar.setDrawable(mqM), bVar);
        cVar.setDrawable(f);
        g.checkNotNull(f, "Parent has no child drawable!");
        return (o) f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.facebook.drawee.drawable.c cVar, @Nullable RoundingParams roundingParams) {
        Drawable drawable = cVar.getDrawable();
        if (roundingParams != null && roundingParams.dwJ() == RoundingParams.RoundingMethod.OVERLAY_COLOR) {
            if (drawable instanceof RoundedCornersDrawable) {
                RoundedCornersDrawable roundedCornersDrawable = (RoundedCornersDrawable) drawable;
                a((j) roundedCornersDrawable, roundingParams);
                roundedCornersDrawable.setOverlayColor(roundingParams.dwK());
                return;
            }
            cVar.setDrawable(a(cVar.setDrawable(mqM), roundingParams));
        } else if (drawable instanceof RoundedCornersDrawable) {
            cVar.setDrawable(((RoundedCornersDrawable) drawable).setCurrent(mqM));
            mqM.setCallback(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.facebook.drawee.drawable.c cVar, @Nullable RoundingParams roundingParams, Resources resources) {
        com.facebook.drawee.drawable.c a = a(cVar);
        Drawable drawable = a.getDrawable();
        if (roundingParams != null && roundingParams.dwJ() == RoundingParams.RoundingMethod.BITMAP_ONLY) {
            if (drawable instanceof j) {
                a((j) drawable, roundingParams);
            } else if (drawable != null) {
                a.setDrawable(mqM);
                a.setDrawable(b(drawable, roundingParams, resources));
            }
        } else if (drawable instanceof j) {
            a((j) drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable a(@Nullable Drawable drawable, @Nullable RoundingParams roundingParams) {
        if (drawable != null && roundingParams != null && roundingParams.dwJ() == RoundingParams.RoundingMethod.OVERLAY_COLOR) {
            RoundedCornersDrawable roundedCornersDrawable = new RoundedCornersDrawable(drawable);
            a((j) roundedCornersDrawable, roundingParams);
            roundedCornersDrawable.setOverlayColor(roundingParams.dwK());
            return roundedCornersDrawable;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable a(@Nullable Drawable drawable, @Nullable RoundingParams roundingParams, Resources resources) {
        if (drawable != null && roundingParams != null && roundingParams.dwJ() == RoundingParams.RoundingMethod.BITMAP_ONLY) {
            if (drawable instanceof com.facebook.drawee.drawable.g) {
                com.facebook.drawee.drawable.c a = a((com.facebook.drawee.drawable.g) drawable);
                a.setDrawable(b(a.setDrawable(mqM), roundingParams, resources));
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
        } else if (drawable instanceof NinePatchDrawable) {
            n nVar = new n((NinePatchDrawable) drawable);
            a((j) nVar, roundingParams);
            return nVar;
        } else if ((drawable instanceof ColorDrawable) && Build.VERSION.SDK_INT >= 11) {
            l a = l.a((ColorDrawable) drawable);
            a((j) a, roundingParams);
            return a;
        } else {
            com.facebook.common.c.a.k("WrappingUtils", "Don't know how to round that drawable: %s", drawable);
            return drawable;
        }
    }

    static void a(j jVar, RoundingParams roundingParams) {
        jVar.wb(roundingParams.dwH());
        jVar.y(roundingParams.dwI());
        jVar.n(roundingParams.getBorderColor(), roundingParams.getBorderWidth());
        jVar.aB(roundingParams.dwN());
        jVar.wc(roundingParams.dwO());
    }

    static void a(j jVar) {
        jVar.wb(false);
        jVar.setRadius(0.0f);
        jVar.n(0, 0.0f);
        jVar.aB(0.0f);
        jVar.wc(false);
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
