package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.RoundedNinePatchDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class WrappingUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "WrappingUtils";
    public static final Drawable sEmptyDrawable;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(73333370, "Lcom/facebook/drawee/generic/WrappingUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(73333370, "Lcom/facebook/drawee/generic/WrappingUtils;");
                return;
            }
        }
        sEmptyDrawable = new ColorDrawable(0);
    }

    public WrappingUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Drawable applyLeafRounding(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, drawable, roundingParams, resources)) == null) {
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                RoundedBitmapDrawable roundedBitmapDrawable = new RoundedBitmapDrawable(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
                applyRoundingParams(roundedBitmapDrawable, roundingParams);
                return roundedBitmapDrawable;
            } else if (drawable instanceof NinePatchDrawable) {
                RoundedNinePatchDrawable roundedNinePatchDrawable = new RoundedNinePatchDrawable((NinePatchDrawable) drawable);
                applyRoundingParams(roundedNinePatchDrawable, roundingParams);
                return roundedNinePatchDrawable;
            } else if ((drawable instanceof ColorDrawable) && Build.VERSION.SDK_INT >= 11) {
                RoundedColorDrawable fromColorDrawable = RoundedColorDrawable.fromColorDrawable((ColorDrawable) drawable);
                applyRoundingParams(fromColorDrawable, roundingParams);
                return fromColorDrawable;
            } else {
                FLog.w(TAG, "Don't know how to round that drawable: %s", drawable);
                return drawable;
            }
        }
        return (Drawable) invokeLLL.objValue;
    }

    public static void applyRoundingParams(Rounded rounded, RoundingParams roundingParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, rounded, roundingParams) == null) {
            rounded.setCircle(roundingParams.getRoundAsCircle());
            rounded.setRadii(roundingParams.getCornersRadii());
            rounded.setBorder(roundingParams.getBorderColor(), roundingParams.getBorderWidth());
            rounded.setPadding(roundingParams.getPadding());
            rounded.setScaleDownInsideBorders(roundingParams.getScaleDownInsideBorders());
            rounded.setPaintFilterBitmap(roundingParams.getPaintFilterBitmap());
        }
    }

    public static DrawableParent findDrawableParentForLeaf(DrawableParent drawableParent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, drawableParent)) == null) {
            while (true) {
                Drawable drawable = drawableParent.getDrawable();
                if (drawable == drawableParent || !(drawable instanceof DrawableParent)) {
                    break;
                }
                drawableParent = (DrawableParent) drawable;
            }
            return drawableParent;
        }
        return (DrawableParent) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    public static Drawable maybeApplyLeafRounding(@Nullable Drawable drawable, @Nullable RoundingParams roundingParams, Resources resources) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, drawable, roundingParams, resources)) == null) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("WrappingUtils#maybeApplyLeafRounding");
                }
                if (drawable != null && roundingParams != null && roundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.BITMAP_ONLY) {
                    if (drawable instanceof ForwardingDrawable) {
                        DrawableParent findDrawableParentForLeaf = findDrawableParentForLeaf((ForwardingDrawable) drawable);
                        findDrawableParentForLeaf.setDrawable(applyLeafRounding(findDrawableParentForLeaf.setDrawable(sEmptyDrawable), roundingParams, resources));
                        return drawable;
                    }
                    Drawable applyLeafRounding = applyLeafRounding(drawable, roundingParams, resources);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return applyLeafRounding;
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return drawable;
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
        return (Drawable) invokeLLL.objValue;
    }

    @Nullable
    public static Drawable maybeWrapWithMatrix(@Nullable Drawable drawable, @Nullable Matrix matrix) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, drawable, matrix)) == null) ? (drawable == null || matrix == null) ? drawable : new MatrixDrawable(drawable, matrix) : (Drawable) invokeLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
    public static Drawable maybeWrapWithRoundedOverlayColor(@Nullable Drawable drawable, @Nullable RoundingParams roundingParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, drawable, roundingParams)) == null) {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("WrappingUtils#maybeWrapWithRoundedOverlayColor");
                }
                if (drawable != null && roundingParams != null && roundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.OVERLAY_COLOR) {
                    RoundedCornersDrawable roundedCornersDrawable = new RoundedCornersDrawable(drawable);
                    applyRoundingParams(roundedCornersDrawable, roundingParams);
                    roundedCornersDrawable.setOverlayColor(roundingParams.getOverlayColor());
                    return roundedCornersDrawable;
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return drawable;
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }
        return (Drawable) invokeLL.objValue;
    }

    @Nullable
    public static Drawable maybeWrapWithScaleType(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, drawable, scaleType)) == null) ? maybeWrapWithScaleType(drawable, scaleType, null) : (Drawable) invokeLL.objValue;
    }

    public static void resetRoundingParams(Rounded rounded) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, rounded) == null) {
            rounded.setCircle(false);
            rounded.setRadius(0.0f);
            rounded.setBorder(0, 0.0f);
            rounded.setPadding(0.0f);
            rounded.setScaleDownInsideBorders(false);
            rounded.setPaintFilterBitmap(false);
        }
    }

    public static void updateLeafRounding(DrawableParent drawableParent, @Nullable RoundingParams roundingParams, Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, drawableParent, roundingParams, resources) == null) {
            DrawableParent findDrawableParentForLeaf = findDrawableParentForLeaf(drawableParent);
            Drawable drawable = findDrawableParentForLeaf.getDrawable();
            if (roundingParams != null && roundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.BITMAP_ONLY) {
                if (drawable instanceof Rounded) {
                    applyRoundingParams((Rounded) drawable, roundingParams);
                } else if (drawable != null) {
                    findDrawableParentForLeaf.setDrawable(sEmptyDrawable);
                    findDrawableParentForLeaf.setDrawable(applyLeafRounding(drawable, roundingParams, resources));
                }
            } else if (drawable instanceof Rounded) {
                resetRoundingParams((Rounded) drawable);
            }
        }
    }

    public static void updateOverlayColorRounding(DrawableParent drawableParent, @Nullable RoundingParams roundingParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, drawableParent, roundingParams) == null) {
            Drawable drawable = drawableParent.getDrawable();
            if (roundingParams != null && roundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.OVERLAY_COLOR) {
                if (drawable instanceof RoundedCornersDrawable) {
                    RoundedCornersDrawable roundedCornersDrawable = (RoundedCornersDrawable) drawable;
                    applyRoundingParams(roundedCornersDrawable, roundingParams);
                    roundedCornersDrawable.setOverlayColor(roundingParams.getOverlayColor());
                    return;
                }
                drawableParent.setDrawable(maybeWrapWithRoundedOverlayColor(drawableParent.setDrawable(sEmptyDrawable), roundingParams));
            } else if (drawable instanceof RoundedCornersDrawable) {
                drawableParent.setDrawable(((RoundedCornersDrawable) drawable).setCurrent(sEmptyDrawable));
                sEmptyDrawable.setCallback(null);
            }
        }
    }

    public static ScaleTypeDrawable wrapChildWithScaleType(DrawableParent drawableParent, ScalingUtils.ScaleType scaleType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, drawableParent, scaleType)) == null) {
            Drawable maybeWrapWithScaleType = maybeWrapWithScaleType(drawableParent.setDrawable(sEmptyDrawable), scaleType);
            drawableParent.setDrawable(maybeWrapWithScaleType);
            Preconditions.checkNotNull(maybeWrapWithScaleType, "Parent has no child drawable!");
            return (ScaleTypeDrawable) maybeWrapWithScaleType;
        }
        return (ScaleTypeDrawable) invokeLL.objValue;
    }

    @Nullable
    public static Drawable maybeWrapWithScaleType(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType, @Nullable PointF pointF) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, drawable, scaleType, pointF)) == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("WrappingUtils#maybeWrapWithScaleType");
            }
            if (drawable != null && scaleType != null) {
                ScaleTypeDrawable scaleTypeDrawable = new ScaleTypeDrawable(drawable, scaleType);
                if (pointF != null) {
                    scaleTypeDrawable.setFocusPoint(pointF);
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return scaleTypeDrawable;
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return drawable;
        }
        return (Drawable) invokeLLL.objValue;
    }
}
