package com.cmic.sso.sdk.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.c.b.d;
import com.cmic.sso.sdk.c.b.g;
import com.cmic.sso.sdk.e.q;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;

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

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    private com.cmic.sso.sdk.c.c.c a(String str, String str2, String str3, g gVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, this, str, str2, str3, gVar)) == null) {
            com.cmic.sso.sdk.c.c.c cVar = new com.cmic.sso.sdk.c.c.c(str, gVar, str3, str2);
            if (str3.equals("GET")) {
                cVar.a("Content-Type", "application/x-www-form-urlencoded");
            }
            return cVar;
        }
        return (com.cmic.sso.sdk.c.c.c) invokeLLLL.objValue;
    }

    public com.cmic.sso.sdk.c.c.c a(com.cmic.sso.sdk.c.c.c cVar, com.cmic.sso.sdk.c.d.b bVar, com.cmic.sso.sdk.a aVar) {
        InterceptResult invokeLLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, cVar, bVar, aVar)) == null) {
            Map<String, List<String>> b = bVar.b();
            if (TextUtils.isEmpty(this.a) && (list = b.get("pplocation")) != null && list.size() > 0) {
                this.a = list.get(0);
            }
            q.b(aVar, String.valueOf(bVar.a()));
            List<String> list2 = b.get("Location");
            if (list2 == null || list2.isEmpty()) {
                list2 = b.get("Location".toLowerCase());
            }
            if (list2 != null && list2.size() > 0) {
                String str = list2.get(0);
                this.b = str;
                if (!TextUtils.isEmpty(str)) {
                    String b2 = aVar.b("operatortype", "0");
                    if ("2".equals(b2)) {
                        q.a(aVar, "getUnicomMobile");
                    } else if ("3".equals(b2)) {
                        q.a(aVar, "getTelecomMobile");
                    } else {
                        q.a(aVar, HlsPlaylistParser.METHOD_NONE);
                    }
                }
            }
            com.cmic.sso.sdk.e.c.b("Location", this.b);
            com.cmic.sso.sdk.c.c.c a = a(this.b, cVar.f(), "GET", new com.cmic.sso.sdk.c.b.c(cVar.k().a()));
            a.a(cVar.h());
            return a;
        }
        return (com.cmic.sso.sdk.c.c.c) invokeLLL.objValue;
    }

    public com.cmic.sso.sdk.c.c.c b(com.cmic.sso.sdk.c.c.c cVar, com.cmic.sso.sdk.c.d.b bVar, com.cmic.sso.sdk.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cVar, bVar, aVar)) == null) {
            String b = aVar.b("operatortype", "0");
            if ("2".equals(b)) {
                q.a(aVar, "getNewUnicomPhoneNumberNotify");
            } else if ("3".equals(b)) {
                q.a(aVar, "getNewTelecomPhoneNumberNotify");
            } else {
                q.a(aVar, HlsPlaylistParser.METHOD_NONE);
            }
            q.b(aVar, String.valueOf(bVar.a()));
            d dVar = new d(cVar.k().a(), "1.0", bVar.c());
            dVar.c(aVar.b("userCapaid"));
            if (aVar.c("logintype") != 3) {
                if (aVar.b("isRisk", false)) {
                    dVar.b("pre");
                } else {
                    dVar.b("authz");
                }
            } else {
                dVar.b("pre");
            }
            com.cmic.sso.sdk.c.c.c a = a(this.a, cVar.f(), "POST", dVar);
            a.a(cVar.h());
            this.a = null;
            return a;
        }
        return (com.cmic.sso.sdk.c.c.c) invokeLLL.objValue;
    }
}
