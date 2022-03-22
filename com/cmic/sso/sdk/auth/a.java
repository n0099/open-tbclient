package com.cmic.sso.sdk.auth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.c.c.d;
import com.cmic.sso.sdk.e.h;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.l;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    public static a f38411c;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.cmic.sso.sdk.c.c.a a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f38412b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1302615045, "Lcom/cmic/sso/sdk/auth/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1302615045, "Lcom/cmic/sso/sdk/auth/a;");
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38412b = context.getApplicationContext();
        this.a = com.cmic.sso.sdk.c.c.a.a();
    }

    private void b(com.cmic.sso.sdk.a aVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, aVar, bVar) == null) {
            com.cmic.sso.sdk.e.c.b("AuthnBusiness", "getScripAndToken start");
            a(aVar);
            if (!aVar.b("isCacheScrip", false)) {
                b(aVar);
            }
            if (aVar.c("logintype") == 1) {
                aVar.a("userCapaid", BasicPushStatus.SUCCESS_CODE);
            } else if (aVar.c("logintype") == 0) {
                aVar.a("userCapaid", "50");
            }
            this.a.a(aVar, new d(this, aVar, bVar) { // from class: com.cmic.sso.sdk.auth.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.cmic.sso.sdk.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f38413b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f38414c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f38414c = this;
                    this.a = aVar;
                    this.f38413b = bVar;
                }

                @Override // com.cmic.sso.sdk.c.c.d
                public void a(String str, String str2, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
                        this.f38414c.a(this.a, this.f38413b, str, str2, jSONObject);
                    }
                }
            });
        }
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f38411c == null) {
                synchronized (a.class) {
                    if (f38411c == null) {
                        f38411c = new a(context);
                    }
                }
            }
            return f38411c;
        }
        return (a) invokeL.objValue;
    }

    public void a(com.cmic.sso.sdk.a aVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, bVar) == null) {
            com.cmic.sso.sdk.e.c.b("AuthnBusiness", "LoginCheck method start");
            int c2 = aVar.c("logintype");
            if (aVar.b("isCacheScrip", false)) {
                String b2 = aVar.b("securityphone", "");
                if (c2 == 3) {
                    bVar.a("103000", "true", aVar, c.a(b2));
                    return;
                } else {
                    b(aVar, bVar);
                    return;
                }
            }
            b(aVar, bVar);
        }
    }

    private void b(com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, aVar) == null) {
            byte[] bArr = new byte[0];
            if (aVar.b("use2048PublicKey", false)) {
                com.cmic.sso.sdk.e.c.a("AuthnBusiness", "使用2048公钥对应的对称秘钥生成方式");
                bArr = com.cmic.sso.sdk.e.a.a();
            } else {
                com.cmic.sso.sdk.e.c.a("AuthnBusiness", "使用1024公钥对应的对称秘钥生成方式");
                try {
                    bArr = UUID.randomUUID().toString().substring(0, 16).getBytes(IMAudioTransRequest.CHARSET);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            byte[] a = com.cmic.sso.sdk.e.a.a();
            aVar.a(b.a.a, bArr);
            aVar.a(b.a.f38415b, a);
            aVar.a("authType", "3");
        }
    }

    private void a(com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, aVar) == null) {
            String packageName = this.f38412b.getPackageName();
            String a = com.cmic.sso.sdk.e.d.a(l.a(this.f38412b, packageName));
            aVar.a("apppackage", packageName);
            aVar.a("appsign", a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.cmic.sso.sdk.a aVar, b bVar, String str, String str2, JSONObject jSONObject) {
        String b2;
        String str3;
        JSONObject jSONObject2;
        String str4;
        String str5;
        String str6;
        JSONObject jSONObject3;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar, bVar, str, str2, jSONObject) == null) {
            if ("103000".equals(str)) {
                String optString2 = jSONObject.optString("resultdata");
                if (TextUtils.isEmpty(optString2)) {
                    b2 = jSONObject.toString();
                } else {
                    b2 = com.cmic.sso.sdk.e.a.b(aVar.a(b.a.a), optString2, aVar.a(b.a.f38415b));
                }
                String str7 = null;
                try {
                    jSONObject3 = new JSONObject(b2);
                    try {
                        optString = jSONObject3.optString("phonescrip");
                    } catch (JSONException e2) {
                        e = e2;
                        str4 = null;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str3 = null;
                    jSONObject2 = null;
                    str4 = null;
                }
                try {
                    str4 = jSONObject3.optString("securityphone");
                    try {
                        str7 = jSONObject3.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID);
                        if (TextUtils.isEmpty(str7)) {
                            str7 = jSONObject3.optString("pcid");
                        }
                        k.a("securityphone", str4);
                        str5 = str4;
                        str6 = optString;
                    } catch (JSONException e4) {
                        e = e4;
                        str3 = str7;
                        str7 = optString;
                        jSONObject2 = jSONObject3;
                        e.printStackTrace();
                        str5 = str4;
                        str6 = str7;
                        str7 = str3;
                        jSONObject3 = jSONObject2;
                        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "securityPhone  = " + str5);
                        aVar.a(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str7);
                        aVar.a("phonescrip", str6);
                        aVar.a("securityphone", str5);
                        if (jSONObject3 != null) {
                        }
                    }
                } catch (JSONException e5) {
                    e = e5;
                    str4 = null;
                    str7 = optString;
                    jSONObject2 = jSONObject3;
                    str3 = str4;
                    e.printStackTrace();
                    str5 = str4;
                    str6 = str7;
                    str7 = str3;
                    jSONObject3 = jSONObject2;
                    com.cmic.sso.sdk.e.c.b("AuthnBusiness", "securityPhone  = " + str5);
                    aVar.a(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str7);
                    aVar.a("phonescrip", str6);
                    aVar.a("securityphone", str5);
                    if (jSONObject3 != null) {
                    }
                }
                com.cmic.sso.sdk.e.c.b("AuthnBusiness", "securityPhone  = " + str5);
                aVar.a(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str7);
                aVar.a("phonescrip", str6);
                aVar.a("securityphone", str5);
                if (jSONObject3 != null) {
                    h.a(this.f38412b, str6, Long.parseLong(jSONObject3.optString("scripExpiresIn", "0")), aVar.b("scripKey", ""), aVar.b("scripType", ""));
                    if (aVar.c("logintype") == 3) {
                        bVar.a(str, "true", aVar, c.a(str5));
                        return;
                    } else {
                        bVar.a(str, str2, aVar, jSONObject3);
                        return;
                    }
                }
                com.cmic.sso.sdk.e.c.a("AuthnBusiness", "返回103000，但是数据解析出错");
                bVar.a(String.valueOf(102223), "数据解析异常", aVar, c.a(String.valueOf(102223), "数据解析异常"));
            } else if (aVar.c("logintype") == 3) {
                bVar.a(str, "true", aVar, c.b(str, str2));
            } else {
                bVar.a(str, str2, aVar, jSONObject);
            }
        }
    }
}
