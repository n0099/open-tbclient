package d.a.q0.a.p.c;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class m implements d.a.q0.a.p.d.y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.a.q0.a.p.d.y
    public long a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? d.a.q0.a.d0.b.b().f47239a : invokeL.longValue;
    }

    @Override // d.a.q0.a.p.d.y
    public void b(Context context, String str, d.a.q0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, bVar) == null) {
            d.a.q0.a.r.a.d(str, bVar);
        }
    }

    @Override // d.a.q0.a.p.d.y
    public void c(Context context, JSONArray jSONArray, d.a.q0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONArray, bVar) == null) {
            d.a.q0.a.r.a.e(jSONArray, bVar);
        }
    }
}
