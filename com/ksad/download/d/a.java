package com.ksad.download.d;

import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    return statFs.getAvailableBytes();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return statFs.getBlockSize() * statFs.getAvailableBlocks();
        }
        return invokeL.longValue;
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) ? file != null && file.exists() : invokeL.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) >= 0) ? str.substring(lastIndexOf + 1) : "" : (String) invokeL.objValue;
    }
}
