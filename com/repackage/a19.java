package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a19 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile a19 c;
    public transient /* synthetic */ FieldHolder $fh;
    public b19 a;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Map<String, JSONObject> b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
            this.b = new HashMap();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755909496, "Lcom/repackage/a19;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755909496, "Lcom/repackage/a19;");
                return;
            }
        }
        b = e19.m();
    }

    public a19() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a19 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (a19.class) {
                    if (c == null) {
                        c = new a19();
                    }
                }
            }
            return c;
        }
        return (a19) invokeV.objValue;
    }

    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && !TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str) && b()) {
            this.a.c(str, z);
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            j09 o = j09.o();
            if (o == null || o.g("2980", 32)) {
                return o == null || !o.d("2980");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            j09 o = j09.o();
            if (o == null || o.g("2980", 32)) {
                return o == null || !o.d("2980");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d(o19 o19Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, o19Var)) == null) {
            if (o19Var == null || o19Var.w() || !c()) {
                return false;
            }
            this.a.f();
            Map<String, a> v = this.a.v(7);
            if (v != null && v.size() != 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    boolean z = false;
                    for (String str : v.keySet()) {
                        a aVar = v.get(str);
                        if (aVar != null && !TextUtils.isEmpty(str)) {
                            JSONObject jSONObject2 = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            for (JSONObject jSONObject3 : aVar.b.values()) {
                                jSONArray.put(jSONObject3);
                            }
                            jSONObject2.put("total", aVar.a);
                            jSONObject2.put("data", jSONArray);
                            jSONObject.put(str.replace("-", ""), jSONObject2);
                            z = true;
                        }
                    }
                    if (z) {
                        q09 q09Var = new q09("2980");
                        q09Var.y(jSONObject);
                        q09Var.B(System.currentTimeMillis());
                        o19Var.c(q09Var, q09Var.g());
                        o19Var.a(v.keySet());
                        return true;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void e(Map<String, a> map, String str, String str2, int i, int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{map, str, str2, Integer.valueOf(i), Integer.valueOf(i2)}) == null) || map == null) {
            return;
        }
        if (map.containsKey(str)) {
            aVar = map.get(str);
        } else {
            a aVar2 = new a();
            map.put(str, aVar2);
            aVar = aVar2;
        }
        Map<String, JSONObject> map2 = aVar.b;
        if (map2.containsKey(str2) && b) {
            Log.e("UBCArrivalStatics", "*******duplicate ubc id record: " + str2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", str2);
            jSONObject.put("c", i);
            jSONObject.put("cc", i2);
            aVar.a += i;
            map2.put(str2, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void g(b19 b19Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, b19Var) == null) {
            this.a = b19Var;
        }
    }
}
