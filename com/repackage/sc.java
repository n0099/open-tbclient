package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class sc implements mc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Queue<?> a;

    public sc(Queue<?> queue) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {queue};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = queue;
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
            Type[] b = ceVar.b();
            ArrayList arrayList = new ArrayList();
            for (Object obj : this.a) {
                if (obj != null) {
                    if (b != null && b.length >= 1) {
                        Object f = fe.a(obj).f(new ce(b[0]));
                        if (f != null) {
                            arrayList.add(f.toString());
                        }
                    } else {
                        Object f2 = fe.a(obj).f(new ce(ceVar.a()));
                        if (f2 != null) {
                            arrayList.add(f2.toString());
                        }
                    }
                }
            }
            return arrayList;
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
            Type[] b = ceVar.b();
            JSONArray jSONArray = new JSONArray();
            for (Object obj : this.a) {
                if (obj != null) {
                    if (b != null && b.length >= 1) {
                        Object f = fe.a(obj).f(new ce(b[0]));
                        if (f != null) {
                            jSONArray.put(f);
                        }
                    } else {
                        Object f2 = fe.a(obj).f(new ce(ceVar.a()));
                        if (f2 != null) {
                            jSONArray.put(f2);
                        }
                    }
                }
            }
            return jSONArray;
        }
        return invokeL.objValue;
    }
}
