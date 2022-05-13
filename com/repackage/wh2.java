package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.davemorrissey.labs.subscaleview.ImageSource;
/* loaded from: classes7.dex */
public class wh2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str.startsWith(ImageSource.FILE_SCHEME)) {
                str = str.substring(8);
            }
            u03 L = u03.L();
            return (!c83.E(str) || L == null) ? str : c83.H(str, L);
        }
        return (String) invokeL.objValue;
    }
}
