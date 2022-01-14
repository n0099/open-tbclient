package com.cmic.sso.sdk.b.c;

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
import com.cmic.sso.sdk.b.b.e;
import com.cmic.sso.sdk.b.b.f;
import com.cmic.sso.sdk.b.b.h;
import com.cmic.sso.sdk.d.i;
import com.cmic.sso.sdk.d.j;
import com.cmic.sso.sdk.d.k;
import com.cmic.sso.sdk.d.n;
import com.cmic.sso.sdk.d.p;
import com.cmic.sso.sdk.d.q;
import com.cmic.sso.sdk.d.r;
import com.cmic.sso.sdk.d.s;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.yy.hiidostatis.inner.BaseStatisContent;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2138160441, "Lcom/cmic/sso/sdk/b/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2138160441, "Lcom/cmic/sso/sdk/b/c/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public void a(boolean z, com.cmic.sso.sdk.a aVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), aVar, dVar}) == null) {
            com.cmic.sso.sdk.b.b.b bVar = new com.cmic.sso.sdk.b.b.b();
            bVar.b("1.0");
            bVar.c("Android");
            bVar.d(k.b("AID", ""));
            bVar.e(z ? "1" : "0");
            bVar.f(AuthnHelper.SDK_VERSION);
            bVar.g(aVar.b("appid"));
            bVar.h(bVar.w("iYm0HAnkxQtpvN44"));
            a(new c("https://config2.cmpassport.com/client/uniConfig", bVar, "POST", aVar.b("traceId")), dVar, aVar);
        }
    }

    public void a(com.cmic.sso.sdk.a aVar, d dVar) {
        String a2;
        c bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, dVar) == null) {
            int c2 = aVar.c("networktype");
            h hVar = new h();
            hVar.b("1.0");
            hVar.c(AuthnHelper.SDK_VERSION);
            hVar.d(aVar.b("appid"));
            hVar.e(aVar.b(BaseStatisContent.IMSI));
            hVar.f(aVar.b("operatortype"));
            hVar.g(c2 + "");
            hVar.h(n.a());
            hVar.i(n.b());
            hVar.j(n.c());
            hVar.k("0");
            hVar.l("1.0");
            hVar.m(s.a());
            hVar.n(p.a());
            hVar.o(j.a().d());
            hVar.q(aVar.b("apppackage"));
            hVar.r(aVar.b("appsign"));
            hVar.a_(k.b("AID", ""));
            if (aVar.c("logintype") == 3) {
                hVar.u("pre");
            } else {
                hVar.y(aVar.b("userCapaid"));
                if (aVar.c("logintype") == 1) {
                    hVar.y(BasicPushStatus.SUCCESS_CODE);
                } else {
                    hVar.y("50");
                }
                hVar.u("authz");
            }
            s.a(aVar, "scripAndToken");
            if (aVar.b("isCacheScrip", false)) {
                hVar.s(r.a(false));
                hVar.t(r.a(false, false));
                hVar.x(aVar.b("phonescrip"));
                hVar.p(hVar.w(aVar.b("appkey")));
                bVar = new c(q.g() + "/rs/scripAndToken", hVar, "POST", aVar.b("traceId"));
                bVar.a("defendEOF", "0");
            } else {
                e eVar = new e();
                eVar.a(aVar.a(b.a.a));
                eVar.a(hVar);
                eVar.a(false);
                aVar.a("isCloseIpv4", q.b());
                aVar.a("isCloseIpv6", q.c());
                String str = q.e() + "/rs/scripAndToken";
                if (aVar.b("use2048PublicKey", false)) {
                    com.cmic.sso.sdk.d.c.a(BaseRequest.TAG, "使用2对应的编码");
                    eVar.b("2");
                    a2 = i.a().b(aVar.a(b.a.a));
                } else {
                    a2 = i.a().a(aVar.a(b.a.a));
                }
                eVar.c(a2);
                bVar = new b(str, eVar, "POST", aVar.b("traceId"));
                bVar.a("defendEOF", "1");
                if (c2 == 3) {
                    bVar.a(true);
                    aVar.a("doNetworkSwitch", true);
                } else {
                    bVar.a(false);
                    aVar.a("doNetworkSwitch", false);
                }
            }
            bVar.a("interfaceVersion", "1.0");
            a(bVar, dVar, aVar);
        }
    }

    public void a(JSONObject jSONObject, com.cmic.sso.sdk.a aVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, aVar, dVar) == null) {
            f fVar = new f();
            f.a aVar2 = new f.a();
            f.b bVar = new f.b();
            bVar.e(s.a());
            bVar.f(p.a());
            bVar.b("2.0");
            bVar.c(aVar.b("appid", ""));
            bVar.d(bVar.w(""));
            aVar2.a(jSONObject);
            fVar.a(aVar2);
            fVar.a(bVar);
            a(new c(q.i(), fVar, "POST", aVar.b("traceId")), dVar, aVar);
        }
    }

    private void a(c cVar, d dVar, com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, cVar, dVar, aVar) == null) {
            com.cmic.sso.sdk.b.a.d dVar2 = new com.cmic.sso.sdk.b.a.d();
            com.cmic.sso.sdk.b.a.c cVar2 = new com.cmic.sso.sdk.b.a.c();
            com.cmic.sso.sdk.b.a.a aVar2 = new com.cmic.sso.sdk.b.a.a();
            dVar2.a(cVar2);
            cVar2.a(aVar2);
            cVar.a(SystemClock.elapsedRealtime());
            dVar2.a(cVar, new com.cmic.sso.sdk.b.d.c(this, cVar, aVar, dVar) { // from class: com.cmic.sso.sdk.b.c.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ com.cmic.sso.sdk.a f53422b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ d f53423c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f53424d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar, aVar, dVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f53424d = this;
                    this.a = cVar;
                    this.f53422b = aVar;
                    this.f53423c = dVar;
                }

                @Override // com.cmic.sso.sdk.b.d.c
                public void a(com.cmic.sso.sdk.b.d.b bVar) {
                    String string;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && this.a.g()) {
                        try {
                            a();
                            JSONObject jSONObject = new JSONObject(bVar.c());
                            if (jSONObject.has("resultcode")) {
                                string = jSONObject.getString("resultcode");
                            } else {
                                string = jSONObject.getString(MiPushCommandMessage.KEY_RESULT_CODE);
                            }
                            s.b(this.f53422b, string);
                            this.f53423c.a(string, jSONObject.optString("desc"), jSONObject);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            a(com.cmic.sso.sdk.b.d.a.a(102223));
                        }
                    }
                }

                @Override // com.cmic.sso.sdk.b.d.c
                public void a(com.cmic.sso.sdk.b.d.a aVar3) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, aVar3) == null) && this.a.g()) {
                        a();
                        s.b(this.f53422b, String.valueOf(aVar3.a()));
                        this.f53423c.a(String.valueOf(aVar3.a()), aVar3.b(), com.cmic.sso.sdk.auth.c.a(String.valueOf(aVar3.a()), aVar3.b()));
                    }
                }

                private void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(65537, this) == null) || this.a.a().contains("uniConfig")) {
                        return;
                    }
                    s.c(this.f53422b, String.valueOf(SystemClock.elapsedRealtime() - this.a.i()));
                }
            }, aVar);
        }
    }
}
