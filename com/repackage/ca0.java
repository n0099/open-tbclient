package com.repackage;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ca0 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, u90> a;
    public static List<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755804065, "Lcom/repackage/ca0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755804065, "Lcom/repackage/ca0;");
                return;
            }
        }
        a = new HashMap();
        b = new ArrayList();
    }

    public static void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || a.isEmpty() || rb0.c(list)) {
            return;
        }
        Iterator<Map.Entry<String, u90>> it = a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, u90> next = it.next();
            if (next != null && list.contains(next.getKey())) {
                it.remove();
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a.isEmpty()) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, u90> entry : a.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    u90 value = entry.getValue();
                    if (value != null && (a2 = value.a()) != null) {
                        jSONArray.put(a2);
                        b.add(key);
                    }
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void c(String str, boolean z, boolean z2) {
        u90 u90Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || xb0.a(str)) {
            return;
        }
        if (a.containsKey(str)) {
            u90Var = a.get(str);
        } else {
            u90Var = new u90();
            a.put(str, u90Var);
        }
        u90Var.a = str;
        if (z2) {
            u90Var.c = 1;
            u90Var.e = System.currentTimeMillis() / 1000;
        }
        if (z) {
            u90Var.b = 1;
            u90Var.d = System.currentTimeMillis() / 1000;
        }
    }
}
