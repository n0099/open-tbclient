package d.a.n0.a.h1.c.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements d.a.n0.a.l1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f45296e;

    /* renamed from: f  reason: collision with root package name */
    public int f45297f;

    /* renamed from: g  reason: collision with root package name */
    public int f45298g;

    /* renamed from: h  reason: collision with root package name */
    public int f45299h;

    /* renamed from: i  reason: collision with root package name */
    public float f45300i;

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
                return;
            }
        }
        this.f45297f = 0;
        this.f45298g = -16777216;
        this.f45299h = -1;
        this.f45300i = 0.0f;
    }

    @Override // d.a.n0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("radius")) {
            c cVar = new c();
            this.f45296e = cVar;
            cVar.a(jSONObject);
            if (this.f45296e.isValid()) {
                this.f45297f = d.a.n0.a.h1.c.d.a(jSONObject.optString("color"), 0);
                this.f45298g = d.a.n0.a.h1.c.d.a(jSONObject.optString("fillColor"), -16777216);
                this.f45299h = jSONObject.optInt("radius", -1);
                this.f45300i = Math.abs(d.a.n0.a.h1.c.d.b(jSONObject.optDouble("strokeWidth", 0.0d)));
            }
        }
    }

    @Override // d.a.n0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c cVar = this.f45296e;
            return (cVar == null || !cVar.isValid() || this.f45299h == -1) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "coordinate ->" + this.f45296e + "color ->" + this.f45297f + "fillColor ->" + this.f45298g + "radius ->" + this.f45299h + "strokeWidth ->" + this.f45300i;
        }
        return (String) invokeV.objValue;
    }
}
