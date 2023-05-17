package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.http.Headers;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.g.d;
import com.huawei.hms.framework.network.grs.g.h;
import com.huawei.hms.framework.network.grs.h.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String f = "a";
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, Map<String, Map<String, String>>> a;
    public final Map<String, Long> b;
    public final c c;
    public final c d;
    public final h e;

    public a(c cVar, c cVar2, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, cVar2, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap(16);
        this.b = new ConcurrentHashMap(16);
        this.d = cVar2;
        this.c = cVar;
        this.e = hVar;
        hVar.a(this);
    }

    private void a(GrsBaseInfo grsBaseInfo, b bVar, Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, this, grsBaseInfo, bVar, context, str) == null) {
            Long l = this.b.get(grsBaseInfo.getGrsParasKey(true, true, context));
            if (e.a(l)) {
                bVar.a(2);
                return;
            }
            if (e.a(l, 300000L)) {
                this.e.a(new com.huawei.hms.framework.network.grs.g.k.c(grsBaseInfo, context), null, str, this.d);
            }
            bVar.a(1);
        }
    }

    private void a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, this, grsBaseInfo, str, context) == null) && e.a(this.b.get(str), 300000L)) {
            this.e.a(new com.huawei.hms.framework.network.grs.g.k.c(grsBaseInfo, context), null, null, this.d);
        }
    }

    public c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (c) invokeV.objValue;
    }

    public Map<String, String> a(GrsBaseInfo grsBaseInfo, String str, b bVar, Context context) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, grsBaseInfo, str, bVar, context)) == null) {
            Map<String, Map<String, String>> map = this.a.get(grsBaseInfo.getGrsParasKey(true, true, context));
            if (map == null || map.isEmpty()) {
                return new HashMap();
            }
            a(grsBaseInfo, bVar, context, str);
            return map.get(str);
        }
        return (Map) invokeLLLL.objValue;
    }

    public void a(GrsBaseInfo grsBaseInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, grsBaseInfo, context) == null) {
            String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
            c cVar = this.c;
            cVar.b(grsParasKey + "time", "0");
            Map<String, Long> map = this.b;
            map.remove(grsParasKey + "time");
            this.a.remove(grsParasKey);
            this.e.a(grsParasKey);
        }
    }

    public void a(GrsBaseInfo grsBaseInfo, d dVar, Context context, com.huawei.hms.framework.network.grs.g.k.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, grsBaseInfo, dVar, context, cVar) == null) {
            if (dVar.f() == 2) {
                Logger.w(f, "update cache from server failed");
            } else if (cVar.d().size() != 0) {
                this.c.b("geoipCountryCode", dVar.j());
                this.c.b("geoipCountryCodetime", dVar.a());
            } else {
                String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
                if (dVar.m()) {
                    this.a.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(this.c.a(grsParasKey, "")));
                } else {
                    this.c.b(grsParasKey, dVar.j());
                    this.a.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(dVar.j()));
                }
                if (!TextUtils.isEmpty(dVar.e())) {
                    c cVar2 = this.c;
                    cVar2.b(grsParasKey + Headers.ETAG, dVar.e());
                }
                c cVar3 = this.c;
                cVar3.b(grsParasKey + "time", dVar.a());
                this.b.put(grsParasKey, Long.valueOf(Long.parseLong(dVar.a())));
            }
        }
    }

    public h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (h) invokeV.objValue;
    }

    public void b(GrsBaseInfo grsBaseInfo, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, grsBaseInfo, context) == null) {
            String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
            String a = this.c.a(grsParasKey, "");
            c cVar = this.c;
            String a2 = cVar.a(grsParasKey + "time", "0");
            long j = 0;
            if (!TextUtils.isEmpty(a2) && a2.matches("\\d+")) {
                try {
                    j = Long.parseLong(a2);
                } catch (NumberFormatException e) {
                    Logger.w(f, "convert urlParamKey from String to Long catch NumberFormatException.", e);
                }
            }
            this.a.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(a));
            this.b.put(grsParasKey, Long.valueOf(j));
            a(grsBaseInfo, grsParasKey, context);
        }
    }

    public c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.d : (c) invokeV.objValue;
    }
}
