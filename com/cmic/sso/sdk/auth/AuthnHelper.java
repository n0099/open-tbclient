package com.cmic.sso.sdk.auth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.d.e;
import com.cmic.sso.sdk.d.g;
import com.cmic.sso.sdk.d.h;
import com.cmic.sso.sdk.d.j;
import com.cmic.sso.sdk.d.k;
import com.cmic.sso.sdk.d.n;
import com.cmic.sso.sdk.d.o;
import com.cmic.sso.sdk.d.p;
import com.cmic.sso.sdk.d.q;
import com.cmic.sso.sdk.d.r;
import com.cmic.sso.sdk.d.s;
import com.cmic.sso.sdk.d.t;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AuthnHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SDK_VERSION = "quick_login_android_9.3.0";
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    public static AuthnHelper f32699c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.cmic.sso.sdk.auth.a f32700a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f32701b;

    /* renamed from: d  reason: collision with root package name */
    public long f32702d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f32703e;

    /* renamed from: f  reason: collision with root package name */
    public String f32704f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f32705g;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AuthnHelper f32733a;

        /* renamed from: b  reason: collision with root package name */
        public final com.cmic.sso.sdk.a f32734b;

        public a(AuthnHelper authnHelper, com.cmic.sso.sdk.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {authnHelper, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32733a = authnHelper;
            this.f32734b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!t.a(this.f32733a.f32701b).a() && this.f32734b.b("doNetworkSwitch", false)) {
                    a2 = c.a("102508", "数据网络切换失败");
                } else {
                    a2 = c.a("200023", "登录超时");
                }
                this.f32733a.callBackResult(a2.optString(MiPushCommandMessage.KEY_RESULT_CODE, "200023"), a2.optString("resultString", "登录超时"), this.f32734b, a2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32702d = 8000L;
        this.f32705g = new Object();
        this.f32701b = context.getApplicationContext();
        this.f32703e = new Handler(this.f32701b.getMainLooper());
        this.f32700a = com.cmic.sso.sdk.auth.a.a(this.f32701b);
        t.a(this.f32701b);
        k.a(this.f32701b);
        j.a(this.f32701b);
        o.a(new o.a(this) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AuthnHelper f32706a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f32706a = this;
            }

            @Override // com.cmic.sso.sdk.d.o.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String b2 = k.b("AID", "");
                    com.cmic.sso.sdk.d.c.b("AuthnHelper", "aid = " + b2);
                    if (TextUtils.isEmpty(b2)) {
                        this.f32706a.a();
                    }
                    if (com.cmic.sso.sdk.d.b.a(this.f32706a.f32701b, true)) {
                        com.cmic.sso.sdk.d.c.b("AuthnHelper", "生成androidkeystore成功");
                    } else {
                        com.cmic.sso.sdk.d.c.b("AuthnHelper", "生成androidkeystore失败");
                    }
                }
            }
        });
    }

    public static AuthnHelper getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (f32699c == null) {
                synchronized (AuthnHelper.class) {
                    if (f32699c == null) {
                        f32699c = new AuthnHelper(context);
                    }
                }
            }
            return f32699c;
        }
        return (AuthnHelper) invokeL.objValue;
    }

    public static void setDebugMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            com.cmic.sso.sdk.d.c.a(z);
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
                    aVar.a("endtime", p.a());
                    int c3 = aVar.c("logintype");
                    if (jSONObject == null) {
                        jSONObject = c.a(str, str2);
                    }
                    if (c3 == 3) {
                        a2 = c.a(str, aVar, jSONObject);
                    } else {
                        a2 = c.a(str, str2, aVar, jSONObject);
                    }
                    a2.put("scripExpiresIn", String.valueOf(h.b()));
                    this.f32703e.post(new Runnable(this, c2, a2) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ TokenListener f32724a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ JSONObject f32725b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ AuthnHelper f32726c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, c2, a2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f32726c = this;
                            this.f32724a = c2;
                            this.f32725b = a2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f32724a.onGetTokenComplete(this.f32725b);
                            }
                        }
                    });
                    a(this.f32701b, str, aVar);
                    if (aVar.b("isNeedToGetCert", false) || q.a()) {
                        o.a(new o.a(this, aVar) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.7
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ com.cmic.sso.sdk.a f32727a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AuthnHelper f32728b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, aVar};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f32728b = this;
                                this.f32727a = aVar;
                            }

                            @Override // com.cmic.sso.sdk.d.o.a
                            public void a() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    q.a(this.f32727a);
                                }
                            }
                        });
                    }
                    if (e.a()) {
                        t.a(this.f32701b).b();
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
                com.cmic.sso.sdk.d.c.b("AuthnHelper", "删除scrip");
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
                com.cmic.sso.sdk.a.b.a().a(context, g.a(context, "android.permission.READ_PHONE_STATE"));
                String a2 = j.a().a(true);
                int a3 = n.a(context, a2);
                jSONObject.put("operatortype", a2);
                StringBuilder sb = new StringBuilder();
                sb.append(a3);
                sb.append("");
                jSONObject.put("networktype", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("网络类型: ");
                sb2.append(a3);
                com.cmic.sso.sdk.d.c.b("AuthnHelper", sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("运营商类型: ");
                sb3.append(a2);
                com.cmic.sso.sdk.d.c.b("AuthnHelper", sb3.toString());
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
            o.a(new o.a(this, this.f32701b, a2, a2, str, str2, tokenListener) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.cmic.sso.sdk.a f32717a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f32718b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f32719c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ TokenListener f32720d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AuthnHelper f32721e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, a2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, a2, a2, str, str2, tokenListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (com.cmic.sso.sdk.a) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32721e = this;
                    this.f32717a = a2;
                    this.f32718b = str;
                    this.f32719c = str2;
                    this.f32720d = tokenListener;
                }

                @Override // com.cmic.sso.sdk.d.o.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f32721e.a(this.f32717a, this.f32718b, this.f32719c, "preGetMobile", 3, this.f32720d)) {
                        this.f32721e.a(this.f32717a);
                    }
                }
            });
        }
    }

    public void loginAuth(String str, String str2, TokenListener tokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, tokenListener) == null) {
            com.cmic.sso.sdk.a a2 = a(tokenListener);
            o.a(new o.a(this, this.f32701b, a2, a2, str, str2, tokenListener) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.cmic.sso.sdk.a f32707a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f32708b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f32709c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ TokenListener f32710d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AuthnHelper f32711e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, a2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, a2, a2, str, str2, tokenListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (com.cmic.sso.sdk.a) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32711e = this;
                    this.f32707a = a2;
                    this.f32708b = str;
                    this.f32709c = str2;
                    this.f32710d = tokenListener;
                }

                @Override // com.cmic.sso.sdk.d.o.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f32711e.a(this.f32707a, this.f32708b, this.f32709c, "loginAuth", 1, this.f32710d)) {
                        this.f32711e.a(this.f32707a);
                    }
                }
            });
        }
    }

    public void mobileAuth(String str, String str2, TokenListener tokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, tokenListener) == null) {
            com.cmic.sso.sdk.a a2 = a(tokenListener);
            o.a(new o.a(this, this.f32701b, a2, a2, str, str2, tokenListener) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.cmic.sso.sdk.a f32712a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f32713b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f32714c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ TokenListener f32715d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AuthnHelper f32716e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, a2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, a2, a2, str, str2, tokenListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Context) objArr2[0], (com.cmic.sso.sdk.a) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32716e = this;
                    this.f32712a = a2;
                    this.f32713b = str;
                    this.f32714c = str2;
                    this.f32715d = tokenListener;
                }

                @Override // com.cmic.sso.sdk.d.o.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f32716e.a(this.f32712a, this.f32713b, this.f32714c, "mobileAuth", 0, this.f32715d)) {
                        this.f32716e.a(this.f32712a);
                    }
                }
            });
        }
    }

    public void setOverTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.f32702d = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            String str = "%" + s.a();
            com.cmic.sso.sdk.d.c.b("AuthnHelper", "generate aid = " + str);
            k.a a2 = k.a();
            a2.a("AID", str);
            a2.b();
        }
    }

    public static AuthnHelper getInstance(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, str)) == null) {
            if (f32699c == null) {
                synchronized (AuthnHelper.class) {
                    if (f32699c == null) {
                        f32699c = new AuthnHelper(context, str);
                    }
                }
            }
            return f32699c;
        }
        return (AuthnHelper) invokeLL.objValue;
    }

    private com.cmic.sso.sdk.a a(TokenListener tokenListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, tokenListener)) == null) {
            com.cmic.sso.sdk.a aVar = new com.cmic.sso.sdk.a(64);
            String b2 = s.b();
            aVar.a(new com.cmic.sso.sdk.c.a());
            aVar.a("traceId", b2);
            com.cmic.sso.sdk.d.c.a("traceId", b2);
            if (tokenListener != null) {
                e.a(b2, tokenListener);
            }
            return aVar;
        }
        return (com.cmic.sso.sdk.a) invokeL.objValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f32704f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, aVar) == null) {
            a aVar2 = new a(this, aVar);
            this.f32703e.postDelayed(aVar2, this.f32702d);
            this.f32700a.a(aVar, new b(this, aVar2) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f32722a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AuthnHelper f32723b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f32723b = this;
                    this.f32722a = aVar2;
                }

                @Override // com.cmic.sso.sdk.auth.b
                public void a(String str, String str2, com.cmic.sso.sdk.a aVar3, JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLLL(1048576, this, str, str2, aVar3, jSONObject) == null) {
                        this.f32723b.f32703e.removeCallbacks(this.f32722a);
                        this.f32723b.callBackResult(str, str2, aVar3, jSONObject);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.cmic.sso.sdk.a aVar, String str, String str2, String str3, int i2, TokenListener tokenListener) {
        InterceptResult invokeCommon;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{aVar, str, str2, str3, Integer.valueOf(i2), tokenListener})) == null) {
            aVar.a("CLOSE_CERT_VERIFY", q.j());
            aVar.a("use2048PublicKey", "rsa2048".equals(this.f32704f));
            aVar.a("systemStartTime", SystemClock.elapsedRealtime());
            aVar.a("starttime", p.a());
            aVar.a("loginMethod", str3);
            aVar.a("appkey", str2);
            aVar.a("appid", str);
            aVar.a("timeOut", String.valueOf(this.f32702d));
            boolean a3 = g.a(this.f32701b, "android.permission.READ_PHONE_STATE");
            com.cmic.sso.sdk.d.c.a("AuthnHelper", "有READ_PHONE_STATE权限？" + a3);
            aVar.a("hsaReadPhoneStatePermission", a3);
            com.cmic.sso.sdk.a.b.a().a(this.f32701b, a3);
            aVar.a("networkClass", com.cmic.sso.sdk.a.b.a().a(this.f32701b));
            aVar.a("simCardNum", String.valueOf(com.cmic.sso.sdk.a.b.a().b().h()));
            String b2 = j.a().b();
            String e2 = j.a().e();
            String c2 = j.a().c();
            String a4 = j.a().a(false);
            aVar.a(BaseStatisContent.IMSI, b2);
            aVar.a("operatortype", a4);
            aVar.a("iccid", e2);
            aVar.a("logintype", i2);
            com.cmic.sso.sdk.d.c.b("AuthnHelper", "iccid = " + e2);
            com.cmic.sso.sdk.d.c.b("AuthnHelper", "imsi = " + b2);
            com.cmic.sso.sdk.d.c.b("AuthnHelper", "subId = " + c2);
            if (!TextUtils.isEmpty(b2)) {
                com.cmic.sso.sdk.d.c.a("AuthnHelper", "使用imsi作为缓存key = " + b2);
                aVar.a("scripType", BaseStatisContent.IMSI);
                aVar.a("scripKey", b2);
            } else if (!TextUtils.isEmpty(e2)) {
                com.cmic.sso.sdk.d.c.a("AuthnHelper", "使用iccid作为缓存key = " + e2);
                aVar.a("scripType", "iccid");
                aVar.a("scripKey", e2);
            } else if (!TextUtils.isEmpty(c2)) {
                com.cmic.sso.sdk.d.c.a("AuthnHelper", "使用subId作为缓存key = " + c2);
                aVar.a("scripType", "subid");
                aVar.a("scripKey", c2);
            } else if (!TextUtils.isEmpty(a4)) {
                com.cmic.sso.sdk.d.c.a("AuthnHelper", "使用operator作为缓存key = " + a4);
                aVar.a("scripType", "operator");
                aVar.a("scripKey", a4);
            }
            int a5 = n.a(this.f32701b, a4);
            aVar.a("networktype", a5);
            synchronized (this.f32705g) {
                a2 = h.a(aVar);
                if (a2) {
                    aVar.a("securityphone", k.b("securityphone", ""));
                    if (3 != i2 && a5 != 0) {
                        String a6 = h.a(this.f32701b);
                        if (TextUtils.isEmpty(a6)) {
                            a2 = false;
                        } else {
                            aVar.a("phonescrip", a6);
                        }
                        h.a(true, false);
                    }
                }
                aVar.a("isCacheScrip", a2);
                StringBuilder sb = new StringBuilder();
                sb.append("isCachePhoneScrip = ");
                sb.append(a2);
                com.cmic.sso.sdk.d.c.b("AuthnHelper", sb.toString());
            }
            if (tokenListener == null) {
                callBackResult("102203", "listener不能为空", aVar, null);
                return false;
            } else if (q.d()) {
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
                } else if (a5 == 0) {
                    callBackResult("102101", "未检测到网络", aVar, null);
                    return false;
                } else if (TextUtils.isEmpty(a4)) {
                    aVar.a("authType", String.valueOf(0));
                    callBackResult("200010", "无法识别sim卡或没有sim卡", aVar, null);
                    return false;
                } else if (a5 == 2 && !a2) {
                    callBackResult("102103", "无数据网络", aVar, null);
                    return false;
                } else if ("2".equals(a4) && q.k()) {
                    callBackResult("200082", "服务器繁忙，请稍后重试", aVar, null);
                    return false;
                } else if ("3".equals(a4) && q.l()) {
                    callBackResult("200082", "服务器繁忙，请稍后重试", aVar, null);
                    return false;
                } else {
                    return true;
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    private void a(Context context, String str, com.cmic.sso.sdk.a aVar) {
        String a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, context, str, aVar) == null) || q.m()) {
            return;
        }
        try {
            if ("105313".equals(str)) {
                URL url = new URL(q.i());
                int port = url.getPort() == -1 ? Constants.SOCKET_PORT_SSL : url.getPort();
                StringBuilder sb = new StringBuilder();
                sb.append("host = ");
                sb.append(url.getHost());
                sb.append("  port = ");
                sb.append(port);
                com.cmic.sso.sdk.d.c.b("AuthnHelper", sb.toString());
                if (aVar.c("networktype") == 3) {
                    a2 = t.a((Context) null).a(url.getHost(), port);
                } else {
                    a2 = r.a(url.getHost(), port);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("eip = ");
                sb2.append(a2);
                com.cmic.sso.sdk.d.c.b("AuthnHelper", sb2.toString());
                aVar.a("eipKey", a2);
            }
        } catch (Exception unused) {
            com.cmic.sso.sdk.d.c.a("AuthnHelper", "日志上报获取eip失败");
        }
        o.a(new o.a(this, str, context, aVar) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f32729a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f32730b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ com.cmic.sso.sdk.a f32731c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ AuthnHelper f32732d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str, context, aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32732d = this;
                this.f32729a = str;
                this.f32730b = context;
                this.f32731c = aVar;
            }

            @Override // com.cmic.sso.sdk.d.o.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if ("200023".equals(this.f32729a)) {
                        SystemClock.sleep(8000L);
                    }
                    new com.cmic.sso.sdk.c.b().a(this.f32730b, this.f32729a, this.f32731c);
                }
            }
        });
    }
}
