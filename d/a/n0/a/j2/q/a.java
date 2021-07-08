package d.a.n0.a.j2.q;

import android.text.TextUtils;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.d;
import d.a.n0.a.a2.e;
import d.a.n0.a.j2.b;
import d.a.n0.a.j2.k;
import d.a.n0.a.v2.q;
import d.a.n0.a.v2.w;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.j2.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC0793a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45826e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45827f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45828g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45829h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ SwanInterfaceType f45830i;

        public RunnableC0793a(int i2, String str, String str2, String str3, SwanInterfaceType swanInterfaceType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, str2, str3, swanInterfaceType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45826e = i2;
            this.f45827f = str;
            this.f45828g = str2;
            this.f45829h = str3;
            this.f45830i = swanInterfaceType;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f45826e;
                boolean z = (i2 == 2000 || i2 == 0) ? false : true;
                String m = k.m(d.g().l());
                JSONObject jSONObject = new JSONObject();
                w.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.g().getAppId());
                w.f(jSONObject, "hostName", d.a.n0.a.c1.a.m().a());
                w.f(jSONObject, "network", d.a.n0.t.a.e());
                w.f(jSONObject, "launchid", d.g().r().L().V());
                if (z) {
                    w.f(jSONObject, "response", this.f45827f);
                    w.f(jSONObject, "statusCode", this.f45828g);
                    w.f(jSONObject, "request_url", this.f45829h);
                }
                a.d(m, this.f45830i.getClassify(), this.f45830i.getInterfaceName(), this.f45826e, jSONObject, z);
            }
        }
    }

    public static void a(SwanInterfaceType swanInterfaceType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, swanInterfaceType) == null) {
            c(swanInterfaceType, 2000, null, null);
        }
    }

    public static void b(SwanInterfaceType swanInterfaceType, int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{swanInterfaceType, Integer.valueOf(i2), str, str2, str3}) == null) {
            q.i(new RunnableC0793a(i2, str3, str2, str, swanInterfaceType), "onInterfaceStabilityStatistic");
        }
    }

    public static void c(SwanInterfaceType swanInterfaceType, int i2, String str, Response response) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65538, null, swanInterfaceType, i2, str, response) == null) {
            String str3 = null;
            if (response != null) {
                String valueOf = String.valueOf(response.code());
                str3 = response.request().url().toString();
                str2 = valueOf;
            } else {
                str2 = null;
            }
            b(swanInterfaceType, i2, str3, str2, str);
        }
    }

    public static void d(String str, String str2, String str3, int i2, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Integer.valueOf(i2), jSONObject, Boolean.valueOf(z)}) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("from", str);
                jSONObject2.put("type", str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("page", str3);
                }
                jSONObject2.put("value", String.valueOf(i2));
                if (jSONObject != null) {
                    jSONObject2.put("ext", jSONObject);
                }
                b.k("874", jSONObject2);
                if (z) {
                    b.i("2486", "86", jSONObject2);
                }
            } catch (JSONException e2) {
                if (e.y) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
