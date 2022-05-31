package com.repackage;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ug a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public Map<String, String> i;

    public yg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? ji.H() ? "WIFI" : ji.t() ? "2G" : ji.u() ? "3G" : (ji.v() || ji.z()) ? "4G" : "NONE" : (String) invokeV.objValue;
    }

    public void a(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.i == null) {
                this.i = new HashMap();
            }
            String[] split2 = str.split("&");
            if (split2 == null || split2.length == 0) {
                return;
            }
            for (String str2 : split2) {
                if (!TextUtils.isEmpty(str2) && (split = str2.split("=")) != null && split.length == 2) {
                    try {
                        this.i.put(split[0], URLDecoder.decode(split[1], IMAudioTransRequest.CHARSET));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                    }
                }
            }
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (this.i == null) {
                this.i = new HashMap();
            }
            this.i.put(str, str2);
        }
    }

    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (this.a != null) {
                    jSONObject2.put("app_version", this.a.c);
                    jSONObject2.put("client_timestamp", Long.toString(System.currentTimeMillis()));
                    jSONObject2.put("cuid", this.a.g);
                    jSONObject2.put("shoubai_cuid", this.a.h);
                    jSONObject2.put("from", this.a.d);
                    jSONObject2.put("uid", this.a.l);
                }
                jSONObject2.put("client_ip", xg.b());
                jSONObject2.put("network", d());
                jSONObject2.put("model", Build.MODEL);
                jSONObject2.put(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, Build.BRAND);
                jSONObject2.put("os_type", "AND");
                jSONObject2.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
                jSONObject2.put("active_id", xg.a());
                jSONObject2.put("mission_id", xg.c());
                jSONObject.put("base_info", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                if (this.b != null) {
                    jSONObject3.put("module", this.b);
                }
                if (this.c != null) {
                    jSONObject3.put("action", this.c);
                }
                if (this.d != null) {
                    jSONObject3.put("error_code", this.d);
                }
                if (this.e != null) {
                    jSONObject3.put("error_message", this.e);
                }
                if (this.i != null) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry<String, String> entry : this.i.entrySet()) {
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
                if (this.f != null) {
                    jSONObject3.put("id", this.f);
                }
                if (this.g != null) {
                    jSONObject3.put("title", this.g);
                }
                if (this.h != null) {
                    jSONObject3.put("abstract", this.h);
                }
                jSONObject.put("debug_info", jSONObject3);
                jSONObject.put("kpi", new JSONObject());
            } catch (JSONException e) {
                BdLog.e(e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.c = str;
        }
    }

    public void f(ug ugVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ugVar) == null) {
            this.a = ugVar;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.d = str;
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.e = str;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.b = str;
        }
    }
}
