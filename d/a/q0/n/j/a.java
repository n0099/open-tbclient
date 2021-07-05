package d.a.q0.n.j;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class a implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // d.a.q0.n.j.d
    public void a(JSONArray jSONArray, d.a.q0.n.f.g gVar, @Nullable d.a.q0.n.f.g gVar2, @Nullable d.a.q0.n.f.g gVar3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, gVar, gVar2, gVar3) == null) {
        }
    }

    @Override // d.a.q0.n.j.d
    public void b(JSONObject jSONObject, d.a.q0.n.f.g gVar, @Nullable d.a.q0.n.f.g gVar2, @Nullable d.a.q0.n.f.g gVar3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, gVar, gVar2, gVar3) == null) {
        }
    }
}
