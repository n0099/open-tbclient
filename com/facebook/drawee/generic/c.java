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
/* loaded from: classes13.dex */
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0796a.GenericDraweeHierarchy);
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
                        if (index == a.C0796a.GenericDraweeHierarchy_actualImageScaleType) {
                            bVar.g(a(obtainStyledAttributes, index));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_placeholderImage) {
                            bVar.n(a(context, obtainStyledAttributes, index));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_pressedStateOverlayImage) {
                            bVar.t(a(context, obtainStyledAttributes, index));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_progressBarImage) {
                            bVar.q(a(context, obtainStyledAttributes, index));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_fadeDuration) {
                            bVar.Ip(obtainStyledAttributes.getInt(index, 0));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_viewAspectRatio) {
                            bVar.aI(obtainStyledAttributes.getFloat(index, 0.0f));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_placeholderImageScaleType) {
                            bVar.c(a(obtainStyledAttributes, index));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_retryImage) {
                            bVar.o(a(context, obtainStyledAttributes, index));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_retryImageScaleType) {
                            bVar.d(a(obtainStyledAttributes, index));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_failureImage) {
                            bVar.p(a(context, obtainStyledAttributes, index));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_failureImageScaleType) {
                            bVar.e(a(obtainStyledAttributes, index));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_progressBarImageScaleType) {
                            bVar.f(a(obtainStyledAttributes, index));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_progressBarAutoRotateInterval) {
                            i = obtainStyledAttributes.getInteger(index, i);
                        } else if (index == a.C0796a.GenericDraweeHierarchy_backgroundImage) {
                            bVar.r(a(context, obtainStyledAttributes, index));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_overlayImage) {
                            bVar.s(a(context, obtainStyledAttributes, index));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_roundAsCircle) {
                            a(bVar).wD(obtainStyledAttributes.getBoolean(index, false));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_roundedCornerRadius) {
                            i2 = obtainStyledAttributes.getDimensionPixelSize(index, i2);
                        } else if (index == a.C0796a.GenericDraweeHierarchy_roundTopLeft) {
                            z19 = obtainStyledAttributes.getBoolean(index, z19);
                        } else if (index == a.C0796a.GenericDraweeHierarchy_roundTopRight) {
                            z17 = obtainStyledAttributes.getBoolean(index, z17);
                        } else if (index == a.C0796a.GenericDraweeHierarchy_roundBottomLeft) {
                            z15 = obtainStyledAttributes.getBoolean(index, z15);
                        } else if (index == a.C0796a.GenericDraweeHierarchy_roundBottomRight) {
                            z13 = obtainStyledAttributes.getBoolean(index, z13);
                        } else if (index == a.C0796a.GenericDraweeHierarchy_roundTopStart) {
                            z20 = obtainStyledAttributes.getBoolean(index, z20);
                        } else if (index == a.C0796a.GenericDraweeHierarchy_roundTopEnd) {
                            z18 = obtainStyledAttributes.getBoolean(index, z18);
                        } else if (index == a.C0796a.GenericDraweeHierarchy_roundBottomStart) {
                            z16 = obtainStyledAttributes.getBoolean(index, z16);
                        } else if (index == a.C0796a.GenericDraweeHierarchy_roundBottomEnd) {
                            z14 = obtainStyledAttributes.getBoolean(index, z14);
                        } else if (index == a.C0796a.GenericDraweeHierarchy_roundWithOverlayColor) {
                            a(bVar).Ir(obtainStyledAttributes.getColor(index, 0));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_roundingBorderWidth) {
                            a(bVar).aK(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_roundingBorderColor) {
                            a(bVar).Is(obtainStyledAttributes.getColor(index, 0));
                        } else if (index == a.C0796a.GenericDraweeHierarchy_roundingBorderPadding) {
                            a(bVar).aL(obtainStyledAttributes.getDimensionPixelSize(index, 0));
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
        if (bVar.dBq() != null && i > 0) {
            bVar.q(new com.facebook.drawee.drawable.b(bVar.dBq(), i));
        }
        if (i2 > 0) {
            a(bVar).h(z9 ? i2 : 0.0f, z10 ? i2 : 0.0f, z12 ? i2 : 0.0f, z11 ? i2 : 0.0f);
        }
        return bVar;
    }

    @ReturnsOwnership
    private static RoundingParams a(b bVar) {
        if (bVar.dBg() == null) {
            bVar.b(new RoundingParams());
        }
        return bVar.dBg();
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
                return p.b.mNg;
            case 1:
                return p.b.mNh;
            case 2:
                return p.b.mNi;
            case 3:
                return p.b.mNj;
            case 4:
                return p.b.mNk;
            case 5:
                return p.b.mNl;
            case 6:
                return p.b.mNm;
            case 7:
                return p.b.mNn;
            case 8:
                return p.b.mNo;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }
}
