package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, String> f72458a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1664386018, "Lcom/xiaomi/push/x;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1664386018, "Lcom/xiaomi/push/x;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        f72458a = hashMap;
        hashMap.put("FFD8FF", "jpg");
        f72458a.put("89504E47", "png");
        f72458a.put("47494638", "gif");
        f72458a.put("474946", "gif");
        f72458a.put("424D", "bmp");
    }

    public static long a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            long j = 0;
            try {
                File[] listFiles = file.listFiles();
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    j += listFiles[i2].isDirectory() ? a(listFiles[i2]) : listFiles[i2].length();
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
            return j;
        }
        return invokeL.longValue;
    }
}
