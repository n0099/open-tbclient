package com.xiaomi.push;

import android.os.Build;
import android.system.Os;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes3.dex */
public class cm {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    if (new File(str).exists()) {
                        return Os.stat(str).st_size;
                    }
                    return 0L;
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    return 0L;
                }
            }
            return 0L;
        }
        return invokeL.longValue;
    }
}
