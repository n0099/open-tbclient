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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0334a.GenericDraweeHierarchy);
            try {
                int indexCount = obtainStyledAttributes.getIndexCount();
                z = true;
                z2 = true;
                z3 = true;
                i = 0;
                for (int i3 = 0; i3 < indexCount; i3++) {
                    int index = obtainStyledAttributes.getIndex(i3);
                    if (index == a.C0334a.GenericDraweeHierarchy_actualImageScaleType) {
                        bVar.g(a(obtainStyledAttributes, index));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_placeholderImage) {
                        bVar.n(a(context, obtainStyledAttributes, index));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_pressedStateOverlayImage) {
                        bVar.t(a(context, obtainStyledAttributes, index));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_progressBarImage) {
                        bVar.q(a(context, obtainStyledAttributes, index));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_fadeDuration) {
                        bVar.Ci(obtainStyledAttributes.getInt(index, 0));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_viewAspectRatio) {
                        bVar.aW(obtainStyledAttributes.getFloat(index, 0.0f));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_placeholderImageScaleType) {
                        bVar.c(a(obtainStyledAttributes, index));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_retryImage) {
                        bVar.o(a(context, obtainStyledAttributes, index));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_retryImageScaleType) {
                        bVar.d(a(obtainStyledAttributes, index));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_failureImage) {
                        bVar.p(a(context, obtainStyledAttributes, index));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_failureImageScaleType) {
                        bVar.e(a(obtainStyledAttributes, index));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_progressBarImageScaleType) {
                        bVar.f(a(obtainStyledAttributes, index));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_progressBarAutoRotateInterval) {
                        i = obtainStyledAttributes.getInteger(index, i);
                    } else if (index == a.C0334a.GenericDraweeHierarchy_backgroundImage) {
                        bVar.r(a(context, obtainStyledAttributes, index));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_overlayImage) {
                        bVar.s(a(context, obtainStyledAttributes, index));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_roundAsCircle) {
                        a(bVar).ru(obtainStyledAttributes.getBoolean(index, false));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_roundedCornerRadius) {
                        i2 = obtainStyledAttributes.getDimensionPixelSize(index, i2);
                    } else if (index == a.C0334a.GenericDraweeHierarchy_roundTopLeft) {
                        z3 = obtainStyledAttributes.getBoolean(index, z3);
                    } else if (index == a.C0334a.GenericDraweeHierarchy_roundTopRight) {
                        z2 = obtainStyledAttributes.getBoolean(index, z2);
                    } else if (index == a.C0334a.GenericDraweeHierarchy_roundBottomLeft) {
                        z = obtainStyledAttributes.getBoolean(index, z);
                    } else if (index == a.C0334a.GenericDraweeHierarchy_roundBottomRight) {
                        z4 = obtainStyledAttributes.getBoolean(index, z4);
                    } else if (index == a.C0334a.GenericDraweeHierarchy_roundWithOverlayColor) {
                        a(bVar).Cj(obtainStyledAttributes.getColor(index, 0));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_roundingBorderWidth) {
                        a(bVar).aY(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_roundingBorderColor) {
                        a(bVar).Ck(obtainStyledAttributes.getColor(index, 0));
                    } else if (index == a.C0334a.GenericDraweeHierarchy_roundingBorderPadding) {
                        a(bVar).aZ(obtainStyledAttributes.getDimensionPixelSize(index, 0));
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
        if (bVar.cvB() != null && i > 0) {
            bVar.q(new com.facebook.drawee.drawable.b(bVar.cvB(), i));
        }
        if (i2 > 0) {
            a(bVar).k(z3 ? i2 : 0.0f, z2 ? i2 : 0.0f, z4 ? i2 : 0.0f, z ? i2 : 0.0f);
        }
        return bVar;
    }

    @ReturnsOwnership
    private static RoundingParams a(b bVar) {
        if (bVar.cvJ() == null) {
            bVar.b(new RoundingParams());
        }
        return bVar.cvJ();
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
                return n.b.jDB;
            case 1:
                return n.b.jDC;
            case 2:
                return n.b.jDD;
            case 3:
                return n.b.jDE;
            case 4:
                return n.b.jDF;
            case 5:
                return n.b.jDG;
            case 6:
                return n.b.jDH;
            case 7:
                return n.b.jDI;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }
}
