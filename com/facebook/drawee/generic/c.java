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
/* loaded from: classes14.dex */
public class c {
    public static b k(Context context, @Nullable AttributeSet attributeSet) {
        return a(new b(context.getResources()), context, attributeSet);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [224=4] */
    public static b a(b bVar, Context context, @Nullable AttributeSet attributeSet) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Throwable th;
        boolean z8;
        int i = 0;
        int i2 = 0;
        boolean z9 = true;
        boolean z10 = true;
        boolean z11 = true;
        boolean z12 = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0973a.GenericDraweeHierarchy);
            try {
                int indexCount = obtainStyledAttributes.getIndexCount();
                boolean z13 = true;
                boolean z14 = true;
                boolean z15 = true;
                boolean z16 = true;
                boolean z17 = true;
                boolean z18 = true;
                boolean z19 = true;
                boolean z20 = true;
                for (int i3 = 0; i3 < indexCount; i3++) {
                    try {
                        int index = obtainStyledAttributes.getIndex(i3);
                        if (index == a.C0973a.GenericDraweeHierarchy_actualImageScaleType) {
                            bVar.g(a(obtainStyledAttributes, index));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_placeholderImage) {
                            bVar.t(a(context, obtainStyledAttributes, index));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_pressedStateOverlayImage) {
                            bVar.z(a(context, obtainStyledAttributes, index));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_progressBarImage) {
                            bVar.w(a(context, obtainStyledAttributes, index));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_fadeDuration) {
                            bVar.Po(obtainStyledAttributes.getInt(index, 0));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_viewAspectRatio) {
                            bVar.bt(obtainStyledAttributes.getFloat(index, 0.0f));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_placeholderImageScaleType) {
                            bVar.c(a(obtainStyledAttributes, index));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_retryImage) {
                            bVar.u(a(context, obtainStyledAttributes, index));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_retryImageScaleType) {
                            bVar.d(a(obtainStyledAttributes, index));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_failureImage) {
                            bVar.v(a(context, obtainStyledAttributes, index));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_failureImageScaleType) {
                            bVar.e(a(obtainStyledAttributes, index));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_progressBarImageScaleType) {
                            bVar.f(a(obtainStyledAttributes, index));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_progressBarAutoRotateInterval) {
                            i = obtainStyledAttributes.getInteger(index, i);
                        } else if (index == a.C0973a.GenericDraweeHierarchy_backgroundImage) {
                            bVar.x(a(context, obtainStyledAttributes, index));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_overlayImage) {
                            bVar.y(a(context, obtainStyledAttributes, index));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_roundAsCircle) {
                            a(bVar).Ar(obtainStyledAttributes.getBoolean(index, false));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_roundedCornerRadius) {
                            i2 = obtainStyledAttributes.getDimensionPixelSize(index, i2);
                        } else if (index == a.C0973a.GenericDraweeHierarchy_roundTopLeft) {
                            z19 = obtainStyledAttributes.getBoolean(index, z19);
                        } else if (index == a.C0973a.GenericDraweeHierarchy_roundTopRight) {
                            z17 = obtainStyledAttributes.getBoolean(index, z17);
                        } else if (index == a.C0973a.GenericDraweeHierarchy_roundBottomLeft) {
                            z15 = obtainStyledAttributes.getBoolean(index, z15);
                        } else if (index == a.C0973a.GenericDraweeHierarchy_roundBottomRight) {
                            z13 = obtainStyledAttributes.getBoolean(index, z13);
                        } else if (index == a.C0973a.GenericDraweeHierarchy_roundTopStart) {
                            z20 = obtainStyledAttributes.getBoolean(index, z20);
                        } else if (index == a.C0973a.GenericDraweeHierarchy_roundTopEnd) {
                            z18 = obtainStyledAttributes.getBoolean(index, z18);
                        } else if (index == a.C0973a.GenericDraweeHierarchy_roundBottomStart) {
                            z16 = obtainStyledAttributes.getBoolean(index, z16);
                        } else if (index == a.C0973a.GenericDraweeHierarchy_roundBottomEnd) {
                            z14 = obtainStyledAttributes.getBoolean(index, z14);
                        } else if (index == a.C0973a.GenericDraweeHierarchy_roundWithOverlayColor) {
                            a(bVar).Pq(obtainStyledAttributes.getColor(index, 0));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_roundingBorderWidth) {
                            a(bVar).bv(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_roundingBorderColor) {
                            a(bVar).Pr(obtainStyledAttributes.getColor(index, 0));
                        } else if (index == a.C0973a.GenericDraweeHierarchy_roundingBorderPadding) {
                            a(bVar).bw(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                        }
                    } catch (Throwable th2) {
                        z = z19;
                        z3 = z17;
                        z5 = z15;
                        z7 = z13;
                        z8 = z20;
                        z2 = z18;
                        z4 = z16;
                        z6 = z14;
                        th = th2;
                        obtainStyledAttributes.recycle();
                        if (Build.VERSION.SDK_INT < 17 || context.getResources().getConfiguration().getLayoutDirection() != 1) {
                            if (!z || !z8) {
                            }
                            if (!z3 || z2) {
                            }
                            if (!z7 || z6) {
                            }
                            if (!z5 || z4) {
                            }
                        } else {
                            if (!z || !z2) {
                            }
                            if (!z3 || z8) {
                            }
                            if (!z7 || z4) {
                            }
                            if (!z5 || z6) {
                            }
                        }
                        throw th;
                    }
                }
                obtainStyledAttributes.recycle();
                if (Build.VERSION.SDK_INT < 17 || context.getResources().getConfiguration().getLayoutDirection() != 1) {
                    boolean z21 = z19 && z20;
                    boolean z22 = z17 && z18;
                    boolean z23 = z13 && z14;
                    z11 = z15 && z16;
                    z12 = z23;
                    z10 = z22;
                    z9 = z21;
                } else {
                    boolean z24 = z19 && z18;
                    z10 = z17 && z20;
                    boolean z25 = z13 && z16;
                    z9 = z24;
                    boolean z26 = z15 && z14;
                    z12 = z25;
                    z11 = z26;
                }
            } catch (Throwable th3) {
                z = true;
                z2 = true;
                z3 = true;
                z4 = true;
                z5 = true;
                z6 = true;
                z7 = true;
                th = th3;
                z8 = true;
            }
        }
        if (bVar.emk() != null && i > 0) {
            bVar.w(new com.facebook.drawee.drawable.b(bVar.emk(), i));
        }
        if (i2 > 0) {
            a(bVar).j(z9 ? i2 : 0.0f, z10 ? i2 : 0.0f, z12 ? i2 : 0.0f, z11 ? i2 : 0.0f);
        }
        return bVar;
    }

    @ReturnsOwnership
    private static RoundingParams a(b bVar) {
        if (bVar.ema() == null) {
            bVar.b(new RoundingParams());
        }
        return bVar.ema();
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
    private static p.b a(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                return p.b.oRi;
            case 1:
                return p.b.oRj;
            case 2:
                return p.b.oRk;
            case 3:
                return p.b.oRl;
            case 4:
                return p.b.oRm;
            case 5:
                return p.b.oRn;
            case 6:
                return p.b.oRo;
            case 7:
                return p.b.oRp;
            case 8:
                return p.b.oRq;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }
}
