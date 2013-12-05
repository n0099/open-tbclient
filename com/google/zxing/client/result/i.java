package com.google.zxing.client.result;

import java.util.Map;
/* loaded from: classes.dex */
public final class i extends t {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public h b(com.google.zxing.h hVar) {
        String str;
        String str2;
        String str3 = null;
        String c = c(hVar);
        if (c.startsWith("mailto:") || c.startsWith("MAILTO:")) {
            String substring = c.substring(7);
            int indexOf = substring.indexOf(63);
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            String e = e(substring);
            Map<String, String> d = d(c);
            if (d != null) {
                str = e.length() == 0 ? d.get("to") : e;
                str2 = d.get("subject");
                str3 = d.get("body");
            } else {
                str = e;
                str2 = null;
            }
            return new h(str, str2, str3, c);
        } else if (j.a(c)) {
            return new h(c, null, null, "mailto:" + c);
        } else {
            return null;
        }
    }
}
