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
/* loaded from: classes6.dex */
public class ha1 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public static Bundle d;
    public static long e;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends t71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t71 a;

        public a(t71 t71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t71Var;
        }

        @Override // com.repackage.t71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.a(th, i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t71
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
                        String unused = ha1.a = optJSONObject.optString("orderId");
                        String unused2 = ha1.b = optJSONObject.optString("smsId");
                        ha1.c = optJSONObject.optString("mobile");
                        this.a.c(optJSONObject);
                        return;
                    }
                    t71 t71Var = this.a;
                    t71Var.a(new ServerDataException("msg = " + optString), optInt, optString);
                } catch (JSONException unused3) {
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends t71<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t71 a;

        public b(t71 t71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t71Var;
        }

        @Override // com.repackage.t71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.a(th, i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t71
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
                    t71 t71Var = this.a;
                    t71Var.a(new ServerDataException("msg = " + optString), optInt, optString);
                } catch (JSONException unused) {
                    this.a.b(new ServerDataException("服务异常，请稍后重试"), "服务异常，请稍后重试");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends t71<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t71 a;

        public c(t71 t71Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t71Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t71Var;
        }

        @Override // com.repackage.t71
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.a.a(th, i, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t71
        /* renamed from: d */
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                this.a.c(jSONObject);
            }
        }
    }

    public static void c(String str, t71<JSONObject> t71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, t71Var) == null) {
            String[] split = str.split("&");
            u71 u71Var = new u71();
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2.length == 2) {
                    if (TextUtils.equals(split2[0], "timestamp")) {
                        u71Var.d(split2[0], URLDecoder.decode(split2[1]));
                    } else {
                        u71Var.d(split2[0], split2[1]);
                    }
                }
            }
            b81.j().g(d81.e(), u71Var, new c(t71Var));
        }
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? i(str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDeoE4C+X8ahP2/juzyb10hdQNIHR3a+m3+nV6sVaOiXpNw1sNnB/2ms9vV2yXCOTz2JFWMmgr8p5dA9yUfYzSVMWN8jyZdOzAwGzjh6oB32FsqlgFkXNTNJHkdIzJRq/H8Q9mlh67c2KrMN2QLU219M6EbLoTL0i+0oUbZ4W0IrwIDAQAB") : (String) invokeL.objValue;
    }

    public static void e(Bundle bundle, String str, String str2, long j, t71<JSONObject> t71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bundle, str, str2, Long.valueOf(j), t71Var}) == null) {
            d = bundle;
            e = j;
            f = str2;
            v71 v71Var = new v71();
            c81.d(v71Var);
            f(bundle, v71Var);
            u71 u71Var = new u71();
            u71Var.d("token", d("orderId=" + str + "&payChannel=" + str2 + "&timestamp=" + j));
            new z71().a(d81.n(), v71Var, u71Var, new a(t71Var));
        }
    }

    public static void f(Bundle bundle, v71 v71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, bundle, v71Var) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            g(string, v71Var);
        }
    }

    public static void g(String str, v71 v71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, v71Var) == null) {
            String a2 = v71Var.a("Cookie");
            String str2 = "BDUSS=" + str;
            if (a2 == null) {
                v71Var.d("Cookie", str2);
                return;
            }
            v71Var.d("Cookie", a2 + "; " + str2);
        }
    }

    public static void h(String str, t71<JSONObject> t71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, t71Var) == null) {
            v71 v71Var = new v71();
            c81.d(v71Var);
            f(d, v71Var);
            u71 u71Var = new u71();
            u71Var.d("token", d("orderId=" + a + "&payChannel=" + f + "&smsId=" + b + "&timestamp=" + e + "&verifyCode=" + str));
            new z71().a(d81.g(), v71Var, u71Var, new b(t71Var));
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
