package com.ss.android.downloadlib.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
            if (file == null || !file.exists()) {
                return 0L;
            }
            return a(file, file.lastModified(), 0);
        }
        return invokeL.longValue;
    }

    public static long a(File file, long j2, int i2) {
        InterceptResult invokeCommon;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{file, Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            if (file != null && file.exists()) {
                j2 = Math.max(j2, file.lastModified());
                int i3 = i2 + 1;
                if (i3 >= 50) {
                    return j2;
                }
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        j2 = Math.max(j2, a(file2, j2, i3));
                    }
                }
            }
            return j2;
        }
        return invokeCommon.longValue;
    }
}
