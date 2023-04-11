package com.cmic.sso.sdk.auth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.e.e;
import com.cmic.sso.sdk.e.h;
import com.cmic.sso.sdk.e.j;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.m;
import com.cmic.sso.sdk.e.n;
import com.cmic.sso.sdk.e.o;
import com.cmic.sso.sdk.e.q;
import com.cmic.sso.sdk.e.r;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AuthnHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SDK_VERSION = "quick_login_android_9.5.5";
    @SuppressLint({"StaticFieldLeak"})
    public static AuthnHelper c;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.cmic.sso.sdk.auth.a a;
    public final Context b;
    public long d;
    public final Handler e;
    public String f;
    public final Object g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1693393544, "Lcom/cmic/sso/sdk/auth/AuthnHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1693393544, "Lcom/cmic/sso/sdk/auth/AuthnHelper;");
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AuthnHelper a;
        public final com.cmic.sso.sdk.a b;

        public a(AuthnHelper authnHelper, com.cmic.sso.sdk.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authnHelper, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = authnHelper;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject a = c.a("200023", "登录超时");
                this.a.callBackResult(a.optString("resultCode", "200023"), a.optString("desc", "登录超时"), this.b, a);
            }
        }
    }

    public AuthnHelper(Context context) {
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
        this.d = 8000L;
        this.g = new Object();
        this.b = context.getApplicationContext();
        this.e = new Handler(this.b.getMainLooper());
        this.a = com.cmic.sso.sdk.auth.a.a(this.b);
        r.a(this.b);
        k.a(this.b);
        j.a(this.b);
        n.a(new n.a(this) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AuthnHelper a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.cmic.sso.sdk.e.n.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String b = k.b("AID", "");
                    com.cmic.sso.sdk.e.c.b("AuthnHelper", "aid = " + b);
                    if (TextUtils.isEmpty(b)) {
                        this.a.a();
                    }
                    if (com.cmic.sso.sdk.e.b.a(this.a.b, true)) {
                        com.cmic.sso.sdk.e.c.b("AuthnHelper", "生成androidkeystore成功");
                    } else {
                        com.cmic.sso.sdk.e.c.b("AuthnHelper", "生成androidkeystore失败");
                    }
                }
            }
        });
    }

    public JSONObject getNetworkType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                try {
                    boolean a2 = m.a(this.b);
                    com.cmic.sso.sdk.b.a.a().a(context, a2);
                    String a3 = j.a().a((String) null);
                    int a4 = m.a(context, a2, new com.cmic.sso.sdk.a(1));
                    jSONObject.put("operatortype", a3);
                    jSONObject.put("networktype", a4 + "");
                    com.cmic.sso.sdk.e.c.b("AuthnHelper", "网络类型: " + a4);
                    com.cmic.sso.sdk.e.c.b("AuthnHelper", "运营商类型: " + a3);
                    return jSONObject;
                } catch (Exception unused) {
                    jSONObject.put("errorDes", "发生未知错误");
                    return jSONObject;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return jSONObject;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthnHelper(Context context, String str) {
        this(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f = str;
    }

    private com.cmic.sso.sdk.a a(TokenListener tokenListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, tokenListener)) == null) {
            com.cmic.sso.sdk.a aVar = new com.cmic.sso.sdk.a(64);
            String c2 = q.c();
            aVar.a(new com.cmic.sso.sdk.d.a());
            aVar.a("traceId", c2);
            com.cmic.sso.sdk.e.c.a("traceId", c2);
            if (tokenListener != null) {
                e.a(c2, tokenListener);
            }
            return aVar;
        }
        return (com.cmic.sso.sdk.a) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            String str = "%" + q.b();
            com.cmic.sso.sdk.e.c.b("AuthnHelper", "generate aid = " + str);
            k.a("AID", str);
        }
    }

    private void a(Context context, String str, com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, this, context, str, aVar) == null) {
            n.a(new n.a(this, str, context, aVar) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ Context b;
                public final /* synthetic */ com.cmic.sso.sdk.a c;
                public final /* synthetic */ AuthnHelper d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, context, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.d = this;
                    this.a = str;
                    this.b = context;
                    this.c = aVar;
                }

                @Override // com.cmic.sso.sdk.e.n.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if ("200023".equals(this.a)) {
                            SystemClock.sleep(8000L);
                        }
                        new com.cmic.sso.sdk.d.b().a(this.b, this.a, this.c);
                    }
                }
            });
        }
    }

    public void getPhoneInfo(String str, String str2, TokenListener tokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, tokenListener) == null) {
            com.cmic.sso.sdk.a a2 = a(tokenListener);
            n.a(new n.a(this, this.b, a2, a2, str, str2, tokenListener) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.cmic.sso.sdk.a a;
                public final /* synthetic */ String b;
                public final /* synthetic */ String c;
                public final /* synthetic */ TokenListener d;
                public final /* synthetic */ AuthnHelper e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, a2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, a2, a2, str, str2, tokenListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (com.cmic.sso.sdk.a) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.e = this;
                    this.a = a2;
                    this.b = str;
                    this.c = str2;
                    this.d = tokenListener;
                }

                @Override // com.cmic.sso.sdk.e.n.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || !this.e.a(this.a, this.b, this.c, "preGetMobile", 3, this.d)) {
                        return;
                    }
                    this.e.a(this.a);
                }
            });
        }
    }

    public void loginAuth(String str, String str2, TokenListener tokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, tokenListener) == null) {
            com.cmic.sso.sdk.a a2 = a(tokenListener);
            n.a(new n.a(this, this.b, a2, a2, str, str2, tokenListener) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.cmic.sso.sdk.a a;
                public final /* synthetic */ String b;
                public final /* synthetic */ String c;
                public final /* synthetic */ TokenListener d;
                public final /* synthetic */ AuthnHelper e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, a2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, a2, a2, str, str2, tokenListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (com.cmic.sso.sdk.a) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.e = this;
                    this.a = a2;
                    this.b = str;
                    this.c = str2;
                    this.d = tokenListener;
                }

                @Override // com.cmic.sso.sdk.e.n.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || !this.e.a(this.a, this.b, this.c, "loginAuth", 1, this.d)) {
                        return;
                    }
                    this.e.a(this.a);
                }
            });
        }
    }

    public void mobileAuth(String str, String str2, TokenListener tokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, tokenListener) == null) {
            com.cmic.sso.sdk.a a2 = a(tokenListener);
            n.a(new n.a(this, this.b, a2, a2, str, str2, tokenListener) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.cmic.sso.sdk.a a;
                public final /* synthetic */ String b;
                public final /* synthetic */ String c;
                public final /* synthetic */ TokenListener d;
                public final /* synthetic */ AuthnHelper e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, a2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, a2, a2, str, str2, tokenListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (com.cmic.sso.sdk.a) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.e = this;
                    this.a = a2;
                    this.b = str;
                    this.c = str2;
                    this.d = tokenListener;
                }

                @Override // com.cmic.sso.sdk.e.n.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || !this.e.a(this.a, this.b, this.c, "mobileAuth", 0, this.d)) {
                        return;
                    }
                    this.e.a(this.a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, aVar) == null) {
            a aVar2 = new a(this, aVar);
            this.e.postDelayed(aVar2, this.d);
            this.a.a(aVar, new b(this, aVar2) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;
                public final /* synthetic */ AuthnHelper b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar2};
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
                    this.a = aVar2;
                }

                @Override // com.cmic.sso.sdk.auth.b
                public void a(String str, String str2, com.cmic.sso.sdk.a aVar3, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, str, str2, aVar3, jSONObject) == null) {
                        this.b.e.removeCallbacks(this.a);
                        this.b.callBackResult(str, str2, aVar3, jSONObject);
                    }
                }
            });
        }
    }

    public static AuthnHelper getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (c == null) {
                synchronized (AuthnHelper.class) {
                    if (c == null) {
                        c = new AuthnHelper(context);
                    }
                }
            }
            return c;
        }
        return (AuthnHelper) invokeL.objValue;
    }

    public static void setDebugMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            com.cmic.sso.sdk.e.c.a(z);
        }
    }

    public void setOverTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.d = j;
        }
    }

    public static AuthnHelper getInstance(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, str)) == null) {
            if (c == null) {
                synchronized (AuthnHelper.class) {
                    if (c == null) {
                        c = new AuthnHelper(context, str);
                    }
                }
            }
            return c;
        }
        return (AuthnHelper) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.cmic.sso.sdk.a aVar, String str, String str2, String str3, int i, TokenListener tokenListener) {
        InterceptResult invokeCommon;
        String trim;
        String trim2;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{aVar, str, str2, str3, Integer.valueOf(i), tokenListener})) == null) {
            com.cmic.sso.sdk.a.a a3 = com.cmic.sso.sdk.a.c.a(this.b).a();
            com.cmic.sso.sdk.e.c.b("AuthnHelper", "umcConfigBean = " + a3.toString());
            aVar.a(a3);
            aVar.a("use2048PublicKey", "rsa2048".equals(this.f));
            aVar.a("systemStartTime", SystemClock.elapsedRealtime());
            aVar.a(LaunchedTaskSpeedStats.KEY_START_TIME, o.a());
            aVar.a("loginMethod", str3);
            aVar.a("appkey", str2);
            aVar.a("appid", str);
            aVar.a("timeOut", String.valueOf(this.d));
            boolean a4 = m.a(this.b);
            com.cmic.sso.sdk.b.a.a().a(this.b, a4);
            String b = j.a().b();
            String c2 = j.a().c();
            String a5 = j.a().a(c2);
            aVar.a("operator", c2);
            aVar.a("operatortype", a5);
            aVar.a("logintype", i);
            com.cmic.sso.sdk.e.c.b("AuthnHelper", "subId = " + b);
            if (!TextUtils.isEmpty(b)) {
                com.cmic.sso.sdk.e.c.a("AuthnHelper", "使用subId作为缓存key = " + b);
                aVar.a("scripType", "subid");
                aVar.a("scripKey", b);
            } else if (!TextUtils.isEmpty(c2)) {
                com.cmic.sso.sdk.e.c.a("AuthnHelper", "使用operator作为缓存key = " + c2);
                aVar.a("scripType", "operator");
                aVar.a("scripKey", c2);
            }
            int a6 = m.a(this.b, a4, aVar);
            aVar.a("networktype", a6);
            if (!a4) {
                aVar.a("authType", String.valueOf(0));
                callBackResult("200010", "无法识别sim卡或没有sim卡", aVar, null);
                return false;
            } else if (tokenListener == null) {
                callBackResult("102203", "listener不能为空", aVar, null);
                return false;
            } else if (a3.g()) {
                callBackResult("200082", "服务器繁忙，请稍后重试", aVar, null);
                return false;
            } else {
                if (str == null) {
                    trim = "";
                } else {
                    trim = str.trim();
                }
                if (TextUtils.isEmpty(trim)) {
                    callBackResult("102203", "appId 不能为空", aVar, null);
                    return false;
                }
                if (str2 == null) {
                    trim2 = "";
                } else {
                    trim2 = str2.trim();
                }
                if (TextUtils.isEmpty(trim2)) {
                    callBackResult("102203", "appkey不能为空", aVar, null);
                    return false;
                } else if (a6 == 0) {
                    callBackResult("102101", "未检测到网络", aVar, null);
                    return false;
                } else if ("2".equals(a5) && a3.f()) {
                    callBackResult("200082", "服务器繁忙，请稍后重试", aVar, null);
                    return false;
                } else if ("3".equals(a5) && a3.e()) {
                    callBackResult("200082", "服务器繁忙，请稍后重试", aVar, null);
                    return false;
                } else {
                    synchronized (this.g) {
                        a2 = h.a(aVar);
                        if (a2) {
                            aVar.a("securityphone", k.b("securityphone", ""));
                            if (3 != i) {
                                String a7 = h.a(this.b);
                                StringBuilder sb = new StringBuilder();
                                sb.append("解密phoneScript ");
                                sb.append(!TextUtils.isEmpty(a7));
                                com.cmic.sso.sdk.e.c.b("AuthnHelper", sb.toString());
                                if (!TextUtils.isEmpty(a7)) {
                                    aVar.a("phonescrip", a7);
                                } else {
                                    a2 = false;
                                }
                                h.a(true, false);
                            }
                        }
                        aVar.a("isCacheScrip", a2);
                        com.cmic.sso.sdk.e.c.b("AuthnHelper", "isCachePhoneScrip = " + a2);
                    }
                    if (a6 != 2 || a2) {
                        return true;
                    }
                    callBackResult("102103", "无数据网络", aVar, null);
                    return false;
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    public void callBackResult(String str, String str2, com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, aVar, jSONObject) == null) {
            try {
                String b = aVar.b("traceId");
                if (!e.a(b)) {
                    synchronized (this) {
                        TokenListener c2 = e.c(b);
                        e.b(b);
                        if (c2 == null) {
                            return;
                        }
                        aVar.a("systemEndTime", SystemClock.elapsedRealtime());
                        aVar.a("endtime", o.a());
                        int c3 = aVar.c("logintype");
                        if (jSONObject == null) {
                            jSONObject = c.a(str, str2);
                        }
                        if (c3 == 3) {
                            a2 = c.a(str, aVar, jSONObject);
                        } else {
                            a2 = c.a(str, str2, aVar, jSONObject);
                        }
                        a2.put("scripExpiresIn", String.valueOf(h.a()));
                        this.e.post(new Runnable(this, c2, a2) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.6
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ TokenListener a;
                            public final /* synthetic */ JSONObject b;
                            public final /* synthetic */ AuthnHelper c;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, c2, a2};
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
                                this.a = c2;
                                this.b = a2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.a.onGetTokenComplete(this.b);
                                }
                            }
                        });
                        com.cmic.sso.sdk.a.c.a(this.b).a(aVar);
                        if (!aVar.b().j() && !q.a(aVar.b())) {
                            a(this.b, str, aVar);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delScrip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                h.a(true, true);
                com.cmic.sso.sdk.e.c.b("AuthnHelper", "删除scrip");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
