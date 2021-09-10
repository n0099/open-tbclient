package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.du;
import com.xiaomi.push.service.av;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class ez {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(av.b bVar, String str, fl flVar) {
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, bVar, str, flVar) == null) {
            du.c cVar = new du.c();
            if (!TextUtils.isEmpty(bVar.f78132c)) {
                cVar.a(bVar.f78132c);
            }
            if (!TextUtils.isEmpty(bVar.f78134e)) {
                cVar.d(bVar.f78134e);
            }
            if (!TextUtils.isEmpty(bVar.f78135f)) {
                cVar.e(bVar.f78135f);
            }
            cVar.b(bVar.f917a ? "1" : "0");
            if (TextUtils.isEmpty(bVar.f78133d)) {
                cVar.c("XIAOMI-SASL");
            } else {
                cVar.c(bVar.f78133d);
            }
            fa faVar = new fa();
            faVar.c(bVar.f918b);
            faVar.a(Integer.parseInt(bVar.f78136g));
            faVar.b(bVar.f915a);
            faVar.a("BIND", (String) null);
            faVar.a(faVar.e());
            com.xiaomi.channel.commonutils.logger.b.m73a("[Slim]: bind id=" + faVar.e());
            HashMap hashMap = new HashMap();
            hashMap.put("challenge", str);
            hashMap.put("token", bVar.f78132c);
            hashMap.put(IAdRequestParam.CHID, bVar.f78136g);
            hashMap.put("from", bVar.f918b);
            hashMap.put("id", faVar.e());
            hashMap.put("to", "xiaomi.com");
            if (bVar.f917a) {
                hashMap.put("kick", "1");
            } else {
                hashMap.put("kick", "0");
            }
            if (TextUtils.isEmpty(bVar.f78134e)) {
                hashMap.put("client_attrs", "");
            } else {
                hashMap.put("client_attrs", bVar.f78134e);
            }
            if (TextUtils.isEmpty(bVar.f78135f)) {
                hashMap.put("cloud_attrs", "");
            } else {
                hashMap.put("cloud_attrs", bVar.f78135f);
            }
            if (bVar.f78133d.equals("XIAOMI-PASS") || bVar.f78133d.equals("XMPUSH-PASS")) {
                a2 = bk.a(bVar.f78133d, null, hashMap, bVar.f78137h);
            } else {
                bVar.f78133d.equals("XIAOMI-SASL");
                a2 = null;
            }
            cVar.f(a2);
            faVar.a(cVar.m284a(), (String) null);
            flVar.b(faVar);
        }
    }

    public static void a(String str, String str2, fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, flVar) == null) {
            fa faVar = new fa();
            faVar.c(str2);
            faVar.a(Integer.parseInt(str));
            faVar.a("UBND", (String) null);
            flVar.b(faVar);
        }
    }
}
