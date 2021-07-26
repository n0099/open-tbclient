package d.a.o0.g.c.c;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.k0;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e extends d.a.o0.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e() {
        super("getAvailableSpace");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.g.f.a
    public d.a.o0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.o0.a.u0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("data", k0.c());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            bVar.a(jSONObject2);
            return null;
        }
        return (d.a.o0.a.u.h.b) invokeLL.objValue;
    }
}
