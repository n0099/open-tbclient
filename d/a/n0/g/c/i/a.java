package d.a.n0.g.c.i;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.e;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f49687a;

    /* renamed from: b  reason: collision with root package name */
    public String f49688b;

    /* renamed from: c  reason: collision with root package name */
    public String f49689c;

    /* renamed from: d  reason: collision with root package name */
    public String f49690d;

    /* renamed from: e  reason: collision with root package name */
    public String f49691e;

    /* renamed from: f  reason: collision with root package name */
    public String f49692f;

    /* renamed from: g  reason: collision with root package name */
    public String f49693g;

    /* renamed from: h  reason: collision with root package name */
    public String f49694h;

    /* renamed from: i  reason: collision with root package name */
    public String f49695i;

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
        this.f49687a = "swan";
        this.f49690d = "";
        this.f49691e = "";
        this.f49692f = "";
        this.f49693g = "";
        this.f49694h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f49687a = k.m(L.G());
        this.f49689c = L.H();
        this.f49688b = L.T();
        this.f49692f = L.r0().getString("aiapp_extra_need_download", "");
        this.f49693g = L.W();
        this.f49694h = L.e0();
        this.f49695i = L.V();
        this.f49690d = L.u1();
        this.f49691e = L.v1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f49687a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f49689c);
                jSONObject.put("source", this.f49688b);
                jSONObject.put("needDown", this.f49692f);
                jSONObject.put("scheme", this.f49693g);
                jSONObject.put("extPage", this.f49694h);
                jSONObject.put("launchId", this.f49695i);
                jSONObject.put("appVersion", this.f49690d);
                jSONObject.put("thirdVersion", this.f49691e);
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
        this.f49687a = "swan";
        this.f49690d = "";
        this.f49691e = "";
        this.f49692f = "";
        this.f49693g = "";
        this.f49694h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f49687a = jSONObject.optString("from", "swan");
        this.f49689c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f49688b = jSONObject.optString("source");
        this.f49692f = jSONObject.optString("needDown");
        this.f49693g = jSONObject.optString("scheme");
        this.f49694h = jSONObject.optString("extPage");
        this.f49695i = jSONObject.optString("launchId", null);
        this.f49690d = jSONObject.optString("appVersion");
        this.f49691e = jSONObject.optString("thirdVersion");
    }
}
