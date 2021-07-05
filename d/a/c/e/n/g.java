package d.a.c.e.n;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f44325a;

    /* renamed from: b  reason: collision with root package name */
    public String f44326b;

    /* renamed from: c  reason: collision with root package name */
    public String f44327c;

    /* renamed from: d  reason: collision with root package name */
    public String f44328d;

    /* renamed from: e  reason: collision with root package name */
    public String f44329e;

    /* renamed from: f  reason: collision with root package name */
    public String f44330f;

    /* renamed from: g  reason: collision with root package name */
    public String f44331g;

    /* renamed from: h  reason: collision with root package name */
    public String f44332h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f44333i;

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

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? j.H() ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : j.t() ? "2G" : j.u() ? com.baidu.apollon.statistics.g.f3983b : (j.v() || j.z()) ? "4G" : "NONE" : (String) invokeV.objValue;
    }

    public void a(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.f44333i == null) {
                this.f44333i = new HashMap();
            }
            String[] split2 = str.split("&");
            if (split2 == null || split2.length == 0) {
                return;
            }
            for (String str2 : split2) {
                if (!TextUtils.isEmpty(str2) && (split = str2.split("=")) != null && split.length == 2) {
                    try {
                        this.f44333i.put(split[0], URLDecoder.decode(split[1], "utf-8"));
                    } catch (UnsupportedEncodingException e2) {
                        BdLog.e(e2);
                    }
                }
            }
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (this.f44333i == null) {
                this.f44333i = new HashMap();
            }
            this.f44333i.put(str, str2);
        }
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (this.f44325a != null) {
                    jSONObject2.put("app_version", this.f44325a.f44302c);
                    jSONObject2.put("client_timestamp", Long.toString(System.currentTimeMillis()));
                    jSONObject2.put("cuid", this.f44325a.f44306g);
                    jSONObject2.put("shoubai_cuid", this.f44325a.f44307h);
                    jSONObject2.put("from", this.f44325a.f44303d);
                    jSONObject2.put("uid", this.f44325a.l);
                }
                jSONObject2.put("client_ip", f.b());
                jSONObject2.put("network", d());
                jSONObject2.put("model", Build.MODEL);
                jSONObject2.put("brand", Build.BRAND);
                jSONObject2.put("os_type", "AND");
                jSONObject2.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
                jSONObject2.put("active_id", f.a());
                jSONObject2.put("mission_id", f.c());
                jSONObject.put("base_info", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                if (this.f44326b != null) {
                    jSONObject3.put("module", this.f44326b);
                }
                if (this.f44327c != null) {
                    jSONObject3.put("action", this.f44327c);
                }
                if (this.f44328d != null) {
                    jSONObject3.put("error_code", this.f44328d);
                }
                if (this.f44329e != null) {
                    jSONObject3.put("error_message", this.f44329e);
                }
                if (this.f44333i != null) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry<String, String> entry : this.f44333i.entrySet()) {
                        sb.append(entry.getKey());
                        sb.append(":");
                        sb.append(entry.getValue());
                        sb.append("|");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    jSONObject3.put("ext1", sb);
                }
                if (this.f44330f != null) {
                    jSONObject3.put("id", this.f44330f);
                }
                if (this.f44331g != null) {
                    jSONObject3.put("title", this.f44331g);
                }
                if (this.f44332h != null) {
                    jSONObject3.put("abstract", this.f44332h);
                }
                jSONObject.put("debug_info", jSONObject3);
                jSONObject.put("kpi", new JSONObject());
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f44327c = str;
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f44325a = cVar;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f44328d = str;
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f44329e = str;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f44326b = str;
        }
    }
}
