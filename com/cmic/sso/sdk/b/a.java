package com.cmic.sso.sdk.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.b.b.d;
import com.cmic.sso.sdk.b.b.g;
import com.cmic.sso.sdk.b.c.c;
import com.cmic.sso.sdk.b.d.b;
import com.cmic.sso.sdk.d.q;
import com.cmic.sso.sdk.d.s;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f69090a;

    /* renamed from: b  reason: collision with root package name */
    public String f69091b;

    public a() {
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

    public c a(c cVar, b bVar, com.cmic.sso.sdk.a aVar) {
        InterceptResult invokeLLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cVar, bVar, aVar)) == null) {
            Map<String, List<String>> b2 = bVar.b();
            if (TextUtils.isEmpty(this.f69090a) && (list = b2.get("pplocation")) != null && list.size() > 0) {
                this.f69090a = list.get(0);
            }
            s.b(aVar, String.valueOf(bVar.a()));
            List<String> list2 = b2.get("Location");
            if (list2 == null || list2.isEmpty()) {
                list2 = b2.get("Location".toLowerCase());
            }
            if (list2 != null && list2.size() > 0) {
                String str = list2.get(0);
                this.f69091b = str;
                if (!TextUtils.isEmpty(str)) {
                    String b3 = aVar.b("operatortype", "0");
                    if ("2".equals(b3)) {
                        s.a(aVar, "getUnicomMobile");
                    } else if ("3".equals(b3)) {
                        s.a(aVar, "getTelecomMobile");
                    } else {
                        s.a(aVar, "NONE");
                    }
                }
            }
            c a2 = a(this.f69091b, cVar.f(), "GET", new com.cmic.sso.sdk.b.b.c(cVar.k().a()));
            a2.a(cVar.h());
            return a2;
        }
        return (c) invokeLLL.objValue;
    }

    public c b(c cVar, b bVar, com.cmic.sso.sdk.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, bVar, aVar)) == null) {
            String b2 = aVar.b("operatortype", "0");
            if ("2".equals(b2)) {
                s.a(aVar, "getNewUnicomPhoneNumberNotify");
            } else if ("3".equals(b2)) {
                s.a(aVar, "getNewTelecomPhoneNumberNotify");
            } else {
                s.a(aVar, "NONE");
            }
            s.b(aVar, String.valueOf(bVar.a()));
            d dVar = new d(cVar.k().a(), "1.0", bVar.c());
            String e2 = q.e();
            dVar.c(aVar.b("userCapaid"));
            if (aVar.c("logintype") != 3) {
                dVar.b("authz");
            } else {
                dVar.b("pre");
            }
            c a2 = a(e2 + this.f69090a, cVar.f(), "POST", dVar);
            a2.a(cVar.h());
            this.f69090a = null;
            return a2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69090a : (String) invokeV.objValue;
    }
}
