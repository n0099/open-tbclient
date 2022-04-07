package com.facebook.imagepipeline.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class Priority {
    public static final /* synthetic */ Priority[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Priority HIGH;
    public static final Priority LOW;
    public static final Priority MEDIUM;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(214700212, "Lcom/facebook/imagepipeline/common/Priority;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(214700212, "Lcom/facebook/imagepipeline/common/Priority;");
                return;
            }
        }
        LOW = new Priority("LOW", 0);
        MEDIUM = new Priority("MEDIUM", 1);
        Priority priority = new Priority("HIGH", 2);
        HIGH = priority;
        $VALUES = new Priority[]{LOW, MEDIUM, priority};
    }

    public Priority(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Priority getHigherPriority(@Nullable Priority priority, @Nullable Priority priority2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, priority, priority2)) == null) ? priority == null ? priority2 : (priority2 != null && priority.ordinal() <= priority2.ordinal()) ? priority2 : priority : (Priority) invokeLL.objValue;
    }

    public static Priority valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Priority) Enum.valueOf(Priority.class, str) : (Priority) invokeL.objValue;
    }

    public static Priority[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Priority[]) $VALUES.clone() : (Priority[]) invokeV.objValue;
    }
}
