package com.cmic.sso.sdk.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import com.cmic.sso.sdk.c.b.d;
import com.cmic.sso.sdk.c.b.g;
import com.cmic.sso.sdk.c.c.c;
import com.cmic.sso.sdk.e.q;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f38419b;

    public a() {
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

    public c a(c cVar, com.cmic.sso.sdk.c.d.b bVar, com.cmic.sso.sdk.a aVar) {
        InterceptResult invokeLLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cVar, bVar, aVar)) == null) {
            Map<String, List<String>> b2 = bVar.b();
            if (TextUtils.isEmpty(this.a) && (list = b2.get("pplocation")) != null && list.size() > 0) {
                this.a = list.get(0);
            }
            q.b(aVar, String.valueOf(bVar.a()));
            List<String> list2 = b2.get(Headers.LOCATION);
            if (list2 == null || list2.isEmpty()) {
                list2 = b2.get(Headers.LOCATION.toLowerCase());
            }
            if (list2 != null && list2.size() > 0) {
                String str = list2.get(0);
                this.f38419b = str;
                if (!TextUtils.isEmpty(str)) {
                    String b3 = aVar.b("operatortype", "0");
                    if ("2".equals(b3)) {
                        q.a(aVar, "getUnicomMobile");
                    } else if ("3".equals(b3)) {
                        q.a(aVar, "getTelecomMobile");
                    } else {
                        q.a(aVar, "NONE");
                    }
                }
            }
            Log.d(Headers.LOCATION, this.f38419b);
            c a = a(this.f38419b, cVar.f(), "GET", new com.cmic.sso.sdk.c.b.c(cVar.k().a()));
            a.a(cVar.h());
            return a;
        }
        return (c) invokeLLL.objValue;
    }

    public c b(c cVar, com.cmic.sso.sdk.c.d.b bVar, com.cmic.sso.sdk.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, bVar, aVar)) == null) {
            String b2 = aVar.b("operatortype", "0");
            if ("2".equals(b2)) {
                q.a(aVar, "getNewUnicomPhoneNumberNotify");
            } else if ("3".equals(b2)) {
                q.a(aVar, "getNewTelecomPhoneNumberNotify");
            } else {
                q.a(aVar, "NONE");
            }
            q.b(aVar, String.valueOf(bVar.a()));
            d dVar = new d(cVar.k().a(), "1.0", bVar.c());
            dVar.c(aVar.b("userCapaid"));
            if (aVar.c("logintype") != 3) {
                dVar.b("authz");
            } else {
                dVar.b("pre");
            }
            c a = a(this.a, cVar.f(), "POST", dVar);
            a.a(cVar.h());
            this.a = null;
            return a;
        }
        return (c) invokeLLL.objValue;
    }

    private c a(String str, String str2, String str3, g gVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, this, str, str2, str3, gVar)) == null) {
            c cVar = new c(str, gVar, str3, str2);
            if (str3.equals("GET")) {
                cVar.a("Content-Type", "application/x-www-form-urlencoded");
            }
            return cVar;
        }
        return (c) invokeLLLL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }
}
