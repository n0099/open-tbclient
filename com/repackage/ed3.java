package com.repackage;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes5.dex */
public final class ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Uri a(@NonNull Context context, @NonNull File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, file)) == null) ? FileProvider.getUriForFile(context, b().a(context), file) : (Uri) invokeLL.objValue;
    }

    public static vi1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? oi2.p() : (vi1) invokeV.objValue;
    }
}
