package com.kwad.sdk.core.imageloader.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import java.io.File;
/* loaded from: classes2.dex */
public final class DiskCacheUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DiskCacheUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static File findInCache(String str, DiskCache diskCache) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, diskCache)) == null) {
            File file = diskCache.get(str);
            if (file == null || !file.exists()) {
                return null;
            }
            return file;
        }
        return (File) invokeLL.objValue;
    }

    public static boolean removeFromCache(String str, DiskCache diskCache) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, diskCache)) == null) {
            File file = diskCache.get(str);
            return file != null && file.exists() && file.delete();
        }
        return invokeLL.booleanValue;
    }
}
