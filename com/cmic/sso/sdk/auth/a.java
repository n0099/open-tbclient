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
import com.cmic.sso.sdk.e.d;
import com.cmic.sso.sdk.e.h;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.l;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static a c;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.cmic.sso.sdk.c.c.a a;
    public final Context b;

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
        this.b = context.getApplicationContext();
        this.a = com.cmic.sso.sdk.c.c.a.a();
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (c == null) {
                synchronized (a.class) {
                    if (c == null) {
                        c = new a(context);
                    }
                }
            }
            return c;
        }
        return (a) invokeL.objValue;
    }

    private void a(com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, aVar) == null) {
            String packageName = this.b.getPackageName();
            String a = d.a(l.a(this.b, packageName));
            aVar.a("apppackage", packageName);
            aVar.a("appsign", a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.cmic.sso.sdk.a aVar, b bVar, String str, String str2, JSONObject jSONObject) {
        String b;
        JSONException jSONException;
        String str3;
        JSONObject jSONObject2;
        String str4;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar, bVar, str, str2, jSONObject) == null) {
            if ("103000".equals(str)) {
                String optString = jSONObject.optString("resultdata");
                if (TextUtils.isEmpty(optString)) {
                    b = jSONObject.toString();
                } else {
                    b = com.cmic.sso.sdk.e.a.b(aVar.a(b.a.a), optString, aVar.a(b.a.b));
                }
                String str7 = null;
                try {
                    jSONObject2 = new JSONObject(b);
                    try {
                        String optString2 = jSONObject2.optString("phonescrip");
                        try {
                            str4 = jSONObject2.optString("securityphone");
                            try {
                                str7 = jSONObject2.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID);
                                if (TextUtils.isEmpty(str7)) {
                                    str7 = jSONObject2.optString("pcid");
                                }
                                k.a("securityphone", str4);
                                str5 = str4;
                                str6 = optString2;
                            } catch (JSONException e) {
                                jSONException = e;
                                str3 = str7;
                                str7 = optString2;
                                jSONException.printStackTrace();
                                String str8 = str7;
                                str7 = str3;
                                str5 = str4;
                                str6 = str8;
                                com.cmic.sso.sdk.e.c.b("AuthnBusiness", "securityPhone  = " + str5);
                                aVar.a(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str7);
                                aVar.a("phonescrip", str6);
                                aVar.a("securityphone", str5);
                                if (jSONObject2 == null) {
                                }
                            }
                        } catch (JSONException e2) {
                            str4 = null;
                            str7 = optString2;
                            jSONException = e2;
                            str3 = null;
                        }
                    } catch (JSONException e3) {
                        jSONException = e3;
                        str3 = null;
                        str4 = null;
                    }
                } catch (JSONException e4) {
                    jSONException = e4;
                    str3 = null;
                    jSONObject2 = null;
                    str4 = null;
                }
                com.cmic.sso.sdk.e.c.b("AuthnBusiness", "securityPhone  = " + str5);
                aVar.a(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str7);
                aVar.a("phonescrip", str6);
                aVar.a("securityphone", str5);
                if (jSONObject2 == null) {
                    if (!aVar.b("isRisk", false)) {
                        h.a(this.b, str6, Long.parseLong(jSONObject2.optString("scripExpiresIn", "0")), aVar.b("scripKey", ""), aVar.b("scripType", ""));
                    }
                    if (aVar.c("logintype") == 3) {
                        bVar.a(str, "true", aVar, c.a(str5));
                        return;
                    } else if (aVar.b("isRisk", false)) {
                        aVar.a("isRisk", false);
                        aVar.a("isGotScrip", true);
                        b(aVar, bVar);
                        return;
                    } else {
                        bVar.a(str, str2, aVar, jSONObject2);
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            byte[] a = com.cmic.sso.sdk.e.a.a();
            aVar.a(b.a.a, bArr);
            aVar.a(b.a.b, a);
            aVar.a("authType", "3");
        }
    }

    private void b(com.cmic.sso.sdk.a aVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, aVar, bVar) == null) {
            com.cmic.sso.sdk.e.c.b("AuthnBusiness", "getScripAndToken start");
            boolean b = aVar.b("isGotScrip", false);
            com.cmic.sso.sdk.e.c.b("AuthnBusiness", "isGotScrip = " + b);
            if (!b) {
                a(aVar);
                if (!aVar.b("isCacheScrip", false)) {
                    b(aVar);
                    if (aVar.c("networktype") == 3 && aVar.c("logintype") != 3) {
                        aVar.a("isRisk", true);
                    }
                }
                if (aVar.c("logintype") == 1) {
                    aVar.a("userCapaid", BasicPushStatus.SUCCESS_CODE);
                } else if (aVar.c("logintype") == 0) {
                    aVar.a("userCapaid", PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_CLOSE_BTN_CLICK);
                }
            }
            this.a.a(aVar, new com.cmic.sso.sdk.c.c.d(this, aVar, bVar) { // from class: com.cmic.sso.sdk.auth.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.cmic.sso.sdk.a a;
                public final /* synthetic */ b b;
                public final /* synthetic */ a c;

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
                    this.c = this;
                    this.a = aVar;
                    this.b = bVar;
                }

                @Override // com.cmic.sso.sdk.c.c.d
                public void a(String str, String str2, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeLLL(1048576, this, str, str2, jSONObject) != null) {
                        return;
                    }
                    this.c.a(this.a, this.b, str, str2, jSONObject);
                }
            });
        }
    }

    public void a(com.cmic.sso.sdk.a aVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, bVar) == null) {
            com.cmic.sso.sdk.e.c.b("AuthnBusiness", "LoginCheck method start");
            int c2 = aVar.c("logintype");
            if (aVar.b("isCacheScrip", false)) {
                String b = aVar.b("securityphone", "");
                if (c2 == 3) {
                    bVar.a("103000", "true", aVar, c.a(b));
                    return;
                } else {
                    b(aVar, bVar);
                    return;
                }
            }
            b(aVar, bVar);
        }
    }
}
