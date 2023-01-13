package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.push.dx;
import com.xiaomi.push.service.bg;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class fk {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(bg.b bVar, String str, fw fwVar) {
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, bVar, str, fwVar) == null) {
            dx.c cVar = new dx.c();
            if (!TextUtils.isEmpty(bVar.c)) {
                cVar.a(bVar.c);
            }
            if (!TextUtils.isEmpty(bVar.e)) {
                cVar.d(bVar.e);
            }
            if (!TextUtils.isEmpty(bVar.f)) {
                cVar.e(bVar.f);
            }
            cVar.b(bVar.f959a ? "1" : "0");
            if (TextUtils.isEmpty(bVar.d)) {
                cVar.c("XIAOMI-SASL");
            } else {
                cVar.c(bVar.d);
            }
            fl flVar = new fl();
            flVar.c(bVar.f960b);
            flVar.a(Integer.parseInt(bVar.g));
            flVar.b(bVar.f957a);
            flVar.a("BIND", (String) null);
            flVar.a(flVar.e());
            com.xiaomi.channel.commonutils.logger.b.m103a("[Slim]: bind id=" + flVar.e());
            HashMap hashMap = new HashMap();
            hashMap.put("challenge", str);
            hashMap.put("token", bVar.c);
            hashMap.put("chid", bVar.g);
            hashMap.put("from", bVar.f960b);
            hashMap.put("id", flVar.e());
            hashMap.put("to", "xiaomi.com");
            if (bVar.f959a) {
                hashMap.put("kick", "1");
            } else {
                hashMap.put("kick", "0");
            }
            if (TextUtils.isEmpty(bVar.e)) {
                hashMap.put("client_attrs", "");
            } else {
                hashMap.put("client_attrs", bVar.e);
            }
            if (TextUtils.isEmpty(bVar.f)) {
                hashMap.put("cloud_attrs", "");
            } else {
                hashMap.put("cloud_attrs", bVar.f);
            }
            if (bVar.d.equals("XIAOMI-PASS") || bVar.d.equals("XMPUSH-PASS")) {
                a = bn.a(bVar.d, null, hashMap, bVar.h);
            } else {
                bVar.d.equals("XIAOMI-SASL");
                a = null;
            }
            cVar.f(a);
            flVar.a(cVar.m368a(), (String) null);
            fwVar.b(flVar);
        }
    }

    public static void a(String str, String str2, fw fwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, fwVar) == null) {
            fl flVar = new fl();
            flVar.c(str2);
            flVar.a(Integer.parseInt(str));
            flVar.a("UBND", (String) null);
            fwVar.b(flVar);
        }
    }
}
