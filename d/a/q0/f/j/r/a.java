package d.a.q0.f.j.r;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f52870a;

    /* renamed from: b  reason: collision with root package name */
    public String f52871b;

    /* renamed from: c  reason: collision with root package name */
    public String f52872c;

    /* renamed from: d  reason: collision with root package name */
    public String f52873d;

    /* renamed from: e  reason: collision with root package name */
    public String f52874e;

    /* renamed from: f  reason: collision with root package name */
    public String f52875f;

    /* renamed from: g  reason: collision with root package name */
    public String f52876g;

    /* renamed from: h  reason: collision with root package name */
    public String f52877h;

    /* renamed from: i  reason: collision with root package name */
    public String f52878i;

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
        this.f52870a = "swan";
        this.f52873d = "";
        this.f52874e = "";
        this.f52875f = "";
        this.f52876g = "";
        this.f52877h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f52870a = k.m(L.G());
        this.f52872c = L.H();
        this.f52871b = L.T();
        this.f52875f = L.r0().getString("aiapp_extra_need_download", "");
        this.f52876g = L.W();
        this.f52877h = L.e0();
        this.f52878i = L.V();
        this.f52873d = L.u1();
        this.f52874e = L.v1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f52870a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f52872c);
                jSONObject.put("source", this.f52871b);
                jSONObject.put("needDown", this.f52875f);
                jSONObject.put("scheme", this.f52876g);
                jSONObject.put("extPage", this.f52877h);
                jSONObject.put("launchId", this.f52878i);
                jSONObject.put("appVersion", this.f52873d);
                jSONObject.put("thirdVersion", this.f52874e);
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
        this.f52870a = "swan";
        this.f52873d = "";
        this.f52874e = "";
        this.f52875f = "";
        this.f52876g = "";
        this.f52877h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f52870a = jSONObject.optString("from", "swan");
        this.f52872c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f52871b = jSONObject.optString("source");
        this.f52875f = jSONObject.optString("needDown");
        this.f52876g = jSONObject.optString("scheme");
        this.f52877h = jSONObject.optString("extPage");
        this.f52878i = jSONObject.optString("launchId", null);
        this.f52873d = jSONObject.optString("appVersion");
        this.f52874e = jSONObject.optString("thirdVersion");
    }
}
