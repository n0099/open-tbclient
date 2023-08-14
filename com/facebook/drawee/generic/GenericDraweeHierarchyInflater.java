package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import com.facebook.drawee.R;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.ReturnsOwnership;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class GenericDraweeHierarchyInflater {
    @Nullable
    public static Drawable getDrawable(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        return context.getResources().getDrawable(resourceId);
    }

    @ReturnsOwnership
    public static RoundingParams getRoundingParams(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        if (genericDraweeHierarchyBuilder.getRoundingParams() == null) {
            genericDraweeHierarchyBuilder.setRoundingParams(new RoundingParams());
        }
        return genericDraweeHierarchyBuilder.getRoundingParams();
    }

    @Nullable
    public static ScalingUtils.ScaleType getScaleTypeFromXml(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                return ScalingUtils.ScaleType.FIT_XY;
            case 1:
                return ScalingUtils.ScaleType.FIT_START;
            case 2:
                return ScalingUtils.ScaleType.FIT_CENTER;
            case 3:
                return ScalingUtils.ScaleType.FIT_END;
            case 4:
                return ScalingUtils.ScaleType.CENTER;
            case 5:
                return ScalingUtils.ScaleType.CENTER_INSIDE;
            case 6:
                return ScalingUtils.ScaleType.CENTER_CROP;
            case 7:
                return ScalingUtils.ScaleType.FOCUS_CROP;
            case 8:
                return ScalingUtils.ScaleType.FIT_BOTTOM_START;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }

    public static GenericDraweeHierarchyBuilder inflateBuilder(Context context, @Nullable AttributeSet attributeSet) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("GenericDraweeHierarchyBuilder#inflateBuilder");
        }
        GenericDraweeHierarchyBuilder updateBuilder = updateBuilder(new GenericDraweeHierarchyBuilder(context.getResources()), context, attributeSet);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return updateBuilder;
    }

    public static GenericDraweeHierarchy inflateHierarchy(Context context, @Nullable AttributeSet attributeSet) {
        return inflateBuilder(context, attributeSet).build();
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x022a  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v4, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static GenericDraweeHierarchyBuilder updateBuilder(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder, Context context, @Nullable AttributeSet attributeSet) {
        boolean z;
        int i;
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        float f;
        float f2;
        float f3;
        float f4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        int i3;
        boolean z10;
        Context context2 = context;
        ?? r4 = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.GenericDraweeHierarchy);
            try {
                int indexCount = obtainStyledAttributes.getIndexCount();
                int i4 = 0;
                int i5 = 0;
                boolean z11 = true;
                boolean z12 = true;
                boolean z13 = true;
                boolean z14 = true;
                boolean z15 = true;
                boolean z16 = true;
                boolean z17 = true;
                boolean z18 = true;
                int i6 = 0;
                while (i5 < indexCount) {
                    try {
                        int index = obtainStyledAttributes.getIndex(i5);
                        if (index == 0) {
                            try {
                                genericDraweeHierarchyBuilder.setActualImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                            } catch (Throwable th) {
                                th = th;
                                obtainStyledAttributes.recycle();
                                if (Build.VERSION.SDK_INT >= 17) {
                                    context.getResources().getConfiguration().getLayoutDirection();
                                }
                                throw th;
                            }
                        } else if (index == 6) {
                            genericDraweeHierarchyBuilder.setPlaceholderImage(getDrawable(context2, obtainStyledAttributes, index));
                        } else if (index == 8) {
                            genericDraweeHierarchyBuilder.setPressedStateOverlay(getDrawable(context2, obtainStyledAttributes, index));
                        } else if (index == 10) {
                            genericDraweeHierarchyBuilder.setProgressBarImage(getDrawable(context2, obtainStyledAttributes, index));
                        } else if (index == 2) {
                            genericDraweeHierarchyBuilder.setFadeDuration(obtainStyledAttributes.getInt(index, r4));
                        } else if (index == 28) {
                            genericDraweeHierarchyBuilder.setDesiredAspectRatio(obtainStyledAttributes.getFloat(index, 0.0f));
                        } else if (index == 7) {
                            genericDraweeHierarchyBuilder.setPlaceholderImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                        } else if (index == 12) {
                            genericDraweeHierarchyBuilder.setRetryImage(getDrawable(context2, obtainStyledAttributes, index));
                        } else if (index == 13) {
                            genericDraweeHierarchyBuilder.setRetryImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                        } else if (index == 3) {
                            genericDraweeHierarchyBuilder.setFailureImage(getDrawable(context2, obtainStyledAttributes, index));
                        } else if (index == 4) {
                            genericDraweeHierarchyBuilder.setFailureImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                        } else if (index == 11) {
                            genericDraweeHierarchyBuilder.setProgressBarImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                        } else {
                            if (index == 9) {
                                i4 = obtainStyledAttributes.getInteger(index, i4);
                            } else if (index == 1) {
                                genericDraweeHierarchyBuilder.setBackground(getDrawable(context2, obtainStyledAttributes, index));
                            } else if (index == 5) {
                                genericDraweeHierarchyBuilder.setOverlay(getDrawable(context2, obtainStyledAttributes, index));
                            } else if (index == 14) {
                                getRoundingParams(genericDraweeHierarchyBuilder).setRoundAsCircle(obtainStyledAttributes.getBoolean(index, r4));
                            } else if (index == 24) {
                                i6 = obtainStyledAttributes.getDimensionPixelSize(index, i6);
                            } else {
                                int i7 = i6;
                                if (index == 20) {
                                    z11 = obtainStyledAttributes.getBoolean(index, z11);
                                } else if (index == 21) {
                                    z13 = obtainStyledAttributes.getBoolean(index, z13);
                                } else if (index == 16) {
                                    z17 = obtainStyledAttributes.getBoolean(index, z17);
                                } else if (index == 17) {
                                    z15 = obtainStyledAttributes.getBoolean(index, z15);
                                } else if (index == 22) {
                                    z12 = obtainStyledAttributes.getBoolean(index, z12);
                                } else if (index == 19) {
                                    z14 = obtainStyledAttributes.getBoolean(index, z14);
                                } else if (index == 18) {
                                    try {
                                        z18 = obtainStyledAttributes.getBoolean(index, z18);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        obtainStyledAttributes.recycle();
                                        if (Build.VERSION.SDK_INT >= 17) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    z10 = z18;
                                    if (index == 15) {
                                        z16 = obtainStyledAttributes.getBoolean(index, z16);
                                        i6 = i7;
                                        z18 = z10;
                                    } else {
                                        if (index == 23) {
                                            i3 = i7;
                                            getRoundingParams(genericDraweeHierarchyBuilder).setOverlayColor(obtainStyledAttributes.getColor(index, 0));
                                        } else {
                                            i3 = i7;
                                            if (index == 27) {
                                                getRoundingParams(genericDraweeHierarchyBuilder).setBorderWidth(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                                            } else if (index == 25) {
                                                getRoundingParams(genericDraweeHierarchyBuilder).setBorderColor(obtainStyledAttributes.getColor(index, 0));
                                            } else if (index == 26) {
                                                getRoundingParams(genericDraweeHierarchyBuilder).setPadding(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                                                i6 = i3;
                                                z18 = z10;
                                                i5++;
                                                context2 = context;
                                                r4 = 0;
                                            }
                                        }
                                        i6 = i3;
                                        z18 = z10;
                                        i5++;
                                        context2 = context;
                                        r4 = 0;
                                    }
                                }
                                i6 = i7;
                            }
                            i5++;
                            context2 = context;
                            r4 = 0;
                        }
                        z10 = z18;
                        i3 = i6;
                        i6 = i3;
                        z18 = z10;
                        i5++;
                        context2 = context;
                        r4 = 0;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                boolean z19 = z18;
                int i8 = i6;
                obtainStyledAttributes.recycle();
                if (Build.VERSION.SDK_INT >= 17 && context.getResources().getConfiguration().getLayoutDirection() == 1) {
                    if (z11 && z14) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z13 && z12) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z15 && z19) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (z17 && z16) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    z3 = z8;
                    z2 = z9;
                    i2 = i4;
                    i = i8;
                } else {
                    if (z11 && z12) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z13 && z14) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z15 && z16) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (z17 && z19) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z4 = z7;
                    i2 = i4;
                    i = i8;
                    boolean z20 = z6;
                    z3 = z5;
                    z2 = z20;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } else {
            z = true;
            i = 0;
            z2 = true;
            i2 = 0;
            z3 = true;
            z4 = true;
        }
        if (genericDraweeHierarchyBuilder.getProgressBarImage() != null && i2 > 0) {
            genericDraweeHierarchyBuilder.setProgressBarImage(new AutoRotateDrawable(genericDraweeHierarchyBuilder.getProgressBarImage(), i2));
        }
        if (i > 0) {
            RoundingParams roundingParams = getRoundingParams(genericDraweeHierarchyBuilder);
            if (z3) {
                f = i;
            } else {
                f = 0.0f;
            }
            if (z) {
                f2 = i;
            } else {
                f2 = 0.0f;
            }
            if (z2) {
                f3 = i;
            } else {
                f3 = 0.0f;
            }
            if (z4) {
                f4 = i;
            } else {
                f4 = 0.0f;
            }
            roundingParams.setCornersRadii(f, f2, f3, f4);
        }
        return genericDraweeHierarchyBuilder;
    }
}
