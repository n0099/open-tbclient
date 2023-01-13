package com.google.android.material.transition.platform;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
@RequiresApi(21)
/* loaded from: classes8.dex */
public class TransitionUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final RectF transformAlphaRectF;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface CanvasOperation {
        void run(Canvas canvas);
    }

    /* loaded from: classes8.dex */
    public interface CornerSizeBinaryOperator {
        @NonNull
        CornerSize apply(@NonNull CornerSize cornerSize, @NonNull CornerSize cornerSize2);
    }

    @NonNull
    public static <T> T defaultIfNull(@Nullable T t, @NonNull T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, t, t2)) == null) ? t != null ? t : t2 : (T) invokeLL.objValue;
    }

    public static float lerp(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) ? f + (f3 * (f2 - f)) : invokeCommon.floatValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(394970221, "Lcom/google/android/material/transition/platform/TransitionUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(394970221, "Lcom/google/android/material/transition/platform/TransitionUtils;");
                return;
            }
        }
        transformAlphaRectF = new RectF();
    }

    public TransitionUtils() {
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

    public static float calculateArea(@NonNull RectF rectF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, rectF)) == null) {
            return rectF.width() * rectF.height();
        }
        return invokeL.floatValue;
    }

    public static Shader createColorShader(@ColorInt int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i, i, Shader.TileMode.CLAMP);
        }
        return (Shader) invokeI.objValue;
    }

    public static RectF getRelativeBounds(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, view2)) == null) {
            return new RectF(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
        }
        return (RectF) invokeL.objValue;
    }

    public static Rect getRelativeBoundsRect(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, view2)) == null) {
            return new Rect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
        }
        return (Rect) invokeL.objValue;
    }

    public static ShapeAppearanceModel convertToRelativeCornerSizes(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, shapeAppearanceModel, rectF)) == null) {
            return shapeAppearanceModel.withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator(rectF) { // from class: com.google.android.material.transition.platform.TransitionUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RectF val$bounds;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {rectF};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$bounds = rectF;
                }

                @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
                @NonNull
                public CornerSize apply(@NonNull CornerSize cornerSize) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cornerSize)) == null) {
                        if (!(cornerSize instanceof RelativeCornerSize)) {
                            return new RelativeCornerSize(cornerSize.getCornerSize(this.val$bounds) / this.val$bounds.height());
                        }
                        return cornerSize;
                    }
                    return (CornerSize) invokeL.objValue;
                }
            });
        }
        return (ShapeAppearanceModel) invokeLL.objValue;
    }

    public static View findDescendantOrAncestorById(View view2, @IdRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, view2, i)) == null) {
            View findViewById = view2.findViewById(i);
            if (findViewById != null) {
                return findViewById;
            }
            return findAncestorById(view2, i);
        }
        return (View) invokeLI.objValue;
    }

    public static void maybeAddTransition(TransitionSet transitionSet, @Nullable Transition transition) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65552, null, transitionSet, transition) == null) && transition != null) {
            transitionSet.addTransition(transition);
        }
    }

    public static void maybeRemoveTransition(TransitionSet transitionSet, @Nullable Transition transition) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65553, null, transitionSet, transition) == null) && transition != null) {
            transitionSet.removeTransition(transition);
        }
    }

    public static View findAncestorById(View view2, @IdRes int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, view2, i)) == null) {
            String resourceName = view2.getResources().getResourceName(i);
            while (view2 != null) {
                if (view2.getId() == i) {
                    return view2;
                }
                ViewParent parent = view2.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view2 = (View) parent;
            }
            throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
        }
        return (View) invokeLI.objValue;
    }

    public static boolean isShapeAppearanceSignificant(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, shapeAppearanceModel, rectF)) == null) {
            if (shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF) == 0.0f) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static RectF getLocationOnScreen(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, view2)) == null) {
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            return new RectF(i, i2, view2.getWidth() + i, view2.getHeight() + i2);
        }
        return (RectF) invokeL.objValue;
    }

    public static float lerp(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            if (f5 < f3) {
                return f;
            }
            if (f5 > f4) {
                return f2;
            }
            return lerp(f, f2, (f5 - f3) / (f4 - f3));
        }
        return invokeCommon.floatValue;
    }

    public static int lerp(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f3 < f) {
                return i;
            }
            if (f3 > f2) {
                return i2;
            }
            return (int) lerp(i, i2, (f3 - f) / (f2 - f));
        }
        return invokeCommon.intValue;
    }

    public static ShapeAppearanceModel lerp(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF2, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f3 < f) {
                return shapeAppearanceModel;
            }
            if (f3 > f2) {
                return shapeAppearanceModel2;
            }
            return transformCornerSizes(shapeAppearanceModel, shapeAppearanceModel2, rectF, new CornerSizeBinaryOperator(rectF, rectF2, f, f2, f3) { // from class: com.google.android.material.transition.platform.TransitionUtils.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RectF val$endBounds;
                public final /* synthetic */ float val$endFraction;
                public final /* synthetic */ float val$fraction;
                public final /* synthetic */ RectF val$startBounds;
                public final /* synthetic */ float val$startFraction;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {rectF, rectF2, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$startBounds = rectF;
                    this.val$endBounds = rectF2;
                    this.val$startFraction = f;
                    this.val$endFraction = f2;
                    this.val$fraction = f3;
                }

                @Override // com.google.android.material.transition.platform.TransitionUtils.CornerSizeBinaryOperator
                @NonNull
                public CornerSize apply(@NonNull CornerSize cornerSize, @NonNull CornerSize cornerSize2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, cornerSize, cornerSize2)) == null) {
                        return new AbsoluteCornerSize(TransitionUtils.lerp(cornerSize.getCornerSize(this.val$startBounds), cornerSize2.getCornerSize(this.val$endBounds), this.val$startFraction, this.val$endFraction, this.val$fraction));
                    }
                    return (CornerSize) invokeLL.objValue;
                }
            });
        }
        return (ShapeAppearanceModel) invokeCommon.objValue;
    }

    public static void transform(Canvas canvas, Rect rect, float f, float f2, float f3, int i, CanvasOperation canvasOperation) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65555, null, new Object[]{canvas, rect, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i), canvasOperation}) != null) || i <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(f, f2);
        canvas.scale(f3, f3);
        if (i < 255) {
            saveLayerAlphaCompat(canvas, rect, i);
        }
        canvasOperation.run(canvas);
        canvas.restoreToCount(save);
    }

    public static int saveLayerAlphaCompat(Canvas canvas, Rect rect, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65554, null, canvas, rect, i)) == null) {
            transformAlphaRectF.set(rect);
            if (Build.VERSION.SDK_INT >= 21) {
                return canvas.saveLayerAlpha(transformAlphaRectF, i);
            }
            RectF rectF = transformAlphaRectF;
            return canvas.saveLayerAlpha(rectF.left, rectF.top, rectF.right, rectF.bottom, i, 31);
        }
        return invokeLLI.intValue;
    }

    public static ShapeAppearanceModel transformCornerSizes(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, CornerSizeBinaryOperator cornerSizeBinaryOperator) {
        InterceptResult invokeLLLL;
        ShapeAppearanceModel shapeAppearanceModel3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65556, null, shapeAppearanceModel, shapeAppearanceModel2, rectF, cornerSizeBinaryOperator)) == null) {
            if (isShapeAppearanceSignificant(shapeAppearanceModel, rectF)) {
                shapeAppearanceModel3 = shapeAppearanceModel;
            } else {
                shapeAppearanceModel3 = shapeAppearanceModel2;
            }
            return shapeAppearanceModel3.toBuilder().setTopLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel2.getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel2.getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel2.getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomRightCornerSize(), shapeAppearanceModel2.getBottomRightCornerSize())).build();
        }
        return (ShapeAppearanceModel) invokeLLLL.objValue;
    }
}
