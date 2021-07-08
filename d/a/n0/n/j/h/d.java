package d.a.n0.n.j.h;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.n.f.g;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends d.a.n0.n.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    @Override // d.a.n0.n.j.a, d.a.n0.n.j.d
    public void b(JSONObject jSONObject, g gVar, @Nullable g gVar2, @Nullable g gVar3) {
        a d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, gVar, gVar2, gVar3) == null) || jSONObject == null || (d2 = b.c().d(jSONObject)) == null) {
            return;
        }
        d.a.n0.n.c.b().A(d2);
    }
}
