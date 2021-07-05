package d.a.q0.a.a0.a.j;

import android.graphics.Canvas;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class x extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i f46613a;

    public x() {
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

    @Override // d.a.q0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, bVar, canvas) == null) && (iVar = this.f46613a) != null && iVar.d()) {
            if (this.f46613a.c()) {
                bVar.f46521f.setShader(this.f46613a.b());
                return;
            }
            bVar.f46524i.setColor(this.f46613a.a());
            bVar.f46521f.setColor(this.f46613a.a());
            bVar.f46521f.setShader(null);
        }
    }

    @Override // d.a.q0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) || jSONArray.length() <= 0) {
            return;
        }
        this.f46613a = new i(jSONArray);
    }
}
