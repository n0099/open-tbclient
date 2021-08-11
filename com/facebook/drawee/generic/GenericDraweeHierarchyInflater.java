package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.R;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.ReturnsOwnership;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, attributeSet)) == null) ? inflateBuilder(context, attributeSet).build() : (GenericDraweeHierarchy) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x01cf, code lost:
        if (r14 != false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01e9, code lost:
        if (r5 != false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01eb, code lost:
        r4 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static GenericDraweeHierarchyBuilder updateBuilder(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder, Context context, @Nullable AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        boolean z;
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, genericDraweeHierarchyBuilder, context, attributeSet)) == null) {
            Context context2 = context;
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.GenericDraweeHierarchy);
                try {
                    int indexCount = obtainStyledAttributes.getIndexCount();
                    boolean z6 = true;
                    int i4 = 0;
                    int i5 = 0;
                    boolean z7 = true;
                    boolean z8 = true;
                    boolean z9 = true;
                    boolean z10 = true;
                    boolean z11 = true;
                    boolean z12 = true;
                    boolean z13 = true;
                    int i6 = 0;
                    while (i5 < indexCount) {
                        try {
                            int index = obtainStyledAttributes.getIndex(i5);
                            if (index == R.styleable.GenericDraweeHierarchy_actualImageScaleType) {
                                genericDraweeHierarchyBuilder.setActualImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                            } else if (index == R.styleable.GenericDraweeHierarchy_placeholderImage) {
                                genericDraweeHierarchyBuilder.setPlaceholderImage(getDrawable(context2, obtainStyledAttributes, index));
                            } else if (index == R.styleable.GenericDraweeHierarchy_pressedStateOverlayImage) {
                                genericDraweeHierarchyBuilder.setPressedStateOverlay(getDrawable(context2, obtainStyledAttributes, index));
                            } else if (index == R.styleable.GenericDraweeHierarchy_progressBarImage) {
                                genericDraweeHierarchyBuilder.setProgressBarImage(getDrawable(context2, obtainStyledAttributes, index));
                            } else if (index == R.styleable.GenericDraweeHierarchy_fadeDuration) {
                                genericDraweeHierarchyBuilder.setFadeDuration(obtainStyledAttributes.getInt(index, 0));
                            } else if (index == R.styleable.GenericDraweeHierarchy_viewAspectRatio) {
                                genericDraweeHierarchyBuilder.setDesiredAspectRatio(obtainStyledAttributes.getFloat(index, 0.0f));
                            } else if (index == R.styleable.GenericDraweeHierarchy_placeholderImageScaleType) {
                                genericDraweeHierarchyBuilder.setPlaceholderImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                            } else if (index == R.styleable.GenericDraweeHierarchy_retryImage) {
                                genericDraweeHierarchyBuilder.setRetryImage(getDrawable(context2, obtainStyledAttributes, index));
                            } else if (index == R.styleable.GenericDraweeHierarchy_retryImageScaleType) {
                                genericDraweeHierarchyBuilder.setRetryImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                            } else if (index == R.styleable.GenericDraweeHierarchy_failureImage) {
                                genericDraweeHierarchyBuilder.setFailureImage(getDrawable(context2, obtainStyledAttributes, index));
                            } else if (index == R.styleable.GenericDraweeHierarchy_failureImageScaleType) {
                                genericDraweeHierarchyBuilder.setFailureImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                            } else if (index == R.styleable.GenericDraweeHierarchy_progressBarImageScaleType) {
                                genericDraweeHierarchyBuilder.setProgressBarImageScaleType(getScaleTypeFromXml(obtainStyledAttributes, index));
                            } else if (index == R.styleable.GenericDraweeHierarchy_progressBarAutoRotateInterval) {
                                i4 = obtainStyledAttributes.getInteger(index, i4);
                            } else if (index == R.styleable.GenericDraweeHierarchy_backgroundImage) {
                                genericDraweeHierarchyBuilder.setBackground(getDrawable(context2, obtainStyledAttributes, index));
                            } else if (index == R.styleable.GenericDraweeHierarchy_overlayImage) {
                                genericDraweeHierarchyBuilder.setOverlay(getDrawable(context2, obtainStyledAttributes, index));
                            } else if (index == R.styleable.GenericDraweeHierarchy_roundAsCircle) {
                                getRoundingParams(genericDraweeHierarchyBuilder).setRoundAsCircle(obtainStyledAttributes.getBoolean(index, false));
                            } else if (index == R.styleable.GenericDraweeHierarchy_roundedCornerRadius) {
                                i6 = obtainStyledAttributes.getDimensionPixelSize(index, i6);
                            } else {
                                int i7 = i6;
                                if (index == R.styleable.GenericDraweeHierarchy_roundTopLeft) {
                                    z7 = obtainStyledAttributes.getBoolean(index, z7);
                                } else if (index == R.styleable.GenericDraweeHierarchy_roundTopRight) {
                                    z9 = obtainStyledAttributes.getBoolean(index, z9);
                                } else if (index == R.styleable.GenericDraweeHierarchy_roundBottomLeft) {
                                    z13 = obtainStyledAttributes.getBoolean(index, z13);
                                } else if (index == R.styleable.GenericDraweeHierarchy_roundBottomRight) {
                                    z11 = obtainStyledAttributes.getBoolean(index, z11);
                                } else if (index == R.styleable.GenericDraweeHierarchy_roundTopStart) {
                                    z8 = obtainStyledAttributes.getBoolean(index, z8);
                                } else if (index == R.styleable.GenericDraweeHierarchy_roundTopEnd) {
                                    z10 = obtainStyledAttributes.getBoolean(index, z10);
                                } else if (index == R.styleable.GenericDraweeHierarchy_roundBottomStart) {
                                    z6 = obtainStyledAttributes.getBoolean(index, z6);
                                } else if (index == R.styleable.GenericDraweeHierarchy_roundBottomEnd) {
                                    z12 = obtainStyledAttributes.getBoolean(index, z12);
                                } else if (index == R.styleable.GenericDraweeHierarchy_roundWithOverlayColor) {
                                    i6 = i7;
                                    getRoundingParams(genericDraweeHierarchyBuilder).setOverlayColor(obtainStyledAttributes.getColor(index, 0));
                                } else {
                                    i6 = i7;
                                    if (index == R.styleable.GenericDraweeHierarchy_roundingBorderWidth) {
                                        getRoundingParams(genericDraweeHierarchyBuilder).setBorderWidth(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                                    } else if (index == R.styleable.GenericDraweeHierarchy_roundingBorderColor) {
                                        getRoundingParams(genericDraweeHierarchyBuilder).setBorderColor(obtainStyledAttributes.getColor(index, 0));
                                    } else if (index == R.styleable.GenericDraweeHierarchy_roundingBorderPadding) {
                                        getRoundingParams(genericDraweeHierarchyBuilder).setPadding(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                                        i5++;
                                        context2 = context;
                                    }
                                }
                                i6 = i7;
                            }
                            i5++;
                            context2 = context;
                        } catch (Throwable th) {
                            th = th;
                            obtainStyledAttributes.recycle();
                            if (Build.VERSION.SDK_INT >= 17) {
                                context.getResources().getConfiguration().getLayoutDirection();
                            }
                            throw th;
                        }
                    }
                    boolean z14 = false;
                    obtainStyledAttributes.recycle();
                    if (Build.VERSION.SDK_INT < 17 || context.getResources().getConfiguration().getLayoutDirection() != 1) {
                        z5 = z7 && z8;
                        z = z9 && z10;
                        z2 = z11 && z12;
                        if (z13) {
                        }
                        z3 = z5;
                        i3 = i6;
                        int i8 = i4;
                        z4 = z14;
                        i2 = i8;
                    } else {
                        z5 = z7 && z10;
                        z = z9 && z8;
                        z2 = z11 && z6;
                        if (z13) {
                        }
                        z3 = z5;
                        i3 = i6;
                        int i82 = i4;
                        z4 = z14;
                        i2 = i82;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                z = true;
                i2 = 0;
                i3 = 0;
                z2 = true;
                z3 = true;
                z4 = true;
            }
            if (genericDraweeHierarchyBuilder.getProgressBarImage() != null && i2 > 0) {
                genericDraweeHierarchyBuilder.setProgressBarImage(new AutoRotateDrawable(genericDraweeHierarchyBuilder.getProgressBarImage(), i2));
            }
            if (i3 > 0) {
                getRoundingParams(genericDraweeHierarchyBuilder).setCornersRadii(z3 ? i3 : 0.0f, z ? i3 : 0.0f, z2 ? i3 : 0.0f, z4 ? i3 : 0.0f);
            }
            return genericDraweeHierarchyBuilder;
        }
        return (GenericDraweeHierarchyBuilder) invokeLLL.objValue;
    }
}
