package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qc implements mc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Object> a;

    public qc(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = map;
    }

    @Override // com.repackage.mc
    public Object a(ce ceVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ceVar)) == null) {
            Object f = f(ceVar);
            if (f != null) {
                if (f instanceof JSONObject) {
                    return f.toString();
                }
                return f instanceof JSONArray ? f.toString() : f;
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // com.repackage.mc
    public Object b(ce ceVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ceVar)) == null) ? this.a : invokeL.objValue;
    }

    @Override // com.repackage.mc
    public Object c(ce ceVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ceVar)) == null) ? this.a : invokeL.objValue;
    }

    @Override // com.repackage.mc
    public Object d(ce ceVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ceVar)) == null) {
            Object f = f(ceVar);
            if (f == null || !(f instanceof JSONObject)) {
                return null;
            }
            return f.toString();
        }
        return invokeL.objValue;
    }

    @Override // com.repackage.mc
    public Object e(ce ceVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ceVar)) == null) ? d(ceVar) : invokeL.objValue;
    }

    @Override // com.repackage.mc
    public Object f(ce ceVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ceVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.a == null) {
                return jSONObject;
            }
            Type[] b = ceVar.b();
            for (String str : this.a.keySet()) {
                Object obj = this.a.get(str);
                if (b != null && b.length >= 2) {
                    try {
                        jSONObject.put(str, fe.a(obj).f(new ce(b[1])));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        jSONObject.put(str, fe.a(obj).f(new ce(ceVar.a())));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return invokeL.objValue;
    }
}
