package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.du;
import com.xiaomi.push.service.av;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class ez {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(av.b bVar, String str, fl flVar) {
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, bVar, str, flVar) == null) {
            du.c cVar = new du.c();
            if (!TextUtils.isEmpty(bVar.f71424c)) {
                cVar.a(bVar.f71424c);
            }
            if (!TextUtils.isEmpty(bVar.f71426e)) {
                cVar.d(bVar.f71426e);
            }
            if (!TextUtils.isEmpty(bVar.f71427f)) {
                cVar.e(bVar.f71427f);
            }
            cVar.b(bVar.f918a ? "1" : "0");
            if (TextUtils.isEmpty(bVar.f71425d)) {
                cVar.c("XIAOMI-SASL");
            } else {
                cVar.c(bVar.f71425d);
            }
            fa faVar = new fa();
            faVar.c(bVar.f919b);
            faVar.a(Integer.parseInt(bVar.f71428g));
            faVar.b(bVar.f916a);
            faVar.a("BIND", (String) null);
            faVar.a(faVar.e());
            com.xiaomi.channel.commonutils.logger.b.m73a("[Slim]: bind id=" + faVar.e());
            HashMap hashMap = new HashMap();
            hashMap.put("challenge", str);
            hashMap.put("token", bVar.f71424c);
            hashMap.put(IAdRequestParam.CHID, bVar.f71428g);
            hashMap.put("from", bVar.f919b);
            hashMap.put("id", faVar.e());
            hashMap.put("to", "xiaomi.com");
            if (bVar.f918a) {
                hashMap.put("kick", "1");
            } else {
                hashMap.put("kick", "0");
            }
            if (TextUtils.isEmpty(bVar.f71426e)) {
                hashMap.put("client_attrs", "");
            } else {
                hashMap.put("client_attrs", bVar.f71426e);
            }
            if (TextUtils.isEmpty(bVar.f71427f)) {
                hashMap.put("cloud_attrs", "");
            } else {
                hashMap.put("cloud_attrs", bVar.f71427f);
            }
            if (bVar.f71425d.equals("XIAOMI-PASS") || bVar.f71425d.equals("XMPUSH-PASS")) {
                a2 = bk.a(bVar.f71425d, null, hashMap, bVar.f71429h);
            } else {
                bVar.f71425d.equals("XIAOMI-SASL");
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
