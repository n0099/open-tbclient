package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bc implements ic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object a;

    public bc(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (obj == null || !obj.getClass().isArray()) {
            return;
        }
        this.a = obj;
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
            Object obj = this.a;
            if (obj != null) {
                Class<?> componentType = obj.getClass().getComponentType();
                if (componentType == Boolean.TYPE) {
                    return this.a;
                }
                if (componentType == Byte.TYPE) {
                    return this.a;
                }
                if (componentType == Character.TYPE) {
                    return this.a;
                }
                if (componentType == Double.TYPE) {
                    return this.a;
                }
                if (componentType == Float.TYPE) {
                    return this.a;
                }
                if (componentType == Integer.TYPE) {
                    return this.a;
                }
                if (componentType == Long.TYPE) {
                    return this.a;
                }
                if (componentType == Short.TYPE) {
                    return this.a;
                }
                if (componentType == String.class) {
                    return this.a;
                }
                int length = Array.getLength(this.a);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < length; i++) {
                    Object f = be.a(Array.get(this.a, i)).f(new yd(componentType));
                    if (f != null) {
                        jSONArray.put(f);
                    }
                }
                return jSONArray.toString();
            }
            return null;
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
            Object obj = this.a;
            if (obj != null) {
                Class<?> componentType = obj.getClass().getComponentType();
                if (componentType == Character.TYPE) {
                    return String.valueOf((char[]) this.a);
                }
                if (componentType == Byte.TYPE) {
                    try {
                        ci.k((byte[]) this.a, 0);
                    } catch (Exception unused) {
                        return null;
                    }
                } else {
                    int length = Array.getLength(this.a);
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < length; i++) {
                        Object f = be.a(Array.get(this.a, i)).f(new yd(componentType));
                        if (f != null) {
                            jSONArray.put(f);
                        }
                    }
                    return jSONArray;
                }
            }
            return null;
        }
        return invokeL.objValue;
    }
}
