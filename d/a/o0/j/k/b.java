package d.a.o0.j.k;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.k;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends a<d.a.o0.a.h1.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(412750027, "Ld/a/o0/j/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(412750027, "Ld/a/o0/j/k/b;");
                return;
            }
        }
        boolean z = k.f46335a;
    }

    public b() {
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

    public static b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new b() : (b) invokeV.objValue;
    }

    @Override // d.a.o0.j.k.a
    public boolean b(Context context, d.a.o0.a.h1.c.c cVar, d.a.o0.a.h1.b bVar, e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, cVar, bVar, eVar, jSONObject)) == null) ? d(context, cVar, bVar, eVar) : invokeLLLLL.booleanValue;
    }

    public final boolean d(Context context, d.a.o0.a.h1.c.c cVar, d.a.o0.a.h1.b bVar, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cVar, bVar, eVar)) == null) {
            d.a.o0.a.e0.d.g("map", "MapCreateAction start");
            boolean a2 = d.a.o0.j.c.b().a(context, cVar);
            d.a.o0.a.e0.d.g("map", "MapCreateAction end");
            return a2;
        }
        return invokeLLLL.booleanValue;
    }
}
