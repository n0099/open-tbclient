package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class ah extends t {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public ag b(com.google.zxing.h hVar) {
        String b;
        String c = c(hVar);
        if (!c.startsWith("WIFI:") || (b = b("S:", c, ';', false)) == null || b.length() == 0) {
            return null;
        }
        String b2 = b("P:", c, ';', false);
        String b3 = b("T:", c, ';', false);
        if (b3 == null) {
            b3 = "nopass";
        }
        return new ag(b3, b, b2, Boolean.parseBoolean(b("H:", c, ';', false)));
    }
}
