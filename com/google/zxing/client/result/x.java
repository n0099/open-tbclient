package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class x extends t {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public h b(com.google.zxing.h hVar) {
        String str;
        String str2 = null;
        String c = c(hVar);
        if (c.startsWith("smtp:") || c.startsWith("SMTP:")) {
            String substring = c.substring(5);
            int indexOf = substring.indexOf(58);
            if (indexOf >= 0) {
                str = substring.substring(indexOf + 1);
                substring = substring.substring(0, indexOf);
                int indexOf2 = str.indexOf(58);
                if (indexOf2 >= 0) {
                    str2 = str.substring(indexOf2 + 1);
                    str = str.substring(0, indexOf2);
                }
            } else {
                str = null;
            }
            return new h(substring, str, str2, "mailto:" + substring);
        }
        return null;
    }
}
