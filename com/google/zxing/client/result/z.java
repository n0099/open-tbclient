package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class z extends t {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public y b(com.google.zxing.h hVar) {
        String c = c(hVar);
        if (c.startsWith("tel:") || c.startsWith("TEL:")) {
            String str = c.startsWith("TEL:") ? "tel:" + c.substring(4) : c;
            int indexOf = c.indexOf(63, 4);
            return new y(indexOf < 0 ? c.substring(4) : c.substring(4, indexOf), str, null);
        }
        return null;
    }
}
