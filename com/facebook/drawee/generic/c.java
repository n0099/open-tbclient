package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.a;
import com.facebook.drawee.drawable.n;
import com.facebook.infer.annotation.ReturnsOwnership;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c {
    public static b k(Context context, @Nullable AttributeSet attributeSet) {
        return a(new b(context.getResources()), context, attributeSet);
    }

    public static b a(b bVar, Context context, @Nullable AttributeSet attributeSet) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        boolean z4 = true;
        int i2 = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0560a.GenericDraweeHierarchy);
            try {
                int indexCount = obtainStyledAttributes.getIndexCount();
                z = true;
                z2 = true;
                z3 = true;
                i = 0;
                for (int i3 = 0; i3 < indexCount; i3++) {
                    int index = obtainStyledAttributes.getIndex(i3);
                    if (index == a.C0560a.GenericDraweeHierarchy_actualImageScaleType) {
                        bVar.g(a(obtainStyledAttributes, index));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_placeholderImage) {
                        bVar.k(a(context, obtainStyledAttributes, index));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_pressedStateOverlayImage) {
                        bVar.q(a(context, obtainStyledAttributes, index));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_progressBarImage) {
                        bVar.n(a(context, obtainStyledAttributes, index));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_fadeDuration) {
                        bVar.Cm(obtainStyledAttributes.getInt(index, 0));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_viewAspectRatio) {
                        bVar.aF(obtainStyledAttributes.getFloat(index, 0.0f));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_placeholderImageScaleType) {
                        bVar.c(a(obtainStyledAttributes, index));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_retryImage) {
                        bVar.l(a(context, obtainStyledAttributes, index));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_retryImageScaleType) {
                        bVar.d(a(obtainStyledAttributes, index));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_failureImage) {
                        bVar.m(a(context, obtainStyledAttributes, index));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_failureImageScaleType) {
                        bVar.e(a(obtainStyledAttributes, index));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_progressBarImageScaleType) {
                        bVar.f(a(obtainStyledAttributes, index));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_progressBarAutoRotateInterval) {
                        i = obtainStyledAttributes.getInteger(index, i);
                    } else if (index == a.C0560a.GenericDraweeHierarchy_backgroundImage) {
                        bVar.o(a(context, obtainStyledAttributes, index));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_overlayImage) {
                        bVar.p(a(context, obtainStyledAttributes, index));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_roundAsCircle) {
                        a(bVar).si(obtainStyledAttributes.getBoolean(index, false));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_roundedCornerRadius) {
                        i2 = obtainStyledAttributes.getDimensionPixelSize(index, i2);
                    } else if (index == a.C0560a.GenericDraweeHierarchy_roundTopLeft) {
                        z3 = obtainStyledAttributes.getBoolean(index, z3);
                    } else if (index == a.C0560a.GenericDraweeHierarchy_roundTopRight) {
                        z2 = obtainStyledAttributes.getBoolean(index, z2);
                    } else if (index == a.C0560a.GenericDraweeHierarchy_roundBottomLeft) {
                        z = obtainStyledAttributes.getBoolean(index, z);
                    } else if (index == a.C0560a.GenericDraweeHierarchy_roundBottomRight) {
                        z4 = obtainStyledAttributes.getBoolean(index, z4);
                    } else if (index == a.C0560a.GenericDraweeHierarchy_roundWithOverlayColor) {
                        a(bVar).Cn(obtainStyledAttributes.getColor(index, 0));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_roundingBorderWidth) {
                        a(bVar).aH(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_roundingBorderColor) {
                        a(bVar).Co(obtainStyledAttributes.getColor(index, 0));
                    } else if (index == a.C0560a.GenericDraweeHierarchy_roundingBorderPadding) {
                        a(bVar).aI(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    }
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            z = true;
            z2 = true;
            z3 = true;
            i = 0;
        }
        if (bVar.cEO() != null && i > 0) {
            bVar.n(new com.facebook.drawee.drawable.b(bVar.cEO(), i));
        }
        if (i2 > 0) {
            a(bVar).j(z3 ? i2 : 0.0f, z2 ? i2 : 0.0f, z4 ? i2 : 0.0f, z ? i2 : 0.0f);
        }
        return bVar;
    }

    @ReturnsOwnership
    private static RoundingParams a(b bVar) {
        if (bVar.cEW() == null) {
            bVar.b(new RoundingParams());
        }
        return bVar.cEW();
    }

    @Nullable
    private static Drawable a(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getResources().getDrawable(resourceId);
    }

    @Nullable
    private static n.b a(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                return n.b.keP;
            case 1:
                return n.b.keQ;
            case 2:
                return n.b.keR;
            case 3:
                return n.b.keS;
            case 4:
                return n.b.keT;
            case 5:
                return n.b.keU;
            case 6:
                return n.b.keV;
            case 7:
                return n.b.keW;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }
}
