package com.kwad.sdk.core.imageloader.utils;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.al;
import java.io.File;
/* loaded from: classes10.dex */
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

    public static File getIndividualCacheDirectory(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? getIndividualCacheDirectory(context, INDIVIDUAL_DIR_NAME) : (File) invokeL.objValue;
    }

    public static File getIndividualCacheDirectory(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            File b2 = al.b(context);
            File file = new File(b2, str);
            return (file.exists() || file.mkdir()) ? file : b2;
        }
        return (File) invokeLL.objValue;
    }
}
