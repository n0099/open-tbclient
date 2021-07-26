package d.a.o0.a.h0.m.n;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.h;
import d.a.o0.a.a2.m;
import d.a.o0.n.i.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class a extends m implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.o0.a.a2.d dVar) {
        super(dVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static final Map<String, String> e(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bundle)) == null) {
            HashMap hashMap = new HashMap();
            if (bundle != null && !bundle.isEmpty()) {
                for (String str : bundle.keySet()) {
                    hashMap.put(str, bundle.getString(str));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static final Bundle f(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            Bundle bundle = new Bundle();
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    bundle.putString(entry.getKey(), entry.getValue());
                }
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // d.a.o0.n.i.g
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
            d.a.o0.a.c1.a.i0().a(str, map, map2, jSONObject, aVar);
        }
    }

    @Override // d.a.o0.n.i.g
    public void c(String str, Map<String, String> map, Map<String, String> map2, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, map2, aVar) == null) {
            d.a.o0.a.c1.a.i0().c(str, map, map2, aVar);
        }
    }
}
