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
import com.cmic.sso.sdk.e.g;
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
/* loaded from: classes6.dex */
public class AuthnHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SDK_VERSION = "quick_login_android_9.5.2";
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    public static AuthnHelper f38386c;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.cmic.sso.sdk.auth.a a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f38387b;

    /* renamed from: d  reason: collision with root package name */
    public long f38388d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f38389e;

    /* renamed from: f  reason: collision with root package name */
    public String f38390f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f38391g;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AuthnHelper a;

        /* renamed from: b  reason: collision with root package name */
        public final com.cmic.sso.sdk.a f38410b;

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
            this.f38410b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!r.a(this.a.f38387b).a() && this.f38410b.b("doNetworkSwitch", false)) {
                    a = c.a("102508", "数据网络切换失败");
                } else {
                    a = c.a("200023", "登录超时");
                }
                this.a.callBackResult(a.optString("resultCode", "200023"), a.optString("resultString", "登录超时"), this.f38410b, a);
            }
        }
    }

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
        this.f38388d = 8000L;
        this.f38391g = new Object();
        this.f38387b = context.getApplicationContext();
        this.f38389e = new Handler(this.f38387b.getMainLooper());
        this.a = com.cmic.sso.sdk.auth.a.a(this.f38387b);
        r.a(this.f38387b);
        k.a(this.f38387b);
        j.a(this.f38387b);
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
                    String b2 = k.b("AID", "");
                    com.cmic.sso.sdk.e.c.b("AuthnHelper", "aid = " + b2);
                    if (TextUtils.isEmpty(b2)) {
                        this.a.a();
                    }
                    if (com.cmic.sso.sdk.e.b.a(this.a.f38387b, true)) {
                        com.cmic.sso.sdk.e.c.b("AuthnHelper", "生成androidkeystore成功");
                    } else {
                        com.cmic.sso.sdk.e.c.b("AuthnHelper", "生成androidkeystore失败");
                    }
                }
            }
        });
    }

    public static AuthnHelper getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (f38386c == null) {
                synchronized (AuthnHelper.class) {
                    if (f38386c == null) {
                        f38386c = new AuthnHelper(context);
                    }
                }
            }
            return f38386c;
        }
        return (AuthnHelper) invokeL.objValue;
    }

    public static void setDebugMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            com.cmic.sso.sdk.e.c.a(z);
        }
    }

    public void callBackResult(String str, String str2, com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, aVar, jSONObject) == null) {
            try {
                String b2 = aVar.b("traceId");
                if (e.a(b2)) {
                    return;
                }
                synchronized (this) {
                    TokenListener c2 = e.c(b2);
                    e.b(b2);
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
                    this.f38389e.post(new Runnable(this, c2, a2) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TokenListener a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ JSONObject f38405b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ AuthnHelper f38406c;

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
                            this.f38406c = this;
                            this.a = c2;
                            this.f38405b = a2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.a.onGetTokenComplete(this.f38405b);
                            }
                        }
                    });
                    com.cmic.sso.sdk.a.c.a(this.f38387b).a(aVar);
                    if (!aVar.b().j() && !q.a(aVar.b())) {
                        a(this.f38387b, str, aVar);
                    }
                    if (e.a()) {
                        r.a(this.f38387b).b();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void delScrip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                h.a(true, true);
                com.cmic.sso.sdk.e.c.b("AuthnHelper", "删除scrip");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public JSONObject getNetworkType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                boolean a2 = m.a(this.f38387b);
                com.cmic.sso.sdk.b.a.a().a(context, g.a(context, "android.permission.READ_PHONE_STATE"), a2);
                String a3 = j.a().a((String) null);
                int a4 = m.a(context, a2);
                jSONObject.put("operatortype", a3);
                StringBuilder sb = new StringBuilder();
                sb.append(a4);
                sb.append("");
                jSONObject.put("networktype", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("网络类型: ");
                sb2.append(a4);
                com.cmic.sso.sdk.e.c.b("AuthnHelper", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("运营商类型: ");
                sb3.append(a3);
                com.cmic.sso.sdk.e.c.b("AuthnHelper", sb3.toString());
                return jSONObject;
            } catch (Exception unused) {
                try {
                    jSONObject.put("errorDes", "发生未知错误");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jSONObject;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public void getPhoneInfo(String str, String str2, TokenListener tokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, tokenListener) == null) {
            com.cmic.sso.sdk.a a2 = a(tokenListener);
            n.a(new n.a(this, this.f38387b, a2, a2, str, str2, tokenListener) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.cmic.sso.sdk.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f38400b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f38401c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ TokenListener f38402d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AuthnHelper f38403e;

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
                    this.f38403e = this;
                    this.a = a2;
                    this.f38400b = str;
                    this.f38401c = str2;
                    this.f38402d = tokenListener;
                }

                @Override // com.cmic.sso.sdk.e.n.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f38403e.a(this.a, this.f38400b, this.f38401c, "preGetMobile", 3, this.f38402d)) {
                        this.f38403e.a(this.a);
                    }
                }
            });
        }
    }

    public void loginAuth(String str, String str2, TokenListener tokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, tokenListener) == null) {
            com.cmic.sso.sdk.a a2 = a(tokenListener);
            n.a(new n.a(this, this.f38387b, a2, a2, str, str2, tokenListener) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.cmic.sso.sdk.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f38392b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f38393c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ TokenListener f38394d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AuthnHelper f38395e;

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
                    this.f38395e = this;
                    this.a = a2;
                    this.f38392b = str;
                    this.f38393c = str2;
                    this.f38394d = tokenListener;
                }

                @Override // com.cmic.sso.sdk.e.n.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f38395e.a(this.a, this.f38392b, this.f38393c, "loginAuth", 1, this.f38394d)) {
                        this.f38395e.a(this.a);
                    }
                }
            });
        }
    }

    public void mobileAuth(String str, String str2, TokenListener tokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, tokenListener) == null) {
            com.cmic.sso.sdk.a a2 = a(tokenListener);
            n.a(new n.a(this, this.f38387b, a2, a2, str, str2, tokenListener) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.cmic.sso.sdk.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f38396b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f38397c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ TokenListener f38398d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AuthnHelper f38399e;

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
                    this.f38399e = this;
                    this.a = a2;
                    this.f38396b = str;
                    this.f38397c = str2;
                    this.f38398d = tokenListener;
                }

                @Override // com.cmic.sso.sdk.e.n.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f38399e.a(this.a, this.f38396b, this.f38397c, "mobileAuth", 0, this.f38398d)) {
                        this.f38399e.a(this.a);
                    }
                }
            });
        }
    }

    public void setOverTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.f38388d = j;
        }
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

    public static AuthnHelper getInstance(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, str)) == null) {
            if (f38386c == null) {
                synchronized (AuthnHelper.class) {
                    if (f38386c == null) {
                        f38386c = new AuthnHelper(context, str);
                    }
                }
            }
            return f38386c;
        }
        return (AuthnHelper) invokeLL.objValue;
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
        this.f38390f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, aVar) == null) {
            a aVar2 = new a(this, aVar);
            this.f38389e.postDelayed(aVar2, this.f38388d);
            this.a.a(aVar, new b(this, aVar2) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AuthnHelper f38404b;

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
                    this.f38404b = this;
                    this.a = aVar2;
                }

                @Override // com.cmic.sso.sdk.auth.b
                public void a(String str, String str2, com.cmic.sso.sdk.a aVar3, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, str, str2, aVar3, jSONObject) == null) {
                        this.f38404b.f38389e.removeCallbacks(this.a);
                        this.f38404b.callBackResult(str, str2, aVar3, jSONObject);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.cmic.sso.sdk.a aVar, String str, String str2, String str3, int i, TokenListener tokenListener) {
        InterceptResult invokeCommon;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{aVar, str, str2, str3, Integer.valueOf(i), tokenListener})) == null) {
            com.cmic.sso.sdk.a.a a3 = com.cmic.sso.sdk.a.c.a(this.f38387b).a();
            com.cmic.sso.sdk.e.c.b("AuthnHelper", "umcConfigBean = " + a3.toString());
            aVar.a(a3);
            aVar.a("use2048PublicKey", "rsa2048".equals(this.f38390f));
            aVar.a("systemStartTime", SystemClock.elapsedRealtime());
            aVar.a(LaunchedTaskSpeedStats.KEY_START_TIME, o.a());
            aVar.a("loginMethod", str3);
            aVar.a("appkey", str2);
            aVar.a("appid", str);
            aVar.a("timeOut", String.valueOf(this.f38388d));
            boolean a4 = g.a(this.f38387b, "android.permission.READ_PHONE_STATE");
            com.cmic.sso.sdk.e.c.a("AuthnHelper", "有READ_PHONE_STATE权限？" + a4);
            aVar.a("hsaReadPhoneStatePermission", a4);
            boolean a5 = m.a(this.f38387b);
            com.cmic.sso.sdk.b.a.a().a(this.f38387b, a4, a5);
            aVar.a("networkClass", com.cmic.sso.sdk.b.a.a().a(this.f38387b));
            String b2 = j.a().b();
            String c2 = j.a().c();
            String a6 = j.a().a(c2);
            aVar.a("operator", c2);
            aVar.a("operatortype", a6);
            aVar.a("logintype", i);
            com.cmic.sso.sdk.e.c.b("AuthnHelper", "subId = " + b2);
            if (!TextUtils.isEmpty(b2)) {
                com.cmic.sso.sdk.e.c.a("AuthnHelper", "使用subId作为缓存key = " + b2);
                aVar.a("scripType", "subid");
                aVar.a("scripKey", b2);
            } else if (!TextUtils.isEmpty(c2)) {
                com.cmic.sso.sdk.e.c.a("AuthnHelper", "使用operator作为缓存key = " + c2);
                aVar.a("scripType", "operator");
                aVar.a("scripKey", c2);
            }
            int a7 = m.a(this.f38387b, a5);
            aVar.a("networktype", a7);
            if (!a5) {
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
                if (TextUtils.isEmpty(str == null ? "" : str.trim())) {
                    callBackResult("102203", "appId 不能为空", aVar, null);
                    return false;
                }
                if (TextUtils.isEmpty(str2 == null ? "" : str2.trim())) {
                    callBackResult("102203", "appkey不能为空", aVar, null);
                    return false;
                } else if (a7 == 0) {
                    callBackResult("102101", "未检测到网络", aVar, null);
                    return false;
                } else if ("2".equals(a6) && a3.f()) {
                    callBackResult("200082", "服务器繁忙，请稍后重试", aVar, null);
                    return false;
                } else if ("3".equals(a6) && a3.e()) {
                    callBackResult("200082", "服务器繁忙，请稍后重试", aVar, null);
                    return false;
                } else {
                    synchronized (this.f38391g) {
                        a2 = h.a(aVar);
                        if (a2) {
                            aVar.a("securityphone", k.b("securityphone", ""));
                            if (3 != i) {
                                String a8 = h.a(this.f38387b);
                                StringBuilder sb = new StringBuilder();
                                sb.append("解密phoneScript ");
                                sb.append(!TextUtils.isEmpty(a8));
                                com.cmic.sso.sdk.e.c.b("AuthnHelper", sb.toString());
                                if (TextUtils.isEmpty(a8)) {
                                    a2 = false;
                                } else {
                                    aVar.a("phonescrip", a8);
                                }
                                h.a(true, false);
                            }
                        }
                        aVar.a("isCacheScrip", a2);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("isCachePhoneScrip = ");
                        sb2.append(a2);
                        com.cmic.sso.sdk.e.c.b("AuthnHelper", sb2.toString());
                    }
                    if (a7 != 2 || a2) {
                        return true;
                    }
                    callBackResult("102103", "无数据网络", aVar, null);
                    return false;
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    private void a(Context context, String str, com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, this, context, str, aVar) == null) {
            n.a(new n.a(this, str, context, aVar) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f38407b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ com.cmic.sso.sdk.a f38408c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ AuthnHelper f38409d;

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
                    this.f38409d = this;
                    this.a = str;
                    this.f38407b = context;
                    this.f38408c = aVar;
                }

                @Override // com.cmic.sso.sdk.e.n.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if ("200023".equals(this.a)) {
                            SystemClock.sleep(8000L);
                        }
                        new com.cmic.sso.sdk.d.b().a(this.f38407b, this.a, this.f38408c);
                    }
                }
            });
        }
    }
}
