package com.cmic.sso.sdk.c.c;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.common.request.BaseRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.c.b.f;
import com.cmic.sso.sdk.c.b.h;
import com.cmic.sso.sdk.e.i;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.m;
import com.cmic.sso.sdk.e.o;
import com.cmic.sso.sdk.e.q;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2128177704, "Lcom/cmic/sso/sdk/c/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2128177704, "Lcom/cmic/sso/sdk/c/c/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    private void a(c cVar, d dVar, com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, cVar, dVar, aVar) == null) {
            com.cmic.sso.sdk.c.a.d dVar2 = new com.cmic.sso.sdk.c.a.d();
            com.cmic.sso.sdk.c.a.c cVar2 = new com.cmic.sso.sdk.c.a.c();
            com.cmic.sso.sdk.c.a.a aVar2 = new com.cmic.sso.sdk.c.a.a();
            dVar2.a(cVar2);
            cVar2.a(aVar2);
            cVar.a(SystemClock.elapsedRealtime());
            dVar2.a(cVar, new com.cmic.sso.sdk.c.d.c(this, cVar, aVar, dVar) { // from class: com.cmic.sso.sdk.c.c.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;
                public final /* synthetic */ com.cmic.sso.sdk.a b;
                public final /* synthetic */ d c;
                public final /* synthetic */ a d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar, aVar, dVar};
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
                    this.a = cVar;
                    this.b = aVar;
                    this.c = dVar;
                }

                private void a() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(65537, this) == null) && !this.a.a().contains("uniConfig")) {
                        q.c(this.b, String.valueOf(SystemClock.elapsedRealtime() - this.a.i()));
                    }
                }

                @Override // com.cmic.sso.sdk.c.d.c
                public void a(com.cmic.sso.sdk.c.d.a aVar3) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, aVar3) == null) && this.a.g()) {
                        a();
                        q.b(this.b, String.valueOf(aVar3.a()));
                        this.c.a(String.valueOf(aVar3.a()), aVar3.b(), com.cmic.sso.sdk.auth.c.a(String.valueOf(aVar3.a()), aVar3.b()));
                    }
                }

                @Override // com.cmic.sso.sdk.c.d.c
                public void a(com.cmic.sso.sdk.c.d.b bVar) {
                    String string;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && this.a.g()) {
                        try {
                            a();
                            JSONObject jSONObject = new JSONObject(bVar.c());
                            if (jSONObject.has("resultcode")) {
                                string = jSONObject.getString("resultcode");
                            } else {
                                string = jSONObject.getString("resultCode");
                            }
                            q.b(this.b, string);
                            this.c.a(string, jSONObject.optString("desc"), jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                            a(com.cmic.sso.sdk.c.d.a.a(102223));
                        }
                    }
                }
            }, aVar);
        }
    }

    public void a(com.cmic.sso.sdk.a aVar, d dVar) {
        c cVar;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, dVar) == null) {
            int c = aVar.c("networktype");
            h hVar = new h();
            hVar.b("1.0");
            hVar.c(AuthnHelper.SDK_VERSION);
            hVar.d(aVar.b("appid"));
            hVar.e(aVar.b("operatortype"));
            hVar.f(c + "");
            hVar.g(m.a());
            hVar.h(m.b());
            hVar.i(m.c());
            hVar.j("0");
            hVar.k("3.0");
            hVar.l(q.b());
            hVar.m(o.a());
            hVar.o(aVar.b("apppackage"));
            hVar.p(aVar.b("appsign"));
            hVar.a_(k.b("AID", ""));
            if (aVar.c("logintype") != 3 && !aVar.b("isRisk", false)) {
                hVar.x(aVar.b("userCapaid"));
                if (aVar.c("logintype") == 1) {
                    hVar.x(BasicPushStatus.SUCCESS_CODE);
                } else {
                    hVar.x(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_CLOSE_BTN_CLICK);
                }
                hVar.s("authz");
            } else {
                hVar.s("pre");
            }
            q.a(aVar, "scripAndTokenForHttps");
            com.cmic.sso.sdk.a.a b = aVar.b();
            if (!aVar.b("isCacheScrip", false) && !aVar.b("isGotScrip", false)) {
                e eVar = new e();
                eVar.a(aVar.a(b.a.a));
                eVar.b(aVar.a(b.a.b));
                eVar.a(hVar);
                eVar.a(false);
                aVar.a("isCloseIpv4", b.h());
                aVar.a("isCloseIpv6", b.i());
                String str = "https://" + b.b() + "/unisdk/rs/scripAndTokenForHttps";
                if (aVar.b("use2048PublicKey", false)) {
                    com.cmic.sso.sdk.e.c.a(BaseRequest.TAG, "使用2对应的编码");
                    eVar.b("2");
                    a2 = i.a().b(aVar.a(b.a.a));
                } else {
                    a2 = i.a().a(aVar.a(b.a.a));
                }
                eVar.c(a2);
                cVar = new b(str, eVar, "POST", aVar.b("traceId"));
                cVar.a("defendEOF", "1");
                if (c == 3) {
                    cVar.a(true);
                    aVar.a("doNetworkSwitch", true);
                } else {
                    cVar.a(false);
                    aVar.a("doNetworkSwitch", false);
                }
            } else {
                hVar.w(aVar.b("phonescrip"));
                hVar.n(hVar.v(aVar.b("appkey")));
                cVar = new c("https://" + b.a() + "/unisdk/rs/scripAndTokenForHttps", hVar, "POST", aVar.b("traceId"));
                cVar.a("defendEOF", "0");
            }
            cVar.a("interfaceVersion", "3.0");
            a(cVar, dVar, aVar);
        }
    }

    public void a(JSONObject jSONObject, com.cmic.sso.sdk.a aVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, aVar, dVar) == null) {
            f fVar = new f();
            f.a aVar2 = new f.a();
            f.b bVar = new f.b();
            bVar.e(q.b());
            bVar.f(o.a());
            bVar.b("2.0");
            bVar.c(aVar.b("appid", ""));
            bVar.d(bVar.v(""));
            aVar2.a(jSONObject);
            fVar.a(aVar2);
            fVar.a(bVar);
            com.cmic.sso.sdk.a.a b = aVar.b();
            a(new c("https://" + b.d() + "/log/logReport", fVar, "POST", aVar.b("traceId")), dVar, aVar);
        }
    }

    public void a(boolean z, com.cmic.sso.sdk.a aVar, d dVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), aVar, dVar}) == null) {
            com.cmic.sso.sdk.c.b.b bVar = new com.cmic.sso.sdk.c.b.b();
            bVar.b("1.0");
            bVar.c("Android");
            bVar.d(k.b("AID", ""));
            if (z) {
                str = "1";
            } else {
                str = "0";
            }
            bVar.e(str);
            bVar.f(AuthnHelper.SDK_VERSION);
            bVar.g(aVar.b("appid"));
            bVar.h(bVar.v("iYm0HAnkxQtpvN44"));
            com.cmic.sso.sdk.a.a b = aVar.b();
            a(new c("https://" + b.c() + "/client/uniConfig", bVar, "POST", aVar.b("traceId")), dVar, aVar);
        }
    }
}
