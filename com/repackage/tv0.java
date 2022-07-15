package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class tv0 {
    public static /* synthetic */ Interceptable $ic;
    public static final tv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755277437, "Lcom/repackage/tv0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755277437, "Lcom/repackage/tv0;");
                return;
            }
        }
        a = new tv0();
    }

    public tv0() {
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

    @JvmStatic
    public static final JSONArray b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            zv0 c = a.c(str);
            if (c != null) {
                JSONArray jSONArray = new JSONArray();
                uv0.a(c, jSONArray);
                sv0.a(c, jSONArray);
                return jSONArray;
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i == 0 : invokeI.booleanValue;
    }

    public final zv0 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("version", -1);
                    if (a.a(optInt)) {
                        zv0 zv0Var = new zv0();
                        zv0Var.e(optInt);
                        zv0Var.d(jSONObject.optString("mode"));
                        uv0.b(zv0Var, jSONObject);
                        sv0.b(zv0Var, jSONObject);
                        Unit unit = Unit.INSTANCE;
                        return zv0Var;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (zv0) invokeL.objValue;
    }
}
