package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RequiresApi(21)
/* loaded from: classes2.dex */
public class FadeModeEvaluators {
    public static /* synthetic */ Interceptable $ic;
    public static final FadeModeEvaluator CROSS;
    public static final FadeModeEvaluator IN;
    public static final FadeModeEvaluator OUT;
    public static final FadeModeEvaluator THROUGH;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1826316534, "Lcom/google/android/material/transition/platform/FadeModeEvaluators;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1826316534, "Lcom/google/android/material/transition/platform/FadeModeEvaluators;");
                return;
            }
        }
        IN = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.google.android.material.transition.platform.FadeModeEvaluator
            public FadeModeResult evaluate(float f2, float f3, float f4) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f3, f4, f2)) : (FadeModeResult) invokeCommon.objValue;
            }
        };
        OUT = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.google.android.material.transition.platform.FadeModeEvaluator
            public FadeModeResult evaluate(float f2, float f3, float f4) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f3, f4, f2), 255) : (FadeModeResult) invokeCommon.objValue;
            }
        };
        CROSS = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.google.android.material.transition.platform.FadeModeEvaluator
            public FadeModeResult evaluate(float f2, float f3, float f4) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f3, f4, f2), TransitionUtils.lerp(0, 255, f3, f4, f2)) : (FadeModeResult) invokeCommon.objValue;
            }
        };
        THROUGH = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.google.android.material.transition.platform.FadeModeEvaluator
            public FadeModeResult evaluate(float f2, float f3, float f4) {
                InterceptResult invokeCommon;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
                    float f5 = ((f4 - f3) * 0.35f) + f3;
                    return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f3, f5, f2), TransitionUtils.lerp(0, 255, f5, f4, f2));
                }
                return (FadeModeResult) invokeCommon.objValue;
            }
        };
    }

    public FadeModeEvaluators() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static FadeModeEvaluator get(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 == 0) {
                return z ? IN : OUT;
            } else if (i2 == 1) {
                return z ? OUT : IN;
            } else if (i2 != 2) {
                if (i2 == 3) {
                    return THROUGH;
                }
                throw new IllegalArgumentException("Invalid fade mode: " + i2);
            } else {
                return CROSS;
            }
        }
        return (FadeModeEvaluator) invokeCommon.objValue;
    }
}
