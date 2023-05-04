package com.cmic.sso.sdk.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.a.a;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.n;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static b c;
    public transient /* synthetic */ FieldHolder $fh;
    public com.cmic.sso.sdk.a.a a;
    public final com.cmic.sso.sdk.a.a b;
    public volatile boolean d;
    public a e;

    /* loaded from: classes7.dex */
    public interface a {
        void a(com.cmic.sso.sdk.a.a aVar);
    }

    public b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        com.cmic.sso.sdk.a.a a2 = new a.C0529a().a();
        this.b = a2;
        if (!z) {
            this.a = d();
        } else {
            this.a = a2;
        }
    }

    public static b a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) {
            if (c == null) {
                synchronized (b.class) {
                    if (c == null) {
                        c = new b(z);
                    }
                }
            }
            return c;
        }
        return (b) invokeZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, aVar) == null) {
            if (this.d) {
                com.cmic.sso.sdk.e.c.a("UmcConfigHandle", "正在获取配置中...");
                return;
            }
            this.d = true;
            com.cmic.sso.sdk.c.c.a.a().a(false, aVar, new com.cmic.sso.sdk.c.c.d(this) { // from class: com.cmic.sso.sdk.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.cmic.sso.sdk.c.c.d
                public void a(String str, String str2, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
                        try {
                            if ("103000".equals(str)) {
                                this.a.a(jSONObject);
                                k.a("sdk_config_version", AuthnHelper.SDK_VERSION);
                                this.a.a = this.a.d();
                                if (this.a.e != null) {
                                    this.a.e.a(this.a.a);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        this.a.d = false;
                    }
                }
            });
        }
    }

    private String a(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2)) == null) {
            String[] split = str.split("&");
            int length = split.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    str3 = split[i];
                    if (str3.contains(str2)) {
                        break;
                    }
                    i++;
                } else {
                    str3 = "";
                    break;
                }
            }
            if (!TextUtils.isEmpty(str3)) {
                return str3.substring(str3.lastIndexOf("=") + 1);
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, jSONObject) == null) {
            k.a b = k.b("sso_config_xf");
            try {
                if (jSONObject.has("client_valid")) {
                    b.a("client_valid", System.currentTimeMillis() + (Integer.parseInt(jSONObject.getString("client_valid")) * 60 * 60 * 1000));
                }
                if (jSONObject.has("Configlist")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("Configlist");
                    if (jSONObject2.has("CHANGE_HOST")) {
                        String string = jSONObject2.getString("CHANGE_HOST");
                        if (string.contains("M007")) {
                            String a2 = a(string, "M007");
                            if (!TextUtils.isEmpty(a2)) {
                                b.a("logHost", a2);
                            }
                        }
                        if (string.contains("M008")) {
                            String a3 = a(string, "M008");
                            if (!TextUtils.isEmpty(a3)) {
                                b.a("https_get_phone_scrip_host", a3);
                            }
                        }
                        if (string.contains("M009")) {
                            String a4 = a(string, "M009");
                            if (!TextUtils.isEmpty(a4)) {
                                b.a("config_host", a4);
                            }
                        }
                    } else {
                        b.a("logHost");
                        b.a("https_get_phone_scrip_host");
                        b.a("config_host");
                    }
                    a(jSONObject2, "CLOSE_FRIEND_WAPKS", "0", b);
                    a(jSONObject2, "CLOSE_LOGS_VERSION", "0", b);
                    a(jSONObject2, "CLOSE_IPV4_LIST", "0", b);
                    a(jSONObject2, "CLOSE_IPV6_LIST", "0", b);
                    a(jSONObject2, "CLOSE_M008_SDKVERSION_LIST", "0", b);
                    a(jSONObject2, "CLOSE_M008_APPID_LIST", "0", b);
                    if (jSONObject2.has("LOGS_CONTROL")) {
                        String[] split = jSONObject2.getString("LOGS_CONTROL").replace("h", "").split("&");
                        if (split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                            try {
                                int parseInt = Integer.parseInt(split[0]);
                                int parseInt2 = Integer.parseInt(split[1]);
                                b.a("maxFailedLogTimes", parseInt);
                                b.a("pauseTime", parseInt2);
                            } catch (Exception unused) {
                                com.cmic.sso.sdk.e.c.a("UmcConfigHandle", "解析日志上报限制时间次数异常");
                            }
                        }
                    } else {
                        b.a("maxFailedLogTimes");
                        b.a("pauseTime");
                    }
                }
                b.b();
            } catch (Exception e) {
                com.cmic.sso.sdk.e.c.a("UmcConfigHandle", "配置项异常，配置失效");
                e.printStackTrace();
            }
        }
    }

    private void a(JSONObject jSONObject, String str, String str2, k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, this, jSONObject, str, str2, aVar) == null) {
            if (jSONObject.has(str)) {
                String optString = jSONObject.optString(str, str2);
                if (!"CLOSE_FRIEND_WAPKS".equals(str)) {
                    if (!"0".equals(optString) && !"1".equals(optString)) {
                        return;
                    }
                } else if (!TextUtils.isEmpty(optString)) {
                    if (!optString.contains(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC) && !optString.contains(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC) && !optString.contains(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
                        return;
                    }
                } else {
                    return;
                }
                aVar.a(str, jSONObject.optString(str, str2));
                return;
            }
            aVar.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.cmic.sso.sdk.a.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            return new a.C0529a().a(d.b(this.b.a())).c(d.a(this.b.c())).b(d.b(this.b.b())).d(d.c(this.b.d())).d(d.a(this.b.h())).e(d.b(this.b.i())).a(d.e(this.b.e())).b(d.d(this.b.f())).c(d.c(this.b.g())).f(d.f(this.b.j())).a(d.a(this.b.k())).b(d.b(this.b.l())).a();
        }
        return (com.cmic.sso.sdk.a.a) invokeV.objValue;
    }

    public com.cmic.sso.sdk.a.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (com.cmic.sso.sdk.a.a) invokeV.objValue;
    }

    public com.cmic.sso.sdk.a.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (com.cmic.sso.sdk.a.a) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            k.a b = k.b("sso_config_xf");
            b.c();
            b.b();
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.e = aVar;
        }
    }

    public void a(com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) && d.a()) {
            n.a(new n.a(this, aVar) { // from class: com.cmic.sso.sdk.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.cmic.sso.sdk.a a;
                public final /* synthetic */ b b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = aVar;
                }

                @Override // com.cmic.sso.sdk.e.n.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.cmic.sso.sdk.e.c.b("UmcConfigHandle", "开始拉取配置..");
                        this.b.b(this.a);
                    }
                }
            });
        }
    }
}
