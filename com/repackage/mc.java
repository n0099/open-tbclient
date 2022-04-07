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
/* loaded from: classes6.dex */
public class mc implements ic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Object> a;

    public mc(Map<String, Object> map) {
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

    @Override // com.repackage.ic
    public Object a(yd ydVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ydVar)) == null) {
            Object f = f(ydVar);
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

    @Override // com.repackage.ic
    public Object b(yd ydVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ydVar)) == null) ? this.a : invokeL.objValue;
    }

    @Override // com.repackage.ic
    public Object c(yd ydVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ydVar)) == null) ? this.a : invokeL.objValue;
    }

    @Override // com.repackage.ic
    public Object d(yd ydVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ydVar)) == null) {
            Object f = f(ydVar);
            if (f == null || !(f instanceof JSONObject)) {
                return null;
            }
            return f.toString();
        }
        return invokeL.objValue;
    }

    @Override // com.repackage.ic
    public Object e(yd ydVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ydVar)) == null) ? d(ydVar) : invokeL.objValue;
    }

    @Override // com.repackage.ic
    public Object f(yd ydVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ydVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.a == null) {
                return jSONObject;
            }
            Type[] b = ydVar.b();
            for (String str : this.a.keySet()) {
                Object obj = this.a.get(str);
                if (b != null && b.length >= 2) {
                    try {
                        jSONObject.put(str, be.a(obj).f(new yd(b[1])));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        jSONObject.put(str, be.a(obj).f(new yd(ydVar.a())));
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
