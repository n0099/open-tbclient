package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class w extends t {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public v b(com.google.zxing.h hVar) {
        String str;
        String c = c(hVar);
        if (c.startsWith("smsto:") || c.startsWith("SMSTO:") || c.startsWith("mmsto:") || c.startsWith("MMSTO:")) {
            String substring = c.substring(6);
            int indexOf = substring.indexOf(58);
            if (indexOf >= 0) {
                str = substring.substring(indexOf + 1);
                substring = substring.substring(0, indexOf);
            } else {
                str = null;
            }
            return new v(substring, (String) null, (String) null, str);
        }
        return null;
    }
}
