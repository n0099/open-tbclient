package com.bytedance.sdk.openadsdk.preload.geckox.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Long a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
            Long l = null;
            if (file == null) {
                return null;
            }
            File[] listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.utils.k.1
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

                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, file2)) == null) ? file2.isDirectory() : invokeL2.booleanValue;
                }
            });
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    try {
                        long longValue = Long.valueOf(file2.getName()).longValue();
                        if (l == null) {
                            l = Long.valueOf(longValue);
                        } else if (longValue > l.longValue()) {
                            l = Long.valueOf(longValue);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return l;
        }
        return (Long) invokeL.objValue;
    }

    public static List<Long> b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            ArrayList arrayList = null;
            if (file == null) {
                return null;
            }
            File[] listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.preload.geckox.utils.k.2
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

                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, file2)) == null) ? file2.isDirectory() : invokeL2.booleanValue;
                }
            });
            if (listFiles != null && listFiles.length != 0) {
                arrayList = new ArrayList();
                for (File file2 : listFiles) {
                    try {
                        arrayList.add(Long.valueOf(Long.valueOf(file2.getName()).longValue()));
                    } catch (Exception unused) {
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
