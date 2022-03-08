package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.du;
import com.xiaomi.push.service.av;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class ez {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(av.b bVar, String str, fl flVar) {
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, bVar, str, flVar) == null) {
            du.c cVar = new du.c();
            if (!TextUtils.isEmpty(bVar.f59981c)) {
                cVar.a(bVar.f59981c);
            }
            if (!TextUtils.isEmpty(bVar.f59983e)) {
                cVar.d(bVar.f59983e);
            }
            if (!TextUtils.isEmpty(bVar.f59984f)) {
                cVar.e(bVar.f59984f);
            }
            cVar.b(bVar.f918a ? "1" : "0");
            if (TextUtils.isEmpty(bVar.f59982d)) {
                cVar.c("XIAOMI-SASL");
            } else {
                cVar.c(bVar.f59982d);
            }
            fa faVar = new fa();
            faVar.c(bVar.f919b);
            faVar.a(Integer.parseInt(bVar.f59985g));
            faVar.b(bVar.f916a);
            faVar.a("BIND", (String) null);
            faVar.a(faVar.e());
            com.xiaomi.channel.commonutils.logger.b.m133a("[Slim]: bind id=" + faVar.e());
            HashMap hashMap = new HashMap();
            hashMap.put("challenge", str);
            hashMap.put("token", bVar.f59981c);
            hashMap.put("chid", bVar.f59985g);
            hashMap.put("from", bVar.f919b);
            hashMap.put("id", faVar.e());
            hashMap.put("to", "xiaomi.com");
            if (bVar.f918a) {
                hashMap.put("kick", "1");
            } else {
                hashMap.put("kick", "0");
            }
            if (TextUtils.isEmpty(bVar.f59983e)) {
                hashMap.put("client_attrs", "");
            } else {
                hashMap.put("client_attrs", bVar.f59983e);
            }
            if (TextUtils.isEmpty(bVar.f59984f)) {
                hashMap.put("cloud_attrs", "");
            } else {
                hashMap.put("cloud_attrs", bVar.f59984f);
            }
            if (bVar.f59982d.equals("XIAOMI-PASS") || bVar.f59982d.equals("XMPUSH-PASS")) {
                a = bk.a(bVar.f59982d, null, hashMap, bVar.f59986h);
            } else {
                bVar.f59982d.equals("XIAOMI-SASL");
                a = null;
            }
            cVar.f(a);
            faVar.a(cVar.m344a(), (String) null);
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
