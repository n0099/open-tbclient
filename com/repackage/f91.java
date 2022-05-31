package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.statistics.exception.ServerDataException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f91 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public static Bundle d;
    public static long e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends r61<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r61 a;

        public a(r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r61Var;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.a(th, i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.r61
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("code", 1);
                    String optString = jSONObject.optString("msg", "");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optInt == 0 && optJSONObject != null) {
                        String unused = f91.a = optJSONObject.optString("orderId");
                        String unused2 = f91.b = optJSONObject.optString("smsId");
                        f91.c = optJSONObject.optString("mobile");
                        this.a.c(optJSONObject);
                        return;
                    }
                    r61 r61Var = this.a;
                    r61Var.a(new ServerDataException("msg = " + optString), optInt, optString);
                } catch (JSONException unused3) {
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends r61<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r61 a;

        public b(r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r61Var;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.a(th, i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.r61
        /* renamed from: d */
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("code", 1);
                    String optString = jSONObject.optString("msg", "");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optInt == 0 && optJSONObject != null) {
                        this.a.c(optJSONObject);
                        return;
                    }
                    r61 r61Var = this.a;
                    r61Var.a(new ServerDataException("msg = " + optString), optInt, optString);
                } catch (JSONException unused) {
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends r61<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r61 a;

        public c(r61 r61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r61Var;
        }

        @Override // com.repackage.r61
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.a(th, i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.r61
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.a.c(jSONObject);
            }
        }
    }

    public static void c(String str, r61<JSONObject> r61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, r61Var) == null) {
            String[] split = str.split("&");
            s61 s61Var = new s61();
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2.length == 2) {
                    if (TextUtils.equals(split2[0], "timestamp")) {
                        s61Var.d(split2[0], URLDecoder.decode(split2[1]));
                    } else {
                        s61Var.d(split2[0], split2[1]);
                    }
                }
            }
            z61.j().g(b71.e(), s61Var, new c(r61Var));
        }
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? i(str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDeoE4C+X8ahP2/juzyb10hdQNIHR3a+m3+nV6sVaOiXpNw1sNnB/2ms9vV2yXCOTz2JFWMmgr8p5dA9yUfYzSVMWN8jyZdOzAwGzjh6oB32FsqlgFkXNTNJHkdIzJRq/H8Q9mlh67c2KrMN2QLU219M6EbLoTL0i+0oUbZ4W0IrwIDAQAB") : (String) invokeL.objValue;
    }

    public static void e(Bundle bundle, String str, String str2, long j, r61<JSONObject> r61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bundle, str, str2, Long.valueOf(j), r61Var}) == null) {
            d = bundle;
            e = j;
            f = str2;
            t61 t61Var = new t61();
            a71.d(t61Var);
            f(bundle, t61Var);
            s61 s61Var = new s61();
            s61Var.d("token", d("orderId=" + str + "&payChannel=" + str2 + "&timestamp=" + j));
            new x61().a(b71.n(), t61Var, s61Var, new a(r61Var));
        }
    }

    public static void f(Bundle bundle, t61 t61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, bundle, t61Var) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            g(string, t61Var);
        }
    }

    public static void g(String str, t61 t61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, t61Var) == null) {
            String a2 = t61Var.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                t61Var.d("Cookie", str2);
                return;
            }
            t61Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public static void h(String str, r61<JSONObject> r61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, r61Var) == null) {
            t61 t61Var = new t61();
            a71.d(t61Var);
            f(d, t61Var);
            s61 s61Var = new s61();
            s61Var.d("token", d("orderId=" + a + "&payChannel=" + f + "&smsId=" + b + "&timestamp=" + e + "&verifyCode=" + str));
            new x61().a(b71.g(), t61Var, s61Var, new b(r61Var));
        }
    }

    public static String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            try {
                PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, generatePublic);
                return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
