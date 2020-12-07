package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.ek;
import com.xiaomi.push.service.ap;
import java.util.HashMap;
/* loaded from: classes18.dex */
class fk {
    public static void a(ap.b bVar, String str, fs fsVar) {
        String a2;
        ek.c cVar = new ek.c();
        if (!TextUtils.isEmpty(bVar.c)) {
            cVar.a(bVar.c);
        }
        if (!TextUtils.isEmpty(bVar.e)) {
            cVar.d(bVar.e);
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            cVar.e(bVar.f);
        }
        cVar.b(bVar.f862a ? "1" : "0");
        if (TextUtils.isEmpty(bVar.d)) {
            cVar.c("XIAOMI-SASL");
        } else {
            cVar.c(bVar.d);
        }
        fl flVar = new fl();
        flVar.c(bVar.f863b);
        flVar.a(Integer.parseInt(bVar.g));
        flVar.b(bVar.f860a);
        flVar.a("BIND", (String) null);
        flVar.a(flVar.e());
        com.xiaomi.channel.commonutils.logger.b.m47a("[Slim]: bind id=" + flVar.e());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.c);
        hashMap.put("chid", bVar.g);
        hashMap.put("from", bVar.f863b);
        hashMap.put("id", flVar.e());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f862a) {
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
            a2 = bd.a(bVar.d, null, hashMap, bVar.h);
        } else {
            if (bVar.d.equals("XIAOMI-SASL")) {
            }
            a2 = null;
        }
        cVar.f(a2);
        flVar.a(cVar.a(), (String) null);
        fsVar.b(flVar);
    }

    public static void a(String str, String str2, fs fsVar) {
        fl flVar = new fl();
        flVar.c(str2);
        flVar.a(Integer.parseInt(str));
        flVar.a("UBND", (String) null);
        fsVar.b(flVar);
    }
}
