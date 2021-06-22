package com.cmic.sso.sdk.b;

import android.text.TextUtils;
import android.util.Log;
import com.cmic.sso.sdk.b.b.d;
import com.cmic.sso.sdk.b.b.g;
import com.cmic.sso.sdk.b.c.c;
import com.cmic.sso.sdk.b.d.b;
import com.cmic.sso.sdk.d.q;
import com.cmic.sso.sdk.d.s;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f30652a;

    /* renamed from: b  reason: collision with root package name */
    public String f30653b;

    public c a(c cVar, b bVar, com.cmic.sso.sdk.a aVar) {
        List<String> list;
        Map<String, List<String>> b2 = bVar.b();
        if (TextUtils.isEmpty(this.f30652a) && (list = b2.get("pplocation")) != null && list.size() > 0) {
            this.f30652a = list.get(0);
        }
        s.b(aVar, String.valueOf(bVar.a()));
        List<String> list2 = b2.get("Location");
        if (list2 == null || list2.isEmpty()) {
            list2 = b2.get("Location".toLowerCase());
        }
        if (list2 != null && list2.size() > 0) {
            String str = list2.get(0);
            this.f30653b = str;
            if (!TextUtils.isEmpty(str)) {
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
        Log.d("Location", this.f30653b);
        c a2 = a(this.f30653b, cVar.f(), "GET", new com.cmic.sso.sdk.b.b.c(cVar.k().a()));
        a2.a(cVar.h());
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
        d dVar = new d(cVar.k().a(), "1.0", bVar.c());
        String e2 = q.e();
        dVar.c(aVar.b("userCapaid"));
        if (aVar.c("logintype") != 3) {
            dVar.b("authz");
        } else {
            dVar.b("pre");
        }
        c a2 = a(e2 + this.f30652a, cVar.f(), "POST", dVar);
        a2.a(cVar.h());
        this.f30652a = null;
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
        return this.f30652a;
    }
}
