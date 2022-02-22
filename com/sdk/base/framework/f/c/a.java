package com.sdk.base.framework.f.c;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.bean.KInfo;
import com.sdk.base.framework.c.f;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.base.framework.f.c.a";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f59466b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1065773551, "Lcom/sdk/base/framework/f/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1065773551, "Lcom/sdk/base/framework/f/c/a;");
                return;
            }
        }
        f59466b = f.f59448b;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
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
                                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                    Object obj3 = arrayList.get(i2);
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
            } catch (Exception e2) {
                c.b(a, e2.getMessage(), Boolean.valueOf(f59466b));
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
