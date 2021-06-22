package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.xiaomi.push.du;
import com.xiaomi.push.service.av;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class ez {
    public static void a(av.b bVar, String str, fl flVar) {
        String a2;
        du.c cVar = new du.c();
        if (!TextUtils.isEmpty(bVar.f41847c)) {
            cVar.a(bVar.f41847c);
        }
        if (!TextUtils.isEmpty(bVar.f41849e)) {
            cVar.d(bVar.f41849e);
        }
        if (!TextUtils.isEmpty(bVar.f41850f)) {
            cVar.e(bVar.f41850f);
        }
        cVar.b(bVar.f910a ? "1" : "0");
        if (TextUtils.isEmpty(bVar.f41848d)) {
            cVar.c("XIAOMI-SASL");
        } else {
            cVar.c(bVar.f41848d);
        }
        fa faVar = new fa();
        faVar.c(bVar.f911b);
        faVar.a(Integer.parseInt(bVar.f41851g));
        faVar.b(bVar.f908a);
        faVar.a("BIND", (String) null);
        faVar.a(faVar.e());
        com.xiaomi.channel.commonutils.logger.b.m56a("[Slim]: bind id=" + faVar.e());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.f41847c);
        hashMap.put(IAdRequestParam.CHID, bVar.f41851g);
        hashMap.put("from", bVar.f911b);
        hashMap.put("id", faVar.e());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f910a) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (TextUtils.isEmpty(bVar.f41849e)) {
            hashMap.put("client_attrs", "");
        } else {
            hashMap.put("client_attrs", bVar.f41849e);
        }
        if (TextUtils.isEmpty(bVar.f41850f)) {
            hashMap.put("cloud_attrs", "");
        } else {
            hashMap.put("cloud_attrs", bVar.f41850f);
        }
        if (bVar.f41848d.equals("XIAOMI-PASS") || bVar.f41848d.equals("XMPUSH-PASS")) {
            a2 = bk.a(bVar.f41848d, null, hashMap, bVar.f41852h);
        } else {
            bVar.f41848d.equals("XIAOMI-SASL");
            a2 = null;
        }
        cVar.f(a2);
        faVar.a(cVar.m267a(), (String) null);
        flVar.b(faVar);
    }

    public static void a(String str, String str2, fl flVar) {
        fa faVar = new fa();
        faVar.c(str2);
        faVar.a(Integer.parseInt(str));
        faVar.a("UBND", (String) null);
        flVar.b(faVar);
    }
}
