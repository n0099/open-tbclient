package com.cmic.sso.sdk.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.c.c.d;
import com.cmic.sso.sdk.e.c;
import com.cmic.sso.sdk.e.f;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.m;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.cmic.sso.sdk.a a;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(a aVar, com.cmic.sso.sdk.a aVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, aVar, aVar2) == null) || aVar == null || aVar2 == null) {
            return;
        }
        aVar.b(aVar2.b("appid", ""));
        aVar.f(m.a());
        aVar.i(aVar2.b("interfaceType", ""));
        aVar.h(aVar2.b("interfaceCode", ""));
        aVar.g(aVar2.b("interfaceElasped", ""));
        aVar.l(aVar2.b("timeOut"));
        aVar.s(aVar2.b("traceId"));
        aVar.v(aVar2.b("networkClass"));
        aVar.n(aVar2.b("simCardNum"));
        aVar.o(aVar2.b("operatortype"));
        aVar.p(m.b());
        aVar.q(m.c());
        aVar.y(String.valueOf(aVar2.b("networktype", 0)));
        aVar.t(aVar2.b(LaunchedTaskSpeedStats.KEY_START_TIME));
        aVar.w(aVar2.b("endtime"));
        aVar.m(String.valueOf(aVar2.b("systemEndTime", 0L) - aVar2.b("systemStartTime", 0L)));
        aVar.d(aVar2.b("imsiState"));
        aVar.z(k.b("AID", ""));
        aVar.A(aVar2.b("operatortype"));
        aVar.B(aVar2.b("scripType"));
        c.a("SendLog", "traceId" + aVar2.b("traceId"));
    }

    public void a(Context context, String str, com.cmic.sso.sdk.a aVar) {
        StackTraceElement[] stackTrace;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, str, aVar) == null) {
            String str2 = "";
            try {
                a a = aVar.a();
                String b = f.b(context);
                a.e(str);
                a.x(aVar.b("loginMethod", ""));
                if (aVar.b("isCacheScrip", false)) {
                    a.r("scrip");
                } else {
                    a.r("pgw");
                }
                a.j(f.a(context));
                if (!TextUtils.isEmpty(b)) {
                    str2 = b;
                }
                a.k(str2);
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
                            stringBuffer.append("\n");
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a(JSONObject jSONObject, com.cmic.sso.sdk.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject, aVar) == null) {
            this.a = aVar;
            a(jSONObject);
        }
    }

    private void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, jSONObject) == null) {
            com.cmic.sso.sdk.c.c.a.a().a(jSONObject, this.a, new d(this) { // from class: com.cmic.sso.sdk.d.b.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.cmic.sso.sdk.c.c.d
                public void a(String str, String str2, JSONObject jSONObject2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, str, str2, jSONObject2) == null) {
                        com.cmic.sso.sdk.a.a b = this.a.a.b();
                        HashMap hashMap = new HashMap();
                        if (!str.equals("103000")) {
                            if (b.l() != 0 && b.k() != 0) {
                                int a = k.a("logFailTimes", 0) + 1;
                                if (a >= b.k()) {
                                    hashMap.put("logFailTimes", 0);
                                    hashMap.put("logCloseTime", Long.valueOf(System.currentTimeMillis()));
                                } else {
                                    hashMap.put("logFailTimes", Integer.valueOf(a));
                                }
                            }
                        } else {
                            hashMap.put("logFailTimes", 0);
                            hashMap.put("logCloseTime", 0L);
                        }
                        k.a(hashMap);
                    }
                }
            });
        }
    }
}
