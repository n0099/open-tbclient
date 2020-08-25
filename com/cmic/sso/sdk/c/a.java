package com.cmic.sso.sdk.c;

import android.text.TextUtils;
import com.baidubce.http.Headers;
import com.cmic.sso.sdk.c.b.d;
import com.cmic.sso.sdk.c.b.g;
import com.cmic.sso.sdk.c.c.c;
import com.cmic.sso.sdk.c.d.b;
import com.cmic.sso.sdk.e.s;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class a {
    private String a;
    private String b;

    public c a(c cVar, b bVar, com.cmic.sso.sdk.a aVar) {
        List<String> list;
        Map<String, List<String>> b = bVar.b();
        if (TextUtils.isEmpty(this.a) && (list = b.get("pplocation")) != null && list.size() > 0) {
            this.a = list.get(0);
        }
        s.b(aVar, String.valueOf(bVar.a()));
        List<String> list2 = b.get(Headers.LOCATION);
        if (list2 == null || list2.isEmpty()) {
            list2 = b.get(Headers.LOCATION.toLowerCase());
        }
        if (list2 != null && list2.size() > 0) {
            this.b = list2.get(0);
            if (!TextUtils.isEmpty(this.b)) {
                String b2 = aVar.b("operatortype", "0");
                if ("2".equals(b2)) {
                    s.a(aVar, "getUnicomMobile");
                } else if ("3".equals(b2)) {
                    s.a(aVar, "getTelecomMobile");
                } else {
                    s.a(aVar, "NONE");
                }
            }
        }
        c a = a(this.b, cVar.f(), "GET", new com.cmic.sso.sdk.c.b.c(cVar.dNl().a()));
        a.f(cVar.dNk());
        return a;
    }

    public c b(c cVar, b bVar, com.cmic.sso.sdk.a aVar) {
        String b = aVar.b("operatortype", "0");
        if ("2".equals(b)) {
            s.a(aVar, "getNewUnicomPhoneNumberNotify");
        } else if ("3".equals(b)) {
            s.a(aVar, "getNewTelecomPhoneNumberNotify");
        } else {
            s.a(aVar, "NONE");
        }
        s.b(aVar, String.valueOf(bVar.a()));
        c a = a("http://www.cmpassport.com/unisdk" + this.a, cVar.f(), "POST", new d(cVar.dNl().a(), "1.0", bVar.c()));
        a.f(cVar.dNk());
        this.a = null;
        return a;
    }

    private c a(String str, String str2, String str3, g gVar) {
        c cVar = new c(str, gVar, str3, str2);
        if (str3.equals("GET")) {
            cVar.a("Content-Type", "application/x-www-form-urlencoded");
        }
        return cVar;
    }

    public String a() {
        return this.a;
    }
}
