package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import com.facebook.drawee.a;
import com.facebook.drawee.drawable.p;
import com.facebook.infer.annotation.ReturnsOwnership;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class c {
    public static b m(Context context, @Nullable AttributeSet attributeSet) {
        return a(new b(context.getResources()), context, attributeSet);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [224=4] */
    public static b a(b bVar, Context context, @Nullable AttributeSet attributeSet) {
        boolean z;
        boolean z2;
        boolean z3;
        Throwable th;
        boolean z4;
        int i = 0;
        int i2 = 0;
        boolean z5 = true;
        boolean z6 = true;
        boolean z7 = true;
        boolean z8 = true;
        boolean z9 = true;
        boolean z10 = true;
        boolean z11 = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C1061a.GenericDraweeHierarchy);
            try {
                int indexCount = obtainStyledAttributes.getIndexCount();
                boolean z12 = true;
                for (int i3 = 0; i3 < indexCount; i3++) {
                    try {
                        int index = obtainStyledAttributes.getIndex(i3);
                        if (index == a.C1061a.GenericDraweeHierarchy_actualImageScaleType) {
                            bVar.g(a(obtainStyledAttributes, index));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_placeholderImage) {
                            bVar.B(getDrawable(context, obtainStyledAttributes, index));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_pressedStateOverlayImage) {
                            bVar.H(getDrawable(context, obtainStyledAttributes, index));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_progressBarImage) {
                            bVar.E(getDrawable(context, obtainStyledAttributes, index));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_fadeDuration) {
                            bVar.Ps(obtainStyledAttributes.getInt(index, 0));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_viewAspectRatio) {
                            bVar.bN(obtainStyledAttributes.getFloat(index, 0.0f));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_placeholderImageScaleType) {
                            bVar.c(a(obtainStyledAttributes, index));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_retryImage) {
                            bVar.C(getDrawable(context, obtainStyledAttributes, index));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_retryImageScaleType) {
                            bVar.d(a(obtainStyledAttributes, index));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_failureImage) {
                            bVar.D(getDrawable(context, obtainStyledAttributes, index));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_failureImageScaleType) {
                            bVar.e(a(obtainStyledAttributes, index));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_progressBarImageScaleType) {
                            bVar.f(a(obtainStyledAttributes, index));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_progressBarAutoRotateInterval) {
                            i = obtainStyledAttributes.getInteger(index, i);
                        } else if (index == a.C1061a.GenericDraweeHierarchy_backgroundImage) {
                            bVar.F(getDrawable(context, obtainStyledAttributes, index));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_overlayImage) {
                            bVar.G(getDrawable(context, obtainStyledAttributes, index));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_roundAsCircle) {
                            a(bVar).Bp(obtainStyledAttributes.getBoolean(index, false));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_roundedCornerRadius) {
                            i2 = obtainStyledAttributes.getDimensionPixelSize(index, i2);
                        } else if (index == a.C1061a.GenericDraweeHierarchy_roundTopLeft) {
                            z5 = obtainStyledAttributes.getBoolean(index, z5);
                        } else if (index == a.C1061a.GenericDraweeHierarchy_roundTopRight) {
                            z6 = obtainStyledAttributes.getBoolean(index, z6);
                        } else if (index == a.C1061a.GenericDraweeHierarchy_roundBottomLeft) {
                            z7 = obtainStyledAttributes.getBoolean(index, z7);
                        } else if (index == a.C1061a.GenericDraweeHierarchy_roundBottomRight) {
                            z8 = obtainStyledAttributes.getBoolean(index, z8);
                        } else if (index == a.C1061a.GenericDraweeHierarchy_roundTopStart) {
                            z9 = obtainStyledAttributes.getBoolean(index, z9);
                        } else if (index == a.C1061a.GenericDraweeHierarchy_roundTopEnd) {
                            z10 = obtainStyledAttributes.getBoolean(index, z10);
                        } else if (index == a.C1061a.GenericDraweeHierarchy_roundBottomStart) {
                            z11 = obtainStyledAttributes.getBoolean(index, z11);
                        } else if (index == a.C1061a.GenericDraweeHierarchy_roundBottomEnd) {
                            z12 = obtainStyledAttributes.getBoolean(index, z12);
                        } else if (index == a.C1061a.GenericDraweeHierarchy_roundWithOverlayColor) {
                            a(bVar).Pu(obtainStyledAttributes.getColor(index, 0));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_roundingBorderWidth) {
                            a(bVar).bP(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_roundingBorderColor) {
                            a(bVar).Pv(obtainStyledAttributes.getColor(index, 0));
                        } else if (index == a.C1061a.GenericDraweeHierarchy_roundingBorderPadding) {
                            a(bVar).bQ(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z4 = z12;
                        obtainStyledAttributes.recycle();
                        if (Build.VERSION.SDK_INT < 17 || context.getResources().getConfiguration().getLayoutDirection() != 1) {
                            if (!z5 || !z9) {
                            }
                            if (!z6 || z10) {
                            }
                            if (!z8 || z4) {
                            }
                            if (!z7 || z11) {
                            }
                        } else {
                            if (!z5 || !z10) {
                            }
                            if (!z6 || z9) {
                            }
                            if (!z8 || z11) {
                            }
                            if (!z7 || z4) {
                            }
                        }
                        throw th;
                    }
                }
                obtainStyledAttributes.recycle();
                if (Build.VERSION.SDK_INT < 17 || context.getResources().getConfiguration().getLayoutDirection() != 1) {
                    z5 = z5 && z9;
                    z3 = z6 && z10;
                    boolean z13 = z8 && z12;
                    z2 = z7 && z11;
                    z = z13;
                } else {
                    z5 = z5 && z10;
                    boolean z14 = z6 && z9;
                    z = z8 && z11;
                    z2 = z7 && z12;
                    z3 = z14;
                }
            } catch (Throwable th3) {
                th = th3;
                z4 = true;
            }
        } else {
            z = true;
            z2 = true;
            z3 = true;
        }
        if (bVar.eva() != null && i > 0) {
            bVar.E(new com.facebook.drawee.drawable.b(bVar.eva(), i));
        }
        if (i2 > 0) {
            a(bVar).j(z5 ? i2 : 0.0f, z3 ? i2 : 0.0f, z ? i2 : 0.0f, z2 ? i2 : 0.0f);
        }
        return bVar;
    }

    @ReturnsOwnership
    private static RoundingParams a(b bVar) {
        if (bVar.euQ() == null) {
            bVar.b(new RoundingParams());
        }
        return bVar.euQ();
    }

    @Nullable
    private static Drawable getDrawable(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getResources().getDrawable(resourceId);
    }

    @Nullable
    private static p.b a(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                return p.b.pFV;
            case 1:
                return p.b.pFW;
            case 2:
                return p.b.pFX;
            case 3:
                return p.b.pFY;
            case 4:
                return p.b.pFZ;
            case 5:
                return p.b.pGa;
            case 6:
                return p.b.pGb;
            case 7:
                return p.b.pGc;
            case 8:
                return p.b.pGd;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }
}
