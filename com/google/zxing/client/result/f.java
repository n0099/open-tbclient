package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class f extends a {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public ab b(com.google.zxing.h hVar) {
        String a2 = hVar.a();
        if (a2.startsWith("MEBKM:")) {
            String b = b("TITLE:", a2, true);
            String[] a3 = a("URL:", a2, true);
            if (a3 != null) {
                String str = a3[0];
                if (ac.a(str)) {
                    return new ab(str, b);
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
