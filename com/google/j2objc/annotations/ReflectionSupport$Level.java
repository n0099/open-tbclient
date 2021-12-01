package com.google.j2objc.annotations;

import com.baidu.poly.widget.PolyActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class ReflectionSupport$Level {
    public static final /* synthetic */ ReflectionSupport$Level[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ReflectionSupport$Level FULL;
    public static final ReflectionSupport$Level NATIVE_ONLY;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1308606241, "Lcom/google/j2objc/annotations/ReflectionSupport$Level;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1308606241, "Lcom/google/j2objc/annotations/ReflectionSupport$Level;");
                return;
            }
        }
        NATIVE_ONLY = new ReflectionSupport$Level("NATIVE_ONLY", 0);
        ReflectionSupport$Level reflectionSupport$Level = new ReflectionSupport$Level(PolyActivity.FULL_PANEL_TYPE, 1);
        FULL = reflectionSupport$Level;
        $VALUES = new ReflectionSupport$Level[]{NATIVE_ONLY, reflectionSupport$Level};
    }

    public ReflectionSupport$Level(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ReflectionSupport$Level valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ReflectionSupport$Level) Enum.valueOf(ReflectionSupport$Level.class, str) : (ReflectionSupport$Level) invokeL.objValue;
    }

    public static ReflectionSupport$Level[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ReflectionSupport$Level[]) $VALUES.clone() : (ReflectionSupport$Level[]) invokeV.objValue;
    }
}
