package com.facebook.common.disk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class NoOpDiskTrimmableRegistry implements DiskTrimmableRegistry {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static NoOpDiskTrimmableRegistry sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1895786987, "Lcom/facebook/common/disk/NoOpDiskTrimmableRegistry;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1895786987, "Lcom/facebook/common/disk/NoOpDiskTrimmableRegistry;");
        }
    }

    public NoOpDiskTrimmableRegistry() {
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

    public static synchronized NoOpDiskTrimmableRegistry getInstance() {
        InterceptResult invokeV;
        NoOpDiskTrimmableRegistry noOpDiskTrimmableRegistry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (NoOpDiskTrimmableRegistry.class) {
                if (sInstance == null) {
                    sInstance = new NoOpDiskTrimmableRegistry();
                }
                noOpDiskTrimmableRegistry = sInstance;
            }
            return noOpDiskTrimmableRegistry;
        }
        return (NoOpDiskTrimmableRegistry) invokeV.objValue;
    }

    @Override // com.facebook.common.disk.DiskTrimmableRegistry
    public void registerDiskTrimmable(DiskTrimmable diskTrimmable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, diskTrimmable) == null) {
        }
    }

    @Override // com.facebook.common.disk.DiskTrimmableRegistry
    public void unregisterDiskTrimmable(DiskTrimmable diskTrimmable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, diskTrimmable) == null) {
        }
    }
}
