package com.cmic.sso.sdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.b.c.d;
import com.cmic.sso.sdk.d.c;
import com.cmic.sso.sdk.d.f;
import com.cmic.sso.sdk.d.h;
import com.cmic.sso.sdk.d.j;
import com.cmic.sso.sdk.d.k;
import com.cmic.sso.sdk.d.n;
import com.cmic.sso.sdk.d.q;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.cmic.sso.sdk.a a;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(a aVar, com.cmic.sso.sdk.a aVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, aVar, aVar2) == null) || aVar == null || aVar2 == null) {
            return;
        }
        aVar.b(aVar2.b("appid", ""));
        aVar.f(h.a() ? "1" : "0");
        aVar.g(n.a());
        aVar.j(aVar2.b("interfaceType", ""));
        aVar.i(aVar2.b("interfaceCode", ""));
        aVar.h(aVar2.b("interfaceElasped", ""));
        aVar.m(aVar2.b("timeOut"));
        aVar.t(aVar2.b("traceId"));
        aVar.v(aVar2.b("networkClass"));
        aVar.o(aVar2.b("simCardNum"));
        aVar.p(aVar2.b("operatortype"));
        aVar.q(n.b());
        aVar.r(n.c());
        aVar.z(String.valueOf(aVar2.b("networktype", 0)));
        aVar.u(aVar2.b(LaunchedTaskSpeedStats.KEY_START_TIME));
        aVar.x(aVar2.b("endtime"));
        aVar.n(String.valueOf(aVar2.b("systemEndTime", 0L) - aVar2.b("systemStartTime", 0L)));
        aVar.d(aVar2.b("imsiState"));
        aVar.A(k.b("AID", ""));
        aVar.B(j.a().f());
        aVar.C(aVar2.b("scripType"));
        aVar.D(aVar2.b("eipKey"));
        c.a("SendLog", "traceId" + aVar2.b("traceId"));
    }

    public void a(Context context, String str, com.cmic.sso.sdk.a aVar) {
        StackTraceElement[] stackTrace;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, str, aVar) == null) {
            String str2 = "";
            try {
                a a = aVar.a();
                String b2 = f.b(context);
                a.e(str);
                a.y(aVar.b("loginMethod", ""));
                if (aVar.b("isCacheScrip", false)) {
                    a.s("scrip");
                } else {
                    a.s("pgw");
                }
                a.k(f.a(context));
                if (!TextUtils.isEmpty(b2)) {
                    str2 = b2;
                }
                a.l(str2);
                a.c(aVar.b("hsaReadPhoneStatePermission", false) ? "1" : "0");
                a(a, aVar);
                JSONArray jSONArray = null;
                if (a.a.size() > 0) {
                    jSONArray = new JSONArray();
                    Iterator<Throwable> it = a.a.iterator();
                    while (it.hasNext()) {
                        Throwable next = it.next();
                        StringBuffer stringBuffer = new StringBuffer();
                        JSONObject jSONObject = new JSONObject();
                        for (StackTraceElement stackTraceElement : next.getStackTrace()) {
                            stringBuffer.append(StringUtils.LF);
                            stringBuffer.append(stackTraceElement.toString());
                        }
                        jSONObject.put("message", next.toString());
                        jSONObject.put("stack", stringBuffer.toString());
                        jSONArray.put(jSONObject);
                    }
                    a.a.clear();
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    a.a(jSONArray);
                }
                c.a("SendLog", "登录日志");
                a(a.b(), aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a(JSONObject jSONObject, com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, jSONObject, aVar) == null) {
            this.a = aVar;
            a(jSONObject);
        }
    }

    private void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, jSONObject) == null) {
            if (q.o() == 0 || q.n() == 0 || System.currentTimeMillis() > k.a("logCloseTime", 0L) + q.o()) {
                com.cmic.sso.sdk.b.c.a.a().a(jSONObject, this.a, new d(this) { // from class: com.cmic.sso.sdk.c.b.1
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.cmic.sso.sdk.b.c.d
                    public void a(String str, String str2, JSONObject jSONObject2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, str2, jSONObject2) == null) {
                            if (!str.equals("103000")) {
                                if (q.o() != 0 && q.n() != 0) {
                                    int a = k.a("logFailTimes", 0) + 1;
                                    k.a a2 = k.a();
                                    if (a >= q.n()) {
                                        a2.a("logFailTimes", 0);
                                        a2.a("logCloseTime", System.currentTimeMillis());
                                    } else {
                                        a2.a("logFailTimes", a);
                                    }
                                    a2.b();
                                }
                                c.a("SendLog", "request failed , url : " + q.i() + ">>>>>errorMsg : " + jSONObject2.toString());
                                return;
                            }
                            c.b("SendLog", "request success , url : " + q.i() + ">>>>result : " + jSONObject2.toString());
                        }
                    }
                });
            }
        }
    }
}
