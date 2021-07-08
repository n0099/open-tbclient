package d.a.n0.a.h1.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.n0.a.h1.c.h.c D;

    public g() {
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

    @Override // d.a.n0.a.h1.c.c, d.a.n0.a.c0.b.b, d.a.n0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        jSONObject.optString("cb");
        double optDouble = jSONObject.optDouble("latitude");
        double optDouble2 = jSONObject.optDouble("longitude");
        jSONObject.optString("guideKey");
        jSONObject.optString("guideIcon");
        if (Double.isNaN(optDouble) || Double.isNaN(optDouble2) || optDouble < -90.0d || optDouble > 90.0d || optDouble2 < -180.0d || optDouble2 > 180.0d) {
            return;
        }
        d.a.n0.a.h1.c.h.c cVar = new d.a.n0.a.h1.c.h.c();
        this.D = cVar;
        cVar.a(jSONObject);
    }

    @Override // d.a.n0.a.c0.b.b, d.a.n0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.D != null : invokeV.booleanValue;
    }
}
