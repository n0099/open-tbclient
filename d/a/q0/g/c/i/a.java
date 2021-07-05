package d.a.q0.g.c.i;

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
    public String f52989a;

    /* renamed from: b  reason: collision with root package name */
    public String f52990b;

    /* renamed from: c  reason: collision with root package name */
    public String f52991c;

    /* renamed from: d  reason: collision with root package name */
    public String f52992d;

    /* renamed from: e  reason: collision with root package name */
    public String f52993e;

    /* renamed from: f  reason: collision with root package name */
    public String f52994f;

    /* renamed from: g  reason: collision with root package name */
    public String f52995g;

    /* renamed from: h  reason: collision with root package name */
    public String f52996h;

    /* renamed from: i  reason: collision with root package name */
    public String f52997i;

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
        this.f52989a = "swan";
        this.f52992d = "";
        this.f52993e = "";
        this.f52994f = "";
        this.f52995g = "";
        this.f52996h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f52989a = k.m(L.G());
        this.f52991c = L.H();
        this.f52990b = L.T();
        this.f52994f = L.r0().getString("aiapp_extra_need_download", "");
        this.f52995g = L.W();
        this.f52996h = L.e0();
        this.f52997i = L.V();
        this.f52992d = L.u1();
        this.f52993e = L.v1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f52989a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f52991c);
                jSONObject.put("source", this.f52990b);
                jSONObject.put("needDown", this.f52994f);
                jSONObject.put("scheme", this.f52995g);
                jSONObject.put("extPage", this.f52996h);
                jSONObject.put("launchId", this.f52997i);
                jSONObject.put("appVersion", this.f52992d);
                jSONObject.put("thirdVersion", this.f52993e);
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
        this.f52989a = "swan";
        this.f52992d = "";
        this.f52993e = "";
        this.f52994f = "";
        this.f52995g = "";
        this.f52996h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f52989a = jSONObject.optString("from", "swan");
        this.f52991c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f52990b = jSONObject.optString("source");
        this.f52994f = jSONObject.optString("needDown");
        this.f52995g = jSONObject.optString("scheme");
        this.f52996h = jSONObject.optString("extPage");
        this.f52997i = jSONObject.optString("launchId", null);
        this.f52992d = jSONObject.optString("appVersion");
        this.f52993e = jSONObject.optString("thirdVersion");
    }
}
