package d.a.c.e.b.b.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f44037a;

    public e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44037a = jSONObject;
    }

    @Override // d.a.c.e.b.b.a.c.c
    public Set<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Iterator<String> keys = this.f44037a.keys();
            if (keys != null) {
                HashSet hashSet = new HashSet();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null) {
                        hashSet.add(next.toString());
                    }
                }
                return hashSet;
            }
            return null;
        }
        return (Set) invokeV.objValue;
    }

    @Override // d.a.c.e.b.b.a.c.c
    public void b(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            try {
                this.f44037a.putOpt(str, obj);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.c.e.b.b.a.c.c
    public Object c(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, type)) == null) {
            Object d2 = d(str);
            if (d2 != null) {
                d.a.c.e.b.b.a.e.c cVar = new d.a.c.e.b.b.a.e.c(type);
                d.a.c.e.b.b.a.d.h a2 = d.a.c.e.b.b.a.e.g.a(d2);
                return a2 != null ? a2.a(cVar) : d2;
            }
            return d2;
        }
        return invokeLL.objValue;
    }

    public Object d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.f44037a.opt(str) : invokeL.objValue;
    }
}
