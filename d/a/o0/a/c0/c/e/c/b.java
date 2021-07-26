package d.a.o0.a.c0.c.e.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.c0.a.c.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int G;
    public String H;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("coverView", "viewId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.H = "";
    }

    @Override // d.a.o0.a.c0.a.c.c, d.a.o0.a.c0.a.d.b, d.a.o0.a.c0.b.b, d.a.o0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.G = jSONObject.optInt("scrollTop");
        JSONObject jSONObject3 = this.n;
        if (jSONObject3 != null) {
            this.H = jSONObject3.optString("overflowY");
        }
        d.a.o0.a.l1.e.a.a aVar = this.l;
        if (aVar == null || (jSONObject2 = this.n) == null) {
            return;
        }
        aVar.l(jSONObject2.optBoolean("fixed", false));
    }
}
