package d.a.q0.a.h1.c.h;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b implements d.a.q0.a.l1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f48603e;

    /* renamed from: f  reason: collision with root package name */
    public String f48604f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48605g;

    /* renamed from: h  reason: collision with root package name */
    public g f48606h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(929590265, "Ld/a/q0/a/h1/c/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(929590265, "Ld/a/q0/a/h1/c/h/b;");
                return;
            }
        }
        boolean z = k.f49133a;
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
                return;
            }
        }
        this.f48604f = "";
        this.f48605g = false;
    }

    @Override // d.a.q0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            String optString = jSONObject.optString("controlId");
            this.f48603e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f48603e = jSONObject.optString("id");
            }
            g gVar = new g();
            this.f48606h = gVar;
            gVar.a(jSONObject.optJSONObject("position"));
            this.f48604f = jSONObject.optString("iconPath");
            this.f48605g = jSONObject.optBoolean("clickable");
        }
    }

    @Override // d.a.q0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            g gVar = this.f48606h;
            return (gVar == null || !gVar.isValid() || TextUtils.isEmpty(this.f48604f)) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
