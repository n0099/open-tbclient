package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, c> a;
    public static final Object b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-6723393, "Lcom/huawei/hms/framework/network/grs/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-6723393, "Lcom/huawei/hms/framework/network/grs/d;");
                return;
            }
        }
        a = new ConcurrentHashMap(16);
        b = new Object();
    }

    public static c a(GrsBaseInfo grsBaseInfo, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, grsBaseInfo, context)) == null) {
            synchronized (b) {
                int uniqueCode = grsBaseInfo.uniqueCode();
                Map<String, c> map = a;
                c cVar = map.get(context.getPackageName() + uniqueCode);
                if (cVar == null) {
                    c cVar2 = new c(context, grsBaseInfo);
                    Map<String, c> map2 = a;
                    map2.put(context.getPackageName() + uniqueCode, cVar2);
                    return cVar2;
                } else if (cVar.a((Object) new c(grsBaseInfo))) {
                    return cVar;
                } else {
                    c cVar3 = new c(context, grsBaseInfo);
                    Map<String, c> map3 = a;
                    map3.put(context.getPackageName() + uniqueCode, cVar3);
                    return cVar3;
                }
            }
        }
        return (c) invokeLL.objValue;
    }
}
