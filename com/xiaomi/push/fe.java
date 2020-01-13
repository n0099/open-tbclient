package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.ee;
import com.xiaomi.push.service.al;
import java.util.HashMap;
/* loaded from: classes6.dex */
class fe {
    public static void a(al.b bVar, String str, fm fmVar) {
        String a;
        ee.c cVar = new ee.c();
        if (!TextUtils.isEmpty(bVar.c)) {
            cVar.a(bVar.c);
        }
        if (!TextUtils.isEmpty(bVar.e)) {
            cVar.d(bVar.e);
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            cVar.e(bVar.f);
        }
        cVar.b(bVar.f865a ? "1" : "0");
        if (TextUtils.isEmpty(bVar.d)) {
            cVar.c("XIAOMI-SASL");
        } else {
            cVar.c(bVar.d);
        }
        ff ffVar = new ff();
        ffVar.c(bVar.f866b);
        ffVar.a(Integer.parseInt(bVar.g));
        ffVar.b(bVar.f863a);
        ffVar.a("BIND", (String) null);
        ffVar.a(ffVar.e());
        com.xiaomi.channel.commonutils.logger.b.m42a("[Slim]: bind id=" + ffVar.e());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.c);
        hashMap.put("chid", bVar.g);
        hashMap.put("from", bVar.f866b);
        hashMap.put("id", ffVar.e());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f865a) {
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
            a = aw.a(bVar.d, null, hashMap, bVar.h);
        } else {
            if (bVar.d.equals("XIAOMI-SASL")) {
            }
            a = null;
        }
        cVar.f(a);
        ffVar.a(cVar.a(), (String) null);
        fmVar.b(ffVar);
    }

    public static void a(String str, String str2, fm fmVar) {
        ff ffVar = new ff();
        ffVar.c(str2);
        ffVar.a(Integer.parseInt(str));
        ffVar.a("UBND", (String) null);
        fmVar.b(ffVar);
    }
}
