package com.xiaomi.push.service;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Long> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(311648611, "Lcom/xiaomi/push/service/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(311648611, "Lcom/xiaomi/push/service/m;");
                return;
            }
        }
        a = new HashMap();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ArrayList<String> arrayList = new ArrayList(a.size());
            for (Map.Entry<String, Long> entry : a.entrySet()) {
                if (elapsedRealtime - entry.getValue().longValue() > 60000) {
                    arrayList.add(entry.getKey());
                }
            }
            for (String str : arrayList) {
                a.remove(str);
            }
        }
    }

    public static boolean a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, str)) == null) {
            boolean z = false;
            if (bArr != null && bArr.length > 0 && !TextUtils.isEmpty(str)) {
                String a2 = com.xiaomi.push.bp.a(bArr);
                if (!TextUtils.isEmpty(a2)) {
                    synchronized (a) {
                        Map<String, Long> map = a;
                        if (map.get(a2 + str) != null) {
                            z = true;
                        } else {
                            Map<String, Long> map2 = a;
                            map2.put(a2 + str, Long.valueOf(SystemClock.elapsedRealtime()));
                        }
                        a();
                    }
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }
}
