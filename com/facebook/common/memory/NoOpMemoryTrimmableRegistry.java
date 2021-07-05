package com.facebook.common.memory;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class NoOpMemoryTrimmableRegistry implements MemoryTrimmableRegistry {
    public static /* synthetic */ Interceptable $ic;
    public static NoOpMemoryTrimmableRegistry sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1198107371, "Lcom/facebook/common/memory/NoOpMemoryTrimmableRegistry;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1198107371, "Lcom/facebook/common/memory/NoOpMemoryTrimmableRegistry;");
        }
    }

    public NoOpMemoryTrimmableRegistry() {
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

    public static synchronized NoOpMemoryTrimmableRegistry getInstance() {
        InterceptResult invokeV;
        NoOpMemoryTrimmableRegistry noOpMemoryTrimmableRegistry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (NoOpMemoryTrimmableRegistry.class) {
                if (sInstance == null) {
                    sInstance = new NoOpMemoryTrimmableRegistry();
                }
                noOpMemoryTrimmableRegistry = sInstance;
            }
            return noOpMemoryTrimmableRegistry;
        }
        return (NoOpMemoryTrimmableRegistry) invokeV.objValue;
    }

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public void registerMemoryTrimmable(MemoryTrimmable memoryTrimmable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, memoryTrimmable) == null) {
        }
    }

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public void unregisterMemoryTrimmable(MemoryTrimmable memoryTrimmable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memoryTrimmable) == null) {
        }
    }
}
