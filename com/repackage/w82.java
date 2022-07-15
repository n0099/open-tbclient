package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class w82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Map<String, Integer> b;
    public static final Object c;
    public static boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755247584, "Lcom/repackage/w82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755247584, "Lcom/repackage/w82;");
                return;
            }
        }
        a = rg1.a;
        b = new HashMap();
        c = new Object();
        d = x82.a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && d) {
            if (a) {
                Log.d("ExcludeRecorder", "remove all exclude appIds");
            }
            synchronized (c) {
                b.clear();
            }
        }
    }

    @NonNull
    public static Set<String> b() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!d) {
                return Collections.emptySet();
            }
            synchronized (c) {
                strArr = (String[]) b.keySet().toArray(new String[0]);
            }
            return le3.a(strArr);
        }
        return (Set) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (d && !TextUtils.isEmpty(str)) {
                synchronized (c) {
                    containsKey = b.containsKey(str);
                }
                if (a) {
                    Log.d("ExcludeRecorder", "appId - " + str + " needExclude - " + containsKey);
                }
                return containsKey;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && d) {
            if (a) {
                Log.d("ExcludeRecorder", "record one appId for exclude - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (c) {
                Integer num = b.get(str);
                if (num == null) {
                    b.put(str, 1);
                } else {
                    b.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
    }

    public static void e(nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, nd4Var) == null) && d && nd4Var != null) {
            for (d94 d94Var : nd4Var.j()) {
                if (d94Var instanceof e94) {
                    d(d94Var.g);
                } else if (d94Var instanceof f94) {
                    d(((f94) d94Var).o);
                }
            }
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, str) == null) && d) {
            if (a) {
                Log.d("ExcludeRecorder", "remove one appId for exclude - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (c) {
                Integer num = b.get(str);
                if (num != null) {
                    int intValue = num.intValue() - 1;
                    if (intValue <= 0) {
                        b.remove(str);
                    } else {
                        b.put(str, Integer.valueOf(intValue));
                    }
                }
            }
        }
    }
}
