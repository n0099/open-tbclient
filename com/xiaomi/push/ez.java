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
            if (!TextUtils.isEmpty(bVar.f78451c)) {
                cVar.a(bVar.f78451c);
            }
            if (!TextUtils.isEmpty(bVar.f78453e)) {
                cVar.d(bVar.f78453e);
            }
            if (!TextUtils.isEmpty(bVar.f78454f)) {
                cVar.e(bVar.f78454f);
            }
            cVar.b(bVar.f917a ? "1" : "0");
            if (TextUtils.isEmpty(bVar.f78452d)) {
                cVar.c("XIAOMI-SASL");
            } else {
                cVar.c(bVar.f78452d);
            }
            fa faVar = new fa();
            faVar.c(bVar.f918b);
            faVar.a(Integer.parseInt(bVar.f78455g));
            faVar.b(bVar.f915a);
            faVar.a("BIND", (String) null);
            faVar.a(faVar.e());
            com.xiaomi.channel.commonutils.logger.b.m73a("[Slim]: bind id=" + faVar.e());
            HashMap hashMap = new HashMap();
            hashMap.put("challenge", str);
            hashMap.put("token", bVar.f78451c);
            hashMap.put(IAdRequestParam.CHID, bVar.f78455g);
            hashMap.put("from", bVar.f918b);
            hashMap.put("id", faVar.e());
            hashMap.put("to", "xiaomi.com");
            if (bVar.f917a) {
                hashMap.put("kick", "1");
            } else {
                hashMap.put("kick", "0");
            }
            if (TextUtils.isEmpty(bVar.f78453e)) {
                hashMap.put("client_attrs", "");
            } else {
                hashMap.put("client_attrs", bVar.f78453e);
            }
            if (TextUtils.isEmpty(bVar.f78454f)) {
                hashMap.put("cloud_attrs", "");
            } else {
                hashMap.put("cloud_attrs", bVar.f78454f);
            }
            if (bVar.f78452d.equals("XIAOMI-PASS") || bVar.f78452d.equals("XMPUSH-PASS")) {
                a2 = bk.a(bVar.f78452d, null, hashMap, bVar.f78456h);
            } else {
                bVar.f78452d.equals("XIAOMI-SASL");
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
