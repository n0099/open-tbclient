package d.a.n0.a.h1.c.h;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements d.a.n0.a.l1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f45301e;

    /* renamed from: f  reason: collision with root package name */
    public String f45302f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45303g;

    /* renamed from: h  reason: collision with root package name */
    public g f45304h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1848701156, "Ld/a/n0/a/h1/c/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1848701156, "Ld/a/n0/a/h1/c/h/b;");
                return;
            }
        }
        boolean z = k.f45831a;
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
        this.f45302f = "";
        this.f45303g = false;
    }

    @Override // d.a.n0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && jSONObject != null && jSONObject.has("position") && jSONObject.has("iconPath")) {
            String optString = jSONObject.optString("controlId");
            this.f45301e = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f45301e = jSONObject.optString("id");
            }
            g gVar = new g();
            this.f45304h = gVar;
            gVar.a(jSONObject.optJSONObject("position"));
            this.f45302f = jSONObject.optString("iconPath");
            this.f45303g = jSONObject.optBoolean("clickable");
        }
    }

    @Override // d.a.n0.a.l1.a
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            g gVar = this.f45304h;
            return (gVar == null || !gVar.isValid() || TextUtils.isEmpty(this.f45302f)) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
