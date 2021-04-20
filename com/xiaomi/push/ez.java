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
        if (!TextUtils.isEmpty(bVar.f41252c)) {
            cVar.a(bVar.f41252c);
        }
        if (!TextUtils.isEmpty(bVar.f41254e)) {
            cVar.d(bVar.f41254e);
        }
        if (!TextUtils.isEmpty(bVar.f41255f)) {
            cVar.e(bVar.f41255f);
        }
        cVar.b(bVar.f910a ? "1" : "0");
        if (TextUtils.isEmpty(bVar.f41253d)) {
            cVar.c("XIAOMI-SASL");
        } else {
            cVar.c(bVar.f41253d);
        }
        fa faVar = new fa();
        faVar.c(bVar.f911b);
        faVar.a(Integer.parseInt(bVar.f41256g));
        faVar.b(bVar.f908a);
        faVar.a("BIND", (String) null);
        faVar.a(faVar.e());
        com.xiaomi.channel.commonutils.logger.b.m55a("[Slim]: bind id=" + faVar.e());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.f41252c);
        hashMap.put(IAdRequestParam.CHID, bVar.f41256g);
        hashMap.put("from", bVar.f911b);
        hashMap.put("id", faVar.e());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f910a) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (TextUtils.isEmpty(bVar.f41254e)) {
            hashMap.put("client_attrs", "");
        } else {
            hashMap.put("client_attrs", bVar.f41254e);
        }
        if (TextUtils.isEmpty(bVar.f41255f)) {
            hashMap.put("cloud_attrs", "");
        } else {
            hashMap.put("cloud_attrs", bVar.f41255f);
        }
        if (bVar.f41253d.equals("XIAOMI-PASS") || bVar.f41253d.equals("XMPUSH-PASS")) {
            a2 = bk.a(bVar.f41253d, null, hashMap, bVar.f41257h);
        } else {
            bVar.f41253d.equals("XIAOMI-SASL");
            a2 = null;
        }
        cVar.f(a2);
        faVar.a(cVar.m266a(), (String) null);
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
