package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.ReturnsOwnership;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class GenericDraweeHierarchyInflater {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public GenericDraweeHierarchyInflater() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    public static Drawable getDrawable(Context context, TypedArray typedArray, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, typedArray, i2)) == null) {
            int resourceId = typedArray.getResourceId(i2, 0);
            if (resourceId == 0) {
                return null;
            }
            return context.getResources().getDrawable(resourceId);
        }
        return (Drawable) invokeLLI.objValue;
    }

    @ReturnsOwnership
    public static RoundingParams getRoundingParams(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, genericDraweeHierarchyBuilder)) == null) {
            if (genericDraweeHierarchyBuilder.getRoundingParams() == null) {
                genericDraweeHierarchyBuilder.setRoundingParams(new RoundingParams());
            }
            return genericDraweeHierarchyBuilder.getRoundingParams();
        }
        return (RoundingParams) invokeL.objValue;
    }

    @Nullable
    public static ScalingUtils.ScaleType getScaleTypeFromXml(TypedArray typedArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, typedArray, i2)) == null) {
            switch (typedArray.getInt(i2, -2)) {
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
        return (ScalingUtils.ScaleType) invokeLI.objValue;
    }

    public static GenericDraweeHierarchyBuilder inflateBuilder(Context context, @Nullable AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, attributeSet)) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("GenericDraweeHierarchyBuilder#inflateBuilder");
            }
            GenericDraweeHierarchyBuilder updateBuilder = updateBuilder(new GenericDraweeHierarchyBuilder(context.getResources()), context, attributeSet);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return updateBuilder;
        }
        return (GenericDraweeHierarchyBuilder) invokeLL.objValue;
    }

    public static GenericDraweeHierarchy inflateHierarchy(Context context, @Nullable AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, attributeSet)) == null) ? inflateBuilder(context, attributeSet).build() : (GenericDraweeHierarchy) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x0233  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v4, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static GenericDraweeHierarchyBuilder updateBuilder(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder, Context context, @Nullable AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        boolean z4;
        int i4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, genericDraweeHierarchyBuilder, context, attributeSet)) == null) {
            Context context2 = context;
            ?? r4 = 0;
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, new int[]{R.attr.actualImageScaleType, R.attr.backgroundImage, R.attr.fadeDuration, R.attr.failureImage, R.attr.failureImageScaleType, R.attr.overlayImage, R.attr.placeholderImage, R.attr.placeholderImageScaleType, R.attr.pressedStateOverlayImage, R.attr.progressBarAutoRotateInterval, R.attr.progressBarImage, R.attr.progressBarImageScaleType, R.attr.retryImage, R.attr.retryImageScaleType, R.attr.roundAsCircle, R.attr.roundBottomEnd, R.attr.roundBottomLeft, R.attr.roundBottomRight, R.attr.roundBottomStart, R.attr.roundTopEnd, R.attr.roundTopLeft, R.attr.roundTopRight, R.attr.roundTopStart, R.attr.roundWithOverlayColor, R.attr.roundedCornerRadius, R.attr.roundingBorderColor, R.attr.roundingBorderPadding, R.attr.roundingBorderWidth, R.attr.viewAspectRatio});
                try {
                    int indexCount = obtainStyledAttributes.getIndexCount();
                    int i5 = 0;
                    int i6 = 0;
                    boolean z6 = true;
                    boolean z7 = true;
                    boolean z8 = true;
                    boolean z9 = true;
                    boolean z10 = true;
                    boolean z11 = true;
                    boolean z12 = true;
                    boolean z13 = true;
                    int i7 = 0;
                    while (i6 < indexCount) {
                        try {
                            int index = obtainStyledAttributes.getIndex(i6);
                            if (index == 0) {
                                try {
                                    genericDraweeHierarchyBuilder.setActualImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                                } catch (Throwable th) {
                                    th = th;
                                    obtainStyledAttributes.recycle();
                                    if (Build.VERSION.SDK_INT >= 17) {
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
                                    i5 = obtainStyledAttributes.getInteger(index, i5);
                                } else if (index == 1) {
                                    genericDraweeHierarchyBuilder.setBackground(getDrawable(context2, obtainStyledAttributes, index));
                                } else if (index == 5) {
                                    genericDraweeHierarchyBuilder.setOverlay(getDrawable(context2, obtainStyledAttributes, index));
                                } else if (index == 14) {
                                    getRoundingParams(genericDraweeHierarchyBuilder).setRoundAsCircle(obtainStyledAttributes.getBoolean(index, r4));
                                } else if (index == 24) {
                                    i7 = obtainStyledAttributes.getDimensionPixelSize(index, i7);
                                } else {
                                    int i8 = i7;
                                    if (index == 20) {
                                        z6 = obtainStyledAttributes.getBoolean(index, z6);
                                    } else if (index == 21) {
                                        z8 = obtainStyledAttributes.getBoolean(index, z8);
                                    } else if (index == 16) {
                                        z12 = obtainStyledAttributes.getBoolean(index, z12);
                                    } else if (index == 17) {
                                        z10 = obtainStyledAttributes.getBoolean(index, z10);
                                    } else if (index == 22) {
                                        z7 = obtainStyledAttributes.getBoolean(index, z7);
                                    } else if (index == 19) {
                                        z9 = obtainStyledAttributes.getBoolean(index, z9);
                                    } else if (index == 18) {
                                        try {
                                            z13 = obtainStyledAttributes.getBoolean(index, z13);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            obtainStyledAttributes.recycle();
                                            if (Build.VERSION.SDK_INT >= 17) {
                                                context.getResources().getConfiguration().getLayoutDirection();
                                            }
                                            throw th;
                                        }
                                    } else {
                                        z5 = z13;
                                        if (index == 15) {
                                            z11 = obtainStyledAttributes.getBoolean(index, z11);
                                            i7 = i8;
                                            z13 = z5;
                                        } else {
                                            if (index == 23) {
                                                i4 = i8;
                                                getRoundingParams(genericDraweeHierarchyBuilder).setOverlayColor(obtainStyledAttributes.getColor(index, 0));
                                            } else {
                                                i4 = i8;
                                                if (index == 27) {
                                                    getRoundingParams(genericDraweeHierarchyBuilder).setBorderWidth(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                                                } else if (index == 25) {
                                                    getRoundingParams(genericDraweeHierarchyBuilder).setBorderColor(obtainStyledAttributes.getColor(index, 0));
                                                } else if (index == 26) {
                                                    getRoundingParams(genericDraweeHierarchyBuilder).setPadding(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                                                    i7 = i4;
                                                    z13 = z5;
                                                    i6++;
                                                    context2 = context;
                                                    r4 = 0;
                                                }
                                            }
                                            i7 = i4;
                                            z13 = z5;
                                            i6++;
                                            context2 = context;
                                            r4 = 0;
                                        }
                                    }
                                    i7 = i8;
                                }
                                i6++;
                                context2 = context;
                                r4 = 0;
                            }
                            z5 = z13;
                            i4 = i7;
                            i7 = i4;
                            z13 = z5;
                            i6++;
                            context2 = context;
                            r4 = 0;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    boolean z14 = z13;
                    int i9 = i7;
                    obtainStyledAttributes.recycle();
                    if (Build.VERSION.SDK_INT < 17 || context.getResources().getConfiguration().getLayoutDirection() != 1) {
                        boolean z15 = z6 && z7;
                        z = z8 && z9;
                        boolean z16 = z10 && z11;
                        z4 = z12 && z14;
                        i3 = i5;
                        i2 = i9;
                        boolean z17 = z16;
                        z3 = z15;
                        z2 = z17;
                    } else {
                        boolean z18 = z6 && z9;
                        z = z8 && z7;
                        boolean z19 = z10 && z14;
                        z4 = z12 && z11;
                        z3 = z18;
                        z2 = z19;
                        i3 = i5;
                        i2 = i9;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } else {
                z = true;
                i2 = 0;
                z2 = true;
                i3 = 0;
                z3 = true;
                z4 = true;
            }
            if (genericDraweeHierarchyBuilder.getProgressBarImage() != null && i3 > 0) {
                genericDraweeHierarchyBuilder.setProgressBarImage(new AutoRotateDrawable(genericDraweeHierarchyBuilder.getProgressBarImage(), i3));
            }
            if (i2 > 0) {
                getRoundingParams(genericDraweeHierarchyBuilder).setCornersRadii(z3 ? i2 : 0.0f, z ? i2 : 0.0f, z2 ? i2 : 0.0f, z4 ? i2 : 0.0f);
            }
            return genericDraweeHierarchyBuilder;
        }
        return (GenericDraweeHierarchyBuilder) invokeLLL.objValue;
    }
}
