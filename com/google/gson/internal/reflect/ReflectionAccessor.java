package com.google.gson.internal.reflect;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes7.dex */
public abstract class ReflectionAccessor {
    public static /* synthetic */ Interceptable $ic;
    public static final ReflectionAccessor instance;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void makeAccessible(AccessibleObject accessibleObject);

    static {
        InterceptResult invokeClinit;
        ReflectionAccessor unsafeReflectionAccessor;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1368621907, "Lcom/google/gson/internal/reflect/ReflectionAccessor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1368621907, "Lcom/google/gson/internal/reflect/ReflectionAccessor;");
                return;
            }
        }
        if (JavaVersion.getMajorJavaVersion() < 9) {
            unsafeReflectionAccessor = new PreJava9ReflectionAccessor();
        } else {
            unsafeReflectionAccessor = new UnsafeReflectionAccessor();
        }
        instance = unsafeReflectionAccessor;
    }

    public ReflectionAccessor() {
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

    public static ReflectionAccessor getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return instance;
        }
        return (ReflectionAccessor) invokeV.objValue;
    }
}
