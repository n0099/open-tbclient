package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class ad extends t {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public ab b(com.google.zxing.h hVar) {
        int indexOf;
        String c = c(hVar);
        if ((c.startsWith("urlto:") || c.startsWith("URLTO:")) && (indexOf = c.indexOf(58, 6)) >= 0) {
            return new ab(c.substring(indexOf + 1), indexOf > 6 ? c.substring(6, indexOf) : null);
        }
        return null;
    }
}
