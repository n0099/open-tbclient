package d.a.c.e.b.b.a.b;

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
/* loaded from: classes8.dex */
public class l implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f44025a;

    public l(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44025a = map;
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object a(d.a.c.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            Object f2 = f(cVar);
            if (f2 != null) {
                if (f2 instanceof JSONObject) {
                    return f2.toString();
                }
                return f2 instanceof JSONArray ? f2.toString() : f2;
            }
            return null;
        }
        return invokeL.objValue;
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object b(d.a.c.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) ? this.f44025a : invokeL.objValue;
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object c(d.a.c.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) ? this.f44025a : invokeL.objValue;
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object d(d.a.c.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            Object f2 = f(cVar);
            if (f2 == null || !(f2 instanceof JSONObject)) {
                return null;
            }
            return f2.toString();
        }
        return invokeL.objValue;
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object e(d.a.c.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) ? d(cVar) : invokeL.objValue;
    }

    @Override // d.a.c.e.b.b.a.b.h
    public Object f(d.a.c.e.b.b.a.e.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.f44025a == null) {
                return jSONObject;
            }
            Type[] b2 = cVar.b();
            for (String str : this.f44025a.keySet()) {
                Object obj = this.f44025a.get(str);
                if (b2 != null && b2.length >= 2) {
                    try {
                        jSONObject.put(str, d.a.c.e.b.b.a.e.f.a(obj).f(new d.a.c.e.b.b.a.e.c(b2[1])));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    try {
                        jSONObject.put(str, d.a.c.e.b.b.a.e.f.a(obj).f(new d.a.c.e.b.b.a.e.c(cVar.a())));
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return invokeL.objValue;
    }
}
