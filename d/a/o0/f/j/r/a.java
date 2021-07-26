package d.a.o0.f.j.r;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.f1.e.b;
import d.a.o0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f50072a;

    /* renamed from: b  reason: collision with root package name */
    public String f50073b;

    /* renamed from: c  reason: collision with root package name */
    public String f50074c;

    /* renamed from: d  reason: collision with root package name */
    public String f50075d;

    /* renamed from: e  reason: collision with root package name */
    public String f50076e;

    /* renamed from: f  reason: collision with root package name */
    public String f50077f;

    /* renamed from: g  reason: collision with root package name */
    public String f50078g;

    /* renamed from: h  reason: collision with root package name */
    public String f50079h;

    /* renamed from: i  reason: collision with root package name */
    public String f50080i;

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
        this.f50072a = "swan";
        this.f50075d = "";
        this.f50076e = "";
        this.f50077f = "";
        this.f50078g = "";
        this.f50079h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f50072a = k.m(L.G());
        this.f50074c = L.H();
        this.f50073b = L.T();
        this.f50077f = L.r0().getString("aiapp_extra_need_download", "");
        this.f50078g = L.W();
        this.f50079h = L.e0();
        this.f50080i = L.V();
        this.f50075d = L.u1();
        this.f50076e = L.v1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f50072a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f50074c);
                jSONObject.put("source", this.f50073b);
                jSONObject.put("needDown", this.f50077f);
                jSONObject.put("scheme", this.f50078g);
                jSONObject.put("extPage", this.f50079h);
                jSONObject.put("launchId", this.f50080i);
                jSONObject.put("appVersion", this.f50075d);
                jSONObject.put("thirdVersion", this.f50076e);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50072a = "swan";
        this.f50075d = "";
        this.f50076e = "";
        this.f50077f = "";
        this.f50078g = "";
        this.f50079h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f50072a = jSONObject.optString("from", "swan");
        this.f50074c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f50073b = jSONObject.optString("source");
        this.f50077f = jSONObject.optString("needDown");
        this.f50078g = jSONObject.optString("scheme");
        this.f50079h = jSONObject.optString("extPage");
        this.f50080i = jSONObject.optString("launchId", null);
        this.f50075d = jSONObject.optString("appVersion");
        this.f50076e = jSONObject.optString("thirdVersion");
    }
}
