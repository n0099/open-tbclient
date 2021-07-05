package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
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
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, bVar, str, flVar) == null) {
            du.c cVar = new du.c();
            if (!TextUtils.isEmpty(bVar.f43590c)) {
                cVar.a(bVar.f43590c);
            }
            if (!TextUtils.isEmpty(bVar.f43592e)) {
                cVar.d(bVar.f43592e);
            }
            if (!TextUtils.isEmpty(bVar.f43593f)) {
                cVar.e(bVar.f43593f);
            }
            cVar.b(bVar.f913a ? "1" : "0");
            if (TextUtils.isEmpty(bVar.f43591d)) {
                cVar.c("XIAOMI-SASL");
            } else {
                cVar.c(bVar.f43591d);
            }
            fa faVar = new fa();
            faVar.c(bVar.f914b);
            faVar.a(Integer.parseInt(bVar.f43594g));
            faVar.b(bVar.f911a);
            faVar.a("BIND", (String) null);
            faVar.a(faVar.e());
            com.xiaomi.channel.commonutils.logger.b.m70a("[Slim]: bind id=" + faVar.e());
            HashMap hashMap = new HashMap();
            hashMap.put("challenge", str);
            hashMap.put("token", bVar.f43590c);
            hashMap.put(IAdRequestParam.CHID, bVar.f43594g);
            hashMap.put("from", bVar.f914b);
            hashMap.put("id", faVar.e());
            hashMap.put("to", "xiaomi.com");
            if (bVar.f913a) {
                hashMap.put("kick", "1");
            } else {
                hashMap.put("kick", "0");
            }
            if (TextUtils.isEmpty(bVar.f43592e)) {
                hashMap.put("client_attrs", "");
            } else {
                hashMap.put("client_attrs", bVar.f43592e);
            }
            if (TextUtils.isEmpty(bVar.f43593f)) {
                hashMap.put("cloud_attrs", "");
            } else {
                hashMap.put("cloud_attrs", bVar.f43593f);
            }
            if (bVar.f43591d.equals("XIAOMI-PASS") || bVar.f43591d.equals("XMPUSH-PASS")) {
                a2 = bk.a(bVar.f43591d, null, hashMap, bVar.f43595h);
            } else {
                bVar.f43591d.equals("XIAOMI-SASL");
                a2 = null;
            }
            cVar.f(a2);
            faVar.a(cVar.m281a(), (String) null);
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
