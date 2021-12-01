package com.kwad.sdk.core.imageloader.utils;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public final class StorageUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String INDIVIDUAL_DIR_NAME = "ksad-images";
    public transient /* synthetic */ FieldHolder $fh;

    public StorageUtils() {
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

    public static File getIndividualCacheDirectory(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) ? getIndividualCacheDirectory(context, str, INDIVIDUAL_DIR_NAME) : (File) invokeLL.objValue;
    }

    public static File getIndividualCacheDirectory(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) == null) {
            File file = new File(str);
            File file2 = new File(str, str2);
            return (file2.exists() || file2.mkdir()) ? file2 : file;
        }
        return (File) invokeLLL.objValue;
    }
}
