package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.du;
import com.xiaomi.push.service.av;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class ez {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(av.b bVar, String str, fl flVar) {
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, bVar, str, flVar) == null) {
            du.c cVar = new du.c();
            if (!TextUtils.isEmpty(bVar.f44547c)) {
                cVar.a(bVar.f44547c);
            }
            if (!TextUtils.isEmpty(bVar.f44549e)) {
                cVar.d(bVar.f44549e);
            }
            if (!TextUtils.isEmpty(bVar.f44550f)) {
                cVar.e(bVar.f44550f);
            }
            cVar.b(bVar.f894a ? "1" : "0");
            if (TextUtils.isEmpty(bVar.f44548d)) {
                cVar.c("XIAOMI-SASL");
            } else {
                cVar.c(bVar.f44548d);
            }
            fa faVar = new fa();
            faVar.c(bVar.f895b);
            faVar.a(Integer.parseInt(bVar.f44551g));
            faVar.b(bVar.f892a);
            faVar.a("BIND", (String) null);
            faVar.a(faVar.e());
            com.xiaomi.channel.commonutils.logger.b.m112a("[Slim]: bind id=" + faVar.e());
            HashMap hashMap = new HashMap();
            hashMap.put("challenge", str);
            hashMap.put("token", bVar.f44547c);
            hashMap.put("chid", bVar.f44551g);
            hashMap.put("from", bVar.f895b);
            hashMap.put("id", faVar.e());
            hashMap.put("to", "xiaomi.com");
            if (bVar.f894a) {
                hashMap.put("kick", "1");
            } else {
                hashMap.put("kick", "0");
            }
            if (TextUtils.isEmpty(bVar.f44549e)) {
                hashMap.put("client_attrs", "");
            } else {
                hashMap.put("client_attrs", bVar.f44549e);
            }
            if (TextUtils.isEmpty(bVar.f44550f)) {
                hashMap.put("cloud_attrs", "");
            } else {
                hashMap.put("cloud_attrs", bVar.f44550f);
            }
            if (bVar.f44548d.equals("XIAOMI-PASS") || bVar.f44548d.equals("XMPUSH-PASS")) {
                a = bk.a(bVar.f44548d, null, hashMap, bVar.f44552h);
            } else {
                bVar.f44548d.equals("XIAOMI-SASL");
                a = null;
            }
            cVar.f(a);
            faVar.a(cVar.m323a(), (String) null);
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
