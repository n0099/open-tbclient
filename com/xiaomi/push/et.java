package com.xiaomi.push;

import android.util.Pair;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class et {
    public static /* synthetic */ Interceptable $ic;
    public static Vector<Pair<String, Long>> a;

    /* renamed from: a  reason: collision with other field name */
    public static ConcurrentHashMap<String, Long> f1045a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56375439, "Lcom/xiaomi/push/et;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56375439, "Lcom/xiaomi/push/et;");
                return;
            }
        }
        a = new Vector<>();
        f1045a = new ConcurrentHashMap<>();
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuilder sb = new StringBuilder();
            synchronized (a) {
                for (int i = 0; i < a.size(); i++) {
                    Pair<String, Long> elementAt = a.elementAt(i);
                    sb.append((String) elementAt.first);
                    sb.append(":");
                    sb.append(elementAt.second);
                    if (i < a.size() - 1) {
                        sb.append(ParamableElem.DIVIDE_PARAM);
                    }
                }
                a.clear();
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
