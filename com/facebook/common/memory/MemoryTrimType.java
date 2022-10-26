package com.facebook.common.memory;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class MemoryTrimType {
    public static final /* synthetic */ MemoryTrimType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final MemoryTrimType OnAppBackgrounded;
    public static final MemoryTrimType OnCloseToDalvikHeapLimit;
    public static final MemoryTrimType OnSystemLowMemoryWhileAppInBackground;
    public static final MemoryTrimType OnSystemLowMemoryWhileAppInForeground;
    public static final MemoryTrimType OnSystemMemoryCriticallyLowWhileAppInForeground;
    public transient /* synthetic */ FieldHolder $fh;
    public double mSuggestedTrimRatio;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1723055931, "Lcom/facebook/common/memory/MemoryTrimType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1723055931, "Lcom/facebook/common/memory/MemoryTrimType;");
                return;
            }
        }
        OnCloseToDalvikHeapLimit = new MemoryTrimType("OnCloseToDalvikHeapLimit", 0, 0.5d);
        OnSystemMemoryCriticallyLowWhileAppInForeground = new MemoryTrimType("OnSystemMemoryCriticallyLowWhileAppInForeground", 1, 1.0d);
        OnSystemLowMemoryWhileAppInForeground = new MemoryTrimType("OnSystemLowMemoryWhileAppInForeground", 2, 0.5d);
        OnSystemLowMemoryWhileAppInBackground = new MemoryTrimType("OnSystemLowMemoryWhileAppInBackground", 3, 1.0d);
        MemoryTrimType memoryTrimType = new MemoryTrimType("OnAppBackgrounded", 4, 1.0d);
        OnAppBackgrounded = memoryTrimType;
        $VALUES = new MemoryTrimType[]{OnCloseToDalvikHeapLimit, OnSystemMemoryCriticallyLowWhileAppInForeground, OnSystemLowMemoryWhileAppInForeground, OnSystemLowMemoryWhileAppInBackground, memoryTrimType};
    }

    public MemoryTrimType(String str, int i, double d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Double.valueOf(d)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSuggestedTrimRatio = d;
    }

    public static MemoryTrimType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (MemoryTrimType) Enum.valueOf(MemoryTrimType.class, str);
        }
        return (MemoryTrimType) invokeL.objValue;
    }

    public static MemoryTrimType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (MemoryTrimType[]) $VALUES.clone();
        }
        return (MemoryTrimType[]) invokeV.objValue;
    }

    public double getSuggestedTrimRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mSuggestedTrimRatio;
        }
        return invokeV.doubleValue;
    }
}
