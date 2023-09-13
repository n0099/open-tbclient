package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.dw;
import com.xiaomi.push.service.bg;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class fj {
    public static void a(bg.b bVar, String str, fv fvVar) {
        String a;
        dw.c cVar = new dw.c();
        if (!TextUtils.isEmpty(bVar.c)) {
            cVar.a(bVar.c);
        }
        if (!TextUtils.isEmpty(bVar.e)) {
            cVar.d(bVar.e);
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            cVar.e(bVar.f);
        }
        cVar.b(bVar.f937a ? "1" : "0");
        if (TextUtils.isEmpty(bVar.d)) {
            cVar.c("XIAOMI-SASL");
        } else {
            cVar.c(bVar.d);
        }
        fk fkVar = new fk();
        fkVar.c(bVar.f938b);
        fkVar.a(Integer.parseInt(bVar.g));
        fkVar.b(bVar.f935a);
        fkVar.a("BIND", (String) null);
        fkVar.a(fkVar.e());
        com.xiaomi.channel.commonutils.logger.b.m181a("[Slim]: bind id=" + fkVar.e());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.c);
        hashMap.put("chid", bVar.g);
        hashMap.put("from", bVar.f938b);
        hashMap.put("id", fkVar.e());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f937a) {
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
            a = bm.a(bVar.d, null, hashMap, bVar.h);
        } else {
            bVar.d.equals("XIAOMI-SASL");
            a = null;
        }
        cVar.f(a);
        fkVar.a(cVar.m447a(), (String) null);
        fvVar.b(fkVar);
    }

    public static void a(String str, String str2, fv fvVar) {
        fk fkVar = new fk();
        fkVar.c(str2);
        fkVar.a(Integer.parseInt(str));
        fkVar.a("UBND", (String) null);
        fvVar.b(fkVar);
    }
}
