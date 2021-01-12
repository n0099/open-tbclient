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
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f7696a;

    /* renamed from: b  reason: collision with root package name */
    private String f7697b;

    public c a(c cVar, b bVar, com.cmic.sso.sdk.a aVar) {
        List<String> list;
        Map<String, List<String>> b2 = bVar.b();
        if (TextUtils.isEmpty(this.f7696a) && (list = b2.get("pplocation")) != null && list.size() > 0) {
            this.f7696a = list.get(0);
        }
        s.b(aVar, String.valueOf(bVar.a()));
        List<String> list2 = b2.get(Headers.LOCATION);
        if (list2 == null || list2.isEmpty()) {
            list2 = b2.get(Headers.LOCATION.toLowerCase());
        }
        if (list2 != null && list2.size() > 0) {
            this.f7697b = list2.get(0);
            if (!TextUtils.isEmpty(this.f7697b)) {
                String b3 = aVar.b("operatortype", "0");
                if ("2".equals(b3)) {
                    s.a(aVar, "getUnicomMobile");
                } else if ("3".equals(b3)) {
                    s.a(aVar, "getTelecomMobile");
                } else {
                    s.a(aVar, "NONE");
                }
            }
        }
        c a2 = a(this.f7697b, cVar.f(), "GET", new com.cmic.sso.sdk.c.b.c(cVar.eoY().a()));
        a2.d(cVar.eoX());
        return a2;
    }

    public c b(c cVar, b bVar, com.cmic.sso.sdk.a aVar) {
        String b2 = aVar.b("operatortype", "0");
        if ("2".equals(b2)) {
            s.a(aVar, "getNewUnicomPhoneNumberNotify");
        } else if ("3".equals(b2)) {
            s.a(aVar, "getNewTelecomPhoneNumberNotify");
        } else {
            s.a(aVar, "NONE");
        }
        s.b(aVar, String.valueOf(bVar.a()));
        c a2 = a("http://www.cmpassport.com/unisdk" + this.f7696a, cVar.f(), "POST", new d(cVar.eoY().a(), "1.0", bVar.c()));
        a2.d(cVar.eoX());
        this.f7696a = null;
        return a2;
    }

    private c a(String str, String str2, String str3, g gVar) {
        c cVar = new c(str, gVar, str3, str2);
        if (str3.equals("GET")) {
            cVar.a("Content-Type", "application/x-www-form-urlencoded");
        }
        return cVar;
    }

    public String a() {
        return this.f7696a;
    }
}
