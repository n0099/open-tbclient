package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.du;
import com.xiaomi.push.service.av;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class ez {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(av.b bVar, String str, fl flVar) {
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, bVar, str, flVar) == null) {
            du.c cVar = new du.c();
            if (!TextUtils.isEmpty(bVar.f61464c)) {
                cVar.a(bVar.f61464c);
            }
            if (!TextUtils.isEmpty(bVar.f61466e)) {
                cVar.d(bVar.f61466e);
            }
            if (!TextUtils.isEmpty(bVar.f61467f)) {
                cVar.e(bVar.f61467f);
            }
            cVar.b(bVar.f918a ? "1" : "0");
            if (TextUtils.isEmpty(bVar.f61465d)) {
                cVar.c("XIAOMI-SASL");
            } else {
                cVar.c(bVar.f61465d);
            }
            fa faVar = new fa();
            faVar.c(bVar.f919b);
            faVar.a(Integer.parseInt(bVar.f61468g));
            faVar.b(bVar.f916a);
            faVar.a("BIND", (String) null);
            faVar.a(faVar.e());
            com.xiaomi.channel.commonutils.logger.b.m134a("[Slim]: bind id=" + faVar.e());
            HashMap hashMap = new HashMap();
            hashMap.put("challenge", str);
            hashMap.put("token", bVar.f61464c);
            hashMap.put("chid", bVar.f61468g);
            hashMap.put("from", bVar.f919b);
            hashMap.put("id", faVar.e());
            hashMap.put("to", "xiaomi.com");
            if (bVar.f918a) {
                hashMap.put("kick", "1");
            } else {
                hashMap.put("kick", "0");
            }
            if (TextUtils.isEmpty(bVar.f61466e)) {
                hashMap.put("client_attrs", "");
            } else {
                hashMap.put("client_attrs", bVar.f61466e);
            }
            if (TextUtils.isEmpty(bVar.f61467f)) {
                hashMap.put("cloud_attrs", "");
            } else {
                hashMap.put("cloud_attrs", bVar.f61467f);
            }
            if (bVar.f61465d.equals("XIAOMI-PASS") || bVar.f61465d.equals("XMPUSH-PASS")) {
                a = bk.a(bVar.f61465d, null, hashMap, bVar.f61469h);
            } else {
                bVar.f61465d.equals("XIAOMI-SASL");
                a = null;
            }
            cVar.f(a);
            faVar.a(cVar.m345a(), (String) null);
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
