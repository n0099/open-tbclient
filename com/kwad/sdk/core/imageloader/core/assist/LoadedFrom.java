package com.kwad.sdk.core.imageloader.core.assist;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class LoadedFrom {
    public static final /* synthetic */ LoadedFrom[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LoadedFrom DISC_CACHE;
    public static final LoadedFrom MEMORY_CACHE;
    public static final LoadedFrom NETWORK;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1678474752, "Lcom/kwad/sdk/core/imageloader/core/assist/LoadedFrom;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1678474752, "Lcom/kwad/sdk/core/imageloader/core/assist/LoadedFrom;");
                return;
            }
        }
        NETWORK = new LoadedFrom("NETWORK", 0);
        DISC_CACHE = new LoadedFrom("DISC_CACHE", 1);
        LoadedFrom loadedFrom = new LoadedFrom("MEMORY_CACHE", 2);
        MEMORY_CACHE = loadedFrom;
        $VALUES = new LoadedFrom[]{NETWORK, DISC_CACHE, loadedFrom};
    }

    public LoadedFrom(String str, int i2) {
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

    public static LoadedFrom valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LoadedFrom) Enum.valueOf(LoadedFrom.class, str) : (LoadedFrom) invokeL.objValue;
    }

    public static LoadedFrom[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LoadedFrom[]) $VALUES.clone() : (LoadedFrom[]) invokeV.objValue;
    }
}
