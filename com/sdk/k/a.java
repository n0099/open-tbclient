package com.sdk.k;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.f.g;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.k.a";
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593018387, "Lcom/sdk/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593018387, "Lcom/sdk/k/a;");
                return;
            }
        }
        b = g.b;
    }

    public static String a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) {
            try {
                Field[] declaredFields = Class.forName(obj.getClass().getName()).getDeclaredFields();
                JSONObject jSONObject = new JSONObject();
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    String name = field.getName();
                    if (!"serialVersionUID".equals(name)) {
                        Object obj2 = field.get(obj);
                        if (field.getType().equals(ArrayList.class)) {
                            JSONArray jSONArray = new JSONArray();
                            ArrayList arrayList = (ArrayList) obj2;
                            if (arrayList != null) {
                                for (int i = 0; i < arrayList.size(); i++) {
                                    Object obj3 = arrayList.get(i);
                                    Class<?> cls = obj3.getClass();
                                    if (cls.equals(KInfo.class)) {
                                        Field[] declaredFields2 = cls.getDeclaredFields();
                                        JSONObject jSONObject2 = new JSONObject();
                                        for (Field field2 : declaredFields2) {
                                            field2.setAccessible(true);
                                            jSONObject2.put(field2.getName(), field2.get(obj3));
                                        }
                                        jSONArray.put(jSONObject2);
                                    } else {
                                        jSONArray.put(obj3);
                                    }
                                }
                            }
                            obj2 = jSONArray;
                        }
                        jSONObject.put(name, obj2);
                    }
                }
                return jSONObject.toString();
            } catch (Exception e) {
                com.sdk.n.a.a(a, e.getMessage(), Boolean.valueOf(b));
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
