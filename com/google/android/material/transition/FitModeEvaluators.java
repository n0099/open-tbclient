package com.google.android.material.transition;

import android.graphics.RectF;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FitModeEvaluators {
    public static /* synthetic */ Interceptable $ic;
    public static final FitModeEvaluator HEIGHT;
    public static final FitModeEvaluator WIDTH;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2067610063, "Lcom/google/android/material/transition/FitModeEvaluators;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2067610063, "Lcom/google/android/material/transition/FitModeEvaluators;");
                return;
            }
        }
        WIDTH = new FitModeEvaluator() { // from class: com.google.android.material.transition.FitModeEvaluators.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.google.android.material.transition.FitModeEvaluator
            public void applyMask(RectF rectF, float f, FitModeResult fitModeResult) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{rectF, Float.valueOf(f), fitModeResult}) == null) {
                    rectF.bottom -= Math.abs(fitModeResult.currentEndHeight - fitModeResult.currentStartHeight) * f;
                }
            }

            @Override // com.google.android.material.transition.FitModeEvaluator
            public FitModeResult evaluate(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)})) == null) {
                    float lerp = TransitionUtils.lerp(f4, f6, f2, f3, f);
                    float f8 = lerp / f4;
                    float f9 = lerp / f6;
                    return new FitModeResult(f8, f9, lerp, f5 * f8, lerp, f7 * f9);
                }
                return (FitModeResult) invokeCommon.objValue;
            }

            @Override // com.google.android.material.transition.FitModeEvaluator
            public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, fitModeResult)) == null) ? fitModeResult.currentStartHeight > fitModeResult.currentEndHeight : invokeL.booleanValue;
            }
        };
        HEIGHT = new FitModeEvaluator() { // from class: com.google.android.material.transition.FitModeEvaluators.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.google.android.material.transition.FitModeEvaluator
            public void applyMask(RectF rectF, float f, FitModeResult fitModeResult) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{rectF, Float.valueOf(f), fitModeResult}) == null) {
                    float abs = (Math.abs(fitModeResult.currentEndWidth - fitModeResult.currentStartWidth) / 2.0f) * f;
                    rectF.left += abs;
                    rectF.right -= abs;
                }
            }

            @Override // com.google.android.material.transition.FitModeEvaluator
            public FitModeResult evaluate(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)})) == null) {
                    float lerp = TransitionUtils.lerp(f5, f7, f2, f3, f);
                    float f8 = lerp / f5;
                    float f9 = lerp / f7;
                    return new FitModeResult(f8, f9, f4 * f8, lerp, f6 * f9, lerp);
                }
                return (FitModeResult) invokeCommon.objValue;
            }

            @Override // com.google.android.material.transition.FitModeEvaluator
            public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, fitModeResult)) == null) ? fitModeResult.currentStartWidth > fitModeResult.currentEndWidth : invokeL.booleanValue;
            }
        };
    }

    public FitModeEvaluators() {
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

    public static FitModeEvaluator get(int i, boolean z, RectF rectF, RectF rectF2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), rectF, rectF2})) == null) {
            if (i == 0) {
                return shouldAutoFitToWidth(z, rectF, rectF2) ? WIDTH : HEIGHT;
            } else if (i != 1) {
                if (i == 2) {
                    return HEIGHT;
                }
                throw new IllegalArgumentException("Invalid fit mode: " + i);
            } else {
                return WIDTH;
            }
        }
        return (FitModeEvaluator) invokeCommon.objValue;
    }

    public static boolean shouldAutoFitToWidth(boolean z, RectF rectF, RectF rectF2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), rectF, rectF2})) == null) {
            float width = rectF.width();
            float height = rectF.height();
            float width2 = rectF2.width();
            float height2 = rectF2.height();
            float f = (height2 * width) / width2;
            float f2 = (width2 * height) / width;
            if (z) {
                if (f >= height) {
                    return true;
                }
            } else if (f2 >= height2) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
