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
/* loaded from: classes6.dex */
public class p80 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, h80> a;
    public static List<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755456183, "Lcom/repackage/p80;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755456183, "Lcom/repackage/p80;");
                return;
            }
        }
        a = new HashMap();
        b = new ArrayList();
    }

    public static void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || a.isEmpty() || ea0.c(list)) {
            return;
        }
        Iterator<Map.Entry<String, h80>> it = a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, h80> next = it.next();
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
            for (Map.Entry<String, h80> entry : a.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    h80 value = entry.getValue();
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
        h80 h80Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || ka0.a(str)) {
            return;
        }
        if (a.containsKey(str)) {
            h80Var = a.get(str);
        } else {
            h80Var = new h80();
            a.put(str, h80Var);
        }
        h80Var.a = str;
        if (z2) {
            h80Var.c = 1;
            h80Var.e = System.currentTimeMillis() / 1000;
        }
        if (z) {
            h80Var.b = 1;
            h80Var.d = System.currentTimeMillis() / 1000;
        }
    }
}
