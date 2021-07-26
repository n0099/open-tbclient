package d.a.o0.g.c.i;

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
    public String f50191a;

    /* renamed from: b  reason: collision with root package name */
    public String f50192b;

    /* renamed from: c  reason: collision with root package name */
    public String f50193c;

    /* renamed from: d  reason: collision with root package name */
    public String f50194d;

    /* renamed from: e  reason: collision with root package name */
    public String f50195e;

    /* renamed from: f  reason: collision with root package name */
    public String f50196f;

    /* renamed from: g  reason: collision with root package name */
    public String f50197g;

    /* renamed from: h  reason: collision with root package name */
    public String f50198h;

    /* renamed from: i  reason: collision with root package name */
    public String f50199i;

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
        this.f50191a = "swan";
        this.f50194d = "";
        this.f50195e = "";
        this.f50196f = "";
        this.f50197g = "";
        this.f50198h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f50191a = k.m(L.G());
        this.f50193c = L.H();
        this.f50192b = L.T();
        this.f50196f = L.r0().getString("aiapp_extra_need_download", "");
        this.f50197g = L.W();
        this.f50198h = L.e0();
        this.f50199i = L.V();
        this.f50194d = L.u1();
        this.f50195e = L.v1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f50191a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f50193c);
                jSONObject.put("source", this.f50192b);
                jSONObject.put("needDown", this.f50196f);
                jSONObject.put("scheme", this.f50197g);
                jSONObject.put("extPage", this.f50198h);
                jSONObject.put("launchId", this.f50199i);
                jSONObject.put("appVersion", this.f50194d);
                jSONObject.put("thirdVersion", this.f50195e);
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
        this.f50191a = "swan";
        this.f50194d = "";
        this.f50195e = "";
        this.f50196f = "";
        this.f50197g = "";
        this.f50198h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f50191a = jSONObject.optString("from", "swan");
        this.f50193c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f50192b = jSONObject.optString("source");
        this.f50196f = jSONObject.optString("needDown");
        this.f50197g = jSONObject.optString("scheme");
        this.f50198h = jSONObject.optString("extPage");
        this.f50199i = jSONObject.optString("launchId", null);
        this.f50194d = jSONObject.optString("appVersion");
        this.f50195e = jSONObject.optString("thirdVersion");
    }
}
