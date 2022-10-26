package com.xiaomi.push;

import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class aa {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56379872, "Lcom/xiaomi/push/aa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56379872, "Lcom/xiaomi/push/aa;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("FFD8FF", "jpg");
        a.put("89504E47", "png");
        a.put("47494638", NativeConstants.TYPE_GIF);
        a.put("474946", NativeConstants.TYPE_GIF);
        a.put("424D", "bmp");
    }

    public static long a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            long j = 0;
            try {
                File[] listFiles = file.listFiles();
                for (int i = 0; i < listFiles.length; i++) {
                    j += listFiles[i].isDirectory() ? a(listFiles[i]) : listFiles[i].length();
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            return j;
        }
        return invokeL.longValue;
    }
}
