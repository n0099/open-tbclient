package com.xiaomi.push;

import android.util.Pair;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class eq {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Vector<Pair<String, Long>> f70891a;

    /* renamed from: a  reason: collision with other field name */
    public static ConcurrentHashMap<String, Long> f337a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56375532, "Lcom/xiaomi/push/eq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56375532, "Lcom/xiaomi/push/eq;");
                return;
            }
        }
        f70891a = new Vector<>();
        f337a = new ConcurrentHashMap<>();
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuilder sb = new StringBuilder();
            synchronized (f70891a) {
                for (int i2 = 0; i2 < f70891a.size(); i2++) {
                    Pair<String, Long> elementAt = f70891a.elementAt(i2);
                    sb.append((String) elementAt.first);
                    sb.append(":");
                    sb.append(elementAt.second);
                    if (i2 < f70891a.size() - 1) {
                        sb.append(";");
                    }
                }
                f70891a.clear();
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
